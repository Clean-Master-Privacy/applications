package android.support.constraint.solver;

public final class SolverVariable {
    int cY = -1;
    public int cZ = 0;
    public float da;
    float[] db = new float[6];
    Type dc;
    b[] dd = new b[8];

    /* renamed from: de  reason: collision with root package name */
    int f344de = 0;
    public int id = -1;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type) {
        this.dc = type;
    }

    /* access modifiers changed from: package-private */
    public final String ab() {
        String str = this + "[";
        for (int i = 0; i < this.db.length; i++) {
            String str2 = str + this.db[i];
            if (i < this.db.length - 1) {
                str = str2 + ", ";
            } else {
                str = str2 + "] ";
            }
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void c(b bVar) {
        for (int i = 0; i < this.f344de; i++) {
            if (this.dd[i] == bVar) {
                for (int i2 = 0; i2 < (this.f344de - i) - 1; i2++) {
                    int i3 = i + i2;
                    this.dd[i3] = this.dd[i3 + 1];
                }
                this.f344de--;
                return;
            }
        }
    }

    public final void reset() {
        this.dc = Type.UNKNOWN;
        this.cZ = 0;
        this.id = -1;
        this.cY = -1;
        this.da = 0.0f;
        this.f344de = 0;
    }

    public final String toString() {
        return "" + null;
    }
}
