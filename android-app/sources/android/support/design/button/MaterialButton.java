package android.support.design.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.a;
import android.support.design.internal.f;
import android.support.design.internal.g;
import android.support.v4.view.s;
import android.support.v4.widget.n;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;

public class MaterialButton extends AppCompatButton {
    private final b fA;
    private int fB;
    private PorterDuff.Mode fC;
    private ColorStateList fD;
    private int fE;
    private int fF;
    private int fG;
    private Drawable icon;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.br);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        TypedArray a2 = f.a(context, attributeSet, a.k.MaterialButton, i, a.j.s0, new int[0]);
        this.fB = a2.getDimensionPixelSize(a.k.MaterialButton_iconPadding, 0);
        this.fC = g.parseTintMode(a2.getInt(a.k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.fD = android.support.design.d.a.b(getContext(), a2, a.k.MaterialButton_iconTint);
        this.icon = android.support.design.d.a.c(getContext(), a2, a.k.MaterialButton_icon);
        this.fG = a2.getInteger(a.k.MaterialButton_iconGravity, 1);
        this.fE = a2.getDimensionPixelSize(a.k.MaterialButton_iconSize, 0);
        this.fA = new b(this);
        b bVar = this.fA;
        bVar.insetLeft = a2.getDimensionPixelOffset(a.k.MaterialButton_android_insetLeft, 0);
        bVar.insetRight = a2.getDimensionPixelOffset(a.k.MaterialButton_android_insetRight, 0);
        bVar.insetTop = a2.getDimensionPixelOffset(a.k.MaterialButton_android_insetTop, 0);
        bVar.insetBottom = a2.getDimensionPixelOffset(a.k.MaterialButton_android_insetBottom, 0);
        bVar.fJ = a2.getDimensionPixelSize(a.k.MaterialButton_cornerRadius, 0);
        bVar.strokeWidth = a2.getDimensionPixelSize(a.k.MaterialButton_strokeWidth, 0);
        bVar.fK = g.parseTintMode(a2.getInt(a.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        bVar.fL = android.support.design.d.a.b(bVar.fI.getContext(), a2, a.k.MaterialButton_backgroundTint);
        bVar.fM = android.support.design.d.a.b(bVar.fI.getContext(), a2, a.k.MaterialButton_strokeColor);
        bVar.fN = android.support.design.d.a.b(bVar.fI.getContext(), a2, a.k.MaterialButton_rippleColor);
        bVar.fO.setStyle(Paint.Style.STROKE);
        bVar.fO.setStrokeWidth((float) bVar.strokeWidth);
        bVar.fO.setColor(bVar.fM != null ? bVar.fM.getColorForState(bVar.fI.getDrawableState(), 0) : 0);
        int V = s.V(bVar.fI);
        int paddingTop = bVar.fI.getPaddingTop();
        int W = s.W(bVar.fI);
        int paddingBottom = bVar.fI.getPaddingBottom();
        MaterialButton materialButton = bVar.fI;
        if (b.fH) {
            drawable = bVar.aG();
        } else {
            bVar.fQ = new GradientDrawable();
            bVar.fQ.setCornerRadius(((float) bVar.fJ) + 1.0E-5f);
            bVar.fQ.setColor(-1);
            bVar.fR = android.support.v4.graphics.drawable.a.s(bVar.fQ);
            android.support.v4.graphics.drawable.a.a(bVar.fR, bVar.fL);
            if (bVar.fK != null) {
                android.support.v4.graphics.drawable.a.a(bVar.fR, bVar.fK);
            }
            bVar.fS = new GradientDrawable();
            bVar.fS.setCornerRadius(((float) bVar.fJ) + 1.0E-5f);
            bVar.fS.setColor(-1);
            bVar.fT = android.support.v4.graphics.drawable.a.s(bVar.fS);
            android.support.v4.graphics.drawable.a.a(bVar.fT, bVar.fN);
            drawable = bVar.b(new LayerDrawable(new Drawable[]{bVar.fR, bVar.fT}));
        }
        super.setBackgroundDrawable(drawable);
        s.d(bVar.fI, V + bVar.insetLeft, paddingTop + bVar.insetTop, W + bVar.insetRight, paddingBottom + bVar.insetBottom);
        a2.recycle();
        setCompoundDrawablePadding(this.fB);
        aD();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT < 21 && aE()) {
            b bVar = this.fA;
            if (canvas != null && bVar.fM != null && bVar.strokeWidth > 0) {
                bVar.bounds.set(bVar.fI.getBackground().getBounds());
                bVar.fP.set(((float) bVar.bounds.left) + (((float) bVar.strokeWidth) / 2.0f) + ((float) bVar.insetLeft), ((float) bVar.bounds.top) + (((float) bVar.strokeWidth) / 2.0f) + ((float) bVar.insetTop), (((float) bVar.bounds.right) - (((float) bVar.strokeWidth) / 2.0f)) - ((float) bVar.insetRight), (((float) bVar.bounds.bottom) - (((float) bVar.strokeWidth) / 2.0f)) - ((float) bVar.insetBottom));
                float f = ((float) bVar.fJ) - (((float) bVar.strokeWidth) / 2.0f);
                canvas.drawRoundRect(bVar.fP, f, f, bVar.fO);
            }
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (aE()) {
            b bVar = this.fA;
            if (bVar.fL != colorStateList) {
                bVar.fL = colorStateList;
                if (b.fH) {
                    bVar.aF();
                } else if (bVar.fR != null) {
                    android.support.v4.graphics.drawable.a.a(bVar.fR, bVar.fL);
                }
            }
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (aE()) {
            return this.fA.fL;
        }
        return super.getSupportBackgroundTintList();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (aE()) {
            b bVar = this.fA;
            if (bVar.fK != mode) {
                bVar.fK = mode;
                if (b.fH) {
                    bVar.aF();
                } else if (bVar.fR != null && bVar.fK != null) {
                    android.support.v4.graphics.drawable.a.a(bVar.fR, bVar.fK);
                }
            }
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (aE()) {
            return this.fA.fK;
        }
        return super.getSupportBackgroundTintMode();
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public void setBackgroundColor(int i) {
        if (aE()) {
            b bVar = this.fA;
            if (b.fH && bVar.fU != null) {
                bVar.fU.setColor(i);
            } else if (!b.fH && bVar.fQ != null) {
                bVar.fQ.setColor(i);
            }
        } else {
            super.setBackgroundColor(i);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? android.support.v7.c.a.a.getDrawable(getContext(), i) : null);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (aE()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                b bVar = this.fA;
                bVar.fX = true;
                bVar.fI.setSupportBackgroundTintList(bVar.fL);
                bVar.fI.setSupportBackgroundTintMode(bVar.fK);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT == 21) {
            b bVar = this.fA;
            int i5 = i4 - i2;
            int i6 = i3 - i;
            if (bVar.fW != null) {
                bVar.fW.setBounds(bVar.insetLeft, bVar.insetTop, i6 - bVar.insetRight, i5 - bVar.insetBottom);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.icon != null && this.fG == 2) {
            int measuredWidth = (((((getMeasuredWidth() - ((int) getPaint().measureText(getText().toString()))) - s.W(this)) - (this.fE == 0 ? this.icon.getIntrinsicWidth() : this.fE)) - this.fB) - s.V(this)) / 2;
            boolean z = true;
            if (s.Q(this) != 1) {
                z = false;
            }
            if (z) {
                measuredWidth = -measuredWidth;
            }
            if (this.fF != measuredWidth) {
                this.fF = measuredWidth;
                aD();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setIconPadding(int i) {
        if (this.fB != i) {
            this.fB = i;
            setCompoundDrawablePadding(i);
        }
    }

    public int getIconPadding() {
        return this.fB;
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.fE != i) {
            this.fE = i;
            aD();
        }
    }

    public int getIconSize() {
        return this.fE;
    }

    public void setIconResource(int i) {
        Drawable drawable = i != 0 ? android.support.v7.c.a.a.getDrawable(getContext(), i) : null;
        if (this.icon != drawable) {
            this.icon = drawable;
            aD();
        }
    }

    public void setIconTintResource(int i) {
        ColorStateList c2 = android.support.v7.c.a.a.c(getContext(), i);
        if (this.fD != c2) {
            this.fD = c2;
            aD();
        }
    }

    private void aD() {
        if (this.icon != null) {
            this.icon = this.icon.mutate();
            android.support.v4.graphics.drawable.a.a(this.icon, this.fD);
            if (this.fC != null) {
                android.support.v4.graphics.drawable.a.a(this.icon, this.fC);
            }
            this.icon.setBounds(this.fF, 0, this.fF + (this.fE != 0 ? this.fE : this.icon.getIntrinsicWidth()), this.fE != 0 ? this.fE : this.icon.getIntrinsicHeight());
        }
        n.a(this, this.icon, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setRippleColorResource(int i) {
        if (aE()) {
            ColorStateList c2 = android.support.v7.c.a.a.c(getContext(), i);
            if (aE()) {
                b bVar = this.fA;
                if (bVar.fN != c2) {
                    bVar.fN = c2;
                    if (b.fH && (bVar.fI.getBackground() instanceof RippleDrawable)) {
                        ((RippleDrawable) bVar.fI.getBackground()).setColor(c2);
                    } else if (!b.fH && bVar.fT != null) {
                        android.support.v4.graphics.drawable.a.a(bVar.fT, c2);
                    }
                }
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (aE()) {
            ColorStateList c2 = android.support.v7.c.a.a.c(getContext(), i);
            if (aE()) {
                b bVar = this.fA;
                if (bVar.fM != c2) {
                    bVar.fM = c2;
                    Paint paint = bVar.fO;
                    int i2 = 0;
                    if (c2 != null) {
                        i2 = c2.getColorForState(bVar.fI.getDrawableState(), 0);
                    }
                    paint.setColor(i2);
                    bVar.aH();
                }
            }
        }
    }

    public void setStrokeWidth(int i) {
        if (aE()) {
            b bVar = this.fA;
            if (bVar.strokeWidth != i) {
                bVar.strokeWidth = i;
                bVar.fO.setStrokeWidth((float) i);
                bVar.aH();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (aE()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    public int getStrokeWidth() {
        if (aE()) {
            return this.fA.strokeWidth;
        }
        return 0;
    }

    /* JADX WARNING: type inference failed for: r0v26, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCornerRadius(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.aE()
            if (r0 == 0) goto L_0x00b0
            android.support.design.button.b r5 = r5.fA
            int r0 = r5.fJ
            if (r0 == r6) goto L_0x00b0
            r5.fJ = r6
            boolean r0 = android.support.design.button.b.fH
            r1 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r0 == 0) goto L_0x0093
            android.graphics.drawable.GradientDrawable r0 = r5.fU
            if (r0 == 0) goto L_0x0093
            android.graphics.drawable.GradientDrawable r0 = r5.fV
            if (r0 == 0) goto L_0x0093
            android.graphics.drawable.GradientDrawable r0 = r5.fW
            if (r0 == 0) goto L_0x0093
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 != r2) goto L_0x0081
            boolean r0 = android.support.design.button.b.fH
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0050
            android.support.design.button.MaterialButton r0 = r5.fI
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x0050
            android.support.design.button.MaterialButton r0 = r5.fI
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            android.graphics.drawable.RippleDrawable r0 = (android.graphics.drawable.RippleDrawable) r0
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r3)
            android.graphics.drawable.InsetDrawable r0 = (android.graphics.drawable.InsetDrawable) r0
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r3)
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            goto L_0x0051
        L_0x0050:
            r0 = r2
        L_0x0051:
            float r4 = (float) r6
            float r4 = r4 + r1
            r0.setCornerRadius(r4)
            boolean r0 = android.support.design.button.b.fH
            if (r0 == 0) goto L_0x007e
            android.support.design.button.MaterialButton r0 = r5.fI
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x007e
            android.support.design.button.MaterialButton r0 = r5.fI
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            android.graphics.drawable.RippleDrawable r0 = (android.graphics.drawable.RippleDrawable) r0
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r3)
            android.graphics.drawable.InsetDrawable r0 = (android.graphics.drawable.InsetDrawable) r0
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0
            r2 = 1
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
            r2 = r0
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2
        L_0x007e:
            r2.setCornerRadius(r4)
        L_0x0081:
            android.graphics.drawable.GradientDrawable r0 = r5.fU
            float r6 = (float) r6
            float r6 = r6 + r1
            r0.setCornerRadius(r6)
            android.graphics.drawable.GradientDrawable r0 = r5.fV
            r0.setCornerRadius(r6)
            android.graphics.drawable.GradientDrawable r5 = r5.fW
            r5.setCornerRadius(r6)
            return
        L_0x0093:
            boolean r0 = android.support.design.button.b.fH
            if (r0 != 0) goto L_0x00b0
            android.graphics.drawable.GradientDrawable r0 = r5.fQ
            if (r0 == 0) goto L_0x00b0
            android.graphics.drawable.GradientDrawable r0 = r5.fS
            if (r0 == 0) goto L_0x00b0
            android.graphics.drawable.GradientDrawable r0 = r5.fQ
            float r6 = (float) r6
            float r6 = r6 + r1
            r0.setCornerRadius(r6)
            android.graphics.drawable.GradientDrawable r0 = r5.fS
            r0.setCornerRadius(r6)
            android.support.design.button.MaterialButton r5 = r5.fI
            r5.invalidate()
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.button.MaterialButton.setCornerRadius(int):void");
    }

    public void setCornerRadiusResource(int i) {
        if (aE()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public int getCornerRadius() {
        if (aE()) {
            return this.fA.fJ;
        }
        return 0;
    }

    public int getIconGravity() {
        return this.fG;
    }

    public void setIconGravity(int i) {
        this.fG = i;
    }

    private boolean aE() {
        return !this.fA.fX;
    }
}
