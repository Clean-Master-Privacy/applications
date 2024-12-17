    package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.i;
import com.airbnb.lottie.a.b.j;
import com.airbnb.lottie.e.a;
import java.util.Collections;
import java.util.List;

public final class e implements m<PointF, PointF> {
    private final List<a<PointF>> ny;

    public e() {
        this.ny = Collections.singletonList(new a(new PointF(0.0f, 0.0f)));
    }

    public e(List<a<PointF>> list) {
        this.ny = list;
    }

    public final com.airbnb.lottie.a.b.a<PointF, PointF> cO() {
        if (this.ny.get(0).df()) {
            return new j(this.ny);
        }
        return new i(this.ny);
    }
}
    
