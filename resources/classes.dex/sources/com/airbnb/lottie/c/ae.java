    package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.c;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.io.IOException;

final class ae {
    static ShapeTrimPath t(JsonReader jsonReader, c cVar) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        b bVar = null;
        b bVar2 = null;
        b bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 109) {
                    if (hashCode != 111) {
                        if (hashCode != 115) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c2 = 3;
                            }
                        } else if (nextName.equals("s")) {
                            c2 = 0;
                        }
                    } else if (nextName.equals("o")) {
                        c2 = 2;
                    }
                } else if (nextName.equals("m")) {
                    c2 = 4;
                }
            } else if (nextName.equals("e")) {
                c2 = 1;
            }
            switch (c2) {
                case 0:
                    bVar = d.a(jsonReader, cVar, false);
                    break;
                case 1:
                    bVar2 = d.a(jsonReader, cVar, false);
                    break;
                case 2:
                    bVar3 = d.a(jsonReader, cVar, false);
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    type = ShapeTrimPath.Type.forId(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3);
    }
}
    
