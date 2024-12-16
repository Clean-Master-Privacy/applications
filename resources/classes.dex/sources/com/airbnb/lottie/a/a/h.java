    package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.e;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.c;

public final class h extends a {
    private final a<c, c> mP;
    private final LongSparseArray<LinearGradient> mQ = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> mR = new LongSparseArray<>();
    private final RectF mT = new RectF();
    private final GradientType mU;
    private final a<PointF, PointF> mV;
    private final a<PointF, PointF> mW;
    private final int mZ;
    private final String name;

    public final void a(Canvas canvas, Matrix matrix, int i) {
        a(this.mT, matrix);
        if (this.mU == GradientType.Linear) {
            Paint paint = this.paint;
            long cG = (long) cG();
            LinearGradient linearGradient = (LinearGradient) this.mQ.get(cG);
            if (linearGradient == null) {
                PointF value = this.mV.getValue();
                PointF value2 = this.mW.getValue();
                c value3 = this.mP.getValue();
                LinearGradient linearGradient2 = new LinearGradient((float) ((int) (this.mT.left + (this.mT.width() / 2.0f) + value.x)), (float) ((int) (this.mT.top + (this.mT.height() / 2.0f) + value.y)), (float) ((int) (this.mT.left + (this.mT.width() / 2.0f) + value2.x)), (float) ((int) (this.mT.top + (this.mT.height() / 2.0f) + value2.y)), value3.oP, value3.oO, Shader.TileMode.CLAMP);
                this.mQ.put(cG, linearGradient2);
                linearGradient = linearGradient2;
            }
            paint.setShader(linearGradient);
        } else {
            Paint paint2 = this.paint;
            long cG2 = (long) cG();
            RadialGradient radialGradient = (RadialGradient) this.mR.get(cG2);
            if (radialGradient == null) {
                PointF value4 = this.mV.getValue();
                PointF value5 = this.mW.getValue();
                c value6 = this.mP.getValue();
                int[] iArr = value6.oP;
                float[] fArr = value6.oO;
                int width = (int) (this.mT.left + (this.mT.width() / 2.0f) + value4.x);
                int height = (int) (this.mT.top + (this.mT.height() / 2.0f) + value4.y);
                RadialGradient radialGradient2 = new RadialGradient((float) width, (float) height, (float) Math.hypot((double) (((int) ((this.mT.left + (this.mT.width() / 2.0f)) + value5.x)) - width), (double) (((int) ((this.mT.top + (this.mT.height() / 2.0f)) + value5.y)) - height)), iArr, fArr, Shader.TileMode.CLAMP);
                this.mR.put(cG2, radialGradient2);
                radialGradient = radialGradient2;
            }
            paint2.setShader(radialGradient);
        }
        super.a(canvas, matrix, i);
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

    public h(e eVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar2) {
        super(eVar, aVar, eVar2.oW.toPaintCap(), eVar2.oX.toPaintJoin(), eVar2.oY, eVar2.oJ, eVar2.oV, eVar2.oZ, eVar2.pa);
        this.name = eVar2.name;
        this.mU = eVar2.oQ;
        this.mZ = (int) (eVar.lB.ct() / 32.0f);
        this.mP = eVar2.oS.cO();
        this.mP.b(this);
        aVar.a(this.mP);
        this.mV = eVar2.oT.cO();
        this.mV.b(this);
        aVar.a(this.mV);
        this.mW = eVar2.oU.cO();
        this.mW.b(this);
        aVar.a(this.mW);
    }
}
    
