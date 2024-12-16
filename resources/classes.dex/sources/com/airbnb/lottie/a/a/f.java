    package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.b;
import com.airbnb.lottie.d.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.i;
import java.util.ArrayList;
import java.util.List;

public final class f implements d, j, a.C0012a {
    private final e le;
    private final a<Integer, Integer> mC;
    @Nullable
    private a<ColorFilter, ColorFilter> mF;
    private final List<l> mG = new ArrayList();
    private final a<Integer, Integer> mP;
    private final com.airbnb.lottie.model.layer.a mx;
    private final String name;
    private final Paint paint = new Paint(1);
    private final Path path = new Path();

    public f(e eVar, com.airbnb.lottie.model.layer.a aVar, i iVar) {
        this.mx = aVar;
        this.name = iVar.name;
        this.le = eVar;
        if (iVar.oB == null || iVar.oJ == null) {
            this.mP = null;
            this.mC = null;
            return;
        }
        this.path.setFillType(iVar.oR);
        this.mP = iVar.oB.cO();
        this.mP.b(this);
        aVar.a(this.mP);
        this.mC = iVar.oJ.cO();
        this.mC.b(this);
        aVar.a(this.mC);
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

    public final String getName() {
        return this.name;
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        b.cq();
        this.paint.setColor(this.mP.getValue().intValue());
        this.paint.setAlpha(d.J((int) ((((((float) i) / 255.0f) * ((float) this.mC.getValue().intValue())) / 100.0f) * 255.0f)));
        if (this.mF != null) {
            this.paint.setColorFilter(this.mF.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.mG.size(); i2++) {
            this.path.addPath(this.mG.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        b.cr();
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.mG.size(); i++) {
            this.path.addPath(this.mG.get(i).getPath(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        d.a(eVar, i, list, eVar2, this);
    }

    public final <T> void a(T t, @Nullable c<T> cVar) {
        if (t == h.lO) {
            this.mP.a(cVar);
        } else if (t == h.lR) {
            this.mC.a(cVar);
        } else if (t != h.ml) {
        } else {
            if (cVar == null) {
                this.mF = null;
                return;
            }
            this.mF = new p(cVar);
            this.mF.b(this);
            this.mx.a(this.mF);
        }
    }
}
    
