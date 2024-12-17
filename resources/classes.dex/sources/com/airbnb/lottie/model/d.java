    package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
import com.airbnb.lottie.model.content.j;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class d {
    private final String fontFamily;
    private final String oq;
    public final List<j> or;
    private final char ot;
    public final double ou;

    public static int a(char c2, String str, String str2) {
        return (((c2 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<j> list, char c2, double d, String str, String str2) {
        this.or = list;
        this.ot = c2;
        this.ou = d;
        this.oq = str;
        this.fontFamily = str2;
    }

    public final int hashCode() {
        return a(this.ot, this.fontFamily, this.oq);
    }
}
    
