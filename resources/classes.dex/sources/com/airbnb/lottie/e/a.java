    package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.airbnb.lottie.c;

public class a<T> {
    @Nullable
    private final c lB;
    public final float lu;
    @Nullable
    public final T rc;
    @Nullable
    public final T rd;
    @Nullable
    public final Interpolator re;
    @Nullable
    public Float rf;
    private float rg;
    private float rh;
    public PointF ri;
    public PointF rj;

    public a(c cVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.rg = Float.MIN_VALUE;
        this.rh = Float.MIN_VALUE;
        this.ri = null;
        this.rj = null;
        this.lB = cVar;
        this.rc = t;
        this.rd = t2;
        this.re = interpolator;
        this.lu = f;
        this.rf = f2;
    }

    public a(T t) {
        this.rg = Float.MIN_VALUE;
        this.rh = Float.MIN_VALUE;
        this.ri = null;
        this.rj = null;
        this.lB = null;
        this.rc = t;
        this.rd = t;
        this.re = null;
        this.lu = Float.MIN_VALUE;
        this.rf = Float.valueOf(Float.MAX_VALUE);
    }

    public final float de() {
        if (this.lB == null) {
            return 0.0f;
        }
        if (this.rg == Float.MIN_VALUE) {
            this.rg = (this.lu - this.lB.lu) / this.lB.cu();
        }
        return this.rg;
    }

    public final float cL() {
        if (this.lB == null) {
            return 1.0f;
        }
        if (this.rh == Float.MIN_VALUE) {
            if (this.rf == null) {
                this.rh = 1.0f;
            } else {
                this.rh = de() + ((this.rf.floatValue() - this.lu) / this.lB.cu());
            }
        }
        return this.rh;
    }

    public final boolean df() {
        return this.re == null;
    }

    public final boolean k(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= de() && f < cL();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.rc + ", endValue=" + this.rd + ", startFrame=" + this.lu + ", endFrame=" + this.rf + ", interpolator=" + this.re + '}';
    }
}
    
