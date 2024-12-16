    package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.ByteString;
import okio.d;
import okio.k;
import okio.q;

public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(d dVar) throws IOException;

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() {
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            public long contentLength() throws IOException {
                return (long) byteString.size();
            }

            public void writeTo(d dVar) throws IOException {
                dVar.d(byteString);
            }
        };
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return (long) i2;
                }

                public void writeTo(d dVar) throws IOException {
                    dVar.c(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return file.length();
                }

                public void writeTo(d dVar) throws IOException {
                    q qVar = null;
                    try {
                        q source = k.source(file);
                        try {
                            dVar.a(source);
                            Util.closeQuietly((Closeable) source);
                        } catch (Throwable th) {
                            th = th;
                            qVar = source;
                            Util.closeQuietly((Closeable) qVar);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Util.closeQuietly((Closeable) qVar);
                        throw th;
                    }
                }
            };
        }
        throw new NullPointerException("file == null");
    }
}
    
