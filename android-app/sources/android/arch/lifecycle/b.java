package android.arch.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class b
{
  static b c = new b();
  final Map<Class, Boolean> a = new HashMap();
  private final Map<Class, a.a> d = new HashMap();
  
  b() {}
  
  private static void a(Map paramMap, Label paramLabel, Lifecycle.Event paramEvent, Class paramClass)
  {
    Lifecycle.Event localEvent = (Lifecycle.Event)paramMap.get(paramLabel);
    if ((localEvent != null) && (paramEvent != localEvent))
    {
      paramMap = d;
      paramLabel = new StringBuilder("Method ");
      paramLabel.append(paramMap.getName());
      paramLabel.append(" in ");
      paramLabel.append(paramClass.getName());
      paramLabel.append(" already declared with different @OnLifecycleEvent value: previous value ");
      paramLabel.append(localEvent);
      paramLabel.append(", new value ");
      paramLabel.append(paramEvent);
      throw new IllegalArgumentException(paramLabel.toString());
    }
    if (localEvent == null) {
      paramMap.put(paramLabel, paramEvent);
    }
  }
  
  static Method[] toString(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  final i a(Class paramClass)
  {
    i localI = (i)d.get(paramClass);
    if (localI != null) {
      return localI;
    }
    return a(paramClass, null);
  }
  
  final i a(Class paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = a((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(a);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = aa.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (Label)((Map.Entry)localObject3).getKey(), (Lifecycle.Event)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod == null) {
      paramArrayOfMethod = toString(paramClass);
    }
    int k = paramArrayOfMethod.length;
    j = 0;
    boolean bool = false;
    while (j < k)
    {
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (Segment)((Method)localObject1).getAnnotation(k.class);
      if (localObject3 != null)
      {
        localObject2 = ((Method)localObject1).getParameterTypes();
        if (localObject2.length > 0)
        {
          if (localObject2[0].isAssignableFrom(d.class)) {
            i = 1;
          } else {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
        else {
          i = 0;
        }
        localObject3 = ((Segment)localObject3).getValue();
        if (localObject2.length > 1) {
          if (localObject2[1].isAssignableFrom(Lifecycle.Event.class))
          {
            if (localObject3 == Lifecycle.Event.ON_ANY) {
              i = 2;
            } else {
              throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
            }
          }
          else {
            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
          }
        }
        if (localObject2.length <= 2)
        {
          a(localHashMap, new Label(i, (Method)localObject1), (Lifecycle.Event)localObject3, paramClass);
          bool = true;
        }
        else
        {
          throw new IllegalArgumentException("cannot have more than 2 params");
        }
      }
      j += 1;
    }
    paramArrayOfMethod = new i(localHashMap);
    d.put(paramClass, paramArrayOfMethod);
    a.put(paramClass, Boolean.valueOf(bool));
    return paramArrayOfMethod;
  }
}
