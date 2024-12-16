    package com.airbnb.lottie;

import android.graphics.Rect;
import android.support.annotation.RestrictTo;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class c {
    public Rect bounds;
    public final k lm = new k();
    private final HashSet<String> ln = new HashSet<>();
    public Map<String, List<Layer>> lo;
    public Map<String, f> lp;
    public Map<String, com.airbnb.lottie.model.c> lq;
    public SparseArrayCompat<d> lr;
    public LongSparseArray<Layer> ls;
    public List<Layer> lt;
    public float lu;
    public float lv;
    public float lw;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void bu(String str) {
        Log.w("LOTTIE", str);
        this.ln.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Layer v(long j) {
        return (Layer) this.ls.get(j);
    }

    public final float ct() {
        return (float) ((long) ((cu() / this.lw) * 1000.0f));
    }

    public final float cu() {
        return this.lv - this.lu;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.lt) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
    
