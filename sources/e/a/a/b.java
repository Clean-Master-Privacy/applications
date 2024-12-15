    package e.a.a;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public final class b extends Thread {
    private String jNT = null;
    private BufferedReader jNU = null;
    private List<String> jNV = null;

    public b(String str, InputStream inputStream, List<String> list) {
        this.jNT = str;
        this.jNU = new BufferedReader(new InputStreamReader(inputStream));
        this.jNV = list;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0022 A[SYNTHETIC, Splitter:B:6:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
        L_0x0000:
            java.io.BufferedReader r0 = r5.jNU     // Catch:{ IOException -> 0x0022 }
            java.lang.String r0 = r0.readLine()     // Catch:{ IOException -> 0x0022 }
            if (r0 == 0) goto L_0x0022
            java.lang.String r1 = "[%s] %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0022 }
            r3 = 0
            java.lang.String r4 = r5.jNT     // Catch:{ IOException -> 0x0022 }
            r2[r3] = r4     // Catch:{ IOException -> 0x0022 }
            r3 = 1
            r2[r3] = r0     // Catch:{ IOException -> 0x0022 }
            java.lang.String.format(r1, r2)     // Catch:{ IOException -> 0x0022 }
            java.util.List<java.lang.String> r1 = r5.jNV     // Catch:{ IOException -> 0x0022 }
            if (r1 == 0) goto L_0x0000
            java.util.List<java.lang.String> r1 = r5.jNV     // Catch:{ IOException -> 0x0022 }
            r1.add(r0)     // Catch:{ IOException -> 0x0022 }
            goto L_0x0000
        L_0x0022:
            java.io.BufferedReader r0 = r5.jNU     // Catch:{ IOException -> 0x0028 }
            r0.close()     // Catch:{ IOException -> 0x0028 }
            return
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.b.run():void");
    }
}
    
