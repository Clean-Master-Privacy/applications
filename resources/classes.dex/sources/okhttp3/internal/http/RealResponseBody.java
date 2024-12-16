    package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.e;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    @Nullable
    private final String contentTypeString;
    private final e source;

    public RealResponseBody(@Nullable String str, long j, e eVar) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = eVar;
    }

    public final MediaType contentType() {
        if (this.contentTypeString != null) {
            return MediaType.parse(this.contentTypeString);
        }
        return null;
    }

    public final long contentLength() {
        return this.contentLength;
    }

    public final e source() {
        return this.source;
    }
}
    
