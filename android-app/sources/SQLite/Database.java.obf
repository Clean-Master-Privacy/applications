package SQLite;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class Database
{
  static
  {
    try
    {
      String str1 = System.getProperty("SQLite.library.path");
      if (str1 != null)
      {
        int i = str1.length();
        if (i != 0) {
          try
          {
            String str2 = (String)System.class.getMethod("mapLibraryName", new Class[] { String.class }).invoke(null, new Object[] { "sqlite_jni" });
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append(File.separator);
            ((StringBuilder)localObject).append(str2);
            System.load(((StringBuilder)localObject).toString());
            return;
          }
          catch (Throwable localThrowable2)
          {
            localObject = System.err;
            StringBuilder localStringBuilder = new StringBuilder("Unable to load sqlite_jni fromSQLite.library.path=");
            localStringBuilder.append(str1);
            localStringBuilder.append(", trying system default: ");
            localStringBuilder.append(localThrowable2);
            ((PrintStream)localObject).println(localStringBuilder.toString());
            System.loadLibrary("sqlite_jni");
            return;
          }
        }
      }
      System.loadLibrary("sqlite_jni");
      return;
    }
    catch (Throwable localThrowable1)
    {
      PrintStream localPrintStream = System.err;
      Object localObject = new StringBuilder("Unable to load sqlite_jni: ");
      ((StringBuilder)localObject).append(localThrowable1);
      localPrintStream.println(((StringBuilder)localObject).toString());
    }
  }
  
  public Database() {}
  
  public static native String version();
}
