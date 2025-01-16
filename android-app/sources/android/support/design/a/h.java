package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.e.o;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.List;

public final class h {
    private o<String, i> fa = new o<>();

    public final long ax() {
        int size = this.fa.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            i valueAt = this.fa.valueAt(i);
            j = Math.max(j, valueAt.delay + valueAt.fb);
        }
        return j;
    }

    public static h a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return b(context, resourceId);
    }

    public static h b(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return e(arrayList);
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e2);
            return null;
        }
    }

    private static h e(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        int i = 0;
        while (i < size) {
            Animator animator = list.get(i);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                    interpolator = a.eP;
                } else if (interpolator instanceof AccelerateInterpolator) {
                    interpolator = a.eQ;
                } else if (interpolator instanceof DecelerateInterpolator) {
                    interpolator = a.eR;
                }
                i iVar = new i(startDelay, duration, interpolator);
                iVar.repeatCount = objectAnimator.getRepeatCount();
                iVar.repeatMode = objectAnimator.getRepeatMode();
                hVar.fa.put(propertyName, iVar);
                i++;
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return hVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.fa.equals(((h) obj).fa);
    }

    public final int hashCode() {
        return this.fa.hashCode();
    }

    public final String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.fa + "}\n";
    }

    public final i n(String str) {
        if (this.fa.get(str) != null) {
            return this.fa.get(str);
        }
        throw new IllegalArgumentException();
    }
}
