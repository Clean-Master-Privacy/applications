    package com.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class a {
    public final PointF od;
    public final PointF oe;
    public final PointF of;

    public a() {
        this.od = new PointF();
        this.oe = new PointF();
        this.of = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.od = pointF;
        this.oe = pointF2;
        this.of = pointF3;
    }
}
    
