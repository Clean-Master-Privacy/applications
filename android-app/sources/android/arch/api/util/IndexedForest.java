package android.arch.api.util;

import android.arch.a.b.b;
import android.arch.a.b.b.c;
import java.util.HashMap;

public final class IndexedForest<K, V>
  extends b<K, V>
{
  public HashMap<K, b.c<K, V>> m = new HashMap();
  
  public IndexedForest() {}
  
  public final boolean contains(Object paramObject)
  {
    return m.containsKey(paramObject);
  }
  
  protected final Option get(Object paramObject)
  {
    return (Option)m.get(paramObject);
  }
  
  public final Object putIfAbsent(Object paramObject1, Object paramObject2)
  {
    Option localOption = get(paramObject1);
    if (localOption != null) {
      return mValue;
    }
    m.put(paramObject1, add(paramObject1, paramObject2));
    return null;
  }
  
  public final Object remove(Object paramObject)
  {
    Object localObject = super.remove(paramObject);
    m.remove(paramObject);
    return localObject;
  }
}
