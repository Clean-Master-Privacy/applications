    package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.a.b.h;
import com.airbnb.lottie.c;
import com.airbnb.lottie.model.a.e;
import java.io.IOException;
import java.util.ArrayList;

public final class a {
    public static e a(JsonReader jsonReader, c cVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(new h(cVar, o.a(jsonReader, cVar, com.airbnb.lottie.d.e.dd(), u.qM, jsonReader.peek() == JsonToken.BEGIN_OBJECT)));
            }
            jsonReader.endArray();
            p.o(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.e.a(n.c(jsonReader, com.airbnb.lottie.d.e.dd())));
        }
        return new e(arrayList);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006a A[PHI: r1 
      PHI: (r1v4 boolean) = (r1v2 boolean), (r1v5 boolean) binds: [B:16:0x0044, B:22:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.a.m<android.graphics.PointF, android.graphics.PointF> b(android.util.JsonReader r10, com.airbnb.lottie.c r11) throws java.io.IOException {
        /*
            r10.beginObject()
            r0 = 0
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
            r1 = 0
        L_0x0009:
            android.util.JsonToken r5 = r10.peek()
            android.util.JsonToken r6 = android.util.JsonToken.END_OBJECT
            if (r5 == r6) goto L_0x006e
            java.lang.String r5 = r10.nextName()
            r6 = -1
            int r7 = r5.hashCode()
            r8 = 107(0x6b, float:1.5E-43)
            r9 = 1
            if (r7 == r8) goto L_0x0039
            switch(r7) {
                case 120: goto L_0x002e;
                case 121: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0043
        L_0x0023:
            java.lang.String r7 = "y"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0043
            r5 = 2
            goto L_0x0044
        L_0x002e:
            java.lang.String r7 = "x"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0043
            r5 = 1
            goto L_0x0044
        L_0x0039:
            java.lang.String r7 = "k"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0043
            r5 = 0
            goto L_0x0044
        L_0x0043:
            r5 = -1
        L_0x0044:
            switch(r5) {
                case 0: goto L_0x0065;
                case 1: goto L_0x0056;
                case 2: goto L_0x0048;
                default: goto L_0x0047;
            }
        L_0x0047:
            goto L_0x006a
        L_0x0048:
            android.util.JsonToken r5 = r10.peek()
            android.util.JsonToken r6 = android.util.JsonToken.STRING
            if (r5 != r6) goto L_0x0051
            goto L_0x005e
        L_0x0051:
            com.airbnb.lottie.model.a.b r4 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r10, (com.airbnb.lottie.c) r11, (boolean) r9)
            goto L_0x0009
        L_0x0056:
            android.util.JsonToken r5 = r10.peek()
            android.util.JsonToken r6 = android.util.JsonToken.STRING
            if (r5 != r6) goto L_0x0060
        L_0x005e:
            r1 = 1
            goto L_0x006a
        L_0x0060:
            com.airbnb.lottie.model.a.b r3 = com.airbnb.lottie.c.d.a((android.util.JsonReader) r10, (com.airbnb.lottie.c) r11, (boolean) r9)
            goto L_0x0009
        L_0x0065:
            com.airbnb.lottie.model.a.e r2 = a(r10, r11)
            goto L_0x0009
        L_0x006a:
            r10.skipValue()
            goto L_0x0009
        L_0x006e:
            r10.endObject()
            if (r1 == 0) goto L_0x0078
            java.lang.String r10 = "Lottie doesn't support expressions."
            r11.bu(r10)
        L_0x0078:
            if (r2 == 0) goto L_0x007b
            return r2
        L_0x007b:
            com.airbnb.lottie.model.a.i r10 = new com.airbnb.lottie.model.a.i
            r10.<init>(r3, r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.a.b(android.util.JsonReader, com.airbnb.lottie.c):com.airbnb.lottie.model.a.m");
    }
}
    
