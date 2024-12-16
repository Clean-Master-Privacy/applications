    package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.e;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.model.f;
import java.util.ArrayList;
import java.util.List;

public final class c implements d, l, a.C0012a, f {
    private final e le;
    private final List<b> mI;
    @Nullable
    private List<l> mJ;
    @Nullable
    private o mK;
    private final Matrix matrix;
    private final RectF mw;
    private final String name;
    private final Path path;

    private static List<b> a(e eVar, com.airbnb.lottie.model.layer.a aVar, List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            b a2 = list.get(i).a(eVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Nullable
    private static l n(List<b> list) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof l) {
                return (l) bVar;
            }
        }
        return null;
    }

    c(e eVar, com.airbnb.lottie.model.layer.a aVar, String str, List<b> list, @Nullable l lVar) {
        this.matrix = new Matrix();
        this.path = new Path();
        this.mw = new RectF();
        this.name = str;
        this.le = eVar;
        this.mI = list;
        if (lVar != null) {
            this.mK = lVar.cQ();
            this.mK.a(aVar);
            this.mK.a((a.C0012a) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    public final void cD() {
        this.le.invalidateSelf();
    }

    public final String getName() {
        return this.name;
    }

    public final void b(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.mI.size());
        arrayList.addAll(list);
        for (int size = this.mI.size() - 1; size >= 0; size--) {
            b bVar = this.mI.get(size);
            bVar.b(arrayList, this.mI.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final List<l> cE() {
        if (this.mJ == null) {
            this.mJ = new ArrayList();
            for (int i = 0; i < this.mI.size(); i++) {
                b bVar = this.mI.get(i);
                if (bVar instanceof l) {
                    this.mJ.add((l) bVar);
                }
            }
        }
        return this.mJ;
    }

    /* access modifiers changed from: package-private */
    public final Matrix cF() {
        if (this.mK != null) {
            return this.mK.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    public final Path getPath() {
        this.matrix.reset();
        if (this.mK != null) {
            this.matrix.set(this.mK.getMatrix());
        }
        this.path.reset();
        for (int size = this.mI.size() - 1; size >= 0; size--) {
            b bVar = this.mI.get(size);
            if (bVar instanceof l) {
                this.path.addPath(((l) bVar).getPath(), this.matrix);
            }
        }
        return this.path;
    }

    public final void a(Canvas canvas, Matrix matrix2, int i) {
        this.matrix.set(matrix2);
        if (this.mK != null) {
            this.matrix.preConcat(this.mK.getMatrix());
            i = (int) ((((((float) this.mK.nR.getValue().intValue()) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
        }
        for (int size = this.mI.size() - 1; size >= 0; size--) {
            b bVar = this.mI.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.matrix, i);
            }
        }
    }

    public final void a(RectF rectF, Matrix matrix2) {
        this.matrix.set(matrix2);
        if (this.mK != null) {
            this.matrix.preConcat(this.mK.getMatrix());
        }
        this.mw.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.mI.size() - 1; size >= 0; size--) {
            b bVar = this.mI.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.mw, this.matrix);
                if (rectF.isEmpty()) {
                    rectF.set(this.mw);
                } else {
                    rectF.set(Math.min(rectF.left, this.mw.left), Math.min(rectF.top, this.mw.top), Math.max(rectF.right, this.mw.right), Math.max(rectF.bottom, this.mw.bottom));
                }
            }
        }
    }

    public final <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (this.mK != null) {
            this.mK.b(t, cVar);
        }
    }

    public c(e eVar, com.airbnb.lottie.model.layer.a aVar, j jVar) {
        this(eVar, aVar, jVar.name, a(eVar, aVar, jVar.pw), n(jVar.pw));
    }

    public final void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.j(this.name, i)) {
            if (!"__container".equals(this.name)) {
                eVar2 = eVar2.bw(this.name);
                if (eVar.l(this.name, i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.m(this.name, i)) {
                int k = i + eVar.k(this.name, i);
                for (int i2 = 0; i2 < this.mI.size(); i2++) {
                    b bVar = this.mI.get(i2);
                    if (bVar instanceof f) {
                        ((f) bVar).a(eVar, k, list, eVar2);
                    }
                }
            }
        }
    }
}
    
