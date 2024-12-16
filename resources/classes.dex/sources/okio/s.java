    package okio;

import java.nio.charset.Charset;

final class s {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static short E(short s) {
        short s2 = s & 65535;
        return (short) (((s2 & 255) << 8) | ((s2 >>> 8) & 255));
    }

    public static int Nw(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static void w(Throwable th) {
        throw th;
    }
}
    
