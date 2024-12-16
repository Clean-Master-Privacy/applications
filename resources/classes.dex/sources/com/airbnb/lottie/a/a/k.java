    package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public final class k implements i, l {
    private final List<l> mJ = new ArrayList();
    private final Path na = new Path();
    private final String name;
    private final Path nb = new Path();
    private final MergePaths nc;
    private final Path path = new Path();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.name = mergePaths.name;
            this.nc = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ListIterator<com.airbnb.lottie.a.a.b> r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r3.previous()
            if (r0 != r2) goto L_0x0000
        L_0x000c:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r3.previous()
            com.airbnb.lottie.a.a.b r0 = (com.airbnb.lottie.a.a.b) r0
            boolean r1 = r0 instanceof com.airbnb.lottie.a.a.l
            if (r1 == 0) goto L_0x000c
            java.util.List<com.airbnb.lottie.a.a.l> r1 = r2.mJ
            com.airbnb.lottie.a.a.l r0 = (com.airbnb.lottie.a.a.l) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000c
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.k.a(java.util.ListIterator):void");
    }

    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < this.mJ.size(); i++) {
            this.mJ.get(i).b(list, list2);
        }
    }

    public final Path getPath() {
        this.path.reset();
        switch (this.nc.pf) {
            case Merge:
                for (int i = 0; i < this.mJ.size(); i++) {
                    this.path.addPath(this.mJ.get(i).getPath());
                }
                break;
            case Add:
                a(Path.Op.UNION);
                break;
            case Subtract:
                a(Path.Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                a(Path.Op.INTERSECT);
                break;
            case ExcludeIntersections:
                a(Path.Op.XOR);
                break;
        }
        return this.path;
    }

    public final String getName() {
        return this.name;
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.nb.reset();
        this.na.reset();
        for (int size = this.mJ.size() - 1; size > 0; size--) {
            l lVar = this.mJ.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                List<l> cE = cVar.cE();
                for (int size2 = cE.size() - 1; size2 >= 0; size2--) {
                    Path path2 = cE.get(size2).getPath();
                    path2.transform(cVar.cF());
                    this.nb.addPath(path2);
                }
            } else {
                this.nb.addPath(lVar.getPath());
            }
        }
        l lVar2 = this.mJ.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            List<l> cE2 = cVar2.cE();
            for (int i = 0; i < cE2.size(); i++) {
                Path path3 = cE2.get(i).getPath();
                path3.transform(cVar2.cF());
                this.na.addPath(path3);
            }
        } else {
            this.na.set(lVar2.getPath());
        }
        this.path.op(this.na, this.nb, op);
    }
}
    
