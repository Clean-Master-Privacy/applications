    package retrofit2;

import android.os.Build;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

class j {
    private static final j kjd = bYL();

    /* access modifiers changed from: package-private */
    @Nullable
    public Executor bYM() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean c(Method method) {
        return false;
    }

    j() {
    }

    static j bYK() {
        return kjd;
    }

    private static j bYL() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new j();
        }
    }

    /* access modifiers changed from: package-private */
    public c$a c(@Nullable Executor executor) {
        if (executor != null) {
            return new g(executor);
        }
        return f.kiH;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    @IgnoreJRERequirement
    static class b extends j {
        b() {
        }

        /* access modifiers changed from: package-private */
        public final boolean c(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: package-private */
        public final Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor<MethodHandles.Lookup> declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[]{cls, -1}).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    static class a extends j {
        a() {
        }

        public final Executor bYM() {
            return new a();
        }

        /* access modifiers changed from: package-private */
        public final c$a c(@Nullable Executor executor) {
            if (executor != null) {
                return new g(executor);
            }
            throw new AssertionError();
        }
    }
}
    
