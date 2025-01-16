package android.support.design.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.a;

final class b {
    static final boolean fH = (Build.VERSION.SDK_INT >= 21);
    final Rect bounds = new Rect();
    final MaterialButton fI;
    int fJ;
    PorterDuff.Mode fK;
    ColorStateList fL;
    ColorStateList fM;
    ColorStateList fN;
    final Paint fO = new Paint(1);
    final RectF fP = new RectF();
    GradientDrawable fQ;
    Drawable fR;
    GradientDrawable fS;
    Drawable fT;
    GradientDrawable fU;
    GradientDrawable fV;
    GradientDrawable fW;
    boolean fX = false;
    int insetBottom;
    int insetLeft;
    int insetRight;
    int insetTop;
    int strokeWidth;

    public b(MaterialButton materialButton) {
        this.fI = materialButton;
    }

    /* access modifiers changed from: package-private */
    public final InsetDrawable b(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    /* access modifiers changed from: package-private */
    public final void aF() {
        if (this.fU != null) {
            a.a((Drawable) this.fU, this.fL);
            if (this.fK != null) {
                a.a((Drawable) this.fU, this.fK);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(21)
    public final Drawable aG() {
        this.fU = new GradientDrawable();
        this.fU.setCornerRadius(((float) this.fJ) + 1.0E-5f);
        this.fU.setColor(-1);
        aF();
        this.fV = new GradientDrawable();
        this.fV.setCornerRadius(((float) this.fJ) + 1.0E-5f);
        this.fV.setColor(0);
        this.fV.setStroke(this.strokeWidth, this.fM);
        InsetDrawable b2 = b(new LayerDrawable(new Drawable[]{this.fU, this.fV}));
        this.fW = new GradientDrawable();
        this.fW.setCornerRadius(((float) this.fJ) + 1.0E-5f);
        this.fW.setColor(-1);
        return new a(android.support.design.e.a.i(this.fN), b2, this.fW);
    }

    /* access modifiers changed from: package-private */
    public final void aH() {
        if (fH && this.fV != null) {
            this.fI.a(aG());
        } else if (!fH) {
            this.fI.invalidate();
        }
    }
}
