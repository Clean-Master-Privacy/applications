    package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.airbnb.lottie.e.c;
import java.util.ArrayList;
import java.util.List;

public abstract class a<K, A> {
    final List<C0012a> listeners = new ArrayList();
    @Nullable
    private com.airbnb.lottie.e.a<K> nA;
    public boolean nx = false;
    private final List<? extends com.airbnb.lottie.e.a<K>> ny;
    @Nullable
    protected c<A> nz;
    public float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    public interface C0012a {
        void cD();
    }

    /* access modifiers changed from: package-private */
    public abstract A a(com.airbnb.lottie.e.a<K> aVar, float f);

    a(List<? extends com.airbnb.lottie.e.a<K>> list) {
        this.ny = list;
    }

    public final void b(C0012a aVar) {
        this.listeners.add(aVar);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < cK()) {
            f = cK();
        } else if (f > cL()) {
            f = cL();
        }
        if (f != this.progress) {
            this.progress = f;
            cH();
        }
    }

    public void cH() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).cD();
        }
    }

    private com.airbnb.lottie.e.a<K> cI() {
        if (this.nA != null && this.nA.k(this.progress)) {
            return this.nA;
        }
        com.airbnb.lottie.e.a<K> aVar = (com.airbnb.lottie.e.a) this.ny.get(this.ny.size() - 1);
        if (this.progress < aVar.de()) {
            for (int size = this.ny.size() - 1; size >= 0; size--) {
                aVar = (com.airbnb.lottie.e.a) this.ny.get(size);
                if (aVar.k(this.progress)) {
                    break;
                }
            }
        }
        this.nA = aVar;
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final float cJ() {
        if (this.nx) {
            return 0.0f;
        }
        com.airbnb.lottie.e.a cI = cI();
        if (cI.df()) {
            return 0.0f;
        }
        return (this.progress - cI.de()) / (cI.cL() - cI.de());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float cK() {
        if (this.ny.isEmpty()) {
            return 0.0f;
        }
        return ((com.airbnb.lottie.e.a) this.ny.get(0)).de();
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float cL() {
        if (this.ny.isEmpty()) {
            return 1.0f;
        }
        return ((com.airbnb.lottie.e.a) this.ny.get(this.ny.size() - 1)).cL();
    }

    public A getValue() {
        float f;
        com.airbnb.lottie.e.a cI = cI();
        com.airbnb.lottie.e.a cI2 = cI();
        if (cI2.df()) {
            f = 0.0f;
        } else {
            f = cI2.re.getInterpolation(cJ());
        }
        return a(cI, f);
    }

    public final void a(@Nullable c<A> cVar) {
        this.nz = cVar;
    }
}
    
