    package defpackage;

import java.net.Socket;

/* renamed from: a  reason: default package */
final class a implements Runnable {
    private final Socket jPL;
    private final jnamed jPM;

    a(jnamed jnamed, Socket socket) {
        this.jPM = jnamed;
        this.jPL = socket;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = jnamed.I(r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            jnamed r0 = r6.jPM
            java.net.Socket r1 = r6.jPL
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ IOException -> 0x0041 }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ IOException -> 0x0041 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0041 }
            int r2 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0041 }
            byte[] r4 = new byte[r2]     // Catch:{ IOException -> 0x0041 }
            r3.readFully(r4)     // Catch:{ IOException -> 0x0041 }
            org.xbill.DNS.Message r3 = new org.xbill.DNS.Message     // Catch:{ IOException -> 0x0026 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0026 }
            byte[] r0 = r0.a(r3, r4, r2, r1)     // Catch:{ IOException -> 0x0026 }
            if (r0 != 0) goto L_0x002a
            r1.close()     // Catch:{ IOException -> 0x0025 }
            return
        L_0x0025:
            return
        L_0x0026:
            byte[] r0 = jnamed.I(r4)     // Catch:{ IOException -> 0x0041 }
        L_0x002a:
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0041 }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ IOException -> 0x0041 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0041 }
            int r3 = r0.length     // Catch:{ IOException -> 0x0041 }
            r2.writeShort(r3)     // Catch:{ IOException -> 0x0041 }
            r2.write(r0)     // Catch:{ IOException -> 0x0041 }
            r1.close()     // Catch:{ IOException -> 0x003e }
            return
        L_0x003e:
            return
        L_0x003f:
            r0 = move-exception
            goto L_0x006e
        L_0x0041:
            r0 = move-exception
            java.io.PrintStream r2 = java.lang.System.out     // Catch:{ all -> 0x003f }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ all -> 0x003f }
            java.lang.String r4 = "TCPclient("
            r3.<init>(r4)     // Catch:{ all -> 0x003f }
            java.net.InetAddress r4 = r1.getLocalAddress()     // Catch:{ all -> 0x003f }
            int r5 = r1.getLocalPort()     // Catch:{ all -> 0x003f }
            java.lang.String r4 = jnamed.c(r4, r5)     // Catch:{ all -> 0x003f }
            r3.append(r4)     // Catch:{ all -> 0x003f }
            java.lang.String r4 = "): "
            r3.append(r4)     // Catch:{ all -> 0x003f }
            r3.append(r0)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x003f }
            r2.println(r0)     // Catch:{ all -> 0x003f }
            r1.close()     // Catch:{ IOException -> 0x006d }
            return
        L_0x006d:
            return
        L_0x006e:
            r1.close()     // Catch:{ IOException -> 0x0071 }
        L_0x0071:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a.run():void");
    }
}
    
