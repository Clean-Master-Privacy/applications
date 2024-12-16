    package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements d, j, a.C0012a {
    private final e le;
    private final com.airbnb.lottie.a.b.a<?, Float> mB;
    private final com.airbnb.lottie.a.b.a<?, Integer> mC;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> mD;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> mE;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> mF;
    private final PathMeasure mu = new PathMeasure();
    private final Path mv = new Path();
    private final RectF mw = new RectF();
    private final com.airbnb.lottie.model.layer.a mx;
    private final List<C0011a> my = new ArrayList();
    private final float[] mz;
    final Paint paint = new Paint(1);
    private final Path path = new Path();

    a(e eVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, d dVar, b bVar, List<b> list, b bVar2) {
        this.le = eVar;
        this.mx = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.mC = dVar.cO();
        this.mB = bVar.cO();
        if (bVar2 == null) {
            this.mE = null;
        } else {
            this.mE = bVar2.cO();
        }
        this.mD = new ArrayList(list.size());
        this.mz = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.mD.add(list.get(i).cO());
        }
        aVar.a(this.mC);
        aVar.a(this.mB);
        for (int i2 = 0; i2 < this.mD.size(); i2++) {
            aVar.a(this.mD.get(i2));
        }
        if (this.mE != null) {
            aVar.a(this.mE);
        }
        this.mC.b(this);
        this.mB.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.mD.get(i3).b(this);
        }
        if (this.mE != null) {
            this.mE.b(this);
        }
    }

    public final void cD() {
        this.le.invalidateSelf();
    }

    public final void b(List<b> list, List<b> list2) {
        C0011a aVar = null;
        r rVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof r) {
                r rVar2 = (r) bVar;
                if (rVar2.nt == ShapeTrimPath.Type.Individually) {
                    rVar = rVar2;
                }
            }
        }
        if (rVar != null) {
            rVar.a(this);
        }
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            b bVar2 = list2.get(size2);
            if (bVar2 instanceof r) {
                r rVar3 = (r) bVar2;
                if (rVar3.nt == ShapeTrimPath.Type.Individually) {
                    if (aVar != null) {
                        this.my.add(aVar);
                    }
                    C0011a aVar2 = new C0011a(rVar3, (byte) 0);
                    rVar3.a(this);
                    aVar = aVar2;
                }
            }
            if (bVar2 instanceof l) {
                if (aVar == null) {
                    aVar = new C0011a(rVar, (byte) 0);
                }
                aVar.mG.add((l) bVar2);
            }
        }
        if (aVar != null) {
            this.my.add(aVar);
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.b.cq();
        this.paint.setAlpha(com.airbnb.lottie.d.d.J((int) ((((((float) i) / 255.0f) * ((float) this.mC.getValue().intValue())) / 100.0f) * 255.0f)));
        this.paint.setStrokeWidth(this.mB.getValue().floatValue() * com.airbnb.lottie.d.e.a(matrix));
        float f = 0.0f;
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.b.cr();
            return;
        }
        com.airbnb.lottie.b.cq();
        if (this.mD.isEmpty()) {
            com.airbnb.lottie.b.cr();
        } else {
            float a2 = com.airbnb.lottie.d.e.a(matrix);
            for (int i2 = 0; i2 < this.mD.size(); i2++) {
                this.mz[i2] = ((Float) this.mD.get(i2).getValue()).floatValue();
                if (i2 % 2 == 0) {
                    if (this.mz[i2] < 1.0f) {
                        this.mz[i2] = 1.0f;
                    }
                } else if (this.mz[i2] < 0.1f) {
                    this.mz[i2] = 0.1f;
                }
                float[] fArr = this.mz;
                fArr[i2] = fArr[i2] * a2;
            }
            if (this.mE != null) {
                f = this.mE.getValue().floatValue();
            }
            this.paint.setPathEffect(new DashPathEffect(this.mz, f));
            com.airbnb.lottie.b.cr();
        }
        if (this.mF != null) {
            this.paint.setColorFilter(this.mF.getValue());
        }
        for (int i3 = 0; i3 < this.my.size(); i3++) {
            C0011a aVar = this.my.get(i3);
            if (aVar.mH != null) {
                a(canvas, aVar, matrix);
            } else {
                com.airbnb.lottie.b.cq();
                this.path.reset();
                for (int size = aVar.mG.size() - 1; size >= 0; size--) {
                    this.path.addPath(aVar.mG.get(size).getPath(), matrix);
                }
                com.airbnb.lottie.b.cr();
                com.airbnb.lottie.b.cq();
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.b.cr();
            }
        }
        com.airbnb.lottie.b.cr();
    }

    private void a(Canvas canvas, C0011a aVar, Matrix matrix) {
        float f;
        com.airbnb.lottie.b.cq();
        if (aVar.mH == null) {
            com.airbnb.lottie.b.cr();
            return;
        }
        this.path.reset();
        for (int size = aVar.mG.size() - 1; size >= 0; size--) {
            this.path.addPath(aVar.mG.get(size).getPath(), matrix);
        }
        this.mu.setPath(this.path, false);
        float length = this.mu.getLength();
        while (this.mu.nextContour()) {
            length += this.mu.getLength();
        }
        float floatValue = (aVar.mH.nw.getValue().floatValue() * length) / 360.0f;
        float floatValue2 = ((aVar.mH.nu.getValue().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((aVar.mH.nv.getValue().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = aVar.mG.size() - 1; size2 >= 0; size2--) {
            this.mv.set(aVar.mG.get(size2).getPath());
            this.mv.transform(matrix);
            this.mu.setPath(this.mv, false);
            float length2 = this.mu.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                float f4 = floatValue3 - length;
                if (f4 < f2 + length2 && f2 < f4) {
                    f = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f3 = Math.min(f4 / length2, 1.0f);
                    com.airbnb.lottie.d.e.a(this.mv, f, f3, 0.0f);
                    canvas.drawPath(this.mv, this.paint);
                    f2 += length2;
                }
            }
            float f5 = f2 + length2;
            if (f5 >= floatValue2 && f2 <= floatValue3) {
                if (f5 > floatValue3 || floatValue2 >= f2) {
                    f = floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2;
                    if (floatValue3 <= f5) {
                        f3 = (floatValue3 - f2) / length2;
                    }
                    com.airbnb.lottie.d.e.a(this.mv, f, f3, 0.0f);
                    canvas.drawPath(this.mv, this.paint);
                } else {
                    canvas.drawPath(this.mv, this.paint);
                }
            }
            f2 += length2;
        }
        com.airbnb.lottie.b.cr();
    }

    public final void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.b.cq();
        this.path.reset();
        for (int i = 0; i < this.my.size(); i++) {
            C0011a aVar = this.my.get(i);
            for (int i2 = 0; i2 < aVar.mG.size(); i2++) {
                this.path.addPath(aVar.mG.get(i2).getPath(), matrix);
            }
        }
        this.path.computeBounds(this.mw, false);
        float floatValue = this.mB.getValue().floatValue() / 2.0f;
        this.mw.set(this.mw.left - floatValue, this.mw.top - floatValue, this.mw.right + floatValue, this.mw.bottom + floatValue);
        rectF.set(this.mw);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.b.cr();
    }

    public final void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.d.a(eVar, i, list, eVar2, this);
    }

    @CallSuper
    public <T> void a(T t, @Nullable c<T> cVar) {
        if (t == h.lR) {
            this.mC.a(cVar);
        } else if (t == h.lY) {
            this.mB.a(cVar);
        } else if (t != h.ml) {
        } else {
            if (cVar == null) {
                this.mF = null;
                return;
            }
            this.mF = new p(cVar);
            this.mF.b(this);
            this.mx.a(this.mF);
        }
    }

    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    private static final class C0011a {
        final List<l> mG;
        @Nullable
        final r mH;

        /* synthetic */ C0011a(r rVar, byte b2) {
            this(rVar);
        }

        private C0011a(@Nullable r rVar) {
            this.mG = new ArrayList();
            this.mH = rVar;
        }
    }
}
    
