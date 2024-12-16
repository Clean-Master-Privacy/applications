    package okio;

import javax.annotation.Nullable;

final class o {
    private static long kiB;
    @Nullable
    private static n kiz;

    private o() {
    }

    static n bYB() {
        synchronized (o.class) {
            if (kiz == null) {
                return new n();
            }
            n nVar = kiz;
            kiz = nVar.kiz;
            nVar.kiz = null;
            kiB -= 8192;
            return nVar;
        }
    }

    static void b(n nVar) {
        if (nVar.kiz != null || nVar.kiA != null) {
            throw new IllegalArgumentException();
        } else if (!nVar.kix) {
            synchronized (o.class) {
                if (kiB + 8192 <= 65536) {
                    kiB += 8192;
                    nVar.kiz = kiz;
                    nVar.limit = 0;
                    nVar.pos = 0;
                    kiz = nVar;
                }
            }
        }
    }
}
    
