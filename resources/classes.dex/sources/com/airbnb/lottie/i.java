    package com.airbnb.lottie;

import android.support.annotation.Nullable;
import java.util.Arrays;

public final class i<V> {
    @Nullable
    final Throwable exception;
    @Nullable
    public final V value;

    public i(V v) {
        this.value = v;
        this.exception = null;
    }

    public i(Throwable th) {
        this.exception = th;
        this.value = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.value != null && this.value.equals(iVar.value)) {
            return true;
        }
        if (this.exception == null || iVar.exception == null) {
            return false;
        }
        return this.exception.toString().equals(this.exception.toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.value, this.exception});
    }
}
    
