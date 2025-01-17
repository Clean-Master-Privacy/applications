package android.arch.api.a;

public class b
  extends f
{
  private static volatile b a;
  private f b = new a();
  public f c = b;
  
  static
  {
    new ActivityChooserModel.SerialExecutor();
    new Threading.2();
  }
  
  private b() {}
  
  public static b a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void a(Runnable paramRunnable)
  {
    c.a(paramRunnable);
  }
  
  public final void close(Runnable paramRunnable)
  {
    c.close(paramRunnable);
  }
  
  public final boolean close()
  {
    return c.close();
  }
}
