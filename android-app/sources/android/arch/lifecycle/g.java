package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling */
public final class g {
    private static Map<Class, Integer> aE = new HashMap();
    private static Map<Class, List<Constructor<? extends b>>> aF = new HashMap();

    static GenericLifecycleObserver c(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter();
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (e(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = aF.get(cls);
        if (list.size() == 1) {
            a((Constructor) list.get(0), obj);
            return new SingleGeneratedAdapterObserver();
        }
        b[] bVarArr = new b[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bVarArr[i] = a((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver();
    }

    private static b a(Constructor<? extends b> constructor, Object obj) {
        try {
            return (b) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Constructor<? extends b> d(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String str = canonicalName.replace(".", "_") + "_LifecycleAdapter";
            if (!name.isEmpty()) {
                str = name + "." + str;
            }
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static int e(Class<?> cls) {
        boolean z;
        if (aE.containsKey(cls)) {
            return aE.get(cls).intValue();
        }
        int i = 2;
        if (cls.getCanonicalName() != null) {
            Constructor<? extends b> d2 = d(cls);
            if (d2 != null) {
                aF.put(cls, Collections.singletonList(d2));
            } else {
                a aVar = a.am;
                int i2 = 0;
                if (!aVar.ao.containsKey(cls)) {
                    Method[] b2 = a.b(cls);
                    int length = b2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            aVar.ao.put(cls, false);
                            z = false;
                            break;
                        } else if (((k) b2[i3].getAnnotation(k.class)) != null) {
                            aVar.a(cls, b2);
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                } else {
                    z = aVar.ao.get(cls).booleanValue();
                }
                if (!z) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    ArrayList arrayList = null;
                    if (f(superclass)) {
                        if (e(superclass) != 1) {
                            arrayList = new ArrayList(aF.get(superclass));
                        }
                    }
                    Class[] interfaces = cls.getInterfaces();
                    int length2 = interfaces.length;
                    while (true) {
                        if (i2 < length2) {
                            Class cls2 = interfaces[i2];
                            if (f(cls2)) {
                                if (e(cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.addAll(aF.get(cls2));
                            }
                            i2++;
                        } else if (arrayList != null) {
                            aF.put(cls, arrayList);
                        }
                    }
                }
            }
            aE.put(cls, Integer.valueOf(i));
            return i;
        }
        i = 1;
        aE.put(cls, Integer.valueOf(i));
        return i;
    }

    private static boolean f(Class<?> cls) {
        return cls != null && c.class.isAssignableFrom(cls);
    }
}
