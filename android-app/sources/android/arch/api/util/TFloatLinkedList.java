package android.arch.api.util;

import android.arch.a.b.b.c;
import android.arch.a.b.b.f;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class TFloatLinkedList<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public b.c<K, V> data;
  public int mSize = 0;
  public b.c<K, V> size;
  public WeakHashMap<b.f<K, V>, Boolean> this$0 = new WeakHashMap();
  
  public TFloatLinkedList() {}
  
  protected final Option add(Object paramObject1, Object paramObject2)
  {
    paramObject1 = new Option(paramObject1, paramObject2);
    mSize += 1;
    if (data == null)
    {
      size = paramObject1;
      data = size;
      return paramObject1;
    }
    data.value = paramObject1;
    data = data;
    data = paramObject1;
    return paramObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof TFloatLinkedList)) {
      return false;
    }
    Object localObject1 = (TFloatLinkedList)paramObject;
    if (mSize != mSize) {
      return false;
    }
    paramObject = iterator();
    localObject1 = ((TFloatLinkedList)localObject1).iterator();
    while ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)paramObject.next();
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localEntry == null) && (localObject2 != null)) {
        break label126;
      }
      if ((localEntry != null) && (!localEntry.equals(localObject2))) {
        return false;
      }
    }
    return (!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext());
  }
  
  public final FormControl.SelectFormControl.OptionElementIterator get()
  {
    FormControl.SelectFormControl.OptionElementIterator localOptionElementIterator = new FormControl.SelectFormControl.OptionElementIterator(this, (byte)0);
    this$0.put(localOptionElementIterator, Boolean.valueOf(false));
    return localOptionElementIterator;
  }
  
  protected Option get(Object paramObject)
  {
    for (Option localOption = size; (localOption != null) && (!key.equals(paramObject)); localOption = value) {}
    return localOption;
  }
  
  public Iterator iterator()
  {
    BufferedTreeNodeStream localBufferedTreeNodeStream = new BufferedTreeNodeStream(size, data);
    this$0.put(localBufferedTreeNodeStream, Boolean.valueOf(false));
    return localBufferedTreeNodeStream;
  }
  
  public Object putIfAbsent(Object paramObject1, Object paramObject2)
  {
    Option localOption = get(paramObject1);
    if (localOption != null) {
      return mValue;
    }
    add(paramObject1, paramObject2);
    return null;
  }
  
  public Object remove(Object paramObject)
  {
    paramObject = get(paramObject);
    if (paramObject == null) {
      return null;
    }
    mSize -= 1;
    if (!this$0.isEmpty())
    {
      Iterator localIterator = this$0.keySet().iterator();
      while (localIterator.hasNext()) {
        ((FastMap.EntryImpl)localIterator.next()).next(paramObject);
      }
    }
    if (data != null) {
      data.value = value;
    } else {
      size = value;
    }
    if (value != null) {
      value.data = data;
    } else {
      data = data;
    }
    value = null;
    data = null;
    return mValue;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
