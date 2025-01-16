package android.support.constraint.solver.widgets;

import android.support.constraint.solver.e;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.Arrays;

public final class a extends e {
    public int bb = 2;
    private int dU;
    private int dV;
    private ConstraintWidget[] eA = new ConstraintWidget[4];
    private ConstraintWidget[] eB = new ConstraintWidget[4];
    private ConstraintWidget[] eC = new ConstraintWidget[4];
    private boolean[] eD = new boolean[3];
    private ConstraintWidget[] eE = new ConstraintWidget[4];
    public boolean eF = false;
    public boolean eG = false;
    private e ew = new e();
    private d ex;
    private int ey = 0;
    private int ez = 0;

    public final void reset() {
        this.ew.reset();
        super.reset();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:222:0x073b, code lost:
        if (r5.dt == -1) goto L_0x073f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:553:0x0e68  */
    /* JADX WARNING: Removed duplicated region for block: B:617:0x0e6a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(android.support.constraint.solver.e r39) {
        /*
            r38 = this;
            r6 = r38
            r15 = r39
            r38.b((android.support.constraint.solver.e) r39)
            java.util.ArrayList r0 = r6.mChildren
            int r0 = r0.size()
            int r1 = r6.bb
            r16 = 1056964608(0x3f000000, float:0.5)
            r13 = 2
            r11 = 1
            if (r1 == r13) goto L_0x001a
            int r1 = r6.bb
            r2 = 4
            if (r1 != r2) goto L_0x075a
        L_0x001a:
            java.util.ArrayList r1 = r6.mChildren
            int r1 = r1.size()
            r2 = 0
        L_0x0021:
            r3 = -1
            if (r2 >= r1) goto L_0x0043
            java.util.ArrayList r4 = r6.mChildren
            java.lang.Object r4 = r4.get(r2)
            android.support.constraint.solver.widgets.ConstraintWidget r4 = (android.support.constraint.solver.widgets.ConstraintWidget) r4
            r4.dt = r3
            r4.du = r3
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r4.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r5) goto L_0x003c
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r4.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r5) goto L_0x0040
        L_0x003c:
            r4.dt = r11
            r4.du = r11
        L_0x0040:
            int r2 = r2 + 1
            goto L_0x0021
        L_0x0043:
            r2 = 0
            r4 = 0
            r5 = 0
        L_0x0046:
            if (r2 != 0) goto L_0x0726
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x004b:
            if (r7 >= r1) goto L_0x0713
            java.util.ArrayList r10 = r6.mChildren
            java.lang.Object r10 = r10.get(r7)
            android.support.constraint.solver.widgets.ConstraintWidget r10 = (android.support.constraint.solver.widgets.ConstraintWidget) r10
            int r14 = r10.dt
            if (r14 != r3) goto L_0x0304
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = r6.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r14 != r12) goto L_0x0063
            r10.dt = r11
            goto L_0x0304
        L_0x0063:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = r10.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r14) goto L_0x006d
            r10.dt = r11
            goto L_0x0304
        L_0x006d:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = r6.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r14) goto L_0x00af
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = r10.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r12 != r14) goto L_0x00af
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dB
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dD
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            int r12 = r12.mMargin
            int r14 = r38.getWidth()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            int r3 = r3.mMargin
            int r14 = r14 - r3
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            r15.b(r3, r12)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            r15.b(r3, r14)
            r10.e(r12, r14)
            r10.dt = r13
            goto L_0x0304
        L_0x00af:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0129
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0129
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r6) goto L_0x0124
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r6) goto L_0x0124
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            int r3 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            int r12 = r12.ad()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = r6.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r14 != r11) goto L_0x00e3
            int r11 = r38.getWidth()
            int r11 = r11 - r12
            goto L_0x00fb
        L_0x00e3:
            int r11 = r10.getWidth()
            int r14 = r38.getWidth()
            int r14 = r14 - r3
            int r14 = r14 - r12
            int r14 = r14 - r11
            float r11 = (float) r14
            float r12 = r10.dX
            float r11 = r11 * r12
            float r11 = r11 + r16
            int r11 = (int) r11
            int r3 = r3 + r11
            int r11 = r10.getWidth()
            int r11 = r11 + r3
        L_0x00fb:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dB
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dD
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            r10.dt = r13
            r10.e(r3, r11)
            goto L_0x0304
        L_0x0124:
            r3 = r11
            r10.dt = r3
            goto L_0x0304
        L_0x0129:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x016b
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r6) goto L_0x016b
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            int r3 = r3.ad()
            int r11 = r10.getWidth()
            int r11 = r11 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dB
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dD
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            r10.dt = r13
            r10.e(r3, r11)
            goto L_0x0304
        L_0x016b:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x01b3
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r6) goto L_0x01b3
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dB
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            int r3 = r38.getWidth()
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            int r11 = r11.ad()
            int r3 = r3 - r11
            int r11 = r10.getWidth()
            int r11 = r3 - r11
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            r10.dt = r13
            r10.e(r11, r3)
            goto L_0x0304
        L_0x01b3:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0204
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            int r3 = r3.dt
            if (r3 != r13) goto L_0x0204
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            float r3 = r3.da
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dB
            int r11 = r11.ad()
            float r11 = (float) r11
            float r3 = r3 + r11
            float r3 = r3 + r16
            int r3 = (int) r3
            int r11 = r10.getWidth()
            int r11 = r11 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            r10.dt = r13
            r10.e(r3, r11)
            goto L_0x0304
        L_0x0204:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0256
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            int r3 = r3.dt
            if (r3 != r13) goto L_0x0256
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            float r3 = r3.da
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            int r11 = r11.ad()
            float r11 = (float) r11
            float r3 = r3 - r11
            float r3 = r3 + r16
            int r3 = (int) r3
            int r11 = r10.getWidth()
            int r11 = r3 - r11
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            r10.dt = r13
            r10.e(r11, r3)
            goto L_0x0304
        L_0x0256:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x025e
            r3 = 1
            goto L_0x025f
        L_0x025e:
            r3 = 0
        L_0x025f:
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            if (r11 == 0) goto L_0x0267
            r11 = 1
            goto L_0x0268
        L_0x0267:
            r11 = 0
        L_0x0268:
            if (r3 != 0) goto L_0x0304
            if (r11 != 0) goto L_0x0304
            boolean r3 = r10 instanceof android.support.constraint.solver.widgets.b
            if (r3 == 0) goto L_0x02d7
            r3 = r10
            android.support.constraint.solver.widgets.b r3 = (android.support.constraint.solver.widgets.b) r3
            int r11 = r3.getOrientation()
            r12 = 1
            if (r11 != r12) goto L_0x0304
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dD
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            int r11 = r3.at()
            r12 = -1
            if (r11 == r12) goto L_0x029b
            int r3 = r3.at()
            float r3 = (float) r3
            goto L_0x02b6
        L_0x029b:
            int r11 = r3.au()
            if (r11 == r12) goto L_0x02ac
            int r11 = r38.getWidth()
            int r3 = r3.au()
            int r11 = r11 - r3
            float r3 = (float) r11
            goto L_0x02b6
        L_0x02ac:
            int r11 = r38.getWidth()
            float r11 = (float) r11
            float r3 = r3.as()
            float r3 = r3 * r11
        L_0x02b6:
            float r3 = r3 + r16
            int r3 = (int) r3
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dB
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            r15.b(r11, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            r15.b(r11, r3)
            r10.dt = r13
            r10.du = r13
            r10.e(r3, r3)
            int r3 = r38.getHeight()
            r11 = 0
            r10.f(r11, r3)
            goto L_0x0304
        L_0x02d7:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dB
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dD
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            int r3 = r10.getX()
            int r11 = r10.getWidth()
            int r11 = r11 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dB
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dD
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            r15.b(r3, r11)
            r10.dt = r13
        L_0x0304:
            int r3 = r10.du
            r11 = -1
            if (r3 != r11) goto L_0x0700
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r6.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r11) goto L_0x0314
            r3 = 1
            r10.du = r3
            goto L_0x0700
        L_0x0314:
            r3 = 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r10.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x031f
            r10.du = r3
            goto L_0x0700
        L_0x031f:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r6.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 == r11) goto L_0x037f
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r10.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r3 != r11) goto L_0x037f
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            int r3 = r3.mMargin
            int r11 = r38.getHeight()
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            int r12 = r12.mMargin
            int r11 = r11 - r12
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            int r12 = r10.dT
            if (r12 > 0) goto L_0x0366
            int r12 = r10.getVisibility()
            r14 = 8
            if (r12 != r14) goto L_0x037a
        L_0x0366:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dF
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            int r14 = r10.dT
            int r14 = r14 + r3
            r15.b(r12, r14)
        L_0x037a:
            r10.f(r3, r11)
            goto L_0x06fe
        L_0x037f:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x041a
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x041a
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r6) goto L_0x0415
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r6) goto L_0x0415
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            int r3 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            int r11 = r11.ad()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = r6.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r14) goto L_0x03b3
            int r11 = r10.getHeight()
            int r11 = r11 + r3
            goto L_0x03cc
        L_0x03b3:
            int r12 = r10.getHeight()
            int r14 = r38.getHeight()
            int r14 = r14 - r3
            int r14 = r14 - r11
            int r14 = r14 - r12
            float r3 = (float) r3
            float r11 = (float) r14
            float r12 = r10.dY
            float r11 = r11 * r12
            float r3 = r3 + r11
            float r3 = r3 + r16
            int r3 = (int) r3
            int r11 = r10.getHeight()
            int r11 = r11 + r3
        L_0x03cc:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dC
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dE
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            int r12 = r10.dT
            if (r12 > 0) goto L_0x03fa
            int r12 = r10.getVisibility()
            r14 = 8
            if (r12 != r14) goto L_0x040e
        L_0x03fa:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dF
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            int r14 = r10.dT
            int r14 = r14 + r3
            r15.b(r12, r14)
        L_0x040e:
            r10.du = r13
            r10.f(r3, r11)
            goto L_0x0700
        L_0x0415:
            r3 = 1
            r10.du = r3
            goto L_0x0700
        L_0x041a:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x047c
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r6) goto L_0x047c
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            int r3 = r3.ad()
            int r11 = r10.getHeight()
            int r11 = r11 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dC
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dE
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            int r12 = r10.dT
            if (r12 > 0) goto L_0x0461
            int r12 = r10.getVisibility()
            r14 = 8
            if (r12 != r14) goto L_0x0475
        L_0x0461:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dF
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            int r14 = r10.dT
            int r14 = r14 + r3
            r15.b(r12, r14)
        L_0x0475:
            r10.du = r13
            r10.f(r3, r11)
            goto L_0x0700
        L_0x047c:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x04e4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r6) goto L_0x04e4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            int r3 = r38.getHeight()
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            int r11 = r11.ad()
            int r3 = r3 - r11
            int r11 = r10.getHeight()
            int r11 = r3 - r11
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            int r12 = r10.dT
            if (r12 > 0) goto L_0x04c9
            int r12 = r10.getVisibility()
            r14 = 8
            if (r12 != r14) goto L_0x04dd
        L_0x04c9:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dF
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            int r14 = r10.dT
            int r14 = r14 + r11
            r15.b(r12, r14)
        L_0x04dd:
            r10.du = r13
            r10.f(r11, r3)
            goto L_0x0700
        L_0x04e4:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0555
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            int r3 = r3.du
            if (r3 != r13) goto L_0x0555
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            float r3 = r3.da
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            int r11 = r11.ad()
            float r11 = (float) r11
            float r3 = r3 + r11
            float r3 = r3 + r16
            int r3 = (int) r3
            int r11 = r10.getHeight()
            int r11 = r11 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            int r12 = r10.dT
            if (r12 > 0) goto L_0x053a
            int r12 = r10.getVisibility()
            r14 = 8
            if (r12 != r14) goto L_0x054e
        L_0x053a:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dF
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            int r14 = r10.dT
            int r14 = r14 + r3
            r15.b(r12, r14)
        L_0x054e:
            r10.du = r13
            r10.f(r3, r11)
            goto L_0x0700
        L_0x0555:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x05c7
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            int r3 = r3.du
            if (r3 != r13) goto L_0x05c7
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            float r3 = r3.da
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            int r11 = r11.ad()
            float r11 = (float) r11
            float r3 = r3 - r11
            float r3 = r3 + r16
            int r3 = (int) r3
            int r11 = r10.getHeight()
            int r11 = r3 - r11
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            int r12 = r10.dT
            if (r12 > 0) goto L_0x05ac
            int r12 = r10.getVisibility()
            r14 = 8
            if (r12 != r14) goto L_0x05c0
        L_0x05ac:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dF
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            int r14 = r10.dT
            int r14 = r14 + r11
            r15.b(r12, r14)
        L_0x05c0:
            r10.du = r13
            r10.f(r11, r3)
            goto L_0x0700
        L_0x05c7:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0628
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            int r3 = r3.du
            if (r3 != r13) goto L_0x0628
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            float r3 = r3.da
            int r11 = r10.dT
            float r11 = (float) r11
            float r3 = r3 - r11
            float r3 = r3 + r16
            int r3 = (int) r3
            int r11 = r10.getHeight()
            int r11 = r11 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r10.dF
            android.support.constraint.solver.SolverVariable r14 = r15.f(r14)
            r12.f0do = r14
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            int r14 = r10.dT
            int r14 = r14 + r3
            r15.b(r12, r14)
            r10.du = r13
            r10.f(r3, r11)
            goto L_0x0700
        L_0x0628:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0630
            r3 = 1
            goto L_0x0631
        L_0x0630:
            r3 = 0
        L_0x0631:
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            if (r11 == 0) goto L_0x0639
            r11 = 1
            goto L_0x063a
        L_0x0639:
            r11 = 0
        L_0x063a:
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r12.di
            if (r12 == 0) goto L_0x0642
            r12 = 1
            goto L_0x0643
        L_0x0642:
            r12 = 0
        L_0x0643:
            if (r3 != 0) goto L_0x0700
            if (r11 != 0) goto L_0x0700
            if (r12 != 0) goto L_0x0700
            boolean r3 = r10 instanceof android.support.constraint.solver.widgets.b
            if (r3 == 0) goto L_0x06b3
            r3 = r10
            android.support.constraint.solver.widgets.b r3 = (android.support.constraint.solver.widgets.b) r3
            int r11 = r3.getOrientation()
            if (r11 != 0) goto L_0x0700
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            int r11 = r3.at()
            r12 = -1
            if (r11 == r12) goto L_0x0677
            int r3 = r3.at()
            float r3 = (float) r3
            goto L_0x0692
        L_0x0677:
            int r11 = r3.au()
            if (r11 == r12) goto L_0x0688
            int r11 = r38.getHeight()
            int r3 = r3.au()
            int r11 = r11 - r3
            float r3 = (float) r11
            goto L_0x0692
        L_0x0688:
            int r11 = r38.getHeight()
            float r11 = (float) r11
            float r3 = r3.as()
            float r3 = r3 * r11
        L_0x0692:
            float r3 = r3 + r16
            int r3 = (int) r3
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            r15.b(r11, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            r15.b(r11, r3)
            r10.du = r13
            r10.dt = r13
            r10.f(r3, r3)
            int r3 = r38.getWidth()
            r11 = 0
            r10.e(r11, r3)
            goto L_0x0700
        L_0x06b3:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dC
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.SolverVariable r11 = r15.f(r11)
            r3.f0do = r11
            int r3 = r10.getY()
            int r11 = r10.getHeight()
            int r11 = r11 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dC
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dE
            android.support.constraint.solver.SolverVariable r12 = r12.f0do
            r15.b(r12, r11)
            int r11 = r10.dT
            if (r11 > 0) goto L_0x06ea
            int r11 = r10.getVisibility()
            r12 = 8
            if (r11 != r12) goto L_0x06fe
        L_0x06ea:
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r10.dF
            android.support.constraint.solver.SolverVariable r12 = r15.f(r12)
            r11.f0do = r12
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dF
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            int r12 = r10.dT
            int r3 = r3 + r12
            r15.b(r11, r3)
        L_0x06fe:
            r10.du = r13
        L_0x0700:
            int r3 = r10.du
            r11 = -1
            if (r3 != r11) goto L_0x0707
            int r8 = r8 + 1
        L_0x0707:
            int r3 = r10.dt
            if (r3 != r11) goto L_0x070d
            int r9 = r9 + 1
        L_0x070d:
            int r7 = r7 + 1
            r3 = -1
            r11 = 1
            goto L_0x004b
        L_0x0713:
            if (r8 != 0) goto L_0x071e
            if (r9 != 0) goto L_0x071e
            r4 = r8
            r5 = r9
            r2 = 1
        L_0x071a:
            r3 = -1
            r11 = 1
            goto L_0x0046
        L_0x071e:
            if (r4 != r8) goto L_0x0723
            if (r5 != r9) goto L_0x0723
            r2 = 1
        L_0x0723:
            r4 = r8
            r5 = r9
            goto L_0x071a
        L_0x0726:
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0729:
            if (r2 >= r1) goto L_0x074e
            java.util.ArrayList r5 = r6.mChildren
            java.lang.Object r5 = r5.get(r2)
            android.support.constraint.solver.widgets.ConstraintWidget r5 = (android.support.constraint.solver.widgets.ConstraintWidget) r5
            int r7 = r5.dt
            r8 = 1
            if (r7 == r8) goto L_0x073e
            int r7 = r5.dt
            r9 = -1
            if (r7 != r9) goto L_0x0741
            goto L_0x073f
        L_0x073e:
            r9 = -1
        L_0x073f:
            int r3 = r3 + 1
        L_0x0741:
            int r7 = r5.du
            if (r7 == r8) goto L_0x0749
            int r5 = r5.du
            if (r5 != r9) goto L_0x074b
        L_0x0749:
            int r4 = r4 + 1
        L_0x074b:
            int r2 = r2 + 1
            goto L_0x0729
        L_0x074e:
            if (r3 != 0) goto L_0x0754
            if (r4 != 0) goto L_0x0754
            r1 = 1
            goto L_0x0755
        L_0x0754:
            r1 = 0
        L_0x0755:
            if (r1 == 0) goto L_0x0759
            r1 = 0
            return r1
        L_0x0759:
            r11 = 0
        L_0x075a:
            r1 = 0
        L_0x075b:
            if (r1 >= r0) goto L_0x083b
            java.util.ArrayList r2 = r6.mChildren
            java.lang.Object r2 = r2.get(r1)
            android.support.constraint.solver.widgets.ConstraintWidget r2 = (android.support.constraint.solver.widgets.ConstraintWidget) r2
            boolean r3 = r2 instanceof android.support.constraint.solver.widgets.a
            if (r3 == 0) goto L_0x0792
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r2.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r5) goto L_0x0776
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r2.a((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r5)
        L_0x0776:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r5) goto L_0x077f
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r2.b((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r5)
        L_0x077f:
            r2.b((android.support.constraint.solver.e) r15)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r5) goto L_0x0789
            r2.a((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r3)
        L_0x0789:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r3) goto L_0x0837
            r2.b((android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour) r4)
            goto L_0x0837
        L_0x0792:
            if (r11 == 0) goto L_0x0834
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r6.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 == r4) goto L_0x07d4
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r3 != r4) goto L_0x07d4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r2.dB
            android.support.constraint.solver.SolverVariable r4 = r15.f(r4)
            r3.f0do = r4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r2.dD
            android.support.constraint.solver.SolverVariable r4 = r15.f(r4)
            r3.f0do = r4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.dB
            int r3 = r3.mMargin
            int r4 = r38.getWidth()
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dD
            int r5 = r5.mMargin
            int r4 = r4 - r5
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dB
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            r15.b(r5, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dD
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            r15.b(r5, r4)
            r2.e(r3, r4)
            r2.dt = r13
        L_0x07d4:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r6.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 == r4) goto L_0x0834
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r3 != r4) goto L_0x0834
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r2.dC
            android.support.constraint.solver.SolverVariable r4 = r15.f(r4)
            r3.f0do = r4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r2.dE
            android.support.constraint.solver.SolverVariable r4 = r15.f(r4)
            r3.f0do = r4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.dC
            int r3 = r3.mMargin
            int r4 = r38.getHeight()
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dE
            int r5 = r5.mMargin
            int r4 = r4 - r5
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dC
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            r15.b(r5, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dE
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            r15.b(r5, r4)
            int r5 = r2.dT
            if (r5 > 0) goto L_0x081b
            int r5 = r2.getVisibility()
            r7 = 8
            if (r5 != r7) goto L_0x082f
        L_0x081b:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r2.dF
            android.support.constraint.solver.SolverVariable r7 = r15.f(r7)
            r5.f0do = r7
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dF
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            int r7 = r2.dT
            int r7 = r7 + r3
            r15.b(r5, r7)
        L_0x082f:
            r2.f(r3, r4)
            r2.du = r13
        L_0x0834:
            r2.b((android.support.constraint.solver.e) r15)
        L_0x0837:
            int r1 = r1 + 1
            goto L_0x075b
        L_0x083b:
            int r0 = r6.ey
            if (r0 <= 0) goto L_0x0ed7
            r14 = 0
        L_0x0840:
            int r0 = r6.ey
            if (r14 >= r0) goto L_0x0ed7
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.eC
            r12 = r0[r14]
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r6.eE
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.eC
            r3 = r0[r14]
            r4 = 0
            boolean[] r5 = r6.eD
            r0 = r38
            r1 = r39
            int r0 = r0.a(r1, r2, r3, r4, r5)
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r6.eE
            r1 = r1[r13]
            if (r1 == 0) goto L_0x0ec6
            boolean[] r2 = r6.eD
            r3 = 1
            boolean r2 = r2[r3]
            if (r2 == 0) goto L_0x088a
            int r0 = r12.ah()
        L_0x086a:
            if (r1 == 0) goto L_0x0ec6
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dB
            android.support.constraint.solver.SolverVariable r2 = r2.f0do
            r15.b(r2, r0)
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r1.et
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dB
            int r3 = r3.ad()
            int r4 = r1.getWidth()
            int r3 = r3 + r4
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.dD
            int r1 = r1.ad()
            int r3 = r3 + r1
            int r0 = r0 + r3
            r1 = r2
            goto L_0x086a
        L_0x088a:
            int r2 = r12.en
            if (r2 != 0) goto L_0x0890
            r2 = 1
            goto L_0x0891
        L_0x0890:
            r2 = 0
        L_0x0891:
            int r3 = r12.en
            if (r3 != r13) goto L_0x0897
            r3 = 1
            goto L_0x0898
        L_0x0897:
            r3 = 0
        L_0x0898:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r6.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r5) goto L_0x08a0
            r4 = 1
            goto L_0x08a1
        L_0x08a0:
            r4 = 0
        L_0x08a1:
            int r5 = r6.bb
            r7 = 0
            r19 = 0
            if (r5 == r13) goto L_0x08b2
            int r5 = r6.bb
            r8 = 8
            if (r5 != r8) goto L_0x08af
            goto L_0x08b2
        L_0x08af:
            r11 = r8
            goto L_0x0a13
        L_0x08b2:
            boolean[] r5 = r6.eD
            r8 = 0
            boolean r5 = r5[r8]
            if (r5 == 0) goto L_0x0a11
            boolean r5 = r12.ep
            if (r5 == 0) goto L_0x0a11
            if (r3 != 0) goto L_0x0a11
            if (r4 != 0) goto L_0x0a11
            int r4 = r12.en
            if (r4 != 0) goto L_0x0a11
            r5 = r7
            r1 = r12
            r2 = r19
            r3 = 0
            r4 = 0
        L_0x08cb:
            if (r1 == 0) goto L_0x0936
            int r2 = r1.getVisibility()
            r8 = 8
            if (r2 != r8) goto L_0x08d7
            r2 = 1
            goto L_0x08d8
        L_0x08d7:
            r2 = 0
        L_0x08d8:
            if (r2 != 0) goto L_0x0909
            int r3 = r3 + 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = r1.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 == r8) goto L_0x0906
            int r2 = r1.getWidth()
            int r4 = r4 + r2
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x08f4
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dB
            int r2 = r2.ad()
            goto L_0x08f5
        L_0x08f4:
            r2 = 0
        L_0x08f5:
            int r4 = r4 + r2
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0903
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dD
            int r2 = r2.ad()
            goto L_0x0904
        L_0x0903:
            r2 = 0
        L_0x0904:
            int r4 = r4 + r2
            goto L_0x0909
        L_0x0906:
            float r2 = r1.er
            float r5 = r5 + r2
        L_0x0909:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0916
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            goto L_0x0918
        L_0x0916:
            r2 = r19
        L_0x0918:
            if (r2 == 0) goto L_0x0930
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r2.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            if (r8 == 0) goto L_0x092e
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r2.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            if (r8 == 0) goto L_0x0930
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r2.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            android.support.constraint.solver.widgets.ConstraintWidget r8 = r8.dg
            if (r8 == r1) goto L_0x0930
        L_0x092e:
            r2 = r19
        L_0x0930:
            r37 = r2
            r2 = r1
            r1 = r37
            goto L_0x08cb
        L_0x0936:
            if (r2 == 0) goto L_0x095d
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r2.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            if (r1 == 0) goto L_0x0949
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r2.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r1.dg
            int r1 = r1.getX()
            goto L_0x094a
        L_0x0949:
            r1 = 0
        L_0x094a:
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r2.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            if (r8 == 0) goto L_0x095e
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            if (r2 != r6) goto L_0x095e
            int r1 = r38.getRight()
            goto L_0x095e
        L_0x095d:
            r1 = 0
        L_0x095e:
            float r1 = (float) r1
            float r2 = (float) r4
            float r1 = r1 - r2
            int r3 = r3 + 1
            float r2 = (float) r3
            float r2 = r1 / r2
            if (r0 != 0) goto L_0x096a
            r3 = r2
            goto L_0x096f
        L_0x096a:
            float r2 = (float) r0
            float r2 = r1 / r2
            r3 = r2
            r2 = r7
        L_0x096f:
            if (r12 == 0) goto L_0x0ec6
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x097e
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dB
            int r4 = r4.ad()
            goto L_0x097f
        L_0x097e:
            r4 = 0
        L_0x097f:
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r12.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            if (r8 == 0) goto L_0x098c
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r12.dD
            int r8 = r8.ad()
            goto L_0x098d
        L_0x098c:
            r8 = 0
        L_0x098d:
            int r9 = r12.getVisibility()
            r11 = 8
            if (r9 == r11) goto L_0x09d0
            float r4 = (float) r4
            float r2 = r2 + r4
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r12.dB
            android.support.constraint.solver.SolverVariable r9 = r9.f0do
            float r10 = r2 + r16
            int r10 = (int) r10
            r15.b(r9, r10)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r12.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r10) goto L_0x09ba
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x09b1
            float r4 = r3 - r4
            float r9 = (float) r8
            float r4 = r4 - r9
            float r2 = r2 + r4
            goto L_0x09c0
        L_0x09b1:
            float r9 = r12.er
            float r9 = r9 * r1
            float r9 = r9 / r5
            float r9 = r9 - r4
            float r4 = (float) r8
            float r9 = r9 - r4
            float r2 = r2 + r9
            goto L_0x09c0
        L_0x09ba:
            int r4 = r12.getWidth()
            float r4 = (float) r4
            float r2 = r2 + r4
        L_0x09c0:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dD
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            float r9 = r2 + r16
            int r9 = (int) r9
            r15.b(r4, r9)
            if (r0 != 0) goto L_0x09cd
            float r2 = r2 + r3
        L_0x09cd:
            float r4 = (float) r8
            float r2 = r2 + r4
            goto L_0x09e7
        L_0x09d0:
            r4 = 1073741824(0x40000000, float:2.0)
            float r4 = r3 / r4
            float r4 = r2 - r4
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r12.dB
            android.support.constraint.solver.SolverVariable r8 = r8.f0do
            float r4 = r4 + r16
            int r4 = (int) r4
            r15.b(r8, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r12.dD
            android.support.constraint.solver.SolverVariable r8 = r8.f0do
            r15.b(r8, r4)
        L_0x09e7:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x09f4
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            goto L_0x09f6
        L_0x09f4:
            r4 = r19
        L_0x09f6:
            if (r4 == 0) goto L_0x0a08
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r4.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            if (r8 == 0) goto L_0x0a08
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r4.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            android.support.constraint.solver.widgets.ConstraintWidget r8 = r8.dg
            if (r8 == r12) goto L_0x0a08
            r4 = r19
        L_0x0a08:
            if (r4 != r6) goto L_0x0a0e
            r12 = r19
            goto L_0x096f
        L_0x0a0e:
            r12 = r4
            goto L_0x096f
        L_0x0a11:
            r11 = 8
        L_0x0a13:
            r4 = 3
            if (r0 == 0) goto L_0x0ceb
            if (r3 == 0) goto L_0x0a1a
            goto L_0x0ceb
        L_0x0a1a:
            r2 = r19
        L_0x0a1c:
            if (r1 == 0) goto L_0x0ae3
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r1.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r5) goto L_0x0a9b
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dB
            int r3 = r3.ad()
            if (r2 == 0) goto L_0x0a33
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dD
            int r2 = r2.ad()
            int r3 = r3 + r2
        L_0x0a33:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r5) goto L_0x0a41
            r2 = r13
            goto L_0x0a42
        L_0x0a41:
            r2 = r4
        L_0x0a42:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dB
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r1.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            android.support.constraint.solver.SolverVariable r8 = r8.f0do
            r15.a(r5, r8, r3, r2)
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dD
            int r2 = r2.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0a7c
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r1) goto L_0x0a7c
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dB
            int r3 = r3.ad()
            int r2 = r2 + r3
        L_0x0a7c:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r5) goto L_0x0a8a
            r3 = r13
            goto L_0x0a8b
        L_0x0a8a:
            r3 = r4
        L_0x0a8b:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dD
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            android.support.constraint.solver.SolverVariable r8 = r8.f0do
            int r2 = -r2
            r15.b(r5, r8, r2, r3)
            r8 = 1
            goto L_0x0ada
        L_0x0a9b:
            float r2 = r1.er
            float r7 = r7 + r2
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0abe
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dD
            int r2 = r2.ad()
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r6.eE
            r3 = r3[r4]
            if (r1 == r3) goto L_0x0abf
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dB
            int r3 = r3.ad()
            int r2 = r2 + r3
            goto L_0x0abf
        L_0x0abe:
            r2 = 0
        L_0x0abf:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dD
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dB
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            r8 = 1
            r9 = 0
            r15.a(r3, r5, r9, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dD
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            int r2 = -r2
            r15.b(r3, r5, r2, r8)
        L_0x0ada:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r1.et
            r37 = r2
            r2 = r1
            r1 = r37
            goto L_0x0a1c
        L_0x0ae3:
            r8 = 1
            if (r0 != r8) goto L_0x0b79
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.eA
            r5 = 0
            r0 = r0[r5]
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.dB
            int r1 = r1.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r0.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0b00
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r0.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            int r2 = r2.ad()
            int r1 = r1 + r2
        L_0x0b00:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r0.dD
            int r2 = r2.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0b15
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            int r3 = r3.ad()
            int r2 = r2 + r3
        L_0x0b15:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r12.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            android.support.constraint.solver.widgets.ConstraintWidget[] r7 = r6.eE
            r4 = r7[r4]
            if (r0 != r4) goto L_0x0b2d
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r6.eE
            r4 = 1
            r3 = r3[r4]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            goto L_0x0b2e
        L_0x0b2d:
            r4 = 1
        L_0x0b2e:
            int r7 = r0.dv
            if (r7 != r4) goto L_0x0b58
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dB
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r12.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.di
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            r15.a(r0, r7, r1, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dD
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            int r1 = -r2
            r15.b(r0, r3, r1, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dD
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r12.dB
            android.support.constraint.solver.SolverVariable r1 = r1.f0do
            int r2 = r12.getWidth()
            r15.c(r0, r1, r2, r13)
            goto L_0x0ce0
        L_0x0b58:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.dB
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.di
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            r8 = 1
            r15.c(r4, r7, r1, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.dD
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            int r1 = -r2
            r15.c(r0, r3, r1, r8)
            r20 = r5
            r0 = r8
            r22 = r11
            r21 = r13
            r17 = r14
            goto L_0x0ecf
        L_0x0b79:
            r5 = 0
            r1 = r5
        L_0x0b7b:
            int r2 = r0 + -1
            if (r1 >= r2) goto L_0x0ce0
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r6.eA
            r3 = r3[r1]
            android.support.constraint.solver.widgets.ConstraintWidget[] r8 = r6.eA
            int r1 = r1 + 1
            r8 = r8[r1]
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r3.dB
            android.support.constraint.solver.SolverVariable r9 = r9.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r3.dD
            android.support.constraint.solver.SolverVariable r10 = r10.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r8.dB
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r8.dD
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            android.support.constraint.solver.widgets.ConstraintWidget[] r13 = r6.eE
            r13 = r13[r4]
            if (r8 != r13) goto L_0x0ba8
            android.support.constraint.solver.widgets.ConstraintWidget[] r11 = r6.eE
            r13 = 1
            r11 = r11[r13]
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.dD
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
        L_0x0ba8:
            android.support.constraint.solver.widgets.ConstraintAnchor r13 = r3.dB
            int r13 = r13.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x0bdb
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x0bdb
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            if (r4 != r3) goto L_0x0bdb
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dD
            int r4 = r4.ad()
            int r13 = r13 + r4
        L_0x0bdb:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            r33 = r0
            r0 = 2
            r15.a(r9, r4, r13, r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r3.dD
            int r0 = r0.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x0c0a
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r3.et
            if (r4 == 0) goto L_0x0c0a
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r3.et
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x0c08
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r3.et
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dB
            int r4 = r4.ad()
            goto L_0x0c09
        L_0x0c08:
            r4 = 0
        L_0x0c09:
            int r0 = r0 + r4
        L_0x0c0a:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            int r0 = -r0
            r13 = 2
            r15.b(r10, r4, r0, r13)
            if (r1 != r2) goto L_0x0c97
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r8.dB
            int r0 = r0.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r8.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0c4a
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r8.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x0c4a
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r8.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            if (r2 != r8) goto L_0x0c4a
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r8.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dD
            int r2 = r2.ad()
            int r0 = r0 + r2
        L_0x0c4a:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r8.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.SolverVariable r2 = r2.f0do
            r4 = 2
            r15.a(r5, r2, r0, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r8.dD
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r6.eE
            r4 = 3
            r2 = r2[r4]
            if (r8 != r2) goto L_0x0c64
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.eE
            r2 = 1
            r0 = r0[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.dD
        L_0x0c64:
            int r2 = r0.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.di
            if (r4 == 0) goto L_0x0c8d
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x0c8d
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            if (r4 != r8) goto L_0x0c8d
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dB
            int r4 = r4.ad()
            int r2 = r2 + r4
        L_0x0c8d:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            int r2 = -r2
            r4 = 2
            r15.b(r11, r0, r2, r4)
            goto L_0x0c98
        L_0x0c97:
            r4 = 2
        L_0x0c98:
            int r0 = r12.dy
            if (r0 <= 0) goto L_0x0ca1
            int r0 = r12.dy
            r15.b(r10, r9, r0, r4)
        L_0x0ca1:
            android.support.constraint.solver.b r0 = r39.Y()
            float r2 = r3.er
            float r13 = r8.er
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dB
            int r26 = r4.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dD
            int r28 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r8.dB
            int r30 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r8.dD
            int r32 = r3.ad()
            r21 = r0
            r22 = r2
            r23 = r7
            r24 = r13
            r25 = r9
            r27 = r10
            r29 = r5
            r31 = r11
            r21.a(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r15.b((android.support.constraint.solver.b) r0)
            r0 = r33
            r4 = 3
            r5 = 0
            r11 = 8
            r13 = 2
            goto L_0x0b7b
        L_0x0ce0:
            r20 = r5
            r22 = r11
            r21 = r13
            r17 = r14
            r0 = 1
            goto L_0x0ecf
        L_0x0ceb:
            r0 = r1
            r4 = r19
            r5 = r4
            r7 = 0
        L_0x0cf0:
            if (r0 == 0) goto L_0x0e78
            android.support.constraint.solver.widgets.ConstraintWidget r8 = r0.et
            if (r8 != 0) goto L_0x0cfe
            android.support.constraint.solver.widgets.ConstraintWidget[] r4 = r6.eE
            r7 = 1
            r4 = r4[r7]
            r13 = r4
            r4 = 1
            goto L_0x0d00
        L_0x0cfe:
            r13 = r4
            r4 = r7
        L_0x0d00:
            if (r3 == 0) goto L_0x0d5e
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.dB
            int r9 = r7.ad()
            if (r5 == 0) goto L_0x0d11
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.dD
            int r5 = r5.ad()
            int r9 = r9 + r5
        L_0x0d11:
            if (r1 == r0) goto L_0x0d15
            r5 = 3
            goto L_0x0d16
        L_0x0d15:
            r5 = 1
        L_0x0d16:
            android.support.constraint.solver.SolverVariable r10 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r7.di
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            r15.a(r10, r11, r9, r5)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = r0.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r9) goto L_0x0d5a
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dD
            int r9 = r0.dv
            r10 = 1
            if (r9 != r10) goto L_0x0d42
            int r9 = r0.dx
            int r10 = r0.getWidth()
            int r9 = java.lang.Math.max(r9, r10)
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            r11 = 3
            r15.c(r5, r7, r9, r11)
            r34 = r14
            goto L_0x0dba
        L_0x0d42:
            r11 = 3
            android.support.constraint.solver.SolverVariable r9 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r7.di
            android.support.constraint.solver.SolverVariable r10 = r10.f0do
            r34 = r14
            int r14 = r7.mMargin
            r15.a(r9, r10, r14, r11)
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            int r9 = r0.dx
            r15.b(r5, r7, r9, r11)
            goto L_0x0dba
        L_0x0d5a:
            r34 = r14
            r11 = 3
            goto L_0x0dba
        L_0x0d5e:
            r34 = r14
            r11 = 3
            r7 = 5
            if (r2 != 0) goto L_0x0d8f
            if (r4 == 0) goto L_0x0d8f
            if (r5 == 0) goto L_0x0d8f
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 != 0) goto L_0x0d7a
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dD
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            int r7 = r0.aj()
            r15.b(r5, r7)
            goto L_0x0dba
        L_0x0d7a:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dD
            int r5 = r5.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.dD
            android.support.constraint.solver.SolverVariable r9 = r9.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r13.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r10.di
            android.support.constraint.solver.SolverVariable r10 = r10.f0do
            int r5 = -r5
            r15.c(r9, r10, r5, r7)
            goto L_0x0dba
        L_0x0d8f:
            if (r2 != 0) goto L_0x0dce
            if (r4 != 0) goto L_0x0dce
            if (r5 != 0) goto L_0x0dce
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 != 0) goto L_0x0da7
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dB
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            int r7 = r0.ah()
            r15.b(r5, r7)
            goto L_0x0dba
        L_0x0da7:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dB
            int r5 = r5.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.dB
            android.support.constraint.solver.SolverVariable r9 = r9.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r12.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r10.di
            android.support.constraint.solver.SolverVariable r10 = r10.f0do
            r15.c(r9, r10, r5, r7)
        L_0x0dba:
            r35 = r0
            r36 = r2
            r5 = r8
            r18 = r11
            r2 = r12
            r6 = r13
            r17 = r34
            r0 = 1
        L_0x0dc6:
            r20 = 0
            r21 = 2
            r22 = 8
            goto L_0x0e66
        L_0x0dce:
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.dD
            int r10 = r7.ad()
            int r14 = r9.ad()
            android.support.constraint.solver.SolverVariable r11 = r7.f0do
            r35 = r0
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.di
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            r36 = r2
            r2 = 1
            r15.a(r11, r0, r10, r2)
            android.support.constraint.solver.SolverVariable r0 = r9.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r9.di
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            int r6 = -r14
            r15.b(r0, r11, r6, r2)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.di
            if (r0 == 0) goto L_0x0dfb
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.di
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            goto L_0x0dfd
        L_0x0dfb:
            r0 = r19
        L_0x0dfd:
            if (r5 != 0) goto L_0x0e0e
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            if (r0 == 0) goto L_0x0e0c
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            goto L_0x0e0e
        L_0x0e0c:
            r0 = r19
        L_0x0e0e:
            if (r8 != 0) goto L_0x0e20
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r13.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x0e1e
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r13.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            r8 = r5
            goto L_0x0e20
        L_0x0e1e:
            r8 = r19
        L_0x0e20:
            r5 = r8
            if (r5 == 0) goto L_0x0e5d
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r5.dB
            android.support.constraint.solver.SolverVariable r6 = r6.f0do
            if (r4 == 0) goto L_0x0e38
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r13.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.di
            if (r6 == 0) goto L_0x0e36
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r13.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.di
            android.support.constraint.solver.SolverVariable r6 = r6.f0do
            goto L_0x0e38
        L_0x0e36:
            r6 = r19
        L_0x0e38:
            if (r0 == 0) goto L_0x0e5d
            if (r6 == 0) goto L_0x0e5d
            android.support.constraint.solver.SolverVariable r8 = r7.f0do
            r11 = 1056964608(0x3f000000, float:0.5)
            android.support.constraint.solver.SolverVariable r9 = r9.f0do
            r7 = r39
            r17 = r9
            r9 = r0
            r0 = r2
            r2 = 8
            r18 = 3
            r2 = r12
            r20 = 0
            r12 = r6
            r6 = r13
            r21 = 2
            r13 = r17
            r17 = r34
            r22 = 8
            r7.b(r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0e66
        L_0x0e5d:
            r0 = r2
            r2 = r12
            r6 = r13
            r17 = r34
            r18 = 3
            goto L_0x0dc6
        L_0x0e66:
            if (r4 == 0) goto L_0x0e6a
            r5 = r19
        L_0x0e6a:
            r12 = r2
            r7 = r4
            r0 = r5
            r4 = r6
            r14 = r17
            r5 = r35
            r2 = r36
            r6 = r38
            goto L_0x0cf0
        L_0x0e78:
            r2 = r12
            r17 = r14
            r0 = 1
            r20 = 0
            r21 = 2
            r22 = 8
            if (r3 == 0) goto L_0x0ecf
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r4.dD
            int r10 = r1.ad()
            int r14 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x0e9e
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dB
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            r9 = r5
            goto L_0x0ea0
        L_0x0e9e:
            r9 = r19
        L_0x0ea0:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r4.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x0eae
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dD
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            r12 = r4
            goto L_0x0eb0
        L_0x0eae:
            r12 = r19
        L_0x0eb0:
            if (r9 == 0) goto L_0x0ecf
            if (r12 == 0) goto L_0x0ecf
            android.support.constraint.solver.SolverVariable r4 = r3.f0do
            int r5 = -r14
            r15.b(r4, r12, r5, r0)
            android.support.constraint.solver.SolverVariable r8 = r1.f0do
            float r11 = r2.dX
            android.support.constraint.solver.SolverVariable r13 = r3.f0do
            r7 = r39
            r7.b(r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0ecf
        L_0x0ec6:
            r21 = r13
            r17 = r14
            r0 = 1
            r20 = 0
            r22 = 8
        L_0x0ecf:
            int r14 = r17 + 1
            r13 = r21
            r6 = r38
            goto L_0x0840
        L_0x0ed7:
            r0 = 1
            r1 = r38
            int r2 = r1.ez
            if (r2 <= 0) goto L_0x0ee1
            r38.d(r39)
        L_0x0ee1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.a.c(android.support.constraint.solver.e):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:285:0x0610  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0612 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(android.support.constraint.solver.e r34) {
        /*
            r33 = this;
            r6 = r33
            r15 = r34
            r14 = 0
            r13 = r14
        L_0x0006:
            int r0 = r6.ez
            if (r13 >= r0) goto L_0x0674
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.eB
            r12 = r0[r13]
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r6.eE
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.eB
            r3 = r0[r13]
            r4 = 1
            boolean[] r5 = r6.eD
            r0 = r33
            r1 = r34
            int r0 = r0.a(r1, r2, r3, r4, r5)
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r6.eE
            r2 = 2
            r1 = r1[r2]
            if (r1 == 0) goto L_0x0669
            boolean[] r3 = r6.eD
            r4 = 1
            boolean r3 = r3[r4]
            if (r3 == 0) goto L_0x0051
            int r0 = r12.ai()
        L_0x0031:
            if (r1 == 0) goto L_0x0669
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dC
            android.support.constraint.solver.SolverVariable r2 = r2.f0do
            r15.b(r2, r0)
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r1.eu
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dC
            int r3 = r3.ad()
            int r4 = r1.getHeight()
            int r3 = r3 + r4
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.dE
            int r1 = r1.ad()
            int r3 = r3 + r1
            int r0 = r0 + r3
            r1 = r2
            goto L_0x0031
        L_0x0051:
            int r3 = r12.eo
            if (r3 != 0) goto L_0x0057
            r3 = r4
            goto L_0x0058
        L_0x0057:
            r3 = r14
        L_0x0058:
            int r5 = r12.eo
            if (r5 != r2) goto L_0x005e
            r5 = r4
            goto L_0x005f
        L_0x005e:
            r5 = r14
        L_0x005f:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r6.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r8) goto L_0x0067
            r7 = r4
            goto L_0x0068
        L_0x0067:
            r7 = r14
        L_0x0068:
            int r8 = r6.bb
            r9 = 8
            r10 = 0
            r16 = 0
            if (r8 == r2) goto L_0x0075
            int r8 = r6.bb
            if (r8 != r9) goto L_0x01cc
        L_0x0075:
            boolean[] r8 = r6.eD
            boolean r8 = r8[r14]
            if (r8 == 0) goto L_0x01cc
            boolean r8 = r12.eq
            if (r8 == 0) goto L_0x01cc
            if (r5 != 0) goto L_0x01cc
            if (r7 != 0) goto L_0x01cc
            int r7 = r12.eo
            if (r7 != 0) goto L_0x01cc
            r7 = r10
            r1 = r12
            r3 = r14
            r5 = r3
            r2 = r16
        L_0x008d:
            if (r1 == 0) goto L_0x00f4
            int r2 = r1.mVisibility
            if (r2 != r9) goto L_0x0095
            r2 = r4
            goto L_0x0096
        L_0x0095:
            r2 = r14
        L_0x0096:
            if (r2 != 0) goto L_0x00c7
            int r3 = r3 + 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = r1.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 == r8) goto L_0x00c4
            int r2 = r1.getHeight()
            int r5 = r5 + r2
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x00b2
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dC
            int r2 = r2.ad()
            goto L_0x00b3
        L_0x00b2:
            r2 = r14
        L_0x00b3:
            int r5 = r5 + r2
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x00c1
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dE
            int r2 = r2.ad()
            goto L_0x00c2
        L_0x00c1:
            r2 = r14
        L_0x00c2:
            int r5 = r5 + r2
            goto L_0x00c7
        L_0x00c4:
            float r2 = r1.es
            float r7 = r7 + r2
        L_0x00c7:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            if (r2 == 0) goto L_0x00d4
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            goto L_0x00d6
        L_0x00d4:
            r2 = r16
        L_0x00d6:
            if (r2 == 0) goto L_0x00ee
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r2.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            if (r8 == 0) goto L_0x00ec
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r2.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            if (r8 == 0) goto L_0x00ee
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r2.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            android.support.constraint.solver.widgets.ConstraintWidget r8 = r8.dg
            if (r8 == r1) goto L_0x00ee
        L_0x00ec:
            r2 = r16
        L_0x00ee:
            r32 = r2
            r2 = r1
            r1 = r32
            goto L_0x008d
        L_0x00f4:
            if (r2 == 0) goto L_0x011b
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r2.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            if (r1 == 0) goto L_0x0107
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r2.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r1.dg
            int r1 = r1.getX()
            goto L_0x0108
        L_0x0107:
            r1 = r14
        L_0x0108:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r2.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x011c
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.dg
            if (r2 != r6) goto L_0x011c
            int r1 = r33.getBottom()
            goto L_0x011c
        L_0x011b:
            r1 = r14
        L_0x011c:
            float r1 = (float) r1
            float r2 = (float) r5
            float r1 = r1 - r2
            int r3 = r3 + 1
            float r2 = (float) r3
            float r2 = r1 / r2
            if (r0 != 0) goto L_0x0128
            r3 = r2
            goto L_0x012d
        L_0x0128:
            float r2 = (float) r0
            float r2 = r1 / r2
            r3 = r2
            r2 = r10
        L_0x012d:
            if (r12 == 0) goto L_0x0669
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x013c
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dC
            int r4 = r4.ad()
            goto L_0x013d
        L_0x013c:
            r4 = r14
        L_0x013d:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r12.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x014a
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r12.dE
            int r5 = r5.ad()
            goto L_0x014b
        L_0x014a:
            r5 = r14
        L_0x014b:
            int r8 = r12.mVisibility
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r8 == r9) goto L_0x018b
            float r4 = (float) r4
            float r2 = r2 + r4
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r12.dC
            android.support.constraint.solver.SolverVariable r8 = r8.f0do
            float r9 = r2 + r11
            int r9 = (int) r9
            r15.b(r8, r9)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r12.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r9) goto L_0x0176
            int r8 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r8 != 0) goto L_0x016d
            float r4 = r3 - r4
            float r8 = (float) r5
            float r4 = r4 - r8
            float r2 = r2 + r4
            goto L_0x017c
        L_0x016d:
            float r8 = r12.es
            float r8 = r8 * r1
            float r8 = r8 / r7
            float r8 = r8 - r4
            float r4 = (float) r5
            float r8 = r8 - r4
            float r2 = r2 + r8
            goto L_0x017c
        L_0x0176:
            int r4 = r12.getHeight()
            float r4 = (float) r4
            float r2 = r2 + r4
        L_0x017c:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dE
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            float r11 = r11 + r2
            int r8 = (int) r11
            r15.b(r4, r8)
            if (r0 != 0) goto L_0x0188
            float r2 = r2 + r3
        L_0x0188:
            float r4 = (float) r5
            float r2 = r2 + r4
            goto L_0x01a1
        L_0x018b:
            r4 = 1073741824(0x40000000, float:2.0)
            float r4 = r3 / r4
            float r4 = r2 - r4
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r12.dC
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            float r4 = r4 + r11
            int r4 = (int) r4
            r15.b(r5, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r12.dE
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            r15.b(r5, r4)
        L_0x01a1:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x01ae
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r12.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            goto L_0x01b0
        L_0x01ae:
            r4 = r16
        L_0x01b0:
            if (r4 == 0) goto L_0x01c2
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r4.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x01c2
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r4.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            if (r5 == r12) goto L_0x01c2
            r4 = r16
        L_0x01c2:
            if (r4 != r6) goto L_0x01c7
            r12 = r16
            goto L_0x01c8
        L_0x01c7:
            r12 = r4
        L_0x01c8:
            r9 = 8
            goto L_0x012d
        L_0x01cc:
            r11 = 3
            if (r0 == 0) goto L_0x0485
            if (r5 == 0) goto L_0x01d3
            goto L_0x0485
        L_0x01d3:
            r3 = r16
        L_0x01d5:
            if (r1 == 0) goto L_0x0299
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = r1.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 == r7) goto L_0x0253
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dC
            int r5 = r5.ad()
            if (r3 == 0) goto L_0x01ec
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dE
            int r3 = r3.ad()
            int r5 = r5 + r3
        L_0x01ec:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r7) goto L_0x01fa
            r3 = r2
            goto L_0x01fb
        L_0x01fa:
            r3 = r11
        L_0x01fb:
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r1.dC
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r1.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            android.support.constraint.solver.SolverVariable r8 = r8.f0do
            r15.a(r7, r8, r5, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dE
            int r3 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x0235
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            if (r5 != r1) goto L_0x0235
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.dC
            int r5 = r5.ad()
            int r3 = r3 + r5
        L_0x0235:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = r5.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r7) goto L_0x0243
            r5 = r2
            goto L_0x0244
        L_0x0243:
            r5 = r11
        L_0x0244:
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r1.dE
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.di
            android.support.constraint.solver.SolverVariable r8 = r8.f0do
            int r3 = -r3
            r15.b(r7, r8, r3, r5)
            goto L_0x0290
        L_0x0253:
            float r3 = r1.es
            float r10 = r10 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x0276
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.dE
            int r3 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintWidget[] r5 = r6.eE
            r5 = r5[r11]
            if (r1 == r5) goto L_0x0277
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.dC
            int r5 = r5.ad()
            int r3 = r3 + r5
            goto L_0x0277
        L_0x0276:
            r3 = r14
        L_0x0277:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dE
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r1.dC
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            r15.a(r5, r7, r14, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.dE
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r1.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.di
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            int r3 = -r3
            r15.b(r5, r7, r3, r4)
        L_0x0290:
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r1.eu
            r32 = r3
            r3 = r1
            r1 = r32
            goto L_0x01d5
        L_0x0299:
            if (r0 != r4) goto L_0x0320
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.eA
            r0 = r0[r14]
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.dC
            int r1 = r1.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x02b4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            int r3 = r3.ad()
            int r1 = r1 + r3
        L_0x02b4:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.dE
            int r3 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x02c9
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            int r5 = r5.ad()
            int r3 = r3 + r5
        L_0x02c9:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r12.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            android.support.constraint.solver.widgets.ConstraintWidget[] r7 = r6.eE
            r7 = r7[r11]
            if (r0 != r7) goto L_0x02df
            android.support.constraint.solver.widgets.ConstraintWidget[] r5 = r6.eE
            r5 = r5[r4]
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
        L_0x02df:
            int r7 = r0.dw
            if (r7 != r4) goto L_0x0309
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dC
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r12.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.di
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            r15.a(r0, r7, r1, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dE
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            int r1 = -r3
            r15.b(r0, r5, r1, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dE
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r12.dC
            android.support.constraint.solver.SolverVariable r1 = r1.f0do
            int r3 = r12.getHeight()
            r15.c(r0, r1, r3, r2)
            goto L_0x0669
        L_0x0309:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r0.dC
            android.support.constraint.solver.SolverVariable r2 = r2.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.di
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            r15.c(r2, r7, r1, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.dE
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            int r1 = -r3
            r15.c(r0, r5, r1, r4)
            goto L_0x0669
        L_0x0320:
            r1 = r14
        L_0x0321:
            int r3 = r0 + -1
            if (r1 >= r3) goto L_0x0669
            android.support.constraint.solver.widgets.ConstraintWidget[] r5 = r6.eA
            r5 = r5[r1]
            android.support.constraint.solver.widgets.ConstraintWidget[] r7 = r6.eA
            int r1 = r1 + 1
            r7 = r7[r1]
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r5.dC
            android.support.constraint.solver.SolverVariable r8 = r8.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r5.dE
            android.support.constraint.solver.SolverVariable r9 = r9.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r7.dC
            android.support.constraint.solver.SolverVariable r14 = r14.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r7.dE
            android.support.constraint.solver.SolverVariable r2 = r2.f0do
            android.support.constraint.solver.widgets.ConstraintWidget[] r4 = r6.eE
            r4 = r4[r11]
            if (r7 != r4) goto L_0x034e
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r6.eE
            r4 = 1
            r2 = r2[r4]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dE
            android.support.constraint.solver.SolverVariable r2 = r2.f0do
        L_0x034e:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r5.dC
            int r4 = r4.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            if (r11 == 0) goto L_0x0381
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintWidget r11 = r11.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            if (r11 == 0) goto L_0x0381
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintWidget r11 = r11.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintWidget r11 = r11.dg
            if (r11 != r5) goto L_0x0381
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintWidget r11 = r11.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.dE
            int r11 = r11.ad()
            int r4 = r4 + r11
        L_0x0381:
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            r28 = r0
            r0 = 2
            r15.a(r8, r11, r4, r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r5.dE
            int r0 = r0.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r5.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x03b0
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r5.eu
            if (r4 == 0) goto L_0x03b0
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r5.eu
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x03ae
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r5.eu
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dC
            int r4 = r4.ad()
            goto L_0x03af
        L_0x03ae:
            r4 = 0
        L_0x03af:
            int r0 = r0 + r4
        L_0x03b0:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r5.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            int r0 = -r0
            r11 = 2
            r15.b(r9, r4, r0, r11)
            if (r1 != r3) goto L_0x043d
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.dC
            int r0 = r0.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x03f0
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x03f0
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            if (r3 != r7) goto L_0x03f0
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.dE
            int r3 = r3.ad()
            int r0 = r0 + r3
        L_0x03f0:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.SolverVariable r3 = r3.f0do
            r4 = 2
            r15.a(r14, r3, r0, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.dE
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r6.eE
            r4 = 3
            r3 = r3[r4]
            if (r7 != r3) goto L_0x040a
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.eE
            r3 = 1
            r0 = r0[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.dE
        L_0x040a:
            int r3 = r0.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.di
            if (r4 == 0) goto L_0x0433
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x0433
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            if (r4 != r7) goto L_0x0433
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.di
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dC
            int r4 = r4.ad()
            int r3 = r3 + r4
        L_0x0433:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            int r3 = -r3
            r4 = 2
            r15.b(r2, r0, r3, r4)
            goto L_0x043e
        L_0x043d:
            r4 = 2
        L_0x043e:
            int r0 = r12.dA
            if (r0 <= 0) goto L_0x0447
            int r0 = r12.dA
            r15.b(r9, r8, r0, r4)
        L_0x0447:
            android.support.constraint.solver.b r0 = r34.Y()
            float r3 = r5.es
            float r11 = r7.es
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r5.dC
            int r21 = r4.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r5.dE
            int r23 = r4.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r7.dC
            int r25 = r4.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r7.dE
            int r27 = r4.ad()
            r16 = r0
            r17 = r3
            r18 = r10
            r19 = r11
            r20 = r8
            r22 = r9
            r24 = r14
            r26 = r2
            r16.a(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r15.b((android.support.constraint.solver.b) r0)
            r0 = r28
            r2 = 2
            r4 = 1
            r11 = 3
            r14 = 0
            goto L_0x0321
        L_0x0485:
            r0 = r1
            r2 = r16
            r4 = r2
            r7 = 0
        L_0x048a:
            if (r0 == 0) goto L_0x0620
            android.support.constraint.solver.widgets.ConstraintWidget r8 = r0.eu
            if (r8 != 0) goto L_0x0498
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r6.eE
            r7 = 1
            r2 = r2[r7]
            r14 = r2
            r2 = 1
            goto L_0x049a
        L_0x0498:
            r14 = r2
            r2 = r7
        L_0x049a:
            if (r5 == 0) goto L_0x0515
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.dC
            int r9 = r7.ad()
            if (r4 == 0) goto L_0x04ab
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.dE
            int r4 = r4.ad()
            int r9 = r9 + r4
        L_0x04ab:
            if (r1 == r0) goto L_0x04af
            r4 = 3
            goto L_0x04b0
        L_0x04af:
            r4 = 1
        L_0x04b0:
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r7.di
            if (r10 == 0) goto L_0x04bb
            android.support.constraint.solver.SolverVariable r10 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r7.di
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            goto L_0x04d5
        L_0x04bb:
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r0.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r10.di
            if (r10 == 0) goto L_0x04d2
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r0.dF
            android.support.constraint.solver.SolverVariable r10 = r10.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r0.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            int r17 = r7.ad()
            int r9 = r9 - r17
            goto L_0x04d5
        L_0x04d2:
            r10 = r16
            r11 = r10
        L_0x04d5:
            if (r10 == 0) goto L_0x04dc
            if (r11 == 0) goto L_0x04dc
            r15.a(r10, r11, r9, r4)
        L_0x04dc:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r0.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r9) goto L_0x0513
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.dE
            int r9 = r0.dw
            r10 = 1
            if (r9 != r10) goto L_0x04fd
            int r9 = r0.dz
            int r10 = r0.getHeight()
            int r9 = java.lang.Math.max(r9, r10)
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            r11 = 3
            r15.c(r4, r7, r9, r11)
            goto L_0x0572
        L_0x04fd:
            r11 = 3
            android.support.constraint.solver.SolverVariable r9 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r7.di
            android.support.constraint.solver.SolverVariable r10 = r10.f0do
            int r6 = r7.mMargin
            r15.a(r9, r10, r6, r11)
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            android.support.constraint.solver.SolverVariable r6 = r7.f0do
            int r7 = r0.dz
            r15.b(r4, r6, r7, r11)
            goto L_0x0572
        L_0x0513:
            r11 = 3
            goto L_0x0572
        L_0x0515:
            r11 = 3
            r6 = 5
            if (r3 != 0) goto L_0x0547
            if (r2 == 0) goto L_0x0547
            if (r4 == 0) goto L_0x0547
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 != 0) goto L_0x0532
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.dE
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            int r6 = r0.ai()
            int r7 = r0.dQ
            int r6 = r6 + r7
            r15.b(r4, r6)
            goto L_0x0572
        L_0x0532:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.dE
            int r4 = r4.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.dE
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r14.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            android.support.constraint.solver.SolverVariable r9 = r9.f0do
            int r4 = -r4
            r15.c(r7, r9, r4, r6)
            goto L_0x0572
        L_0x0547:
            if (r3 != 0) goto L_0x057f
            if (r2 != 0) goto L_0x057f
            if (r4 != 0) goto L_0x057f
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 != 0) goto L_0x055f
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.dC
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            int r6 = r0.ai()
            r15.b(r4, r6)
            goto L_0x0572
        L_0x055f:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.dC
            int r4 = r4.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.dC
            android.support.constraint.solver.SolverVariable r7 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r12.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            android.support.constraint.solver.SolverVariable r9 = r9.f0do
            r15.c(r7, r9, r4, r6)
        L_0x0572:
            r29 = r0
            r30 = r3
            r3 = r8
            r0 = r12
            r4 = r13
            r17 = r14
        L_0x057b:
            r18 = 0
            goto L_0x060e
        L_0x057f:
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r0.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.dE
            int r10 = r6.ad()
            int r9 = r7.ad()
            android.support.constraint.solver.SolverVariable r11 = r6.f0do
            r29 = r0
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r6.di
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            r30 = r3
            r3 = 1
            r15.a(r11, r0, r10, r3)
            android.support.constraint.solver.SolverVariable r0 = r7.f0do
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r7.di
            android.support.constraint.solver.SolverVariable r11 = r11.f0do
            r31 = r13
            int r13 = -r9
            r15.b(r0, r11, r13, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r6.di
            if (r0 == 0) goto L_0x05ae
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r6.di
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            goto L_0x05b0
        L_0x05ae:
            r0 = r16
        L_0x05b0:
            if (r4 != 0) goto L_0x05c1
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            if (r0 == 0) goto L_0x05bf
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r12.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.di
            android.support.constraint.solver.SolverVariable r0 = r0.f0do
            goto L_0x05c1
        L_0x05bf:
            r0 = r16
        L_0x05c1:
            if (r8 != 0) goto L_0x05d3
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r14.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x05d1
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r14.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            r8 = r3
            goto L_0x05d3
        L_0x05d1:
            r8 = r16
        L_0x05d3:
            r3 = r8
            if (r3 == 0) goto L_0x0607
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.dC
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            if (r2 == 0) goto L_0x05eb
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r14.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            if (r4 == 0) goto L_0x05e9
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r14.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.di
            android.support.constraint.solver.SolverVariable r4 = r4.f0do
            goto L_0x05eb
        L_0x05e9:
            r4 = r16
        L_0x05eb:
            if (r0 == 0) goto L_0x0607
            if (r4 == 0) goto L_0x0607
            android.support.constraint.solver.SolverVariable r8 = r6.f0do
            r11 = 1056964608(0x3f000000, float:0.5)
            android.support.constraint.solver.SolverVariable r13 = r7.f0do
            r7 = r34
            r6 = r9
            r9 = r0
            r0 = 3
            r0 = r12
            r12 = r4
            r4 = r31
            r17 = r14
            r18 = 0
            r14 = r6
            r7.b(r8, r9, r10, r11, r12, r13, r14)
            goto L_0x060e
        L_0x0607:
            r0 = r12
            r17 = r14
            r4 = r31
            goto L_0x057b
        L_0x060e:
            if (r2 == 0) goto L_0x0612
            r3 = r16
        L_0x0612:
            r12 = r0
            r7 = r2
            r0 = r3
            r13 = r4
            r2 = r17
            r4 = r29
            r3 = r30
            r6 = r33
            goto L_0x048a
        L_0x0620:
            r0 = r12
            r4 = r13
            r18 = 0
            if (r5 == 0) goto L_0x066c
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.dE
            int r10 = r1.ad()
            int r14 = r3.ad()
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x0640
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r0.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.SolverVariable r5 = r5.f0do
            r9 = r5
            goto L_0x0642
        L_0x0640:
            r9 = r16
        L_0x0642:
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r2.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r5 == 0) goto L_0x0650
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.di
            android.support.constraint.solver.SolverVariable r2 = r2.f0do
            r12 = r2
            goto L_0x0652
        L_0x0650:
            r12 = r16
        L_0x0652:
            if (r9 == 0) goto L_0x066c
            if (r12 == 0) goto L_0x066c
            android.support.constraint.solver.SolverVariable r2 = r3.f0do
            int r5 = -r14
            r6 = 1
            r15.b(r2, r12, r5, r6)
            android.support.constraint.solver.SolverVariable r8 = r1.f0do
            float r11 = r0.dY
            android.support.constraint.solver.SolverVariable r13 = r3.f0do
            r7 = r34
            r7.b(r8, r9, r10, r11, r12, r13, r14)
            goto L_0x066c
        L_0x0669:
            r4 = r13
            r18 = r14
        L_0x066c:
            int r13 = r4 + 1
            r14 = r18
            r6 = r33
            goto L_0x0006
        L_0x0674:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.a.d(android.support.constraint.solver.e):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ar() {
        /*
            r30 = this;
            r1 = r30
            int r2 = r1.mX
            int r3 = r1.mY
            int r0 = r30.getWidth()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r30.getHeight()
            int r6 = java.lang.Math.max(r4, r0)
            r1.eF = r4
            r1.eG = r4
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r1.dK
            r7 = 0
            if (r0 == 0) goto L_0x009d
            android.support.constraint.solver.widgets.d r0 = r1.ex
            if (r0 != 0) goto L_0x002b
            android.support.constraint.solver.widgets.d r0 = new android.support.constraint.solver.widgets.d
            r0.<init>(r1)
            r1.ex = r0
        L_0x002b:
            android.support.constraint.solver.widgets.d r0 = r1.ex
            int r8 = r30.getX()
            r0.mX = r8
            int r8 = r30.getY()
            r0.mY = r8
            int r8 = r30.getWidth()
            r0.mWidth = r8
            int r8 = r30.getHeight()
            r0.mHeight = r8
            java.util.ArrayList<android.support.constraint.solver.widgets.d$a> r8 = r0.eL
            int r8 = r8.size()
            r9 = r4
        L_0x004c:
            if (r9 >= r8) goto L_0x008c
            java.util.ArrayList<android.support.constraint.solver.widgets.d$a> r10 = r0.eL
            java.lang.Object r10 = r10.get(r9)
            android.support.constraint.solver.widgets.d$a r10 = (android.support.constraint.solver.widgets.d.a) r10
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.eK
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r11 = r11.dh
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r1.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r11)
            r10.eK = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.eK
            if (r11 == 0) goto L_0x007f
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.eK
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            r10.di = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.eK
            int r11 = r11.ad()
            r10.mMargin = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.eK
            android.support.constraint.solver.widgets.ConstraintAnchor$Strength r11 = r11.dk
            r10.eM = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.eK
            int r11 = r11.dm
            r10.eN = r11
            goto L_0x0089
        L_0x007f:
            r10.di = r7
            r10.mMargin = r4
            android.support.constraint.solver.widgets.ConstraintAnchor$Strength r11 = android.support.constraint.solver.widgets.ConstraintAnchor.Strength.STRONG
            r10.eM = r11
            r10.eN = r4
        L_0x0089:
            int r9 = r9 + 1
            goto L_0x004c
        L_0x008c:
            r1.setX(r4)
            r1.setY(r4)
            r30.ap()
            android.support.constraint.solver.e r0 = r1.ew
            android.support.constraint.solver.c r0 = r0.cv
            r1.a((android.support.constraint.solver.c) r0)
            goto L_0x00a1
        L_0x009d:
            r1.mX = r4
            r1.mY = r4
        L_0x00a1:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r1.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r1.dZ
            int r0 = r1.bb
            r11 = 2
            r12 = 1
            if (r0 != r11) goto L_0x0231
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r1.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 == r13) goto L_0x00b7
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r1.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x0231
        L_0x00b7:
            java.util.ArrayList r0 = r1.mChildren
            boolean[] r13 = r1.eD
            int r14 = r0.size()
            r13[r4] = r12
            r7 = r4
            r11 = r7
            r12 = r11
            r15 = r12
            r18 = r15
            r19 = r18
            r20 = r19
        L_0x00cb:
            if (r15 >= r14) goto L_0x0194
            java.lang.Object r21 = r0.get(r15)
            r10 = r21
            android.support.constraint.solver.widgets.ConstraintWidget r10 = (android.support.constraint.solver.widgets.ConstraintWidget) r10
            boolean r21 = r10.ae()
            if (r21 != 0) goto L_0x0181
            boolean r4 = r10.el
            if (r4 != 0) goto L_0x00e2
            r1.a((android.support.constraint.solver.widgets.ConstraintWidget) r10, (boolean[]) r13)
        L_0x00e2:
            boolean r4 = r10.em
            if (r4 != 0) goto L_0x00e9
            r1.b(r10, r13)
        L_0x00e9:
            r4 = 0
            boolean r21 = r13[r4]
            if (r21 == 0) goto L_0x017e
            int r4 = r10.ee
            r23 = r13
            int r13 = r10.ef
            int r4 = r4 + r13
            int r13 = r10.getWidth()
            int r4 = r4 - r13
            int r13 = r10.ed
            r24 = r4
            int r4 = r10.eg
            int r13 = r13 + r4
            int r4 = r10.getHeight()
            int r13 = r13 - r4
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r10.dZ
            r25 = r13
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r4 != r13) goto L_0x011d
            int r4 = r10.getWidth()
            android.support.constraint.solver.widgets.ConstraintAnchor r13 = r10.dB
            int r13 = r13.mMargin
            int r4 = r4 + r13
            android.support.constraint.solver.widgets.ConstraintAnchor r13 = r10.dD
            int r13 = r13.mMargin
            int r4 = r4 + r13
            goto L_0x011f
        L_0x011d:
            r4 = r24
        L_0x011f:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = r10.eb
            r26 = r4
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r13 != r4) goto L_0x0136
            int r4 = r10.getHeight()
            android.support.constraint.solver.widgets.ConstraintAnchor r13 = r10.dC
            int r13 = r13.mMargin
            int r4 = r4 + r13
            android.support.constraint.solver.widgets.ConstraintAnchor r13 = r10.dE
            int r13 = r13.mMargin
            int r4 = r4 + r13
            goto L_0x0138
        L_0x0136:
            r4 = r25
        L_0x0138:
            int r13 = r10.mVisibility
            r27 = r4
            r4 = 8
            if (r13 != r4) goto L_0x0145
            r28 = r3
            r4 = 0
            r13 = 0
            goto L_0x014b
        L_0x0145:
            r28 = r3
            r4 = r26
            r13 = r27
        L_0x014b:
            int r3 = r10.ee
            int r3 = java.lang.Math.max(r7, r3)
            int r7 = r10.ef
            int r7 = java.lang.Math.max(r11, r7)
            int r11 = r10.eg
            r29 = r3
            r3 = r19
            int r3 = java.lang.Math.max(r3, r11)
            int r10 = r10.ed
            r11 = r18
            int r10 = java.lang.Math.max(r11, r10)
            int r4 = java.lang.Math.max(r12, r4)
            r11 = r20
            int r11 = java.lang.Math.max(r11, r13)
            r19 = r3
            r12 = r4
            r18 = r10
            r20 = r11
            r11 = r7
            r7 = r29
            goto L_0x018b
        L_0x017e:
            r28 = r3
            goto L_0x01d5
        L_0x0181:
            r28 = r3
            r23 = r13
            r4 = r18
            r3 = r19
            r10 = r20
        L_0x018b:
            int r15 = r15 + 1
            r13 = r23
            r3 = r28
            r4 = 0
            goto L_0x00cb
        L_0x0194:
            r28 = r3
            r4 = r18
            r3 = r19
            r10 = r20
            int r7 = java.lang.Math.max(r7, r11)
            int r11 = r1.mMinWidth
            int r7 = java.lang.Math.max(r7, r12)
            int r7 = java.lang.Math.max(r11, r7)
            r1.dU = r7
            int r3 = java.lang.Math.max(r4, r3)
            int r4 = r1.mMinHeight
            int r3 = java.lang.Math.max(r3, r10)
            int r3 = java.lang.Math.max(r4, r3)
            r1.dV = r3
            r3 = 0
        L_0x01bd:
            if (r3 >= r14) goto L_0x01d5
            java.lang.Object r4 = r0.get(r3)
            android.support.constraint.solver.widgets.ConstraintWidget r4 = (android.support.constraint.solver.widgets.ConstraintWidget) r4
            r7 = 0
            r4.el = r7
            r4.em = r7
            r4.eh = r7
            r4.ei = r7
            r4.ej = r7
            r4.ek = r7
            int r3 = r3 + 1
            goto L_0x01bd
        L_0x01d5:
            r7 = 0
            boolean[] r0 = r1.eD
            boolean r0 = r0[r7]
            if (r5 <= 0) goto L_0x01e8
            if (r6 <= 0) goto L_0x01e8
            int r3 = r1.dU
            if (r3 > r5) goto L_0x01e6
            int r3 = r1.dV
            if (r3 <= r6) goto L_0x01e8
        L_0x01e6:
            r4 = 0
            goto L_0x01e9
        L_0x01e8:
            r4 = r0
        L_0x01e9:
            if (r4 == 0) goto L_0x022f
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r1.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x020d
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.dZ = r0
            if (r5 <= 0) goto L_0x0202
            int r0 = r1.dU
            if (r5 >= r0) goto L_0x0202
            r3 = 1
            r1.eF = r3
            r1.setWidth(r5)
            goto L_0x020d
        L_0x0202:
            int r0 = r1.mMinWidth
            int r3 = r1.dU
            int r0 = java.lang.Math.max(r0, r3)
            r1.setWidth(r0)
        L_0x020d:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r1.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x022f
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.eb = r0
            if (r6 <= 0) goto L_0x0224
            int r0 = r1.dV
            if (r6 >= r0) goto L_0x0224
            r3 = 1
            r1.eG = r3
            r1.setHeight(r6)
            goto L_0x022f
        L_0x0224:
            int r0 = r1.mMinHeight
            int r3 = r1.dV
            int r0 = java.lang.Math.max(r0, r3)
            r1.setHeight(r0)
        L_0x022f:
            r3 = 0
            goto L_0x0235
        L_0x0231:
            r28 = r3
            r3 = 0
            r4 = 0
        L_0x0235:
            r1.ey = r3
            r1.ez = r3
            java.util.ArrayList r0 = r1.mChildren
            int r3 = r0.size()
            r0 = 0
        L_0x0240:
            if (r0 >= r3) goto L_0x0256
            java.util.ArrayList r7 = r1.mChildren
            java.lang.Object r7 = r7.get(r0)
            android.support.constraint.solver.widgets.ConstraintWidget r7 = (android.support.constraint.solver.widgets.ConstraintWidget) r7
            boolean r10 = r7 instanceof android.support.constraint.solver.widgets.e
            if (r10 == 0) goto L_0x0253
            android.support.constraint.solver.widgets.e r7 = (android.support.constraint.solver.widgets.e) r7
            r7.ar()
        L_0x0253:
            int r0 = r0 + 1
            goto L_0x0240
        L_0x0256:
            r12 = r4
            r0 = 0
            r4 = 1
        L_0x0259:
            if (r4 == 0) goto L_0x03ef
            r7 = 1
            int r10 = r0 + 1
            android.support.constraint.solver.e r0 = r1.ew     // Catch:{ Exception -> 0x028c }
            r0.reset()     // Catch:{ Exception -> 0x028c }
            android.support.constraint.solver.e r0 = r1.ew     // Catch:{ Exception -> 0x028c }
            boolean r7 = r1.c(r0)     // Catch:{ Exception -> 0x028c }
            if (r7 == 0) goto L_0x0291
            android.support.constraint.solver.e r0 = r1.ew     // Catch:{ Exception -> 0x028a }
            android.support.constraint.solver.d r4 = r0.cM     // Catch:{ Exception -> 0x028a }
            r4.a(r0)     // Catch:{ Exception -> 0x028a }
            r0.b((android.support.constraint.solver.d) r4)     // Catch:{ Exception -> 0x028a }
            r0.a((android.support.constraint.solver.d) r4)     // Catch:{ Exception -> 0x028a }
            r4 = 0
        L_0x0279:
            int r11 = r0.cR     // Catch:{ Exception -> 0x028a }
            if (r4 >= r11) goto L_0x0291
            android.support.constraint.solver.b[] r11 = r0.cO     // Catch:{ Exception -> 0x028a }
            r11 = r11[r4]     // Catch:{ Exception -> 0x028a }
            android.support.constraint.solver.SolverVariable r13 = r11.cD     // Catch:{ Exception -> 0x028a }
            float r11 = r11.cE     // Catch:{ Exception -> 0x028a }
            r13.da = r11     // Catch:{ Exception -> 0x028a }
            int r4 = r4 + 1
            goto L_0x0279
        L_0x028a:
            r0 = move-exception
            goto L_0x028e
        L_0x028c:
            r0 = move-exception
            r7 = r4
        L_0x028e:
            r0.printStackTrace()
        L_0x0291:
            if (r7 == 0) goto L_0x02de
            boolean[] r0 = r1.eD
            r4 = 0
            r7 = 2
            r0[r7] = r4
            r30.aq()
            java.util.ArrayList r7 = r1.mChildren
            int r7 = r7.size()
            r11 = r4
        L_0x02a3:
            if (r11 >= r7) goto L_0x02da
            java.util.ArrayList r13 = r1.mChildren
            java.lang.Object r13 = r13.get(r11)
            android.support.constraint.solver.widgets.ConstraintWidget r13 = (android.support.constraint.solver.widgets.ConstraintWidget) r13
            r13.aq()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = r13.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r14 != r15) goto L_0x02c3
            int r14 = r13.getWidth()
            int r15 = r13.dU
            if (r14 >= r15) goto L_0x02c3
            r14 = 1
            r15 = 2
            r0[r15] = r14
            goto L_0x02c5
        L_0x02c3:
            r14 = 1
            r15 = 2
        L_0x02c5:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r13.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r14) goto L_0x02d6
            int r4 = r13.getHeight()
            int r13 = r13.dV
            if (r4 >= r13) goto L_0x02d6
            r4 = 1
            r0[r15] = r4
        L_0x02d6:
            int r11 = r11 + 1
            r4 = 0
            goto L_0x02a3
        L_0x02da:
            r4 = 8
            r11 = 2
            goto L_0x031c
        L_0x02de:
            r30.aq()
            r0 = 0
        L_0x02e2:
            if (r0 >= r3) goto L_0x0319
            java.util.ArrayList r4 = r1.mChildren
            java.lang.Object r4 = r4.get(r0)
            android.support.constraint.solver.widgets.ConstraintWidget r4 = (android.support.constraint.solver.widgets.ConstraintWidget) r4
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r4.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 != r11) goto L_0x0301
            int r7 = r4.getWidth()
            int r11 = r4.dU
            if (r7 >= r11) goto L_0x0301
            boolean[] r0 = r1.eD
            r7 = 1
            r11 = 2
            r0[r11] = r7
            goto L_0x031a
        L_0x0301:
            r7 = 1
            r11 = 2
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = r4.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r13 != r14) goto L_0x0316
            int r13 = r4.getHeight()
            int r4 = r4.dV
            if (r13 >= r4) goto L_0x0316
            boolean[] r0 = r1.eD
            r0[r11] = r7
            goto L_0x031a
        L_0x0316:
            int r0 = r0 + 1
            goto L_0x02e2
        L_0x0319:
            r11 = 2
        L_0x031a:
            r4 = 8
        L_0x031c:
            if (r10 >= r4) goto L_0x0380
            boolean[] r0 = r1.eD
            boolean r0 = r0[r11]
            if (r0 == 0) goto L_0x0380
            r0 = 0
            r7 = 0
            r13 = 0
        L_0x0327:
            if (r0 >= r3) goto L_0x034b
            java.util.ArrayList r14 = r1.mChildren
            java.lang.Object r14 = r14.get(r0)
            android.support.constraint.solver.widgets.ConstraintWidget r14 = (android.support.constraint.solver.widgets.ConstraintWidget) r14
            int r15 = r14.mX
            int r16 = r14.getWidth()
            int r15 = r15 + r16
            int r7 = java.lang.Math.max(r7, r15)
            int r15 = r14.mY
            int r14 = r14.getHeight()
            int r15 = r15 + r14
            int r13 = java.lang.Math.max(r13, r15)
            int r0 = r0 + 1
            goto L_0x0327
        L_0x034b:
            int r0 = r1.mMinWidth
            int r0 = java.lang.Math.max(r0, r7)
            int r7 = r1.mMinHeight
            int r7 = java.lang.Math.max(r7, r13)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 != r13) goto L_0x036b
            int r13 = r30.getWidth()
            if (r13 >= r0) goto L_0x036b
            r1.setWidth(r0)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r1.dZ = r0
            r0 = 1
            r12 = 1
            goto L_0x036c
        L_0x036b:
            r0 = 0
        L_0x036c:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r13) goto L_0x0381
            int r13 = r30.getHeight()
            if (r13 >= r7) goto L_0x0381
            r1.setHeight(r7)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r1.eb = r0
            r0 = 1
            r12 = 1
            goto L_0x0381
        L_0x0380:
            r0 = 0
        L_0x0381:
            int r7 = r1.mMinWidth
            int r13 = r30.getWidth()
            int r7 = java.lang.Math.max(r7, r13)
            int r13 = r30.getWidth()
            if (r7 <= r13) goto L_0x039a
            r1.setWidth(r7)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.dZ = r0
            r0 = 1
            r12 = 1
        L_0x039a:
            int r7 = r1.mMinHeight
            int r13 = r30.getHeight()
            int r7 = java.lang.Math.max(r7, r13)
            int r13 = r30.getHeight()
            if (r7 <= r13) goto L_0x03b3
            r1.setHeight(r7)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.eb = r0
            r0 = 1
            r12 = 1
        L_0x03b3:
            if (r12 != 0) goto L_0x03ea
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r1.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r13) goto L_0x03cf
            if (r5 <= 0) goto L_0x03cf
            int r7 = r30.getWidth()
            if (r7 <= r5) goto L_0x03cf
            r7 = 1
            r1.eF = r7
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.dZ = r0
            r1.setWidth(r5)
            r0 = 1
            r12 = 1
        L_0x03cf:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r1.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r13) goto L_0x03ea
            if (r6 <= 0) goto L_0x03ea
            int r7 = r30.getHeight()
            if (r7 <= r6) goto L_0x03ea
            r7 = 1
            r1.eG = r7
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.eb = r0
            r1.setHeight(r6)
            r0 = r7
            r12 = r0
            goto L_0x03eb
        L_0x03ea:
            r7 = 1
        L_0x03eb:
            r4 = r0
            r0 = r10
            goto L_0x0259
        L_0x03ef:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r1.dK
            if (r0 == 0) goto L_0x0457
            int r0 = r1.mMinWidth
            int r2 = r30.getWidth()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r1.mMinHeight
            int r3 = r30.getHeight()
            int r2 = java.lang.Math.max(r2, r3)
            android.support.constraint.solver.widgets.d r3 = r1.ex
            int r4 = r3.mX
            r1.setX(r4)
            int r4 = r3.mY
            r1.setY(r4)
            int r4 = r3.mWidth
            r1.setWidth(r4)
            int r4 = r3.mHeight
            r1.setHeight(r4)
            java.util.ArrayList<android.support.constraint.solver.widgets.d$a> r4 = r3.eL
            int r4 = r4.size()
            r5 = 0
        L_0x0424:
            if (r5 >= r4) goto L_0x0450
            java.util.ArrayList<android.support.constraint.solver.widgets.d$a> r6 = r3.eL
            java.lang.Object r6 = r6.get(r5)
            android.support.constraint.solver.widgets.d$a r6 = (android.support.constraint.solver.widgets.d.a) r6
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r6.eK
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r7 = r7.dh
            android.support.constraint.solver.widgets.ConstraintAnchor r16 = r1.a((android.support.constraint.solver.widgets.ConstraintAnchor.Type) r7)
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r6.di
            int r10 = r6.mMargin
            android.support.constraint.solver.widgets.ConstraintAnchor$Strength r11 = r6.eM
            int r6 = r6.eN
            r19 = -1
            r22 = 0
            r17 = r7
            r18 = r10
            r20 = r11
            r21 = r6
            r16.a(r17, r18, r19, r20, r21, r22)
            int r5 = r5 + 1
            goto L_0x0424
        L_0x0450:
            r1.setWidth(r0)
            r1.setHeight(r2)
            goto L_0x045d
        L_0x0457:
            r1.mX = r2
            r2 = r28
            r1.mY = r2
        L_0x045d:
            if (r12 == 0) goto L_0x0463
            r1.dZ = r9
            r1.eb = r8
        L_0x0463:
            android.support.constraint.solver.e r0 = r1.ew
            android.support.constraint.solver.c r0 = r0.cv
            r1.a((android.support.constraint.solver.c) r0)
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r1.dK
            boolean r2 = r1 instanceof android.support.constraint.solver.widgets.a
            if (r2 == 0) goto L_0x0474
            r7 = r1
            android.support.constraint.solver.widgets.a r7 = (android.support.constraint.solver.widgets.a) r7
            goto L_0x0475
        L_0x0474:
            r7 = 0
        L_0x0475:
            if (r0 == 0) goto L_0x0482
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r0.dK
            boolean r3 = r0 instanceof android.support.constraint.solver.widgets.a
            if (r3 == 0) goto L_0x0480
            r7 = r0
            android.support.constraint.solver.widgets.a r7 = (android.support.constraint.solver.widgets.a) r7
        L_0x0480:
            r0 = r2
            goto L_0x0475
        L_0x0482:
            if (r1 != r7) goto L_0x0487
            r30.ao()
        L_0x0487:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.a.ar():void");
    }

    private void a(ConstraintWidget constraintWidget, boolean[] zArr) {
        int i;
        int i2;
        ConstraintWidget constraintWidget2;
        int i3 = 0;
        if (constraintWidget.dZ == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.eb == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.dL > 0.0f) {
            zArr[0] = false;
            return;
        }
        int af = constraintWidget.af();
        if (constraintWidget.dZ != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.eb == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.dL <= 0.0f) {
            boolean z = true;
            constraintWidget.el = true;
            if (constraintWidget instanceof b) {
                b bVar = (b) constraintWidget;
                if (bVar.mOrientation != 1) {
                    i = af;
                    i3 = i;
                } else if (bVar.eI != -1) {
                    i = bVar.eI;
                } else if (bVar.eJ != -1) {
                    i3 = bVar.eJ;
                    i = 0;
                } else {
                    i = 0;
                }
                i2 = i3;
            } else if (!constraintWidget.dD.isConnected() && !constraintWidget.dB.isConnected()) {
                i = constraintWidget.getX() + af;
                i2 = af;
            } else if (constraintWidget.dD.di == null || constraintWidget.dB.di == null || (constraintWidget.dD.di != constraintWidget.dB.di && (constraintWidget.dD.di.dg != constraintWidget.dB.di.dg || constraintWidget.dD.di.dg == constraintWidget.dK))) {
                ConstraintWidget constraintWidget3 = null;
                if (constraintWidget.dD.di != null) {
                    constraintWidget2 = constraintWidget.dD.di.dg;
                    i2 = constraintWidget.dD.ad() + af;
                    if (!constraintWidget2.ae() && !constraintWidget2.el) {
                        a(constraintWidget2, zArr);
                    }
                } else {
                    i2 = af;
                    constraintWidget2 = null;
                }
                if (constraintWidget.dB.di != null) {
                    constraintWidget3 = constraintWidget.dB.di.dg;
                    af += constraintWidget.dB.ad();
                    if (!constraintWidget3.ae() && !constraintWidget3.el) {
                        a(constraintWidget3, zArr);
                    }
                }
                i = af;
                if (constraintWidget.dD.di != null && !constraintWidget2.ae()) {
                    if (constraintWidget.dD.di.dh == ConstraintAnchor.Type.RIGHT) {
                        i2 += constraintWidget2.ef - constraintWidget2.af();
                    } else if (constraintWidget.dD.di.dh == ConstraintAnchor.Type.LEFT) {
                        i2 += constraintWidget2.ef;
                    }
                    constraintWidget.ei = constraintWidget2.ei || !(constraintWidget2.dB.di == null || constraintWidget2.dD.di == null || constraintWidget2.dZ == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    if (constraintWidget.ei && (constraintWidget2.dB.di == null || constraintWidget2.dB.di.dg != constraintWidget)) {
                        i2 += i2 - constraintWidget2.ef;
                    }
                }
                if (constraintWidget.dB.di != null && !constraintWidget3.ae()) {
                    if (constraintWidget.dB.di.dh == ConstraintAnchor.Type.LEFT) {
                        i += constraintWidget3.ee - constraintWidget3.af();
                    } else if (constraintWidget.dB.di.dh == ConstraintAnchor.Type.RIGHT) {
                        i += constraintWidget3.ee;
                    }
                    if (!constraintWidget3.eh && (constraintWidget3.dB.di == null || constraintWidget3.dD.di == null || constraintWidget3.dZ == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
                        z = false;
                    }
                    constraintWidget.eh = z;
                    if (constraintWidget.eh && (constraintWidget3.dD.di == null || constraintWidget3.dD.di.dg != constraintWidget)) {
                        i += i - constraintWidget3.ee;
                    }
                }
            } else {
                zArr[0] = false;
                return;
            }
            if (constraintWidget.mVisibility == 8) {
                i -= constraintWidget.mWidth;
                i2 -= constraintWidget.mWidth;
            }
            constraintWidget.ee = i;
            constraintWidget.ef = i2;
            return;
        }
        zArr[0] = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x01f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.support.constraint.solver.widgets.ConstraintWidget r10, boolean[] r11) {
        /*
            r9 = this;
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r10.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r2 = 0
            if (r0 != r1) goto L_0x0017
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r10.dZ
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 == r1) goto L_0x0017
            float r0 = r10.dL
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0017
            r11[r2] = r2
            return
        L_0x0017:
            int r0 = r10.ag()
            r1 = 1
            r10.em = r1
            boolean r3 = r10 instanceof android.support.constraint.solver.widgets.b
            r4 = 8
            if (r3 == 0) goto L_0x0044
            r9 = r10
            android.support.constraint.solver.widgets.b r9 = (android.support.constraint.solver.widgets.b) r9
            int r11 = r9.mOrientation
            if (r11 != 0) goto L_0x003f
            int r11 = r9.eI
            r0 = -1
            if (r11 == r0) goto L_0x0033
            int r9 = r9.eI
            goto L_0x0041
        L_0x0033:
            int r11 = r9.eJ
            if (r11 == r0) goto L_0x003d
            int r9 = r9.eJ
            r8 = r2
            r2 = r9
            r9 = r8
            goto L_0x0041
        L_0x003d:
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r0
            r2 = r9
        L_0x0041:
            r0 = r2
            goto L_0x01ee
        L_0x0044:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 != 0) goto L_0x005d
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 != 0) goto L_0x005d
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 != 0) goto L_0x005d
            int r9 = r10.getY()
            int r9 = r9 + r0
            goto L_0x01ee
        L_0x005d:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x008e
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            if (r3 == 0) goto L_0x008e
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            if (r3 == r5) goto L_0x008b
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            if (r3 != r5) goto L_0x008e
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r10.dK
            if (r3 == r5) goto L_0x008e
        L_0x008b:
            r11[r2] = r2
            return
        L_0x008e:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dF
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x00c6
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r10.dF
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.di
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r1.dg
            boolean r2 = r1.em
            if (r2 != 0) goto L_0x00a3
            r9.b(r1, r11)
        L_0x00a3:
            int r9 = r1.ed
            int r11 = r1.mHeight
            int r9 = r9 - r11
            int r9 = r9 + r0
            int r9 = java.lang.Math.max(r9, r0)
            int r11 = r1.eg
            int r1 = r1.mHeight
            int r11 = r11 - r1
            int r11 = r11 + r0
            int r11 = java.lang.Math.max(r11, r0)
            int r0 = r10.mVisibility
            if (r0 != r4) goto L_0x00c1
            int r0 = r10.mHeight
            int r9 = r9 - r0
            int r0 = r10.mHeight
            int r11 = r11 - r0
        L_0x00c1:
            r10.ed = r9
            r10.eg = r11
            return
        L_0x00c6:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            boolean r3 = r3.isConnected()
            r5 = 0
            if (r3 == 0) goto L_0x00ea
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.di
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r10.dC
            int r6 = r6.ad()
            int r6 = r6 + r0
            boolean r7 = r3.ae()
            if (r7 != 0) goto L_0x00ec
            boolean r7 = r3.em
            if (r7 != 0) goto L_0x00ec
            r9.b(r3, r11)
            goto L_0x00ec
        L_0x00ea:
            r6 = r0
            r3 = r5
        L_0x00ec:
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r10.dE
            boolean r7 = r7.isConnected()
            if (r7 == 0) goto L_0x010e
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.di
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r5.dg
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r10.dE
            int r7 = r7.ad()
            int r0 = r0 + r7
            boolean r7 = r5.ae()
            if (r7 != 0) goto L_0x010e
            boolean r7 = r5.em
            if (r7 != 0) goto L_0x010e
            r9.b(r5, r11)
        L_0x010e:
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            if (r9 == 0) goto L_0x017d
            boolean r9 = r3.ae()
            if (r9 != 0) goto L_0x017d
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r9 = r9.dh
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r11 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r9 != r11) goto L_0x012d
            int r9 = r3.ed
            int r11 = r3.ag()
            int r9 = r9 - r11
            int r6 = r6 + r9
            goto L_0x013a
        L_0x012d:
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r10.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r9 = r9.dh
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r11 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r9 != r11) goto L_0x013a
            int r9 = r3.ed
            int r6 = r6 + r9
        L_0x013a:
            boolean r9 = r3.ej
            if (r9 != 0) goto L_0x0163
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r3.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            if (r9 == 0) goto L_0x0161
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r3.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r9.dg
            if (r9 == r10) goto L_0x0161
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r3.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            if (r9 == 0) goto L_0x0161
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r3.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r9.dg
            if (r9 == r10) goto L_0x0161
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r3.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 == r11) goto L_0x0161
            goto L_0x0163
        L_0x0161:
            r9 = r2
            goto L_0x0164
        L_0x0163:
            r9 = r1
        L_0x0164:
            r10.ej = r9
            boolean r9 = r10.ej
            if (r9 == 0) goto L_0x017d
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r3.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            if (r9 == 0) goto L_0x0178
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r3.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.di
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r9.dg
            if (r9 == r10) goto L_0x017d
        L_0x0178:
            int r9 = r3.ed
            int r9 = r6 - r9
            int r6 = r6 + r9
        L_0x017d:
            r9 = r6
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            if (r11 == 0) goto L_0x01ee
            boolean r11 = r5.ae()
            if (r11 != 0) goto L_0x01ee
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r11 = r11.dh
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r11 != r3) goto L_0x019d
            int r11 = r5.eg
            int r3 = r5.ag()
            int r11 = r11 - r3
            int r0 = r0 + r11
            goto L_0x01aa
        L_0x019d:
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r10.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r11 = r11.dh
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r11 != r3) goto L_0x01aa
            int r11 = r5.eg
            int r0 = r0 + r11
        L_0x01aa:
            boolean r11 = r5.ek
            if (r11 != 0) goto L_0x01d2
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            if (r11 == 0) goto L_0x01d1
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintWidget r11 = r11.dg
            if (r11 == r10) goto L_0x01d1
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            if (r11 == 0) goto L_0x01d1
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dE
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintWidget r11 = r11.dg
            if (r11 == r10) goto L_0x01d1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r5.eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 == r3) goto L_0x01d1
            goto L_0x01d2
        L_0x01d1:
            r1 = r2
        L_0x01d2:
            r10.ek = r1
            boolean r11 = r10.ek
            if (r11 == 0) goto L_0x01ee
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            if (r11 == 0) goto L_0x01e6
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.dC
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r11.di
            android.support.constraint.solver.widgets.ConstraintWidget r11 = r11.dg
            if (r11 == r10) goto L_0x01ee
        L_0x01e6:
            int r11 = r5.eg
            int r11 = r0 - r11
            int r2 = r0 + r11
            goto L_0x0041
        L_0x01ee:
            int r11 = r10.mVisibility
            if (r11 != r4) goto L_0x01f8
            int r11 = r10.mHeight
            int r9 = r9 - r11
            int r11 = r10.mHeight
            int r0 = r0 - r11
        L_0x01f8:
            r10.ed = r9
            r10.eg = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.a.b(android.support.constraint.solver.widgets.ConstraintWidget, boolean[]):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(ConstraintWidget constraintWidget, int i) {
        int i2 = 0;
        if (i == 0) {
            while (constraintWidget.dB.di != null && constraintWidget.dB.di.dg.dD.di != null && constraintWidget.dB.di.dg.dD.di == constraintWidget.dB && constraintWidget.dB.di.dg != constraintWidget) {
                constraintWidget = constraintWidget.dB.di.dg;
            }
            while (i2 < this.ey) {
                if (this.eC[i2] != constraintWidget) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.ey + 1 >= this.eC.length) {
                this.eC = (ConstraintWidget[]) Arrays.copyOf(this.eC, this.eC.length << 1);
            }
            this.eC[this.ey] = constraintWidget;
            this.ey++;
        } else if (i == 1) {
            while (constraintWidget.dC.di != null && constraintWidget.dC.di.dg.dE.di != null && constraintWidget.dC.di.dg.dE.di == constraintWidget.dC && constraintWidget.dC.di.dg != constraintWidget) {
                constraintWidget = constraintWidget.dC.di.dg;
            }
            while (i2 < this.ez) {
                if (this.eB[i2] != constraintWidget) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.ez + 1 >= this.eB.length) {
                this.eB = (ConstraintWidget[]) Arrays.copyOf(this.eB, this.eB.length << 1);
            }
            this.eB[this.ez] = constraintWidget;
            this.ez++;
        }
    }

    private int a(e eVar, ConstraintWidget[] constraintWidgetArr, ConstraintWidget constraintWidget, int i, boolean[] zArr) {
        int i2;
        char c2;
        char c3;
        e eVar2 = eVar;
        ConstraintWidget constraintWidget2 = constraintWidget;
        zArr[0] = true;
        zArr[1] = false;
        ConstraintWidget constraintWidget3 = null;
        constraintWidgetArr[0] = null;
        constraintWidgetArr[2] = null;
        constraintWidgetArr[1] = null;
        constraintWidgetArr[3] = null;
        float f = 0.0f;
        int i3 = 5;
        int i4 = 8;
        if (i == 0) {
            boolean z = constraintWidget2.dB.di == null || constraintWidget2.dB.di.dg == this;
            constraintWidget2.et = null;
            i2 = 0;
            ConstraintWidget constraintWidget4 = null;
            ConstraintWidget constraintWidget5 = constraintWidget2.mVisibility != 8 ? constraintWidget2 : null;
            ConstraintWidget constraintWidget6 = constraintWidget5;
            ConstraintWidget constraintWidget7 = constraintWidget2;
            while (constraintWidget7.dD.di != null) {
                constraintWidget7.et = constraintWidget3;
                if (constraintWidget7.mVisibility != 8) {
                    if (constraintWidget6 == null) {
                        constraintWidget6 = constraintWidget7;
                    }
                    if (!(constraintWidget5 == null || constraintWidget5 == constraintWidget7)) {
                        constraintWidget5.et = constraintWidget7;
                    }
                    constraintWidget5 = constraintWidget7;
                } else {
                    eVar2.c(constraintWidget7.dB.f0do, constraintWidget7.dB.di.f0do, 0, 5);
                    eVar2.c(constraintWidget7.dD.f0do, constraintWidget7.dB.f0do, 0, 5);
                }
                if (constraintWidget7.mVisibility != 8 && constraintWidget7.dZ == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget7.eb == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (constraintWidget7.dL <= f) {
                        zArr[0] = false;
                        int i5 = i2 + 1;
                        if (i5 >= this.eA.length) {
                            this.eA = (ConstraintWidget[]) Arrays.copyOf(this.eA, this.eA.length << 1);
                        }
                        this.eA[i2] = constraintWidget7;
                        i2 = i5;
                    }
                }
                if (constraintWidget7.dD.di.dg.dB.di == null || constraintWidget7.dD.di.dg.dB.di.dg != constraintWidget7 || constraintWidget7.dD.di.dg == constraintWidget7) {
                    break;
                }
                constraintWidget4 = constraintWidget7.dD.di.dg;
                constraintWidget7 = constraintWidget4;
                constraintWidget3 = null;
                f = 0.0f;
            }
            if (!(constraintWidget7.dD.di == null || constraintWidget7.dD.di.dg == this)) {
                z = false;
            }
            if (constraintWidget2.dB.di == null || constraintWidget4.dD.di == null) {
                c3 = 1;
                zArr[1] = true;
            } else {
                c3 = 1;
            }
            constraintWidget2.ep = z;
            constraintWidget4.et = null;
            constraintWidgetArr[0] = constraintWidget2;
            constraintWidgetArr[2] = constraintWidget6;
            constraintWidgetArr[c3] = constraintWidget4;
            constraintWidgetArr[3] = constraintWidget5;
        } else {
            boolean z2 = constraintWidget2.dC.di == null || constraintWidget2.dC.di.dg == this;
            ConstraintWidget constraintWidget8 = null;
            constraintWidget2.eu = null;
            int i6 = 0;
            ConstraintWidget constraintWidget9 = null;
            ConstraintWidget constraintWidget10 = constraintWidget2.mVisibility != 8 ? constraintWidget2 : null;
            ConstraintWidget constraintWidget11 = constraintWidget10;
            ConstraintWidget constraintWidget12 = constraintWidget2;
            while (constraintWidget12.dE.di != null) {
                constraintWidget12.eu = constraintWidget8;
                if (constraintWidget12.mVisibility != i4) {
                    if (constraintWidget10 == null) {
                        constraintWidget10 = constraintWidget12;
                    }
                    if (!(constraintWidget11 == null || constraintWidget11 == constraintWidget12)) {
                        constraintWidget11.eu = constraintWidget12;
                    }
                    constraintWidget11 = constraintWidget12;
                } else {
                    eVar2.c(constraintWidget12.dC.f0do, constraintWidget12.dC.di.f0do, 0, i3);
                    eVar2.c(constraintWidget12.dE.f0do, constraintWidget12.dC.f0do, 0, i3);
                }
                if (constraintWidget12.mVisibility != i4 && constraintWidget12.eb == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget12.dZ == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (constraintWidget12.dL <= 0.0f) {
                        zArr[0] = false;
                        int i7 = i6 + 1;
                        if (i7 >= this.eA.length) {
                            this.eA = (ConstraintWidget[]) Arrays.copyOf(this.eA, this.eA.length << 1);
                        }
                        this.eA[i6] = constraintWidget12;
                        i6 = i7;
                    }
                }
                if (constraintWidget12.dE.di.dg.dC.di == null || constraintWidget12.dE.di.dg.dC.di.dg != constraintWidget12 || constraintWidget12.dE.di.dg == constraintWidget12) {
                    break;
                }
                constraintWidget9 = constraintWidget12.dE.di.dg;
                constraintWidget12 = constraintWidget9;
                constraintWidget8 = null;
                i3 = 5;
                i4 = 8;
            }
            i2 = i6;
            if (!(constraintWidget12.dE.di == null || constraintWidget12.dE.di.dg == this)) {
                z2 = false;
            }
            if (constraintWidget2.dC.di == null || constraintWidget9.dE.di == null) {
                c2 = 1;
                zArr[1] = true;
            } else {
                c2 = 1;
            }
            constraintWidget2.eq = z2;
            constraintWidget9.eu = null;
            constraintWidgetArr[0] = constraintWidget2;
            constraintWidgetArr[2] = constraintWidget10;
            constraintWidgetArr[c2] = constraintWidget9;
            constraintWidgetArr[3] = constraintWidget11;
        }
        return i2;
    }
}
