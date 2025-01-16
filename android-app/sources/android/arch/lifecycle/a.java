package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache */
final class a {
    static a am = new a();
    private final Map<Class, C0001a> an = new HashMap();
    final Map<Class, Boolean> ao = new HashMap();

    a() {
    }

    static Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final C0001a c(Class cls) {
        C0001a aVar = this.an.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }

    private static void a(Map<b, Lifecycle.Event> map, b bVar, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 != null && event != event2) {
            Method method = bVar.as;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(bVar, event);
        }
    }

    /* access modifiers changed from: package-private */
    public final C0001a a(Class cls, Method[] methodArr) {
        int i;
        C0001a c2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c2 = c(superclass)) == null)) {
            hashMap.putAll(c2.aq);
        }
        for (Class c3 : cls.getInterfaces()) {
            for (Map.Entry next : c(c3).aq.entrySet()) {
                a(hashMap, (b) next.getKey(), (Lifecycle.Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            k kVar = (k) method.getAnnotation(k.class);
            if (kVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(d.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event R = kVar.R();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (R == Lifecycle.Event.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), R, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0001a aVar = new C0001a(hashMap);
        this.an.put(cls, aVar);
        this.ao.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* renamed from: android.arch.lifecycle.a$a  reason: collision with other inner class name */
    /* compiled from: ClassesInfoCache */
    static class C0001a {
        final Map<Lifecycle.Event, List<b>> ap = new HashMap();
        final Map<b, Lifecycle.Event> aq;

        C0001a(Map<b, Lifecycle.Event> map) {
            this.aq = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) next.getValue();
                List list = this.ap.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.ap.put(event, list);
                }
                list.add(next.getKey());
            }
        }

        static void a(List<b> list, d dVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                int size = list.size() - 1;
                while (size >= 0) {
                    b bVar = list.get(size);
                    try {
                        switch (bVar.ar) {
                            case 0:
                                bVar.as.invoke(obj, new Object[0]);
                                break;
                            case 1:
                                bVar.as.invoke(obj, new Object[]{dVar});
                                break;
                            case 2:
                                bVar.as.invoke(obj, new Object[]{dVar, event});
                                break;
                        }
                        size--;
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    } catch (IllegalAccessException e3) {
                        throw new RuntimeException(e3);
                    }
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache */
    static class b {
        final int ar;
        final Method as;

        b(int i, Method method) {
            this.ar = i;
            this.as = method;
            this.as.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.ar == bVar.ar && this.as.getName().equals(bVar.as.getName());
        }

        public final int hashCode() {
            return (this.ar * 31) + this.as.getName().hashCode();
        }
    }
}
