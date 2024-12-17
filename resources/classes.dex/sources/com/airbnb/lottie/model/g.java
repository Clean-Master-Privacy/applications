    package com.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import com.airbnb.lottie.c;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class g {
    private static final g ox = new g();
    private final LruCache<String, c> oy = new LruCache<>(10485760);

    public static g cN() {
        return ox;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public final c bx(String str) {
        return (c) this.oy.get(str);
    }

    public final void a(@Nullable String str, @Nullable c cVar) {
        if (str != null) {
            this.oy.put(str, cVar);
        }
    }
}
    
