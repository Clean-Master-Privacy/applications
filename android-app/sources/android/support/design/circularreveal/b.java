package android.support.design.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.circularreveal.c;
import android.support.design.widget.j;
import android.view.View;

public final class b {
    public static final int hz;
    private final a hA;
    private final Path hB = new Path();
    private final Paint hC = new Paint(7);
    public final Paint hD = new Paint(1);
    private c.d hE;
    private Drawable hF;
    private boolean hG;
    private boolean hH;
    private final View view;

    interface a {
        void a(Canvas canvas);

        boolean bf();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            hz = 2;
        } else if (Build.VERSION.SDK_INT >= 18) {
            hz = 1;
        } else {
            hz = 0;
        }
    }

    public b(a aVar) {
        this.hA = aVar;
        this.view = (View) aVar;
        this.view.setWillNotDraw(false);
        this.hD.setColor(0);
    }

    public final void bc() {
        if (hz == 0) {
            this.hG = true;
            this.hH = false;
            this.view.buildDrawingCache();
            Bitmap drawingCache = this.view.getDrawingCache();
            if (!(drawingCache != null || this.view.getWidth() == 0 || this.view.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
                this.view.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                this.hC.setShader(new BitmapShader(drawingCache, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            }
            this.hG = false;
            this.hH = true;
        }
    }

    public final void bd() {
        if (hz == 0) {
            this.hH = false;
            this.view.destroyDrawingCache();
            this.hC.setShader((Shader) null);
            this.view.invalidate();
        }
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            this.hE = null;
        } else {
            if (this.hE == null) {
                this.hE = new c.d(dVar);
            } else {
                this.hE.a(dVar.centerX, dVar.centerY, dVar.radius);
            }
            if (dVar.radius + 1.0E-4f >= b(dVar)) {
                this.hE.radius = Float.MAX_VALUE;
            }
        }
        if (hz == 1) {
            this.hB.rewind();
            if (this.hE != null) {
                this.hB.addCircle(this.hE.centerX, this.hE.centerY, this.hE.radius, Path.Direction.CW);
            }
        }
        this.view.invalidate();
    }

    public final c.d be() {
        if (this.hE == null) {
            return null;
        }
        c.d dVar = new c.d(this.hE);
        if (dVar.isInvalid()) {
            dVar.radius = b(dVar);
        }
        return dVar;
    }

    public final void setCircularRevealScrimColor(int i) {
        this.hD.setColor(i);
        this.view.invalidate();
    }

    public final void i(Drawable drawable) {
        this.hF = drawable;
        this.view.invalidate();
    }

    private float b(c.d dVar) {
        return j.b(dVar.centerX, dVar.centerY, (float) this.view.getWidth(), (float) this.view.getHeight());
    }

    public final void draw(Canvas canvas) {
        if (bg()) {
            switch (hz) {
                case 0:
                    canvas.drawCircle(this.hE.centerX, this.hE.centerY, this.hE.radius, this.hC);
                    if (bh()) {
                        canvas.drawCircle(this.hE.centerX, this.hE.centerY, this.hE.radius, this.hD);
                        break;
                    }
                    break;
                case 1:
                    int save = canvas.save();
                    canvas.clipPath(this.hB);
                    this.hA.a(canvas);
                    if (bh()) {
                        canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.hD);
                    }
                    canvas.restoreToCount(save);
                    break;
                case 2:
                    this.hA.a(canvas);
                    if (bh()) {
                        canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.hD);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unsupported strategy " + hz);
            }
        } else {
            this.hA.a(canvas);
            if (bh()) {
                canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.hD);
            }
        }
        if ((this.hG || this.hF == null || this.hE == null) ? false : true) {
            Rect bounds = this.hF.getBounds();
            float width = this.hE.centerX - (((float) bounds.width()) / 2.0f);
            float height = this.hE.centerY - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.hF.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public final boolean isOpaque() {
        return this.hA.bf() && !bg();
    }

    private boolean bg() {
        boolean z = this.hE == null || this.hE.isInvalid();
        return hz == 0 ? !z && this.hH : !z;
    }

    private boolean bh() {
        return !this.hG && Color.alpha(this.hD.getColor()) != 0;
    }
}
