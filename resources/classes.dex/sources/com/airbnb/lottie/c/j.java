    package com.airbnb.lottie.c;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.model.content.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j implements af<c> {
    private int qI;

    public j(int i) {
        this.qI = i;
    }

    private void a(c cVar, List<Float> list) {
        int i;
        c cVar2 = cVar;
        List<Float> list2 = list;
        int i2 = this.qI << 2;
        if (list.size() > i2) {
            int size = (list.size() - i2) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i3 = 0;
            while (i2 < list.size()) {
                if (i2 % 2 == 0) {
                    dArr[i3] = (double) list2.get(i2).floatValue();
                } else {
                    dArr2[i3] = (double) list2.get(i2).floatValue();
                    i3++;
                }
                i2++;
            }
            for (int i4 = 0; i4 < cVar2.oP.length; i4++) {
                int i5 = cVar2.oP[i4];
                double d = (double) cVar2.oO[i4];
                int i6 = 1;
                while (true) {
                    if (i6 >= dArr.length) {
                        i = (int) (dArr2[dArr2.length - 1] * 255.0d);
                        break;
                    }
                    int i7 = i6 - 1;
                    double d2 = dArr[i7];
                    double d3 = dArr[i6];
                    if (dArr[i6] >= d) {
                        Double.isNaN(d);
                        double d4 = dArr2[i7];
                        i = (int) ((d4 + (((d - d2) / (d3 - d2)) * (dArr2[i6] - d4))) * 255.0d);
                        break;
                    }
                    i6++;
                }
                cVar2.oP[i4] = Color.argb(i, Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
    }

    public final /* synthetic */ Object a(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.qI == -1) {
            this.qI = arrayList.size() / 4;
        }
        float[] fArr = new float[this.qI];
        int[] iArr = new int[this.qI];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < (this.qI << 2); i3++) {
            int i4 = i3 / 4;
            double floatValue = (double) ((Float) arrayList.get(i3)).floatValue();
            switch (i3 % 4) {
                case 0:
                    fArr[i4] = (float) floatValue;
                    break;
                case 1:
                    Double.isNaN(floatValue);
                    i = (int) (floatValue * 255.0d);
                    break;
                case 2:
                    Double.isNaN(floatValue);
                    i2 = (int) (floatValue * 255.0d);
                    break;
                case 3:
                    Double.isNaN(floatValue);
                    iArr[i4] = Color.argb(255, i, i2, (int) (floatValue * 255.0d));
                    break;
            }
        }
        c cVar = new c(fArr, iArr);
        a(cVar, (List<Float>) arrayList);
        return cVar;
    }
}
    
