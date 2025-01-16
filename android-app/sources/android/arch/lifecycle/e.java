package android.arch.lifecycle;

import android.arch.a.b.b;
import android.arch.lifecycle.Lifecycle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: LifecycleRegistry */
public final class e extends Lifecycle {
    private boolean aA = false;
    private ArrayList<Lifecycle.State> aB = new ArrayList<>();
    private android.arch.a.b.a<c, a> av = new android.arch.a.b.a<>();
    private Lifecycle.State aw;
    private final WeakReference<d> ax;
    private int ay = 0;
    private boolean az = false;

    public e(d dVar) {
        this.ax = new WeakReference<>(dVar);
        this.aw = Lifecycle.State.INITIALIZED;
    }

    public final void a(Lifecycle.Event event) {
        a(b(event));
    }

    public final void a(Lifecycle.State state) {
        if (this.aw != state) {
            this.aw = state;
            if (this.az || this.ay != 0) {
                this.aA = true;
                return;
            }
            this.az = true;
            sync();
            this.az = false;
        }
    }

    private Lifecycle.State c(c cVar) {
        android.arch.a.b.a<c, a> aVar = this.av;
        Lifecycle.State state = null;
        b.c<K, V> cVar2 = aVar.contains(cVar) ? aVar.aa.get(cVar).ah : null;
        Lifecycle.State state2 = cVar2 != null ? ((a) cVar2.getValue()).aw : null;
        if (!this.aB.isEmpty()) {
            state = this.aB.get(this.aB.size() - 1);
        }
        return a(a(this.aw, state2), state);
    }

    public final void a(c cVar) {
        d dVar;
        a aVar = new a(cVar, this.aw == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.av.putIfAbsent(cVar, aVar) == null && (dVar = (d) this.ax.get()) != null) {
            boolean z = this.ay != 0 || this.az;
            Lifecycle.State c2 = c(cVar);
            this.ay++;
            while (aVar.aw.compareTo(c2) < 0 && this.av.contains(cVar)) {
                b(aVar.aw);
                aVar.b(dVar, c(aVar.aw));
                M();
                c2 = c(cVar);
            }
            if (!z) {
                sync();
            }
            this.ay--;
        }
    }

    private void M() {
        this.aB.remove(this.aB.size() - 1);
    }

    private void b(Lifecycle.State state) {
        this.aB.add(state);
    }

    public final void b(c cVar) {
        this.av.remove(cVar);
    }

    public final Lifecycle.State L() {
        return this.aw;
    }

    static Lifecycle.State b(Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.State.STARTED;
            case ON_RESUME:
                return Lifecycle.State.RESUMED;
            case ON_DESTROY:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private static Lifecycle.Event c(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Lifecycle.Event.ON_CREATE;
            case CREATED:
                return Lifecycle.Event.ON_START;
            case STARTED:
                return Lifecycle.Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    private void a(d dVar) {
        b<K, V>.d J = this.av.J();
        while (J.hasNext() && !this.aA) {
            Map.Entry entry = (Map.Entry) J.next();
            a aVar = (a) entry.getValue();
            while (aVar.aw.compareTo(this.aw) < 0 && !this.aA && this.av.contains(entry.getKey())) {
                b(aVar.aw);
                aVar.b(dVar, c(aVar.aw));
                M();
            }
        }
    }

    private void sync() {
        Lifecycle.Event event;
        Lifecycle.State state;
        d dVar = (d) this.ax.get();
        if (dVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (true) {
            boolean z = true;
            if (!(this.av.mSize == 0 || (((a) this.av.ab.getValue()).aw == (state = ((a) this.av.ac.getValue()).aw) && this.aw == state))) {
                z = false;
            }
            if (!z) {
                this.aA = false;
                if (this.aw.compareTo(((a) this.av.ab.getValue()).aw) < 0) {
                    android.arch.a.b.a<c, a> aVar = this.av;
                    b.C0000b bVar = new b.C0000b(aVar.ac, aVar.ab);
                    aVar.ae.put(bVar, false);
                    while (bVar.hasNext() && !this.aA) {
                        Map.Entry entry = (Map.Entry) bVar.next();
                        a aVar2 = (a) entry.getValue();
                        while (aVar2.aw.compareTo(this.aw) > 0 && !this.aA && this.av.contains(entry.getKey())) {
                            Lifecycle.State state2 = aVar2.aw;
                            switch (state2) {
                                case INITIALIZED:
                                    throw new IllegalArgumentException();
                                case CREATED:
                                    event = Lifecycle.Event.ON_DESTROY;
                                    break;
                                case STARTED:
                                    event = Lifecycle.Event.ON_STOP;
                                    break;
                                case RESUMED:
                                    event = Lifecycle.Event.ON_PAUSE;
                                    break;
                                case DESTROYED:
                                    throw new IllegalArgumentException();
                                default:
                                    throw new IllegalArgumentException("Unexpected state value " + state2);
                            }
                            b(b(event));
                            aVar2.b(dVar, event);
                            M();
                        }
                    }
                }
                b.c<K, V> cVar = this.av.ac;
                if (!this.aA && cVar != null && this.aw.compareTo(((a) cVar.getValue()).aw) > 0) {
                    a(dVar);
                }
            } else {
                this.aA = false;
                return;
            }
        }
    }

    static Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* compiled from: LifecycleRegistry */
    static class a {
        private GenericLifecycleObserver aD;
        Lifecycle.State aw;

        a(c cVar, Lifecycle.State state) {
            this.aD = g.c(cVar);
            this.aw = state;
        }

        /* access modifiers changed from: package-private */
        public final void b(d dVar, Lifecycle.Event event) {
            Lifecycle.State b2 = e.b(event);
            this.aw = e.a(this.aw, b2);
            this.aD.a(dVar, event);
            this.aw = b2;
        }
    }
}
