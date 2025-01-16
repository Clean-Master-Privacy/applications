package android.support.design.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public final class i {
    public long delay = 0;
    public long fb = 300;
    private TimeInterpolator fc = null;
    int repeatCount = 0;
    int repeatMode = 1;

    public i(long j) {
        this.delay = j;
        this.fb = 150;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.delay = j;
        this.fb = j2;
        this.fc = timeInterpolator;
    }

    public final TimeInterpolator getInterpolator() {
        return this.fc != null ? this.fc : a.eP;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.delay == iVar.delay && this.fb == iVar.fb && this.repeatCount == iVar.repeatCount && this.repeatMode == iVar.repeatMode) {
            return getInterpolator().getClass().equals(iVar.getInterpolator().getClass());
        }
        return false;
    }

    public final String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.delay + " duration: " + this.fb + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + this.repeatCount + " repeatMode: " + this.repeatMode + "}\n";
    }

    public final void a(Animator animator) {
        animator.setStartDelay(this.delay);
        animator.setDuration(this.fb);
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.repeatCount);
            valueAnimator.setRepeatMode(this.repeatMode);
        }
    }

    public final int hashCode() {
        return (((((((((int) (this.delay ^ (this.delay >>> 32))) * 31) + ((int) (this.fb ^ (this.fb >>> 32)))) * 31) + getInterpolator().getClass().hashCode()) * 31) + this.repeatCount) * 31) + this.repeatMode;
    }
}
