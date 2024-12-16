    package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.d.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.f;
import java.util.List;

public final class n implements j, l, a.C0012a {
    private final e le;
    @Nullable
    private r mH;
    private final a<?, PointF> mL;
    private final a<?, PointF> mM;
    private boolean mO;
    private final RectF mw = new RectF();
    private final String name;
    private final a<?, Float> nm;
    private final Path path = new Path();

    public final <T> void a(T t, @Nullable c<T> cVar) {
    }

    public n(e eVar, com.airbnb.lottie.model.layer.a aVar, f fVar) {
        this.name = fVar.name;
        this.le = eVar;
        this.mM = fVar.oG.cO();
        this.mL = fVar.oM.cO();
        this.nm = fVar.po.cO();
        aVar.a(this.mM);
        aVar.a(this.mL);
        aVar.a(this.nm);
        this.mM.b(this);
        this.mL.b(this);
        this.nm.b(this);
    }

    public final String getName() {
        return this.name;
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

    public final Path getPath() {
        if (this.mO) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.mL.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.nm == null ? 0.0f : this.nm.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF value2 = this.mM.getValue();
        this.path.moveTo(value2.x + f, (value2.y - f2) + floatValue);
        this.path.lineTo(value2.x + f, (value2.y + f2) - floatValue);
        if (floatValue > 0.0f) {
            float f3 = floatValue * 2.0f;
            this.mw.set((value2.x + f) - f3, (value2.y + f2) - f3, value2.x + f, value2.y + f2);
            this.path.arcTo(this.mw, 0.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x - f) + floatValue, value2.y + f2);
        if (floatValue > 0.0f) {
            float f4 = floatValue * 2.0f;
            this.mw.set(value2.x - f, (value2.y + f2) - f4, (value2.x - f) + f4, value2.y + f2);
            this.path.arcTo(this.mw, 90.0f, 90.0f, false);
        }
        this.path.lineTo(value2.x - f, (value2.y - f2) + floatValue);
        if (floatValue > 0.0f) {
            float f5 = floatValue * 2.0f;
            this.mw.set(value2.x - f, value2.y - f2, (value2.x - f) + f5, (value2.y - f2) + f5);
            this.path.arcTo(this.mw, 180.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x + f) - floatValue, value2.y - f2);
        if (floatValue > 0.0f) {
            float f6 = floatValue * 2.0f;
            this.mw.set((value2.x + f) - f6, value2.y - f2, value2.x + f, (value2.y - f2) + f6);
            this.path.arcTo(this.mw, 270.0f, 90.0f, false);
        }
        this.path.close();
        com.airbnb.lottie.d.e.a(this.path, this.mH);
        this.mO = true;
        return this.path;
    }

    public final void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        d.a(eVar, i, list, eVar2, this);
    }

    public final void cD() {
        this.mO = false;
        this.le.invalidateSelf();
    }
}
    
