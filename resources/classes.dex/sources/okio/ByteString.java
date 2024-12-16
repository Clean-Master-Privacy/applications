    package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY = of(new byte[0]);
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;

    ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString of(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            s.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new ByteString(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString of(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString encodeUtf8(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(s.UTF_8));
            byteString.utf8 = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new ByteString(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, s.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String base64() {
        return b.encode(this.data);
    }

    public ByteString md5() {
        return GZ("MD5");
    }

    public ByteString sha1() {
        return GZ("SHA-1");
    }

    public ByteString sha256() {
        return GZ("SHA-256");
    }

    public ByteString sha512() {
        return GZ("SHA-512");
    }

    private ByteString GZ(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        return a("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return a("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return a("HmacSHA512", byteString);
    }

    private ByteString a(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            return of(instance.doFinal(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public String base64Url() {
        return b.K(this.data);
    }

    @Nullable
    public static ByteString decodeBase64(String str) {
        if (str != null) {
            byte[] decode = b.decode(str);
            if (decode != null) {
                return new ByteString(decode);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public String hex() {
        char[] cArr = new char[(this.data.length << 1)];
        int i = 0;
        for (byte b2 : this.data) {
            int i2 = i + 1;
            cArr[i] = HEX_DIGITS[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = HEX_DIGITS[b2 & 15];
        }
        return new String(cArr);
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i << 1;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return of(bArr);
        } else {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
    }

    private static int decodeHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return (c2 - 'a') + 10;
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return (c2 - 'A') + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c2);
    }

    public static ByteString read(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i >= 0) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new ByteString(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b2 = this.data[i];
            if (b2 < 65 || b2 > 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                bArr[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b3 = bArr[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr[i2] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b2 = this.data[i];
            if (b2 < 97 || b2 > 122) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                bArr[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b3 = bArr[i2];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr[i2] = (byte) (b3 - 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public ByteString substring(int i) {
        return substring(i, this.data.length);
    }

    public ByteString substring(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 <= this.data.length) {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.data.length) {
                return this;
            } else {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.data, i, bArr, 0, i3);
                return new ByteString(bArr);
            }
        } else {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
        }
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    /* access modifiers changed from: package-private */
    public byte[] internalArray() {
        return this.data;
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.write(this.data);
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* access modifiers changed from: package-private */
    public void write(c cVar) {
        cVar.c(this.data, 0, this.data.length);
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.data, i, i3);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.data.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && s.a(this.data, i, bArr, i2, i3);
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.internalArray(), 0);
    }

    public final int indexOf(ByteString byteString, int i) {
        return indexOf(byteString.internalArray(), i);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public int indexOf(byte[] bArr, int i) {
        int length = this.data.length - bArr.length;
        for (int max = Math.max(i, 0); max <= length; max++) {
            if (s.a(this.data, max, bArr, 0, bArr.length)) {
                return max;
            }
        }
        return -1;
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.internalArray(), size());
    }

    public final int lastIndexOf(ByteString byteString, int i) {
        return lastIndexOf(byteString.internalArray(), i);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int lastIndexOf(byte[] bArr, int i) {
        for (int min = Math.min(i, this.data.length - bArr.length); min >= 0; min--) {
            if (s.a(this.data, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == this.data.length && byteString.rangeEquals(0, this.data, 0, this.data.length);
        }
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode2 = Arrays.hashCode(this.data);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            byte b2 = getByte(i) & 255;
            byte b3 = byteString.getByte(i) & 255;
            if (b2 != b3) {
                return b2 < b3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf82 = utf8();
        int codePointIndexToCharIndex = codePointIndexToCharIndex(utf82, 64);
        if (codePointIndexToCharIndex != -1) {
            String replace = utf82.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (codePointIndexToCharIndex < utf82.length()) {
                return "[size=" + this.data.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + "]";
        } else if (this.data.length <= 64) {
            return "[hex=" + hex() + "]";
        } else {
            return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
        }
    }

    static int codePointIndexToCharIndex(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
    
