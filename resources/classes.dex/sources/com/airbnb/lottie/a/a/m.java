    package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.d.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;

public final class m implements j, l, a.C0012a {
    private final e le;
    @Nullable
    private r mH;
    private final a<?, PointF> mM;
    private boolean mO;
    private final String name;
    private final PolystarShape.Type ne;
    private final a<?, Float> nf;
    private final a<?, Float> ng;
    @Nullable
    private final a<?, Float> nh;
    private final a<?, Float> ni;
    @Nullable
    private final a<?, Float> nj;
    private final a<?, Float> nk;
    private final Path path = new Path();

    public m(e eVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.le = eVar;
        this.name = polystarShape.name;
        this.ne = polystarShape.ne;
        this.nf = polystarShape.ph.cO();
        this.mM = polystarShape.oG.cO();
        this.ng = polystarShape.oI.cO();
        this.ni = polystarShape.pj.cO();
        this.nk = polystarShape.pl.cO();
        if (this.ne == PolystarShape.Type.Star) {
            this.nh = polystarShape.pi.cO();
            this.nj = polystarShape.pk.cO();
        } else {
            this.nh = null;
            this.nj = null;
        }
        aVar.a(this.nf);
        aVar.a(this.mM);
        aVar.a(this.ng);
        aVar.a(this.ni);
        aVar.a(this.nk);
        if (this.ne == PolystarShape.Type.Star) {
            aVar.a(this.nh);
            aVar.a(this.nj);
        }
        this.nf.b(this);
        this.mM.b(this);
        this.ng.b(this);
        this.ni.b(this);
        this.nk.b(this);
        if (this.ne == PolystarShape.Type.Star) {
            this.nh.b(this);
            this.nj.b(this);
        }
    }

    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.nt == ShapeTrimPath.Type.Simultaneously) {
                    this.mH = rVar;
                    this.mH.a(this);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0292  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Path getPath() {
        /*
            r45 = this;
            r0 = r45
            boolean r1 = r0.mO
            if (r1 == 0) goto L_0x0009
            android.graphics.Path r1 = r0.path
            return r1
        L_0x0009:
            android.graphics.Path r1 = r0.path
            r1.reset()
            int[] r1 = com.airbnb.lottie.a.a.m.AnonymousClass1.nl
            com.airbnb.lottie.model.content.PolystarShape$Type r2 = r0.ne
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            r4 = 4636033603912859648(0x4056800000000000, double:90.0)
            r6 = 0
            r9 = 1120403456(0x42c80000, float:100.0)
            switch(r1) {
                case 1: goto L_0x0142;
                case 2: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0353
        L_0x002b:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r1 = r0.nf
            java.lang.Object r1 = r1.getValue()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            double r13 = (double) r1
            double r13 = java.lang.Math.floor(r13)
            int r1 = (int) r13
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r13 = r0.ng
            if (r13 != 0) goto L_0x0042
            goto L_0x004f
        L_0x0042:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r6 = r0.ng
            java.lang.Object r6 = r6.getValue()
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            double r6 = (double) r6
        L_0x004f:
            r13 = 0
            double r6 = r6 - r4
            double r4 = java.lang.Math.toRadians(r6)
            double r6 = (double) r1
            java.lang.Double.isNaN(r6)
            double r2 = r2 / r6
            float r1 = (float) r2
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r2 = r0.nk
            java.lang.Object r2 = r2.getValue()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            float r2 = r2 / r9
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r3 = r0.ni
            java.lang.Object r3 = r3.getValue()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            double r13 = (double) r3
            double r15 = java.lang.Math.cos(r4)
            java.lang.Double.isNaN(r13)
            double r8 = r13 * r15
            float r8 = (float) r8
            double r15 = java.lang.Math.sin(r4)
            java.lang.Double.isNaN(r13)
            double r10 = r13 * r15
            float r9 = (float) r10
            android.graphics.Path r10 = r0.path
            r10.moveTo(r8, r9)
            double r10 = (double) r1
            java.lang.Double.isNaN(r10)
            double r4 = r4 + r10
            double r6 = java.lang.Math.ceil(r6)
            r18 = r13
            r1 = 0
        L_0x009a:
            double r12 = (double) r1
            int r14 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r14 >= 0) goto L_0x012a
            double r12 = java.lang.Math.cos(r4)
            java.lang.Double.isNaN(r18)
            double r13 = r18 * r12
            float r12 = (float) r13
            double r13 = java.lang.Math.sin(r4)
            java.lang.Double.isNaN(r18)
            double r13 = r13 * r18
            float r13 = (float) r13
            r14 = 0
            int r15 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r15 == 0) goto L_0x0110
            double r14 = (double) r9
            r27 = r6
            double r6 = (double) r8
            double r6 = java.lang.Math.atan2(r14, r6)
            r14 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r6 = r6 - r14
            float r6 = (float) r6
            double r6 = (double) r6
            double r14 = java.lang.Math.cos(r6)
            float r14 = (float) r14
            double r6 = java.lang.Math.sin(r6)
            float r6 = (float) r6
            r31 = r4
            double r4 = (double) r13
            r33 = r10
            double r10 = (double) r12
            double r4 = java.lang.Math.atan2(r4, r10)
            r10 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r4 = r4 - r10
            float r4 = (float) r4
            double r4 = (double) r4
            double r10 = java.lang.Math.cos(r4)
            float r7 = (float) r10
            double r4 = java.lang.Math.sin(r4)
            float r4 = (float) r4
            float r5 = r3 * r2
            r10 = 1048576000(0x3e800000, float:0.25)
            float r5 = r5 * r10
            float r14 = r14 * r5
            float r6 = r6 * r5
            float r7 = r7 * r5
            float r5 = r5 * r4
            android.graphics.Path r4 = r0.path
            float r21 = r8 - r14
            float r22 = r9 - r6
            float r23 = r12 + r7
            float r24 = r13 + r5
            r20 = r4
            r25 = r12
            r26 = r13
            r20.cubicTo(r21, r22, r23, r24, r25, r26)
            goto L_0x011b
        L_0x0110:
            r31 = r4
            r27 = r6
            r33 = r10
            android.graphics.Path r4 = r0.path
            r4.lineTo(r12, r13)
        L_0x011b:
            java.lang.Double.isNaN(r33)
            double r4 = r31 + r33
            int r1 = r1 + 1
            r8 = r12
            r9 = r13
            r6 = r27
            r10 = r33
            goto L_0x009a
        L_0x012a:
            com.airbnb.lottie.a.b.a<?, android.graphics.PointF> r1 = r0.mM
            java.lang.Object r1 = r1.getValue()
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            android.graphics.Path r2 = r0.path
            float r3 = r1.x
            float r1 = r1.y
            r2.offset(r3, r1)
            android.graphics.Path r1 = r0.path
            r1.close()
            goto L_0x0353
        L_0x0142:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r1 = r0.nf
            java.lang.Object r1 = r1.getValue()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r8 = r0.ng
            if (r8 != 0) goto L_0x0153
            goto L_0x0160
        L_0x0153:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r6 = r0.ng
            java.lang.Object r6 = r6.getValue()
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            double r6 = (double) r6
        L_0x0160:
            r8 = 0
            double r6 = r6 - r4
            double r4 = java.lang.Math.toRadians(r6)
            double r6 = (double) r1
            java.lang.Double.isNaN(r6)
            double r2 = r2 / r6
            float r2 = (float) r2
            r3 = 1073741824(0x40000000, float:2.0)
            float r8 = r2 / r3
            int r10 = (int) r1
            float r10 = (float) r10
            float r1 = r1 - r10
            r10 = 0
            int r11 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r11 == 0) goto L_0x0182
            r10 = 1065353216(0x3f800000, float:1.0)
            float r10 = r10 - r1
            float r10 = r10 * r8
            double r10 = (double) r10
            java.lang.Double.isNaN(r10)
            double r4 = r4 + r10
        L_0x0182:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r10 = r0.ni
            java.lang.Object r10 = r10.getValue()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r11 = r0.nh
            java.lang.Object r11 = r11.getValue()
            java.lang.Float r11 = (java.lang.Float) r11
            float r11 = r11.floatValue()
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r12 = r0.nj
            if (r12 == 0) goto L_0x01ac
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r12 = r0.nj
            java.lang.Object r12 = r12.getValue()
            java.lang.Float r12 = (java.lang.Float) r12
            float r12 = r12.floatValue()
            float r12 = r12 / r9
            goto L_0x01ad
        L_0x01ac:
            r12 = 0
        L_0x01ad:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r13 = r0.nk
            if (r13 == 0) goto L_0x01c0
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r13 = r0.nk
            java.lang.Object r13 = r13.getValue()
            java.lang.Float r13 = (java.lang.Float) r13
            float r13 = r13.floatValue()
            float r9 = r13 / r9
            goto L_0x01c1
        L_0x01c0:
            r9 = 0
        L_0x01c1:
            r13 = 0
            int r14 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r14 == 0) goto L_0x01f2
            float r13 = r10 - r11
            float r13 = r13 * r1
            float r13 = r13 + r11
            double r14 = (double) r13
            double r18 = java.lang.Math.cos(r4)
            java.lang.Double.isNaN(r14)
            r35 = r11
            r36 = r12
            double r11 = r14 * r18
            float r11 = (float) r11
            double r18 = java.lang.Math.sin(r4)
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r18
            float r12 = (float) r14
            android.graphics.Path r14 = r0.path
            r14.moveTo(r11, r12)
            float r14 = r2 * r1
            float r14 = r14 / r3
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r4 = r4 + r14
            goto L_0x0217
        L_0x01f2:
            r35 = r11
            r36 = r12
            double r11 = (double) r10
            double r13 = java.lang.Math.cos(r4)
            java.lang.Double.isNaN(r11)
            double r13 = r13 * r11
            float r13 = (float) r13
            double r14 = java.lang.Math.sin(r4)
            java.lang.Double.isNaN(r11)
            double r11 = r11 * r14
            float r12 = (float) r11
            android.graphics.Path r11 = r0.path
            r11.moveTo(r13, r12)
            double r14 = (double) r8
            java.lang.Double.isNaN(r14)
            double r4 = r4 + r14
            r11 = r13
            r13 = 0
        L_0x0217:
            double r6 = java.lang.Math.ceil(r6)
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = r6 * r14
            r18 = r4
            r4 = 0
            r17 = 0
        L_0x0224:
            double r14 = (double) r4
            int r5 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x033d
            if (r17 == 0) goto L_0x022f
            r5 = r10
        L_0x022c:
            r16 = 0
            goto L_0x0232
        L_0x022f:
            r5 = r35
            goto L_0x022c
        L_0x0232:
            int r20 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r20 == 0) goto L_0x0245
            r20 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r22 = r6 - r20
            int r16 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r16 != 0) goto L_0x0247
            float r16 = r2 * r1
            float r16 = r16 / r3
            r3 = r16
            goto L_0x0248
        L_0x0245:
            r20 = 4611686018427387904(0x4000000000000000, double:2.0)
        L_0x0247:
            r3 = r8
        L_0x0248:
            r22 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r16 = 0
            int r24 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r24 == 0) goto L_0x025c
            double r24 = r6 - r22
            int r16 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
            if (r16 != 0) goto L_0x025c
            r37 = r2
            r38 = r3
            r5 = r13
            goto L_0x0260
        L_0x025c:
            r37 = r2
            r38 = r3
        L_0x0260:
            double r2 = (double) r5
            double r24 = java.lang.Math.cos(r18)
            java.lang.Double.isNaN(r2)
            r39 = r13
            r40 = r14
            double r13 = r2 * r24
            float r5 = (float) r13
            double r13 = java.lang.Math.sin(r18)
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r13
            float r2 = (float) r2
            r3 = 0
            int r13 = (r36 > r3 ? 1 : (r36 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x0292
            int r13 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x0292
            android.graphics.Path r3 = r0.path
            r3.lineTo(r5, r2)
            r42 = r8
            r43 = r9
            r44 = r10
            r3 = r38
            r8 = 0
            goto L_0x0323
        L_0x0292:
            double r13 = (double) r12
            r42 = r8
            r43 = r9
            double r8 = (double) r11
            double r8 = java.lang.Math.atan2(r13, r8)
            r13 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r8 = r8 - r13
            float r3 = (float) r8
            double r8 = (double) r3
            double r13 = java.lang.Math.cos(r8)
            float r3 = (float) r13
            double r8 = java.lang.Math.sin(r8)
            float r8 = (float) r8
            double r13 = (double) r2
            r44 = r10
            double r9 = (double) r5
            double r9 = java.lang.Math.atan2(r13, r9)
            r13 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r9 = r9 - r13
            float r9 = (float) r9
            double r9 = (double) r9
            double r13 = java.lang.Math.cos(r9)
            float r13 = (float) r13
            double r9 = java.lang.Math.sin(r9)
            float r9 = (float) r9
            if (r17 == 0) goto L_0x02cd
            r10 = r36
            goto L_0x02cf
        L_0x02cd:
            r10 = r43
        L_0x02cf:
            if (r17 == 0) goto L_0x02d4
            r14 = r43
            goto L_0x02d6
        L_0x02d4:
            r14 = r36
        L_0x02d6:
            if (r17 == 0) goto L_0x02db
            r15 = r35
            goto L_0x02dd
        L_0x02db:
            r15 = r44
        L_0x02dd:
            if (r17 == 0) goto L_0x02e2
            r16 = r44
            goto L_0x02e4
        L_0x02e2:
            r16 = r35
        L_0x02e4:
            float r15 = r15 * r10
            r10 = 1056236141(0x3ef4e26d, float:0.47829)
            float r15 = r15 * r10
            float r3 = r3 * r15
            float r15 = r15 * r8
            float r16 = r16 * r14
            float r16 = r16 * r10
            float r13 = r13 * r16
            float r16 = r16 * r9
            r8 = 0
            int r9 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x030e
            if (r4 != 0) goto L_0x0303
            float r3 = r3 * r1
            float r15 = r15 * r1
            goto L_0x030e
        L_0x0303:
            r9 = 0
            double r9 = r6 - r22
            int r14 = (r40 > r9 ? 1 : (r40 == r9 ? 0 : -1))
            if (r14 != 0) goto L_0x030e
            float r13 = r13 * r1
            float r16 = r16 * r1
        L_0x030e:
            android.graphics.Path r9 = r0.path
            float r25 = r11 - r3
            float r26 = r12 - r15
            float r27 = r5 + r13
            float r28 = r2 + r16
            r24 = r9
            r29 = r5
            r30 = r2
            r24.cubicTo(r25, r26, r27, r28, r29, r30)
            r3 = r38
        L_0x0323:
            double r9 = (double) r3
            java.lang.Double.isNaN(r9)
            double r18 = r18 + r9
            r17 = r17 ^ 1
            int r4 = r4 + 1
            r12 = r2
            r11 = r5
            r2 = r37
            r13 = r39
            r8 = r42
            r9 = r43
            r10 = r44
            r3 = 1073741824(0x40000000, float:2.0)
            goto L_0x0224
        L_0x033d:
            com.airbnb.lottie.a.b.a<?, android.graphics.PointF> r1 = r0.mM
            java.lang.Object r1 = r1.getValue()
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            android.graphics.Path r2 = r0.path
            float r3 = r1.x
            float r1 = r1.y
            r2.offset(r3, r1)
            android.graphics.Path r1 = r0.path
            r1.close()
        L_0x0353:
            android.graphics.Path r1 = r0.path
            r1.close()
            android.graphics.Path r1 = r0.path
            com.airbnb.lottie.a.a.r r2 = r0.mH
            com.airbnb.lottie.d.e.a(r1, r2)
            r1 = 1
            r0.mO = r1
            android.graphics.Path r1 = r0.path
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.m.getPath():android.graphics.Path");
    }

    public final String getName() {
        return this.name;
    }

    public final void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        d.a(eVar, i, list, eVar2, this);
    }

    public final <T> void a(T t, @Nullable c<T> cVar) {
        if (t == h.mc) {
            this.nf.a(cVar);
        } else if (t == h.md) {
            this.ng.a(cVar);
        } else if (t == h.lV) {
            this.mM.a(cVar);
        } else if (t == h.me && this.nh != null) {
            this.nh.a(cVar);
        } else if (t == h.mf) {
            this.ni.a(cVar);
        } else if (t == h.mg && this.nj != null) {
            this.nj.a(cVar);
        } else if (t == h.mh) {
            this.nk.a(cVar);
        }
    }

    public final void cD() {
        this.mO = false;
        this.le.invalidateSelf();
    }
}
    
