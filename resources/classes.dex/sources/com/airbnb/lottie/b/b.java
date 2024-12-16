    package com.airbnb.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.a;
import com.airbnb.lottie.f;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private static final Object nZ = new Object();
    public final Context context;
    private String oa;
    @Nullable
    private a ob;
    private final Map<String, f> oc;

    public b(Drawable.Callback callback, String str, Map<String, f> map) {
        this.oa = str;
        if (!TextUtils.isEmpty(str) && this.oa.charAt(this.oa.length() - 1) != '/') {
            this.oa += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.oc = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.oc = map;
        this.ob = null;
    }

    @Nullable
    public final Bitmap bv(String str) {
        f fVar = this.oc.get(str);
        if (fVar == null) {
            return null;
        }
        Bitmap bitmap = fVar.bitmap;
        if (bitmap != null) {
            return bitmap;
        }
        String str2 = fVar.fileName;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!str2.startsWith("data:") || str2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.oa)) {
                    AssetManager assets = this.context.getAssets();
                    return a(str, BitmapFactory.decodeStream(assets.open(this.oa + str2), (Rect) null, options));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e) {
                Log.w("LOTTIE", "Unable to open asset.", e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(str2.substring(str2.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e2) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e2);
                return null;
            }
        }
    }

    public final void recycleBitmaps() {
        synchronized (nZ) {
            Iterator<Map.Entry<String, f>> it = this.oc.entrySet().iterator();
            while (it.hasNext()) {
                Bitmap bitmap = ((f) it.next().getValue()).bitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                it.remove();
            }
        }
    }

    private Bitmap a(String str, @Nullable Bitmap bitmap) {
        synchronized (nZ) {
            this.oc.get(str).bitmap = bitmap;
        }
        return bitmap;
    }
}
    
