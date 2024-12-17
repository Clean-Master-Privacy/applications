    package com.airbnb.lottie.c;

import android.support.annotation.Nullable;
import android.util.JsonReader;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.a.h;
import java.io.IOException;
import java.util.List;

public final class d {
    public static b a(JsonReader jsonReader, c cVar, boolean z) throws IOException {
        return new b(a(jsonReader, z ? e.dd() : 1.0f, cVar, i.qH));
    }

    static com.airbnb.lottie.model.a.d e(JsonReader jsonReader, c cVar) throws IOException {
        return new com.airbnb.lottie.model.a.d(a(jsonReader, cVar, m.qJ));
    }

    static f f(JsonReader jsonReader, c cVar) throws IOException {
        return new f(a(jsonReader, e.dd(), cVar, v.qN));
    }

    static h g(JsonReader jsonReader, c cVar) throws IOException {
        return new h(a(jsonReader, e.dd(), cVar, aa.qP));
    }

    static a h(JsonReader jsonReader, c cVar) throws IOException {
        return new a(a(jsonReader, cVar, f.qF));
    }

    static com.airbnb.lottie.model.a.c a(JsonReader jsonReader, c cVar, int i) throws IOException {
        return new com.airbnb.lottie.model.a.c(a(jsonReader, cVar, new j(i)));
    }

    @Nullable
    static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, c cVar, af<T> afVar) throws IOException {
        return p.a(jsonReader, cVar, 1.0f, afVar);
    }

    @Nullable
    private static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, float f, c cVar, af<T> afVar) throws IOException {
        return p.a(jsonReader, cVar, f, afVar);
    }
}
    
