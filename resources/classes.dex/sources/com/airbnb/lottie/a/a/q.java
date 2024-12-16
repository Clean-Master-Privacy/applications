    package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeStroke;

public final class q extends a {
    @Nullable
    private a<ColorFilter, ColorFilter> mF;
    private final a<Integer, Integer> mP;
    private final com.airbnb.lottie.model.layer.a mx;
    private final String name;

    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.mP.getValue().intValue());
        if (this.mF != null) {
            this.paint.setColorFilter(this.mF.getValue());
        }
        super.a(canvas, matrix, i);
    }

    public final String getName() {
        return this.name;
    }

    public final <T> void a(T t, @Nullable c<T> cVar) {
        super.a(t, cVar);
        if (t == h.lP) {
            this.mP.a(cVar);
        } else if (t != h.ml) {
        } else {
            if (cVar == null) {
                this.mF = null;
                return;
            }
            this.mF = new p(cVar);
            this.mF.b(this);
            this.mx.a(this.mP);
        }
    }

    public q(e eVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(eVar, aVar, shapeStroke.oW.toPaintCap(), shapeStroke.oX.toPaintJoin(), shapeStroke.oY, shapeStroke.oJ, shapeStroke.oV, shapeStroke.oZ, shapeStroke.pq);
        this.mx = aVar;
        this.name = shapeStroke.name;
        this.mP = shapeStroke.oB.cO();
        this.mP.b(this);
        aVar.a(this.mP);
    }
}
    
