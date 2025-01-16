package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.b;
import android.support.constraint.solver.c;
import android.support.constraint.solver.e;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public class ConstraintWidget {
    private static float dW = 0.5f;
    public int dA = 0;
    ConstraintAnchor dB = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    ConstraintAnchor dC = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    ConstraintAnchor dD = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor dE = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor dF = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    private ConstraintAnchor dG = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    private ConstraintAnchor dH = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    private ConstraintAnchor dI = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
    protected ArrayList<ConstraintAnchor> dJ = new ArrayList<>();
    ConstraintWidget dK = null;
    protected float dL = 0.0f;
    private int dM = -1;
    private int dN = 0;
    private int dO = 0;
    private int dP = 0;
    int dQ = 0;
    private int dR = 0;
    private int dS = 0;
    public int dT = 0;
    public int dU;
    public int dV;
    public float dX = dW;
    public float dY = dW;
    public DimensionBehaviour dZ = DimensionBehaviour.FIXED;
    public int dt = -1;
    public int du = -1;
    public int dv = 0;
    public int dw = 0;
    public int dx = 0;
    public int dy = 0;
    public int dz = 0;
    public DimensionBehaviour eb = DimensionBehaviour.FIXED;
    public Object ec;
    int ed;
    int ee;
    int ef;
    int eg;
    boolean eh;
    boolean ei;
    boolean ej;
    boolean ek;
    boolean el;
    boolean em;
    public int en = 0;
    public int eo = 0;
    boolean ep;
    boolean eq;
    public float er = 0.0f;
    public float es = 0.0f;
    ConstraintWidget et = null;
    ConstraintWidget eu = null;
    int mHeight = 0;
    protected int mMinHeight;
    protected int mMinWidth;
    public int mVisibility = 0;
    int mWidth = 0;
    protected int mX = 0;
    protected int mY = 0;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void reset() {
        this.dB.reset();
        this.dC.reset();
        this.dD.reset();
        this.dE.reset();
        this.dF.reset();
        this.dG.reset();
        this.dH.reset();
        this.dI.reset();
        this.dK = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.dL = 0.0f;
        this.dM = -1;
        this.mX = 0;
        this.mY = 0;
        this.dN = 0;
        this.dO = 0;
        this.dP = 0;
        this.dQ = 0;
        this.dR = 0;
        this.dS = 0;
        this.dT = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.dU = 0;
        this.dV = 0;
        this.dX = dW;
        this.dY = dW;
        this.dZ = DimensionBehaviour.FIXED;
        this.eb = DimensionBehaviour.FIXED;
        this.ec = null;
        this.mVisibility = 0;
        this.el = false;
        this.em = false;
        this.en = 0;
        this.eo = 0;
        this.ep = false;
        this.eq = false;
        this.er = 0.0f;
        this.es = 0.0f;
        this.dt = -1;
        this.du = -1;
    }

    public ConstraintWidget() {
        this.dJ.add(this.dB);
        this.dJ.add(this.dC);
        this.dJ.add(this.dD);
        this.dJ.add(this.dE);
        this.dJ.add(this.dG);
        this.dJ.add(this.dH);
        this.dJ.add(this.dF);
    }

    public void a(c cVar) {
        this.dB.ac();
        this.dC.ac();
        this.dD.ac();
        this.dE.ac();
        this.dF.ac();
        this.dI.ac();
        this.dG.ac();
        this.dH.ac();
    }

    public final boolean ae() {
        return this.dK == null;
    }

    public final int getVisibility() {
        return this.mVisibility;
    }

    public String toString() {
        return "(" + this.mX + ", " + this.mY + ") - (" + this.mWidth + " x " + this.mHeight + ") wrap: (" + this.dU + " x " + this.dV + ")";
    }

    public final int getX() {
        return this.mX;
    }

    public final int getY() {
        return this.mY;
    }

    public final int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public final int af() {
        int i;
        int i2 = this.mWidth;
        if (this.dZ != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.dv == 1) {
            i = Math.max(this.dx, i2);
        } else if (this.dx > 0) {
            i = this.dx;
            this.mWidth = i;
        } else {
            i = 0;
        }
        return (this.dy <= 0 || this.dy >= i) ? i : this.dy;
    }

    public final int ag() {
        int i;
        int i2 = this.mHeight;
        if (this.eb != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.dw == 1) {
            i = Math.max(this.dz, i2);
        } else if (this.dz > 0) {
            i = this.dz;
            this.mHeight = i;
        } else {
            i = 0;
        }
        return (this.dA <= 0 || this.dA >= i) ? i : this.dA;
    }

    public final int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public final int ah() {
        return this.dN + this.dR;
    }

    public final int ai() {
        return this.dO + this.dS;
    }

    public final int aj() {
        return ah() + this.dP;
    }

    /* access modifiers changed from: protected */
    public final int ak() {
        return this.mX + this.dR;
    }

    /* access modifiers changed from: protected */
    public final int al() {
        return this.mY + this.dS;
    }

    public final boolean am() {
        return this.dT > 0;
    }

    public ArrayList<ConstraintAnchor> an() {
        return this.dJ;
    }

    public final void setX(int i) {
        this.mX = i;
    }

    public final void setY(int i) {
        this.mY = i;
    }

    public final void c(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void d(int i, int i2) {
        this.dR = i;
        this.dS = i2;
    }

    public void ao() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        this.dN = i;
        this.dO = i2;
        this.dP = i3 - i;
        this.dQ = (this.mY + this.mHeight) - i2;
    }

    public final void setWidth(int i) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public final void setHeight(int i) {
        this.mHeight = i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = r4
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = r5
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = r0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.dL = r9
            r8.dM = r1
        L_0x008d:
            return
        L_0x008e:
            r8.dL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.m(java.lang.String):void");
    }

    public final void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public final void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public final void e(int i, int i2) {
        this.mX = i;
        this.mWidth = i2 - i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public final void f(int i, int i2) {
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public final void a(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        a(type).a(constraintWidget.a(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public final void ap() {
        int size = this.dJ.size();
        for (int i = 0; i < size; i++) {
            this.dJ.get(i).reset();
        }
    }

    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.dB;
            case TOP:
                return this.dC;
            case RIGHT:
                return this.dD;
            case BOTTOM:
                return this.dE;
            case BASELINE:
                return this.dF;
            case CENTER_X:
                return this.dG;
            case CENTER_Y:
                return this.dH;
            case CENTER:
                return this.dI;
            default:
                return null;
        }
    }

    public final void a(DimensionBehaviour dimensionBehaviour) {
        this.dZ = dimensionBehaviour;
        if (this.dZ == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.dU);
        }
    }

    public final void b(DimensionBehaviour dimensionBehaviour) {
        this.eb = dimensionBehaviour;
        if (this.eb == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.dV);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:182:0x038f, code lost:
        if (r14 == -1) goto L_0x0393;
     */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x028c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.support.constraint.solver.e r43) {
        /*
            r42 = this;
            r15 = r42
            r14 = r43
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dB
            android.support.constraint.solver.SolverVariable r13 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dD
            android.support.constraint.solver.SolverVariable r12 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dC
            android.support.constraint.solver.SolverVariable r11 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dE
            android.support.constraint.solver.SolverVariable r10 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dF
            android.support.constraint.solver.SolverVariable r9 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.dK
            r8 = 0
            r7 = 1
            if (r0 == 0) goto L_0x018d
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            if (r0 == 0) goto L_0x0038
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dB
            if (r0 == r1) goto L_0x0048
        L_0x0038:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            if (r0 == 0) goto L_0x0051
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dD
            if (r0 != r1) goto L_0x0051
        L_0x0048:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.dK
            android.support.constraint.solver.widgets.a r0 = (android.support.constraint.solver.widgets.a) r0
            r0.a((android.support.constraint.solver.widgets.ConstraintWidget) r15, (int) r8)
            r0 = r7
            goto L_0x0052
        L_0x0051:
            r0 = r8
        L_0x0052:
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            if (r1 == 0) goto L_0x0062
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dC
            if (r1 == r2) goto L_0x0072
        L_0x0062:
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            if (r1 == 0) goto L_0x007b
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dE
            if (r1 != r2) goto L_0x007b
        L_0x0072:
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r15.dK
            android.support.constraint.solver.widgets.a r1 = (android.support.constraint.solver.widgets.a) r1
            r1.a((android.support.constraint.solver.widgets.ConstraintWidget) r15, (int) r7)
            r1 = r7
            goto L_0x007c
        L_0x007b:
            r1 = r8
        L_0x007c:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.dK
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x0102
            if (r0 != 0) goto L_0x0102
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x00ae
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.dK
            if (r2 == r3) goto L_0x0097
            goto L_0x00ae
        L_0x0097:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x00c4
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.dK
            if (r2 != r3) goto L_0x00c4
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor$ConnectionType r3 = android.support.constraint.solver.widgets.ConstraintAnchor.ConnectionType.STRICT
            r2.dl = r3
            goto L_0x00c4
        L_0x00ae:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.dK
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dB
            android.support.constraint.solver.SolverVariable r2 = r14.f(r2)
            android.support.constraint.solver.b r3 = r43.Y()
            android.support.constraint.solver.SolverVariable r4 = r43.Z()
            r3.a(r13, r2, r4, r8)
            r14.b((android.support.constraint.solver.b) r3)
        L_0x00c4:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x00ec
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.dK
            if (r2 == r3) goto L_0x00d5
            goto L_0x00ec
        L_0x00d5:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0102
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.dK
            if (r2 != r3) goto L_0x0102
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor$ConnectionType r3 = android.support.constraint.solver.widgets.ConstraintAnchor.ConnectionType.STRICT
            r2.dl = r3
            goto L_0x0102
        L_0x00ec:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.dK
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dD
            android.support.constraint.solver.SolverVariable r2 = r14.f(r2)
            android.support.constraint.solver.b r3 = r43.Y()
            android.support.constraint.solver.SolverVariable r4 = r43.Z()
            r3.a(r2, r12, r4, r8)
            r14.b((android.support.constraint.solver.b) r3)
        L_0x0102:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.dK
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x0188
            if (r1 != 0) goto L_0x0188
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0134
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.dK
            if (r2 == r3) goto L_0x011d
            goto L_0x0134
        L_0x011d:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x014a
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.dK
            if (r2 != r3) goto L_0x014a
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor$ConnectionType r3 = android.support.constraint.solver.widgets.ConstraintAnchor.ConnectionType.STRICT
            r2.dl = r3
            goto L_0x014a
        L_0x0134:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.dK
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dC
            android.support.constraint.solver.SolverVariable r2 = r14.f(r2)
            android.support.constraint.solver.b r3 = r43.Y()
            android.support.constraint.solver.SolverVariable r4 = r43.Z()
            r3.a(r11, r2, r4, r8)
            r14.b((android.support.constraint.solver.b) r3)
        L_0x014a:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0172
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.dK
            if (r2 == r3) goto L_0x015b
            goto L_0x0172
        L_0x015b:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0188
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.dK
            if (r2 != r3) goto L_0x0188
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor$ConnectionType r3 = android.support.constraint.solver.widgets.ConstraintAnchor.ConnectionType.STRICT
            r2.dl = r3
            goto L_0x0188
        L_0x0172:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.dK
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dE
            android.support.constraint.solver.SolverVariable r2 = r14.f(r2)
            android.support.constraint.solver.b r3 = r43.Y()
            android.support.constraint.solver.SolverVariable r4 = r43.Z()
            r3.a(r2, r10, r4, r8)
            r14.b((android.support.constraint.solver.b) r3)
        L_0x0188:
            r16 = r0
            r17 = r1
            goto L_0x0191
        L_0x018d:
            r16 = r8
            r17 = r16
        L_0x0191:
            int r0 = r15.mWidth
            int r1 = r15.mMinWidth
            if (r0 >= r1) goto L_0x0199
            int r0 = r15.mMinWidth
        L_0x0199:
            int r1 = r15.mHeight
            int r2 = r15.mMinHeight
            if (r1 >= r2) goto L_0x01a1
            int r1 = r15.mMinHeight
        L_0x01a1:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = r15.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 == r3) goto L_0x01a9
            r2 = r7
            goto L_0x01aa
        L_0x01a9:
            r2 = r8
        L_0x01aa:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r15.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r4) goto L_0x01b2
            r3 = r7
            goto L_0x01b3
        L_0x01b2:
            r3 = r8
        L_0x01b3:
            if (r2 != 0) goto L_0x01ca
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dB
            if (r4 == 0) goto L_0x01ca
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dD
            if (r4 == 0) goto L_0x01ca
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x01c9
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 != 0) goto L_0x01ca
        L_0x01c9:
            r2 = r7
        L_0x01ca:
            if (r3 != 0) goto L_0x01f5
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dC
            if (r4 == 0) goto L_0x01f5
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dE
            if (r4 == 0) goto L_0x01f5
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x01e0
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 != 0) goto L_0x01f5
        L_0x01e0:
            int r4 = r15.dT
            if (r4 == 0) goto L_0x01f4
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dF
            if (r4 == 0) goto L_0x01f5
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x01f4
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 != 0) goto L_0x01f5
        L_0x01f4:
            r3 = r7
        L_0x01f5:
            int r4 = r15.dM
            float r5 = r15.dL
            float r6 = r15.dL
            r18 = 0
            int r6 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            r19 = r13
            r13 = -1
            if (r6 <= 0) goto L_0x027f
            int r6 = r15.mVisibility
            r7 = 8
            if (r6 == r7) goto L_0x027f
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r15.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r18 = 1065353216(0x3f800000, float:1.0)
            if (r6 != r7) goto L_0x024b
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r15.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x024b
            if (r2 == 0) goto L_0x0225
            if (r3 != 0) goto L_0x0225
            r21 = r0
            r6 = r1
            r22 = r3
            r23 = r5
            r7 = r8
            goto L_0x0248
        L_0x0225:
            if (r2 != 0) goto L_0x0240
            if (r3 == 0) goto L_0x0240
            int r4 = r15.dM
            if (r4 != r13) goto L_0x0237
            float r18 = r18 / r5
            r21 = r0
            r6 = r1
            r22 = r3
            r23 = r18
            goto L_0x023e
        L_0x0237:
            r21 = r0
            r6 = r1
            r22 = r3
            r23 = r5
        L_0x023e:
            r7 = 1
            goto L_0x0248
        L_0x0240:
            r21 = r0
            r6 = r1
            r22 = r3
            r7 = r4
            r23 = r5
        L_0x0248:
            r18 = 1
            goto L_0x0289
        L_0x024b:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r15.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x0262
            int r0 = r15.mHeight
            float r0 = (float) r0
            float r0 = r0 * r5
            int r0 = (int) r0
            r21 = r0
            r6 = r1
            r22 = r3
            r23 = r5
            r7 = r8
            r18 = r7
            r3 = 1
            goto L_0x028a
        L_0x0262:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r15.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x027f
            int r1 = r15.dM
            if (r1 != r13) goto L_0x026e
            float r5 = r18 / r5
        L_0x026e:
            int r1 = r15.mWidth
            float r1 = (float) r1
            float r1 = r1 * r5
            int r1 = (int) r1
            r21 = r0
            r6 = r1
            r3 = r2
            r23 = r5
            r18 = r8
            r7 = 1
            r22 = 1
            goto L_0x028a
        L_0x027f:
            r21 = r0
            r6 = r1
            r22 = r3
            r7 = r4
            r23 = r5
            r18 = r8
        L_0x0289:
            r3 = r2
        L_0x028a:
            if (r18 == 0) goto L_0x0293
            if (r7 == 0) goto L_0x0290
            if (r7 != r13) goto L_0x0293
        L_0x0290:
            r24 = 1
            goto L_0x0295
        L_0x0293:
            r24 = r8
        L_0x0295:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r15.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r1) goto L_0x02a1
            boolean r0 = r15 instanceof android.support.constraint.solver.widgets.a
            if (r0 == 0) goto L_0x02a1
            r2 = 1
            goto L_0x02a2
        L_0x02a1:
            r2 = r8
        L_0x02a2:
            int r0 = r15.dt
            r5 = 2
            r4 = 3
            if (r0 == r5) goto L_0x0361
            if (r24 == 0) goto L_0x031b
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            if (r0 == 0) goto L_0x031b
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            if (r0 == 0) goto L_0x031b
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dB
            android.support.constraint.solver.SolverVariable r1 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dD
            android.support.constraint.solver.SolverVariable r3 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.SolverVariable r2 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.SolverVariable r0 = r14.f(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.dB
            int r5 = r5.ad()
            r14.a(r1, r2, r5, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.dD
            int r5 = r5.ad()
            int r5 = r5 * r13
            r14.b(r3, r0, r5, r4)
            if (r16 != 0) goto L_0x030a
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.dB
            int r5 = r5.ad()
            float r4 = r15.dX
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r15.dD
            int r8 = r8.ad()
            r16 = r0
            r0 = r43
            r21 = r3
            r3 = r5
            r5 = 3
            r5 = r16
            r28 = r6
            r6 = r21
            r29 = r7
            r7 = r8
            r0.b(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x030e
        L_0x030a:
            r28 = r6
            r29 = r7
        L_0x030e:
            r31 = r9
            r32 = r10
            r33 = r11
            r34 = r12
            r35 = r19
            r27 = 0
            goto L_0x0373
        L_0x031b:
            r28 = r6
            r29 = r7
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.dD
            int r6 = r15.mX
            int r0 = r15.mX
            int r7 = r0 + r21
            int r8 = r15.mMinWidth
            float r1 = r15.dX
            int r0 = r15.dv
            int r14 = r15.dx
            r30 = r14
            int r14 = r15.dy
            r20 = r0
            r0 = r42
            r25 = r1
            r1 = r43
            r26 = r8
            r27 = 0
            r8 = r21
            r31 = r9
            r9 = r26
            r32 = r10
            r10 = r25
            r33 = r11
            r11 = r24
            r34 = r12
            r12 = r16
            r35 = r19
            r13 = r20
            r16 = r14
            r14 = r30
            r15 = r16
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0371
        L_0x0361:
            r28 = r6
            r29 = r7
            r27 = r8
            r31 = r9
            r32 = r10
            r33 = r11
            r34 = r12
            r35 = r19
        L_0x0371:
            r15 = r42
        L_0x0373:
            int r0 = r15.du
            r1 = 2
            if (r0 != r1) goto L_0x0379
            return
        L_0x0379:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r15.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r1) goto L_0x0385
            boolean r0 = r15 instanceof android.support.constraint.solver.widgets.a
            if (r0 == 0) goto L_0x0385
            r2 = 1
            goto L_0x0387
        L_0x0385:
            r2 = r27
        L_0x0387:
            if (r18 == 0) goto L_0x0395
            r14 = r29
            r13 = 1
            if (r14 == r13) goto L_0x0392
            r0 = -1
            if (r14 != r0) goto L_0x0399
            goto L_0x0393
        L_0x0392:
            r0 = -1
        L_0x0393:
            r11 = r13
            goto L_0x039b
        L_0x0395:
            r14 = r29
            r0 = -1
            r13 = 1
        L_0x0399:
            r11 = r27
        L_0x039b:
            int r1 = r15.dT
            if (r1 <= 0) goto L_0x0464
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dE
            int r3 = r15.dT
            r12 = 5
            r4 = r31
            r9 = r33
            r10 = r43
            r10.c(r4, r9, r3, r12)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x03ba
            int r1 = r15.dT
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.dF
            r8 = r1
            r5 = r3
            goto L_0x03bd
        L_0x03ba:
            r5 = r1
            r8 = r28
        L_0x03bd:
            if (r11 == 0) goto L_0x0418
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            if (r1 == 0) goto L_0x0418
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            if (r1 == 0) goto L_0x0418
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.dC
            android.support.constraint.solver.SolverVariable r1 = r10.f(r1)
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dE
            android.support.constraint.solver.SolverVariable r6 = r10.f(r2)
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r15.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.SolverVariable r2 = r10.f(r2)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r5 = r10.f(r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.dC
            int r3 = r3.ad()
            r8 = 3
            r10.a(r1, r2, r3, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.dE
            int r3 = r3.ad()
            int r3 = r3 * r0
            r10.b(r6, r5, r3, r8)
            if (r17 != 0) goto L_0x0410
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dC
            int r3 = r0.ad()
            float r4 = r15.dY
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.dE
            int r7 = r0.ad()
            r0 = r43
            r0.b(r1, r2, r3, r4, r5, r6, r7)
        L_0x0410:
            r41 = r9
            r39 = r14
            r40 = r32
            goto L_0x04f8
        L_0x0418:
            r7 = 3
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.dC
            int r6 = r15.mY
            int r0 = r15.mY
            int r16 = r0 + r8
            int r3 = r15.mMinHeight
            float r1 = r15.dY
            int r0 = r15.dw
            r36 = r14
            int r14 = r15.dz
            r37 = r14
            int r14 = r15.dA
            r19 = r0
            r0 = r42
            r20 = r1
            r1 = r43
            r21 = r3
            r3 = r22
            r7 = r16
            r38 = r9
            r9 = r21
            r10 = r20
            r12 = r17
            r13 = r19
            r16 = r14
            r39 = r36
            r14 = r37
            r15 = r16
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r8 = r28
            r13 = r32
            r14 = r38
            r0 = 5
            r15 = r43
            r15.c(r13, r14, r8, r0)
        L_0x045e:
            r40 = r13
            r41 = r14
            goto L_0x04f8
        L_0x0464:
            r39 = r14
            r8 = r28
            r13 = r32
            r14 = r33
            r15 = r43
            if (r11 == 0) goto L_0x04c6
            r12 = r42
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r12.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            if (r1 == 0) goto L_0x04c4
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r12.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            if (r1 == 0) goto L_0x04c4
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r12.dC
            android.support.constraint.solver.SolverVariable r1 = r15.f(r1)
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r12.dE
            android.support.constraint.solver.SolverVariable r6 = r15.f(r2)
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r12.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.SolverVariable r2 = r15.f(r2)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r12.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r5 = r15.f(r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r12.dC
            int r3 = r3.ad()
            r10 = 3
            r15.a(r1, r2, r3, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r12.dE
            int r3 = r3.ad()
            int r3 = r3 * r0
            r15.b(r6, r5, r3, r10)
            if (r17 != 0) goto L_0x045e
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dC
            int r3 = r0.ad()
            float r4 = r12.dY
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dE
            int r7 = r0.ad()
            r0 = r43
            r0.b(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x045e
        L_0x04c4:
            r10 = 3
            goto L_0x04c9
        L_0x04c6:
            r10 = 3
            r12 = r42
        L_0x04c9:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r12.dE
            int r6 = r12.mY
            int r0 = r12.mY
            int r7 = r0 + r8
            int r9 = r12.mMinHeight
            float r3 = r12.dY
            int r1 = r12.dw
            int r0 = r12.dz
            int r15 = r12.dA
            r16 = r0
            r0 = r42
            r19 = r1
            r1 = r43
            r20 = r3
            r3 = r22
            r10 = r20
            r12 = r17
            r40 = r13
            r13 = r19
            r41 = r14
            r14 = r16
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x04f8:
            if (r18 == 0) goto L_0x0573
            android.support.constraint.solver.b r0 = r43.Y()
            r4 = r39
            if (r4 != 0) goto L_0x0517
            r1 = r0
            r2 = r34
            r3 = r35
            r4 = r40
            r5 = r41
            r6 = r23
            android.support.constraint.solver.b r0 = r1.a(r2, r3, r4, r5, r6)
            r7 = r43
            r7.b((android.support.constraint.solver.b) r0)
            return
        L_0x0517:
            r1 = 1
            r7 = r43
            if (r4 != r1) goto L_0x052f
            r1 = r0
            r2 = r40
            r3 = r41
            r4 = r34
            r5 = r35
            r6 = r23
            android.support.constraint.solver.b r0 = r1.a(r2, r3, r4, r5, r6)
            r7.b((android.support.constraint.solver.b) r0)
            return
        L_0x052f:
            r1 = r42
            int r2 = r1.dx
            if (r2 <= 0) goto L_0x0540
            int r2 = r1.dx
            r4 = r34
            r3 = r35
            r5 = 3
            r7.a(r4, r3, r2, r5)
            goto L_0x0545
        L_0x0540:
            r4 = r34
            r3 = r35
            r5 = 3
        L_0x0545:
            int r2 = r1.dz
            if (r2 <= 0) goto L_0x0553
            int r1 = r1.dz
            r8 = r40
            r6 = r41
            r7.a(r8, r6, r1, r5)
            goto L_0x0557
        L_0x0553:
            r8 = r40
            r6 = r41
        L_0x0557:
            r1 = r0
            r2 = r4
            r4 = r8
            r5 = r6
            r6 = r23
            r1.a(r2, r3, r4, r5, r6)
            android.support.constraint.solver.SolverVariable r1 = r43.aa()
            android.support.constraint.solver.SolverVariable r2 = r43.aa()
            r3 = 4
            r1.cZ = r3
            r2.cZ = r3
            r0.a((android.support.constraint.solver.SolverVariable) r1, (android.support.constraint.solver.SolverVariable) r2)
            r7.b((android.support.constraint.solver.b) r0)
        L_0x0573:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.b(android.support.constraint.solver.e):void");
    }

    private void a(e eVar, boolean z, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7) {
        int i8;
        boolean z5;
        int i9;
        e eVar2 = eVar;
        ConstraintAnchor constraintAnchor3 = constraintAnchor;
        ConstraintAnchor constraintAnchor4 = constraintAnchor2;
        int i10 = i;
        int i11 = i2;
        int i12 = i4;
        int i13 = i6;
        int i14 = i7;
        SolverVariable f2 = eVar2.f(constraintAnchor3);
        SolverVariable f3 = eVar2.f(constraintAnchor4);
        SolverVariable f4 = eVar2.f(constraintAnchor3.di);
        SolverVariable f5 = eVar2.f(constraintAnchor4.di);
        int ad = constraintAnchor.ad();
        int ad2 = constraintAnchor2.ad();
        if (this.mVisibility == 8) {
            z5 = true;
            i8 = 0;
        } else {
            z5 = z2;
            i8 = i3;
        }
        if (f4 == null && f5 == null) {
            eVar2.b(eVar.Y().a(f2, i10));
            if (z3) {
                return;
            }
            if (z) {
                eVar2.b(e.a(eVar2, f3, f2, i12, true));
            } else if (z5) {
                eVar2.b(e.a(eVar2, f3, f2, i8, false));
            } else {
                eVar2.b(eVar.Y().a(f3, i11));
            }
        } else if (f4 != null && f5 == null) {
            eVar2.b(eVar.Y().a(f2, f4, ad));
            if (z) {
                eVar2.b(e.a(eVar2, f3, f2, i12, true));
            } else if (z3) {
            } else {
                if (z5) {
                    eVar2.b(eVar.Y().a(f3, f2, i8));
                } else {
                    eVar2.b(eVar.Y().a(f3, i11));
                }
            }
        } else if (f4 == null && f5 != null) {
            eVar2.b(eVar.Y().a(f3, f5, ad2 * -1));
            if (z) {
                eVar2.b(e.a(eVar2, f3, f2, i12, true));
            } else if (z3) {
            } else {
                if (z5) {
                    eVar2.b(eVar.Y().a(f3, f2, i8));
                } else {
                    eVar2.b(eVar.Y().a(f2, i10));
                }
            }
        } else if (z5) {
            if (z) {
                eVar2.b(e.a(eVar2, f3, f2, i12, true));
            } else {
                eVar2.b(eVar.Y().a(f3, f2, i8));
            }
            if (constraintAnchor3.dk != constraintAnchor4.dk) {
                if (constraintAnchor3.dk == ConstraintAnchor.Strength.STRONG) {
                    eVar2.b(eVar.Y().a(f2, f4, ad));
                    SolverVariable Z = eVar.Z();
                    b Y = eVar.Y();
                    Y.b(f3, f5, Z, ad2 * -1);
                    eVar2.b(Y);
                    return;
                }
                SolverVariable Z2 = eVar.Z();
                b Y2 = eVar.Y();
                Y2.a(f2, f4, Z2, ad);
                eVar2.b(Y2);
                eVar2.b(eVar.Y().a(f3, f5, ad2 * -1));
            } else if (f4 == f5) {
                eVar2.b(e.a(eVar, f2, f4, 0, 0.5f, f5, f3, 0, true));
            } else {
                boolean z6 = false;
                if (!z4) {
                    eVar2.b(e.b(eVar2, f2, f4, ad, constraintAnchor3.dl != ConstraintAnchor.ConnectionType.STRICT));
                    if (constraintAnchor4.dl != ConstraintAnchor.ConnectionType.STRICT) {
                        z6 = true;
                    }
                    eVar2.b(e.c(eVar2, f3, f5, ad2 * -1, z6));
                    eVar2.b(e.a(eVar, f2, f4, ad, f, f5, f3, ad2, false));
                }
            }
        } else if (z3) {
            eVar2.a(f2, f4, ad, 3);
            eVar2.b(f3, f5, ad2 * -1, 3);
            eVar2.b(e.a(eVar, f2, f4, ad, f, f5, f3, ad2, true));
        } else if (!z4) {
            if (i5 == 1) {
                int i15 = i6;
                if (i15 <= i8) {
                    i15 = i8;
                }
                i9 = ad2;
                int i16 = i7;
                if (i16 > 0) {
                    if (i16 < i15) {
                        i15 = i16;
                    } else {
                        eVar2.b(f3, f2, i16, 3);
                    }
                }
                eVar2.c(f3, f2, i15, 3);
            } else {
                i9 = ad2;
                int i17 = i7;
                if (i6 == 0 && i17 == 0) {
                    eVar2.b(eVar.Y().a(f2, f4, ad));
                    eVar2.b(eVar.Y().a(f3, f5, i9 * -1));
                    return;
                } else if (i17 > 0) {
                    eVar2.b(f3, f2, i17, 3);
                }
            }
            eVar2.a(f2, f4, ad, 2);
            eVar2.b(f3, f5, -i9, 2);
            eVar.b(f2, f4, ad, f, f5, f3, i9);
        }
    }

    public void aq() {
        int g = e.g(this.dB);
        int g2 = e.g(this.dC);
        int g3 = e.g(this.dD) - g;
        int g4 = e.g(this.dE) - g2;
        this.mX = g;
        this.mY = g2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.dZ == DimensionBehaviour.FIXED && g3 < this.mWidth) {
            g3 = this.mWidth;
        }
        if (this.eb == DimensionBehaviour.FIXED && g4 < this.mHeight) {
            g4 = this.mHeight;
        }
        this.mWidth = g3;
        this.mHeight = g4;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public final int getRight() {
        return this.mX + this.mWidth;
    }

    public final int getBottom() {
        return this.mY + this.mHeight;
    }
}
