    package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.e.c;
import java.util.List;

public final class j extends f<PointF> {
    private final PointF nF = new PointF();

    public j(List<a<PointF>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.rc == null || aVar.rd == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) aVar.rc;
        PointF pointF2 = (PointF) aVar.rd;
        if (this.nz != null) {
            c cVar = this.nz;
            aVar.rf.floatValue();
            cJ();
            return (PointF) cVar.value;
        }
        this.nF.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
        return this.nF;
    }
}
    
