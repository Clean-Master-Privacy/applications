package android.support.design.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.f.c;
import android.support.design.f.e;
import android.support.design.internal.f;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.g;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.s;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {
    private final int fg;
    /* access modifiers changed from: private */
    public final c fh;
    /* access modifiers changed from: private */
    public final a fi;
    /* access modifiers changed from: private */
    public Animator fj;
    /* access modifiers changed from: private */
    public Animator fk;
    /* access modifiers changed from: private */
    public Animator fl;
    /* access modifiers changed from: private */
    public int fm;
    private boolean fn;
    /* access modifiers changed from: private */
    public boolean fo;
    private AnimatorListenerAdapter fp;

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.r);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fo = true;
        this.fp = new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                BottomAppBar.a(BottomAppBar.this, BottomAppBar.this.fo);
                BottomAppBar.this.a(BottomAppBar.this.fm, BottomAppBar.this.fo);
            }
        };
        TypedArray a2 = f.a(context, attributeSet, a.k.BottomAppBar, i, a.j.rv, new int[0]);
        ColorStateList b2 = android.support.design.d.a.b(context, a2, a.k.BottomAppBar_backgroundTint);
        this.fm = a2.getInt(a.k.BottomAppBar_fabAlignmentMode, 0);
        this.fn = a2.getBoolean(a.k.BottomAppBar_hideOnScroll, false);
        a2.recycle();
        this.fg = getResources().getDimensionPixelOffset(a.d.ol);
        this.fi = new a((float) a2.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleMargin, 0), (float) a2.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleRoundedCornerRadius, 0), (float) a2.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleVerticalOffset, 0));
        e eVar = new e();
        eVar.kh = this.fi;
        this.fh = new c(eVar);
        c cVar = this.fh;
        cVar.jR = true;
        cVar.invalidateSelf();
        c cVar2 = this.fh;
        cVar2.jU = Paint.Style.FILL;
        cVar2.invalidateSelf();
        android.support.v4.graphics.drawable.a.a((Drawable) this.fh, b2);
        s.setBackground(this, this.fh);
    }

    public int getFabAlignmentMode() {
        return this.fm;
    }

    public float getFabCradleMargin() {
        return this.fi.fw;
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            this.fi.fw = f;
            this.fh.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.fi.fv;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            this.fi.fv = f;
            this.fh.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return this.fi.fy;
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            this.fi.fy = f;
            this.fh.invalidateSelf();
        }
    }

    public boolean getHideOnScroll() {
        return this.fn;
    }

    public void setHideOnScroll(boolean z) {
        this.fn = z;
    }

    /* access modifiers changed from: package-private */
    public void setFabDiameter(int i) {
        float f = (float) i;
        if (f != this.fi.fx) {
            this.fi.fx = f;
            this.fh.invalidateSelf();
        }
    }

    /* access modifiers changed from: private */
    public FloatingActionButton ay() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View next : ((CoordinatorLayout) getParent()).s(this)) {
            if (next instanceof FloatingActionButton) {
                return (FloatingActionButton) next;
            }
        }
        return null;
    }

    private boolean az() {
        FloatingActionButton ay = ay();
        return ay != null && ay.cc().cm();
    }

    /* access modifiers changed from: private */
    public void a(final int i, final boolean z) {
        if (s.ao(this)) {
            if (this.fl != null) {
                this.fl.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!az()) {
                i = 0;
                z = false;
            }
            final ActionMenuView aA = aA();
            if (aA != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aA, "alpha", new float[]{1.0f});
                if ((this.fo || (z && az())) && (this.fm == 1 || i == 1)) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aA, "alpha", new float[]{0.0f});
                    ofFloat2.addListener(new AnimatorListenerAdapter() {
                        private boolean cancelled;

                        public final void onAnimationCancel(Animator animator) {
                            this.cancelled = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            if (!this.cancelled) {
                                BottomAppBar.this.a(aA, i, z);
                            }
                        }
                    });
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(150);
                    animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                    arrayList.add(animatorSet);
                } else if (aA.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.fl = animatorSet2;
            this.fl.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    Animator unused = BottomAppBar.this.fl = null;
                }
            });
            this.fl.start();
        }
    }

    private float g(boolean z) {
        FloatingActionButton ay = ay();
        if (ay == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        ay.b(rect);
        float height = (float) rect.height();
        if (height == 0.0f) {
            height = (float) ay.getMeasuredHeight();
        }
        float height2 = (float) (ay.getHeight() - rect.height());
        float height3 = (-getCradleVerticalOffset()) + (height / 2.0f) + ((float) (ay.getHeight() - rect.bottom));
        float paddingBottom = height2 - ((float) ay.getPaddingBottom());
        float f = (float) (-getMeasuredHeight());
        if (z) {
            paddingBottom = height3;
        }
        return f + paddingBottom;
    }

    /* access modifiers changed from: private */
    public float getFabTranslationY() {
        return g(this.fo);
    }

    private int l(int i) {
        int i2 = 1;
        boolean z = s.Q(this) == 1;
        if (i != 1) {
            return 0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - this.fg;
        if (z) {
            i2 = -1;
        }
        return measuredWidth * i2;
    }

    private float getFabTranslationX() {
        return (float) l(this.fm);
    }

    private ActionMenuView aA() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = s.Q(this) == 1;
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                i2 = Math.max(i2, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i != 1 || !z) ? 0.0f : (float) (i2 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft())));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fj != null) {
            this.fj.cancel();
        }
        if (this.fl != null) {
            this.fl.cancel();
        }
        if (this.fk != null) {
            this.fk.cancel();
        }
        aB();
    }

    /* access modifiers changed from: private */
    public void aB() {
        this.fi.fz = getFabTranslationX();
        FloatingActionButton ay = ay();
        this.fh.a((!this.fo || !az()) ? 0.0f : 1.0f);
        if (ay != null) {
            ay.setTranslationY(getFabTranslationY());
            ay.setTranslationX(getFabTranslationX());
        }
        ActionMenuView aA = aA();
        if (aA != null) {
            aA.setAlpha(1.0f);
            if (!az()) {
                a(aA, 0, false);
            } else {
                a(aA, this.fm, this.fo);
            }
        }
    }

    public final CoordinatorLayout.Behavior<BottomAppBar> aC() {
        return new Behavior();
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect fu = new Rect();

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            FloatingActionButton h = bottomAppBar.ay();
            if (h != null) {
                ((CoordinatorLayout.d) h.getLayoutParams()).nV = 17;
                BottomAppBar.a(bottomAppBar, h);
                Rect rect = this.fu;
                rect.set(0, 0, h.getMeasuredWidth(), h.getMeasuredHeight());
                h.c(rect);
                bottomAppBar.setFabDiameter(this.fu.height());
            }
            if (!BottomAppBar.i(bottomAppBar)) {
                bottomAppBar.aB();
            }
            coordinatorLayout.f(bottomAppBar, i);
            return super.a(coordinatorLayout, bottomAppBar, i);
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.a(coordinatorLayout, bottomAppBar, view2, view3, i, i2);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void c(View view) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            super.c(bottomAppBar);
            FloatingActionButton h = bottomAppBar.ay();
            if (h != null) {
                h.clearAnimation();
                h.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(android.support.design.a.a.eR).setDuration(225);
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void d(View view) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            super.d(bottomAppBar);
            FloatingActionButton h = bottomAppBar.ay();
            if (h != null) {
                h.b(this.fu);
                float measuredHeight = (float) (h.getMeasuredHeight() - this.fu.height());
                h.clearAnimation();
                h.animate().translationY(((float) (-h.getPaddingBottom())) + measuredHeight).setInterpolator(android.support.design.a.a.eQ).setDuration(175);
            }
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fm = this.fm;
        savedState.fo = this.fo;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fm = savedState.fm;
        this.fo = savedState.fo;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        int fm;
        boolean fo;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fm = parcel.readInt();
            this.fo = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.fm);
            parcel.writeInt(this.fo ? 1 : 0);
        }
    }

    public void setFabAlignmentMode(int i) {
        if (this.fm != i && s.ao(this)) {
            if (this.fk != null) {
                this.fk.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.fo) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.fi.fz, (float) l(i)});
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BottomAppBar.this.fi.fz = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        BottomAppBar.this.fh.invalidateSelf();
                    }
                });
                ofFloat.setDuration(300);
                arrayList.add(ofFloat);
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ay(), "translationX", new float[]{(float) l(i)});
            ofFloat2.setDuration(300);
            arrayList.add(ofFloat2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.fk = animatorSet;
            this.fk.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    Animator unused = BottomAppBar.this.fk = null;
                }
            });
            this.fk.start();
        }
        a(i, this.fo);
        this.fm = i;
    }

    static /* synthetic */ void a(BottomAppBar bottomAppBar, boolean z) {
        if (s.ao(bottomAppBar)) {
            if (bottomAppBar.fj != null) {
                bottomAppBar.fj.cancel();
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = z && bottomAppBar.az();
            if (z2) {
                bottomAppBar.fi.fz = bottomAppBar.getFabTranslationX();
            }
            float[] fArr = new float[2];
            fArr[0] = bottomAppBar.fh.jS;
            fArr[1] = z2 ? 1.0f : 0.0f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BottomAppBar.this.fh.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat.setDuration(300);
            arrayList.add(ofFloat);
            FloatingActionButton ay = bottomAppBar.ay();
            if (ay != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ay, "translationY", new float[]{bottomAppBar.g(z)});
                ofFloat2.setDuration(300);
                arrayList.add(ofFloat2);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            bottomAppBar.fj = animatorSet;
            bottomAppBar.fj.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    Animator unused = BottomAppBar.this.fj = null;
                }
            });
            bottomAppBar.fj.start();
        }
    }

    static /* synthetic */ void a(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        AnimatorListenerAdapter animatorListenerAdapter = bottomAppBar.fp;
        g cc = floatingActionButton.cc();
        if (cc.oY != null) {
            cc.oY.remove(animatorListenerAdapter);
        }
        AnimatorListenerAdapter animatorListenerAdapter2 = bottomAppBar.fp;
        g cc2 = floatingActionButton.cc();
        if (cc2.oX != null) {
            cc2.oX.remove(animatorListenerAdapter2);
        }
        AnimatorListenerAdapter animatorListenerAdapter3 = bottomAppBar.fp;
        g cc3 = floatingActionButton.cc();
        if (cc3.oY == null) {
            cc3.oY = new ArrayList<>();
        }
        cc3.oY.add(animatorListenerAdapter3);
        AnimatorListenerAdapter animatorListenerAdapter4 = bottomAppBar.fp;
        g cc4 = floatingActionButton.cc();
        if (cc4.oX == null) {
            cc4.oX = new ArrayList<>();
        }
        cc4.oX.add(animatorListenerAdapter4);
    }

    static /* synthetic */ boolean i(BottomAppBar bottomAppBar) {
        if (bottomAppBar.fj != null && bottomAppBar.fj.isRunning()) {
            return true;
        }
        if (bottomAppBar.fl == null || !bottomAppBar.fl.isRunning()) {
            return bottomAppBar.fk != null && bottomAppBar.fk.isRunning();
        }
        return true;
    }
}
