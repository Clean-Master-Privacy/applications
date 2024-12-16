    package okhttp3.internal.http2;

import java.io.IOException;

public abstract class Http2Connection$Listener {
    public static final Http2Connection$Listener REFUSE_INCOMING_STREAMS = new 1();

    public void onSettings(Http2Connection http2Connection) {
    }

    public abstract void onStream(Http2Stream http2Stream) throws IOException;
}
    
