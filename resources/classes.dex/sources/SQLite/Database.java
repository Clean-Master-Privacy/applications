    package SQLite;

import java.io.File;
import java.io.PrintStream;

public class Database {
    public static native String version();

    static {
        String property;
        try {
            property = System.getProperty("SQLite.library.path");
            if (property == null || property.length() == 0) {
                System.loadLibrary("sqlite_jni");
                return;
            }
            System.load(property + File.separator + ((String) System.class.getMethod("mapLibraryName", new Class[]{String.class}).invoke((Object) null, new Object[]{"sqlite_jni"})));
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            printStream.println("Unable to load sqlite_jni: " + th);
        }
    }
}
    
