package android.support.design.a;

import android.animation.TimeInterpolator;
import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public final class a {
    public static final TimeInterpolator eO = new LinearInterpolator();
    public static final TimeInterpolator eP = new b();
    public static final TimeInterpolator eQ = new android.support.v4.view.b.a();
    public static final TimeInterpolator eR = new c();
    public static final TimeInterpolator eS = new DecelerateInterpolator();

    public static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int a(int i, int i2, float f) {
        return i + Math.round(f * ((float) (i2 - i)));
    }
}
