package android.arch.lifecycle;

public abstract class Lifecycle {

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public abstract State L();

    public abstract void a(c cVar);

    public abstract void b(c cVar);

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }
    }
}
