    package client.core;

import client.core.model.c;
import client.core.model.d;
import client.core.model.f;
import client.core.model.h;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public static int iT = 1;
    public static int iU = 1;
    public static int iV = 2;
    public static int iW = 4096;
    public static d iX = new a();
    private static b iY = new b();
    private c iZ = c.bA();
    private e ja = e.bB();

    private b() {
        new ConcurrentHashMap();
    }

    public static b bz() {
        return iY;
    }

    public final void a(h hVar) {
        this.ja.jj.n(hVar);
    }

    public final void a(c cVar) {
        this.iZ.a(cVar);
    }

    public final void a(String str, d dVar) {
        c cVar = this.iZ;
        cVar.bj(str);
        f fVar = cVar.je.get(str);
        if (!fVar.jw.contains(dVar)) {
            fVar.jw.add(dVar);
            String.format("[:uri '%s' :size %d :listener+ '%s']", new Object[]{fVar.mUri, Integer.valueOf(fVar.jw.size()), dVar});
        }
    }

    public final void b(String str, d dVar) {
        f bi = this.iZ.bi(str);
        if (bi != null) {
            bi.a(dVar);
        }
    }

    public final void a(d dVar) {
        this.iZ.bi("lg://default").a(dVar);
    }
}
    
