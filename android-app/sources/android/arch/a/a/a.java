package android.arch.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor */
public class a extends c {
    private static volatile a U;
    public c W = this.X;
    private c X = new b();

    static {
        new Executor() {
            public final void execute(Runnable runnable) {
                a.H().b(runnable);
            }
        };
        new Executor() {
            public final void execute(Runnable runnable) {
                a.H().a(runnable);
            }
        };
    }

    private a() {
    }

    public static a H() {
        if (U != null) {
            return U;
        }
        synchronized (a.class) {
            if (U == null) {
                U = new a();
            }
        }
        return U;
    }

    public final void a(Runnable runnable) {
        this.W.a(runnable);
    }

    public final void b(Runnable runnable) {
        this.W.b(runnable);
    }

    public final boolean I() {
        return this.W.I();
    }
}
