    package okhttp3.internal.cache;

import java.io.IOException;
import okio.p;

public interface CacheRequest {
    void abort();

    p body() throws IOException;
}
    
