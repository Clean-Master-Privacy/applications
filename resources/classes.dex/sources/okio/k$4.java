    package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

class k$4 extends a {
    private /* synthetic */ Socket kit;

    k$4(Socket socket) {
        this.kit = socket;
    }

    /* access modifiers changed from: protected */
    public final IOException newTimeoutException(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* access modifiers changed from: protected */
    public final void timedOut() {
        try {
            this.kit.close();
        } catch (Exception e) {
            Logger logger = k.logger;
            Level level = Level.WARNING;
            logger.log(level, "Failed to close timed out socket " + this.kit, e);
        } catch (AssertionError e2) {
            if (k.isAndroidGetsocknameError(e2)) {
                Logger logger2 = k.logger;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.kit, e2);
                return;
            }
            throw e2;
        }
    }
}
    
