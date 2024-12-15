    package client.core.model;

import client.core.b;
import client.core.d;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class f {
    private volatile boolean jv = false;
    public ConcurrentLinkedQueue<d> jw = new ConcurrentLinkedQueue<>();
    public String mUri = "";

    public f(String str) {
        this.mUri = str;
    }

    public final void c(c cVar) {
        boolean z = this.jv;
        if (!this.jw.isEmpty()) {
            Iterator<d> it = this.jw.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onEvent(cVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void a(d dVar) {
        if (this.jw.remove(dVar)) {
            d dVar2 = b.iX;
            String.format("[:uri '%s' :size %d :listener- '%s']", new Object[]{this.mUri, Integer.valueOf(this.jw.size()), dVar});
        }
    }
}
    
