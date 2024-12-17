    package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.e.d;
import java.io.IOException;

public final class z implements af<d> {
    public static final z qO = new z();

    private z() {
    }

    public final /* synthetic */ Object a(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new d((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
    
