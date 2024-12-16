    package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

public final class r implements b, a.C0012a {
    private final List<a.C0012a> listeners = new ArrayList();
    private final String name;
    final ShapeTrimPath.Type nt;
    public final a<?, Float> nu;
    public final a<?, Float> nv;
    public final a<?, Float> nw;

    public final void b(List<b> list, List<b> list2) {
    }

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.name;
        this.nt = shapeTrimPath.nt;
        this.nu = shapeTrimPath.pC.cO();
        this.nv = shapeTrimPath.pD.cO();
        this.nw = shapeTrimPath.pq.cO();
        aVar.a(this.nu);
        aVar.a(this.nv);
        aVar.a(this.nw);
        this.nu.b(this);
        this.nv.b(this);
        this.nw.b(this);
    }

    public final void cD() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).cD();
        }
    }

    public final String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public final void a(a.C0012a aVar) {
        this.listeners.add(aVar);
    }
}
    
