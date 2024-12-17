    package com.airbnb.lottie.c;

final class l {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.e k(android.util.JsonReader r21, com.airbnb.lottie.c r22) throws java.io.IOException {
        /*
            r0 = r21
            r1 = r22
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r3 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x0015:
            boolean r15 = r21.hasNext()
            if (r15 == 0) goto L_0x0212
            java.lang.String r15 = r21.nextName()
            int r16 = r15.hashCode()
            r17 = -1
            switch(r16) {
                case 100: goto L_0x0094;
                case 101: goto L_0x008a;
                case 103: goto L_0x0080;
                case 111: goto L_0x0076;
                case 115: goto L_0x006b;
                case 116: goto L_0x0060;
                case 119: goto L_0x0055;
                case 3447: goto L_0x004b;
                case 3454: goto L_0x0040;
                case 3487: goto L_0x0035;
                case 3519: goto L_0x002a;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x009f
        L_0x002a:
            java.lang.String r2 = "nm"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 0
            goto L_0x00a0
        L_0x0035:
            java.lang.String r2 = "ml"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 9
            goto L_0x00a0
        L_0x0040:
            java.lang.String r2 = "lj"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 8
            goto L_0x00a0
        L_0x004b:
            java.lang.String r2 = "lc"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 7
            goto L_0x00a0
        L_0x0055:
            java.lang.String r2 = "w"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 6
            goto L_0x00a0
        L_0x0060:
            java.lang.String r2 = "t"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 3
            goto L_0x00a0
        L_0x006b:
            java.lang.String r2 = "s"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 4
            goto L_0x00a0
        L_0x0076:
            java.lang.String r2 = "o"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 2
            goto L_0x00a0
        L_0x0080:
            java.lang.String r2 = "g"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 1
            goto L_0x00a0
        L_0x008a:
            java.lang.String r2 = "e"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 5
            goto L_0x00a0
        L_0x0094:
            java.lang.String r2 = "d"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x009f
            r2 = 10
            goto L_0x00a0
        L_0x009f:
            r2 = -1
        L_0x00a0:
            switch(r2) {
                case 0: goto L_0x0204;
                case 1: goto L_0x01b7;
                case 2: goto L_0x01ad;
                case 3: goto L_0x019a;
                case 4: goto L_0x0190;
                case 5: goto L_0x0186;
                case 6: goto L_0x0179;
                case 7: goto L_0x0168;
                case 8: goto L_0x0156;
                case 9: goto L_0x014e;
                case 10: goto L_0x00ac;
                default: goto L_0x00a3;
            }
        L_0x00a3:
            r20 = r12
            r19 = r13
            r21.skipValue()
            goto L_0x020e
        L_0x00ac:
            r21.beginArray()
        L_0x00af:
            boolean r2 = r21.hasNext()
            if (r2 == 0) goto L_0x0132
            r21.beginObject()
            r2 = 0
            r15 = 0
        L_0x00ba:
            boolean r16 = r21.hasNext()
            if (r16 == 0) goto L_0x0105
            r18 = r14
            java.lang.String r14 = r21.nextName()
            r19 = r13
            int r13 = r14.hashCode()
            r20 = r12
            r12 = 110(0x6e, float:1.54E-43)
            if (r13 == r12) goto L_0x00e2
            r12 = 118(0x76, float:1.65E-43)
            if (r13 == r12) goto L_0x00d7
            goto L_0x00ec
        L_0x00d7:
            java.lang.String r12 = "v"
            boolean r12 = r14.equals(r12)
            if (r12 == 0) goto L_0x00ec
            r12 = 1
            goto L_0x00ed
        L_0x00e2:
            java.lang.String r12 = "n"
            boolean r12 = r14.equals(r12)
            if (r12 == 0) goto L_0x00ec
            r12 = 0
            goto L_0x00ed
        L_0x00ec:
            r12 = -1
        L_0x00ed:
            switch(r12) {
                case 0: goto L_0x0100;
                case 1: goto L_0x00fa;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            r21.skipValue()
        L_0x00f3:
            r14 = r18
            r13 = r19
            r12 = r20
            goto L_0x00ba
        L_0x00fa:
            r12 = 1
            com.airbnb.lottie.model.a.b r15 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r1, (boolean) r12)
            goto L_0x00f3
        L_0x0100:
            java.lang.String r2 = r21.nextString()
            goto L_0x00f3
        L_0x0105:
            r20 = r12
            r19 = r13
            r18 = r14
            r21.endObject()
            java.lang.String r12 = "o"
            boolean r12 = r2.equals(r12)
            if (r12 == 0) goto L_0x011c
            r14 = r15
        L_0x0117:
            r13 = r19
            r12 = r20
            goto L_0x00af
        L_0x011c:
            java.lang.String r12 = "d"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x012c
            java.lang.String r12 = "g"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x012f
        L_0x012c:
            r11.add(r15)
        L_0x012f:
            r14 = r18
            goto L_0x0117
        L_0x0132:
            r20 = r12
            r19 = r13
            r18 = r14
            r21.endArray()
            int r2 = r11.size()
            r12 = 1
            if (r2 != r12) goto L_0x014a
            r2 = 0
            java.lang.Object r2 = r11.get(r2)
            r11.add(r2)
        L_0x014a:
            r14 = r18
            goto L_0x020e
        L_0x014e:
            r20 = r12
            double r12 = r21.nextDouble()
            float r13 = (float) r12
            goto L_0x0182
        L_0x0156:
            r19 = r13
            r12 = 1
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r2 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r13 = r21.nextInt()
            int r13 = r13 - r12
            r12 = r2[r13]
            r13 = r19
            goto L_0x0015
        L_0x0168:
            r20 = r12
            r19 = r13
            r12 = 1
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r2 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r10 = r21.nextInt()
            int r10 = r10 - r12
            r10 = r2[r10]
            goto L_0x0182
        L_0x0179:
            r20 = r12
            r19 = r13
            r12 = 1
            com.airbnb.lottie.model.a.b r9 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r1, (boolean) r12)
        L_0x0182:
            r12 = r20
            goto L_0x0015
        L_0x0186:
            r20 = r12
            r19 = r13
            com.airbnb.lottie.model.a.f r8 = com.airbnb.lottie.c.d.f(r21, r22)
            goto L_0x0015
        L_0x0190:
            r20 = r12
            r19 = r13
            com.airbnb.lottie.model.a.f r7 = com.airbnb.lottie.c.d.f(r21, r22)
            goto L_0x0015
        L_0x019a:
            r20 = r12
            r19 = r13
            r12 = 1
            int r2 = r21.nextInt()
            if (r2 != r12) goto L_0x01aa
            com.airbnb.lottie.model.content.GradientType r2 = com.airbnb.lottie.model.content.GradientType.Linear
        L_0x01a7:
            r4 = r2
            goto L_0x020e
        L_0x01aa:
            com.airbnb.lottie.model.content.GradientType r2 = com.airbnb.lottie.model.content.GradientType.Radial
            goto L_0x01a7
        L_0x01ad:
            r20 = r12
            r19 = r13
            com.airbnb.lottie.model.a.d r6 = com.airbnb.lottie.c.d.e(r21, r22)
            goto L_0x0015
        L_0x01b7:
            r20 = r12
            r19 = r13
            r2 = 0
            r12 = 1
            r21.beginObject()
            r13 = -1
        L_0x01c1:
            boolean r15 = r21.hasNext()
            if (r15 == 0) goto L_0x0200
            java.lang.String r15 = r21.nextName()
            int r2 = r15.hashCode()
            r12 = 107(0x6b, float:1.5E-43)
            if (r2 == r12) goto L_0x01e2
            r12 = 112(0x70, float:1.57E-43)
            if (r2 == r12) goto L_0x01d8
            goto L_0x01ec
        L_0x01d8:
            java.lang.String r2 = "p"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x01ec
            r2 = 0
            goto L_0x01ed
        L_0x01e2:
            java.lang.String r2 = "k"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x01ec
            r2 = 1
            goto L_0x01ed
        L_0x01ec:
            r2 = -1
        L_0x01ed:
            switch(r2) {
                case 0: goto L_0x01fb;
                case 1: goto L_0x01f6;
                default: goto L_0x01f0;
            }
        L_0x01f0:
            r21.skipValue()
        L_0x01f3:
            r2 = 0
            r12 = 1
            goto L_0x01c1
        L_0x01f6:
            com.airbnb.lottie.model.a.c r5 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r1, (int) r13)
            goto L_0x01f3
        L_0x01fb:
            int r13 = r21.nextInt()
            goto L_0x01f3
        L_0x0200:
            r21.endObject()
            goto L_0x020e
        L_0x0204:
            r20 = r12
            r19 = r13
            java.lang.String r3 = r21.nextString()
            goto L_0x0015
        L_0x020e:
            r13 = r19
            goto L_0x0182
        L_0x0212:
            r20 = r12
            r19 = r13
            com.airbnb.lottie.model.content.e r13 = new com.airbnb.lottie.model.content.e
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r10
            r9 = r20
            r10 = r19
            r12 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.l.k(android.util.JsonReader, com.airbnb.lottie.c):com.airbnb.lottie.model.content.e");
    }
}
    
