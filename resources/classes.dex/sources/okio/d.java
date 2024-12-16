    package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public interface d extends WritableByteChannel, p {
    d GY(String str) throws IOException;

    d M(byte[] bArr) throws IOException;

    d Ns(int i) throws IOException;

    d Nt(int i) throws IOException;

    d Nu(int i) throws IOException;

    long a(q qVar) throws IOException;

    c bYi();

    d bYj() throws IOException;

    d bYv() throws IOException;

    d c(byte[] bArr, int i, int i2) throws IOException;

    d d(ByteString byteString) throws IOException;

    d fG(long j) throws IOException;

    d fH(long j) throws IOException;

    void flush() throws IOException;
}
    
