    package com.airbnb.lottie.c;

public final class c {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.model.a.l d(android.util.JsonReader r14, com.airbnb.lottie.c r15) throws java.io.IOException {
        /*
            android.util.JsonToken r0 = r14.peek()
            android.util.JsonToken r1 = android.util.JsonToken.BEGIN_OBJECT
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            if (r0 == 0) goto L_0x0012
            r14.beginObject()
        L_0x0012:
            r1 = 0
            r4 = r1
            r5 = r4
            r8 = r5
            r10 = r8
            r12 = r10
            r13 = r12
        L_0x0019:
            boolean r6 = r14.hasNext()
            if (r6 == 0) goto L_0x00d5
            java.lang.String r6 = r14.nextName()
            r7 = -1
            int r9 = r6.hashCode()
            switch(r9) {
                case 97: goto L_0x0073;
                case 111: goto L_0x0069;
                case 112: goto L_0x005f;
                case 114: goto L_0x0055;
                case 115: goto L_0x004b;
                case 3242: goto L_0x0041;
                case 3656: goto L_0x0037;
                case 3676: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x007d
        L_0x002c:
            java.lang.String r9 = "so"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x007d
            r6 = 6
            goto L_0x007e
        L_0x0037:
            java.lang.String r9 = "rz"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x007d
            r6 = 3
            goto L_0x007e
        L_0x0041:
            java.lang.String r9 = "eo"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x007d
            r6 = 7
            goto L_0x007e
        L_0x004b:
            java.lang.String r9 = "s"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x007d
            r6 = 2
            goto L_0x007e
        L_0x0055:
            java.lang.String r9 = "r"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x007d
            r6 = 4
            goto L_0x007e
        L_0x005f:
            java.lang.String r9 = "p"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x007d
            r6 = 1
            goto L_0x007e
        L_0x0069:
            java.lang.String r9 = "o"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x007d
            r6 = 5
            goto L_0x007e
        L_0x0073:
            java.lang.String r9 = "a"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x007d
            r6 = 0
            goto L_0x007e
        L_0x007d:
            r6 = -1
        L_0x007e:
            switch(r6) {
                case 0: goto L_0x00b2;
                case 1: goto L_0x00ac;
                case 2: goto L_0x009f;
                case 3: goto L_0x0094;
                case 4: goto L_0x0099;
                case 5: goto L_0x008f;
                case 6: goto L_0x008a;
                case 7: goto L_0x0085;
                default: goto L_0x0081;
            }
        L_0x0081:
            r14.skipValue()
            goto L_0x0019
        L_0x0085:
            com.airbnb.lottie.model.a.b r13 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r14, (com.airbnb.lottie.c) r15, (boolean) r3)
            goto L_0x0019
        L_0x008a:
            com.airbnb.lottie.model.a.b r12 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r14, (com.airbnb.lottie.c) r15, (boolean) r3)
            goto L_0x0019
        L_0x008f:
            com.airbnb.lottie.model.a.d r5 = com.airbnb.lottie.c.d.e(r14, r15)
            goto L_0x0019
        L_0x0094:
            java.lang.String r6 = "Lottie doesn't support 3D layers."
            r15.bu(r6)
        L_0x0099:
            com.airbnb.lottie.model.a.b r10 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r14, (com.airbnb.lottie.c) r15, (boolean) r3)
            goto L_0x0019
        L_0x009f:
            com.airbnb.lottie.model.a.g r4 = new com.airbnb.lottie.model.a.g
            com.airbnb.lottie.c.z r6 = com.airbnb.lottie.c.z.qO
            java.util.List r6 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r14, (com.airbnb.lottie.c) r15, r6)
            r4.<init>((java.util.List<com.airbnb.lottie.e.a<com.airbnb.lottie.e.d>>) r6)
            goto L_0x0019
        L_0x00ac:
            com.airbnb.lottie.model.a.m r8 = com.airbnb.lottie.c.a.b(r14, r15)
            goto L_0x0019
        L_0x00b2:
            r14.beginObject()
        L_0x00b5:
            boolean r6 = r14.hasNext()
            if (r6 == 0) goto L_0x00d0
            java.lang.String r6 = r14.nextName()
            java.lang.String r7 = "k"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00cc
            com.airbnb.lottie.model.a.e r1 = com.airbnb.lottie.c.a.a(r14, r15)
            goto L_0x00b5
        L_0x00cc:
            r14.skipValue()
            goto L_0x00b5
        L_0x00d0:
            r14.endObject()
            goto L_0x0019
        L_0x00d5:
            if (r0 == 0) goto L_0x00da
            r14.endObject()
        L_0x00da:
            if (r1 != 0) goto L_0x00e8
            java.lang.String r14 = "LOTTIE"
            java.lang.String r15 = "Layer has no transform property. You may be using an unsupported layer type such as a camera."
            android.util.Log.w(r14, r15)
            com.airbnb.lottie.model.a.e r1 = new com.airbnb.lottie.model.a.e
            r1.<init>()
        L_0x00e8:
            r7 = r1
            if (r4 != 0) goto L_0x00f7
            com.airbnb.lottie.model.a.g r4 = new com.airbnb.lottie.model.a.g
            com.airbnb.lottie.e.d r14 = new com.airbnb.lottie.e.d
            r15 = 1065353216(0x3f800000, float:1.0)
            r14.<init>(r15, r15)
            r4.<init>((com.airbnb.lottie.e.d) r14)
        L_0x00f7:
            r9 = r4
            if (r5 != 0) goto L_0x00ff
            com.airbnb.lottie.model.a.d r5 = new com.airbnb.lottie.model.a.d
            r5.<init>()
        L_0x00ff:
            r11 = r5
            com.airbnb.lottie.model.a.l r14 = new com.airbnb.lottie.model.a.l
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.d(android.util.JsonReader, com.airbnb.lottie.c):com.airbnb.lottie.model.a.l");
    }
}
    
