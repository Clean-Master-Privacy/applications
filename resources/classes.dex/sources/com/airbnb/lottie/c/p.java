    package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.c;
import com.airbnb.lottie.e.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class p {
    static <T> List<a<T>> a(JsonReader jsonReader, c cVar, float f, af<T> afVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            cVar.bu("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 107 && nextName.equals("k")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(o.a(jsonReader, cVar, f, afVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(o.a(jsonReader, cVar, f, afVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(o.a(jsonReader, cVar, f, afVar, false));
            }
        }
        jsonReader.endObject();
        o(arrayList);
        return arrayList;
    }

    public static void o(List<? extends a<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            i2++;
            ((a) list.get(i2)).rf = Float.valueOf(((a) list.get(i2)).lu);
        }
        a aVar = (a) list.get(i);
        if (aVar.rc == null) {
            list.remove(aVar);
        }
    }
}
    
