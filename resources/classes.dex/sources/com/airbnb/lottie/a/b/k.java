    package com.airbnb.lottie.a.b;

import com.airbnb.lottie.e.a;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.e.d;
import java.util.List;

public final class k extends f<d> {
    public k(List<a<d>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.rc == null || aVar.rd == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar = (d) aVar.rc;
        d dVar2 = (d) aVar.rd;
        if (this.nz != null) {
            c cVar = this.nz;
            aVar.rf.floatValue();
            cJ();
            return (d) cVar.value;
        }
        float f2 = dVar.scaleX;
        float f3 = dVar.scaleY;
        return new d(f2 + ((dVar2.scaleX - f2) * f), f3 + (f * (dVar2.scaleY - f3)));
    }
}
    
