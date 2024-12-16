    package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.e;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.k;
import java.util.List;

public final class p implements l, a.C0012a {
    private final e le;
    @Nullable
    private r mH;
    private boolean mO;
    private final String name;
    private final a<?, Path> ns;
    private final Path path = new Path();

    public p(e eVar, com.airbnb.lottie.model.layer.a aVar, k kVar) {
        this.name = kVar.name;
        this.le = eVar;
        this.ns = kVar.px.cO();
        aVar.a(this.ns);
        this.ns.b(this);
    }

    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.nt == ShapeTrimPath.Type.Simultaneously) {
                    this.mH = rVar;
                    this.mH.a(this);
                }
            }
        }
    }

    public final Path getPath() {
        if (this.mO) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.ns.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.d.e.a(this.path, this.mH);
        this.mO = true;
        return this.path;
    }

    public final String getName() {
        return this.name;
    }

    public final void cD() {
        this.mO = false;
        this.le.invalidateSelf();
    }
}
    
