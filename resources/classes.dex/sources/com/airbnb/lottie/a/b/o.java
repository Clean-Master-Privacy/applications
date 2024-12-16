    package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.e.d;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.layer.a;

public final class o {
    private final Matrix matrix = new Matrix();
    public final a<PointF, PointF> nN;
    public final a<?, PointF> nO;
    public final a<d, d> nP;
    public final a<Float, Float> nQ;
    public final a<Integer, Integer> nR;
    @Nullable
    public final a<?, Float> nS;
    @Nullable
    public final a<?, Float> nT;

    public o(l lVar) {
        this.nN = lVar.oF.cO();
        this.nO = lVar.oG.cO();
        this.nP = lVar.oH.cO();
        this.nQ = lVar.oI.cO();
        this.nR = lVar.oJ.cO();
        if (lVar.oK != null) {
            this.nS = lVar.oK.cO();
        } else {
            this.nS = null;
        }
        if (lVar.oL != null) {
            this.nT = lVar.oL.cO();
        } else {
            this.nT = null;
        }
    }

    public final void a(a aVar) {
        aVar.a(this.nN);
        aVar.a(this.nO);
        aVar.a(this.nP);
        aVar.a(this.nQ);
        aVar.a(this.nR);
        if (this.nS != null) {
            aVar.a(this.nS);
        }
        if (this.nT != null) {
            aVar.a(this.nT);
        }
    }

    public final void a(a.C0012a aVar) {
        this.nN.b(aVar);
        this.nO.b(aVar);
        this.nP.b(aVar);
        this.nQ.b(aVar);
        this.nR.b(aVar);
        if (this.nS != null) {
            this.nS.b(aVar);
        }
        if (this.nT != null) {
            this.nT.b(aVar);
        }
    }

    public final Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nO.getValue();
        if (!(value.x == 0.0f && value.y == 0.0f)) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nQ.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        d value2 = this.nP.getValue();
        if (!(value2.scaleX == 1.0f && value2.scaleY == 1.0f)) {
            this.matrix.preScale(value2.scaleX, value2.scaleY);
        }
        PointF value3 = this.nN.getValue();
        if (!(value3.x == 0.0f && value3.y == 0.0f)) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public final Matrix h(float f) {
        PointF value = this.nO.getValue();
        PointF value2 = this.nN.getValue();
        d value3 = this.nP.getValue();
        float floatValue = this.nQ.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        double d = (double) f;
        this.matrix.preScale((float) Math.pow((double) value3.scaleX, d), (float) Math.pow((double) value3.scaleY, d));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public final <T> boolean b(T t, @Nullable c<T> cVar) {
        if (t == h.lS) {
            this.nN.a(cVar);
            return true;
        } else if (t == h.lT) {
            this.nO.a(cVar);
            return true;
        } else if (t == h.lW) {
            this.nP.a(cVar);
            return true;
        } else if (t == h.lX) {
            this.nQ.a(cVar);
            return true;
        } else if (t == h.lQ) {
            this.nR.a(cVar);
            return true;
        } else if (t == h.mi && this.nS != null) {
            this.nS.a(cVar);
            return true;
        } else if (t != h.mj || this.nT == null) {
            return false;
        } else {
            this.nT.a(cVar);
            return true;
        }
    }
}
    
