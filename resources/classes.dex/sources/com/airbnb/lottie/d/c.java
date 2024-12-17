    package com.airbnb.lottie.d;

import android.animation.Animator;
import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;

public final class c extends a implements Choreographer.FrameCallback {
    @Nullable
    public com.airbnb.lottie.c lB;
    private float qR = 1.0f;
    private boolean qS = false;
    public long qT = 0;
    public float qU = 0.0f;
    public float qV = -2.14748365E9f;
    public float qW = 2.14748365E9f;
    @VisibleForTesting
    public boolean qX = false;
    public int repeatCount = 0;

    public final Object getAnimatedValue() {
        return Float.valueOf(cX());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float cX() {
        if (this.lB == null) {
            return 0.0f;
        }
        return (this.qU - this.lB.lu) / (this.lB.lv - this.lB.lu);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getAnimatedFraction() {
        if (this.lB == null) {
            return 0.0f;
        }
        if (cZ()) {
            return (db() - this.qU) / (db() - da());
        }
        return (this.qU - da()) / (db() - da());
    }

    public final long getDuration() {
        if (this.lB == null) {
            return 0;
        }
        return (long) this.lB.ct();
    }

    public final boolean isRunning() {
        return this.qX;
    }

    public final void doFrame(long j) {
        float f2;
        dc();
        if (this.lB != null && isRunning()) {
            long nanoTime = System.nanoTime();
            long j2 = nanoTime - this.qT;
            if (this.lB == null) {
                f2 = Float.MAX_VALUE;
            } else {
                f2 = (1.0E9f / this.lB.lw) / Math.abs(this.qR);
            }
            float f3 = ((float) j2) / f2;
            float f4 = this.qU;
            if (cZ()) {
                f3 = -f3;
            }
            this.qU = f4 + f3;
            float f5 = this.qU;
            boolean z = !(f5 >= da() && f5 <= db());
            this.qU = d.clamp(this.qU, da(), db());
            this.qT = nanoTime;
            cW();
            if (z) {
                if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                    for (Animator.AnimatorListener onAnimationRepeat : this.listeners) {
                        onAnimationRepeat.onAnimationRepeat(this);
                    }
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.qS = !this.qS;
                        cY();
                    } else {
                        this.qU = cZ() ? db() : da();
                    }
                    this.qT = nanoTime;
                } else {
                    this.qU = db();
                    u(true);
                    t(cZ());
                }
            }
            if (this.lB == null) {
                return;
            }
            if (this.qU < this.qV || this.qU > this.qW) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.qV), Float.valueOf(this.qW), Float.valueOf(this.qU)}));
            }
        }
    }

    public final void G(int i) {
        float f2 = (float) i;
        if (this.qU != f2) {
            this.qU = d.clamp(f2, da(), db());
            this.qT = System.nanoTime();
            cW();
        }
    }

    public final void f(int i, int i2) {
        float f2 = this.lB == null ? -3.4028235E38f : this.lB.lu;
        float f3 = this.lB == null ? Float.MAX_VALUE : this.lB.lv;
        float f4 = (float) i;
        this.qV = d.clamp(f4, f2, f3);
        float f5 = (float) i2;
        this.qW = d.clamp(f5, f2, f3);
        G((int) d.clamp(this.qU, f4, f5));
    }

    public final void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.qS) {
            this.qS = false;
            cY();
        }
    }

    public final float da() {
        if (this.lB == null) {
            return 0.0f;
        }
        if (this.qV == -2.14748365E9f) {
            return this.lB.lu;
        }
        return this.qV;
    }

    public final float db() {
        if (this.lB == null) {
            return 0.0f;
        }
        if (this.qW == 2.14748365E9f) {
            return this.lB.lv;
        }
        return this.qW;
    }

    public final void dc() {
        if (isRunning()) {
            u(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public final void u(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.qX = false;
        }
    }

    private void cY() {
        this.qR = -this.qR;
    }

    @MainThread
    public final void cancel() {
        for (Animator.AnimatorListener onAnimationCancel : this.listeners) {
            onAnimationCancel.onAnimationCancel(this);
        }
        u(true);
    }

    public final boolean cZ() {
        return this.qR < 0.0f;
    }
}
    
