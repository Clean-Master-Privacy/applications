    package com.airbnb.lottie.a.b;

import com.airbnb.lottie.d.b;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.model.content.c;
import java.util.List;

public final class d extends f<c> {
    private final c nB;

    public d(List<a<c>> list) {
        super(list);
        int i = 0;
        c cVar = (c) list.get(0).rc;
        i = cVar != null ? cVar.oP.length : i;
        this.nB = new c(new float[i], new int[i]);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(a aVar, float f) {
        c cVar = this.nB;
        c cVar2 = (c) aVar.rc;
        c cVar3 = (c) aVar.rd;
        if (cVar2.oP.length == cVar3.oP.length) {
            for (int i = 0; i < cVar2.oP.length; i++) {
                float[] fArr = cVar.oO;
                float f2 = cVar2.oO[i];
                fArr[i] = f2 + ((cVar3.oO[i] - f2) * f);
                cVar.oP[i] = b.a(f, cVar2.oP[i], cVar3.oP[i]);
            }
            return this.nB;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar2.oP.length + " vs " + cVar3.oP.length + ")");
    }
}
    
