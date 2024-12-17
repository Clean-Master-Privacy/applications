    package com.airbnb.lottie.c;

import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.c;
import com.airbnb.lottie.e.a;
import java.io.IOException;
import java.lang.ref.WeakReference;

class o {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static SparseArrayCompat<WeakReference<Interpolator>> qL;

    o() {
    }

    @Nullable
    private static WeakReference<Interpolator> H(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (o.class) {
            if (qL == null) {
                qL = new SparseArrayCompat<>();
            }
            weakReference = (WeakReference) qL.get(i);
        }
        return weakReference;
    }

    static <T> a<T> a(JsonReader jsonReader, c cVar, float f, af<T> afVar, boolean z) throws IOException {
        if (z) {
            return a(cVar, jsonReader, f, afVar);
        }
        return new a<>(afVar.a(jsonReader, f));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: android.view.animation.Interpolator} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.airbnb.lottie.e.a<T> a(com.airbnb.lottie.c r16, android.util.JsonReader r17, float r18, com.airbnb.lottie.c.af<T> r19) throws java.io.IOException {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r17.beginObject()
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = r6
            r8 = r7
            r9 = r8
            r13 = r9
            r14 = r13
            r5 = 0
            r11 = 0
        L_0x0013:
            boolean r10 = r17.hasNext()
            if (r10 == 0) goto L_0x00b6
            java.lang.String r10 = r17.nextName()
            r12 = -1
            int r15 = r10.hashCode()
            r3 = 1
            switch(r15) {
                case 101: goto L_0x0070;
                case 104: goto L_0x0066;
                case 105: goto L_0x005c;
                case 111: goto L_0x0052;
                case 115: goto L_0x0048;
                case 116: goto L_0x003d;
                case 3701: goto L_0x0032;
                case 3707: goto L_0x0027;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x007a
        L_0x0027:
            java.lang.String r15 = "to"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r10 = 6
            goto L_0x007b
        L_0x0032:
            java.lang.String r15 = "ti"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r10 = 7
            goto L_0x007b
        L_0x003d:
            java.lang.String r15 = "t"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r10 = 0
            goto L_0x007b
        L_0x0048:
            java.lang.String r15 = "s"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r10 = 1
            goto L_0x007b
        L_0x0052:
            java.lang.String r15 = "o"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r10 = 3
            goto L_0x007b
        L_0x005c:
            java.lang.String r15 = "i"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r10 = 4
            goto L_0x007b
        L_0x0066:
            java.lang.String r15 = "h"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r10 = 5
            goto L_0x007b
        L_0x0070:
            java.lang.String r15 = "e"
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r10 = 2
            goto L_0x007b
        L_0x007a:
            r10 = -1
        L_0x007b:
            switch(r10) {
                case 0: goto L_0x00af;
                case 1: goto L_0x00a9;
                case 2: goto L_0x00a3;
                case 3: goto L_0x009d;
                case 4: goto L_0x0097;
                case 5: goto L_0x008c;
                case 6: goto L_0x0087;
                case 7: goto L_0x0082;
                default: goto L_0x007e;
            }
        L_0x007e:
            r17.skipValue()
            goto L_0x0013
        L_0x0082:
            android.graphics.PointF r14 = com.airbnb.lottie.c.n.c(r17, r18)
            goto L_0x0013
        L_0x0087:
            android.graphics.PointF r13 = com.airbnb.lottie.c.n.c(r17, r18)
            goto L_0x0013
        L_0x008c:
            int r5 = r17.nextInt()
            if (r5 != r3) goto L_0x0094
            r5 = 1
            goto L_0x0013
        L_0x0094:
            r5 = 0
            goto L_0x0013
        L_0x0097:
            android.graphics.PointF r7 = com.airbnb.lottie.c.n.c(r17, r18)
            goto L_0x0013
        L_0x009d:
            android.graphics.PointF r6 = com.airbnb.lottie.c.n.c(r17, r18)
            goto L_0x0013
        L_0x00a3:
            java.lang.Object r9 = r2.a(r0, r1)
            goto L_0x0013
        L_0x00a9:
            java.lang.Object r8 = r2.a(r0, r1)
            goto L_0x0013
        L_0x00af:
            double r10 = r17.nextDouble()
            float r11 = (float) r10
            goto L_0x0013
        L_0x00b6:
            r17.endObject()
            if (r5 == 0) goto L_0x00c0
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
            r10 = r0
            r9 = r8
            goto L_0x012d
        L_0x00c0:
            if (r6 == 0) goto L_0x012a
            if (r7 == 0) goto L_0x012a
            float r0 = r6.x
            float r2 = -r1
            float r0 = com.airbnb.lottie.d.d.clamp(r0, r2, r1)
            r6.x = r0
            float r0 = r6.y
            r3 = 1120403456(0x42c80000, float:100.0)
            r5 = -1027080192(0xffffffffc2c80000, float:-100.0)
            float r0 = com.airbnb.lottie.d.d.clamp(r0, r5, r3)
            r6.y = r0
            float r0 = r7.x
            float r0 = com.airbnb.lottie.d.d.clamp(r0, r2, r1)
            r7.x = r0
            float r0 = r7.y
            float r0 = com.airbnb.lottie.d.d.clamp(r0, r5, r3)
            r7.y = r0
            float r0 = r6.x
            float r2 = r6.y
            float r3 = r7.x
            float r5 = r7.y
            int r0 = com.airbnb.lottie.d.e.b(r0, r2, r3, r5)
            java.lang.ref.WeakReference r2 = H(r0)
            if (r2 == 0) goto L_0x0102
            java.lang.Object r3 = r2.get()
            r4 = r3
            android.view.animation.Interpolator r4 = (android.view.animation.Interpolator) r4
        L_0x0102:
            if (r2 == 0) goto L_0x0106
            if (r4 != 0) goto L_0x0128
        L_0x0106:
            float r2 = r6.x
            float r2 = r2 / r1
            float r3 = r6.y
            float r3 = r3 / r1
            float r4 = r7.x
            float r4 = r4 / r1
            float r5 = r7.y
            float r5 = r5 / r1
            android.view.animation.Interpolator r4 = android.support.v4.view.animation.PathInterpolatorCompat.create(r2, r3, r4, r5)
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0128 }
            r1.<init>(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0128 }
            java.lang.Class<com.airbnb.lottie.c.o> r2 = com.airbnb.lottie.c.o.class
            monitor-enter(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0128 }
            android.support.v4.util.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> r3 = qL     // Catch:{ all -> 0x0125 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0125 }
            monitor-exit(r2)     // Catch:{ all -> 0x0125 }
            goto L_0x0128
        L_0x0125:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0125 }
            throw r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0128 }
        L_0x0128:
            r10 = r4
            goto L_0x012d
        L_0x012a:
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
            r10 = r0
        L_0x012d:
            com.airbnb.lottie.e.a r0 = new com.airbnb.lottie.e.a
            r12 = 0
            r6 = r0
            r7 = r16
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r0.ri = r13
            r0.rj = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.o.a(com.airbnb.lottie.c, android.util.JsonReader, float, com.airbnb.lottie.c.af):com.airbnb.lottie.e.a");
    }
}
    
