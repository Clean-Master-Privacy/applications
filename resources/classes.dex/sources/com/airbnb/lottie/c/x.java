    package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.appcompat.R;
import com.airbnb.lottie.c;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.content.f;
import java.io.IOException;

final class x {
    static f o(JsonReader jsonReader, c cVar) throws IOException {
        String str = null;
        m<PointF, PointF> mVar = null;
        com.airbnb.lottie.model.a.f fVar = null;
        b bVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3519) {
                    switch (hashCode) {
                        case R.styleable.AppCompatTheme_spinnerStyle:
                            if (nextName.equals("r")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case R.styleable.AppCompatTheme_switchStyle:
                            if (nextName.equals("s")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                } else if (nextName.equals("nm")) {
                    c2 = 0;
                }
            } else if (nextName.equals("p")) {
                c2 = 1;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    mVar = a.b(jsonReader, cVar);
                    break;
                case 2:
                    fVar = d.f(jsonReader, cVar);
                    break;
                case 3:
                    bVar = d.a(jsonReader, cVar, true);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new f(str, mVar, fVar, bVar);
    }
}
    
