    package com.airbnb.lottie.a.b;

import com.airbnb.lottie.e.a;
import com.airbnb.lottie.e.c;
import java.util.List;

public final class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.rc == null || aVar.rd == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) aVar.rc).intValue();
        int intValue2 = ((Integer) aVar.rd).intValue();
        if (this.nz == null) {
            return Integer.valueOf(com.airbnb.lottie.d.b.a(f, intValue, intValue2));
        }
        c cVar = this.nz;
        aVar.rf.floatValue();
        Integer.valueOf(intValue);
        Integer.valueOf(intValue2);
        cJ();
        return (Integer) cVar.value;
    }
}
    
