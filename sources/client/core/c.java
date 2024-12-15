    package client.core;

import client.core.model.b;
import client.core.model.f;
import client.core.model.g;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class c {
    private static c jb = new c();
    private BlockingQueue<client.core.model.c> jc = new LinkedBlockingQueue();
    private a jd = new a(this.jc);
    ConcurrentHashMap<String, f> je = new ConcurrentHashMap<>();

    protected class a extends b<client.core.model.c> {
        public a(BlockingQueue<client.core.model.c> blockingQueue) {
            this.jp = blockingQueue;
            this.jq = Executors.newFixedThreadPool(b.iT);
            setName("EventDispather");
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public client.core.model.c m(client.core.model.c cVar) {
            if (cVar == null) {
                return null;
            }
            d dVar = b.iX;
            cVar.toString();
            g gVar = cVar.ju;
            if (gVar.bD()) {
                c.a(c.this, cVar);
            } else {
                Iterator<String> it = gVar.jx.iterator();
                while (it.hasNext()) {
                    f a2 = c.this.bi(it.next());
                    if (a2 != null) {
                        a2.c(cVar);
                    }
                }
            }
            return null;
        }
    }

    private c() {
        bj("lg://default");
        this.jd.start();
    }

    public static c bA() {
        return jb;
    }

    public final void a(client.core.model.c cVar) {
        if (cVar != null) {
            this.jc.add(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final f bi(String str) {
        return this.je.get(str);
    }

    public final void bj(String str) {
        if (!this.je.containsKey(str)) {
            this.je.put(str, new f(str));
        }
    }

    static /* synthetic */ void a(c cVar, client.core.model.c cVar2) {
        for (Map.Entry<String, f> value : cVar.je.entrySet()) {
            ((f) value.getValue()).c(cVar2);
        }
    }
}
    
