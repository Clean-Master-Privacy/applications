    package c.a;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class d<K, V> {
    d<K, V>.b kU;
    private d<K, V>.c kV;
    d<K, V>.e kW;

    /* access modifiers changed from: protected */
    public abstract void colClear();

    /* access modifiers changed from: protected */
    public abstract Object colGetEntry(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> colGetMap();

    /* access modifiers changed from: protected */
    public abstract int colGetSize();

    /* access modifiers changed from: protected */
    public abstract int colIndexOfKey(Object obj);

    /* access modifiers changed from: protected */
    public abstract int colIndexOfValue(Object obj);

    /* access modifiers changed from: protected */
    public abstract void colPut(K k, V v);

    /* access modifiers changed from: protected */
    public abstract void colRemoveAt(int i);

    /* access modifiers changed from: protected */
    public abstract V colSetValue(int i, V v);

    d() {
    }

    final class a<T> implements Iterator<T> {
        private boolean mCanRemove = false;
        private int mIndex;
        private int mOffset;
        private int mSize;

        a(int i) {
            this.mOffset = i;
            this.mSize = d.this.colGetSize();
        }

        public final boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        public final T next() {
            T colGetEntry = d.this.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return colGetEntry;
        }

        public final void remove() {
            if (this.mCanRemove) {
                this.mIndex--;
                this.mSize--;
                this.mCanRemove = false;
                d.this.colRemoveAt(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: c.a.d$d  reason: collision with other inner class name */
    final class C0009d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        private int mEnd;
        private boolean mEntryValid = false;
        private int mIndex;

        C0009d() {
            this.mEnd = d.this.colGetSize() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        public final void remove() {
            if (this.mEntryValid) {
                this.mIndex--;
                this.mEnd--;
                this.mEntryValid = false;
                d.this.colRemoveAt(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.mEntryValid) {
                return d.this.colGetEntry(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.mEntryValid) {
                return d.this.colGetEntry(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.mEntryValid) {
                return d.this.colSetValue(this.mIndex, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!libcore.util.a.equal(entry.getKey(), d.this.colGetEntry(this.mIndex, 0)) || !libcore.util.a.equal(entry.getValue(), d.this.colGetEntry(this.mIndex, 1))) {
                    return false;
                }
                return true;
            }
        }

        public final int hashCode() {
            int i;
            if (this.mEntryValid) {
                int i2 = 0;
                Object colGetEntry = d.this.colGetEntry(this.mIndex, 0);
                Object colGetEntry2 = d.this.colGetEntry(this.mIndex, 1);
                if (colGetEntry == null) {
                    i = 0;
                } else {
                    i = colGetEntry.hashCode();
                }
                if (colGetEntry2 != null) {
                    i2 = colGetEntry2.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int colGetSize = d.this.colGetSize();
            for (Map.Entry entry : collection) {
                d.this.colPut(entry.getKey(), entry.getValue());
            }
            return colGetSize != d.this.colGetSize();
        }

        public final void clear() {
            d.this.colClear();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int colIndexOfKey = d.this.colIndexOfKey(entry.getKey());
            if (colIndexOfKey < 0) {
                return false;
            }
            return libcore.util.a.equal(d.this.colGetEntry(colIndexOfKey, 1), entry.getValue());
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return d.this.colGetSize() == 0;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new C0009d();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return d.this.colGetSize();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return d.equalsSetHelper(this, obj);
        }

        public final int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int colGetSize = d.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = d.this.colGetEntry(colGetSize, 0);
                Object colGetEntry2 = d.this.colGetEntry(colGetSize, 1);
                if (colGetEntry == null) {
                    i = 0;
                } else {
                    i = colGetEntry.hashCode();
                }
                if (colGetEntry2 == null) {
                    i2 = 0;
                } else {
                    i2 = colGetEntry2.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            d.this.colClear();
        }

        public final boolean contains(Object obj) {
            return d.this.colIndexOfKey(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map colGetMap = d.this.colGetMap();
            for (Object containsKey : collection) {
                if (!colGetMap.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return d.this.colGetSize() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(0);
        }

        public final boolean remove(Object obj) {
            int colIndexOfKey = d.this.colIndexOfKey(obj);
            if (colIndexOfKey < 0) {
                return false;
            }
            d.this.colRemoveAt(colIndexOfKey);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map colGetMap = d.this.colGetMap();
            int size = colGetMap.size();
            for (Object remove : collection) {
                colGetMap.remove(remove);
            }
            return size != colGetMap.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            Map colGetMap = d.this.colGetMap();
            int size = colGetMap.size();
            Iterator it = colGetMap.keySet().iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                }
            }
            return size != colGetMap.size();
        }

        public final int size() {
            return d.this.colGetSize();
        }

        public final Object[] toArray() {
            return d.this.toArrayHelper(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return d.this.toArrayHelper(tArr, 0);
        }

        public final boolean equals(Object obj) {
            return d.equalsSetHelper(this, obj);
        }

        public final int hashCode() {
            int i;
            int i2 = 0;
            for (int colGetSize = d.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = d.this.colGetEntry(colGetSize, 0);
                if (colGetEntry == null) {
                    i = 0;
                } else {
                    i = colGetEntry.hashCode();
                }
                i2 += i;
            }
            return i2;
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            d.this.colClear();
        }

        public final boolean contains(Object obj) {
            return d.this.colIndexOfValue(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return d.this.colGetSize() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(1);
        }

        public final boolean remove(Object obj) {
            int colIndexOfValue = d.this.colIndexOfValue(obj);
            if (colIndexOfValue < 0) {
                return false;
            }
            d.this.colRemoveAt(colIndexOfValue);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int colGetSize = d.this.colGetSize();
            int i = 0;
            boolean z = false;
            while (i < colGetSize) {
                if (collection.contains(d.this.colGetEntry(i, 1))) {
                    d.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int colGetSize = d.this.colGetSize();
            int i = 0;
            boolean z = false;
            while (i < colGetSize) {
                if (!collection.contains(d.this.colGetEntry(i, 1))) {
                    d.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return d.this.colGetSize();
        }

        public final Object[] toArray() {
            return d.this.toArrayHelper(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return d.this.toArrayHelper(tArr, 1);
        }
    }

    public final Object[] toArrayHelper(int i) {
        int colGetSize = colGetSize();
        Object[] objArr = new Object[colGetSize];
        for (int i2 = 0; i2 < colGetSize; i2++) {
            objArr[i2] = colGetEntry(i2, i);
        }
        return objArr;
    }

    public final <T> T[] toArrayHelper(T[] tArr, int i) {
        int colGetSize = colGetSize();
        if (tArr.length < colGetSize) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), colGetSize);
        }
        for (int i2 = 0; i2 < colGetSize; i2++) {
            tArr[i2] = colGetEntry(i2, i);
        }
        if (tArr.length > colGetSize) {
            tArr[colGetSize] = null;
        }
        return tArr;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (NullPointerException unused) {
            return false;
        } catch (ClassCastException unused2) {
            return false;
        }
    }

    public final Set<K> getKeySet() {
        if (this.kV == null) {
            this.kV = new c();
        }
        return this.kV;
    }
}
    
