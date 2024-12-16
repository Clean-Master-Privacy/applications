    package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.d.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.g;
import java.util.List;

public final class o implements d, i, j, l, a.C0012a {
    private final e le;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.model.layer.a mx;
    private final String name;
    private final a<Float, Float> nn;
    private final a<Float, Float> no;
    private final com.airbnb.lottie.a.b.o nq;
    private c nr;
    private final Path path = new Path();

    public o(e eVar, com.airbnb.lottie.model.layer.a aVar, g gVar) {
        this.le = eVar;
        this.mx = aVar;
        this.name = gVar.name;
        this.nn = gVar.pp.cO();
        aVar.a(this.nn);
        this.nn.b(this);
        this.no = gVar.pq.cO();
        aVar.a(this.no);
        this.no.b(this);
        this.nq = gVar.pr.cQ();
        this.nq.a(aVar);
        this.nq.a((a.C0012a) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ListIterator<com.airbnb.lottie.a.a.b> r8) {
        /*
            r7 = this;
            com.airbnb.lottie.a.a.c r0 = r7.nr
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.hasPrevious()
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r8.previous()
            if (r0 != r7) goto L_0x0005
        L_0x0011:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0016:
            boolean r0 = r8.hasPrevious()
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r8.previous()
            r5.add(r0)
            r8.remove()
            goto L_0x0016
        L_0x0027:
            java.util.Collections.reverse(r5)
            com.airbnb.lottie.a.a.c r8 = new com.airbnb.lottie.a.a.c
            com.airbnb.lottie.e r2 = r7.le
            com.airbnb.lottie.model.layer.a r3 = r7.mx
            java.lang.String r4 = "Repeater"
            r6 = 0
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r7.nr = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.o.a(java.util.ListIterator):void");
    }

    public final String getName() {
        return this.name;
    }

    public final void b(List<b> list, List<b> list2) {
        this.nr.b(list, list2);
    }

    public final Path getPath() {
        Path path2 = this.nr.getPath();
        this.path.reset();
        float floatValue = this.nn.getValue().floatValue();
        float floatValue2 = this.no.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.nq.h(((float) i) + floatValue2));
            this.path.addPath(path2, this.matrix);
        }
        return this.path;
    }

    public final void a(Canvas canvas, Matrix matrix2, int i) {
        float floatValue = this.nn.getValue().floatValue();
        float floatValue2 = this.no.getValue().floatValue();
        float floatValue3 = this.nq.nS.getValue().floatValue() / 100.0f;
        float floatValue4 = this.nq.nT.getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix2);
            float f = (float) i2;
            this.matrix.preConcat(this.nq.h(f + floatValue2));
            this.nr.a(canvas, this.matrix, (int) (((float) i) * (((f / floatValue) * (floatValue4 - floatValue3)) + floatValue3)));
        }
    }

    public final void a(RectF rectF, Matrix matrix2) {
        this.nr.a(rectF, matrix2);
    }

    public final void cD() {
        this.le.invalidateSelf();
    }

    public final void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        d.a(eVar, i, list, eVar2, this);
    }

    public final <T> void a(T t, @Nullable c<T> cVar) {
        if (!this.nq.b(t, cVar)) {
            if (t == h.ma) {
                this.nn.a(cVar);
            } else if (t == h.mb) {
                this.no.a(cVar);
            }
        }
    }
}
    
