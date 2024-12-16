    package defpackage;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;

/* renamed from: b  reason: default package */
final class b implements Runnable {
    private final jnamed jPM;
    private final InetAddress jPN;
    private final int jPO;

    b(jnamed jnamed, InetAddress inetAddress, int i) {
        this.jPM = jnamed;
        this.jPN = inetAddress;
        this.jPO = i;
    }

    public final void run() {
        jnamed jnamed = this.jPM;
        InetAddress inetAddress = this.jPN;
        int i = this.jPO;
        try {
            while (true) {
                new Thread(new a(jnamed, new ServerSocket(i, 128, inetAddress).accept())).start();
            }
        } catch (IOException e) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer("serveTCP(");
            stringBuffer.append(jnamed.c(inetAddress, i));
            stringBuffer.append("): ");
            stringBuffer.append(e);
            printStream.println(stringBuffer.toString());
        }
    }
}
    
