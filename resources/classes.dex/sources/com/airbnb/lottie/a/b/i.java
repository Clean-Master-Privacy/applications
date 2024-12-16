    package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.e.c;
import java.util.List;

public final class i extends f<PointF> {
    private final PointF nF = new PointF();
    private final float[] nG = new float[2];
    private h nH;
    private PathMeasure nI;

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.path;
        if (path == null) {
            return (PointF) aVar.rc;
        }
        if (this.nz != null) {
            c cVar = this.nz;
            hVar.rf.floatValue();
            cJ();
            return (PointF) cVar.value;
        }
        if (this.nH != hVar) {
            this.nI = new PathMeasure(path, false);
            this.nH = hVar;
        }
        this.nI.getPosTan(f * this.nI.getLength(), this.nG, (float[]) null);
        this.nF.set(this.nG[0], this.nG[1]);
        return this.nF;
    }
}
    
