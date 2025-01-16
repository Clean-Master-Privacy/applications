package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.a.a;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int fd = 2;
    /* access modifiers changed from: private */
    public ViewPropertyAnimator fe;
    private int height = 0;

    public final boolean k(int i) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.height = v.getMeasuredHeight();
        return super.a(coordinatorLayout, v, i);
    }

    public final void a(V v, int i) {
        if (this.fd != 1 && i > 0) {
            d(v);
        } else if (this.fd != 2 && i < 0) {
            c(v);
        }
    }

    public void c(V v) {
        if (this.fe != null) {
            this.fe.cancel();
            v.clearAnimation();
        }
        this.fd = 2;
        a(v, 0, 225, a.eR);
    }

    public void d(V v) {
        if (this.fe != null) {
            this.fe.cancel();
            v.clearAnimation();
        }
        this.fd = 1;
        a(v, this.height, 175, a.eQ);
    }

    private void a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.fe = v.animate().translationY((float) i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.fe = null;
            }
        });
    }
}
