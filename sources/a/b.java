package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MeasurementEvent */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    Context f19a;

    /* renamed from: b  reason: collision with root package name */
    String f20b;

    /* renamed from: c  reason: collision with root package name */
    Bundle f21c;

    b(Context context, String str, Bundle bundle) {
        this.f19a = context.getApplicationContext();
        this.f20b = str;
        this.f21c = bundle;
    }

    static Bundle a(Context context, String str, Bundle bundle, Intent intent) {
        Bundle bundle2 = new Bundle();
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity != null) {
            bundle2.putString("class", resolveActivity.getShortClassName());
        }
        if ("al_nav_out".equals(str)) {
            if (resolveActivity != null) {
                bundle2.putString("package", resolveActivity.getPackageName());
            }
            if (intent.getData() != null) {
                bundle2.putString("outputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("outputURLScheme", intent.getScheme());
            }
        } else if ("al_nav_in".equals(str)) {
            if (intent.getData() != null) {
                bundle2.putString("inputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("inputURLScheme", intent.getScheme());
            }
        }
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                for (String str3 : ((Bundle) obj).keySet()) {
                    String a2 = a(((Bundle) obj).get(str3));
                    if (str2.equals("referer_app_link")) {
                        if (str3.equalsIgnoreCase("url")) {
                            bundle2.putString("refererURL", a2);
                        } else if (str3.equalsIgnoreCase("app_name")) {
                            bundle2.putString("refererAppName", a2);
                        } else if (str3.equalsIgnoreCase("package")) {
                            bundle2.putString("sourceApplication", a2);
                        }
                    }
                    bundle2.putString(str2 + "/" + str3, a2);
                }
            } else {
                String a3 = a(obj);
                if (str2.equals("target_url")) {
                    Uri parse = Uri.parse(a3);
                    bundle2.putString("targetURL", parse.toString());
                    bundle2.putString("targetURLHost", parse.getHost());
                } else {
                    bundle2.putString(str2, a3);
                }
            }
        }
        return bundle2;
    }

    static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj.toString();
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj).toString();
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj).toString();
            }
            return obj.toString();
        } catch (Exception e2) {
            return null;
        }
    }
}
