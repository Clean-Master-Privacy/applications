    package com.airbnb.lottie.d;

public final class b {
    private static float i(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow((double) f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float j(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((double) ((f2 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static int a(float f2, int i, int i2) {
        float f3 = ((float) (i >>> 24)) / 255.0f;
        float j = j(((float) ((i >> 16) & 255)) / 255.0f);
        float j2 = j(((float) ((i >> 8) & 255)) / 255.0f);
        float j3 = j(((float) (i & 255)) / 255.0f);
        float j4 = j(((float) ((i2 >> 16) & 255)) / 255.0f);
        float j5 = j(((float) ((i2 >> 8) & 255)) / 255.0f);
        float j6 = j3 + (f2 * (j(((float) (i2 & 255)) / 255.0f) - j3));
        return (Math.round(i(j + ((j4 - j) * f2)) * 255.0f) << 16) | (Math.round((f3 + (((((float) (i2 >>> 24)) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(i(j2 + ((j5 - j2) * f2)) * 255.0f) << 8) | Math.round(i(j6) * 255.0f);
    }
}
    
