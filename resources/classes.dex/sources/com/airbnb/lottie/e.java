    package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.b.b;
import com.airbnb.lottie.d.c;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class e extends Drawable implements Animatable, Drawable.Callback {
    static final String TAG = "e";
    private int alpha;
    public c lB;
    public final c lC = new c();
    public final ArrayList<a> lD;
    @Nullable
    public b lE;
    @Nullable
    public com.airbnb.lottie.b.a lF;
    public boolean lG;
    /* access modifiers changed from: private */
    @Nullable
    public com.airbnb.lottie.model.layer.b lH;
    @Nullable
    public String ll;
    private final Matrix matrix = new Matrix();
    float scale = 1.0f;

    private interface a {
        void cz();
    }

    public int getOpacity() {
        return -3;
    }

    public e() {
        new HashSet();
        this.lD = new ArrayList<>();
        this.alpha = 255;
        this.lC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (e.this.lH != null) {
                    e.this.lH.setProgress(e.this.lC.cX());
                }
            }
        });
    }

    public final void recycleBitmaps() {
        if (this.lE != null) {
            this.lE.recycleBitmaps();
        }
    }

    /* access modifiers changed from: package-private */
    public final void cv() {
        c cVar = this.lB;
        Rect rect = cVar.bounds;
        List emptyList = Collections.emptyList();
        Layer.LayerType layerType = Layer.LayerType.PreComp;
        List emptyList2 = Collections.emptyList();
        l lVar = r7;
        l lVar2 = new l();
        Layer layer = r2;
        Layer layer2 = new Layer(emptyList, cVar, "__container", -1, layerType, -1, (String) null, emptyList2, lVar, 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), (j) null, (k) null, Collections.emptyList(), Layer.MatteType.None, (com.airbnb.lottie.model.a.b) null);
        this.lH = new com.airbnb.lottie.model.layer.b(this, layer, this.lB.lt, this.lB);
    }

    public final void cw() {
        recycleBitmaps();
        if (this.lC.isRunning()) {
            this.lC.cancel();
        }
        this.lB = null;
        this.lH = null;
        this.lE = null;
        c cVar = this.lC;
        cVar.lB = null;
        cVar.qV = -2.14748365E9f;
        cVar.qW = 2.14748365E9f;
        invalidateSelf();
    }

    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.alpha = i;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public void draw(@NonNull Canvas canvas) {
        float f;
        b.cq();
        if (this.lH != null) {
            float f2 = this.scale;
            float min = Math.min(((float) canvas.getWidth()) / ((float) this.lB.bounds.width()), ((float) canvas.getHeight()) / ((float) this.lB.bounds.height()));
            if (f2 > min) {
                f = this.scale / min;
            } else {
                min = f2;
                f = 1.0f;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = ((float) this.lB.bounds.width()) / 2.0f;
                float height = ((float) this.lB.bounds.height()) / 2.0f;
                float f3 = width * min;
                float f4 = height * min;
                canvas.translate((this.scale * width) - f3, (this.scale * height) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(min, min);
            this.lH.a(canvas, this.matrix, this.alpha);
            b.cr();
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    @MainThread
    public void start() {
        playAnimation();
    }

    @MainThread
    public final void playAnimation() {
        if (this.lH == null) {
            this.lD.add(new a() {
                public final void cz() {
                    e.this.playAnimation();
                }
            });
            return;
        }
        c cVar = this.lC;
        cVar.qX = true;
        boolean cZ = cVar.cZ();
        for (Animator.AnimatorListener next : cVar.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationStart(cVar, cZ);
            } else {
                next.onAnimationStart(cVar);
            }
        }
        cVar.G((int) (cVar.cZ() ? cVar.db() : cVar.da()));
        cVar.qT = System.nanoTime();
        cVar.repeatCount = 0;
        cVar.dc();
    }

    public final void G(final int i) {
        if (this.lB == null) {
            this.lD.add(new a() {
                public final void cz() {
                    e.this.G(i);
                }
            });
        } else {
            this.lC.G(i);
        }
    }

    public final void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.lB == null) {
            this.lD.add(new a() {
                public final void cz() {
                    e.this.setProgress(f);
                }
            });
            return;
        }
        float f2 = this.lB.lu;
        G((int) (f2 + (f * (this.lB.lv - f2))));
    }

    public final void setRepeatCount(int i) {
        this.lC.setRepeatCount(i);
    }

    public final void setScale(float f) {
        this.scale = f;
        cy();
    }

    public final boolean cx() {
        return this.lB.lr.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public final void cy() {
        if (this.lB != null) {
            float f = this.scale;
            setBounds(0, 0, (int) (((float) this.lB.bounds.width()) * f), (int) (((float) this.lB.bounds.height()) * f));
        }
    }

    public int getIntrinsicWidth() {
        if (this.lB == null) {
            return -1;
        }
        return (int) (((float) this.lB.bounds.width()) * this.scale);
    }

    public int getIntrinsicHeight() {
        if (this.lB == null) {
            return -1;
        }
        return (int) (((float) this.lB.bounds.height()) * this.scale);
    }

    public final <T> void a(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        List list;
        if (this.lH == null) {
            this.lD.add(new a() {
                public final void cz() {
                    e.this.a(eVar, t, cVar);
                }
            });
            return;
        }
        boolean z = true;
        if (eVar.ow != null) {
            eVar.ow.a(t, cVar);
        } else {
            if (this.lH == null) {
                Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
                list = Collections.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                this.lH.a(eVar, 0, (List<com.airbnb.lottie.model.e>) arrayList, new com.airbnb.lottie.model.e(new String[0]));
                list = arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                ((com.airbnb.lottie.model.e) list.get(i)).ow.a(t, cVar);
            }
            if (list.isEmpty()) {
                z = false;
            }
        }
        if (z) {
            invalidateSelf();
            if (t == h.mk) {
                setProgress(this.lC.cX());
            }
        }
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    @MainThread
    public void stop() {
        this.lD.clear();
        c cVar = this.lC;
        cVar.u(true);
        cVar.t(cVar.cZ());
    }

    public boolean isRunning() {
        return this.lC.isRunning();
    }
}
    
