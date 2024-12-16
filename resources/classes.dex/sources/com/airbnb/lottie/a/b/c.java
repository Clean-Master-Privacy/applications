    package com.airbnb.lottie.a.b;

import com.airbnb.lottie.e.a;
import java.util.List;

public final class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.rc == null || aVar.rd == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else if (this.nz != null) {
            com.airbnb.lottie.e.c cVar = this.nz;
            aVar.rf.floatValue();
            cJ();
            return (Float) cVar.value;
        } else {
            float floatValue = ((Float) aVar.rc).floatValue();
            return Float.valueOf(floatValue + (f * (((Float) aVar.rd).floatValue() - floatValue)));
        }
    }
}
    
