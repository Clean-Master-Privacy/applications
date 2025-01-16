package android.arch.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    public c<K, V> ab;
    public c<K, V> ac;
    public WeakHashMap<f<K, V>, Boolean> ae = new WeakHashMap<>();
    public int mSize = 0;

    /* compiled from: SafeIterableMap */
    interface f<K, V> {
        void c(c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    public c<K, V> b(K k) {
        c<K, V> cVar = this.ab;
        while (cVar != null && !cVar.af.equals(k)) {
            cVar = cVar.ag;
        }
        return cVar;
    }

    public V putIfAbsent(K k, V v) {
        c b2 = b(k);
        if (b2 != null) {
            return b2.mValue;
        }
        b(k, v);
        return null;
    }

    /* access modifiers changed from: protected */
    public final c<K, V> b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.mSize++;
        if (this.ac == null) {
            this.ab = cVar;
            this.ac = this.ab;
            return cVar;
        }
        this.ac.ag = cVar;
        cVar.ah = this.ac;
        this.ac = cVar;
        return cVar;
    }

    public V remove(K k) {
        c b2 = b(k);
        if (b2 == null) {
            return null;
        }
        this.mSize--;
        if (!this.ae.isEmpty()) {
            for (f<K, V> c2 : this.ae.keySet()) {
                c2.c(b2);
            }
        }
        if (b2.ah != null) {
            b2.ah.ag = b2.ag;
        } else {
            this.ab = b2.ag;
        }
        if (b2.ag != null) {
            b2.ag.ah = b2.ah;
        } else {
            this.ac = b2.ah;
        }
        b2.ag = null;
        b2.ah = null;
        return b2.mValue;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.ab, this.ac);
        this.ae.put(aVar, false);
        return aVar;
    }

    public final b<K, V>.d J() {
        b<K, V>.d dVar = new d(this, (byte) 0);
        this.ae.put(dVar, false);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.mSize != bVar.mSize) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* compiled from: SafeIterableMap */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> ag;
        private c<K, V> al;

        /* access modifiers changed from: package-private */
        public abstract c<K, V> a(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.al = cVar2;
            this.ag = cVar;
        }

        public boolean hasNext() {
            return this.ag != null;
        }

        public final void c(c<K, V> cVar) {
            if (this.al == cVar && cVar == this.ag) {
                this.ag = null;
                this.al = null;
            }
            if (this.al == cVar) {
                this.al = b(this.al);
            }
            if (this.ag == cVar) {
                this.ag = K();
            }
        }

        private c<K, V> K() {
            if (this.ag == this.al || this.al == null) {
                return null;
            }
            return a(this.ag);
        }

        public /* synthetic */ Object next() {
            c<K, V> cVar = this.ag;
            this.ag = K();
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.ag;
        }

        /* access modifiers changed from: package-private */
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.ah;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    /* compiled from: SafeIterableMap */
    private static class C0000b<K, V> extends e<K, V> {
        public C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.ah;
        }

        /* access modifiers changed from: package-private */
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.ag;
        }
    }

    /* compiled from: SafeIterableMap */
    private class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> ai;
        private boolean aj;

        private d() {
            this.aj = true;
        }

        /* synthetic */ d(b bVar, byte b2) {
            this();
        }

        public final void c(c<K, V> cVar) {
            if (cVar == this.ai) {
                this.ai = this.ai.ah;
                this.aj = this.ai == null;
            }
        }

        public final boolean hasNext() {
            return this.aj ? b.this.ab != null : (this.ai == null || this.ai.ag == null) ? false : true;
        }

        public final /* synthetic */ Object next() {
            c<K, V> cVar;
            if (this.aj) {
                this.aj = false;
                cVar = b.this.ab;
            } else {
                cVar = this.ai != null ? this.ai.ag : null;
            }
            this.ai = cVar;
            return this.ai;
        }
    }

    /* compiled from: SafeIterableMap */
    static class c<K, V> implements Map.Entry<K, V> {
        final K af;
        c<K, V> ag;
        public c<K, V> ah;
        final V mValue;

        c(K k, V v) {
            this.af = k;
            this.mValue = v;
        }

        public final K getKey() {
            return this.af;
        }

        public final V getValue() {
            return this.mValue;
        }

        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.af + "=" + this.mValue;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.af.equals(cVar.af) && this.mValue.equals(cVar.mValue);
        }
    }
}
