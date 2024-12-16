    package com.airbnb.lottie.a.a;

import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.e;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.model.content.d;
import java.util.ArrayList;
import java.util.List;

public final class g implements d, j, a.C0012a {
    private final e le;
    private final a<Integer, Integer> mC;
    @Nullable
    private a<ColorFilter, ColorFilter> mF;
    private final List<l> mG = new ArrayList();
    private final a<c, c> mP;
    private final LongSparseArray<LinearGradient> mQ = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> mR = new LongSparseArray<>();
    private final Matrix mS = new Matrix();
    private final RectF mT = new RectF();
    private final GradientType mU;
    private final a<PointF, PointF> mV;
    private final a<PointF, PointF> mW;
    private final int mZ;
    private final com.airbnb.lottie.model.layer.a mx;
    @NonNull
    private final String name;
    private final Paint paint = new Paint(1);
    private final Path path = new Path();

    public g(e eVar, com.airbnb.lottie.model.layer.a aVar, d dVar) {
        this.mx = aVar;
        this.name = dVar.name;
        this.le = eVar;
        this.mU = dVar.oQ;
        this.path.setFillType(dVar.oR);
        this.mZ = (int) (eVar.lB.ct() / 32.0f);
        this.mP = dVar.oS.cO();
        this.mP.b(this);
        aVar.a(this.mP);
        this.mC = dVar.oJ.cO();
        this.mC.b(this);
        aVar.a(this.mC);
        this.mV = dVar.oT.cO();
        this.mV.b(this);
        aVar.a(this.mV);
        this.mW = dVar.oU.cO();
        this.mW.b(this);
        aVar.a(this.mW);
    }

