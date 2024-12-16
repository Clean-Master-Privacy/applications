    package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.e.a;

public final class h extends a<PointF> {
    @Nullable
    Path path;

    public h(c cVar, a<PointF> aVar) {
        super(cVar, aVar.rc, aVar.rd, aVar.re, aVar.lu, aVar.rf);
        boolean z = (this.rd == null || this.rc == null || !((PointF) this.rc).equals(((PointF) this.rd).x, ((PointF) this.rd).y)) ? false : true;
        if (this.rd != null && !z) {
            this.path = e.a((PointF) this.rc, (PointF) this.rd, aVar.ri, aVar.rj);
        }
    }
}
    
