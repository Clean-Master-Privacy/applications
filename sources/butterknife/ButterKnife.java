 package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {
    @VisibleForTesting
    private static Map<Class<?>, Constructor<? extends Unbinder>> iO = new LinkedHashMap();

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @UiThread
    @NonNull
    public static Unbinder c(@NonNull Activity activity) {
        return a((Object) activity, activity.getWindow().getDecorView());
    }

    @UiThread
    @NonNull
    public static Unbinder d(@NonNull View view) {
        return a((Object) view, view);
    }

    @UiThread
    @NonNull
    public static Unbinder a(@NonNull Dialog dialog) {
        return a((Object) dialog, dialog.getWindow().getDecorView());
    }

    @UiThread
    @NonNull
    public static Unbinder a(@NonNull Object obj, @NonNull Activity activity) {
        return a(obj, activity.getWindow().getDecorView());
    }

    @UiThread
    @NonNull
    public static Unbinder a(@NonNull Object obj, @NonNull View view) {
        Constructor<? extends Unbinder> d2 = d(obj.getClass());
        if (d2 == null) {
            return Unbinder.EMPTY;
        }
        try {
            return (Unbinder) d2.newInstance(new Object[]{obj, view});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to invoke " + d2, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Unable to invoke " + d2, e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }

    @UiThread
    @Nullable
    @CheckResult
    private static Constructor<? extends Unbinder> d(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Constructor<? extends Unbinder> constructor2 = iO.get(cls);
        if (constructor2 != null || iO.containsKey(cls)) {
            return constructor2;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("androidx.")) {
            return null;
        }
        try {
            ClassLoader classLoader = cls.getClassLoader();
            constructor = classLoader.loadClass(name + "_ViewBinding").getConstructor(new Class[]{cls, View.class});
        } catch (ClassNotFoundException unused) {
            constructor = d((Class<?>) cls.getSuperclass());
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Unable to find binding constructor for " + name, e2);
        }
        iO.put(cls, constructor);
        return constructor;
    }
}
    
