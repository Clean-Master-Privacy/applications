    package c.a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {
    private static Object[] mBaseCache;
    private static int mBaseCacheSize;
    private static Object[] mTwiceBaseCache;
    private static int mTwiceBaseCacheSize;
    private d<E, E> kR;
    Object[] mArray = c.EMPTY_OBJECTS;
    private int[] mHashes = c.EMPTY_INTS;
    int mSize = 0;

    /* access modifiers changed from: private */
    public int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = c.binarySearch(this.mHashes, i2, i);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == i) {
            if (obj.equals(this.mArray[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = binarySearch - 1;
        while (i4 >= 0 && this.mHashes[i4] == i) {
            if (obj.equals(this.mArray[i4])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* access modifiers changed from: private */
    public int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = c.binarySearch(this.mHashes, i, 0);
        if (binarySearch < 0 || this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (this.mArray[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = binarySearch - 1;
        while (i3 >= 0 && this.mHashes[i3] == 0) {
            if (this.mArray[i3] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    private void allocArrays(int i) {
        if (i == 8) {
            synchronized (b.class) {
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
            synchronized (b.class) {
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
        this.mArray = new Object[i];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public final void clear() {
        if (this.mSize != 0) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = c.EMPTY_INTS;
            this.mArray = c.EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }

    public final boolean contains(Object obj) {
        return obj == null ? indexOfNull() >= 0 : indexOf(obj, obj.hashCode()) >= 0;
    }

    public final boolean isEmpty() {
        return this.mSize <= 0;
    }

    public final boolean add(E e2) {
        int i;
        int i2;
        if (e2 == null) {
            i2 = indexOfNull();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            i2 = indexOf(e2, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = i2 ^ -1;
        if (this.mSize >= this.mHashes.length) {
            int i4 = 4;
            if (this.mSize >= 8) {
                i4 = (this.mSize >> 1) + this.mSize;
            } else if (this.mSize >= 4) {
                i4 = 8;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i4);
            if (this.mHashes.length > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        if (i3 < this.mSize) {
            int i5 = i3 + 1;
            System.arraycopy(this.mHashes, i3, this.mHashes, i5, this.mSize - i3);
            System.arraycopy(this.mArray, i3, this.mArray, i5, this.mSize - i3);
        }
        this.mHashes[i3] = i;
        this.mArray[i3] = e2;
        this.mSize++;
        return true;
    }

    public final boolean remove(Object obj) {
        int indexOfNull = obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
        if (indexOfNull < 0) {
            return false;
        }
        removeAt(indexOfNull);
        return true;
    }

    public final E removeAt(int i) {
        E e2 = this.mArray[i];
        if (this.mSize <= 1) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = c.EMPTY_INTS;
            this.mArray = c.EMPTY_OBJECTS;
            this.mSize = 0;
        } else {
            int i2 = 8;
            if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
                this.mSize--;
                if (i < this.mSize) {
                    int i3 = i + 1;
                    System.arraycopy(this.mHashes, i3, this.mHashes, i, this.mSize - i);
                    System.arraycopy(this.mArray, i3, this.mArray, i, this.mSize - i);
                }
                this.mArray[this.mSize] = null;
            } else {
                if (this.mSize > 8) {
                    i2 = (this.mSize >> 1) + this.mSize;
                }
                int[] iArr = this.mHashes;
                Object[] objArr = this.mArray;
                allocArrays(i2);
                this.mSize--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i);
                    System.arraycopy(objArr, 0, this.mArray, 0, i);
                }
                if (i < this.mSize) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.mHashes, i, this.mSize - i);
                    System.arraycopy(objArr, i4, this.mArray, i, this.mSize - i);
                }
            }
        }
        return e2;
    }

    public final int size() {
        return this.mSize;
    }

    public final Object[] toArray() {
        Object[] objArr = new Object[this.mSize];
        System.arraycopy(this.mArray, 0, objArr, 0, this.mSize);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        if (tArr.length > this.mSize) {
            tArr[this.mSize] = null;
        }
        return tArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.mSize) {
            try {
                if (!set.contains(this.mArray[i])) {
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
        int i = this.mSize;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.mArray[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        int size = this.mSize + collection.size();
        boolean z = false;
        if (this.mHashes.length < size) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(size);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public final boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.mSize - 1; i >= 0; i--) {
            if (!collection.contains(this.mArray[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    public final Iterator<E> iterator() {
        if (this.kR == null) {
            this.kR = new d<E, E>() {
                /* access modifiers changed from: protected */
                public final int colGetSize() {
                    return b.this.mSize;
                }

                /* access modifiers changed from: protected */
                public final Object colGetEntry(int i, int i2) {
                    return b.this.mArray[i];
                }

                /* access modifiers changed from: protected */
                public final int colIndexOfKey(Object obj) {
                    return obj == null ? b.this.indexOfNull() : b.this.indexOf(obj, obj.hashCode());
                }

                /* access modifiers changed from: protected */
                public final int colIndexOfValue(Object obj) {
                    return obj == null ? b.this.indexOfNull() : b.this.indexOf(obj, obj.hashCode());
                }

                /* access modifiers changed from: protected */
                public final Map<E, E> colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public final void colPut(E e2, E e3) {
                    b.this.add(e2);
                }

                /* access modifiers changed from: protected */
                public final E colSetValue(int i, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public final void colRemoveAt(int i) {
                    b.this.removeAt(i);
                }

                /* access modifiers changed from: protected */
                public final void colClear() {
                    b.this.clear();
                }
            };
        }
        return this.kR.getKeySet().iterator();
    }
}
    
