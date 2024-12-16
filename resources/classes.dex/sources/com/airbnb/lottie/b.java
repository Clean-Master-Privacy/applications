    package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class b {
    public static boolean DBG = false;
    private static final Set<String> kZ = new HashSet();
    private static int la = 0;

    public static void cp() {
    }

    public static void cq() {
    }

    public static void bt(String str) {
        if (!kZ.contains(str)) {
            Log.w("LOTTIE", str);
            kZ.add(str);
        }
    }

    public static float cr() {
        if (la <= 0) {
            return 0.0f;
        }
        la--;
        return 0.0f;
    }
}
    
