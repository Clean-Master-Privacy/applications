package android.support.design.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.support.design.circularreveal.c;
import android.view.View;
import android.view.ViewAnimationUtils;

public final class a {
    public static Animator a(c cVar, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, c.b.hJ, c.a.hI, new c.d[]{new c.d(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        c.d be = cVar.be();
        if (be != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f, (int) f2, be.radius, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }
}
