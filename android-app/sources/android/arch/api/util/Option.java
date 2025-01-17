package android.arch.api.util;

import android.arch.a.b.b.c;
import java.util.Map.Entry;

public final class Option<K, V>
  implements Map.Entry<K, V>
{
  public b.c<K, V> data;
  final K key;
  final V mValue;
  b.c<K, V> value;
  
  Option(Object paramObject1, Object paramObject2)
  {
    key = paramObject1;
    mValue = paramObject2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Option)) {
      return false;
    }
    paramObject = (Option)paramObject;
    return (key.equals(key)) && (mValue.equals(mValue));
  }
  
  public final Object getKey()
  {
    return key;
  }
  
  public final Object getValue()
  {
    return mValue;
  }
  
  public final Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(key);
    localStringBuilder.append("=");
    localStringBuilder.append(mValue);
    return localStringBuilder.toString();
  }
}
