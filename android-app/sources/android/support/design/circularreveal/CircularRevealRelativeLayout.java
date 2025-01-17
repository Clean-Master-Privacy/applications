package android.support.design.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.design.circularreveal.c;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CircularRevealRelativeLayout extends RelativeLayout implements c {
    private final b hy = new b(this);

    public CircularRevealRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void bc() {
        this.hy.bc();
    }

    public final void bd() {
        this.hy.bd();
    }

    public final c.d be() {
        return this.hy.be();
    }

    public final void a(c.d dVar) {
        this.hy.a(dVar);
    }

    public int getCircularRevealScrimColor() {
        return this.hy.hD.getColor();
    }

    public void setCircularRevealScrimColor(int i) {
        this.hy.setCircularRevealScrimColor(i);
    }

    public final void i(Drawable drawable) {
        this.hy.i(drawable);
    }

    public void draw(Canvas canvas) {
        this.hy.draw(canvas);
    }

    public final void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean isOpaque() {
        return this.hy.isOpaque();
    }

    public final boolean bf() {
        return super.isOpaque();
    }
}
