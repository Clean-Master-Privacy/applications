    package com.airbnb.lottie.c;

public final class q {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0254  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.model.layer.Layer l(android.util.JsonReader r36, com.airbnb.lottie.c r37) throws java.io.IOException {
        /*
            r0 = r36
            r7 = r37
            com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.None
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r36.beginObject()
            r2 = 0
            r11 = 0
            r3 = 0
            r4 = 0
            r12 = -1
            r30 = r1
            r14 = r2
            r20 = r14
            r21 = r20
            r28 = r21
            r29 = r28
            r31 = r29
            r16 = r4
            r18 = r12
            r1 = 0
            r15 = 1065353216(0x3f800000, float:1.0)
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r12 = r31
            r13 = r12
            r2 = 0
        L_0x003e:
            boolean r4 = r36.hasNext()
            if (r4 == 0) goto L_0x02fe
            java.lang.String r4 = r36.nextName()
            int r5 = r4.hashCode()
            r6 = 1
            r32 = -1
            switch(r5) {
                case -995424086: goto L_0x014b;
                case -903568142: goto L_0x013f;
                case 104: goto L_0x0134;
                case 116: goto L_0x0128;
                case 119: goto L_0x011c;
                case 3177: goto L_0x0111;
                case 3233: goto L_0x0106;
                case 3367: goto L_0x00fb;
                case 3432: goto L_0x00f0;
                case 3519: goto L_0x00e5;
                case 3553: goto L_0x00d9;
                case 3664: goto L_0x00ce;
                case 3669: goto L_0x00c2;
                case 3679: goto L_0x00b5;
                case 3681: goto L_0x00a8;
                case 3684: goto L_0x009c;
                case 3705: goto L_0x008f;
                case 3712: goto L_0x0082;
                case 3717: goto L_0x0076;
                case 104415: goto L_0x006b;
                case 108390670: goto L_0x0060;
                case 1441620890: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0155
        L_0x0054:
            java.lang.String r5 = "masksProperties"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 10
            goto L_0x0156
        L_0x0060:
            java.lang.String r5 = "refId"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 2
            goto L_0x0156
        L_0x006b:
            java.lang.String r5 = "ind"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 1
            goto L_0x0156
        L_0x0076:
            java.lang.String r5 = "ty"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 3
            goto L_0x0156
        L_0x0082:
            java.lang.String r5 = "tt"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 9
            goto L_0x0156
        L_0x008f:
            java.lang.String r5 = "tm"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 20
            goto L_0x0156
        L_0x009c:
            java.lang.String r5 = "sw"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 5
            goto L_0x0156
        L_0x00a8:
            java.lang.String r5 = "st"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 15
            goto L_0x0156
        L_0x00b5:
            java.lang.String r5 = "sr"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 14
            goto L_0x0156
        L_0x00c2:
            java.lang.String r5 = "sh"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 6
            goto L_0x0156
        L_0x00ce:
            java.lang.String r5 = "sc"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 7
            goto L_0x0156
        L_0x00d9:
            java.lang.String r5 = "op"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 19
            goto L_0x0156
        L_0x00e5:
            java.lang.String r5 = "nm"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 0
            goto L_0x0156
        L_0x00f0:
            java.lang.String r5 = "ks"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 8
            goto L_0x0156
        L_0x00fb:
            java.lang.String r5 = "ip"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 18
            goto L_0x0156
        L_0x0106:
            java.lang.String r5 = "ef"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 13
            goto L_0x0156
        L_0x0111:
            java.lang.String r5 = "cl"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 21
            goto L_0x0156
        L_0x011c:
            java.lang.String r5 = "w"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 16
            goto L_0x0156
        L_0x0128:
            java.lang.String r5 = "t"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 12
            goto L_0x0156
        L_0x0134:
            java.lang.String r5 = "h"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 17
            goto L_0x0156
        L_0x013f:
            java.lang.String r5 = "shapes"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 11
            goto L_0x0156
        L_0x014b:
            java.lang.String r5 = "parent"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0155
            r4 = 4
            goto L_0x0156
        L_0x0155:
            r4 = -1
        L_0x0156:
            switch(r4) {
                case 0: goto L_0x02f7;
                case 1: goto L_0x02ef;
                case 2: goto L_0x02ea;
                case 3: goto L_0x02d4;
                case 4: goto L_0x02cc;
                case 5: goto L_0x02bd;
                case 6: goto L_0x02ae;
                case 7: goto L_0x02a5;
                case 8: goto L_0x02a0;
                case 9: goto L_0x0295;
                case 10: goto L_0x027f;
                case 11: goto L_0x0267;
                case 12: goto L_0x0201;
                case 13: goto L_0x01a8;
                case 14: goto L_0x01a1;
                case 15: goto L_0x0198;
                case 16: goto L_0x0188;
                case 17: goto L_0x0178;
                case 18: goto L_0x0171;
                case 19: goto L_0x016a;
                case 20: goto L_0x0164;
                case 21: goto L_0x015e;
                default: goto L_0x0159;
            }
        L_0x0159:
            r36.skipValue()
            goto L_0x02fb
        L_0x015e:
            java.lang.String r13 = r36.nextString()
            goto L_0x003e
        L_0x0164:
            com.airbnb.lottie.model.a.b r31 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r7, (boolean) r3)
            goto L_0x003e
        L_0x016a:
            double r4 = r36.nextDouble()
            float r2 = (float) r4
            goto L_0x003e
        L_0x0171:
            double r4 = r36.nextDouble()
            float r1 = (float) r4
            goto L_0x003e
        L_0x0178:
            int r4 = r36.nextInt()
            float r4 = (float) r4
            float r5 = com.airbnb.lottie.d.e.dd()
            float r4 = r4 * r5
            int r4 = (int) r4
            r27 = r4
            goto L_0x003e
        L_0x0188:
            int r4 = r36.nextInt()
            float r4 = (float) r4
            float r5 = com.airbnb.lottie.d.e.dd()
            float r4 = r4 * r5
            int r4 = (int) r4
            r26 = r4
            goto L_0x003e
        L_0x0198:
            double r4 = r36.nextDouble()
            float r4 = (float) r4
            r25 = r4
            goto L_0x003e
        L_0x01a1:
            double r4 = r36.nextDouble()
            float r15 = (float) r4
            goto L_0x003e
        L_0x01a8:
            r36.beginArray()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x01b0:
            boolean r5 = r36.hasNext()
            if (r5 == 0) goto L_0x01eb
            r36.beginObject()
        L_0x01b9:
            boolean r5 = r36.hasNext()
            if (r5 == 0) goto L_0x01e6
            java.lang.String r5 = r36.nextName()
            int r6 = r5.hashCode()
            r3 = 3519(0xdbf, float:4.931E-42)
            if (r6 == r3) goto L_0x01cc
            goto L_0x01d6
        L_0x01cc:
            java.lang.String r3 = "nm"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x01d6
            r3 = 0
            goto L_0x01d7
        L_0x01d6:
            r3 = -1
        L_0x01d7:
            if (r3 == 0) goto L_0x01de
            r36.skipValue()
        L_0x01dc:
            r3 = 0
            goto L_0x01b9
        L_0x01de:
            java.lang.String r3 = r36.nextString()
            r4.add(r3)
            goto L_0x01dc
        L_0x01e6:
            r36.endObject()
            r3 = 0
            goto L_0x01b0
        L_0x01eb:
            r36.endArray()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: "
            r3.<init>(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.bu(r3)
            goto L_0x02fb
        L_0x0201:
            r36.beginObject()
        L_0x0204:
            boolean r3 = r36.hasNext()
            if (r3 == 0) goto L_0x0262
            java.lang.String r3 = r36.nextName()
            int r4 = r3.hashCode()
            r5 = 97
            if (r4 == r5) goto L_0x0225
            r5 = 100
            if (r4 == r5) goto L_0x021b
            goto L_0x022f
        L_0x021b:
            java.lang.String r4 = "d"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x022f
            r3 = 0
            goto L_0x0230
        L_0x0225:
            java.lang.String r4 = "a"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x022f
            r3 = 1
            goto L_0x0230
        L_0x022f:
            r3 = -1
        L_0x0230:
            switch(r3) {
                case 0: goto L_0x0254;
                case 1: goto L_0x0237;
                default: goto L_0x0233;
            }
        L_0x0233:
            r36.skipValue()
            goto L_0x0204
        L_0x0237:
            r36.beginArray()
            boolean r3 = r36.hasNext()
            if (r3 == 0) goto L_0x0246
            com.airbnb.lottie.model.a.k r3 = com.airbnb.lottie.c.b.c(r36, r37)
            r29 = r3
        L_0x0246:
            boolean r3 = r36.hasNext()
            if (r3 == 0) goto L_0x0250
            r36.skipValue()
            goto L_0x0246
        L_0x0250:
            r36.endArray()
            goto L_0x0204
        L_0x0254:
            com.airbnb.lottie.model.a.j r3 = new com.airbnb.lottie.model.a.j
            com.airbnb.lottie.c.h r4 = com.airbnb.lottie.c.h.qG
            java.util.List r4 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r7, r4)
            r3.<init>(r4)
            r28 = r3
            goto L_0x0204
        L_0x0262:
            r36.endObject()
            goto L_0x02fb
        L_0x0267:
            r36.beginArray()
        L_0x026a:
            boolean r3 = r36.hasNext()
            if (r3 == 0) goto L_0x027a
            com.airbnb.lottie.model.content.b r3 = com.airbnb.lottie.c.g.i(r36, r37)
            if (r3 == 0) goto L_0x026a
            r8.add(r3)
            goto L_0x026a
        L_0x027a:
            r36.endArray()
            goto L_0x02fb
        L_0x027f:
            r36.beginArray()
        L_0x0282:
            boolean r3 = r36.hasNext()
            if (r3 == 0) goto L_0x0290
            com.airbnb.lottie.model.content.Mask r3 = com.airbnb.lottie.c.s.m(r36, r37)
            r10.add(r3)
            goto L_0x0282
        L_0x0290:
            r36.endArray()
            goto L_0x02fb
        L_0x0295:
            com.airbnb.lottie.model.layer.Layer$MatteType[] r3 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
            int r4 = r36.nextInt()
            r30 = r3[r4]
            goto L_0x02fb
        L_0x02a0:
            com.airbnb.lottie.model.a.l r21 = com.airbnb.lottie.c.c.d(r36, r37)
            goto L_0x02fb
        L_0x02a5:
            java.lang.String r3 = r36.nextString()
            int r24 = android.graphics.Color.parseColor(r3)
            goto L_0x02fb
        L_0x02ae:
            int r3 = r36.nextInt()
            float r3 = (float) r3
            float r4 = com.airbnb.lottie.d.e.dd()
            float r3 = r3 * r4
            int r3 = (int) r3
            r23 = r3
            goto L_0x02fb
        L_0x02bd:
            int r3 = r36.nextInt()
            float r3 = (float) r3
            float r4 = com.airbnb.lottie.d.e.dd()
            float r3 = r3 * r4
            int r3 = (int) r3
            r22 = r3
            goto L_0x02fb
        L_0x02cc:
            int r3 = r36.nextInt()
            long r3 = (long) r3
            r18 = r3
            goto L_0x02fb
        L_0x02d4:
            int r3 = r36.nextInt()
            com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.Unknown
            int r4 = r4.ordinal()
            if (r3 >= r4) goto L_0x02e7
            com.airbnb.lottie.model.layer.Layer$LayerType[] r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
            r14 = r4[r3]
            goto L_0x02fb
        L_0x02e7:
            com.airbnb.lottie.model.layer.Layer$LayerType r14 = com.airbnb.lottie.model.layer.Layer.LayerType.Unknown
            goto L_0x02fb
        L_0x02ea:
            java.lang.String r20 = r36.nextString()
            goto L_0x02fb
        L_0x02ef:
            int r3 = r36.nextInt()
            long r3 = (long) r3
            r16 = r3
            goto L_0x02fb
        L_0x02f7:
            java.lang.String r12 = r36.nextString()
        L_0x02fb:
            r3 = 0
            goto L_0x003e
        L_0x02fe:
            r36.endObject()
            float r32 = r1 / r15
            float r33 = r2 / r15
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            int r0 = (r32 > r11 ? 1 : (r32 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x032f
            com.airbnb.lottie.e.a r5 = new com.airbnb.lottie.e.a
            java.lang.Float r2 = java.lang.Float.valueOf(r11)
            java.lang.Float r3 = java.lang.Float.valueOf(r11)
            r4 = 0
            r34 = 0
            java.lang.Float r35 = java.lang.Float.valueOf(r32)
            r0 = r5
            r1 = r37
            r9 = r5
            r5 = r34
            r11 = r6
            r6 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.add(r9)
            goto L_0x0330
        L_0x032f:
            r11 = r6
        L_0x0330:
            r0 = 0
            int r1 = (r33 > r0 ? 1 : (r33 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0336
            goto L_0x033a
        L_0x0336:
            float r0 = r7.lv
            r33 = r0
        L_0x033a:
            com.airbnb.lottie.e.a r9 = new com.airbnb.lottie.e.a
            r0 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r2 = java.lang.Float.valueOf(r0)
            java.lang.Float r3 = java.lang.Float.valueOf(r0)
            r4 = 0
            java.lang.Float r6 = java.lang.Float.valueOf(r33)
            r0 = r9
            r1 = r37
            r5 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.add(r9)
            com.airbnb.lottie.e.a r9 = new com.airbnb.lottie.e.a
            r0 = 0
            java.lang.Float r2 = java.lang.Float.valueOf(r0)
            java.lang.Float r3 = java.lang.Float.valueOf(r0)
            r0 = 2139095039(0x7f7fffff, float:3.4028235E38)
            java.lang.Float r6 = java.lang.Float.valueOf(r0)
            r0 = r9
            r5 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.add(r9)
            java.lang.String r0 = ".ai"
            boolean r0 = r12.endsWith(r0)
            if (r0 != 0) goto L_0x0381
            java.lang.String r0 = "ai"
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0386
        L_0x0381:
            java.lang.String r0 = "Convert your Illustrator layers to shape layers."
            r7.bu(r0)
        L_0x0386:
            com.airbnb.lottie.model.layer.Layer r32 = new com.airbnb.lottie.model.layer.Layer
            r0 = r32
            r1 = r8
            r2 = r37
            r3 = r12
            r4 = r16
            r6 = r14
            r7 = r18
            r9 = r20
            r33 = r11
            r11 = r21
            r12 = r22
            r13 = r23
            r14 = r24
            r16 = r25
            r17 = r26
            r18 = r27
            r19 = r28
            r20 = r29
            r21 = r33
            r22 = r30
            r23 = r31
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.q.l(android.util.JsonReader, com.airbnb.lottie.c):com.airbnb.lottie.model.layer.Layer");
    }
}
    
