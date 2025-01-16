package android.support.design.card;

import android.graphics.drawable.GradientDrawable;

final class a {
    private final MaterialCardView fZ;
    int strokeColor;
    int strokeWidth;

    public a(MaterialCardView materialCardView) {
        this.fZ = materialCardView;
    }

    /* access modifiers changed from: package-private */
    public final void aI() {
        MaterialCardView materialCardView = this.fZ;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.fZ.getRadius());
        if (this.strokeColor != -1) {
            gradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
        }
        materialCardView.setForeground(gradientDrawable);
    }

    /* access modifiers changed from: package-private */
    public final void aJ() {
        this.fZ.setContentPadding(this.fZ.getContentPaddingLeft() + this.strokeWidth, this.fZ.getContentPaddingTop() + this.strokeWidth, this.fZ.getContentPaddingRight() + this.strokeWidth, this.fZ.getContentPaddingBottom() + this.strokeWidth);
    }
}
