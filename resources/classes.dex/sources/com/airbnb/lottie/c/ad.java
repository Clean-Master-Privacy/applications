    package com.airbnb.lottie.c;

final class ad {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0127 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ShapeStroke s(android.util.JsonReader r17, com.airbnb.lottie.c r18) throws java.io.IOException {
        /*
            r0 = r17
            r1 = r18
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0012:
            boolean r12 = r17.hasNext()
            if (r12 == 0) goto L_0x017b
            java.lang.String r12 = r17.nextName()
            int r13 = r12.hashCode()
            r15 = 111(0x6f, float:1.56E-43)
            r16 = -1
            if (r13 == r15) goto L_0x0085
            r2 = 119(0x77, float:1.67E-43)
            if (r13 == r2) goto L_0x007a
            r2 = 3447(0xd77, float:4.83E-42)
            if (r13 == r2) goto L_0x0070
            r2 = 3454(0xd7e, float:4.84E-42)
            if (r13 == r2) goto L_0x0066
            r2 = 3487(0xd9f, float:4.886E-42)
            if (r13 == r2) goto L_0x005c
            r2 = 3519(0xdbf, float:4.931E-42)
            if (r13 == r2) goto L_0x0052
            switch(r13) {
                case 99: goto L_0x0048;
                case 100: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x008f
        L_0x003e:
            java.lang.String r2 = "d"
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x008f
            r2 = 7
            goto L_0x0090
        L_0x0048:
            java.lang.String r2 = "c"
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x008f
            r2 = 1
            goto L_0x0090
        L_0x0052:
            java.lang.String r2 = "nm"
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x008f
            r2 = 0
            goto L_0x0090
        L_0x005c:
            java.lang.String r2 = "ml"
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x008f
            r2 = 6
            goto L_0x0090
        L_0x0066:
            java.lang.String r2 = "lj"
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x008f
            r2 = 5
            goto L_0x0090
        L_0x0070:
            java.lang.String r2 = "lc"
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x008f
            r2 = 4
            goto L_0x0090
        L_0x007a:
            java.lang.String r2 = "w"
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x008f
            r2 = 2
            goto L_0x0090
        L_0x0085:
            java.lang.String r2 = "o"
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x008f
            r2 = 3
            goto L_0x0090
        L_0x008f:
            r2 = -1
        L_0x0090:
            switch(r2) {
                case 0: goto L_0x0175;
                case 1: goto L_0x016f;
                case 2: goto L_0x0168;
                case 3: goto L_0x0162;
                case 4: goto L_0x0154;
                case 5: goto L_0x0146;
                case 6: goto L_0x013f;
                case 7: goto L_0x0098;
                default: goto L_0x0093;
            }
        L_0x0093:
            r17.skipValue()
            goto L_0x0012
        L_0x0098:
            r17.beginArray()
        L_0x009b:
            boolean r2 = r17.hasNext()
            if (r2 == 0) goto L_0x012b
            r17.beginObject()
            r2 = 0
            r12 = 0
        L_0x00a6:
            boolean r13 = r17.hasNext()
            if (r13 == 0) goto L_0x00e7
            java.lang.String r13 = r17.nextName()
            int r15 = r13.hashCode()
            r14 = 110(0x6e, float:1.54E-43)
            if (r15 == r14) goto L_0x00c8
            r14 = 118(0x76, float:1.65E-43)
            if (r15 == r14) goto L_0x00bd
            goto L_0x00d2
        L_0x00bd:
            java.lang.String r14 = "v"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00d2
            r13 = 1
            goto L_0x00d3
        L_0x00c8:
            java.lang.String r14 = "n"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00d2
            r13 = 0
            goto L_0x00d3
        L_0x00d2:
            r13 = -1
        L_0x00d3:
            switch(r13) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00dc;
                default: goto L_0x00d6;
            }
        L_0x00d6:
            r17.skipValue()
        L_0x00d9:
            r15 = 111(0x6f, float:1.56E-43)
            goto L_0x00a6
        L_0x00dc:
            r13 = 1
            com.airbnb.lottie.model.a.b r12 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r1, (boolean) r13)
            goto L_0x00d9
        L_0x00e2:
            java.lang.String r2 = r17.nextString()
            goto L_0x00d9
        L_0x00e7:
            r17.endObject()
            int r13 = r2.hashCode()
            r14 = 100
            if (r13 == r14) goto L_0x0111
            r14 = 103(0x67, float:1.44E-43)
            if (r13 == r14) goto L_0x0105
            r14 = 111(0x6f, float:1.56E-43)
            if (r13 == r14) goto L_0x00fb
            goto L_0x011d
        L_0x00fb:
            java.lang.String r13 = "o"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x011d
            r2 = 0
            goto L_0x011e
        L_0x0105:
            r14 = 111(0x6f, float:1.56E-43)
            java.lang.String r13 = "g"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x011d
            r2 = 2
            goto L_0x011e
        L_0x0111:
            r14 = 111(0x6f, float:1.56E-43)
            java.lang.String r13 = "d"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x011d
            r2 = 1
            goto L_0x011e
        L_0x011d:
            r2 = -1
        L_0x011e:
            switch(r2) {
                case 0: goto L_0x0126;
                case 1: goto L_0x0122;
                case 2: goto L_0x0122;
                default: goto L_0x0121;
            }
        L_0x0121:
            goto L_0x0127
        L_0x0122:
            r3.add(r12)
            goto L_0x0127
        L_0x0126:
            r5 = r12
        L_0x0127:
            r15 = 111(0x6f, float:1.56E-43)
            goto L_0x009b
        L_0x012b:
            r17.endArray()
            int r2 = r3.size()
            r12 = 1
            if (r2 != r12) goto L_0x0012
            r2 = 0
            java.lang.Object r2 = r3.get(r2)
            r3.add(r2)
            goto L_0x0012
        L_0x013f:
            double r11 = r17.nextDouble()
            float r11 = (float) r11
            goto L_0x0012
        L_0x0146:
            r12 = 1
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r2 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r10 = r17.nextInt()
            int r10 = r10 - r12
            r10 = r2[r10]
            goto L_0x0012
        L_0x0154:
            r12 = 1
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r2 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r9 = r17.nextInt()
            int r9 = r9 - r12
            r9 = r2[r9]
            goto L_0x0012
        L_0x0162:
            com.airbnb.lottie.model.a.d r7 = com.airbnb.lottie.c.d.e(r17, r18)
            goto L_0x0012
        L_0x0168:
            r12 = 1
            com.airbnb.lottie.model.a.b r8 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r1, (boolean) r12)
            goto L_0x0012
        L_0x016f:
            com.airbnb.lottie.model.a.a r6 = com.airbnb.lottie.c.d.h(r17, r18)
            goto L_0x0012
        L_0x0175:
            java.lang.String r4 = r17.nextString()
            goto L_0x0012
        L_0x017b:
            com.airbnb.lottie.model.content.ShapeStroke r12 = new com.airbnb.lottie.model.content.ShapeStroke
            r0 = r12
            r1 = r4
            r2 = r5
            r4 = r6
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r10
            r9 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.ad.s(android.util.JsonReader, com.airbnb.lottie.c):com.airbnb.lottie.model.content.ShapeStroke");
    }
}
    
