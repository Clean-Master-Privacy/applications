package android.support.design.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.a.f;
import android.support.v4.graphics.drawable.b;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class a extends Drawable implements Drawable.Callback, b {
    private static final int[] gn = {16842910};
    private int alpha = 255;
    final Context context;
    ColorStateList fN;
    private final RectF fP = new RectF();
    private ColorStateList gA;
    float gB;
    boolean gC;
    Drawable gD;
    private ColorStateList gE;
    float gF;
    boolean gG;
    boolean gH;
    Drawable gI;
    float gJ;
    float gK;
    float gL;
    float gM;
    float gN;
    float gO;
    float gP;
    float gQ;
    private final TextPaint gR = new TextPaint(1);
    private final Paint gS = new Paint(1);
    private final Paint.FontMetrics gT = new Paint.FontMetrics();
    private final PointF gU = new PointF();
    private int gV;
    private int gW;
    private int gX;
    private int gY;
    private boolean gZ;
    private final f.a gl = new f.a() {
        public final void onFontRetrievalFailed(int i) {
        }

        public final void onFontRetrieved(Typeface typeface) {
            boolean unused = a.this.hj = true;
            a.this.aS();
            a.this.invalidateSelf();
        }
    };
    private ColorStateList go;
    float gp;
    float gq;
    private ColorStateList gr;
    float gs;
    CharSequence gt;
    private CharSequence gu;
    android.support.design.d.b gv;
    boolean gw;
    private Drawable gz;
    private int ha;
    private ColorFilter hb;
    private PorterDuffColorFilter hc;
    private ColorStateList hd;
    private PorterDuff.Mode he = PorterDuff.Mode.SRC_IN;
    private int[] hf;
    private boolean hg;
    private ColorStateList hh;
    private WeakReference<C0006a> hi = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public boolean hj = true;
    private float hk;
    TextUtils.TruncateAt hl;
    boolean hm;
    int maxWidth;

    /* renamed from: android.support.design.chip.a$a  reason: collision with other inner class name */
    public interface C0006a {
        void aL();
    }

    public final int getOpacity() {
        return -3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0063, code lost:
        r2 = r9.getResourceId(r2, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.design.chip.a a(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10) {
        /*
            android.support.design.chip.a r0 = new android.support.design.chip.a
            r0.<init>(r7)
            android.content.Context r1 = r0.context
            int[] r3 = android.support.design.a.k.Chip
            r7 = 0
            int[] r6 = new int[r7]
            r2 = r8
            r4 = r9
            r5 = r10
            android.content.res.TypedArray r9 = android.support.design.internal.f.a(r1, r2, r3, r4, r5, r6)
            android.content.Context r10 = r0.context
            int r1 = android.support.design.a.k.Chip_chipBackgroundColor
            android.content.res.ColorStateList r10 = android.support.design.d.a.b(r10, r9, r1)
            r0.b((android.content.res.ColorStateList) r10)
            int r10 = android.support.design.a.k.Chip_chipMinHeight
            r1 = 0
            float r10 = r9.getDimension(r10, r1)
            r0.setChipMinHeight(r10)
            int r10 = android.support.design.a.k.Chip_chipCornerRadius
            float r10 = r9.getDimension(r10, r1)
            r0.setChipCornerRadius(r10)
            android.content.Context r10 = r0.context
            int r2 = android.support.design.a.k.Chip_chipStrokeColor
            android.content.res.ColorStateList r10 = android.support.design.d.a.b(r10, r9, r2)
            r0.c((android.content.res.ColorStateList) r10)
            int r10 = android.support.design.a.k.Chip_chipStrokeWidth
            float r10 = r9.getDimension(r10, r1)
            r0.setChipStrokeWidth(r10)
            android.content.Context r10 = r0.context
            int r2 = android.support.design.a.k.Chip_rippleColor
            android.content.res.ColorStateList r10 = android.support.design.d.a.b(r10, r9, r2)
            r0.d((android.content.res.ColorStateList) r10)
            int r10 = android.support.design.a.k.Chip_android_text
            java.lang.CharSequence r10 = r9.getText(r10)
            r0.setText(r10)
            android.content.Context r10 = r0.context
            int r2 = android.support.design.a.k.Chip_android_textAppearance
            boolean r3 = r9.hasValue(r2)
            if (r3 == 0) goto L_0x006f
            int r2 = r9.getResourceId(r2, r7)
            if (r2 == 0) goto L_0x006f
            android.support.design.d.b r3 = new android.support.design.d.b
            r3.<init>(r10, r2)
            goto L_0x0070
        L_0x006f:
            r3 = 0
        L_0x0070:
            r0.b((android.support.design.d.b) r3)
            int r10 = android.support.design.a.k.Chip_android_ellipsize
            int r10 = r9.getInt(r10, r7)
            switch(r10) {
                case 1: goto L_0x0087;
                case 2: goto L_0x0082;
                case 3: goto L_0x007d;
                default: goto L_0x007c;
            }
        L_0x007c:
            goto L_0x008b
        L_0x007d:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.END
            r0.hl = r10
            goto L_0x008b
        L_0x0082:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.MIDDLE
            r0.hl = r10
            goto L_0x008b
        L_0x0087:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.START
            r0.hl = r10
        L_0x008b:
            int r10 = android.support.design.a.k.Chip_chipIconVisible
            boolean r10 = r9.getBoolean(r10, r7)
            r0.setChipIconVisible(r10)
            if (r8 == 0) goto L_0x00b3
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r2 = "chipIconEnabled"
            java.lang.String r10 = r8.getAttributeValue(r10, r2)
            if (r10 == 0) goto L_0x00b3
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r2 = "chipIconVisible"
            java.lang.String r10 = r8.getAttributeValue(r10, r2)
            if (r10 != 0) goto L_0x00b3
            int r10 = android.support.design.a.k.Chip_chipIconEnabled
            boolean r10 = r9.getBoolean(r10, r7)
            r0.setChipIconVisible(r10)
        L_0x00b3:
            android.content.Context r10 = r0.context
            int r2 = android.support.design.a.k.Chip_chipIcon
            android.graphics.drawable.Drawable r10 = android.support.design.d.a.c(r10, r9, r2)
            r0.f((android.graphics.drawable.Drawable) r10)
            android.content.Context r10 = r0.context
            int r2 = android.support.design.a.k.Chip_chipIconTint
            android.content.res.ColorStateList r10 = android.support.design.d.a.b(r10, r9, r2)
            r0.e((android.content.res.ColorStateList) r10)
            int r10 = android.support.design.a.k.Chip_chipIconSize
            float r10 = r9.getDimension(r10, r1)
            r0.setChipIconSize(r10)
            int r10 = android.support.design.a.k.Chip_closeIconVisible
            boolean r10 = r9.getBoolean(r10, r7)
            r0.setCloseIconVisible(r10)
            if (r8 == 0) goto L_0x00fa
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r2 = "closeIconEnabled"
            java.lang.String r10 = r8.getAttributeValue(r10, r2)
            if (r10 == 0) goto L_0x00fa
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r2 = "closeIconVisible"
            java.lang.String r10 = r8.getAttributeValue(r10, r2)
            if (r10 != 0) goto L_0x00fa
            int r10 = android.support.design.a.k.Chip_closeIconEnabled
            boolean r10 = r9.getBoolean(r10, r7)
            r0.setCloseIconVisible(r10)
        L_0x00fa:
            android.content.Context r10 = r0.context
            int r2 = android.support.design.a.k.Chip_closeIcon
            android.graphics.drawable.Drawable r10 = android.support.design.d.a.c(r10, r9, r2)
            r0.g(r10)
            android.content.Context r10 = r0.context
            int r2 = android.support.design.a.k.Chip_closeIconTint
            android.content.res.ColorStateList r10 = android.support.design.d.a.b(r10, r9, r2)
            r0.f((android.content.res.ColorStateList) r10)
            int r10 = android.support.design.a.k.Chip_closeIconSize
            float r10 = r9.getDimension(r10, r1)
            r0.setCloseIconSize(r10)
            int r10 = android.support.design.a.k.Chip_android_checkable
            boolean r10 = r9.getBoolean(r10, r7)
            r0.setCheckable(r10)
            int r10 = android.support.design.a.k.Chip_checkedIconVisible
            boolean r10 = r9.getBoolean(r10, r7)
            r0.setCheckedIconVisible(r10)
            if (r8 == 0) goto L_0x014a
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r2 = "checkedIconEnabled"
            java.lang.String r10 = r8.getAttributeValue(r10, r2)
            if (r10 == 0) goto L_0x014a
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r2 = "checkedIconVisible"
            java.lang.String r8 = r8.getAttributeValue(r10, r2)
            if (r8 != 0) goto L_0x014a
            int r8 = android.support.design.a.k.Chip_checkedIconEnabled
            boolean r7 = r9.getBoolean(r8, r7)
            r0.setCheckedIconVisible(r7)
        L_0x014a:
            android.content.Context r7 = r0.context
            int r8 = android.support.design.a.k.Chip_checkedIcon
            android.graphics.drawable.Drawable r7 = android.support.design.d.a.c(r7, r9, r8)
            r0.h(r7)
            android.content.Context r7 = r0.context
            int r8 = android.support.design.a.k.Chip_showMotionSpec
            android.support.design.a.h.a(r7, r9, r8)
            android.content.Context r7 = r0.context
            int r8 = android.support.design.a.k.Chip_hideMotionSpec
            android.support.design.a.h.a(r7, r9, r8)
            int r7 = android.support.design.a.k.Chip_chipStartPadding
            float r7 = r9.getDimension(r7, r1)
            r0.setChipStartPadding(r7)
            int r7 = android.support.design.a.k.Chip_iconStartPadding
            float r7 = r9.getDimension(r7, r1)
            r0.setIconStartPadding(r7)
            int r7 = android.support.design.a.k.Chip_iconEndPadding
            float r7 = r9.getDimension(r7, r1)
            r0.setIconEndPadding(r7)
            int r7 = android.support.design.a.k.Chip_textStartPadding
            float r7 = r9.getDimension(r7, r1)
            r0.setTextStartPadding(r7)
            int r7 = android.support.design.a.k.Chip_textEndPadding
            float r7 = r9.getDimension(r7, r1)
            r0.setTextEndPadding(r7)
            int r7 = android.support.design.a.k.Chip_closeIconStartPadding
            float r7 = r9.getDimension(r7, r1)
            r0.setCloseIconStartPadding(r7)
            int r7 = android.support.design.a.k.Chip_closeIconEndPadding
            float r7 = r9.getDimension(r7, r1)
            r0.setCloseIconEndPadding(r7)
            int r7 = android.support.design.a.k.Chip_chipEndPadding
            float r7 = r9.getDimension(r7, r1)
            r0.setChipEndPadding(r7)
            int r7 = android.support.design.a.k.Chip_android_maxWidth
            r8 = 2147483647(0x7fffffff, float:NaN)
            int r7 = r9.getDimensionPixelSize(r7, r8)
            r0.maxWidth = r7
            r9.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.chip.a.a(android.content.Context, android.util.AttributeSet, int, int):android.support.design.chip.a");
    }

    private a(Context context2) {
        this.context = context2;
        this.gt = "";
        this.gR.density = context2.getResources().getDisplayMetrics().density;
        setState(gn);
        b(gn);
        this.hm = true;
    }

    public final void i(boolean z) {
        if (this.hg != z) {
            this.hg = z;
            aZ();
            onStateChange(getState());
        }
    }

    public final void a(C0006a aVar) {
        this.hi = new WeakReference<>(aVar);
    }

    /* access modifiers changed from: protected */
    public final void aS() {
        C0006a aVar = (C0006a) this.hi.get();
        if (aVar != null) {
            aVar.aL();
        }
    }

    public final int getIntrinsicWidth() {
        return Math.min(Math.round(this.gJ + aW() + this.gM + getTextWidth() + this.gN + aX() + this.gQ), this.maxWidth);
    }

    public final int getIntrinsicHeight() {
        return (int) this.gp;
    }

    private boolean aT() {
        return this.gw && this.gz != null;
    }

    private boolean aU() {
        return this.gH && this.gI != null && this.gZ;
    }

    /* access modifiers changed from: package-private */
    public final boolean aV() {
        return this.gC && this.gD != null;
    }

    /* access modifiers changed from: package-private */
    public final float aW() {
        if (aT() || aU()) {
            return this.gK + this.gB + this.gL;
        }
        return 0.0f;
    }

    private float getTextWidth() {
        float f;
        if (!this.hj) {
            return this.hk;
        }
        CharSequence charSequence = this.gu;
        if (charSequence == null) {
            f = 0.0f;
        } else {
            f = this.gR.measureText(charSequence, 0, charSequence.length());
        }
        this.hk = f;
        this.hj = false;
        return this.hk;
    }

    private float aX() {
        if (aV()) {
            return this.gO + this.gF + this.gP;
        }
        return 0.0f;
    }

    public final void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            if (this.alpha < 255) {
                float f = (float) bounds.left;
                float f2 = (float) bounds.top;
                float f3 = (float) bounds.right;
                float f4 = (float) bounds.bottom;
                int i4 = this.alpha;
                if (Build.VERSION.SDK_INT > 21) {
                    i3 = canvas.saveLayerAlpha(f, f2, f3, f4, i4);
                } else {
                    i3 = canvas.saveLayerAlpha(f, f2, f3, f4, i4, 31);
                }
                i = i3;
            } else {
                i = 0;
            }
            this.gS.setColor(this.gV);
            this.gS.setStyle(Paint.Style.FILL);
            this.gS.setColorFilter(aY());
            this.fP.set(bounds);
            canvas2.drawRoundRect(this.fP, this.gq, this.gq, this.gS);
            if (this.gs > 0.0f) {
                this.gS.setColor(this.gW);
                this.gS.setStyle(Paint.Style.STROKE);
                this.gS.setColorFilter(aY());
                this.fP.set(((float) bounds.left) + (this.gs / 2.0f), ((float) bounds.top) + (this.gs / 2.0f), ((float) bounds.right) - (this.gs / 2.0f), ((float) bounds.bottom) - (this.gs / 2.0f));
                float f5 = this.gq - (this.gs / 2.0f);
                canvas2.drawRoundRect(this.fP, f5, f5, this.gS);
            }
            this.gS.setColor(this.gX);
            this.gS.setStyle(Paint.Style.FILL);
            this.fP.set(bounds);
            canvas2.drawRoundRect(this.fP, this.gq, this.gq, this.gS);
            if (aT()) {
                a(bounds, this.fP);
                float f6 = this.fP.left;
                float f7 = this.fP.top;
                canvas2.translate(f6, f7);
                this.gz.setBounds(0, 0, (int) this.fP.width(), (int) this.fP.height());
                this.gz.draw(canvas2);
                canvas2.translate(-f6, -f7);
            }
            if (aU()) {
                a(bounds, this.fP);
                float f8 = this.fP.left;
                float f9 = this.fP.top;
                canvas2.translate(f8, f9);
                this.gI.setBounds(0, 0, (int) this.fP.width(), (int) this.fP.height());
                this.gI.draw(canvas2);
                canvas2.translate(-f8, -f9);
            }
            if (this.hm && this.gu != null) {
                PointF pointF = this.gU;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.gu != null) {
                    float aW = this.gJ + aW() + this.gM;
                    if (android.support.v4.graphics.drawable.a.u(this) == 0) {
                        pointF.x = ((float) bounds.left) + aW;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - aW;
                        align = Paint.Align.RIGHT;
                    }
                    this.gR.getFontMetrics(this.gT);
                    pointF.y = ((float) bounds.centerY()) - ((this.gT.descent + this.gT.ascent) / 2.0f);
                }
                RectF rectF = this.fP;
                rectF.setEmpty();
                if (this.gu != null) {
                    float aW2 = this.gJ + aW() + this.gM;
                    float aX = this.gQ + aX() + this.gN;
                    if (android.support.v4.graphics.drawable.a.u(this) == 0) {
                        rectF.left = ((float) bounds.left) + aW2;
                        rectF.right = ((float) bounds.right) - aX;
                    } else {
                        rectF.left = ((float) bounds.left) + aX;
                        rectF.right = ((float) bounds.right) - aW2;
                    }
                    rectF.top = (float) bounds.top;
                    rectF.bottom = (float) bounds.bottom;
                }
                if (this.gv != null) {
                    this.gR.drawableState = getState();
                    this.gv.a(this.context, this.gR, this.gl);
                }
                this.gR.setTextAlign(align);
                boolean z = Math.round(getTextWidth()) > Math.round(this.fP.width());
                if (z) {
                    int save = canvas.save();
                    canvas2.clipRect(this.fP);
                    i2 = save;
                } else {
                    i2 = 0;
                }
                CharSequence charSequence = this.gu;
                if (z && this.hl != null) {
                    charSequence = TextUtils.ellipsize(this.gu, this.gR, this.fP.width(), this.hl);
                }
                CharSequence charSequence2 = charSequence;
                canvas.drawText(charSequence2, 0, charSequence2.length(), this.gU.x, this.gU.y, this.gR);
                if (z) {
                    canvas2.restoreToCount(i2);
                }
            }
            if (aV()) {
                RectF rectF2 = this.fP;
                rectF2.setEmpty();
                if (aV()) {
                    float f10 = this.gQ + this.gP;
                    if (android.support.v4.graphics.drawable.a.u(this) == 0) {
                        rectF2.right = ((float) bounds.right) - f10;
                        rectF2.left = rectF2.right - this.gF;
                    } else {
                        rectF2.left = ((float) bounds.left) + f10;
                        rectF2.right = rectF2.left + this.gF;
                    }
                    rectF2.top = bounds.exactCenterY() - (this.gF / 2.0f);
                    rectF2.bottom = rectF2.top + this.gF;
                }
                float f11 = this.fP.left;
                float f12 = this.fP.top;
                canvas2.translate(f11, f12);
                this.gD.setBounds(0, 0, (int) this.fP.width(), (int) this.fP.height());
                this.gD.draw(canvas2);
                canvas2.translate(-f11, -f12);
            }
            if (this.alpha < 255) {
                canvas2.restoreToCount(i);
            }
        }
    }

    private void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (aT() || aU()) {
            float f = this.gJ + this.gK;
            if (android.support.v4.graphics.drawable.a.u(this) == 0) {
                rectF.left = ((float) rect.left) + f;
                rectF.right = rectF.left + this.gB;
            } else {
                rectF.right = ((float) rect.right) - f;
                rectF.left = rectF.right - this.gB;
            }
            rectF.top = rect.exactCenterY() - (this.gB / 2.0f);
            rectF.bottom = rectF.top + this.gB;
        }
    }

    public final boolean isStateful() {
        if (!a(this.go) && !a(this.gr) && (!this.hg || !a(this.hh))) {
            android.support.design.d.b bVar = this.gv;
            if (!((bVar == null || bVar.iX == null || !bVar.iX.isStateful()) ? false : true)) {
                if ((this.gH && this.gI != null && this.gG) || c(this.gz) || c(this.gI) || a(this.hd)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public final boolean b(int[] iArr) {
        if (Arrays.equals(this.hf, iArr)) {
            return false;
        }
        this.hf = iArr;
        if (aV()) {
            return a(getState(), iArr);
        }
        return false;
    }

    private boolean a(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        boolean onStateChange = super.onStateChange(iArr);
        int i = 0;
        int colorForState = this.go != null ? this.go.getColorForState(iArr, this.gV) : 0;
        if (this.gV != colorForState) {
            this.gV = colorForState;
            onStateChange = true;
        }
        int colorForState2 = this.gr != null ? this.gr.getColorForState(iArr, this.gW) : 0;
        if (this.gW != colorForState2) {
            this.gW = colorForState2;
            onStateChange = true;
        }
        int colorForState3 = this.hh != null ? this.hh.getColorForState(iArr, this.gX) : 0;
        if (this.gX != colorForState3) {
            this.gX = colorForState3;
            if (this.hg) {
                onStateChange = true;
            }
        }
        int colorForState4 = (this.gv == null || this.gv.iX == null) ? 0 : this.gv.iX.getColorForState(iArr, this.gY);
        if (this.gY != colorForState4) {
            this.gY = colorForState4;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            int length = state.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (state[i2] == 16842912) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        boolean z3 = z && this.gG;
        if (this.gZ == z3 || this.gI == null) {
            z2 = false;
        } else {
            float aW = aW();
            this.gZ = z3;
            if (aW != aW()) {
                onStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                onStateChange = true;
            }
        }
        if (this.hd != null) {
            i = this.hd.getColorForState(iArr, this.ha);
        }
        if (this.ha != i) {
            this.ha = i;
            this.hc = android.support.design.b.a.a(this, this.hd, this.he);
            onStateChange = true;
        }
        if (c(this.gz)) {
            onStateChange |= this.gz.setState(iArr);
        }
        if (c(this.gI)) {
            onStateChange |= this.gI.setState(iArr);
        }
        if (c(this.gD)) {
            onStateChange |= this.gD.setState(iArr2);
        }
        if (onStateChange) {
            invalidateSelf();
        }
        if (z2) {
            aS();
        }
        return onStateChange;
    }

    private static boolean a(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    static boolean c(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    @TargetApi(23)
    public final boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (aT()) {
            onLayoutDirectionChanged |= this.gz.setLayoutDirection(i);
        }
        if (aU()) {
            onLayoutDirectionChanged |= this.gI.setLayoutDirection(i);
        }
        if (aV()) {
            onLayoutDirectionChanged |= this.gD.setLayoutDirection(i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (aT()) {
            onLevelChange |= this.gz.setLevel(i);
        }
        if (aU()) {
            onLevelChange |= this.gI.setLevel(i);
        }
        if (aV()) {
            onLevelChange |= this.gD.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (aT()) {
            visible |= this.gz.setVisible(z, z2);
        }
        if (aU()) {
            visible |= this.gI.setVisible(z, z2);
        }
        if (aV()) {
            visible |= this.gD.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public final int getAlpha() {
        return this.alpha;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.hb != colorFilter) {
            this.hb = colorFilter;
            invalidateSelf();
        }
    }

    public final ColorFilter getColorFilter() {
        return this.hb;
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.hd != colorStateList) {
            this.hd = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.he != mode) {
            this.he = mode;
            this.hc = android.support.design.b.a.a(this, this.hd, mode);
            invalidateSelf();
        }
    }

    @TargetApi(21)
    public final void getOutline(Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.gq);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.gq);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private static void d(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void e(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            android.support.v4.graphics.drawable.a.b(drawable, android.support.v4.graphics.drawable.a.u(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.gD) {
                if (drawable.isStateful()) {
                    drawable.setState(this.hf);
                }
                android.support.v4.graphics.drawable.a.a(drawable, this.gE);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private ColorFilter aY() {
        return this.hb != null ? this.hb : this.hc;
    }

    private void aZ() {
        this.hh = this.hg ? android.support.design.e.a.i(this.fN) : null;
    }

    public final void b(ColorStateList colorStateList) {
        if (this.go != colorStateList) {
            this.go = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setChipMinHeight(float f) {
        if (this.gp != f) {
            this.gp = f;
            invalidateSelf();
            aS();
        }
    }

    public final void setChipCornerRadius(float f) {
        if (this.gq != f) {
            this.gq = f;
            invalidateSelf();
        }
    }

    public final void c(ColorStateList colorStateList) {
        if (this.gr != colorStateList) {
            this.gr = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setChipStrokeWidth(float f) {
        if (this.gs != f) {
            this.gs = f;
            this.gS.setStrokeWidth(f);
            invalidateSelf();
        }
    }

    public final void d(ColorStateList colorStateList) {
        if (this.fN != colorStateList) {
            this.fN = colorStateList;
            aZ();
            onStateChange(getState());
        }
    }

    public final void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.gt != charSequence) {
            this.gt = charSequence;
            this.gu = android.support.v4.d.a.eS().h(charSequence);
            this.hj = true;
            invalidateSelf();
            aS();
        }
    }

    public final void setTextAppearanceResource(int i) {
        b(new android.support.design.d.b(this.context, i));
    }

    private void b(android.support.design.d.b bVar) {
        if (this.gv != bVar) {
            this.gv = bVar;
            if (bVar != null) {
                bVar.b(this.context, this.gR, this.gl);
                this.hj = true;
            }
            onStateChange(getState());
            aS();
        }
    }

    public final void setChipIconVisible(boolean z) {
        if (this.gw != z) {
            boolean aT = aT();
            this.gw = z;
            boolean aT2 = aT();
            if (aT != aT2) {
                if (aT2) {
                    e(this.gz);
                } else {
                    d(this.gz);
                }
                invalidateSelf();
                aS();
            }
        }
    }

    public final Drawable ba() {
        if (this.gz != null) {
            return android.support.v4.graphics.drawable.a.t(this.gz);
        }
        return null;
    }

    public final void f(Drawable drawable) {
        Drawable ba = ba();
        if (ba != drawable) {
            float aW = aW();
            this.gz = drawable != null ? android.support.v4.graphics.drawable.a.s(drawable).mutate() : null;
            float aW2 = aW();
            d(ba);
            if (aT()) {
                e(this.gz);
            }
            invalidateSelf();
            if (aW != aW2) {
                aS();
            }
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (this.gA != colorStateList) {
            this.gA = colorStateList;
            if (aT()) {
                android.support.v4.graphics.drawable.a.a(this.gz, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setChipIconSize(float f) {
        if (this.gB != f) {
            float aW = aW();
            this.gB = f;
            float aW2 = aW();
            invalidateSelf();
            if (aW != aW2) {
                aS();
            }
        }
    }

    public final void setCloseIconVisible(boolean z) {
        if (this.gC != z) {
            boolean aV = aV();
            this.gC = z;
            boolean aV2 = aV();
            if (aV != aV2) {
                if (aV2) {
                    e(this.gD);
                } else {
                    d(this.gD);
                }
                invalidateSelf();
                aS();
            }
        }
    }

    public final Drawable bb() {
        if (this.gD != null) {
            return android.support.v4.graphics.drawable.a.t(this.gD);
        }
        return null;
    }

    public final void g(Drawable drawable) {
        Drawable bb = bb();
        if (bb != drawable) {
            float aX = aX();
            this.gD = drawable != null ? android.support.v4.graphics.drawable.a.s(drawable).mutate() : null;
            float aX2 = aX();
            d(bb);
            if (aV()) {
                e(this.gD);
            }
            invalidateSelf();
            if (aX != aX2) {
                aS();
            }
        }
    }

    public final void f(ColorStateList colorStateList) {
        if (this.gE != colorStateList) {
            this.gE = colorStateList;
            if (aV()) {
                android.support.v4.graphics.drawable.a.a(this.gD, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setCloseIconSize(float f) {
        if (this.gF != f) {
            this.gF = f;
            invalidateSelf();
            if (aV()) {
                aS();
            }
        }
    }

    public final void setCheckable(boolean z) {
        if (this.gG != z) {
            this.gG = z;
            float aW = aW();
            if (!z && this.gZ) {
                this.gZ = false;
            }
            float aW2 = aW();
            invalidateSelf();
            if (aW != aW2) {
                aS();
            }
        }
    }

    public final void setCheckedIconVisible(boolean z) {
        if (this.gH != z) {
            boolean aU = aU();
            this.gH = z;
            boolean aU2 = aU();
            if (aU != aU2) {
                if (aU2) {
                    e(this.gI);
                } else {
                    d(this.gI);
                }
                invalidateSelf();
                aS();
            }
        }
    }

    public final void h(Drawable drawable) {
        if (this.gI != drawable) {
            float aW = aW();
            this.gI = drawable;
            float aW2 = aW();
            d(this.gI);
            e(this.gI);
            invalidateSelf();
            if (aW != aW2) {
                aS();
            }
        }
    }

    public final void setChipStartPadding(float f) {
        if (this.gJ != f) {
            this.gJ = f;
            invalidateSelf();
            aS();
        }
    }

    public final void setIconStartPadding(float f) {
        if (this.gK != f) {
            float aW = aW();
            this.gK = f;
            float aW2 = aW();
            invalidateSelf();
            if (aW != aW2) {
                aS();
            }
        }
    }

    public final void setIconEndPadding(float f) {
        if (this.gL != f) {
            float aW = aW();
            this.gL = f;
            float aW2 = aW();
            invalidateSelf();
            if (aW != aW2) {
                aS();
            }
        }
    }

    public final void setTextStartPadding(float f) {
        if (this.gM != f) {
            this.gM = f;
            invalidateSelf();
            aS();
        }
    }

    public final void setTextEndPadding(float f) {
        if (this.gN != f) {
            this.gN = f;
            invalidateSelf();
            aS();
        }
    }

    public final void setCloseIconStartPadding(float f) {
        if (this.gO != f) {
            this.gO = f;
            invalidateSelf();
            if (aV()) {
                aS();
            }
        }
    }

    public final void setCloseIconEndPadding(float f) {
        if (this.gP != f) {
            this.gP = f;
            invalidateSelf();
            if (aV()) {
                aS();
            }
        }
    }

    public final void setChipEndPadding(float f) {
        if (this.gQ != f) {
            this.gQ = f;
            invalidateSelf();
            aS();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        return a(iArr, this.hf);
    }
}
