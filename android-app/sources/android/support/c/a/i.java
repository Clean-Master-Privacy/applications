package android.support.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import com.cleanmaster.cloud.upload.MediaModel;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i extends h {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Matrix mTmpMatrix;
    g tH;
    boolean tI;
    private final float[] tJ;
    private final Rect tK;

    public final /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

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

    public final /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    i() {
        this.tI = true;
        this.tJ = new float[9];
        this.mTmpMatrix = new Matrix();
        this.tK = new Rect();
        this.tH = new g();
    }

    i(g gVar) {
        this.tI = true;
        this.tJ = new float[9];
        this.mTmpMatrix = new Matrix();
        this.tK = new Rect();
        this.tH = gVar;
        this.mTintFilter = updateTintFilter(this.mTintFilter, gVar.mTint, gVar.mTintMode);
    }

    public final Drawable mutate() {
        if (this.tG != null) {
            this.tG.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.tH = new g(this.tH);
            this.mMutated = true;
        }
        return this;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.tG != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.tG.getConstantState());
        }
        this.tH.mChangingConfigurations = getChangingConfigurations();
        return this.tH;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00de, code lost:
        if ((r1 == r6.mCachedBitmap.getWidth() && r3 == r6.mCachedBitmap.getHeight()) == false) goto L_0x00e0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            android.graphics.drawable.Drawable r0 = r10.tG
            if (r0 == 0) goto L_0x000a
            android.graphics.drawable.Drawable r10 = r10.tG
            r10.draw(r11)
            return
        L_0x000a:
            android.graphics.Rect r0 = r10.tK
            r10.copyBounds(r0)
            android.graphics.Rect r0 = r10.tK
            int r0 = r0.width()
            if (r0 <= 0) goto L_0x017a
            android.graphics.Rect r0 = r10.tK
            int r0 = r0.height()
            if (r0 > 0) goto L_0x0021
            goto L_0x017a
        L_0x0021:
            android.graphics.ColorFilter r0 = r10.mColorFilter
            if (r0 != 0) goto L_0x0028
            android.graphics.PorterDuffColorFilter r0 = r10.mTintFilter
            goto L_0x002a
        L_0x0028:
            android.graphics.ColorFilter r0 = r10.mColorFilter
        L_0x002a:
            android.graphics.Matrix r1 = r10.mTmpMatrix
            r11.getMatrix(r1)
            android.graphics.Matrix r1 = r10.mTmpMatrix
            float[] r2 = r10.tJ
            r1.getValues(r2)
            float[] r1 = r10.tJ
            r2 = 0
            r1 = r1[r2]
            float r1 = java.lang.Math.abs(r1)
            float[] r3 = r10.tJ
            r4 = 4
            r3 = r3[r4]
            float r3 = java.lang.Math.abs(r3)
            float[] r4 = r10.tJ
            r5 = 1
            r4 = r4[r5]
            float r4 = java.lang.Math.abs(r4)
            float[] r6 = r10.tJ
            r7 = 3
            r6 = r6[r7]
            float r6 = java.lang.Math.abs(r6)
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r4 != 0) goto L_0x0065
            int r4 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0067
        L_0x0065:
            r1 = r8
            r3 = r1
        L_0x0067:
            android.graphics.Rect r4 = r10.tK
            int r4 = r4.width()
            float r4 = (float) r4
            float r4 = r4 * r1
            int r1 = (int) r4
            android.graphics.Rect r4 = r10.tK
            int r4 = r4.height()
            float r4 = (float) r4
            float r4 = r4 * r3
            int r3 = (int) r4
            r4 = 2048(0x800, float:2.87E-42)
            int r1 = java.lang.Math.min(r4, r1)
            int r3 = java.lang.Math.min(r4, r3)
            if (r1 <= 0) goto L_0x0179
            if (r3 > 0) goto L_0x0089
            goto L_0x0179
        L_0x0089:
            int r4 = r11.save()
            android.graphics.Rect r6 = r10.tK
            int r6 = r6.left
            float r6 = (float) r6
            android.graphics.Rect r9 = r10.tK
            int r9 = r9.top
            float r9 = (float) r9
            r11.translate(r6, r9)
            int r6 = android.os.Build.VERSION.SDK_INT
            r9 = 17
            if (r6 < r9) goto L_0x00ae
            boolean r6 = r10.isAutoMirrored()
            if (r6 == 0) goto L_0x00ae
            int r6 = android.support.v4.graphics.drawable.a.u(r10)
            if (r6 != r5) goto L_0x00ae
            r6 = r5
            goto L_0x00af
        L_0x00ae:
            r6 = r2
        L_0x00af:
            if (r6 == 0) goto L_0x00c0
            android.graphics.Rect r6 = r10.tK
            int r6 = r6.width()
            float r6 = (float) r6
            r11.translate(r6, r7)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11.scale(r6, r8)
        L_0x00c0:
            android.graphics.Rect r6 = r10.tK
            r6.offsetTo(r2, r2)
            android.support.c.a.i$g r6 = r10.tH
            android.graphics.Bitmap r7 = r6.mCachedBitmap
            if (r7 == 0) goto L_0x00e0
            android.graphics.Bitmap r7 = r6.mCachedBitmap
            int r7 = r7.getWidth()
            if (r1 != r7) goto L_0x00dd
            android.graphics.Bitmap r7 = r6.mCachedBitmap
            int r7 = r7.getHeight()
            if (r3 != r7) goto L_0x00dd
            r7 = r5
            goto L_0x00de
        L_0x00dd:
            r7 = r2
        L_0x00de:
            if (r7 != 0) goto L_0x00ea
        L_0x00e0:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r1, r3, r7)
            r6.mCachedBitmap = r7
            r6.mCacheDirty = r5
        L_0x00ea:
            boolean r6 = r10.tI
            if (r6 != 0) goto L_0x00f4
            android.support.c.a.i$g r6 = r10.tH
            r6.updateCachedBitmap(r1, r3)
            goto L_0x0138
        L_0x00f4:
            android.support.c.a.i$g r6 = r10.tH
            boolean r7 = r6.mCacheDirty
            if (r7 != 0) goto L_0x0118
            android.content.res.ColorStateList r7 = r6.mCachedTint
            android.content.res.ColorStateList r8 = r6.mTint
            if (r7 != r8) goto L_0x0118
            android.graphics.PorterDuff$Mode r7 = r6.mCachedTintMode
            android.graphics.PorterDuff$Mode r8 = r6.mTintMode
            if (r7 != r8) goto L_0x0118
            boolean r7 = r6.mCachedAutoMirrored
            boolean r8 = r6.mAutoMirrored
            if (r7 != r8) goto L_0x0118
            int r7 = r6.mCachedRootAlpha
            android.support.c.a.i$f r6 = r6.ue
            int r6 = r6.getRootAlpha()
            if (r7 != r6) goto L_0x0118
            r6 = r5
            goto L_0x0119
        L_0x0118:
            r6 = r2
        L_0x0119:
            if (r6 != 0) goto L_0x0138
            android.support.c.a.i$g r6 = r10.tH
            r6.updateCachedBitmap(r1, r3)
            android.support.c.a.i$g r1 = r10.tH
            android.content.res.ColorStateList r3 = r1.mTint
            r1.mCachedTint = r3
            android.graphics.PorterDuff$Mode r3 = r1.mTintMode
            r1.mCachedTintMode = r3
            android.support.c.a.i$f r3 = r1.ue
            int r3 = r3.getRootAlpha()
            r1.mCachedRootAlpha = r3
            boolean r3 = r1.mAutoMirrored
            r1.mCachedAutoMirrored = r3
            r1.mCacheDirty = r2
        L_0x0138:
            android.support.c.a.i$g r1 = r10.tH
            android.graphics.Rect r10 = r10.tK
            android.support.c.a.i$f r3 = r1.ue
            int r3 = r3.getRootAlpha()
            r6 = 255(0xff, float:3.57E-43)
            if (r3 >= r6) goto L_0x0147
            r2 = r5
        L_0x0147:
            r3 = 0
            if (r2 != 0) goto L_0x014e
            if (r0 != 0) goto L_0x014e
            r0 = r3
            goto L_0x0170
        L_0x014e:
            android.graphics.Paint r2 = r1.mTempPaint
            if (r2 != 0) goto L_0x015e
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r1.mTempPaint = r2
            android.graphics.Paint r2 = r1.mTempPaint
            r2.setFilterBitmap(r5)
        L_0x015e:
            android.graphics.Paint r2 = r1.mTempPaint
            android.support.c.a.i$f r5 = r1.ue
            int r5 = r5.getRootAlpha()
            r2.setAlpha(r5)
            android.graphics.Paint r2 = r1.mTempPaint
            r2.setColorFilter(r0)
            android.graphics.Paint r0 = r1.mTempPaint
        L_0x0170:
            android.graphics.Bitmap r1 = r1.mCachedBitmap
            r11.drawBitmap(r1, r3, r10, r0)
            r11.restoreToCount(r4)
            return
        L_0x0179:
            return
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.i.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        if (this.tG != null) {
            return android.support.v4.graphics.drawable.a.p(this.tG);
        }
        return this.tH.ue.getRootAlpha();
    }

    public final void setAlpha(int i) {
        if (this.tG != null) {
            this.tG.setAlpha(i);
        } else if (this.tH.ue.getRootAlpha() != i) {
            this.tH.ue.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.tG != null) {
            this.tG.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public final PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, colorStateList);
            return;
        }
        g gVar = this.tH;
        if (gVar.mTint != colorStateList) {
            gVar.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, gVar.mTintMode);
            invalidateSelf();
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, mode);
            return;
        }
        g gVar = this.tH;
        if (gVar.mTintMode != mode) {
            gVar.mTintMode = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, gVar.mTint, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.tG != null) {
            return this.tG.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        if (this.tH == null) {
            return false;
        }
        if (!this.tH.isStateful()) {
            return this.tH.mTint != null && this.tH.mTint.isStateful();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (this.tG != null) {
            return this.tG.setState(iArr);
        }
        boolean z = false;
        g gVar = this.tH;
        if (!(gVar.mTint == null || gVar.mTintMode == null)) {
            this.mTintFilter = updateTintFilter(this.mTintFilter, gVar.mTint, gVar.mTintMode);
            invalidateSelf();
            z = true;
        }
        if (!gVar.isStateful()) {
            return z;
        }
        boolean d2 = gVar.ue.ub.d(iArr);
        gVar.mCacheDirty |= d2;
        if (!d2) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.tG != null) {
            return this.tG.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.tG != null) {
            return this.tG.getIntrinsicWidth();
        }
        return (int) this.tH.ue.mBaseWidth;
    }

    public final int getIntrinsicHeight() {
        if (this.tG != null) {
            return this.tG.getIntrinsicHeight();
        }
        return (int) this.tH.ue.mBaseHeight;
    }

    public final boolean canApplyTheme() {
        if (this.tG == null) {
            return false;
        }
        android.support.v4.graphics.drawable.a.q(this.tG);
        return false;
    }

    public final boolean isAutoMirrored() {
        if (this.tG != null) {
            return android.support.v4.graphics.drawable.a.o(this.tG);
        }
        return this.tH.mAutoMirrored;
    }

    public final void setAutoMirrored(boolean z) {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, z);
        } else {
            this.tH.mAutoMirrored = z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036 A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.c.a.i a(android.content.res.Resources r4, int r5, android.content.res.Resources.Theme r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x001d
            android.support.c.a.i r0 = new android.support.c.a.i
            r0.<init>()
            android.graphics.drawable.Drawable r4 = android.support.v4.content.a.f.c(r4, r5, r6)
            r0.tG = r4
            android.support.c.a.i$h r4 = new android.support.c.a.i$h
            android.graphics.drawable.Drawable r5 = r0.tG
            android.graphics.drawable.Drawable$ConstantState r5 = r5.getConstantState()
            r4.<init>(r5)
            return r0
        L_0x001d:
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }
        L_0x0025:
            int r1 = r5.next()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }
            r2 = 2
            if (r1 == r2) goto L_0x002f
            r3 = 1
            if (r1 != r3) goto L_0x0025
        L_0x002f:
            if (r1 != r2) goto L_0x0036
            android.support.c.a.i r4 = a(r4, r5, r0, r6)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }
            return r4
        L_0x0036:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }
            throw r4     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x003e }
        L_0x003e:
            r4 = move-exception
            java.lang.String r5 = "VectorDrawableCompat"
            java.lang.String r6 = "parser error"
            android.util.Log.e(r5, r6, r4)
            goto L_0x0051
        L_0x0048:
            r4 = move-exception
            java.lang.String r5 = "VectorDrawableCompat"
            java.lang.String r6 = "parser error"
            android.util.Log.e(r5, r6, r4)
        L_0x0051:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.i.a(android.content.res.Resources, int, android.content.res.Resources$Theme):android.support.c.a.i");
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    static int b(int i, float f2) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f2)) << 24);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.tG != null) {
            this.tG.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.tG != null) {
            android.support.v4.graphics.drawable.a.a(this.tG, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.tH;
        gVar.ue = new f();
        TypedArray obtainAttributes = android.support.v4.content.a.g.obtainAttributes(resources, theme, attributeSet, a.tg);
        g gVar2 = this.tH;
        f fVar = gVar2.ue;
        int a2 = android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (a2 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (a2 == 5) {
            mode = PorterDuff.Mode.SRC_IN;
        } else if (a2 != 9) {
            switch (a2) {
                case 14:
                    mode = PorterDuff.Mode.MULTIPLY;
                    break;
                case 15:
                    mode = PorterDuff.Mode.SCREEN;
                    break;
                case 16:
                    mode = PorterDuff.Mode.ADD;
                    break;
            }
        } else {
            mode = PorterDuff.Mode.SRC_ATOP;
        }
        gVar2.mTintMode = mode;
        ColorStateList colorStateList = obtainAttributes.getColorStateList(1);
        if (colorStateList != null) {
            gVar2.mTint = colorStateList;
        }
        gVar2.mAutoMirrored = android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "autoMirrored", 5, gVar2.mAutoMirrored);
        fVar.mViewportWidth = android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "viewportWidth", 7, fVar.mViewportWidth);
        fVar.mViewportHeight = android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "viewportHeight", 8, fVar.mViewportHeight);
        if (fVar.mViewportWidth <= 0.0f) {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.mViewportHeight > 0.0f) {
            fVar.mBaseWidth = obtainAttributes.getDimension(3, fVar.mBaseWidth);
            fVar.mBaseHeight = obtainAttributes.getDimension(2, fVar.mBaseHeight);
            if (fVar.mBaseWidth <= 0.0f) {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.mBaseHeight > 0.0f) {
                fVar.setAlpha(android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = obtainAttributes.getString(0);
                if (string != null) {
                    fVar.mRootName = string;
                    fVar.ud.put(string, fVar);
                }
                obtainAttributes.recycle();
                gVar.mChangingConfigurations = getChangingConfigurations();
                gVar.mCacheDirty = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.mTintFilter = updateTintFilter(this.mTintFilter, gVar.mTint, gVar.mTintMode);
            } else {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Resources resources2 = resources;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AttributeSet attributeSet2 = attributeSet;
        Resources.Theme theme2 = theme;
        g gVar = this.tH;
        f fVar = gVar.ue;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.ub);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if (MediaModel.MEDIA_PATH.equals(name)) {
                    b bVar = new b();
                    TypedArray obtainAttributes = android.support.v4.content.a.g.obtainAttributes(resources2, theme2, attributeSet2, a.ti);
                    bVar.a(obtainAttributes, xmlPullParser2, theme2);
                    obtainAttributes.recycle();
                    cVar.mChildren.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.ud.put(bVar.getPathName(), bVar);
                    }
                    gVar.mChangingConfigurations = bVar.mChangingConfigurations | gVar.mChangingConfigurations;
                    z = false;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    if (android.support.v4.content.a.g.a(xmlPullParser2, "pathData")) {
                        TypedArray obtainAttributes2 = android.support.v4.content.a.g.obtainAttributes(resources2, theme2, attributeSet2, a.tj);
                        aVar.updateStateFromTypedArray(obtainAttributes2);
                        obtainAttributes2.recycle();
                    }
                    cVar.mChildren.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.ud.put(aVar.getPathName(), aVar);
                    }
                    gVar.mChangingConfigurations = aVar.mChangingConfigurations | gVar.mChangingConfigurations;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    TypedArray obtainAttributes3 = android.support.v4.content.a.g.obtainAttributes(resources2, theme2, attributeSet2, a.th);
                    cVar2.mThemeAttrs = null;
                    cVar2.tO = android.support.v4.content.a.g.a(obtainAttributes3, xmlPullParser2, "rotation", 5, cVar2.tO);
                    cVar2.mPivotX = obtainAttributes3.getFloat(1, cVar2.mPivotX);
                    cVar2.mPivotY = obtainAttributes3.getFloat(2, cVar2.mPivotY);
                    cVar2.tP = android.support.v4.content.a.g.a(obtainAttributes3, xmlPullParser2, "scaleX", 3, cVar2.tP);
                    cVar2.tQ = android.support.v4.content.a.g.a(obtainAttributes3, xmlPullParser2, "scaleY", 4, cVar2.tQ);
                    cVar2.tR = android.support.v4.content.a.g.a(obtainAttributes3, xmlPullParser2, "translateX", 6, cVar2.tR);
                    cVar2.tS = android.support.v4.content.a.g.a(obtainAttributes3, xmlPullParser2, "translateY", 7, cVar2.tS);
                    String string = obtainAttributes3.getString(0);
                    if (string != null) {
                        cVar2.tU = string;
                    }
                    cVar2.cS();
                    obtainAttributes3.recycle();
                    cVar.mChildren.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.ud.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.mChangingConfigurations = cVar2.mChangingConfigurations | gVar.mChangingConfigurations;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        if (this.tG != null) {
            this.tG.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.tG != null) {
            return this.tG.getChangingConfigurations();
        }
        return this.tH.getChangingConfigurations() | super.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.tG != null) {
            this.tG.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.tG != null) {
            this.tG.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.tG != null) {
            return this.tG.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.tG != null) {
            this.tG.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    private static class h extends Drawable.ConstantState {
        private final Drawable.ConstantState tB;

        public h(Drawable.ConstantState constantState) {
            this.tB = constantState;
        }

        public final Drawable newDrawable() {
            i iVar = new i();
            iVar.tG = (VectorDrawable) this.tB.newDrawable();
            return iVar;
        }

        public final Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.tG = (VectorDrawable) this.tB.newDrawable(resources);
            return iVar;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.tG = (VectorDrawable) this.tB.newDrawable(resources, theme);
            return iVar;
        }

        public final boolean canApplyTheme() {
            return this.tB.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.tB.getChangingConfigurations();
        }
    }

    private static class g extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        ColorStateList mCachedTint;
        PorterDuff.Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;
        f ue;

        public g(g gVar) {
            this.mTint = null;
            this.mTintMode = i.DEFAULT_TINT_MODE;
            if (gVar != null) {
                this.mChangingConfigurations = gVar.mChangingConfigurations;
                this.ue = new f(gVar.ue);
                if (gVar.ue.tZ != null) {
                    this.ue.tZ = new Paint(gVar.ue.tZ);
                }
                if (gVar.ue.tY != null) {
                    this.ue.tY = new Paint(gVar.ue.tY);
                }
                this.mTint = gVar.mTint;
                this.mTintMode = gVar.mTintMode;
                this.mAutoMirrored = gVar.mAutoMirrored;
            }
        }

        public final void updateCachedBitmap(int i, int i2) {
            this.mCachedBitmap.eraseColor(0);
            this.ue.a(new Canvas(this.mCachedBitmap), i, i2);
        }

        public g() {
            this.mTint = null;
            this.mTintMode = i.DEFAULT_TINT_MODE;
            this.ue = new f();
        }

        public final Drawable newDrawable() {
            return new i(this);
        }

        public final Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final boolean isStateful() {
            f fVar = this.ue;
            if (fVar.uc == null) {
                fVar.uc = Boolean.valueOf(fVar.ub.isStateful());
            }
            return fVar.uc.booleanValue();
        }
    }

    private static class f {
        private static final Matrix IDENTITY_MATRIX = new Matrix();
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        private final Path mPath;
        private int mRootAlpha;
        String mRootName;
        float mViewportHeight;
        float mViewportWidth;
        private final Path tW;
        private final Matrix tX;
        Paint tY;
        Paint tZ;
        private PathMeasure ua;
        final c ub;
        Boolean uc;
        final android.support.v4.e.a<String, Object> ud;

        public f() {
            this.tX = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.uc = null;
            this.ud = new android.support.v4.e.a<>();
            this.ub = new c();
            this.mPath = new Path();
            this.tW = new Path();
        }

        public final void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }

        public final int getRootAlpha() {
            return this.mRootAlpha;
        }

        public final void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public final float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public f(f fVar) {
            this.tX = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.uc = null;
            this.ud = new android.support.v4.e.a<>();
            this.ub = new c(fVar.ub, this.ud);
            this.mPath = new Path(fVar.mPath);
            this.tW = new Path(fVar.tW);
            this.mBaseWidth = fVar.mBaseWidth;
            this.mBaseHeight = fVar.mBaseHeight;
            this.mViewportWidth = fVar.mViewportWidth;
            this.mViewportHeight = fVar.mViewportHeight;
            this.mChangingConfigurations = fVar.mChangingConfigurations;
            this.mRootAlpha = fVar.mRootAlpha;
            this.mRootName = fVar.mRootName;
            if (fVar.mRootName != null) {
                this.ud.put(fVar.mRootName, this);
            }
            this.uc = fVar.uc;
        }

        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r11v1, types: [boolean] */
        /* JADX WARNING: type inference failed for: r11v2 */
        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            f fVar;
            float f;
            f fVar2 = this;
            c cVar2 = cVar;
            Canvas canvas2 = canvas;
            ColorFilter colorFilter2 = colorFilter;
            cVar2.tN.set(matrix);
            cVar2.tN.preConcat(cVar2.tT);
            canvas.save();
            ? r11 = 0;
            int i3 = 0;
            while (i3 < cVar2.mChildren.size()) {
                d dVar = cVar2.mChildren.get(i3);
                if (dVar instanceof c) {
                    a((c) dVar, cVar2.tN, canvas, i, i2, colorFilter);
                } else if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    float f2 = ((float) i) / fVar2.mViewportWidth;
                    float f3 = ((float) i2) / fVar2.mViewportHeight;
                    float min = Math.min(f2, f3);
                    Matrix matrix2 = cVar2.tN;
                    fVar2.tX.set(matrix2);
                    fVar2.tX.postScale(f2, f3);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float f4 = min;
                    float f5 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot((double) fArr[r11], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f5) / max : 0.0f;
                    if (abs != 0.0f) {
                        fVar = this;
                        eVar.toPath(fVar.mPath);
                        Path path = fVar.mPath;
                        fVar.tW.reset();
                        if (eVar.isClipPath()) {
                            fVar.tW.addPath(path, fVar.tX);
                            canvas2.clipPath(fVar.tW);
                        } else {
                            b bVar = (b) eVar;
                            if (!(bVar.mTrimPathStart == 0.0f && bVar.mTrimPathEnd == 1.0f)) {
                                float f6 = (bVar.mTrimPathStart + bVar.mTrimPathOffset) % 1.0f;
                                float f7 = (bVar.mTrimPathEnd + bVar.mTrimPathOffset) % 1.0f;
                                if (fVar.ua == null) {
                                    fVar.ua = new PathMeasure();
                                }
                                fVar.ua.setPath(fVar.mPath, r11);
                                float length = fVar.ua.getLength();
                                float f8 = f6 * length;
                                float f9 = f7 * length;
                                path.reset();
                                if (f8 > f9) {
                                    fVar.ua.getSegment(f8, length, path, true);
                                    f = 0.0f;
                                    fVar.ua.getSegment(0.0f, f9, path, true);
                                } else {
                                    f = 0.0f;
                                    fVar.ua.getSegment(f8, f9, path, true);
                                }
                                path.rLineTo(f, f);
                            }
                            fVar.tW.addPath(path, fVar.tX);
                            if (bVar.tM.ep()) {
                                android.support.v4.content.a.b bVar2 = bVar.tM;
                                if (fVar.tZ == null) {
                                    fVar.tZ = new Paint(1);
                                    fVar.tZ.setStyle(Paint.Style.FILL);
                                }
                                Paint paint = fVar.tZ;
                                if (bVar2.eo()) {
                                    Shader shader = bVar2.By;
                                    shader.setLocalMatrix(fVar.tX);
                                    paint.setShader(shader);
                                    paint.setAlpha(Math.round(bVar.mFillAlpha * 255.0f));
                                } else {
                                    paint.setColor(i.b(bVar2.mColor, bVar.mFillAlpha));
                                }
                                paint.setColorFilter(colorFilter2);
                                fVar.tW.setFillType(bVar.mFillRule == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas2.drawPath(fVar.tW, paint);
                            }
                            if (bVar.tL.ep()) {
                                android.support.v4.content.a.b bVar3 = bVar.tL;
                                if (fVar.tY == null) {
                                    fVar.tY = new Paint(1);
                                    fVar.tY.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint2 = fVar.tY;
                                if (bVar.mStrokeLineJoin != null) {
                                    paint2.setStrokeJoin(bVar.mStrokeLineJoin);
                                }
                                if (bVar.mStrokeLineCap != null) {
                                    paint2.setStrokeCap(bVar.mStrokeLineCap);
                                }
                                paint2.setStrokeMiter(bVar.mStrokeMiterlimit);
                                if (bVar3.eo()) {
                                    Shader shader2 = bVar3.By;
                                    shader2.setLocalMatrix(fVar.tX);
                                    paint2.setShader(shader2);
                                    paint2.setAlpha(Math.round(bVar.mStrokeAlpha * 255.0f));
                                } else {
                                    paint2.setColor(i.b(bVar3.mColor, bVar.mStrokeAlpha));
                                }
                                paint2.setColorFilter(colorFilter2);
                                paint2.setStrokeWidth(bVar.mStrokeWidth * abs * f4);
                                canvas2.drawPath(fVar.tW, paint2);
                            }
                        }
                    } else {
                        fVar = this;
                    }
                    i3++;
                    fVar2 = fVar;
                    r11 = 0;
                }
                int i4 = i;
                int i5 = i2;
                fVar = fVar2;
                i3++;
                fVar2 = fVar;
                r11 = 0;
            }
            canvas.restore();
        }

        public final void a(Canvas canvas, int i, int i2) {
            a(this.ub, IDENTITY_MATRIX, canvas, i, i2, (ColorFilter) null);
        }
    }

    private static abstract class d {
        public boolean d(int[] iArr) {
            return false;
        }

        public boolean isStateful() {
            return false;
        }

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    private static class c extends d {
        int mChangingConfigurations;
        final ArrayList<d> mChildren = new ArrayList<>();
        float mPivotX = 0.0f;
        float mPivotY = 0.0f;
        int[] mThemeAttrs;
        final Matrix tN = new Matrix();
        float tO = 0.0f;
        float tP = 1.0f;
        float tQ = 1.0f;
        float tR = 0.0f;
        float tS = 0.0f;
        final Matrix tT = new Matrix();
        String tU = null;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(c cVar, android.support.v4.e.a<String, Object> aVar) {
            super((byte) 0);
            e eVar;
            this.tO = cVar.tO;
            this.mPivotX = cVar.mPivotX;
            this.mPivotY = cVar.mPivotY;
            this.tP = cVar.tP;
            this.tQ = cVar.tQ;
            this.tR = cVar.tR;
            this.tS = cVar.tS;
            this.mThemeAttrs = cVar.mThemeAttrs;
            this.tU = cVar.tU;
            this.mChangingConfigurations = cVar.mChangingConfigurations;
            if (this.tU != null) {
                aVar.put(this.tU, this);
            }
            this.tT.set(cVar.tT);
            ArrayList<d> arrayList = cVar.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                d dVar = arrayList.get(i);
                if (dVar instanceof c) {
                    this.mChildren.add(new c((c) dVar, aVar));
                } else {
                    if (dVar instanceof b) {
                        eVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        eVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(eVar);
                    if (eVar.mPathName != null) {
                        aVar.put(eVar.mPathName, eVar);
                    }
                }
            }
        }

        public c() {
            super((byte) 0);
        }

        public final String getGroupName() {
            return this.tU;
        }

        public final Matrix getLocalMatrix() {
            return this.tT;
        }

        /* access modifiers changed from: package-private */
        public final void cS() {
            this.tT.reset();
            this.tT.postTranslate(-this.mPivotX, -this.mPivotY);
            this.tT.postScale(this.tP, this.tQ);
            this.tT.postRotate(this.tO, 0.0f, 0.0f);
            this.tT.postTranslate(this.tR + this.mPivotX, this.tS + this.mPivotY);
        }

        public final float getRotation() {
            return this.tO;
        }

        public final void setRotation(float f) {
            if (f != this.tO) {
                this.tO = f;
                cS();
            }
        }

        public final float getPivotX() {
            return this.mPivotX;
        }

        public final void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                cS();
            }
        }

        public final float getPivotY() {
            return this.mPivotY;
        }

        public final void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                cS();
            }
        }

        public final float getScaleX() {
            return this.tP;
        }

        public final void setScaleX(float f) {
            if (f != this.tP) {
                this.tP = f;
                cS();
            }
        }

        public final float getScaleY() {
            return this.tQ;
        }

        public final void setScaleY(float f) {
            if (f != this.tQ) {
                this.tQ = f;
                cS();
            }
        }

        public final float getTranslateX() {
            return this.tR;
        }

        public final void setTranslateX(float f) {
            if (f != this.tR) {
                this.tR = f;
                cS();
            }
        }

        public final float getTranslateY() {
            return this.tS;
        }

        public final void setTranslateY(float f) {
            if (f != this.tS) {
                this.tS = f;
                cS();
            }
        }

        public final boolean isStateful() {
            for (int i = 0; i < this.mChildren.size(); i++) {
                if (this.mChildren.get(i).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.mChildren.size(); i++) {
                z |= this.mChildren.get(i).d(iArr);
            }
            return z;
        }
    }

    private static abstract class e extends d {
        int mChangingConfigurations;
        String mPathName;
        protected b.C0020b[] tV = null;

        public boolean isClipPath() {
            return false;
        }

        public e() {
            super((byte) 0);
        }

        public e(e eVar) {
            super((byte) 0);
            this.mPathName = eVar.mPathName;
            this.mChangingConfigurations = eVar.mChangingConfigurations;
            this.tV = android.support.v4.graphics.b.a(eVar.tV);
        }

        public final void toPath(Path path) {
            path.reset();
            if (this.tV != null) {
                b.C0020b.a(this.tV, path);
            }
        }

        public String getPathName() {
            return this.mPathName;
        }

        public b.C0020b[] getPathData() {
            return this.tV;
        }

        public void setPathData(b.C0020b[] bVarArr) {
            if (!android.support.v4.graphics.b.a(this.tV, bVarArr)) {
                this.tV = android.support.v4.graphics.b.a(bVarArr);
                return;
            }
            b.C0020b[] bVarArr2 = this.tV;
            for (int i = 0; i < bVarArr.length; i++) {
                bVarArr2[i].BM = bVarArr[i].BM;
                for (int i2 = 0; i2 < bVarArr[i].BN.length; i2++) {
                    bVarArr2[i].BN[i2] = bVarArr[i].BN[i2];
                }
            }
        }
    }

    private static class a extends e {
        public final boolean isClipPath() {
            return true;
        }

        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public final void updateStateFromTypedArray(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.tV = android.support.v4.graphics.b.s(string2);
            }
        }
    }

    private static class b extends e {
        float mFillAlpha = 1.0f;
        int mFillRule = 0;
        float mStrokeAlpha = 1.0f;
        Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
        Paint.Join mStrokeLineJoin = Paint.Join.MITER;
        float mStrokeMiterlimit = 4.0f;
        float mStrokeWidth = 0.0f;
        private int[] mThemeAttrs;
        float mTrimPathEnd = 1.0f;
        float mTrimPathOffset = 0.0f;
        float mTrimPathStart = 0.0f;
        android.support.v4.content.a.b tL;
        android.support.v4.content.a.b tM;

        public b() {
        }

        public b(b bVar) {
            super(bVar);
            this.mThemeAttrs = bVar.mThemeAttrs;
            this.tL = bVar.tL;
            this.mStrokeWidth = bVar.mStrokeWidth;
            this.mStrokeAlpha = bVar.mStrokeAlpha;
            this.tM = bVar.tM;
            this.mFillRule = bVar.mFillRule;
            this.mFillAlpha = bVar.mFillAlpha;
            this.mTrimPathStart = bVar.mTrimPathStart;
            this.mTrimPathEnd = bVar.mTrimPathEnd;
            this.mTrimPathOffset = bVar.mTrimPathOffset;
            this.mStrokeLineCap = bVar.mStrokeLineCap;
            this.mStrokeLineJoin = bVar.mStrokeLineJoin;
            this.mStrokeMiterlimit = bVar.mStrokeMiterlimit;
        }

        /* access modifiers changed from: package-private */
        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.mThemeAttrs = null;
            if (android.support.v4.content.a.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.mPathName = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.tV = android.support.v4.graphics.b.s(string2);
                }
                this.tM = android.support.v4.content.a.g.a(typedArray, xmlPullParser, theme, "fillColor", 1);
                this.mFillAlpha = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.mFillAlpha);
                int a2 = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1);
                Paint.Cap cap = this.mStrokeLineCap;
                switch (a2) {
                    case 0:
                        cap = Paint.Cap.BUTT;
                        break;
                    case 1:
                        cap = Paint.Cap.ROUND;
                        break;
                    case 2:
                        cap = Paint.Cap.SQUARE;
                        break;
                }
                this.mStrokeLineCap = cap;
                int a3 = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1);
                Paint.Join join = this.mStrokeLineJoin;
                switch (a3) {
                    case 0:
                        join = Paint.Join.MITER;
                        break;
                    case 1:
                        join = Paint.Join.ROUND;
                        break;
                    case 2:
                        join = Paint.Join.BEVEL;
                        break;
                }
                this.mStrokeLineJoin = join;
                this.mStrokeMiterlimit = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
                this.tL = android.support.v4.content.a.g.a(typedArray, xmlPullParser, theme, "strokeColor", 3);
                this.mStrokeAlpha = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
                this.mStrokeWidth = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
                this.mTrimPathEnd = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
                this.mTrimPathOffset = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
                this.mTrimPathStart = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
                this.mFillRule = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "fillType", 13, this.mFillRule);
            }
        }

        public final boolean isStateful() {
            return this.tM.isStateful() || this.tL.isStateful();
        }

        public final boolean d(int[] iArr) {
            return this.tL.d(iArr) | this.tM.d(iArr);
        }

        /* access modifiers changed from: package-private */
        public final int getStrokeColor() {
            return this.tL.mColor;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeColor(int i) {
            this.tL.mColor = i;
        }

        /* access modifiers changed from: package-private */
        public final float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        /* access modifiers changed from: package-private */
        public final float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        /* access modifiers changed from: package-private */
        public final int getFillColor() {
            return this.tM.mColor;
        }

        /* access modifiers changed from: package-private */
        public final void setFillColor(int i) {
            this.tM.mColor = i;
        }

        /* access modifiers changed from: package-private */
        public final float getFillAlpha() {
            return this.mFillAlpha;
        }

        /* access modifiers changed from: package-private */
        public final void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }
    }
}
