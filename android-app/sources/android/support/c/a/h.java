package android.support.c.a;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.a;
import android.support.v4.graphics.drawable.b;

abstract class h extends Drawable implements b {
    Drawable tG;

    h() {
    }

    public void setColorFilter(int i, PorterDuff.Mode mode) {
        if (this.tG != null) {
            this.tG.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.tG == null) {
            return null;
        }
        Drawable drawable = this.tG;
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.tG != null) {
            return this.tG.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.tG != null) {
            this.tG.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.tG != null) {
            a.a(this.tG, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.tG != null) {
            a.a(this.tG, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.tG != null) {
            this.tG.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.tG != null) {
            this.tG.jumpToCurrentState();
        }
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.tG != null) {
            a.a(this.tG, theme);
        }
    }

    public void clearColorFilter() {
        if (this.tG != null) {
            this.tG.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.tG != null) {
            return this.tG.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.tG != null) {
            return this.tG.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.tG != null) {
            return this.tG.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.tG != null) {
            return this.tG.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.tG != null) {
            return this.tG.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.tG != null) {
            return this.tG.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.tG != null) {
            this.tG.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.tG != null) {
            return this.tG.setState(iArr);
        }
        return super.setState(iArr);
    }
}
