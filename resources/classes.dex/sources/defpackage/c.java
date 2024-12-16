    package defpackage;

import java.net.InetAddress;

/* renamed from: c  reason: default package */
final class c implements Runnable {
    private final jnamed jPM;
    private final InetAddress jPN;
    private final int jPO;

    c(jnamed jnamed, InetAddress inetAddress, int i) {
        this.jPM = jnamed;
        this.jPN = inetAddress;
        this.jPO = i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r9 = jnamed.I(r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            jnamed r0 = r13.jPM
            java.net.InetAddress r1 = r13.jPN
            int r2 = r13.jPO
            java.net.DatagramSocket r3 = new java.net.DatagramSocket     // Catch:{ IOException -> 0x005a }
            r3.<init>(r2, r1)     // Catch:{ IOException -> 0x005a }
            r4 = 512(0x200, float:7.175E-43)
            byte[] r5 = new byte[r4]     // Catch:{ IOException -> 0x005a }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ IOException -> 0x005a }
            r6.<init>(r5, r4)     // Catch:{ IOException -> 0x005a }
            r7 = 0
            r8 = r7
        L_0x0016:
            r6.setLength(r4)     // Catch:{ IOException -> 0x005a }
            r3.receive(r6)     // Catch:{ InterruptedIOException -> 0x0016 }
            org.xbill.DNS.Message r9 = new org.xbill.DNS.Message     // Catch:{ IOException -> 0x002c }
            r9.<init>(r5)     // Catch:{ IOException -> 0x002c }
            int r10 = r6.getLength()     // Catch:{ IOException -> 0x002c }
            byte[] r9 = r0.a(r9, r5, r10, r7)     // Catch:{ IOException -> 0x002c }
            if (r9 != 0) goto L_0x0030
            goto L_0x0016
        L_0x002c:
            byte[] r9 = jnamed.I(r5)     // Catch:{ IOException -> 0x005a }
        L_0x0030:
            if (r8 != 0) goto L_0x0041
            java.net.DatagramPacket r8 = new java.net.DatagramPacket     // Catch:{ IOException -> 0x005a }
            int r10 = r9.length     // Catch:{ IOException -> 0x005a }
            java.net.InetAddress r11 = r6.getAddress()     // Catch:{ IOException -> 0x005a }
            int r12 = r6.getPort()     // Catch:{ IOException -> 0x005a }
            r8.<init>(r9, r10, r11, r12)     // Catch:{ IOException -> 0x005a }
            goto L_0x0056
        L_0x0041:
            r8.setData(r9)     // Catch:{ IOException -> 0x005a }
            int r9 = r9.length     // Catch:{ IOException -> 0x005a }
            r8.setLength(r9)     // Catch:{ IOException -> 0x005a }
            java.net.InetAddress r9 = r6.getAddress()     // Catch:{ IOException -> 0x005a }
            r8.setAddress(r9)     // Catch:{ IOException -> 0x005a }
            int r9 = r6.getPort()     // Catch:{ IOException -> 0x005a }
            r8.setPort(r9)     // Catch:{ IOException -> 0x005a }
        L_0x0056:
            r3.send(r8)     // Catch:{ IOException -> 0x005a }
            goto L_0x0016
        L_0x005a:
            r0 = move-exception
            java.io.PrintStream r3 = java.lang.System.out
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            java.lang.String r5 = "serveUDP("
            r4.<init>(r5)
            java.lang.String r1 = jnamed.c(r1, r2)
            r4.append(r1)
            java.lang.String r1 = "): "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.println(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c.run():void");
    }
}
    
