    package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import java.util.Collections;

public final class m extends a<PointF, PointF> {
    private final PointF nF = new PointF();
    private final a<Float, Float> nL;
    private final a<Float, Float> nM;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.nL = aVar;
        this.nM = aVar2;
        setProgress(this.progress);
    }

    public final void setProgress(float f) {
        this.nL.setProgress(f);
        this.nM.setProgress(f);
        this.nF.set(this.nL.getValue().floatValue(), this.nM.getValue().floatValue());
        for (int i = 0; i < this.listeners.size(); i++) {
            ((a.C0012a) this.listeners.get(i)).cD();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.e.a aVar, float f) {
        return this.nF;
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return this.nF;
    }
}
    
