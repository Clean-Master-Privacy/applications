    package c.a;

import c.a.d;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class a<K, V> implements Map<K, V> {
    private static int[] EMPTY_IMMUTABLE_INTS = new int[0];
    private static Object[] mBaseCache;
    private static int mBaseCacheSize;
    private static Object[] mTwiceBaseCache;
    private static int mTwiceBaseCacheSize;
    private d<K, V> kR;
    Object[] mArray;
    private int[] mHashes;
    int mSize;

    static {
        new a((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = c.binarySearch(this.mHashes, i2, i);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch << 1])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == i) {
            if (obj.equals(this.mArray[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = binarySearch - 1;
        while (i4 >= 0 && this.mHashes[i4] == i) {
            if (obj.equals(this.mArray[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* access modifiers changed from: package-private */
    public final int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = c.binarySearch(this.mHashes, i, 0);
        if (binarySearch < 0 || this.mArray[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (this.mArray[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = binarySearch - 1;
        while (i3 >= 0 && this.mHashes[i3] == 0) {
            if (this.mArray[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    private void allocArrays(int i) {
        if (this.mHashes != EMPTY_IMMUTABLE_INTS) {
            if (i == 8) {
                synchronized (a.class) {
                    if (mTwiceBaseCache != null) {
                        Object[] objArr = mTwiceBaseCache;
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                }
            } else if (i == 4) {
                synchronized (a.class) {
                    if (mBaseCache != null) {
                        Object[] objArr2 = mBaseCache;
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                }
            }
            this.mHashes = new int[i];
            this.mArray = new Object[(i << 1)];
            return;
        }
        throw new UnsupportedOperationException("ArrayMap is immutable");
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public a() {
        this.mHashes = c.EMPTY_INTS;
        this.mArray = c.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private a(byte b2) {
        this.mHashes = EMPTY_IMMUTABLE_INTS;
        this.mArray = c.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public final void clear() {
        if (this.mSize > 0) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = c.EMPTY_INTS;
            this.mArray = c.EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }

    public final boolean containsKey(Object obj) {
        return obj == null ? indexOfNull() >= 0 : indexOf(obj, obj.hashCode()) >= 0;
    }

    /* access modifiers changed from: package-private */
    public final int indexOfValue(Object obj) {
        int i = this.mSize << 1;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public final V get(Object obj) {
        int indexOfNull = obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
        if (indexOfNull >= 0) {
            return this.mArray[(indexOfNull << 1) + 1];
        }
        return null;
    }

    private K keyAt(int i) {
        return this.mArray[i << 1];
    }

    private V valueAt(int i) {
        return this.mArray[(i << 1) + 1];
    }

    public final boolean isEmpty() {
        return this.mSize <= 0;
    }

    public final V put(K k, V v) {
        int i;
        int i2;
        if (k == null) {
            i2 = indexOfNull();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = indexOf(k, hashCode);
        }
        if (i2 >= 0) {
            int i3 = (i2 << 1) + 1;
            V v2 = this.mArray[i3];
            this.mArray[i3] = v;
            return v2;
        }
        int i4 = i2 ^ -1;
        if (this.mSize >= this.mHashes.length) {
            int i5 = 4;
            if (this.mSize >= 8) {
                i5 = (this.mSize >> 1) + this.mSize;
            } else if (this.mSize >= 4) {
                i5 = 8;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i5);
            if (this.mHashes.length > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        if (i4 < this.mSize) {
            int i6 = i4 + 1;
            System.arraycopy(this.mHashes, i4, this.mHashes, i6, this.mSize - i4);
            System.arraycopy(this.mArray, i4 << 1, this.mArray, i6 << 1, (this.mSize - i4) << 1);
        }
        this.mHashes[i4] = i;
        int i7 = i4 << 1;
        this.mArray[i7] = k;
        this.mArray[i7 + 1] = v;
        this.mSize++;
        return null;
    }

    public final V remove(Object obj) {
        int indexOfNull = obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
        if (indexOfNull >= 0) {
            return removeAt(indexOfNull);
        }
        return null;
    }

    public final V removeAt(int i) {
        int i2 = i << 1;
        V v = this.mArray[i2 + 1];
        if (this.mSize <= 1) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = c.EMPTY_INTS;
            this.mArray = c.EMPTY_OBJECTS;
            this.mSize = 0;
        } else {
            int i3 = 8;
            if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
                this.mSize--;
                if (i < this.mSize) {
                    int i4 = i + 1;
                    System.arraycopy(this.mHashes, i4, this.mHashes, i, this.mSize - i);
                    System.arraycopy(this.mArray, i4 << 1, this.mArray, i2, (this.mSize - i) << 1);
                }
                this.mArray[this.mSize << 1] = null;
                this.mArray[(this.mSize << 1) + 1] = null;
            } else {
                if (this.mSize > 8) {
                    i3 = (this.mSize >> 1) + this.mSize;
                }
                int[] iArr = this.mHashes;
                Object[] objArr = this.mArray;
                allocArrays(i3);
                this.mSize--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i);
                    System.arraycopy(objArr, 0, this.mArray, 0, i2);
                }
                if (i < this.mSize) {
                    int i5 = i + 1;
                    System.arraycopy(iArr, i5, this.mHashes, i, this.mSize - i);
                    System.arraycopy(objArr, i5 << 1, this.mArray, i2, (this.mSize - i) << 1);
                }
            }
        }
        return v;
    }

    public final int size() {
        return this.mSize;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.mSize) {
            try {
                Object keyAt = keyAt(i);
                Object valueAt = valueAt(i);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 != null || !map.containsKey(keyAt)) {
                        return false;
                    }
                } else if (!valueAt.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException unused) {
                return false;
            } catch (ClassCastException unused2) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = this.mSize;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < i) {
            Object obj = objArr[i3];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i3 += 2;
        }
        return i4;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private d<K, V> cn() {
        if (this.kR == null) {
            this.kR = new d<K, V>() {
                /* access modifiers changed from: protected */
                public final int colGetSize() {
                    return a.this.mSize;
                }

                /* access modifiers changed from: protected */
                public final Object colGetEntry(int i, int i2) {
                    return a.this.mArray[(i << 1) + i2];
                }

                /* access modifiers changed from: protected */
                public final int colIndexOfKey(Object obj) {
                    return obj == null ? a.this.indexOfNull() : a.this.indexOf(obj, obj.hashCode());
                }

                /* access modifiers changed from: protected */
                public final int colIndexOfValue(Object obj) {
                    return a.this.indexOfValue(obj);
                }

                /* access modifiers changed from: protected */
                public final Map<K, V> colGetMap() {
                    return a.this;
                }

                /* access modifiers changed from: protected */
                public final void colPut(K k, V v) {
                    a.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                public final V colSetValue(int i, V v) {
                    a aVar = a.this;
                    int i2 = (i << 1) + 1;
                    V v2 = aVar.mArray[i2];
                    aVar.mArray[i2] = v;
                    return v2;
                }

                /* access modifiers changed from: protected */
                public final void colRemoveAt(int i) {
                    a.this.removeAt(i);
                }

                /* access modifiers changed from: protected */
                public final void colClear() {
                    a.this.clear();
                }
            };
        }
        return this.kR;
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        int size = this.mSize + map.size();
        if (this.mHashes.length < size) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(size);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize << 1);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        d cn2 = cn();
        if (cn2.kU == null) {
            cn2.kU = new d.b();
        }
        return cn2.kU;
    }

    public final Set<K> keySet() {
        return cn().getKeySet();
    }

    public final Collection<V> values() {
        d cn2 = cn();
        if (cn2.kW == null) {
            cn2.kW = new d.e();
        }
        return cn2.kW;
    }
}
    
