package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.Arrays;

public final class e {
    private static int POOL_SIZE = 1000;
    private int TABLE_SIZE;
    private int cL;
    public d cM;
    private int cN;
    public b[] cO;
    private boolean[] cP;
    int cQ;
    public int cR;
    private int cS;
    private SolverVariable[] cT;
    private int cU;
    private b[] cV;
    public final c cv;

    public e() {
        this.cL = 0;
        this.cM = new d();
        this.TABLE_SIZE = 32;
        this.cN = this.TABLE_SIZE;
        this.cO = null;
        this.cP = new boolean[this.TABLE_SIZE];
        this.cQ = 1;
        this.cR = 0;
        this.cS = this.TABLE_SIZE;
        this.cT = new SolverVariable[POOL_SIZE];
        this.cU = 0;
        this.cV = new b[this.TABLE_SIZE];
        this.cO = new b[this.TABLE_SIZE];
        X();
        this.cv = new c();
    }

    private void W() {
        this.TABLE_SIZE <<= 1;
        this.cO = (b[]) Arrays.copyOf(this.cO, this.TABLE_SIZE);
        this.cv.cJ = (SolverVariable[]) Arrays.copyOf(this.cv.cJ, this.TABLE_SIZE);
        this.cP = new boolean[this.TABLE_SIZE];
        this.cN = this.TABLE_SIZE;
        this.cS = this.TABLE_SIZE;
        this.cM.cK.clear();
    }

    private void X() {
        for (int i = 0; i < this.cO.length; i++) {
            b bVar = this.cO[i];
            if (bVar != null) {
                this.cv.cH.release(bVar);
            }
            this.cO[i] = null;
        }
    }

    public final void reset() {
        for (SolverVariable solverVariable : this.cv.cJ) {
            if (solverVariable != null) {
                solverVariable.reset();
            }
        }
        this.cv.cI.b(this.cT, this.cU);
        this.cU = 0;
        Arrays.fill(this.cv.cJ, (Object) null);
        this.cL = 0;
        this.cM.cK.clear();
        this.cQ = 1;
        X();
        this.cR = 0;
    }

