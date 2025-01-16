package android.support.design.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.design.internal.f;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class MaterialCardView extends CardView {
    private final a fY;

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.bs);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray a2 = f.a(context, attributeSet, a.k.MaterialCardView, i, a.j.s_, new int[0]);
        this.fY = new a(this);
        a aVar = this.fY;
        aVar.strokeColor = a2.getColor(a.k.MaterialCardView_strokeColor, -1);
        aVar.strokeWidth = a2.getDimensionPixelSize(a.k.MaterialCardView_strokeWidth, 0);
        aVar.aI();
        aVar.aJ();
        a2.recycle();
    }

    public void setStrokeColor(int i) {
        a aVar = this.fY;
        aVar.strokeColor = i;
        aVar.aI();
    }

    public int getStrokeColor() {
        return this.fY.strokeColor;
    }

    public void setStrokeWidth(int i) {
        a aVar = this.fY;
        aVar.strokeWidth = i;
        aVar.aI();
        aVar.aJ();
    }

    public int getStrokeWidth() {
        return this.fY.strokeWidth;
    }

    public void setRadius(float f) {
        super.setRadius(f);
        this.fY.aI();
    }
}
