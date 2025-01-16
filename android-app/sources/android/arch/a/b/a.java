package android.arch.a.b;

import android.arch.a.b.b;
import java.util.HashMap;

/* compiled from: FastSafeIterableMap */
public final class a<K, V> extends b<K, V> {
    public HashMap<K, b.c<K, V>> aa = new HashMap<>();

    /* access modifiers changed from: protected */
    public final b.c<K, V> b(K k) {
        return this.aa.get(k);
    }

    public final V putIfAbsent(K k, V v) {
        b.c b2 = b(k);
        if (b2 != null) {
            return b2.mValue;
        }
        this.aa.put(k, b(k, v));
        return null;
    }

    public final V remove(K k) {
        V remove = super.remove(k);
        this.aa.remove(k);
        return remove;
    }

    public final boolean contains(K k) {
        return this.aa.containsKey(k);
    }
}
