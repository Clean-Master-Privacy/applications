package android.os.fake;

public class SystemProperties {
    public static String get(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (Exception unused) {
            return str2;
        }
    }

    public static long getLong(String str, long j) {
        try {
            return ((Long) Class.forName("android.os.SystemProperties").getMethod("getLong", new Class[]{String.class, Long.TYPE}).invoke((Object) null, new Object[]{str, Long.valueOf(j)})).longValue();
        } catch (Exception unused) {
            return j;
        }
    }
}
