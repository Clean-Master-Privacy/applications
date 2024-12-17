    package com.airbnb.lottie.c;

final class s {
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        if (r0.equals("a") != false) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.Mask m(android.util.JsonReader r10, com.airbnb.lottie.c r11) throws java.io.IOException {
        /*
            r10.beginObject()
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0006:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x00b9
            java.lang.String r3 = r10.nextName()
            int r4 = r3.hashCode()
            r5 = 111(0x6f, float:1.56E-43)
            r6 = 0
            r7 = 1
            r8 = 2
            r9 = -1
            if (r4 == r5) goto L_0x003a
            r5 = 3588(0xe04, float:5.028E-42)
            if (r4 == r5) goto L_0x0030
            r5 = 3357091(0x3339a3, float:4.704286E-39)
            if (r4 == r5) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            java.lang.String r4 = "mode"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0044
            r4 = 0
            goto L_0x0045
        L_0x0030:
            java.lang.String r4 = "pt"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0044
            r4 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r4 = "o"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0044
            r4 = 2
            goto L_0x0045
        L_0x0044:
            r4 = -1
        L_0x0045:
            switch(r4) {
                case 0: goto L_0x0056;
                case 1: goto L_0x0051;
                case 2: goto L_0x004c;
                default: goto L_0x0048;
            }
        L_0x0048:
            r10.skipValue()
            goto L_0x0006
        L_0x004c:
            com.airbnb.lottie.model.a.d r2 = com.airbnb.lottie.c.d.e(r10, r11)
            goto L_0x0006
        L_0x0051:
            com.airbnb.lottie.model.a.h r1 = com.airbnb.lottie.c.d.g(r10, r11)
            goto L_0x0006
        L_0x0056:
            java.lang.String r0 = r10.nextString()
            int r4 = r0.hashCode()
            r5 = 97
            if (r4 == r5) goto L_0x007f
            r5 = 105(0x69, float:1.47E-43)
            if (r4 == r5) goto L_0x0075
            r5 = 115(0x73, float:1.61E-43)
            if (r4 == r5) goto L_0x006b
            goto L_0x0088
        L_0x006b:
            java.lang.String r4 = "s"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0088
            r6 = 1
            goto L_0x0089
        L_0x0075:
            java.lang.String r4 = "i"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0088
            r6 = 2
            goto L_0x0089
        L_0x007f:
            java.lang.String r4 = "a"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r6 = -1
        L_0x0089:
            switch(r6) {
                case 0: goto L_0x00b5;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00a8;
                default: goto L_0x008c;
            }
        L_0x008c:
            java.lang.String r0 = "LOTTIE"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Unknown mask mode "
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = ". Defaulting to Add."
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r0, r3)
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeAdd
            goto L_0x0006
        L_0x00a8:
            java.lang.String r0 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r11.bu(r0)
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeIntersect
            goto L_0x0006
        L_0x00b1:
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeSubtract
            goto L_0x0006
        L_0x00b5:
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeAdd
            goto L_0x0006
        L_0x00b9:
            r10.endObject()
            com.airbnb.lottie.model.content.Mask r10 = new com.airbnb.lottie.model.content.Mask
            r10.<init>(r0, r1, r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.s.m(android.util.JsonReader, com.airbnb.lottie.c):com.airbnb.lottie.model.content.Mask");
    }
}
    
