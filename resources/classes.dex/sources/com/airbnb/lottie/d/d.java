    package com.airbnb.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.a.j;
import com.airbnb.lottie.model.a;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.e;
import java.util.List;

public final class d {
    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF pointF = hVar.pu;
        path.moveTo(pointF.x, pointF.y);
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        for (int i = 0; i < hVar.pt.size(); i++) {
            a aVar = hVar.pt.get(i);
            PointF pointF3 = aVar.od;
            PointF pointF4 = aVar.oe;
            PointF pointF5 = aVar.of;
            if (!pointF3.equals(pointF2) || !pointF4.equals(pointF5)) {
                path.cubicTo(pointF3.x, pointF3.y, pointF4.x, pointF4.y, pointF5.x, pointF5.y);
            } else {
                path.lineTo(pointF5.x, pointF5.y);
            }
            pointF2.set(pointF5.x, pointF5.y);
        }
        if (hVar.closed) {
            path.close();
        }
    }

    public static int J(int i) {
        return Math.max(0, Math.min(255, i));
    }

    public static float clamp(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static void a(e eVar, int i, List<e> list, e eVar2, j jVar) {
        if (eVar.l(jVar.getName(), i)) {
            list.add(eVar2.bw(jVar.getName()).a(jVar));
        }
    }

    static int b(float f2, float f3) {
        int i = (int) f2;
        int i2 = (int) f3;
        int i3 = i / i2;
        int i4 = i % i2;
        if (!((i ^ i2) >= 0) && i4 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }
}
    
