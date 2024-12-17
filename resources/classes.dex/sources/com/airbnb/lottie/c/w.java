    package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.appcompat.R;
import com.airbnb.lottie.c;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.content.PolystarShape;
import java.io.IOException;

final class w {
    static PolystarShape n(JsonReader jsonReader, c cVar) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        b bVar = null;
        m<PointF, PointF> mVar = null;
        b bVar2 = null;
        b bVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        b bVar6 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case R.styleable.AppCompatTheme_ratingBarStyleSmall:
                    if (nextName.equals("p")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case R.styleable.AppCompatTheme_spinnerStyle:
                    if (nextName.equals("r")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3369:
                    if (nextName.equals("ir")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 3370:
                    if (nextName.equals("is")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3555:
                    if (nextName.equals("or")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3686:
                    if (nextName.equals("sy")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    bVar = d.a(jsonReader, cVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, cVar);
                    break;
                case 4:
                    bVar2 = d.a(jsonReader, cVar, false);
                    break;
                case 5:
                    bVar4 = d.a(jsonReader, cVar, true);
                    break;
                case 6:
                    bVar6 = d.a(jsonReader, cVar, false);
                    break;
                case 7:
                    bVar3 = d.a(jsonReader, cVar, true);
                    break;
                case 8:
                    bVar5 = d.a(jsonReader, cVar, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }
}
    
