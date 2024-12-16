    package okio;

import javax.annotation.Nullable;

final class n {
    final byte[] data;
    n kiA;
    boolean kix;
    boolean kiy;
    n kiz;
    int limit;
    int pos;

    n() {
        this.data = new byte[8192];
        this.kiy = true;
        this.kix = false;
    }

    n(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.kix = z;
        this.kiy = z2;
    }

    /* access modifiers changed from: package-private */
    public final n bYy() {
        this.kix = true;
        return new n(this.data, this.pos, this.limit, true, false);
    }

    /* access modifiers changed from: package-private */
    public final n bYz() {
        return new n((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    @Nullable
    public final n bYA() {
        n nVar = this.kiz != this ? this.kiz : null;
        this.kiA.kiz = this.kiz;
        this.kiz.kiA = this.kiA;
        this.kiz = null;
        this.kiA = null;
        return nVar;
    }

    public final n a(n nVar) {
        nVar.kiA = this;
        nVar.kiz = this.kiz;
        this.kiz.kiA = nVar;
        this.kiz = nVar;
        return nVar;
    }

    public final void a(n nVar, int i) {
        if (nVar.kiy) {
            if (nVar.limit + i > 8192) {
                if (nVar.kix) {
                    throw new IllegalArgumentException();
                } else if ((nVar.limit + i) - nVar.pos <= 8192) {
                    System.arraycopy(nVar.data, nVar.pos, nVar.data, 0, nVar.limit - nVar.pos);
                    nVar.limit -= nVar.pos;
                    nVar.pos = 0;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.data, this.pos, nVar.data, nVar.limit, i);
            nVar.limit += i;
            this.pos += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
    
