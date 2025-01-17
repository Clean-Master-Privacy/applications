package android.arch.api.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
  extends f
{
  private ExecutorService executorService = Executors.newFixedThreadPool(2);
  private volatile Handler h;
  private final Object mLock = new Object();
  
  public a() {}
  
  public final void a(Runnable paramRunnable)
  {
    if (h == null)
    {
      Object localObject = mLock;
      try
      {
        if (h == null) {
          h = new Handler(Looper.getMainLooper());
        }
      }
      catch (Throwable paramRunnable)
      {
        throw paramRunnable;
      }
    }
    h.post(paramRunnable);
  }
  
  public final void close(Runnable paramRunnable)
  {
    executorService.execute(paramRunnable);
  }
  
  public final boolean close()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}
