    package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface p extends Closeable, Flushable {
    void close() throws IOException;

    void flush() throws IOException;

    r timeout();

    void write(c cVar, long j) throws IOException;
}
    
