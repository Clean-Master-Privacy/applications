    package e.a.a;

import com.huawei.openalliance.ad.constant.af;
import java.util.List;

public final class a {
    protected static String[] jNS = {"echo -BOC-", af.R};

    /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|(2:4|5)|23|6|7|8|9|10|11|12|13|14|(1:19)|20|22) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x00ac */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x00a6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> p(java.lang.String r14, java.lang.String[] r15) {
        /*
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r0 = r14.toUpperCase(r0)
            java.lang.String r1 = "[%s%%] START"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r0
            java.lang.String.format(r1, r3)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = java.util.Collections.synchronizedList(r1)
            r3 = 0
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.Process r5 = r5.exec(r14, r3)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.io.OutputStream r7 = r5.getOutputStream()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r6.<init>(r7)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            e.a.a.b r7 = new e.a.a.b     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r8.<init>()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r8.append(r0)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String r9 = "-"
            r8.append(r9)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.io.InputStream r9 = r5.getInputStream()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r7.<init>(r8, r9, r1)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            e.a.a.b r8 = new e.a.a.b     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r9.<init>()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r9.append(r0)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String r10 = "*"
            r9.append(r10)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.io.InputStream r10 = r5.getErrorStream()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r8.<init>(r9, r10, r3)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r7.start()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r8.start()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            int r9 = r15.length     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r10 = 0
        L_0x0068:
            if (r10 >= r9) goto L_0x0098
            r11 = r15[r10]     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String r12 = "[%s+] %s"
            r13 = 2
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r13[r4] = r0     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r13[r2] = r11     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String.format(r12, r13)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r12.<init>()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r12.append(r11)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String r11 = "\n"
            r12.append(r11)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String r11 = r12.toString()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            java.lang.String r12 = "UTF-8"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r6.write(r11)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r6.flush()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            int r10 = r10 + 1
            goto L_0x0068
        L_0x0098:
            java.lang.String r15 = "exit\n"
            java.lang.String r0 = "UTF-8"
            byte[] r15 = r15.getBytes(r0)     // Catch:{ IOException -> 0x00a6 }
            r6.write(r15)     // Catch:{ IOException -> 0x00a6 }
            r6.flush()     // Catch:{ IOException -> 0x00a6 }
        L_0x00a6:
            r5.waitFor()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r6.close()     // Catch:{ IOException -> 0x00ac }
        L_0x00ac:
            r7.join()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r8.join()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r5.destroy()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            boolean r15 = e.a.a.a.C0451a.Gd(r14)     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            if (r15 == 0) goto L_0x00c4
            int r15 = r5.exitValue()     // Catch:{ IOException | InterruptedException -> 0x00c5 }
            r0 = 255(0xff, float:3.57E-43)
            if (r15 != r0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r3 = r1
        L_0x00c5:
            java.lang.String r15 = "[%s%%] END"
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r14 = r14.toUpperCase(r1)
            r0[r4] = r14
            java.lang.String.format(r15, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.a.p(java.lang.String, java.lang.String[]):java.util.List");
    }

    protected static boolean fo(List<String> list) {
        if (list == null) {
            return false;
        }
        boolean z = false;
        for (String next : list) {
            if (next.contains("uid=")) {
                if (next.contains("uid=0")) {
                    return true;
                }
                return false;
            } else if (next.contains("-BOC-")) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: e.a.a.a$a  reason: collision with other inner class name */
    public static class C0451a {
        static {
            String[] strArr = {null, null};
        }

        public static List<String> w(String[] strArr) {
            return a.p("su", strArr);
        }

        public static boolean bTK() {
            return a.fo(a.p("su", a.jNS));
        }

        public static boolean Gd(String str) {
            int indexOf = str.indexOf(32);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf >= 0) {
                str = str.substring(lastIndexOf + 1);
            }
            return str.equals("su");
        }
    }
}
    
