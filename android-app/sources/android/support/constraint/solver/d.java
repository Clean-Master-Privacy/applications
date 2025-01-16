package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public final class d {
    ArrayList<SolverVariable> cK = new ArrayList<>();

    public final String toString() {
        String str = "Goal: ";
        for (int i = 0; i < this.cK.size(); i++) {
            str = str + this.cK.get(i).ab();
        }
        return str;
    }

    public final void a(e eVar) {
        e eVar2 = eVar;
        this.cK.clear();
        for (int i = 1; i < eVar2.cQ; i++) {
            SolverVariable solverVariable = eVar2.cv.cJ[i];
            for (int i2 = 0; i2 < 6; i2++) {
                solverVariable.db[i2] = 0.0f;
            }
            solverVariable.db[solverVariable.cZ] = 1.0f;
            if (solverVariable.dc == SolverVariable.Type.ERROR) {
                this.cK.add(solverVariable);
            }
        }
        int size = this.cK.size();
        for (int i3 = 0; i3 < size; i3++) {
            SolverVariable solverVariable2 = this.cK.get(i3);
            if (solverVariable2.cY != -1) {
                a aVar = eVar2.cO[solverVariable2.cY].cF;
                int i4 = aVar.ct;
                for (int i5 = 0; i5 < i4; i5++) {
                    SolverVariable i6 = aVar.i(i5);
                    if (i6 != null) {
                        float j = aVar.j(i5);
                        for (int i7 = 0; i7 < 6; i7++) {
                            float[] fArr = i6.db;
                            fArr[i7] = fArr[i7] + (solverVariable2.db[i7] * j);
                        }
                        if (!this.cK.contains(i6)) {
                            this.cK.add(i6);
                        }
                    }
                }
                for (int i8 = 0; i8 < 6; i8++) {
                    solverVariable2.db[i8] = 0.0f;
                }
            }
        }
    }
}
