 package b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Method;

public final class a {
    public static Uri c(Context context, Intent intent) {
        String string;
        Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
        if (bundleExtra == null || (string = bundleExtra.getString("target_url")) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (intent != null) {
            Bundle bundleExtra2 = intent.getBundleExtra("al_applink_data");
            if (bundleExtra2 != null) {
                bundle = b.a(context, "al_nav_in", bundleExtra2, intent);
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    bundle.putString("intentData", data.toString());
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str : extras.keySet()) {
                        bundle.putString(str, b.l(extras.get(str)));
                    }
                }
            }
        }
        b bVar = new b(context, "al_nav_in", bundle);
        if (bVar.name == null) {
            Log.d(bVar.getClass().getName(), "Event name is required");
        }
        try {
            Class<?> cls = Class.forName("android.support.v4.content.LocalBroadcastManager");
            Method method = cls.getMethod("getInstance", new Class[]{Context.class});
            Method method2 = cls.getMethod("sendBroadcast", new Class[]{Intent.class});
            Object invoke = method.invoke((Object) null, new Object[]{bVar.appContext});
            Intent intent2 = new Intent("com.parse.bolts.measurement_event");
            intent2.putExtra("event_name", bVar.name);
            intent2.putExtra("event_args", bVar.args);
            method2.invoke(invoke, new Object[]{intent2});
        } catch (Exception unused) {
            Log.d(bVar.getClass().getName(), "LocalBroadcastManager in android support library is required to raise bolts event.");
        }
        return Uri.parse(string);
    }
}
    
