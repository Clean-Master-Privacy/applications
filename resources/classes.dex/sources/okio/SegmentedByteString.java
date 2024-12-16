    package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(c cVar, int i) {
        super((byte[]) null);
        s.checkOffsetAndCount(cVar.size, 0, (long) i);
        int i2 = 0;
        n nVar = cVar.kih;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (nVar.limit != nVar.pos) {
                i3 += nVar.limit - nVar.pos;
                i4++;
                nVar = nVar.kiz;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i4][];
        this.directory = new int[(i4 << 1)];
        n nVar2 = cVar.kih;
        int i5 = 0;
        while (i2 < i) {
            this.segments[i5] = nVar2.data;
            i2 += nVar2.limit - nVar2.pos;
            if (i2 > i) {
                i2 = i;
            }
            this.directory[i5] = i2;
            this.directory[this.segments.length + i5] = nVar2.pos;
            nVar2.kix = true;
            i5++;
            nVar2 = nVar2.kiz;
        }
    }

    public final String utf8() {
        return bYC().utf8();
    }

    public final String string(Charset charset) {
        return bYC().string(charset);
    }

    public final String base64() {
        return bYC().base64();
    }

    public final String hex() {
        return bYC().hex();
    }

    public final ByteString toAsciiLowercase() {
        return bYC().toAsciiLowercase();
    }

    public final ByteString toAsciiUppercase() {
        return bYC().toAsciiUppercase();
    }

    public final ByteString md5() {
        return bYC().md5();
    }

    public final ByteString sha1() {
        return bYC().sha1();
    }

    public final ByteString sha256() {
        return bYC().sha256();
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return bYC().hmacSha1(byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return bYC().hmacSha256(byteString);
    }

    public final String base64Url() {
        return bYC().base64Url();
    }

    public final ByteString substring(int i) {
        return bYC().substring(i);
    }

    public final ByteString substring(int i, int i2) {
        return bYC().substring(i, i2);
    }

    public final byte getByte(int i) {
        int i2;
        s.checkOffsetAndCount((long) this.directory[this.segments.length - 1], (long) i, 1);
        int Nv = Nv(i);
        if (Nv == 0) {
            i2 = 0;
        } else {
            i2 = this.directory[Nv - 1];
        }
        return this.segments[Nv][(i - i2) + this.directory[this.segments.length + Nv]];
    }

    private int Nv(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public final int size() {
        return this.directory[this.segments.length - 1];
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[this.directory[this.segments.length - 1]];
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            System.arraycopy(this.segments[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    public final ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public final void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = this.directory[length + i];
                int i4 = this.directory[i];
                outputStream.write(this.segments[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* access modifiers changed from: package-private */
    public final void write(c cVar) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            n nVar = new n(this.segments[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.kih == null) {
                nVar.kiA = nVar;
                nVar.kiz = nVar;
                cVar.kih = nVar;
            } else {
                cVar.kih.kiA.a(nVar);
            }
            i++;
            i2 = i4;
        }
        cVar.size += (long) i2;
    }

    public final boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        int i4;
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int Nv = Nv(i);
        while (i3 > 0) {
            if (Nv == 0) {
                i4 = 0;
            } else {
                i4 = this.directory[Nv - 1];
            }
            int min = Math.min(i3, ((this.directory[Nv] - i4) + i4) - i);
            if (!byteString.rangeEquals(i2, this.segments[Nv], (i - i4) + this.directory[this.segments.length + Nv], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            Nv++;
        }
        return true;
    }

    public final boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int Nv = Nv(i);
        while (i3 > 0) {
            if (Nv == 0) {
                i4 = 0;
            } else {
                i4 = this.directory[Nv - 1];
            }
            int min = Math.min(i3, ((this.directory[Nv] - i4) + i4) - i);
            if (!s.a(this.segments[Nv], (i - i4) + this.directory[this.segments.length + Nv], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            Nv++;
        }
        return true;
    }

    public final int indexOf(byte[] bArr, int i) {
        return bYC().indexOf(bArr, i);
    }

    public final int lastIndexOf(byte[] bArr, int i) {
        return bYC().lastIndexOf(bArr, i);
    }

    private ByteString bYC() {
        return new ByteString(toByteArray());
    }

    /* access modifiers changed from: package-private */
    public final byte[] internalArray() {
        return toByteArray();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == size() && rangeEquals(0, byteString, 0, size());
        }
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int i5 = this.directory[length + i2];
            int i6 = this.directory[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    public final String toString() {
        return bYC().toString();
    }

    private Object writeReplace() {
        return bYC();
    }
}
    
