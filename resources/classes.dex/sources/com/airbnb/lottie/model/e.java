    package com.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class e {
    private final List<String> ov;
    @Nullable
    public f ow;

    public e(String... strArr) {
        this.ov = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.ov = new ArrayList(eVar.ov);
        this.ow = eVar.ow;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @CheckResult
    public final e bw(String str) {
        e eVar = new e(this);
        eVar.ov.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final e a(f fVar) {
        e eVar = new e(this);
        eVar.ow = fVar;
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean l(String str, int i) {
        if (i >= this.ov.size()) {
            return false;
        }
        boolean z = i == this.ov.size() - 1;
        String str2 = this.ov.get(i);
        if (!str2.equals("**")) {
            boolean z2 = str2.equals(str) || str2.equals("*");
            if ((z || (i == this.ov.size() - 2 && cM())) && z2) {
                return true;
            }
            return false;
        }
        if (!z && this.ov.get(i + 1).equals(str)) {
            if (i == this.ov.size() - 2 || (i == this.ov.size() - 3 && cM())) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.ov.size() - 1) {
                return false;
            }
            return this.ov.get(i2).equals(str);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean m(String str, int i) {
        if (!str.equals("__container") && i >= this.ov.size() - 1 && !this.ov.get(i).equals("**")) {
            return false;
        }
        return true;
    }

    private boolean cM() {
        return this.ov.get(this.ov.size() - 1).equals("**");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.ov);
        sb.append(",resolved=");
        sb.append(this.ow != null);
        sb.append('}');
        return sb.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean j(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        if (i >= this.ov.size()) {
            return false;
        }
        return this.ov.get(i).equals(str) || this.ov.get(i).equals("**") || this.ov.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final int k(String str, int i) {
        if (str.equals("__container")) {
            return 0;
        }
        if (!this.ov.get(i).equals("**")) {
            return 1;
        }
        if (i != this.ov.size() - 1 && this.ov.get(i + 1).equals(str)) {
            return 2;
        }
        return 0;
    }
}
    
