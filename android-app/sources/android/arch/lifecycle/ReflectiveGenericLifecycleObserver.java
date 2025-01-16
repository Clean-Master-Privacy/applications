package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.a;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    private final Object aS;
    private final a.C0001a aT = a.am.c(this.aS.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.aS = obj;
    }

    public final void a(d dVar, Lifecycle.Event event) {
        a.C0001a aVar = this.aT;
        Object obj = this.aS;
        a.C0001a.a(aVar.ap.get(event), dVar, event, obj);
        a.C0001a.a(aVar.ap.get(Lifecycle.Event.ON_ANY), dVar, event, obj);
    }
}
