    package defpackage;

import java.io.IOException;
import java.io.PrintStream;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;

/* renamed from: dig  reason: default package */
public class dig {
    private static int dclass = 1;
    private static Name name = null;
    private static int type = 1;

    private static void bTJ() {
        System.out.println("Usage: dig [@server] name [<type>] [<class>] [options]");
        System.exit(0);
    }

    private static void a(Message message) throws IOException {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer("; java dig 0.0 <> ");
        stringBuffer.append(name);
        stringBuffer.append(" axfr");
        printStream.println(stringBuffer.toString());
        if (message.isSigned()) {
            System.out.print(";; TSIG ");
            if (message.isVerified()) {
                System.out.println("ok");
            } else {
                System.out.println("failed");
            }
        }
        if (message.getRcode() != 0) {
            System.out.println(message);
            return;
        }
        Record[] sectionArray = message.getSectionArray(1);
        for (Record println : sectionArray) {
            System.out.println(println);
        }
        System.out.print(";; done (");
        System.out.print(message.getHeader().getCount(1));
        System.out.print(" records, ");
        System.out.print(message.getHeader().getCount(3));
        System.out.println(" additional)");
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r8) throws java.io.IOException {
        /*
            int r0 = r8.length
            if (r0 > 0) goto L_0x0006
            bTJ()
        L_0x0006:
            r0 = 0
            r1 = 0
            r2 = r8[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0153 }
            java.lang.String r3 = "@"
            boolean r2 = r2.startsWith(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0153 }
            r3 = 1
            if (r2 == 0) goto L_0x001b
            r2 = r8[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0153 }
            java.lang.String r2 = r2.substring(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0153 }
            r4 = 1
            goto L_0x001d
        L_0x001b:
            r2 = r0
            r4 = 0
        L_0x001d:
            if (r2 == 0) goto L_0x0026
            org.xbill.DNS.SimpleResolver r5 = new org.xbill.DNS.SimpleResolver     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0153 }
            r5.<init>(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0153 }
            r2 = r5
            goto L_0x002b
        L_0x0026:
            org.xbill.DNS.SimpleResolver r2 = new org.xbill.DNS.SimpleResolver     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0153 }
            r2.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0153 }
        L_0x002b:
            int r5 = r4 + 1
            r4 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            java.lang.String r6 = "-x"
            boolean r6 = r4.equals(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            if (r6 == 0) goto L_0x0049
            int r4 = r5 + 1
            r5 = r8[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            org.xbill.DNS.Name r5 = org.xbill.DNS.ReverseMap.fromAddress(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            name = r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            r5 = 12
            type = r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            dclass = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
        L_0x0047:
            r5 = 0
            goto L_0x0071
        L_0x0049:
            org.xbill.DNS.Name r6 = org.xbill.DNS.Name.root     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            org.xbill.DNS.Name r4 = org.xbill.DNS.Name.fromString(r4, r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            name = r4     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            r4 = r8[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            int r4 = org.xbill.DNS.Type.value(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            type = r4     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            if (r4 >= 0) goto L_0x005e
            type = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            goto L_0x0060
        L_0x005e:
            int r5 = r5 + 1
        L_0x0060:
            r4 = r5
            r5 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            int r5 = org.xbill.DNS.DClass.value(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            dclass = r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            if (r5 >= 0) goto L_0x006e
            dclass = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0154 }
            goto L_0x0047
        L_0x006e:
            int r4 = r4 + 1
            goto L_0x0047
        L_0x0071:
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r7 = "-"
            boolean r6 = r6.startsWith(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            if (r6 == 0) goto L_0x015c
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            int r6 = r6.length()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            if (r6 <= r3) goto L_0x015c
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            char r6 = r6.charAt(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            r7 = 2
            switch(r6) {
                case 98: goto L_0x011f;
                case 100: goto L_0x0118;
                case 101: goto L_0x00e4;
                case 105: goto L_0x00e0;
                case 107: goto L_0x00c4;
                case 112: goto L_0x0099;
                case 113: goto L_0x0096;
                case 116: goto L_0x0091;
                default: goto L_0x008d;
            }     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
        L_0x008d:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x0142
        L_0x0091:
            r2.setTCP(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x014e
        L_0x0096:
            r5 = 1
            goto L_0x014e
        L_0x0099:
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            int r6 = r6.length()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            if (r6 <= r7) goto L_0x00a8
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r6 = r6.substring(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x00ac
        L_0x00a8:
            int r4 = r4 + 1
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
        L_0x00ac:
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            if (r6 < 0) goto L_0x00bc
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 <= r7) goto L_0x00b7
            goto L_0x00bc
        L_0x00b7:
            r2.setPort(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x014e
        L_0x00bc:
            java.io.PrintStream r8 = java.lang.System.out     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r0 = "Invalid port"
            r8.println(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            return
        L_0x00c4:
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            int r6 = r6.length()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            if (r6 <= r7) goto L_0x00d3
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r6 = r6.substring(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x00d7
        L_0x00d3:
            int r4 = r4 + 1
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
        L_0x00d7:
            org.xbill.DNS.TSIG r6 = org.xbill.DNS.TSIG.fromString(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            r2.setTSIGKey(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x014e
        L_0x00e0:
            r2.setIgnoreTruncation(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x014e
        L_0x00e4:
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            int r6 = r6.length()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            if (r6 <= r7) goto L_0x00f3
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r6 = r6.substring(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x00f7
        L_0x00f3:
            int r4 = r4 + 1
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
        L_0x00f7:
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            if (r6 < 0) goto L_0x0104
            if (r6 <= r3) goto L_0x0100
            goto L_0x0104
        L_0x0100:
            r2.setEDNS(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x014e
        L_0x0104:
            java.io.PrintStream r8 = java.lang.System.out     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r1 = "Unsupported EDNS level: "
            r0.<init>(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            r0.append(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r0 = r0.toString()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            r8.println(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            return
        L_0x0118:
            r6 = 32768(0x8000, float:4.5918E-41)
            r2.setEDNS(r1, r1, r6, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x014e
        L_0x011f:
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            int r6 = r6.length()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            if (r6 <= r7) goto L_0x012e
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r6 = r6.substring(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x0132
        L_0x012e:
            int r4 = r4 + 1
            r6 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
        L_0x0132:
            java.net.InetAddress r6 = java.net.InetAddress.getByName(r6)     // Catch:{ Exception -> 0x013a }
            r2.setLocalAddress(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            goto L_0x014e
        L_0x013a:
            java.io.PrintStream r8 = java.lang.System.out     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.lang.String r0 = "Invalid address"
            r8.println(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            return
        L_0x0142:
            java.lang.String r7 = "Invalid option: "
            r6.print(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            r7 = r8[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
            r6.println(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0151 }
        L_0x014e:
            int r4 = r4 + r3
            goto L_0x0071
        L_0x0151:
            goto L_0x0155
        L_0x0153:
            r2 = r0
        L_0x0154:
            r5 = 0
        L_0x0155:
            org.xbill.DNS.Name r8 = name
            if (r8 != 0) goto L_0x015c
            bTJ()
        L_0x015c:
            if (r2 != 0) goto L_0x0163
            org.xbill.DNS.SimpleResolver r2 = new org.xbill.DNS.SimpleResolver
            r2.<init>()
        L_0x0163:
            org.xbill.DNS.Name r8 = name
            int r0 = type
            int r1 = dclass
            org.xbill.DNS.Record r8 = org.xbill.DNS.Record.newRecord(r8, r0, r1)
            org.xbill.DNS.Message r8 = org.xbill.DNS.Message.newQuery(r8)
            if (r5 == 0) goto L_0x0178
            java.io.PrintStream r0 = java.lang.System.out
            r0.println(r8)
        L_0x0178:
            long r0 = java.lang.System.currentTimeMillis()
            org.xbill.DNS.Message r8 = r2.send(r8)
            long r2 = java.lang.System.currentTimeMillis()
            int r4 = type
            r5 = 252(0xfc, float:3.53E-43)
            if (r4 != r5) goto L_0x018e
            a(r8)
            return
        L_0x018e:
            r4 = 0
            long r2 = r2 - r0
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = "; java dig 0.0"
            r0.println(r1)
            java.io.PrintStream r0 = java.lang.System.out
            r0.println(r8)
            java.io.PrintStream r8 = java.lang.System.out
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            java.lang.String r1 = ";; Query time: "
            r0.<init>(r1)
            r0.append(r2)
            java.lang.String r1 = " ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.println(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dig.main(java.lang.String[]):void");
    }
}
    
