    package okhttp3.internal.ws;

import java.io.IOException;
import okio.ByteString;

public interface WebSocketReader$FrameCallback {
    void onReadClose(int i, String str);

    void onReadMessage(String str) throws IOException;

    void onReadMessage(ByteString byteString) throws IOException;

    void onReadPing(ByteString byteString);

    void onReadPong(ByteString byteString);
}
    
