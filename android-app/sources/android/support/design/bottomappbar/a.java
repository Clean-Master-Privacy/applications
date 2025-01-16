package android.support.design.bottomappbar;

import android.support.design.f.b;
import android.support.design.f.d;

public final class a extends b {
    float fv;
    float fw;
    float fx;
    float fy;
    float fz;

    public a(float f, float f2, float f3) {
        this.fw = f;
        this.fv = f2;
        this.fy = f3;
        if (f3 >= 0.0f) {
            this.fz = 0.0f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public final void a(float f, float f2, d dVar) {
        float f3 = f;
        d dVar2 = dVar;
        if (this.fx == 0.0f) {
            dVar2.b(f3);
            return;
        }
        float f4 = ((this.fw * 2.0f) + this.fx) / 2.0f;
        float f5 = f2 * this.fv;
        float f6 = (f3 / 2.0f) + this.fz;
        float f7 = (this.fy * f2) + ((1.0f - f2) * f4);
        if (f7 / f4 >= 1.0f) {
            dVar2.b(f3);
            return;
        }
        float f8 = f4 + f5;
        float f9 = f7 + f5;
        float sqrt = (float) Math.sqrt((double) ((f8 * f8) - (f9 * f9)));
        float f10 = f6 - sqrt;
        float f11 = f6 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f9)));
        float f12 = 90.0f - degrees;
        float f13 = f10 - f5;
        dVar2.b(f13);
        float f14 = f5 * 2.0f;
        dVar.addArc(f13, 0.0f, f10 + f5, f14, 270.0f, degrees);
        d dVar3 = dVar;
        dVar3.addArc(f6 - f4, (-f4) - f7, f6 + f4, f4 - f7, 180.0f - f12, (f12 * 2.0f) - 180.0f);
        dVar3.addArc(f11 - f5, 0.0f, f11 + f5, f14, 270.0f - degrees, degrees);
        dVar2.b(f3);
    }
}
