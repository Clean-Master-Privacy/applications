package android.arch.lifecycle;

import java.util.HashMap;

/* compiled from: ViewModelStore */
public final class o {
    public final HashMap<String, m> aV = new HashMap<>();

    public final void clear() {
        for (m S : this.aV.values()) {
            S.S();
        }
        this.aV.clear();
    }
}
