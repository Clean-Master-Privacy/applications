    package c.a;

final class c {
    static final int[] EMPTY_INTS = new int[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];

    static int binarySearch(int[] iArr, int i, int i2) {
        if (iArr == null || iArr.length == 0) {
            return -1;
        }
        if (i > iArr.length) {
            i = iArr.length;
        }
        int i3 = 0;
        int i4 = i - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i3 ^ -1;
    }
}
    
