package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.appsflyer.share.Constants;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MeasurementEvent */
public final class b {
    Context Ut;
    String name;
    Bundle zw;

    b(Context context, String str, Bundle bundle) {
        this.Ut = context.getApplicationContext();
        this.name = str;
        this.zw = bundle;
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
                Bundle bundle3 = (Bundle) obj;
                for (String str3 : bundle3.keySet()) {
                    String L = L(bundle3.get(str3));
                    if (str2.equals("referer_app_link")) {
                        if (str3.equalsIgnoreCase("url")) {
                            bundle2.putString("refererURL", L);
                        } else if (str3.equalsIgnoreCase("app_name")) {
                            bundle2.putString("refererAppName", L);
                        } else if (str3.equalsIgnoreCase("package")) {
                            bundle2.putString("sourceApplication", L);
                        }
                    }
                    bundle2.putString(str2 + Constants.URL_PATH_DELIMITER + str3, L);
                }
            } else {
                String L2 = L(obj);
                if (str2.equals("target_url")) {
                    Uri parse = Uri.parse(L2);
                    bundle2.putString("targetURL", parse.toString());
                    bundle2.putString("targetURLHost", parse.getHost());
                } else {
                    bundle2.putString(str2, L2);
                }
            }
        }
        return bundle2;
    }

    static String L(Object obj) {
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
        } catch (Exception unused) {
            return null;
        }
    }
}
