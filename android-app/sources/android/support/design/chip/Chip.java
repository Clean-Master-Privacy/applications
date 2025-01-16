package android.support.design.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.a;
import android.support.design.a.h;
import android.support.design.chip.a;
import android.support.v4.content.a.f;
import android.support.v4.view.a.b;
import android.support.v4.view.s;
import android.support.v4.widget.i;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends AppCompatCheckBox implements a.C0006a {
    /* access modifiers changed from: private */
    public static final Rect ga = new Rect();
    private static final int[] gb = {16842913};
    private final RectF fP;
    /* access modifiers changed from: package-private */
    public a gc;
    private RippleDrawable gd;
    CompoundButton.OnCheckedChangeListener ge;
    private boolean gf;
    private int gg;
    private boolean gh;
    private boolean gi;
    private boolean gj;
    private final a gk;
    private final f.a gl;
    private final Rect rect;

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.z);
    }

    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gg = Integer.MIN_VALUE;
        this.rect = new Rect();
        this.fP = new RectF();
        this.gl = new f.a() {
            public final void onFontRetrievalFailed(int i) {
            }

            public final void onFontRetrieved(Typeface typeface) {
                Chip.this.setText(Chip.this.getText());
                Chip.this.requestLayout();
                Chip.this.invalidate();
            }
        };
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        a a2 = a.a(context, attributeSet, i, a.j.sa);
        if (this.gc != a2) {
            a aVar = this.gc;
            if (aVar != null) {
                aVar.a((a.C0006a) null);
            }
            this.gc = a2;
            this.gc.a((a.C0006a) this);
            if (android.support.design.e.a.jA) {
                this.gd = new RippleDrawable(android.support.design.e.a.i(this.gc.fN), this.gc, (Drawable) null);
                this.gc.i(false);
                s.setBackground(this, this.gd);
            } else {
                this.gc.i(true);
                s.setBackground(this, this.gc);
            }
        }
        this.gk = new a(this);
        s.a((View) this, (android.support.v4.view.a) this.gk);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() {
                @TargetApi(21)
                public final void getOutline(View view, Outline outline) {
                    if (Chip.this.gc != null) {
                        Chip.this.gc.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
        setChecked(this.gf);
        a2.hm = false;
        setText(a2.gt);
        setEllipsize(a2.hl);
        setIncludeFontPadding(false);
        if (aQ() != null) {
            a(aQ());
        }
        setSingleLine();
        setGravity(8388627);
        aK();
    }

    private void aK() {
        if (!TextUtils.isEmpty(getText()) && this.gc != null) {
            float f = this.gc.gJ + this.gc.gQ + this.gc.gM + this.gc.gN;
            if ((this.gc.gw && this.gc.ba() != null) || (this.gc.gI != null && this.gc.gH && isChecked())) {
                f += this.gc.gK + this.gc.gL + this.gc.gB;
            }
            if (this.gc.gC && this.gc.bb() != null) {
                f += this.gc.gO + this.gc.gP + this.gc.gF;
            }
            if (((float) s.W(this)) != f) {
                s.d(this, s.V(this), getPaddingTop(), (int) f, getPaddingBottom());
            }
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, gb);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (TextUtils.isEmpty(getText()) || this.gc == null || this.gc.hm) {
            super.onDraw(canvas);
            return;
        }
        int save = canvas.save();
        float chipStartPadding = getChipStartPadding() + this.gc.aW() + getTextStartPadding();
        if (s.Q(this) != 0) {
            chipStartPadding = -chipStartPadding;
        }
        canvas.translate(chipStartPadding, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setBackgroundColor(int i) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundResource(int i) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackground(Drawable drawable) {
        if (drawable == this.gc || drawable == this.gd) {
            super.setBackground(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == this.gc || drawable == this.gd) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public TextUtils.TruncateAt getEllipsize() {
        if (this.gc != null) {
            return this.gc.hl;
        }
        return null;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.gc != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                if (this.gc != null) {
                    this.gc.hl = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        if (this.gc != null) {
            this.gc.maxWidth = i;
        }
    }

    public final void aL() {
        aK();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setChecked(boolean z) {
        if (this.gc == null) {
            this.gf = z;
        } else if (this.gc.gG) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && this.ge != null) {
                this.ge.onCheckedChanged(this, z);
            }
        }
    }

    public final boolean aM() {
        playSoundEffect(0);
        this.gk.sendEventForVirtualView(0, 1);
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        setCloseIconPressed(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r0 != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (super.onTouchEvent(r5) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getActionMasked()
            android.graphics.RectF r1 = r4.aO()
            float r2 = r5.getX()
            float r3 = r5.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            switch(r0) {
                case 0: goto L_0x0032;
                case 1: goto L_0x0024;
                case 2: goto L_0x001a;
                case 3: goto L_0x002d;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0039
        L_0x001a:
            boolean r0 = r4.gh
            if (r0 == 0) goto L_0x0039
            if (r1 != 0) goto L_0x0037
            r4.setCloseIconPressed(r2)
            goto L_0x0037
        L_0x0024:
            boolean r0 = r4.gh
            if (r0 == 0) goto L_0x002d
            r4.aM()
            r0 = r3
            goto L_0x002e
        L_0x002d:
            r0 = r2
        L_0x002e:
            r4.setCloseIconPressed(r2)
            goto L_0x003a
        L_0x0032:
            if (r1 == 0) goto L_0x0039
            r4.setCloseIconPressed(r3)
        L_0x0037:
            r0 = r3
            goto L_0x003a
        L_0x0039:
            r0 = r2
        L_0x003a:
            if (r0 != 0) goto L_0x0044
            boolean r4 = super.onTouchEvent(r5)
            if (r4 == 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            return r2
        L_0x0044:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(aO().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @SuppressLint({"PrivateApi"})
    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = i.class.getDeclaredField("Lg");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.gk)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = i.class.getDeclaredMethod("updateHoveredVirtualView", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.gk, new Object[]{Integer.MIN_VALUE});
                    return true;
                }
            } catch (NoSuchMethodException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (IllegalAccessException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (NoSuchFieldException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchHoverEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.a((android.view.MotionEvent) r7)
            r1 = 1
            if (r0 != 0) goto L_0x004e
            android.support.design.chip.Chip$a r0 = r6.gk
            android.view.accessibility.AccessibilityManager r2 = r0.Lb
            boolean r2 = r2.isEnabled()
            r3 = 0
            if (r2 == 0) goto L_0x0043
            android.view.accessibility.AccessibilityManager r2 = r0.Lb
            boolean r2 = r2.isTouchExplorationEnabled()
            if (r2 != 0) goto L_0x001b
            goto L_0x0043
        L_0x001b:
            int r2 = r7.getAction()
            r4 = 7
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == r4) goto L_0x0030
            switch(r2) {
                case 9: goto L_0x0030;
                case 10: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x0043
        L_0x0028:
            int r2 = r0.Lg
            if (r2 == r5) goto L_0x0043
            r0.aA(r5)
            goto L_0x0041
        L_0x0030:
            float r2 = r7.getX()
            float r4 = r7.getY()
            int r2 = r0.getVirtualViewAt(r2, r4)
            r0.aA(r2)
            if (r2 == r5) goto L_0x0043
        L_0x0041:
            r0 = r1
            goto L_0x0044
        L_0x0043:
            r0 = r3
        L_0x0044:
            if (r0 != 0) goto L_0x004e
            boolean r6 = super.dispatchHoverEvent(r7)
            if (r6 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            return r3
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            android.support.design.chip.Chip$a r0 = r9.gk
            int r1 = r10.getAction()
            r2 = 0
            r3 = 1
            if (r1 == r3) goto L_0x006c
            int r1 = r10.getKeyCode()
            r4 = 61
            r5 = 0
            if (r1 == r4) goto L_0x0055
            r4 = 66
            if (r1 == r4) goto L_0x003a
            switch(r1) {
                case 19: goto L_0x001b;
                case 20: goto L_0x001b;
                case 21: goto L_0x001b;
                case 22: goto L_0x001b;
                case 23: goto L_0x003a;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x006c
        L_0x001b:
            boolean r4 = r10.hasNoModifiers()
            if (r4 == 0) goto L_0x006c
            int r1 = android.support.v4.widget.i.az(r1)
            int r4 = r10.getRepeatCount()
            int r4 = r4 + r3
            r6 = r2
            r7 = r6
        L_0x002c:
            if (r6 >= r4) goto L_0x0038
            boolean r8 = r0.a(r1, r5)
            if (r8 == 0) goto L_0x0038
            int r6 = r6 + 1
            r7 = r3
            goto L_0x002c
        L_0x0038:
            r0 = r7
            goto L_0x006d
        L_0x003a:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L_0x006c
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L_0x006c
            int r1 = r0.Lf
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r4) goto L_0x0053
            int r1 = r0.Lf
            r4 = 16
            r0.g(r1, r4)
        L_0x0053:
            r0 = r3
            goto L_0x006d
        L_0x0055:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L_0x0061
            r1 = 2
            boolean r0 = r0.a(r1, r5)
            goto L_0x006d
        L_0x0061:
            boolean r1 = r10.hasModifiers(r3)
            if (r1 == 0) goto L_0x006c
            boolean r0 = r0.a(r3, r5)
            goto L_0x006d
        L_0x006c:
            r0 = r2
        L_0x006d:
            if (r0 != 0) goto L_0x0077
            boolean r9 = super.dispatchKeyEvent(r10)
            if (r9 == 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            return r2
        L_0x0077:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect2) {
        if (z) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(Integer.MIN_VALUE);
        }
        invalidate();
        super.onFocusChanged(z, i, rect2);
        a aVar = this.gk;
        if (aVar.Lf != Integer.MIN_VALUE) {
            aVar.aF(aVar.Lf);
        }
        if (z) {
            aVar.a(i, rect2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getKeyCode()
            r1 = 61
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x003f
            r1 = 66
            if (r0 == r1) goto L_0x0031
            switch(r0) {
                case 21: goto L_0x0022;
                case 22: goto L_0x0012;
                case 23: goto L_0x0031;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x006b
        L_0x0012:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006b
            boolean r0 = android.support.design.internal.g.isLayoutRtl(r6)
            r0 = r0 ^ r3
            boolean r2 = r6.h(r0)
            goto L_0x006b
        L_0x0022:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006b
            boolean r0 = android.support.design.internal.g.isLayoutRtl(r6)
            boolean r2 = r6.h(r0)
            goto L_0x006b
        L_0x0031:
            int r0 = r6.gg
            switch(r0) {
                case -1: goto L_0x003b;
                case 0: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x006b
        L_0x0037:
            r6.aM()
            return r3
        L_0x003b:
            r6.performClick()
            return r3
        L_0x003f:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x0047
            r0 = 2
            goto L_0x0050
        L_0x0047:
            boolean r0 = r8.hasModifiers(r3)
            if (r0 == 0) goto L_0x004f
            r0 = r3
            goto L_0x0050
        L_0x004f:
            r0 = r2
        L_0x0050:
            if (r0 == 0) goto L_0x006b
            android.view.ViewParent r1 = r6.getParent()
            r4 = r6
        L_0x0057:
            android.view.View r4 = r4.focusSearch(r0)
            if (r4 == 0) goto L_0x0065
            if (r4 == r6) goto L_0x0065
            android.view.ViewParent r5 = r4.getParent()
            if (r5 == r1) goto L_0x0057
        L_0x0065:
            if (r4 == 0) goto L_0x006b
            r4.requestFocus()
            return r3
        L_0x006b:
            if (r2 == 0) goto L_0x0071
            r6.invalidate()
            return r3
        L_0x0071:
            boolean r6 = super.onKeyDown(r7, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.chip.Chip.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public void getFocusedRect(Rect rect2) {
        if (this.gg == 0) {
            rect2.set(aP());
        } else {
            super.getFocusedRect(rect2);
        }
    }

    private void setFocusedVirtualView(int i) {
        if (this.gg != i) {
            if (this.gg == 0) {
                setCloseIconFocused(false);
            }
            this.gg = i;
            if (i == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.gh != z) {
            this.gh = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.gi != z) {
            this.gi = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconFocused(boolean z) {
        if (this.gj != z) {
            this.gj = z;
            refreshDrawableState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int i = 0;
        if (this.gc != null && a.c(this.gc.gD)) {
            a aVar = this.gc;
            int i2 = isEnabled() ? 1 : 0;
            if (this.gj) {
                i2++;
            }
            if (this.gi) {
                i2++;
            }
            if (this.gh) {
                i2++;
            }
            if (isChecked()) {
                i2++;
            }
            int[] iArr = new int[i2];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.gj) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.gi) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.gh) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            i = aVar.b(iArr);
        }
        if (i != 0) {
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public boolean aN() {
        return (this.gc == null || this.gc.bb() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public RectF aO() {
        this.fP.setEmpty();
        if (aN()) {
            a aVar = this.gc;
            RectF rectF = this.fP;
            Rect bounds = aVar.getBounds();
            rectF.setEmpty();
            if (aVar.aV()) {
                float f = aVar.gQ + aVar.gP + aVar.gF + aVar.gO + aVar.gN;
                if (android.support.v4.graphics.drawable.a.u(aVar) == 0) {
                    rectF.right = (float) bounds.right;
                    rectF.left = rectF.right - f;
                } else {
                    rectF.left = (float) bounds.left;
                    rectF.right = ((float) bounds.left) + f;
                }
                rectF.top = (float) bounds.top;
                rectF.bottom = (float) bounds.bottom;
            }
        }
        return this.fP;
    }

    /* access modifiers changed from: private */
    public Rect aP() {
        RectF aO = aO();
        this.rect.set((int) aO.left, (int) aO.top, (int) aO.right, (int) aO.bottom);
        return this.rect;
    }

    private class a extends i {
        a(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        public final int getVirtualViewAt(float f, float f2) {
            return (!Chip.this.aN() || !Chip.this.aO().contains(f, f2)) ? -1 : 0;
        }

        /* access modifiers changed from: protected */
        public final void f(List<Integer> list) {
            if (Chip.this.aN()) {
                list.add(0);
            }
        }

        /* access modifiers changed from: protected */
        public final void a(b bVar) {
            if (Chip.this.aN()) {
                Chip chip = Chip.this;
                if (chip.gc != null) {
                    a aVar = chip.gc;
                }
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i = a.i.dx3;
                Object[] objArr = new Object[1];
                if (TextUtils.isEmpty(text)) {
                    text = "";
                }
                objArr[0] = text;
                bVar.setContentDescription(context.getString(i, objArr).trim());
                bVar.setBoundsInParent(Chip.this.aP());
                b.a aVar2 = b.a.IH;
                if (Build.VERSION.SDK_INT >= 21) {
                    bVar.IC.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar2.II);
                }
                bVar.setEnabled(Chip.this.isEnabled());
                return;
            }
            bVar.setContentDescription("");
            bVar.setBoundsInParent(Chip.ga);
        }

        /* access modifiers changed from: protected */
        public final void b(b bVar) {
            bVar.setCheckable(Chip.this.gc != null && Chip.this.gc.gG);
            bVar.setClassName(Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.setText(text);
            } else {
                bVar.setContentDescription(text);
            }
        }

        /* access modifiers changed from: protected */
        public final boolean g(int i, int i2) {
            if (i2 == 16 && i == 0) {
                return Chip.this.aM();
            }
            return false;
        }
    }

    public void setChipBackgroundColorResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.b(android.support.v7.c.a.a.c(aVar.context, i));
        }
    }

    public float getChipMinHeight() {
        if (this.gc != null) {
            return this.gc.gp;
        }
        return 0.0f;
    }

    public void setChipMinHeightResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setChipMinHeight(aVar.context.getResources().getDimension(i));
        }
    }

    public void setChipMinHeight(float f) {
        if (this.gc != null) {
            this.gc.setChipMinHeight(f);
        }
    }

    public float getChipCornerRadius() {
        if (this.gc != null) {
            return this.gc.gq;
        }
        return 0.0f;
    }

    public void setChipCornerRadiusResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setChipCornerRadius(aVar.context.getResources().getDimension(i));
        }
    }

    public void setChipCornerRadius(float f) {
        if (this.gc != null) {
            this.gc.setChipCornerRadius(f);
        }
    }

    public void setChipStrokeColorResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.c(android.support.v7.c.a.a.c(aVar.context, i));
        }
    }

    public float getChipStrokeWidth() {
        if (this.gc != null) {
            return this.gc.gs;
        }
        return 0.0f;
    }

    public void setChipStrokeWidthResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setChipStrokeWidth(aVar.context.getResources().getDimension(i));
        }
    }

    public void setChipStrokeWidth(float f) {
        if (this.gc != null) {
            this.gc.setChipStrokeWidth(f);
        }
    }

    public void setRippleColorResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.d(android.support.v7.c.a.a.c(aVar.context, i));
        }
    }

    public CharSequence getText() {
        return this.gc != null ? this.gc.gt : "";
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.gc != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            CharSequence h = android.support.v4.d.a.eS().h(charSequence);
            if (this.gc.hm) {
                h = null;
            }
            super.setText(h, bufferType);
            if (this.gc != null) {
                this.gc.setText(charSequence);
            }
        }
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    private android.support.design.d.b aQ() {
        if (this.gc != null) {
            return this.gc.gv;
        }
        return null;
    }

    private void a(android.support.design.d.b bVar) {
        TextPaint paint = getPaint();
        paint.drawableState = this.gc.getState();
        bVar.a(getContext(), paint, this.gl);
    }

    public void setTextAppearanceResource(int i) {
        if (this.gc != null) {
            this.gc.setTextAppearanceResource(i);
        }
        setTextAppearance(getContext(), i);
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.gc != null) {
            this.gc.setTextAppearanceResource(i);
        }
        if (aQ() != null) {
            aQ().b(context, getPaint(), this.gl);
            a(aQ());
        }
    }

    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        if (this.gc != null) {
            this.gc.setTextAppearanceResource(i);
        }
        if (aQ() != null) {
            aQ().b(getContext(), getPaint(), this.gl);
            a(aQ());
        }
    }

    public void setChipIconVisible(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setChipIconVisible(aVar.context.getResources().getBoolean(i));
        }
    }

    public void setChipIconVisible(boolean z) {
        if (this.gc != null) {
            this.gc.setChipIconVisible(z);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    public void setChipIconResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.f(android.support.v7.c.a.a.getDrawable(aVar.context, i));
        }
    }

    public void setChipIconTintResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.e(android.support.v7.c.a.a.c(aVar.context, i));
        }
    }

    public float getChipIconSize() {
        if (this.gc != null) {
            return this.gc.gB;
        }
        return 0.0f;
    }

    public void setChipIconSizeResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setChipIconSize(aVar.context.getResources().getDimension(i));
        }
    }

    public void setChipIconSize(float f) {
        if (this.gc != null) {
            this.gc.setChipIconSize(f);
        }
    }

    public void setCloseIconVisible(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setCloseIconVisible(aVar.context.getResources().getBoolean(i));
        }
    }

    public void setCloseIconVisible(boolean z) {
        if (this.gc != null) {
            this.gc.setCloseIconVisible(z);
        }
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    public void setCloseIconResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.g(android.support.v7.c.a.a.getDrawable(aVar.context, i));
        }
    }

    public void setCloseIconTintResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.f(android.support.v7.c.a.a.c(aVar.context, i));
        }
    }

    public float getCloseIconSize() {
        if (this.gc != null) {
            return this.gc.gF;
        }
        return 0.0f;
    }

    public void setCloseIconSizeResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setCloseIconSize(aVar.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconSize(float f) {
        if (this.gc != null) {
            this.gc.setCloseIconSize(f);
        }
    }

    public void setCheckableResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setCheckable(aVar.context.getResources().getBoolean(i));
        }
    }

    public void setCheckable(boolean z) {
        if (this.gc != null) {
            this.gc.setCheckable(z);
        }
    }

    public void setCheckedIconVisible(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setCheckedIconVisible(aVar.context.getResources().getBoolean(i));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.gc != null) {
            this.gc.setCheckedIconVisible(z);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    public void setCheckedIconResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.h(android.support.v7.c.a.a.getDrawable(aVar.context, i));
        }
    }

    public void setShowMotionSpecResource(int i) {
        if (this.gc != null) {
            h.b(this.gc.context, i);
        }
    }

    public void setHideMotionSpecResource(int i) {
        if (this.gc != null) {
            h.b(this.gc.context, i);
        }
    }

    public float getChipStartPadding() {
        if (this.gc != null) {
            return this.gc.gJ;
        }
        return 0.0f;
    }

    public void setChipStartPaddingResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setChipStartPadding(aVar.context.getResources().getDimension(i));
        }
    }

    public void setChipStartPadding(float f) {
        if (this.gc != null) {
            this.gc.setChipStartPadding(f);
        }
    }

    public float getIconStartPadding() {
        if (this.gc != null) {
            return this.gc.gK;
        }
        return 0.0f;
    }

    public void setIconStartPaddingResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setIconStartPadding(aVar.context.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        if (this.gc != null) {
            this.gc.setIconStartPadding(f);
        }
    }

    public float getIconEndPadding() {
        if (this.gc != null) {
            return this.gc.gL;
        }
        return 0.0f;
    }

    public void setIconEndPaddingResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setIconEndPadding(aVar.context.getResources().getDimension(i));
        }
    }

    public void setIconEndPadding(float f) {
        if (this.gc != null) {
            this.gc.setIconEndPadding(f);
        }
    }

    public float getTextStartPadding() {
        if (this.gc != null) {
            return this.gc.gM;
        }
        return 0.0f;
    }

    public void setTextStartPaddingResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setTextStartPadding(aVar.context.getResources().getDimension(i));
        }
    }

    public void setTextStartPadding(float f) {
        if (this.gc != null) {
            this.gc.setTextStartPadding(f);
        }
    }

    public float getTextEndPadding() {
        if (this.gc != null) {
            return this.gc.gN;
        }
        return 0.0f;
    }

    public void setTextEndPaddingResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setTextEndPadding(aVar.context.getResources().getDimension(i));
        }
    }

    public void setTextEndPadding(float f) {
        if (this.gc != null) {
            this.gc.setTextEndPadding(f);
        }
    }

    public float getCloseIconStartPadding() {
        if (this.gc != null) {
            return this.gc.gO;
        }
        return 0.0f;
    }

    public void setCloseIconStartPaddingResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setCloseIconStartPadding(aVar.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        if (this.gc != null) {
            this.gc.setCloseIconStartPadding(f);
        }
    }

    public float getCloseIconEndPadding() {
        if (this.gc != null) {
            return this.gc.gP;
        }
        return 0.0f;
    }

    public void setCloseIconEndPaddingResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setCloseIconEndPadding(aVar.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconEndPadding(float f) {
        if (this.gc != null) {
            this.gc.setCloseIconEndPadding(f);
        }
    }

    public float getChipEndPadding() {
        if (this.gc != null) {
            return this.gc.gQ;
        }
        return 0.0f;
    }

    public void setChipEndPaddingResource(int i) {
        if (this.gc != null) {
            a aVar = this.gc;
            aVar.setChipEndPadding(aVar.context.getResources().getDimension(i));
        }
    }

    public void setChipEndPadding(float f) {
        if (this.gc != null) {
            this.gc.setChipEndPadding(f);
        }
    }

    private boolean h(boolean z) {
        if (this.gg == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
        if (z) {
            if (this.gg == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.gg == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }
}
