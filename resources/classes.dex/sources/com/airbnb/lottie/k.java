    package com.airbnb.lottie;

import android.support.v4.util.ArraySet;
import android.support.v4.util.Pair;
import java.util.Comparator;
import java.util.HashMap;

public final class k {
    public k() {
        new ArraySet();
        new HashMap();
        new Comparator<Pair<String, Float>>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                float floatValue = ((Float) ((Pair) obj).second).floatValue();
                float floatValue2 = ((Float) ((Pair) obj2).second).floatValue();
                if (floatValue2 > floatValue) {
                    return 1;
                }
                return floatValue > floatValue2 ? -1 : 0;
            }
        };
    }
}
    
