package android.support.c.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c extends h implements b {
    private Context mContext;
    private a tu;
    private ArgbEvaluator tv;
    final Drawable.Callback tw;

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    c() {
        this((Context) null, (byte) 0);
    }

    private c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b2) {
        this.tv = null;
        this.tw = new Drawable.Callback() {
            public final void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                c.this.scheduleSelf(runnable, j);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.tu = new a();
    }

    public final Drawable mutate() {
        if (this.tG != null) {
            this.tG.mutate();
        }
        return this;
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.tG == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.tG.getConstantState());
    }

    public final int getChangingConfigurations() {
        if (this.tG != null) {
            return this.tG.getChangingConfigurations();
        }
        return super.getChangingConfigurations();
    }

    public final void draw(Canvas canvas) {
        if (this.tG != null) {
            this.tG.draw(canvas);
            return;
        }
        this.tu.ty.draw(canvas);
        if (this.tu.tz.isStarted()) {
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        if (this.tG != null) {
            this.tG.setBounds(rect);
        } else {
            this.tu.ty.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (this.tG != null) {
            return this.tG.setState(iArr);
        }
        return this.tu.ty.setState(iArr);
    }

    /* access modifiers changed from: protected */
    public final boolean onLevelChange(int i) {
        if (this.tG != null) {
            return this.tG.setLevel(i);
        }
        return this.tu.ty.setLevel(i);
    }

    public final int getAlpha() {
        if (this.tG != null) {
            return android.support.v4.graphics.drawable.a.p(this.tG);
        }
        return this.tu.ty.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.tG != null) {
            this.tG.setAlpha(i);
        } else {
            this.tu.ty.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.tG != null) {
            this.tG.setColorFilter(colorFilter);
        } else {
            this.tu.ty.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, i);
        } else {
            this.tu.ty.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, colorStateList);
        } else {
            this.tu.ty.setTintList(colorStateList);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, mode);
        } else {
            this.tu.ty.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.tG != null) {
            return this.tG.setVisible(z, z2);
        }
        this.tu.ty.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.tG != null) {
            return this.tG.isStateful();
        }
        return this.tu.ty.isStateful();
    }

    public final int getOpacity() {
        if (this.tG != null) {
            return this.tG.getOpacity();
        }
        return this.tu.ty.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.tG != null) {
            return this.tG.getIntrinsicWidth();
        }
        return this.tu.ty.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.tG != null) {
            return this.tG.getIntrinsicHeight();
        }
        return this.tu.ty.getIntrinsicHeight();
    }

    public final boolean isAutoMirrored() {
        if (this.tG != null) {
            return android.support.v4.graphics.drawable.a.o(this.tG);
        }
        return this.tu.ty.isAutoMirrored();
    }

    public final void setAutoMirrored(boolean z) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, z);
        } else {
            this.tu.ty.setAutoMirrored(z);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Animator animator;
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray obtainAttributes = g.obtainAttributes(resources, theme, attributeSet, a.tk);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a2 = i.a(resources, resourceId, theme);
                        a2.tI = false;
                        a2.setCallback(this.tw);
                        if (this.tu.ty != null) {
                            this.tu.ty.setCallback((Drawable.Callback) null);
                        }
                        this.tu.ty = a2;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, a.tl);
                    String string = obtainAttributes2.getString(0);
                    int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.mContext != null) {
                            Context context = this.mContext;
                            if (Build.VERSION.SDK_INT >= 24) {
                                animator = AnimatorInflater.loadAnimator(context, resourceId2);
                            } else {
                                animator = e.a(context, context.getResources(), context.getTheme(), resourceId2);
                            }
                            animator.setTarget(this.tu.ty.tH.ue.ud.get(string));
                            if (Build.VERSION.SDK_INT < 21) {
                                b(animator);
                            }
                            if (this.tu.mAnimators == null) {
                                this.tu.mAnimators = new ArrayList<>();
                                this.tu.tA = new android.support.v4.e.a<>();
                            }
                            this.tu.mAnimators.add(animator);
                            this.tu.tA.put(animator, string);
                        } else {
                            obtainAttributes2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes2.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        a aVar = this.tu;
        if (aVar.tz == null) {
            aVar.tz = new AnimatorSet();
        }
        aVar.tz.playTogether(aVar.mAnimators);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public final void applyTheme(Resources.Theme theme) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.tG != null) {
            return android.support.v4.graphics.drawable.a.q(this.tG);
        }
        return false;
    }

    private static class b extends Drawable.ConstantState {
        private final Drawable.ConstantState tB;

        public b(Drawable.ConstantState constantState) {
            this.tB = constantState;
        }

        public final Drawable newDrawable() {
            c cVar = new c();
            cVar.tG = this.tB.newDrawable();
            cVar.tG.setCallback(cVar.tw);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.tG = this.tB.newDrawable(resources);
            cVar.tG.setCallback(cVar.tw);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            cVar.tG = this.tB.newDrawable(resources, theme);
            cVar.tG.setCallback(cVar.tw);
            return cVar;
        }

        public final boolean canApplyTheme() {
            return this.tB.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.tB.getChangingConfigurations();
        }
    }

    private static class a extends Drawable.ConstantState {
        ArrayList<Animator> mAnimators;
        android.support.v4.e.a<Animator, String> tA;
        i ty;
        AnimatorSet tz;

        public final int getChangingConfigurations() {
            return 0;
        }

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    private void b(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                b(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.tv == null) {
                    this.tv = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.tv);
            }
        }
    }

    public final boolean isRunning() {
        if (this.tG != null) {
            return ((AnimatedVectorDrawable) this.tG).isRunning();
        }
        return this.tu.tz.isRunning();
    }

    public final void start() {
        if (this.tG != null) {
            ((AnimatedVectorDrawable) this.tG).start();
        } else if (!this.tu.tz.isStarted()) {
            this.tu.tz.start();
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.tG != null) {
            ((AnimatedVectorDrawable) this.tG).stop();
        } else {
            this.tu.tz.end();
        }
    }
}
