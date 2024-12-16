    package okio;

import java.io.Closeable;
import java.io.IOException;

public interface q extends Closeable {
    void close() throws IOException;

    long read(c cVar, long j) throws IOException;

    r timeout();
}
    
