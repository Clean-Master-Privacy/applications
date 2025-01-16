package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;
import java.util.HashSet;

public final class ConstraintAnchor {
    final ConstraintWidget dg;
    final Type dh;
    ConstraintAnchor di;
    private int dj = -1;
    Strength dk = Strength.NONE;
    ConnectionType dl = ConnectionType.RELAXED;
    int dm = 0;

    /* renamed from: do  reason: not valid java name */
    public SolverVariable f0do;
    public int mMargin = 0;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.dg = constraintWidget;
        this.dh = type;
    }

    public final void ac() {
        if (this.f0do == null) {
            this.f0do = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            this.f0do.reset();
        }
    }

    public final int ad() {
        if (this.dg.mVisibility == 8) {
            return 0;
        }
        if (this.dj < 0 || this.di == null || this.di.dg.mVisibility != 8) {
            return this.mMargin;
        }
        return this.dj;
    }

    public final void reset() {
        this.di = null;
        this.mMargin = 0;
        this.dj = -1;
        this.dk = Strength.STRONG;
        this.dm = 0;
        this.dl = ConnectionType.RELAXED;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r4.dg.am() != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0062, code lost:
        if (r10 != android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        r10 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
        if (r10 != android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008a, code lost:
        if (r10 != android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y) goto L_0x003c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0090 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.support.constraint.solver.widgets.ConstraintAnchor r5, int r6, int r7, android.support.constraint.solver.widgets.ConstraintAnchor.Strength r8, int r9, boolean r10) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 != 0) goto L_0x0014
            r5 = 0
            r4.di = r5
            r4.mMargin = r1
            r5 = -1
            r4.dj = r5
            android.support.constraint.solver.widgets.ConstraintAnchor$Strength r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Strength.NONE
            r4.dk = r5
            r5 = 2
            r4.dm = r5
            return r0
        L_0x0014:
            if (r10 != 0) goto L_0x0091
            if (r5 == 0) goto L_0x008d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = r5.dh
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = r4.dh
            if (r10 != r2) goto L_0x003e
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = r4.dh
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            if (r10 == r2) goto L_0x008d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = r4.dh
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE
            if (r10 != r2) goto L_0x003c
            android.support.constraint.solver.widgets.ConstraintWidget r10 = r5.dg
            boolean r10 = r10.am()
            if (r10 == 0) goto L_0x008d
            android.support.constraint.solver.widgets.ConstraintWidget r10 = r4.dg
            boolean r10 = r10.am()
            if (r10 != 0) goto L_0x003c
            goto L_0x008d
        L_0x003c:
            r10 = r0
            goto L_0x008e
        L_0x003e:
            int[] r2 = android.support.constraint.solver.widgets.ConstraintAnchor.AnonymousClass1.dp
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = r4.dh
            int r3 = r3.ordinal()
            r2 = r2[r3]
            switch(r2) {
                case 1: goto L_0x0080;
                case 2: goto L_0x0067;
                case 3: goto L_0x0067;
                case 4: goto L_0x004c;
                case 5: goto L_0x004c;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x008d
        L_0x004c:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r10 == r2) goto L_0x0057
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r10 != r2) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r1
            goto L_0x0058
        L_0x0057:
            r2 = r0
        L_0x0058:
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r5.dg
            boolean r3 = r3 instanceof android.support.constraint.solver.widgets.b
            if (r3 == 0) goto L_0x0065
            if (r2 != 0) goto L_0x003c
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r10 != r2) goto L_0x008d
            goto L_0x003c
        L_0x0065:
            r10 = r2
            goto L_0x008e
        L_0x0067:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r10 == r2) goto L_0x0072
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r10 != r2) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r1
            goto L_0x0073
        L_0x0072:
            r2 = r0
        L_0x0073:
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r5.dg
            boolean r3 = r3 instanceof android.support.constraint.solver.widgets.b
            if (r3 == 0) goto L_0x0065
            if (r2 != 0) goto L_0x003c
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            if (r10 != r2) goto L_0x008d
            goto L_0x003c
        L_0x0080:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE
            if (r10 == r2) goto L_0x008d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            if (r10 == r2) goto L_0x008d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r10 == r2) goto L_0x008d
            goto L_0x003c
        L_0x008d:
            r10 = r1
        L_0x008e:
            if (r10 != 0) goto L_0x0091
            return r1
        L_0x0091:
            r4.di = r5
            if (r6 <= 0) goto L_0x0098
            r4.mMargin = r6
            goto L_0x009a
        L_0x0098:
            r4.mMargin = r1
        L_0x009a:
            r4.dj = r7
            r4.dk = r8
            r4.dm = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintAnchor.a(android.support.constraint.solver.widgets.ConstraintAnchor, int, int, android.support.constraint.solver.widgets.ConstraintAnchor$Strength, int, boolean):boolean");
    }

    public final boolean isConnected() {
        return this.di != null;
    }

    public final String toString() {
        String str;
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        sb.append((String) null);
        sb.append(":");
        sb.append(this.dh.toString());
        if (this.di != null) {
            str = " connected to " + this.di.a(hashSet);
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    private String a(HashSet<ConstraintAnchor> hashSet) {
        String str;
        if (!hashSet.add(this)) {
            return "<-";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((String) null);
        sb.append(":");
        sb.append(this.dh.toString());
        if (this.di != null) {
            str = " connected to " + this.di.a(hashSet);
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
