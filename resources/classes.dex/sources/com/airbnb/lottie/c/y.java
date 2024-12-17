    package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.c;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.g;
import java.io.IOException;

final class y {
    static g p(JsonReader jsonReader, c cVar) throws IOException {
        String str = null;
        b bVar = null;
        b bVar2 = null;
        l lVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            c2 = 3;
                        }
                    } else if (nextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (nextName.equals("o")) {
                    c2 = 2;
                }
            } else if (nextName.equals("c")) {
                c2 = 1;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    bVar = d.a(jsonReader, cVar, false);
                    break;
                case 2:
                    bVar2 = d.a(jsonReader, cVar, false);
                    break;
                case 3:
                    lVar = c.d(jsonReader, cVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new g(str, bVar, bVar2, lVar);
    }
}
    
