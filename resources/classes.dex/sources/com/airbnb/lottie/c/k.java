    package com.airbnb.lottie.c;

final class k {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.d j(android.util.JsonReader r14, com.airbnb.lottie.c r15) throws java.io.IOException {
        /*
            r0 = 0
            r2 = r0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
        L_0x0008:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x00f5
            java.lang.String r0 = r14.nextName()
            int r1 = r0.hashCode()
            r9 = 101(0x65, float:1.42E-43)
            r10 = 0
            r11 = -1
            r12 = 1
            if (r1 == r9) goto L_0x006a
            r9 = 103(0x67, float:1.44E-43)
            if (r1 == r9) goto L_0x0060
            r9 = 111(0x6f, float:1.56E-43)
            if (r1 == r9) goto L_0x0056
            r9 = 3519(0xdbf, float:4.931E-42)
            if (r1 == r9) goto L_0x004c
            switch(r1) {
                case 114: goto L_0x0042;
                case 115: goto L_0x0038;
                case 116: goto L_0x002d;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x0074
        L_0x002d:
            java.lang.String r1 = "t"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0074
            r0 = 3
            goto L_0x0075
        L_0x0038:
            java.lang.String r1 = "s"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0074
            r0 = 4
            goto L_0x0075
        L_0x0042:
            java.lang.String r1 = "r"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0074
            r0 = 6
            goto L_0x0075
        L_0x004c:
            java.lang.String r1 = "nm"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0074
            r0 = 0
            goto L_0x0075
        L_0x0056:
            java.lang.String r1 = "o"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0074
            r0 = 2
            goto L_0x0075
        L_0x0060:
            java.lang.String r1 = "g"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0074
            r0 = 1
            goto L_0x0075
        L_0x006a:
            java.lang.String r1 = "e"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0074
            r0 = 5
            goto L_0x0075
        L_0x0074:
            r0 = -1
        L_0x0075:
            switch(r0) {
                case 0: goto L_0x00ef;
                case 1: goto L_0x00a9;
                case 2: goto L_0x00a3;
                case 3: goto L_0x0095;
                case 4: goto L_0x008f;
                case 5: goto L_0x0089;
                case 6: goto L_0x007c;
                default: goto L_0x0078;
            }
        L_0x0078:
            r14.skipValue()
            goto L_0x0008
        L_0x007c:
            int r0 = r14.nextInt()
            if (r0 != r12) goto L_0x0086
            android.graphics.Path$FillType r0 = android.graphics.Path.FillType.WINDING
        L_0x0084:
            r4 = r0
            goto L_0x0008
        L_0x0086:
            android.graphics.Path$FillType r0 = android.graphics.Path.FillType.EVEN_ODD
            goto L_0x0084
        L_0x0089:
            com.airbnb.lottie.model.a.f r8 = com.airbnb.lottie.c.d.f(r14, r15)
            goto L_0x0008
        L_0x008f:
            com.airbnb.lottie.model.a.f r7 = com.airbnb.lottie.c.d.f(r14, r15)
            goto L_0x0008
        L_0x0095:
            int r0 = r14.nextInt()
            if (r0 != r12) goto L_0x00a0
            com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Linear
        L_0x009d:
            r3 = r0
            goto L_0x0008
        L_0x00a0:
            com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Radial
            goto L_0x009d
        L_0x00a3:
            com.airbnb.lottie.model.a.d r6 = com.airbnb.lottie.c.d.e(r14, r15)
            goto L_0x0008
        L_0x00a9:
            r14.beginObject()
            r0 = -1
        L_0x00ad:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x00ea
            java.lang.String r1 = r14.nextName()
            int r9 = r1.hashCode()
            r13 = 107(0x6b, float:1.5E-43)
            if (r9 == r13) goto L_0x00ce
            r13 = 112(0x70, float:1.57E-43)
            if (r9 == r13) goto L_0x00c4
            goto L_0x00d8
        L_0x00c4:
            java.lang.String r9 = "p"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00d8
            r1 = 0
            goto L_0x00d9
        L_0x00ce:
            java.lang.String r9 = "k"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00d8
            r1 = 1
            goto L_0x00d9
        L_0x00d8:
            r1 = -1
        L_0x00d9:
            switch(r1) {
                case 0: goto L_0x00e5;
                case 1: goto L_0x00e0;
                default: goto L_0x00dc;
            }
        L_0x00dc:
            r14.skipValue()
            goto L_0x00ad
        L_0x00e0:
            com.airbnb.lottie.model.a.c r5 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r14, (com.airbnb.lottie.c) r15, (int) r0)
            goto L_0x00ad
        L_0x00e5:
            int r0 = r14.nextInt()
            goto L_0x00ad
        L_0x00ea:
            r14.endObject()
            goto L_0x0008
        L_0x00ef:
            java.lang.String r2 = r14.nextString()
            goto L_0x0008
        L_0x00f5:
            com.airbnb.lottie.model.content.d r14 = new com.airbnb.lottie.model.content.d
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.k.j(android.util.JsonReader, com.airbnb.lottie.c):com.airbnb.lottie.model.content.d");
    }
}
    
