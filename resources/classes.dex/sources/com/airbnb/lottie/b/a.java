    package com.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.model.h;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public final h<String> nU = new h<>();
    public final Map<h<String>, Typeface> nV = new HashMap();
    public final Map<String, Typeface> nW = new HashMap();
    public final AssetManager nX;
    public String nY = ".ttf";

    public a(Drawable.Callback callback) {
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.nX = null;
            return;
        }
        this.nX = ((View) callback).getContext().getAssets();
    }
}
    
