    package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public final class j<T> {
    private final Handler handler;
    private Executor mm;
    @Nullable
    private Thread mn;
    final Set<g<T>> mo;
    private final Set<g<Throwable>> mp;
    final FutureTask<i<T>> mq;
    @Nullable
    i<T> mr;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public j(Callable<i<T>> callable) {
        this(callable, (byte) 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private j(Callable<i<T>> callable, byte b2) {
        this.mm = Executors.newCachedThreadPool();
        this.mo = new LinkedHashSet(1);
        this.mp = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.mr = null;
        this.mq = new FutureTask<>(callable);
        this.mm.execute(this.mq);
        cA();
    }

    public final j<T> a(g<T> gVar) {
        if (!(this.mr == null || this.mr.value == null)) {
            gVar.onResult(this.mr.value);
        }
        synchronized (this.mo) {
            this.mo.add(gVar);
        }
        cA();
        return this;
    }

    public final j<T> b(g<T> gVar) {
        synchronized (this.mo) {
            this.mo.remove(gVar);
        }
        cB();
        return this;
    }

    public final j<T> c(g<Throwable> gVar) {
        if (!(this.mr == null || this.mr.exception == null)) {
            gVar.onResult(this.mr.exception);
        }
        synchronized (this.mp) {
            this.mp.add(gVar);
        }
        cA();
        return this;
    }

    public final j<T> d(g<T> gVar) {
        synchronized (this.mp) {
            this.mp.remove(gVar);
        }
        cB();
        return this;
    }

    private void cA() {
        if (!cC() && this.mr == null) {
            this.mn = new Thread("LottieTaskObserver") {
                public final void run() {
                    while (!isInterrupted()) {
                        if (j.this.mq.isDone()) {
                            try {
                                j.a(j.this, (i) j.this.mq.get());
                            } catch (InterruptedException | ExecutionException e) {
                                j.a(j.this, new i(e));
                            }
                            j.this.cB();
                        }
                    }
                }
            };
            this.mn.start();
            b.cp();
        }
    }

    /* access modifiers changed from: package-private */
    public final void cB() {
        if (cC()) {
            if (this.mo.isEmpty() || this.mr != null) {
                this.mn.interrupt();
                this.mn = null;
                b.cp();
            }
        }
    }

    private boolean cC() {
        return this.mn != null && this.mn.isAlive();
    }

    static /* synthetic */ void a(j jVar, Throwable th) {
        ArrayList<g> arrayList = new ArrayList<>(jVar.mp);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (g onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    static /* synthetic */ void a(j jVar, i iVar) {
        if (jVar.mr == null) {
            jVar.mr = iVar;
            jVar.handler.post(new Runnable() {
                public final void run() {
                    if (j.this.mr != null && !j.this.mq.isCancelled()) {
                        i<T> iVar = j.this.mr;
                        if (iVar.value != null) {
                            j jVar = j.this;
                            V v = iVar.value;
                            for (g onResult : new ArrayList(jVar.mo)) {
                                onResult.onResult(v);
                            }
                            return;
                        }
                        j.a(j.this, iVar.exception);
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }
}
    
