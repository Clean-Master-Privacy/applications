    package com.airbnb.lottie.c;

final class g {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [com.airbnb.lottie.model.content.b] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v20 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r6v23 */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: type inference failed for: r6v25 */
    /* JADX WARNING: type inference failed for: r6v26 */
    /* JADX WARNING: type inference failed for: r6v27 */
    /* JADX WARNING: type inference failed for: r6v28 */
    /* JADX WARNING: type inference failed for: r6v29 */
    /* JADX WARNING: type inference failed for: r6v30 */
    /* JADX WARNING: type inference failed for: r6v31 */
    /* JADX WARNING: type inference failed for: r6v32 */
    /* JADX WARNING: type inference failed for: r6v33 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b6, code lost:
        if (r2.equals("gs") != false) goto L_0x00e2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0042 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0194  */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.b i(android.util.JsonReader r9, com.airbnb.lottie.c r10) throws java.io.IOException {
        /*
            r9.beginObject()
            r0 = 2
            r1 = 2
        L_0x0005:
            boolean r2 = r9.hasNext()
            r3 = 0
            r4 = 1
            r5 = -1
            r6 = 0
            if (r2 == 0) goto L_0x0047
            java.lang.String r2 = r9.nextName()
            int r7 = r2.hashCode()
            r8 = 100
            if (r7 == r8) goto L_0x002b
            r8 = 3717(0xe85, float:5.209E-42)
            if (r7 == r8) goto L_0x0020
            goto L_0x0035
        L_0x0020:
            java.lang.String r7 = "ty"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0035
            r2 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r7 = "d"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0035
            r2 = 1
            goto L_0x0036
        L_0x0035:
            r2 = -1
        L_0x0036:
            switch(r2) {
                case 0: goto L_0x0042;
                case 1: goto L_0x003d;
                default: goto L_0x0039;
            }
        L_0x0039:
            r9.skipValue()
            goto L_0x0005
        L_0x003d:
            int r1 = r9.nextInt()
            goto L_0x0005
        L_0x0042:
            java.lang.String r2 = r9.nextString()
            goto L_0x0048
        L_0x0047:
            r2 = r6
        L_0x0048:
            if (r2 != 0) goto L_0x004b
            return r6
        L_0x004b:
            int r7 = r2.hashCode()
            switch(r7) {
                case 3239: goto L_0x00d7;
                case 3270: goto L_0x00cd;
                case 3295: goto L_0x00c3;
                case 3307: goto L_0x00b9;
                case 3308: goto L_0x00b0;
                case 3488: goto L_0x00a5;
                case 3633: goto L_0x009a;
                case 3646: goto L_0x008f;
                case 3669: goto L_0x0085;
                case 3679: goto L_0x0079;
                case 3681: goto L_0x006d;
                case 3705: goto L_0x0060;
                case 3710: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x00e1
        L_0x0054:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 5
            goto L_0x00e2
        L_0x0060:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 9
            goto L_0x00e2
        L_0x006d:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 1
            goto L_0x00e2
        L_0x0079:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 10
            goto L_0x00e2
        L_0x0085:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 6
            goto L_0x00e2
        L_0x008f:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 12
            goto L_0x00e2
        L_0x009a:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 8
            goto L_0x00e2
        L_0x00a5:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 11
            goto L_0x00e2
        L_0x00b0:
            java.lang.String r7 = "gs"
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L_0x00e1
            goto L_0x00e2
        L_0x00b9:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 0
            goto L_0x00e2
        L_0x00c3:
            java.lang.String r0 = "gf"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 4
            goto L_0x00e2
        L_0x00cd:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 3
            goto L_0x00e2
        L_0x00d7:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00e1
            r0 = 7
            goto L_0x00e2
        L_0x00e1:
            r0 = -1
        L_0x00e2:
            switch(r0) {
                case 0: goto L_0x0145;
                case 1: goto L_0x0140;
                case 2: goto L_0x013b;
                case 3: goto L_0x0135;
                case 4: goto L_0x012f;
                case 5: goto L_0x0129;
                case 6: goto L_0x0123;
                case 7: goto L_0x011d;
                case 8: goto L_0x0117;
                case 9: goto L_0x0111;
                case 10: goto L_0x010b;
                case 11: goto L_0x0100;
                case 12: goto L_0x00fa;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            java.lang.String r10 = "LOTTIE"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown shape type "
            r0.<init>(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r10, r0)
            goto L_0x019f
        L_0x00fa:
            com.airbnb.lottie.model.content.g r6 = com.airbnb.lottie.c.y.p(r9, r10)
            goto L_0x019f
        L_0x0100:
            com.airbnb.lottie.model.content.MergePaths r6 = com.airbnb.lottie.c.t.c(r9)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r10.bu(r0)
            goto L_0x019f
        L_0x010b:
            com.airbnb.lottie.model.content.PolystarShape r6 = com.airbnb.lottie.c.w.n(r9, r10)
            goto L_0x019f
        L_0x0111:
            com.airbnb.lottie.model.content.ShapeTrimPath r6 = com.airbnb.lottie.c.ae.t(r9, r10)
            goto L_0x019f
        L_0x0117:
            com.airbnb.lottie.model.content.f r6 = com.airbnb.lottie.c.x.o(r9, r10)
            goto L_0x019f
        L_0x011d:
            com.airbnb.lottie.model.content.a r6 = com.airbnb.lottie.c.e.b(r9, r10, r1)
            goto L_0x019f
        L_0x0123:
            com.airbnb.lottie.model.content.k r6 = com.airbnb.lottie.c.ac.r(r9, r10)
            goto L_0x019f
        L_0x0129:
            com.airbnb.lottie.model.a.l r6 = com.airbnb.lottie.c.c.d(r9, r10)
            goto L_0x019f
        L_0x012f:
            com.airbnb.lottie.model.content.d r6 = com.airbnb.lottie.c.k.j(r9, r10)
            goto L_0x019f
        L_0x0135:
            com.airbnb.lottie.model.content.i r6 = com.airbnb.lottie.c.ab.q(r9, r10)
            goto L_0x019f
        L_0x013b:
            com.airbnb.lottie.model.content.e r6 = com.airbnb.lottie.c.l.k(r9, r10)
            goto L_0x019f
        L_0x0140:
            com.airbnb.lottie.model.content.ShapeStroke r6 = com.airbnb.lottie.c.ad.s(r9, r10)
            goto L_0x019f
        L_0x0145:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x014a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0199
            java.lang.String r1 = r9.nextName()
            int r2 = r1.hashCode()
            r7 = 3371(0xd2b, float:4.724E-42)
            if (r2 == r7) goto L_0x016b
            r7 = 3519(0xdbf, float:4.931E-42)
            if (r2 == r7) goto L_0x0161
            goto L_0x0175
        L_0x0161:
            java.lang.String r2 = "nm"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0175
            r1 = 0
            goto L_0x0176
        L_0x016b:
            java.lang.String r2 = "it"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0175
            r1 = 1
            goto L_0x0176
        L_0x0175:
            r1 = -1
        L_0x0176:
            switch(r1) {
                case 0: goto L_0x0194;
                case 1: goto L_0x017d;
                default: goto L_0x0179;
            }
        L_0x0179:
            r9.skipValue()
            goto L_0x014a
        L_0x017d:
            r9.beginArray()
        L_0x0180:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0190
            com.airbnb.lottie.model.content.b r1 = i(r9, r10)
            if (r1 == 0) goto L_0x0180
            r0.add(r1)
            goto L_0x0180
        L_0x0190:
            r9.endArray()
            goto L_0x014a
        L_0x0194:
            java.lang.String r6 = r9.nextString()
            goto L_0x014a
        L_0x0199:
            com.airbnb.lottie.model.content.j r10 = new com.airbnb.lottie.model.content.j
            r10.<init>(r6, r0)
            r6 = r10
        L_0x019f:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01a9
            r9.skipValue()
            goto L_0x019f
        L_0x01a9:
            r9.endObject()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.g.i(android.util.JsonReader, com.airbnb.lottie.c):com.airbnb.lottie.model.content.b");
    }
}
    
