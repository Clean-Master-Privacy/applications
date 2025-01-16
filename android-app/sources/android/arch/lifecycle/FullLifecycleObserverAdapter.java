package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
    FullLifecycleObserverAdapter() {
    }

    public final void a(d dVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                return;
            case ON_START:
                return;
            case ON_RESUME:
                return;
            case ON_PAUSE:
                return;
            case ON_STOP:
                return;
            case ON_DESTROY:
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