    public final SolverVariable f(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.cQ + 1 >= this.cN) {
            W();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.f0do;
            if (solverVariable == null) {
                constraintAnchor.ac();
                solverVariable = constraintAnchor.f0do;
            }
            if (solverVariable.id == -1 || solverVariable.id > this.cL || this.cv.cJ[solverVariable.id] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                this.cL++;
                this.cQ++;
                solverVariable.id = this.cL;
                solverVariable.dc = SolverVariable.Type.UNRESTRICTED;
                this.cv.cJ[this.cL] = solverVariable;
            }
        }
        return solverVariable;
    }

    public final b Y() {
        b acquire = this.cv.cH.acquire();
        if (acquire == null) {
            return new b(this.cv);
        }
        acquire.cD = null;
        a aVar = acquire.cF;
        aVar.cA = -1;
        aVar.cB = -1;
        aVar.cC = false;
        aVar.ct = 0;
        acquire.cE = 0.0f;
        acquire.cG = false;
        return acquire;
    }

    public final SolverVariable Z() {
        if (this.cQ + 1 >= this.cN) {
            W();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK);
        this.cL++;
        this.cQ++;
        a2.id = this.cL;
        this.cv.cJ[this.cL] = a2;
        return a2;
    }

    private void a(b bVar, int i) {
        bVar.cF.a(aa(), (float) i);
    }

    public final SolverVariable aa() {
        if (this.cQ + 1 >= this.cN) {
            W();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR);
        this.cL++;
        this.cQ++;
        a2.id = this.cL;
        this.cv.cJ[this.cL] = a2;
        return a2;
    }

    private SolverVariable a(SolverVariable.Type type) {
        SolverVariable acquire = this.cv.cI.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type);
        } else {
            acquire.reset();
            acquire.dc = type;
        }
        if (this.cU >= POOL_SIZE) {
            POOL_SIZE <<= 1;
            this.cT = (SolverVariable[]) Arrays.copyOf(this.cT, POOL_SIZE);
        }
        SolverVariable[] solverVariableArr = this.cT;
        int i = this.cU;
        this.cU = i + 1;
        solverVariableArr[i] = acquire;
        return acquire;
    }

    public static int g(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).f0do;
        if (solverVariable != null) {
            return (int) (solverVariable.da + 0.5f);
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x010b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.support.constraint.solver.b r14) {
        /*
            r13 = this;
            if (r14 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r13.cR
            r1 = 1
            int r0 = r0 + r1
            int r2 = r13.cS
            if (r0 >= r2) goto L_0x0012
            int r0 = r13.cQ
            int r0 = r0 + r1
            int r2 = r13.cN
            if (r0 < r2) goto L_0x0015
        L_0x0012:
            r13.W()
        L_0x0015:
            boolean r0 = r14.cG
            r2 = 0
            if (r0 != 0) goto L_0x013b
            int r0 = r13.cR
            r3 = -1
            if (r0 <= 0) goto L_0x008c
            android.support.constraint.solver.a r0 = r14.cF
            android.support.constraint.solver.b[] r4 = r13.cO
            int r5 = r0.cA
        L_0x0025:
            r6 = r2
        L_0x0026:
            if (r5 == r3) goto L_0x0084
            int r7 = r0.ct
            if (r6 >= r7) goto L_0x0084
            android.support.constraint.solver.c r7 = r0.cv
            android.support.constraint.solver.SolverVariable[] r7 = r7.cJ
            int[] r8 = r0.cx
            r8 = r8[r5]
            r7 = r7[r8]
            int r8 = r7.cY
            if (r8 == r3) goto L_0x007d
            float[] r6 = r0.cz
            r5 = r6[r5]
            r0.a(r7)
            int r6 = r7.cY
            r6 = r4[r6]
            boolean r7 = r6.cG
            if (r7 != 0) goto L_0x006d
            android.support.constraint.solver.a r7 = r6.cF
            int r8 = r7.cA
            r9 = r2
        L_0x004e:
            if (r8 == r3) goto L_0x006d
            int r10 = r7.ct
            if (r9 >= r10) goto L_0x006d
            android.support.constraint.solver.c r10 = r0.cv
            android.support.constraint.solver.SolverVariable[] r10 = r10.cJ
            int[] r11 = r7.cx
            r11 = r11[r8]
            r10 = r10[r11]
            float[] r11 = r7.cz
            r11 = r11[r8]
            float r11 = r11 * r5
            r0.b(r10, r11)
            int[] r10 = r7.cy
            r8 = r10[r8]
            int r9 = r9 + 1
            goto L_0x004e
        L_0x006d:
            float r7 = r14.cE
            float r8 = r6.cE
            float r8 = r8 * r5
            float r7 = r7 + r8
            r14.cE = r7
            android.support.constraint.solver.SolverVariable r5 = r6.cD
            r5.c(r14)
            int r5 = r0.cA
            goto L_0x0025
        L_0x007d:
            int[] r7 = r0.cy
            r5 = r7[r5]
            int r6 = r6 + 1
            goto L_0x0026
        L_0x0084:
            android.support.constraint.solver.a r0 = r14.cF
            int r0 = r0.ct
            if (r0 != 0) goto L_0x008c
            r14.cG = r1
        L_0x008c:
            float r0 = r14.cE
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b1
            float r0 = r14.cE
            float r0 = -r0
            r14.cE = r0
            android.support.constraint.solver.a r0 = r14.cF
            int r5 = r0.cA
            r6 = r2
        L_0x009d:
            if (r5 == r3) goto L_0x00b1
            int r7 = r0.ct
            if (r6 >= r7) goto L_0x00b1
            float[] r7 = r0.cz
            r8 = r7[r5]
            float r8 = -r8
            r7[r5] = r8
            int[] r7 = r0.cy
            r5 = r7[r5]
            int r6 = r6 + 1
            goto L_0x009d
        L_0x00b1:
            android.support.constraint.solver.a r0 = r14.cF
            int r5 = r0.cA
            r6 = 0
            r7 = r6
            r8 = r7
            r6 = r2
        L_0x00b9:
            if (r5 == r3) goto L_0x0112
            int r9 = r0.ct
            if (r6 >= r9) goto L_0x0112
            float[] r9 = r0.cz
            r9 = r9[r5]
            int r10 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r10 >= 0) goto L_0x00d4
            r10 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x00e0
            float[] r9 = r0.cz
            r9[r5] = r4
        L_0x00d2:
            r9 = r4
            goto L_0x00e0
        L_0x00d4:
            r10 = 981668463(0x3a83126f, float:0.001)
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x00e0
            float[] r9 = r0.cz
            r9[r5] = r4
            goto L_0x00d2
        L_0x00e0:
            int r10 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x010b
            android.support.constraint.solver.c r10 = r0.cv
            android.support.constraint.solver.SolverVariable[] r10 = r10.cJ
            int[] r11 = r0.cx
            r11 = r11[r5]
            r10 = r10[r11]
            android.support.constraint.solver.SolverVariable$Type r11 = r10.dc
            android.support.constraint.solver.SolverVariable$Type r12 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED
            if (r11 != r12) goto L_0x00fe
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 >= 0) goto L_0x00fa
            r7 = r10
            goto L_0x0116
        L_0x00fa:
            if (r7 != 0) goto L_0x010b
            r7 = r10
            goto L_0x010b
        L_0x00fe:
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 >= 0) goto L_0x010b
            if (r8 == 0) goto L_0x010a
            int r9 = r10.cZ
            int r11 = r8.cZ
            if (r9 >= r11) goto L_0x010b
        L_0x010a:
            r8 = r10
        L_0x010b:
            int[] r9 = r0.cy
            r5 = r9[r5]
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x0112:
            if (r7 == 0) goto L_0x0115
            goto L_0x0116
        L_0x0115:
            r7 = r8
        L_0x0116:
            if (r7 == 0) goto L_0x011b
            r14.c(r7)
        L_0x011b:
            android.support.constraint.solver.a r0 = r14.cF
            int r0 = r0.ct
            if (r0 != 0) goto L_0x0123
            r14.cG = r1
        L_0x0123:
            android.support.constraint.solver.SolverVariable r0 = r14.cD
            if (r0 == 0) goto L_0x0137
            android.support.constraint.solver.SolverVariable r0 = r14.cD
            android.support.constraint.solver.SolverVariable$Type r0 = r0.dc
            android.support.constraint.solver.SolverVariable$Type r3 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED
            if (r0 == r3) goto L_0x0135
            float r0 = r14.cE
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0137
        L_0x0135:
            r0 = r1
            goto L_0x0138
        L_0x0137:
            r0 = r2
        L_0x0138:
            if (r0 != 0) goto L_0x013b
            return
        L_0x013b:
            android.support.constraint.solver.b[] r0 = r13.cO
            int r3 = r13.cR
            r0 = r0[r3]
            if (r0 == 0) goto L_0x0150
            android.support.constraint.solver.c r0 = r13.cv
            android.support.constraint.solver.f$a<android.support.constraint.solver.b> r0 = r0.cH
            android.support.constraint.solver.b[] r3 = r13.cO
            int r4 = r13.cR
            r3 = r3[r4]
            r0.release(r3)
        L_0x0150:
            boolean r0 = r14.cG
            if (r0 != 0) goto L_0x0157
            r14.V()
        L_0x0157:
            android.support.constraint.solver.b[] r0 = r13.cO
            int r3 = r13.cR
            r0[r3] = r14
            android.support.constraint.solver.SolverVariable r0 = r14.cD
            int r3 = r13.cR
            r0.cY = r3
            int r0 = r13.cR
            int r0 = r0 + r1
            r13.cR = r0
            android.support.constraint.solver.SolverVariable r0 = r14.cD
            int r0 = r0.f344de
            if (r0 <= 0) goto L_0x019d
        L_0x016e:
            android.support.constraint.solver.b[] r3 = r13.cV
            int r3 = r3.length
            if (r3 >= r0) goto L_0x017c
            android.support.constraint.solver.b[] r3 = r13.cV
            int r3 = r3.length
            int r3 = r3 << r1
            android.support.constraint.solver.b[] r3 = new android.support.constraint.solver.b[r3]
            r13.cV = r3
            goto L_0x016e
        L_0x017c:
            android.support.constraint.solver.b[] r13 = r13.cV
            r1 = r2
        L_0x017f:
            if (r1 >= r0) goto L_0x018c
            android.support.constraint.solver.SolverVariable r3 = r14.cD
            android.support.constraint.solver.b[] r3 = r3.dd
            r3 = r3[r1]
            r13[r1] = r3
            int r1 = r1 + 1
            goto L_0x017f
        L_0x018c:
            if (r2 >= r0) goto L_0x019d
            r1 = r13[r2]
            if (r1 == r14) goto L_0x019a
            android.support.constraint.solver.a r3 = r1.cF
            r3.a((android.support.constraint.solver.b) r1, (android.support.constraint.solver.b) r14)
            r1.V()
        L_0x019a:
            int r2 = r2 + 1
            goto L_0x018c
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.e.b(android.support.constraint.solver.b):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(android.support.constraint.solver.d r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = 0
            r0 = r3
        L_0x0006:
            int r4 = r1.cQ
            if (r0 >= r4) goto L_0x0011
            boolean[] r4 = r1.cP
            r4[r0] = r3
            int r0 = r0 + 1
            goto L_0x0006
        L_0x0011:
            r4 = 1
            r0 = r3
            r5 = r0
            r6 = r5
        L_0x0015:
            if (r0 != 0) goto L_0x00fb
            int r5 = r5 + 1
            java.util.ArrayList<android.support.constraint.solver.SolverVariable> r7 = r2.cK
            int r7 = r7.size()
            r8 = 0
            r9 = r3
            r11 = r9
            r10 = r8
        L_0x0023:
            r12 = 0
            if (r9 >= r7) goto L_0x004d
            java.util.ArrayList<android.support.constraint.solver.SolverVariable> r13 = r2.cK
            java.lang.Object r13 = r13.get(r9)
            android.support.constraint.solver.SolverVariable r13 = (android.support.constraint.solver.SolverVariable) r13
            r14 = 5
        L_0x002f:
            if (r14 < 0) goto L_0x004a
            float[] r15 = r13.db
            r15 = r15[r14]
            if (r10 != 0) goto L_0x003f
            int r16 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
            if (r16 >= 0) goto L_0x003f
            if (r14 < r11) goto L_0x003f
            r10 = r13
            r11 = r14
        L_0x003f:
            int r15 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x0047
            if (r14 <= r11) goto L_0x0047
            r10 = r8
            r11 = r14
        L_0x0047:
            int r14 = r14 + -1
            goto L_0x002f
        L_0x004a:
            int r9 = r9 + 1
            goto L_0x0023
        L_0x004d:
            if (r10 == 0) goto L_0x0069
            boolean[] r7 = r1.cP
            int r9 = r10.id
            boolean r7 = r7[r9]
            if (r7 == 0) goto L_0x005a
            r7 = r6
            r10 = r8
            goto L_0x006a
        L_0x005a:
            boolean[] r7 = r1.cP
            int r8 = r10.id
            r7[r8] = r4
            int r6 = r6 + 1
            int r7 = r1.cQ
            if (r6 < r7) goto L_0x0069
            r7 = r6
            r6 = r4
            goto L_0x006b
        L_0x0069:
            r7 = r6
        L_0x006a:
            r6 = r0
        L_0x006b:
            if (r10 == 0) goto L_0x00f6
            r0 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r8 = -1
            r11 = r0
            r0 = r3
            r9 = r8
        L_0x0074:
            int r13 = r1.cR
            if (r0 >= r13) goto L_0x00c2
            android.support.constraint.solver.b[] r13 = r1.cO
            r13 = r13[r0]
            android.support.constraint.solver.SolverVariable r14 = r13.cD
            android.support.constraint.solver.SolverVariable$Type r14 = r14.dc
            android.support.constraint.solver.SolverVariable$Type r15 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED
            if (r14 == r15) goto L_0x00bc
            android.support.constraint.solver.a r14 = r13.cF
            int r15 = r14.cA
            if (r15 == r8) goto L_0x00a5
            int r15 = r14.cA
        L_0x008c:
            if (r15 == r8) goto L_0x00a5
            int r4 = r14.ct
            if (r3 >= r4) goto L_0x00a5
            int[] r4 = r14.cx
            r4 = r4[r15]
            int r8 = r10.id
            if (r4 != r8) goto L_0x009c
            r3 = 1
            goto L_0x00a6
        L_0x009c:
            int[] r4 = r14.cy
            r15 = r4[r15]
            int r3 = r3 + 1
            r4 = 1
            r8 = -1
            goto L_0x008c
        L_0x00a5:
            r3 = 0
        L_0x00a6:
            if (r3 == 0) goto L_0x00bc
            android.support.constraint.solver.a r3 = r13.cF
            float r3 = r3.b(r10)
            int r4 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r4 >= 0) goto L_0x00bc
            float r4 = r13.cE
            float r4 = -r4
            float r4 = r4 / r3
            int r3 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x00bc
            r9 = r0
            r11 = r4
        L_0x00bc:
            int r0 = r0 + 1
            r3 = 0
            r4 = 1
            r8 = -1
            goto L_0x0074
        L_0x00c2:
            if (r9 < 0) goto L_0x00f2
            android.support.constraint.solver.b[] r0 = r1.cO
            r0 = r0[r9]
            android.support.constraint.solver.SolverVariable r3 = r0.cD
            r4 = -1
            r3.cY = r4
            r0.c(r10)
            android.support.constraint.solver.SolverVariable r3 = r0.cD
            r3.cY = r9
            r3 = 0
        L_0x00d5:
            int r4 = r1.cR
            if (r3 >= r4) goto L_0x00e3
            android.support.constraint.solver.b[] r4 = r1.cO
            r4 = r4[r3]
            r4.a(r0)
            int r3 = r3 + 1
            goto L_0x00d5
        L_0x00e3:
            r2.a(r1)
            r17.b((android.support.constraint.solver.d) r18)     // Catch:{ Exception -> 0x00ea }
            goto L_0x00ef
        L_0x00ea:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x00ef:
            r0 = r6
            r6 = r7
            goto L_0x00f4
        L_0x00f2:
            r6 = r7
            r0 = 1
        L_0x00f4:
            r3 = 0
            goto L_0x00f8
        L_0x00f6:
            r6 = r7
            r0 = 1
        L_0x00f8:
            r4 = 1
            goto L_0x0015
        L_0x00fb:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.e.a(android.support.constraint.solver.d):int");
    }

    public final int b(d dVar) throws Exception {
        boolean z;
        int i;
        int i2 = 0;
        while (true) {
            if (i2 < this.cR) {
                if (this.cO[i2].cD.dc != SolverVariable.Type.UNRESTRICTED && this.cO[i2].cE < 0.0f) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            boolean z2 = false;
            i = 0;
            while (!z2) {
                i++;
                float f = Float.MAX_VALUE;
                int i3 = -1;
                int i4 = -1;
                int i5 = 0;
                for (int i6 = 0; i6 < this.cR; i6++) {
                    b bVar = this.cO[i6];
                    if (bVar.cD.dc != SolverVariable.Type.UNRESTRICTED && bVar.cE < 0.0f) {
                        int i7 = i5;
                        float f2 = f;
                        int i8 = i4;
                        int i9 = i3;
                        for (int i10 = 1; i10 < this.cQ; i10++) {
                            SolverVariable solverVariable = this.cv.cJ[i10];
                            float b2 = bVar.cF.b(solverVariable);
                            if (b2 > 0.0f) {
                                int i11 = i7;
                                float f3 = f2;
                                int i12 = i8;
                                int i13 = i9;
                                for (int i14 = 0; i14 < 6; i14++) {
                                    float f4 = solverVariable.db[i14] / b2;
                                    if ((f4 < f3 && i14 == i11) || i14 > i11) {
                                        f3 = f4;
                                        i13 = i6;
                                        i12 = i10;
                                        i11 = i14;
                                    }
                                }
                                i9 = i13;
                                i8 = i12;
                                f2 = f3;
                                i7 = i11;
                            }
                        }
                        i3 = i9;
                        i4 = i8;
                        f = f2;
                        i5 = i7;
                    }
                }
                if (i3 != -1) {
                    b bVar2 = this.cO[i3];
                    bVar2.cD.cY = -1;
                    bVar2.c(this.cv.cJ[i4]);
                    bVar2.cD.cY = i3;
                    for (int i15 = 0; i15 < this.cR; i15++) {
                        this.cO[i15].a(bVar2);
                    }
                    dVar.a(this);
                } else {
                    d dVar2 = dVar;
                    z2 = true;
                }
            }
        } else {
            i = 0;
        }
        int i16 = 0;
        while (i16 < this.cR && (this.cO[i16].cD.dc == SolverVariable.Type.UNRESTRICTED || this.cO[i16].cE >= 0.0f)) {
            i16++;
        }
        return i;
    }

    public final void a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b Y = Y();
        SolverVariable Z = Z();
        Z.cZ = i2;
        Y.a(solverVariable, solverVariable2, Z, i);
        b(Y);
    }

    public final void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b Y = Y();
        SolverVariable Z = Z();
        Z.cZ = i2;
        Y.b(solverVariable, solverVariable2, Z, i);
        b(Y);
    }

    public final void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        b Y = Y();
        Y.a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        SolverVariable aa = aa();
        SolverVariable aa2 = aa();
        aa.cZ = 4;
        aa2.cZ = 4;
        Y.a(aa, aa2);
        b(Y);
    }

    public final b c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b Y = Y();
        Y.a(solverVariable, solverVariable2, i);
        SolverVariable aa = aa();
        SolverVariable aa2 = aa();
        aa.cZ = i2;
        aa2.cZ = i2;
        Y.a(aa, aa2);
        b(Y);
        return Y;
    }

    public final void b(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.cY;
        if (solverVariable.cY != -1) {
            b bVar = this.cO[i2];
            if (bVar.cG) {
                bVar.cE = (float) i;
                return;
            }
            b Y = Y();
            Y.a(solverVariable, i);
            b(Y);
            return;
        }
        b Y2 = Y();
        Y2.cD = solverVariable;
        float f = (float) i;
        solverVariable.da = f;
        Y2.cE = f;
        Y2.cG = true;
        b(Y2);
    }

    public static b a(e eVar, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        b Y = eVar.Y();
        Y.a(solverVariable, solverVariable2, i);
        if (z) {
            eVar.a(Y, 1);
        }
        return Y;
    }

    public static b a(e eVar, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        b Y = eVar.Y();
        Y.cF.a(solverVariable, -1.0f);
        Y.cF.a(solverVariable2, 1.0f - f);
        Y.cF.a(solverVariable3, f);
        return Y;
    }

    public static b b(e eVar, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable Z = eVar.Z();
        b Y = eVar.Y();
        Y.a(solverVariable, solverVariable2, Z, i);
        if (z) {
            eVar.a(Y, (int) (Y.cF.b(Z) * -1.0f));
        }
        return Y;
    }

    public static b c(e eVar, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable Z = eVar.Z();
        b Y = eVar.Y();
        Y.b(solverVariable, solverVariable2, Z, i);
        if (z) {
            eVar.a(Y, (int) (Y.cF.b(Z) * -1.0f));
        }
        return Y;
    }

    public static b a(e eVar, SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, boolean z) {
        b Y = eVar.Y();
        Y.a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (z) {
            SolverVariable aa = eVar.aa();
            SolverVariable aa2 = eVar.aa();
            aa.cZ = 4;
            aa2.cZ = 4;
            Y.a(aa, aa2);
        }
        return Y;
    }
}
