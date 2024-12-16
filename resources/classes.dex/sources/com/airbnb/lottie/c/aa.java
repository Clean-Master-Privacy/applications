    package com.airbnb.lottie.c;

import com.airbnb.lottie.model.content.h;

public final class aa implements af<h> {
    public static final aa qP = new aa();

    private aa() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0013 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(android.util.JsonReader r13, float r14) throws java.io.IOException {
        /*
            r12 = this;
            android.util.JsonToken r0 = r13.peek()
            android.util.JsonToken r1 = android.util.JsonToken.BEGIN_ARRAY
            if (r0 != r1) goto L_0x000b
            r13.beginArray()
        L_0x000b:
            r13.beginObject()
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r2
            r4 = 0
        L_0x0013:
            boolean r5 = r13.hasNext()
            r6 = 1
            if (r5 == 0) goto L_0x0076
            java.lang.String r5 = r13.nextName()
            r7 = -1
            int r8 = r5.hashCode()
            r9 = 99
            if (r8 == r9) goto L_0x0053
            r9 = 105(0x69, float:1.47E-43)
            if (r8 == r9) goto L_0x0049
            r9 = 111(0x6f, float:1.56E-43)
            if (r8 == r9) goto L_0x003f
            r9 = 118(0x76, float:1.65E-43)
            if (r8 == r9) goto L_0x0034
            goto L_0x005d
        L_0x0034:
            java.lang.String r8 = "v"
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x005d
            r5 = 1
            goto L_0x005e
        L_0x003f:
            java.lang.String r6 = "o"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x005d
            r5 = 3
            goto L_0x005e
        L_0x0049:
            java.lang.String r6 = "i"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x005d
            r5 = 2
            goto L_0x005e
        L_0x0053:
            java.lang.String r6 = "c"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x005d
            r5 = 0
            goto L_0x005e
        L_0x005d:
            r5 = -1
        L_0x005e:
            switch(r5) {
                case 0: goto L_0x0071;
                case 1: goto L_0x006c;
                case 2: goto L_0x0067;
                case 3: goto L_0x0062;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x0013
        L_0x0062:
            java.util.List r3 = com.airbnb.lottie.c.n.b(r13, r14)
            goto L_0x0013
        L_0x0067:
            java.util.List r2 = com.airbnb.lottie.c.n.b(r13, r14)
            goto L_0x0013
        L_0x006c:
            java.util.List r0 = com.airbnb.lottie.c.n.b(r13, r14)
            goto L_0x0013
        L_0x0071:
            boolean r4 = r13.nextBoolean()
            goto L_0x0013
        L_0x0076:
            r13.endObject()
            android.util.JsonToken r14 = r13.peek()
            android.util.JsonToken r5 = android.util.JsonToken.END_ARRAY
            if (r14 != r5) goto L_0x0084
            r13.endArray()
        L_0x0084:
            if (r0 == 0) goto L_0x010f
            if (r2 == 0) goto L_0x010f
            if (r3 == 0) goto L_0x010f
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L_0x009f
            com.airbnb.lottie.model.content.h r13 = new com.airbnb.lottie.model.content.h
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>()
            java.util.List r0 = java.util.Collections.emptyList()
            r13.<init>(r14, r1, r0)
            return r13
        L_0x009f:
            int r13 = r0.size()
            java.lang.Object r14 = r0.get(r1)
            android.graphics.PointF r14 = (android.graphics.PointF) r14
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r13)
            r7 = 1
        L_0x00af:
            if (r7 >= r13) goto L_0x00de
            java.lang.Object r8 = r0.get(r7)
            android.graphics.PointF r8 = (android.graphics.PointF) r8
            int r9 = r7 + -1
            java.lang.Object r10 = r0.get(r9)
            android.graphics.PointF r10 = (android.graphics.PointF) r10
            java.lang.Object r9 = r3.get(r9)
            android.graphics.PointF r9 = (android.graphics.PointF) r9
            java.lang.Object r11 = r2.get(r7)
            android.graphics.PointF r11 = (android.graphics.PointF) r11
            android.graphics.PointF r9 = com.airbnb.lottie.d.d.a((android.graphics.PointF) r10, (android.graphics.PointF) r9)
            android.graphics.PointF r10 = com.airbnb.lottie.d.d.a((android.graphics.PointF) r8, (android.graphics.PointF) r11)
            com.airbnb.lottie.model.a r11 = new com.airbnb.lottie.model.a
            r11.<init>(r9, r10, r8)
            r5.add(r11)
            int r7 = r7 + 1
            goto L_0x00af
        L_0x00de:
            if (r4 == 0) goto L_0x0109
            java.lang.Object r7 = r0.get(r1)
            android.graphics.PointF r7 = (android.graphics.PointF) r7
            int r13 = r13 - r6
            java.lang.Object r0 = r0.get(r13)
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            java.lang.Object r13 = r3.get(r13)
            android.graphics.PointF r13 = (android.graphics.PointF) r13
            java.lang.Object r1 = r2.get(r1)
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            android.graphics.PointF r13 = com.airbnb.lottie.d.d.a((android.graphics.PointF) r0, (android.graphics.PointF) r13)
            android.graphics.PointF r0 = com.airbnb.lottie.d.d.a((android.graphics.PointF) r7, (android.graphics.PointF) r1)
            com.airbnb.lottie.model.a r1 = new com.airbnb.lottie.model.a
            r1.<init>(r13, r0, r7)
            r5.add(r1)
        L_0x0109:
            com.airbnb.lottie.model.content.h r13 = new com.airbnb.lottie.model.content.h
            r13.<init>(r14, r4, r5)
            return r13
        L_0x010f:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Shape data was missing information."
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.aa.a(android.util.JsonReader, float):java.lang.Object");
    }
}
    
