package android.arch.api.util;

import android.arch.a.b.b.c;
import android.arch.a.b.b.f;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class SelectIterator<K, V>
  implements b.f<K, V>, Iterator<Map.Entry<K, V>>
{
  private b.c<K, V> first;
  private b.c<K, V> last;
  
  SelectIterator(Option paramOption1, Option paramOption2)
  {
    last = paramOption2;
    first = paramOption1;
  }
  
  private Option nextThrow()
  {
    if ((first != last) && (last != null)) {
      return get(first);
    }
    return null;
  }
  
  abstract Option get(Option paramOption);
  
  public boolean hasNext()
  {
    return first != null;
  }
  
  public final void next(Option paramOption)
  {
    if ((last == paramOption) && (paramOption == first))
    {
      first = null;
      last = null;
    }
    if (last == paramOption) {
      last = toString(last);
    }
    if (first == paramOption) {
      first = nextThrow();
    }
  }
  
  abstract Option toString(Option paramOption);
}
