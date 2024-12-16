    package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.d.d;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;

public final class e implements j, l, a.C0012a {
    private final com.airbnb.lottie.e le;
    @Nullable
    private r mH;
    private final a<?, PointF> mL;
    private final a<?, PointF> mM;
    private final com.airbnb.lottie.model.content.a mN;
    private boolean mO;
    private final String name;
    private final Path path = new Path();

    public e(com.airbnb.lottie.e eVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.name;
        this.le = eVar;
        this.mL = aVar2.oM.cO();
        this.mM = aVar2.oG.cO();
        this.mN = aVar2;
        aVar.a(this.mL);
        aVar.a(this.mM);
        this.mL.b(this);
        this.mM.b(this);
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

    public final String getName() {
        return this.name;
    }

    public final Path getPath() {
        if (this.mO) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.mL.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.path.reset();
        if (this.mN.oN) {
            float f5 = -f2;
            this.path.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.path.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            float f10 = f5;
            this.path.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f11 = f3 + 0.0f;
            this.path.cubicTo(f11, f2, f, f9, f, 0.0f);
            this.path.cubicTo(f, f8, f11, f10, 0.0f, f10);
        } else {
            float f12 = -f2;
            this.path.moveTo(0.0f, f12);
            float f13 = f3 + 0.0f;
            float f14 = 0.0f - f4;
            this.path.cubicTo(f13, f12, f, f14, f, 0.0f);
            float f15 = f4 + 0.0f;
            this.path.cubicTo(f, f15, f13, f2, 0.0f, f2);
            float f16 = 0.0f - f3;
            float f17 = -f;
            this.path.cubicTo(f16, f2, f17, f15, f17, 0.0f);
            float f18 = f12;
            this.path.cubicTo(f17, f14, f16, f18, 0.0f, f18);
        }
        PointF value2 = this.mM.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.airbnb.lottie.d.e.a(this.path, this.mH);
        this.mO = true;
        return this.path;
    }

    public final void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        d.a(eVar, i, list, eVar2, this);
    }

    public final <T> void a(T t, @Nullable c<T> cVar) {
        if (t == h.lU) {
            this.mL.a(cVar);
        } else if (t == h.lV) {
            this.mM.a(cVar);
        }
    }

    public final void cD() {
        this.mO = false;
        this.le.invalidateSelf();
    }
}
    
