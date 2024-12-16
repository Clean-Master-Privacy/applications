    package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface e extends ReadableByteChannel, q {
    long a(p pVar) throws IOException;

    String a(Charset charset) throws IOException;

    void a(c cVar, long j) throws IOException;

    c bYi();

    boolean bYk() throws IOException;

    InputStream bYl();

    short bYn() throws IOException;

    int bYo() throws IOException;

    long bYp() throws IOException;

    long bYq() throws IOException;

    String bYs() throws IOException;

    long bYt() throws IOException;

    boolean c(ByteString byteString) throws IOException;

    byte[] fB(long j) throws IOException;

    void fC(long j) throws IOException;

    void fu(long j) throws IOException;

    boolean fv(long j) throws IOException;

    ByteString fx(long j) throws IOException;

    String fz(long j) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;
}
    
