    package com.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class b {
    @ColorInt
    public final int color;
    public final String fontName;
    public final double og;
    private int oh;
    public final int oi;
    private double oj;
    public final double ol;
    public final boolean on;
    @ColorInt
    public final int strokeColor;
    public final int strokeWidth;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, int i5, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.og = d;
        this.oh = i;
        this.oi = i2;
        this.oj = d2;
        this.ol = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.strokeWidth = i5;
        this.on = z;
    }

    public final int hashCode() {
        double hashCode = (double) (((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31);
        double d = this.og;
        Double.isNaN(hashCode);
        int i = (((((int) (hashCode + d)) * 31) + this.oh) * 31) + this.oi;
        long doubleToLongBits = Double.doubleToLongBits(this.oj);
        return (((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
    
