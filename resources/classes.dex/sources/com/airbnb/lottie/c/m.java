    package com.airbnb.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

public final class m implements af<Integer> {
    public static final m qJ = new m();

    private m() {
    }

    public final /* synthetic */ Object a(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(n.b(jsonReader) * f));
    }
}
    
