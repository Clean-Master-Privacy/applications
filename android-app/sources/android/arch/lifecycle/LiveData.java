package android.arch.lifecycle;

import android.arch.a.b.b;
import android.arch.lifecycle.Lifecycle;
import java.util.Map;

public abstract class LiveData<T> {
    public static final Object aH = new Object();
    /* access modifiers changed from: private */
    public final Object aG = new Object();
    private b<j<T>, LiveData<T>.a> aI = new b<>();
    public int aJ = 0;
    /* access modifiers changed from: private */
    public volatile Object aK = aH;
    private boolean aL;
    private boolean aM;
    private final Runnable aN = new Runnable() {
        public final void run() {
            Object b2;
            synchronized (LiveData.this.aG) {
                b2 = LiveData.this.aK;
                Object unused = LiveData.this.aK = LiveData.aH;
            }
            LiveData.this.setValue(b2);
        }
    };
    public volatile Object mData = aH;
    private int mVersion = -1;

    public void O() {
    }

    public void onActive() {
    }

    private void a(LiveData<T>.a aVar) {
        if (aVar.mActive) {
            if (!aVar.P()) {
                aVar.f(false);
            } else if (aVar.aR < this.mVersion) {
                aVar.aR = this.mVersion;
                aVar.aQ.e(this.mData);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(LiveData<T>.a aVar) {
        if (this.aL) {
            this.aM = true;
            return;
        }
        this.aL = true;
        do {
            this.aM = false;
            if (aVar == null) {
                b<K, V>.d J = this.aI.J();
                while (J.hasNext()) {
                    a((LiveData<T>.a) (a) ((Map.Entry) J.next()).getValue());
                    if (this.aM) {
                        break;
                    }
                }
            } else {
                a(aVar);
                aVar = null;
            }
        } while (this.aM);
        this.aL = false;
    }

    public final void a(d dVar, j<T> jVar) {
        if (dVar.getLifecycle().L() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(dVar, jVar);
            a putIfAbsent = this.aI.putIfAbsent(jVar, lifecycleBoundObserver);
            if (putIfAbsent != null && !putIfAbsent.b(dVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (putIfAbsent == null) {
                dVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(j<T> jVar) {
        l("removeObserver");
        a remove = this.aI.remove(jVar);
        if (remove != null) {
            remove.Q();
            remove.f(false);
        }
    }

    /* access modifiers changed from: protected */
    public void d(T t) {
        boolean z;
        synchronized (this.aG) {
            z = this.aK == aH;
            this.aK = t;
        }
        if (z) {
            android.arch.a.a.a.H().b(this.aN);
        }
    }

    public void setValue(T t) {
        l("setValue");
        this.mVersion++;
        this.mData = t;
        b((LiveData<T>.a) null);
    }

    class LifecycleBoundObserver extends LiveData<T>.a implements GenericLifecycleObserver {
        private d aP;

        LifecycleBoundObserver(d dVar, j<T> jVar) {
            super(jVar);
            this.aP = dVar;
        }

        /* access modifiers changed from: package-private */
        public final boolean P() {
            return this.aP.getLifecycle().L().isAtLeast(Lifecycle.State.STARTED);
        }

        public final void a(d dVar, Lifecycle.Event event) {
            if (this.aP.getLifecycle().L() == Lifecycle.State.DESTROYED) {
                LiveData.this.a(this.aQ);
            } else {
                f(P());
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean b(d dVar) {
            return this.aP == dVar;
        }

        /* access modifiers changed from: package-private */
        public final void Q() {
            this.aP.getLifecycle().b(this);
        }
    }

    private abstract class a {
        final j<T> aQ;
        int aR = -1;
        boolean mActive;

        /* access modifiers changed from: package-private */
        public abstract boolean P();

        /* access modifiers changed from: package-private */
        public void Q() {
        }

        /* access modifiers changed from: package-private */
        public boolean b(d dVar) {
            return false;
        }

        a(j<T> jVar) {
            this.aQ = jVar;
        }

        /* access modifiers changed from: package-private */
        public final void f(boolean z) {
            if (z != this.mActive) {
                this.mActive = z;
                int i = 1;
                boolean z2 = LiveData.this.aJ == 0;
                LiveData liveData = LiveData.this;
                int c2 = liveData.aJ;
                if (!this.mActive) {
                    i = -1;
                }
                int unused = liveData.aJ = c2 + i;
                if (z2 && this.mActive) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.aJ == 0 && !this.mActive) {
                    LiveData.this.O();
                }
                if (this.mActive) {
                    LiveData.this.b((LiveData<T>.a) this);
                }
            }
        }
    }

    private static void l(String str) {
        if (!android.arch.a.a.a.H().W.I()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
