    package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.b;
import com.airbnb.lottie.d.d;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.model.content.h;
import java.util.List;

public final class l extends a<h, Path> {
    private final h nJ = new h();
    private final Path nK = new Path();

    public l(List<a<h>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        h hVar = (h) aVar.rc;
        h hVar2 = (h) aVar.rd;
        h hVar3 = this.nJ;
        if (hVar3.pu == null) {
            hVar3.pu = new PointF();
        }
        hVar3.closed = hVar.closed || hVar2.closed;
        if (hVar.pt.size() != hVar2.pt.size()) {
            b.bt("Curves must have the same number of control points. Shape 1: " + hVar.pt.size() + "\tShape 2: " + hVar2.pt.size());
        }
        if (hVar3.pt.isEmpty()) {
            int min = Math.min(hVar.pt.size(), hVar2.pt.size());
            for (int i = 0; i < min; i++) {
                hVar3.pt.add(new com.airbnb.lottie.model.a());
            }
        }
        PointF pointF = hVar.pu;
        PointF pointF2 = hVar2.pu;
        float f2 = pointF.x;
        float f3 = f2 + ((pointF2.x - f2) * f);
        float f4 = pointF.y;
        float f5 = f4 + ((pointF2.y - f4) * f);
        if (hVar3.pu == null) {
            hVar3.pu = new PointF();
        }
        hVar3.pu.set(f3, f5);
        for (int size = hVar3.pt.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.model.a aVar2 = hVar.pt.get(size);
            com.airbnb.lottie.model.a aVar3 = hVar2.pt.get(size);
            PointF pointF3 = aVar2.od;
            PointF pointF4 = aVar2.oe;
            PointF pointF5 = aVar2.of;
            PointF pointF6 = aVar3.od;
            PointF pointF7 = aVar3.oe;
            PointF pointF8 = aVar3.of;
            float f6 = pointF3.x;
            float f7 = pointF3.y;
            hVar3.pt.get(size).od.set(f6 + ((pointF6.x - f6) * f), f7 + ((pointF6.y - f7) * f));
            float f8 = pointF4.x;
            float f9 = pointF4.y;
            hVar3.pt.get(size).oe.set(f8 + ((pointF7.x - f8) * f), f9 + ((pointF7.y - f9) * f));
            float f10 = pointF5.x;
            float f11 = pointF5.y;
            hVar3.pt.get(size).of.set(f10 + ((pointF8.x - f10) * f), f11 + ((pointF8.y - f11) * f));
        }
        d.a(this.nJ, this.nK);
        return this.nK;
    }
}
    
