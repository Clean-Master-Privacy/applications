    package okio;

import com.anchorfree.hydrasdk.exceptions.VPNException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class c implements Cloneable, ByteChannel, d, e {
    private static final byte[] kig = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable
    n kih;
    public long size;

    public final c bYi() {
        return this;
    }

    public final d bYj() {
        return this;
    }

    public final /* bridge */ /* synthetic */ d bYv() throws IOException {
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final boolean isOpen() {
        return true;
    }

    public final boolean bYk() {
        return this.size == 0;
    }

    public final void fu(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    public final boolean fv(long j) {
        return this.size >= j;
    }

    public final InputStream bYl() {
        return new InputStream() {
            public final void close() {
            }

            public final int read() {
                if (c.this.size > 0) {
                    return c.this.readByte() & 255;
                }
                return -1;
            }

            public final int read(byte[] bArr, int i, int i2) {
                return c.this.read(bArr, i, i2);
            }

            public final int available() {
                return (int) Math.min(c.this.size, 2147483647L);
            }

            public final String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar != null) {
            s.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.size += j2;
            n nVar = this.kih;
            while (j >= ((long) (nVar.limit - nVar.pos))) {
                j -= (long) (nVar.limit - nVar.pos);
                nVar = nVar.kiz;
            }
            while (j2 > 0) {
                n bYy = nVar.bYy();
                bYy.pos = (int) (((long) bYy.pos) + j);
                bYy.limit = Math.min(bYy.pos + ((int) j2), bYy.limit);
                if (cVar.kih == null) {
                    bYy.kiA = bYy;
                    bYy.kiz = bYy;
                    cVar.kih = bYy;
                } else {
                    cVar.kih.kiA.a(bYy);
                }
                j2 -= (long) (bYy.limit - bYy.pos);
                nVar = nVar.kiz;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final long bYm() {
        long j = this.size;
        if (j == 0) {
            return 0;
        }
        n nVar = this.kih.kiA;
        return (nVar.limit >= 8192 || !nVar.kiy) ? j : j - ((long) (nVar.limit - nVar.pos));
    }

    public final byte readByte() {
        if (this.size != 0) {
            n nVar = this.kih;
            int i = nVar.pos;
            int i2 = nVar.limit;
            int i3 = i + 1;
            byte b2 = nVar.data[i];
            this.size--;
            if (i3 == i2) {
                this.kih = nVar.bYA();
                o.b(nVar);
            } else {
                nVar.pos = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public final byte fw(long j) {
        s.checkOffsetAndCount(this.size, j, 1);
        if (this.size - j > j) {
            n nVar = this.kih;
            while (true) {
                long j2 = (long) (nVar.limit - nVar.pos);
                if (j < j2) {
                    return nVar.data[nVar.pos + ((int) j)];
                }
                j -= j2;
                nVar = nVar.kiz;
            }
        } else {
            long j3 = j - this.size;
            n nVar2 = this.kih;
            do {
                nVar2 = nVar2.kiA;
                j3 += (long) (nVar2.limit - nVar2.pos);
            } while (j3 < 0);
            return nVar2.data[nVar2.pos + ((int) j3)];
        }
    }

    public final short readShort() {
        if (this.size >= 2) {
            n nVar = this.kih;
            int i = nVar.pos;
            int i2 = nVar.limit;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = nVar.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.size -= 2;
            if (i4 == i2) {
                this.kih = nVar.bYA();
                o.b(nVar);
            } else {
                nVar.pos = i4;
            }
            return (short) b2;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    public final int readInt() {
        if (this.size >= 4) {
            n nVar = this.kih;
            int i = nVar.pos;
            int i2 = nVar.limit;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = nVar.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b3 = b2 | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b4 = b3 | (bArr[i5] & 255);
            this.size -= 4;
            if (i6 == i2) {
                this.kih = nVar.bYA();
                o.b(nVar);
            } else {
                nVar.pos = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    public final long readLong() {
        if (this.size >= 8) {
            n nVar = this.kih;
            int i = nVar.pos;
            int i2 = nVar.limit;
            if (i2 - i < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = nVar.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j2 = (((long) bArr[i9]) & 255) | ((((long) bArr[i8]) & 255) << 8) | j;
            this.size -= 8;
            if (i10 == i2) {
                this.kih = nVar.bYA();
                o.b(nVar);
            } else {
                nVar.pos = i10;
            }
            return j2;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    public final short bYn() {
        return s.E(readShort());
    }

    public final int bYo() {
        return s.Nw(readInt());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        if (r10 != r11) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        r0.kih = r17.bYA();
        okio.o.b(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b3, code lost:
        r17.pos = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r4 != false) goto L_0x00bd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long bYp() {
        /*
            r19 = this;
            r0 = r19
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00c8
            r1 = -7
            r5 = 0
            r6 = r3
            r3 = 0
            r4 = 0
        L_0x0010:
            okio.n r8 = r0.kih
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L_0x0018:
            r12 = 1
            if (r10 >= r11) goto L_0x00a5
            byte r13 = r9[r10]
            r14 = 48
            if (r13 < r14) goto L_0x0072
            r15 = 57
            if (r13 > r15) goto L_0x0072
            int r14 = r14 - r13
            r15 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r12 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r12 < 0) goto L_0x0048
            int r12 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r12 != 0) goto L_0x003d
            r17 = r8
            r18 = r9
            long r8 = (long) r14
            int r12 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r12 >= 0) goto L_0x0041
            goto L_0x0048
        L_0x003d:
            r17 = r8
            r18 = r9
        L_0x0041:
            r8 = 10
            long r6 = r6 * r8
            long r8 = (long) r14
            long r6 = r6 + r8
            goto L_0x0080
        L_0x0048:
            okio.c r1 = new okio.c
            r1.<init>()
            okio.c r1 = r1.fH(r6)
            okio.c r1 = r1.Nu(r13)
            if (r3 != 0) goto L_0x005a
            r1.readByte()
        L_0x005a:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.bYr()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0072:
            r17 = r8
            r18 = r9
            r8 = 45
            if (r13 != r8) goto L_0x0089
            if (r5 != 0) goto L_0x0089
            r8 = 1
            long r1 = r1 - r8
            r3 = 1
        L_0x0080:
            int r10 = r10 + 1
            int r5 = r5 + 1
            r8 = r17
            r9 = r18
            goto L_0x0018
        L_0x0089:
            if (r5 == 0) goto L_0x008d
            r4 = 1
            goto L_0x00a7
        L_0x008d:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.<init>(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r13)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00a5:
            r17 = r8
        L_0x00a7:
            if (r10 != r11) goto L_0x00b3
            okio.n r8 = r17.bYA()
            r0.kih = r8
            okio.o.b(r17)
            goto L_0x00b7
        L_0x00b3:
            r8 = r17
            r8.pos = r10
        L_0x00b7:
            if (r4 != 0) goto L_0x00bd
            okio.n r8 = r0.kih
            if (r8 != 0) goto L_0x0010
        L_0x00bd:
            long r1 = r0.size
            long r4 = (long) r5
            long r1 = r1 - r4
            r0.size = r1
            if (r3 == 0) goto L_0x00c6
            return r6
        L_0x00c6:
            long r1 = -r6
            return r1
        L_0x00c8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.c.bYp():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008e, code lost:
        r15.kih = r6.bYA();
        okio.o.b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        if (r1 != false) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long bYq() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a7
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            okio.n r6 = r15.kih
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0013:
            if (r8 >= r9) goto L_0x008c
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003b
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
            int r11 = r11 + 10
            goto L_0x003b
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0070
            r11 = 70
            if (r10 > r11) goto L_0x0070
            int r11 = r10 + -65
            int r11 = r11 + 10
        L_0x003b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004b
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004b:
            okio.c r0 = new okio.c
            r0.<init>()
            okio.c r0 = r0.fG(r4)
            okio.c r0 = r0.Nu(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.bYr()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0070:
            if (r0 == 0) goto L_0x0074
            r1 = 1
            goto L_0x008c
        L_0x0074:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008c:
            if (r8 != r9) goto L_0x0098
            okio.n r7 = r6.bYA()
            r15.kih = r7
            okio.o.b(r6)
            goto L_0x009a
        L_0x0098:
            r6.pos = r8
        L_0x009a:
            if (r1 != 0) goto L_0x00a0
            okio.n r6 = r15.kih
            if (r6 != 0) goto L_0x000b
        L_0x00a0:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        L_0x00a7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.c.bYq():long");
    }

    public final ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    public final ByteString fx(long j) throws EOFException {
        return new ByteString(fB(j));
    }

    public final void a(c cVar, long j) throws EOFException {
        if (this.size >= j) {
            cVar.write(this, j);
        } else {
            cVar.write(this, this.size);
            throw new EOFException();
        }
    }

    public final long a(p pVar) throws IOException {
        long j = this.size;
        if (j > 0) {
            pVar.write(this, j);
        }
        return j;
    }

    public final String bYr() {
        try {
            return a(this.size, s.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String fy(long j) throws EOFException {
        return a(j, s.UTF_8);
    }

    public final String a(Charset charset) {
        try {
            return a(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    private String a(long j, Charset charset) throws EOFException {
        s.checkOffsetAndCount(this.size, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            n nVar = this.kih;
            if (((long) nVar.pos) + j > ((long) nVar.limit)) {
                return new String(fB(j), charset);
            }
            String str = new String(nVar.data, nVar.pos, (int) j, charset);
            nVar.pos = (int) (((long) nVar.pos) + j);
            this.size -= j;
            if (nVar.pos == nVar.limit) {
                this.kih = nVar.bYA();
                o.b(nVar);
            }
            return str;
        }
    }

    public final String bYs() throws EOFException {
        return fz(Long.MAX_VALUE);
    }

    public final String fz(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a2 = a((byte) 10, 0, j2);
            if (a2 != -1) {
                return fA(a2);
            }
            if (j2 < this.size && fw(j2 - 1) == 13 && fw(j2) == 10) {
                return fA(j2);
            }
            c cVar = new c();
            a(cVar, 0, Math.min(32, this.size));
            throw new EOFException("\\n not found: limit=" + Math.min(this.size, j) + " content=" + cVar.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    /* access modifiers changed from: package-private */
    public final String fA(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (fw(j2) == 13) {
                String fy = fy(j2);
                fC(2);
                return fy;
            }
        }
        String fy2 = fy(j);
        fC(1);
        return fy2;
    }

    public final byte[] readByteArray() {
        try {
            return fB(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] fB(long j) throws EOFException {
        s.checkOffsetAndCount(this.size, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public final void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        s.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        n nVar = this.kih;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(i2, nVar.limit - nVar.pos);
        System.arraycopy(nVar.data, nVar.pos, bArr, i, min);
        nVar.pos += min;
        this.size -= (long) min;
        if (nVar.pos == nVar.limit) {
            this.kih = nVar.bYA();
            o.b(nVar);
        }
        return min;
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        n nVar = this.kih;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), nVar.limit - nVar.pos);
        byteBuffer.put(nVar.data, nVar.pos, min);
        nVar.pos += min;
        this.size -= (long) min;
        if (nVar.pos == nVar.limit) {
            this.kih = nVar.bYA();
            o.b(nVar);
        }
        return min;
    }

    public final void clear() {
        try {
            fC(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void fC(long j) throws EOFException {
        while (j > 0) {
            if (this.kih != null) {
                int min = (int) Math.min(j, (long) (this.kih.limit - this.kih.pos));
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                this.kih.pos += min;
                if (this.kih.pos == this.kih.limit) {
                    n nVar = this.kih;
                    this.kih = nVar.bYA();
                    o.b(nVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public final c d(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: GX */
    public final c GY(String str) {
        return t(str, 0, str.length());
    }

    public final c t(String str, int i, int i2) {
        char c2;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    n Nr = Nr(1);
                    byte[] bArr = Nr.data;
                    int i3 = Nr.limit - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i5 = (i3 + i) - Nr.limit;
                            Nr.limit += i5;
                            this.size += (long) i5;
                        } else {
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                    }
                    int i52 = (i3 + i) - Nr.limit;
                    Nr.limit += i52;
                    this.size += (long) i52;
                } else if (charAt2 < 2048) {
                    Nu((charAt2 >> 6) | VPNException.HYDRA_DCN_BLOCKED_ABUSE);
                    Nu((charAt2 & '?') | 128);
                    i++;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    Nu((charAt2 >> 12) | 224);
                    Nu(((charAt2 >> 6) & 63) | 128);
                    Nu((charAt2 & '?') | 128);
                    i++;
                } else {
                    int i6 = i + 1;
                    if (i6 < i2) {
                        c2 = str.charAt(i6);
                    } else {
                        c2 = 0;
                    }
                    if (charAt2 > 56319 || c2 < 56320 || c2 > 57343) {
                        Nu(63);
                        i = i6;
                    } else {
                        int i7 = (((charAt2 & 10239) << 10) | (9215 & c2)) + 0;
                        Nu((i7 >> 18) | 240);
                        Nu(((i7 >> 12) & 63) | 128);
                        Nu(((i7 >> 6) & 63) | 128);
                        Nu((i7 & 63) | 128);
                        i += 2;
                    }
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public final c Nn(int i) {
        if (i < 128) {
            Nu(i);
        } else if (i < 2048) {
            Nu((i >> 6) | VPNException.HYDRA_DCN_BLOCKED_ABUSE);
            Nu((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                Nu((i >> 12) | 224);
                Nu(((i >> 6) & 63) | 128);
                Nu((i & 63) | 128);
            } else {
                Nu(63);
            }
        } else if (i <= 1114111) {
            Nu((i >> 18) | 240);
            Nu(((i >> 12) & 63) | 128);
            Nu(((i >> 6) & 63) | 128);
            Nu((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public final c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(s.UTF_8)) {
            return t(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return c(bytes, 0, bytes.length);
        }
    }

    /* renamed from: L */
    public final c M(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public final c c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            s.checkOffsetAndCount((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                n Nr = Nr(1);
                int min = Math.min(i3 - i, 8192 - Nr.limit);
                System.arraycopy(bArr, i, Nr.data, Nr.limit, min);
                i += min;
                Nr.limit += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                n Nr = Nr(1);
                int min = Math.min(i, 8192 - Nr.limit);
                byteBuffer.get(Nr.data, Nr.limit, min);
                i -= min;
                Nr.limit += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final long a(q qVar) throws IOException {
        if (qVar != null) {
            long j = 0;
            while (true) {
                long read = qVar.read(this, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: No */
    public final c Nu(int i) {
        n Nr = Nr(1);
        byte[] bArr = Nr.data;
        int i2 = Nr.limit;
        Nr.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    /* renamed from: Np */
    public final c Nt(int i) {
        n Nr = Nr(2);
        byte[] bArr = Nr.data;
        int i2 = Nr.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        Nr.limit = i3 + 1;
        this.size += 2;
        return this;
    }

    /* renamed from: Nq */
    public final c Ns(int i) {
        n Nr = Nr(4);
        byte[] bArr = Nr.data;
        int i2 = Nr.limit;
        int i3 = i2 + 1;
        bArr[i2] = i >> 24;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i5] = (byte) i;
        Nr.limit = i5 + 1;
        this.size += 4;
        return this;
    }

    public final c fD(long j) {
        n Nr = Nr(8);
        byte[] bArr = Nr.data;
        int i = Nr.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        Nr.limit = i8 + 1;
        this.size += 8;
        return this;
    }

    /* renamed from: fE */
    public final c fH(long j) {
        if (j == 0) {
            return Nu(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return GY("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        n Nr = Nr(i);
        byte[] bArr = Nr.data;
        int i2 = Nr.limit + i;
        while (j != 0) {
            i2--;
            bArr[i2] = kig[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        Nr.limit += i;
        this.size += (long) i;
        return this;
    }

    /* renamed from: fF */
    public final c fG(long j) {
        if (j == 0) {
            return Nu(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        n Nr = Nr(numberOfTrailingZeros);
        byte[] bArr = Nr.data;
        int i = Nr.limit;
        for (int i2 = (Nr.limit + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = kig[(int) (15 & j)];
            j >>>= 4;
        }
        Nr.limit += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final n Nr(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.kih == null) {
            this.kih = o.bYB();
            n nVar = this.kih;
            n nVar2 = this.kih;
            n nVar3 = this.kih;
            nVar2.kiA = nVar3;
            nVar.kiz = nVar3;
            return nVar3;
        } else {
            n nVar4 = this.kih.kiA;
            return (nVar4.limit + i > 8192 || !nVar4.kiy) ? nVar4.a(o.bYB()) : nVar4;
        }
    }

    public final void write(c cVar, long j) {
        n nVar;
        int i;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            s.checkOffsetAndCount(cVar.size, 0, j);
            while (j > 0) {
                int i2 = 0;
                if (j < ((long) (cVar.kih.limit - cVar.kih.pos))) {
                    n nVar2 = this.kih != null ? this.kih.kiA : null;
                    if (nVar2 != null && nVar2.kiy) {
                        long j2 = ((long) nVar2.limit) + j;
                        if (nVar2.kix) {
                            i = 0;
                        } else {
                            i = nVar2.pos;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            cVar.kih.a(nVar2, (int) j);
                            cVar.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    n nVar3 = cVar.kih;
                    int i3 = (int) j;
                    if (i3 <= 0 || i3 > nVar3.limit - nVar3.pos) {
                        throw new IllegalArgumentException();
                    }
                    if (i3 >= 1024) {
                        nVar = nVar3.bYy();
                    } else {
                        nVar = o.bYB();
                        System.arraycopy(nVar3.data, nVar3.pos, nVar.data, 0, i3);
                    }
                    nVar.limit = nVar.pos + i3;
                    nVar3.pos += i3;
                    nVar3.kiA.a(nVar);
                    cVar.kih = nVar;
                }
                n nVar4 = cVar.kih;
                long j3 = (long) (nVar4.limit - nVar4.pos);
                cVar.kih = nVar4.bYA();
                if (this.kih == null) {
                    this.kih = nVar4;
                    n nVar5 = this.kih;
                    n nVar6 = this.kih;
                    n nVar7 = this.kih;
                    nVar6.kiA = nVar7;
                    nVar5.kiz = nVar7;
                } else {
                    n a2 = this.kih.kiA.a(nVar4);
                    if (a2.kiA == a2) {
                        throw new IllegalStateException();
                    } else if (a2.kiA.kiy) {
                        int i4 = a2.limit - a2.pos;
                        int i5 = 8192 - a2.kiA.limit;
                        if (!a2.kiA.kix) {
                            i2 = a2.kiA.pos;
                        }
                        if (i4 <= i5 + i2) {
                            a2.a(a2.kiA, i4);
                            a2.bYA();
                            o.b(a2);
                        }
                    }
                }
                cVar.size -= j3;
                this.size += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public final long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.size == 0) {
            return -1;
        } else {
            if (j > this.size) {
                j = this.size;
            }
            cVar.write(this, j);
            return j;
        }
    }

    public final long bYt() {
        return a((byte) 0, 0, Long.MAX_VALUE);
    }

    public final long a(byte b2, long j, long j2) {
        n nVar;
        long j3;
        long j4 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)}));
        }
        if (j2 > this.size) {
            j2 = this.size;
        }
        if (j == j2 || (nVar = this.kih) == null) {
            return -1;
        }
        if (this.size - j >= j) {
            while (true) {
                long j5 = ((long) (nVar.limit - nVar.pos)) + j3;
                if (j5 >= j) {
                    break;
                }
                nVar = nVar.kiz;
                j4 = j5;
            }
        } else {
            j3 = this.size;
            while (j3 > j) {
                nVar = nVar.kiA;
                j3 -= (long) (nVar.limit - nVar.pos);
            }
        }
        while (j3 < j2) {
            byte[] bArr = nVar.data;
            int min = (int) Math.min((long) nVar.limit, (((long) nVar.pos) + j2) - j3);
            for (int i = (int) ((((long) nVar.pos) + j) - j3); i < min; i++) {
                if (bArr[i] == b2) {
                    return ((long) (i - nVar.pos)) + j3;
                }
            }
            j = ((long) (nVar.limit - nVar.pos)) + j3;
            nVar = nVar.kiz;
            j3 = j;
        }
        return -1;
    }

    public final boolean c(ByteString byteString) {
        int size2 = byteString.size();
        if (size2 < 0 || this.size < ((long) size2) || byteString.size() < size2) {
            return false;
        }
        for (int i = 0; i < size2; i++) {
            if (fw(((long) i) + 0) != byteString.getByte(i)) {
                return false;
            }
        }
        return true;
    }

    public final r timeout() {
        return r.NONE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.size != cVar.size) {
            return false;
        }
        long j = 0;
        if (this.size == 0) {
            return true;
        }
        n nVar = this.kih;
        n nVar2 = cVar.kih;
        int i = nVar.pos;
        int i2 = nVar2.pos;
        while (j < this.size) {
            long min = (long) Math.min(nVar.limit - i, nVar2.limit - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (nVar.data[i4] != nVar2.data[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == nVar.limit) {
                nVar = nVar.kiz;
                i = nVar.pos;
            } else {
                i = i4;
            }
            if (i3 == nVar2.limit) {
                nVar2 = nVar2.kiz;
                i2 = nVar2.pos;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public final int hashCode() {
        n nVar = this.kih;
        if (nVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = nVar.limit;
            for (int i3 = nVar.pos; i3 < i2; i3++) {
                i = (i * 31) + nVar.data[i3];
            }
            nVar = nVar.kiz;
        } while (nVar != this.kih);
        return i;
    }

    /* renamed from: bYu */
    public final c clone() {
        c cVar = new c();
        if (this.size == 0) {
            return cVar;
        }
        cVar.kih = this.kih.bYy();
        n nVar = cVar.kih;
        n nVar2 = cVar.kih;
        n nVar3 = cVar.kih;
        nVar2.kiA = nVar3;
        nVar.kiz = nVar3;
        n nVar4 = this.kih;
        while (true) {
            nVar4 = nVar4.kiz;
            if (nVar4 != this.kih) {
                cVar.kih.kiA.a(nVar4.bYy());
            } else {
                cVar.size = this.size;
                return cVar;
            }
        }
    }

    public final a a(a aVar) {
        if (aVar.buffer == null) {
            aVar.buffer = this;
            aVar.kij = true;
            return aVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public static final class a implements Closeable {
        public c buffer;
        public byte[] data;
        public int end = -1;
        public boolean kij;
        private n kik;
        public long offset = -1;
        public int start = -1;

        public final int fI(long j) {
            n nVar;
            long j2;
            if (j < -1 || j > this.buffer.size) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.buffer.size)}));
            } else if (j == -1 || j == this.buffer.size) {
                this.kik = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            } else {
                long j3 = 0;
                long j4 = this.buffer.size;
                n nVar2 = this.buffer.kih;
                n nVar3 = this.buffer.kih;
                if (this.kik != null) {
                    long j5 = this.offset - ((long) (this.start - this.kik.pos));
                    if (j5 > j) {
                        nVar3 = this.kik;
                        j4 = j5;
                    } else {
                        nVar2 = this.kik;
                        j3 = j5;
                    }
                }
                if (j4 - j > j - j3) {
                    while (j >= ((long) (nVar.limit - nVar.pos)) + j2) {
                        j3 = j2 + ((long) (nVar.limit - nVar.pos));
                        nVar2 = nVar.kiz;
                    }
                } else {
                    j2 = j4;
                    nVar = nVar3;
                    while (j2 > j) {
                        nVar = nVar.kiA;
                        j2 -= (long) (nVar.limit - nVar.pos);
                    }
                }
                if (this.kij && nVar.kix) {
                    n bYz = nVar.bYz();
                    if (this.buffer.kih == nVar) {
                        this.buffer.kih = bYz;
                    }
                    nVar = nVar.a(bYz);
                    nVar.kiA.bYA();
                }
                this.kik = nVar;
                this.offset = j;
                this.data = nVar.data;
                this.start = nVar.pos + ((int) (j - j2));
                this.end = nVar.limit;
                return this.end - this.start;
            }
        }

        public final void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.kik = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    public final long b(ByteString byteString) {
        long j;
        n nVar = this.kih;
        if (nVar == null) {
            return -1;
        }
        long j2 = 0;
        if (this.size >= 0) {
            long j3 = 0;
            while (true) {
                long j4 = ((long) (nVar.limit - nVar.pos)) + j;
                if (j4 >= 0) {
                    break;
                }
                nVar = nVar.kiz;
                j3 = j4;
            }
        } else {
            j = this.size;
            while (j > 0) {
                nVar = nVar.kiA;
                j -= (long) (nVar.limit - nVar.pos);
            }
        }
        if (byteString.size() == 2) {
            byte b2 = byteString.getByte(0);
            byte b3 = byteString.getByte(1);
            while (j < this.size) {
                byte[] bArr = nVar.data;
                int i = nVar.limit;
                for (int i2 = (int) ((((long) nVar.pos) + j2) - j); i2 < i; i2++) {
                    byte b4 = bArr[i2];
                    if (b4 == b2 || b4 == b3) {
                        return ((long) (i2 - nVar.pos)) + j;
                    }
                }
                j2 = ((long) (nVar.limit - nVar.pos)) + j;
                nVar = nVar.kiz;
                j = j2;
            }
            return -1;
        }
        byte[] internalArray = byteString.internalArray();
        while (j < this.size) {
            byte[] bArr2 = nVar.data;
            int i3 = nVar.limit;
            for (int i4 = (int) ((((long) nVar.pos) + j2) - j); i4 < i3; i4++) {
                byte b5 = bArr2[i4];
                for (byte b6 : internalArray) {
                    if (b5 == b6) {
                        return ((long) (i4 - nVar.pos)) + j;
                    }
                }
            }
            j2 = ((long) (nVar.limit - nVar.pos)) + j;
            nVar = nVar.kiz;
            j = j2;
        }
        return -1;
    }

    public final String toString() {
        ByteString byteString;
        if (this.size <= 2147483647L) {
            int i = (int) this.size;
            if (i == 0) {
                byteString = ByteString.EMPTY;
            } else {
                byteString = new SegmentedByteString(this, i);
            }
            return byteString.toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }
}
    
