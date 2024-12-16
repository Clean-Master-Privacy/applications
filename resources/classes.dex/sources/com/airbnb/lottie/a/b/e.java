    package com.airbnb.lottie.a.b;

import com.airbnb.lottie.e.a;
import com.airbnb.lottie.e.c;
import java.util.List;

public final class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.rc == null || aVar.rd == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else if (this.nz != null) {
            c cVar = this.nz;
            aVar.rf.floatValue();
            cJ();
            return (Integer) cVar.value;
        } else {
            int intValue = ((Integer) aVar.rc).intValue();
            return Integer.valueOf((int) (((float) intValue) + (f * ((float) (((Integer) aVar.rd).intValue() - intValue)))));
        }
    }
}
    
