    package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.l;
import com.airbnb.lottie.model.e;
import com.airbnb.lottie.model.g;
import java.util.ArrayList;
import java.util.Iterator;

public class LottieAnimationView extends AppCompatImageView {
    private static CacheStrategy lb = CacheStrategy.Weak;
    private final g<c> lc = new g<c>() {
        public final /* synthetic */ void onResult(Object obj) {
            LottieAnimationView.this.a((c) obj);
        }
    };
    private final g<Throwable> ld = new g<Throwable>() {
        public final /* synthetic */ void onResult(Object obj) {
            throw new IllegalStateException("Unable to parse composition", (Throwable) obj);
        }
    };
    public final e le = new e();
    @Nullable
    private j lf;

    @Deprecated
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    static {
        LottieAnimationView.class.getSimpleName();
    }

    public LottieAnimationView(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, l.a.LottieAnimationView);
        obtainStyledAttributes.getInt(l.a.LottieAnimationView_lottie_cacheStrategy, lb.ordinal());
        CacheStrategy.values();
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(l.a.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(l.a.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(l.a.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use use only one at once.");
            } else if (hasValue) {
                final int resourceId = obtainStyledAttributes.getResourceId(l.a.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    c bx = g.cN().bx(Integer.toString(resourceId));
                    if (bx != null) {
                        a(bx);
                    } else {
                        this.le.cw();
                        cancelLoaderTask();
                        this.lf = d.d(getContext(), resourceId).a(new g<c>() {
                            public final /* synthetic */ void onResult(Object obj) {
                                g.cN().a(Integer.toString(resourceId), (c) obj);
                            }
                        }).a(this.lc).c(this.ld);
                    }
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(l.a.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(l.a.LottieAnimationView_lottie_url)) != null) {
                this.le.cw();
                cancelLoaderTask();
                this.lf = d.r(getContext(), string).a(this.lc).c(this.ld);
            }
        }
        obtainStyledAttributes.getBoolean(l.a.LottieAnimationView_lottie_autoPlay, false);
        if (obtainStyledAttributes.getBoolean(l.a.LottieAnimationView_lottie_loop, false)) {
            this.le.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(l.a.LottieAnimationView_lottie_repeatMode)) {
            this.le.lC.setRepeatMode(obtainStyledAttributes.getInt(l.a.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(l.a.LottieAnimationView_lottie_repeatCount)) {
            this.le.setRepeatCount(obtainStyledAttributes.getInt(l.a.LottieAnimationView_lottie_repeatCount, -1));
        }
        this.le.ll = obtainStyledAttributes.getString(l.a.LottieAnimationView_lottie_imageAssetsFolder);
        this.le.setProgress(obtainStyledAttributes.getFloat(l.a.LottieAnimationView_lottie_progress, 0.0f));
        boolean z = obtainStyledAttributes.getBoolean(l.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        e eVar = this.le;
        if (eVar.lG != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(e.TAG, "Merge paths are not supported pre-Kit Kat.");
            } else {
                eVar.lG = z;
                if (eVar.lB != null) {
                    eVar.cv();
                }
            }
        }
        if (obtainStyledAttributes.hasValue(l.a.LottieAnimationView_lottie_colorFilter)) {
            m mVar = new m(obtainStyledAttributes.getColor(l.a.LottieAnimationView_lottie_colorFilter, 0));
            e eVar2 = new e("**");
            c cVar = new c(mVar);
            this.le.a(eVar2, h.ml, cVar);
        }
        if (obtainStyledAttributes.hasValue(l.a.LottieAnimationView_lottie_scale)) {
            this.le.setScale(obtainStyledAttributes.getFloat(l.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        setLayerType(1, (Paint) null);
    }

    public final void setAnimation(final String str) {
        c bx = g.cN().bx(str);
        if (bx != null) {
            a(bx);
            return;
        }
        this.le.cw();
        cancelLoaderTask();
        this.lf = d.s(getContext(), str).a(new g<c>() {
            public final /* synthetic */ void onResult(Object obj) {
                g.cN().a(str, (c) obj);
            }
        }).a(this.lc).c(this.ld);
    }

    private void cancelLoaderTask() {
        if (this.lf != null) {
            this.lf.b(this.lc);
            this.lf.d(this.ld);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.airbnb.lottie.LottieAnimationView, android.graphics.drawable.Drawable$Callback] */
    public final void a(@NonNull c cVar) {
        boolean z = b.DBG;
        this.le.setCallback(this);
        e eVar = this.le;
        boolean z2 = false;
        if (eVar.lB != cVar) {
            eVar.cw();
            eVar.lB = cVar;
            eVar.cv();
            com.airbnb.lottie.d.c cVar2 = eVar.lC;
            if (cVar2.lB == null) {
                z2 = true;
            }
            cVar2.lB = cVar;
            if (z2) {
                cVar2.f((int) Math.max(cVar2.qV, cVar.lu), (int) Math.min(cVar2.qW, cVar.lv));
            } else {
                cVar2.f((int) cVar.lu, (int) cVar.lv);
            }
            cVar2.G((int) cVar2.qU);
            cVar2.qT = System.nanoTime();
            eVar.setProgress(eVar.lC.getAnimatedFraction());
            eVar.setScale(eVar.scale);
            eVar.cy();
            Iterator it = new ArrayList(eVar.lD).iterator();
            while (it.hasNext()) {
                ((e.a) it.next()).cz();
                it.remove();
            }
            eVar.lD.clear();
            z2 = true;
        }
        setLayerType(1, (Paint) null);
        if (getDrawable() != this.le || z2) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.le);
            requestLayout();
        }
    }

    @MainThread
    public final void playAnimation() {
        this.le.playAnimation();
        setLayerType(1, (Paint) null);
    }

    @Deprecated
    public final void cs() {
        this.le.setRepeatCount(-1);
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };
        private String animationName;
        private boolean lk;
        private String ll;
        private float progress;
        private int repeatCount;
        private int repeatMode;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.lk = parcel.readInt() != 1 ? false : true;
            this.ll = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.lk ? 1 : 0);
            parcel.writeString(this.ll);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }

    private void setImageDrawable(Drawable drawable) {
        if (drawable != this.le) {
            this.le.recycleBitmaps();
        }
        cancelLoaderTask();
        LottieAnimationView.super.setImageDrawable(drawable);
    }
}
    
