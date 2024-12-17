    package com.airbnb.lottie.c;

import com.airbnb.lottie.model.b;

public final class h implements af<b> {
    public static final h qG = new h();

    private h() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(android.util.JsonReader r21, float r22) throws java.io.IOException {
        /*
            r20 = this;
            r21.beginObject()
            r0 = 1
            r1 = 0
            r2 = 0
            r4 = 0
            r6 = r1
            r7 = r6
            r8 = r2
            r12 = r8
            r14 = r12
            r10 = 0
            r11 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 1
        L_0x0017:
            boolean r1 = r21.hasNext()
            if (r1 == 0) goto L_0x0111
            java.lang.String r1 = r21.nextName()
            r2 = -1
            int r3 = r1.hashCode()
            r5 = 102(0x66, float:1.43E-43)
            if (r3 == r5) goto L_0x00bc
            r5 = 106(0x6a, float:1.49E-43)
            if (r3 == r5) goto L_0x00b2
            r5 = 3261(0xcbd, float:4.57E-42)
            if (r3 == r5) goto L_0x00a8
            r5 = 3452(0xd7c, float:4.837E-42)
            if (r3 == r5) goto L_0x009e
            r5 = 3463(0xd87, float:4.853E-42)
            if (r3 == r5) goto L_0x0094
            r5 = 3543(0xdd7, float:4.965E-42)
            if (r3 == r5) goto L_0x0089
            r5 = 3664(0xe50, float:5.134E-42)
            if (r3 == r5) goto L_0x007d
            r5 = 3684(0xe64, float:5.162E-42)
            if (r3 == r5) goto L_0x0071
            r5 = 3710(0xe7e, float:5.199E-42)
            if (r3 == r5) goto L_0x0066
            switch(r3) {
                case 115: goto L_0x005b;
                case 116: goto L_0x004f;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x00c6
        L_0x004f:
            java.lang.String r3 = "t"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 0
            goto L_0x00c7
        L_0x005b:
            java.lang.String r3 = "s"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 2
            goto L_0x00c7
        L_0x0066:
            java.lang.String r3 = "tr"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 4
            goto L_0x00c7
        L_0x0071:
            java.lang.String r3 = "sw"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 9
            goto L_0x00c7
        L_0x007d:
            java.lang.String r3 = "sc"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 8
            goto L_0x00c7
        L_0x0089:
            java.lang.String r3 = "of"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 10
            goto L_0x00c7
        L_0x0094:
            java.lang.String r3 = "ls"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 6
            goto L_0x00c7
        L_0x009e:
            java.lang.String r3 = "lh"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 5
            goto L_0x00c7
        L_0x00a8:
            java.lang.String r3 = "fc"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 7
            goto L_0x00c7
        L_0x00b2:
            java.lang.String r3 = "j"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 3
            goto L_0x00c7
        L_0x00bc:
            java.lang.String r3 = "f"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c6
            r1 = 1
            goto L_0x00c7
        L_0x00c6:
            r1 = -1
        L_0x00c7:
            switch(r1) {
                case 0: goto L_0x010b;
                case 1: goto L_0x0105;
                case 2: goto L_0x00ff;
                case 3: goto L_0x00f9;
                case 4: goto L_0x00f3;
                case 5: goto L_0x00ed;
                case 6: goto L_0x00e7;
                case 7: goto L_0x00e1;
                case 8: goto L_0x00db;
                case 9: goto L_0x00d5;
                case 10: goto L_0x00cf;
                default: goto L_0x00ca;
            }
        L_0x00ca:
            r21.skipValue()
            goto L_0x0017
        L_0x00cf:
            boolean r19 = r21.nextBoolean()
            goto L_0x0017
        L_0x00d5:
            int r18 = r21.nextInt()
            goto L_0x0017
        L_0x00db:
            int r17 = com.airbnb.lottie.c.n.a(r21)
            goto L_0x0017
        L_0x00e1:
            int r16 = com.airbnb.lottie.c.n.a(r21)
            goto L_0x0017
        L_0x00e7:
            double r14 = r21.nextDouble()
            goto L_0x0017
        L_0x00ed:
            double r12 = r21.nextDouble()
            goto L_0x0017
        L_0x00f3:
            int r11 = r21.nextInt()
            goto L_0x0017
        L_0x00f9:
            int r10 = r21.nextInt()
            goto L_0x0017
        L_0x00ff:
            double r8 = r21.nextDouble()
            goto L_0x0017
        L_0x0105:
            java.lang.String r7 = r21.nextString()
            goto L_0x0017
        L_0x010b:
            java.lang.String r6 = r21.nextString()
            goto L_0x0017
        L_0x0111:
            r21.endObject()
            com.airbnb.lottie.model.b r0 = new com.airbnb.lottie.model.b
            r5 = r0
            r5.<init>(r6, r7, r8, r10, r11, r12, r14, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.h.a(android.util.JsonReader, float):java.lang.Object");
    }
}
    
