package android.arch.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DefaultTaskExecutor */
public final class b extends c {
    private ExecutorService Y = Executors.newFixedThreadPool(2);
    private volatile Handler a_;
    private final Object mLock = new Object();

    public final void a(Runnable runnable) {
        this.Y.execute(runnable);
    }

    public final void b(Runnable runnable) {
        if (this.a_ == null) {
            synchronized (this.mLock) {
                if (this.a_ == null) {
                    this.a_ = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.a_.post(runnable);
    }

    public final boolean I() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