    public final void cD() {
        this.le.invalidateSelf();
    }

    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            b bVar = list2.get(i);
            if (bVar instanceof l) {
                this.mG.add((l) bVar);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: android.graphics.LinearGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: android.graphics.RadialGradient} */
    /* JADX WARNING: type inference failed for: r2v23, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.graphics.Canvas r16, android.graphics.Matrix r17, int r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r17
            com.airbnb.lottie.b.cq()
            android.graphics.Path r2 = r0.path
            r2.reset()
            r2 = 0
            r3 = 0
        L_0x000d:
            java.util.List<com.airbnb.lottie.a.a.l> r4 = r0.mG
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x0029
            android.graphics.Path r4 = r0.path
            java.util.List<com.airbnb.lottie.a.a.l> r5 = r0.mG
            java.lang.Object r5 = r5.get(r3)
            com.airbnb.lottie.a.a.l r5 = (com.airbnb.lottie.a.a.l) r5
            android.graphics.Path r5 = r5.getPath()
            r4.addPath(r5, r1)
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0029:
            android.graphics.Path r3 = r0.path
            android.graphics.RectF r4 = r0.mT
            r3.computeBounds(r4, r2)
            com.airbnb.lottie.model.content.GradientType r2 = r0.mU
            com.airbnb.lottie.model.content.GradientType r3 = com.airbnb.lottie.model.content.GradientType.Linear
            if (r2 != r3) goto L_0x007a
            int r2 = r15.cG()
            android.support.v4.util.LongSparseArray<android.graphics.LinearGradient> r3 = r0.mQ
            long r4 = (long) r2
            java.lang.Object r2 = r3.get(r4)
            android.graphics.LinearGradient r2 = (android.graphics.LinearGradient) r2
            if (r2 == 0) goto L_0x0047
            goto L_0x00c4
        L_0x0047:
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r2 = r0.mV
            java.lang.Object r2 = r2.getValue()
            android.graphics.PointF r2 = (android.graphics.PointF) r2
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r3 = r0.mW
            java.lang.Object r3 = r3.getValue()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> r6 = r0.mP
            java.lang.Object r6 = r6.getValue()
            com.airbnb.lottie.model.content.c r6 = (com.airbnb.lottie.model.content.c) r6
            int[] r12 = r6.oP
            float[] r13 = r6.oO
            android.graphics.LinearGradient r6 = new android.graphics.LinearGradient
            float r8 = r2.x
            float r9 = r2.y
            float r10 = r3.x
            float r11 = r3.y
            android.graphics.Shader$TileMode r14 = android.graphics.Shader.TileMode.CLAMP
            r7 = r6
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            android.support.v4.util.LongSparseArray<android.graphics.LinearGradient> r2 = r0.mQ
            r2.put(r4, r6)
            r2 = r6
            goto L_0x00c4
        L_0x007a:
            int r2 = r15.cG()
            android.support.v4.util.LongSparseArray<android.graphics.RadialGradient> r3 = r0.mR
            long r4 = (long) r2
            java.lang.Object r2 = r3.get(r4)
            android.graphics.RadialGradient r2 = (android.graphics.RadialGradient) r2
            if (r2 == 0) goto L_0x008a
            goto L_0x00c4
        L_0x008a:
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r2 = r0.mV
            java.lang.Object r2 = r2.getValue()
            android.graphics.PointF r2 = (android.graphics.PointF) r2
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r3 = r0.mW
            java.lang.Object r3 = r3.getValue()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> r6 = r0.mP
            java.lang.Object r6 = r6.getValue()
            com.airbnb.lottie.model.content.c r6 = (com.airbnb.lottie.model.content.c) r6
            int[] r11 = r6.oP
            float[] r12 = r6.oO
            float r8 = r2.x
            float r9 = r2.y
            float r2 = r3.x
            float r3 = r3.y
            float r2 = r2 - r8
            double r6 = (double) r2
            float r3 = r3 - r9
            double r2 = (double) r3
            double r2 = java.lang.Math.hypot(r6, r2)
            float r10 = (float) r2
            android.graphics.RadialGradient r2 = new android.graphics.RadialGradient
            android.graphics.Shader$TileMode r13 = android.graphics.Shader.TileMode.CLAMP
            r7 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13)
            android.support.v4.util.LongSparseArray<android.graphics.RadialGradient> r3 = r0.mR
            r3.put(r4, r2)
        L_0x00c4:
            android.graphics.Matrix r3 = r0.mS
            r3.set(r1)
            android.graphics.Matrix r1 = r0.mS
            r2.setLocalMatrix(r1)
            android.graphics.Paint r1 = r0.paint
            r1.setShader(r2)
            com.airbnb.lottie.a.b.a<android.graphics.ColorFilter, android.graphics.ColorFilter> r1 = r0.mF
            if (r1 == 0) goto L_0x00e4
            android.graphics.Paint r1 = r0.paint
            com.airbnb.lottie.a.b.a<android.graphics.ColorFilter, android.graphics.ColorFilter> r2 = r0.mF
            java.lang.Object r2 = r2.getValue()
            android.graphics.ColorFilter r2 = (android.graphics.ColorFilter) r2
            r1.setColorFilter(r2)
        L_0x00e4:
            r1 = r18
            float r1 = (float) r1
            r2 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 / r2
            com.airbnb.lottie.a.b.a<java.lang.Integer, java.lang.Integer> r3 = r0.mC
            java.lang.Object r3 = r3.getValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            float r3 = (float) r3
            float r1 = r1 * r3
            r3 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r3
            float r1 = r1 * r2
            int r1 = (int) r1
            android.graphics.Paint r2 = r0.paint
            int r1 = com.airbnb.lottie.d.d.J(r1)
            r2.setAlpha(r1)
            android.graphics.Path r1 = r0.path
            android.graphics.Paint r2 = r0.paint
            r3 = r16
            r3.drawPath(r1, r2)
            com.airbnb.lottie.b.cr()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.g.a(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.mG.size(); i++) {
            this.path.addPath(this.mG.get(i).getPath(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final String getName() {
        return this.name;
    }

    private int cG() {
        int round = Math.round(this.mV.progress * ((float) this.mZ));
        int round2 = Math.round(this.mW.progress * ((float) this.mZ));
        int round3 = Math.round(this.mP.progress * ((float) this.mZ));
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    public final void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.d.a(eVar, i, list, eVar2, this);
    }

    public final <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t != h.ml) {
            return;
        }
        if (cVar == null) {
            this.mF = null;
            return;
        }
        this.mF = new p(cVar);
        this.mF.b(this);
        this.mx.a(this.mF);
    }
}
    
