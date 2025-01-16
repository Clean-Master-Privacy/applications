package android.support.constraint.solver;

import com.ijinshan.launcher.theme.CyclePlayCacheAbles;
import java.util.Arrays;

public final class b {
    public SolverVariable cD = null;
    public float cE = 0.0f;
    final a cF;
    boolean cG = false;

    public b(c cVar) {
        this.cF = new a(this, cVar);
    }

    /* access modifiers changed from: package-private */
    public final void V() {
        a aVar = this.cF;
        int i = aVar.cA;
        int i2 = 0;
        while (i != -1 && i2 < aVar.ct) {
            SolverVariable solverVariable = aVar.cv.cJ[aVar.cx[i]];
            int i3 = 0;
            while (true) {
                if (i3 < solverVariable.f344de) {
                    if (solverVariable.dd[i3] == this) {
                        break;
                    }
                    i3++;
                } else {
                    if (solverVariable.f344de >= solverVariable.dd.length) {
                        solverVariable.dd = (b[]) Arrays.copyOf(solverVariable.dd, solverVariable.dd.length << 1);
                    }
                    solverVariable.dd[solverVariable.f344de] = this;
                    solverVariable.f344de++;
                }
            }
            i = aVar.cy[i];
            i2++;
        }
    }

    public final b a(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.cE = (float) (i * -1);
            this.cF.a(solverVariable, 1.0f);
        } else {
            this.cE = (float) i;
            this.cF.a(solverVariable, -1.0f);
        }
        return this;
    }

    public final b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.cE = (float) i;
        }
        if (!z) {
            this.cF.a(solverVariable, -1.0f);
            this.cF.a(solverVariable2, 1.0f);
        } else {
            this.cF.a(solverVariable, 1.0f);
            this.cF.a(solverVariable2, -1.0f);
        }
        return this;
    }

    public final b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.cE = (float) i;
        }
        if (!z) {
            this.cF.a(solverVariable, -1.0f);
            this.cF.a(solverVariable2, 1.0f);
            this.cF.a(solverVariable3, 1.0f);
        } else {
            this.cF.a(solverVariable, 1.0f);
            this.cF.a(solverVariable2, -1.0f);
            this.cF.a(solverVariable3, -1.0f);
        }
        return this;
    }

    public final b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.cE = (float) i;
        }
        if (!z) {
            this.cF.a(solverVariable, -1.0f);
            this.cF.a(solverVariable2, 1.0f);
            this.cF.a(solverVariable3, -1.0f);
        } else {
            this.cF.a(solverVariable, 1.0f);
            this.cF.a(solverVariable2, -1.0f);
            this.cF.a(solverVariable3, 1.0f);
        }
        return this;
    }

    public final b a(float f, float f2, float f3, SolverVariable solverVariable, int i, SolverVariable solverVariable2, int i2, SolverVariable solverVariable3, int i3, SolverVariable solverVariable4, int i4) {
        if (f2 == 0.0f || f == f3) {
            this.cE = (float) (((-i) - i2) + i3 + i4);
            this.cF.a(solverVariable, 1.0f);
            this.cF.a(solverVariable2, -1.0f);
            this.cF.a(solverVariable4, 1.0f);
            this.cF.a(solverVariable3, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.cE = ((float) ((-i) - i2)) + (((float) i3) * f4) + (((float) i4) * f4);
            this.cF.a(solverVariable, 1.0f);
            this.cF.a(solverVariable2, -1.0f);
            this.cF.a(solverVariable4, f4);
            this.cF.a(solverVariable3, -f4);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.cF.a(solverVariable, 1.0f);
            this.cF.a(solverVariable4, 1.0f);
            this.cF.a(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.cF.a(solverVariable, 1.0f);
            this.cF.a(solverVariable2, -1.0f);
            this.cF.a(solverVariable3, -1.0f);
            this.cF.a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.cE = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            this.cF.a(solverVariable, -1.0f);
            this.cF.a(solverVariable2, 1.0f);
            this.cE = (float) i;
        } else if (f >= 1.0f) {
            this.cF.a(solverVariable3, -1.0f);
            this.cF.a(solverVariable4, 1.0f);
            this.cE = (float) i2;
        } else {
            float f2 = 1.0f - f;
            this.cF.a(solverVariable, 1.0f * f2);
            this.cF.a(solverVariable2, f2 * -1.0f);
            this.cF.a(solverVariable3, -1.0f * f);
            this.cF.a(solverVariable4, f);
            if (i > 0 || i2 > 0) {
                this.cE = (((float) (-i)) * f2) + (((float) i2) * f);
            }
        }
        return this;
    }

    public final b a(SolverVariable solverVariable, SolverVariable solverVariable2) {
        this.cF.a(solverVariable, 1.0f);
        this.cF.a(solverVariable2, -1.0f);
        return this;
    }

    public final b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.cF.a(solverVariable, -1.0f);
        this.cF.a(solverVariable2, 1.0f);
        this.cF.a(solverVariable3, f);
        this.cF.a(solverVariable4, -f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(b bVar) {
        this.cF.a(this, bVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void c(SolverVariable solverVariable) {
        if (this.cD != null) {
            this.cF.a(this.cD, -1.0f);
            this.cD = null;
        }
        float f = -this.cF.a(solverVariable);
        this.cD = solverVariable;
        if (f != 1.0f) {
            this.cE /= f;
            a aVar = this.cF;
            int i = aVar.cA;
            int i2 = 0;
            while (i != -1 && i2 < aVar.ct) {
                float[] fArr = aVar.cz;
                fArr[i] = fArr[i] / f;
                i = aVar.cy[i];
                i2++;
            }
        }
    }

    public final String toString() {
        String str;
        String str2;
        boolean z;
        String str3;
        if (this.cD == null) {
            str = "" + CyclePlayCacheAbles.NONE_TYPE;
        } else {
            str = "" + this.cD;
        }
        String str4 = str + " = ";
        if (this.cE != 0.0f) {
            str2 = str4 + this.cE;
            z = true;
        } else {
            str2 = str4;
            z = false;
        }
        int i = this.cF.ct;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable i3 = this.cF.i(i2);
            if (i3 != null) {
                float j = this.cF.j(i2);
                String solverVariable = i3.toString();
                if (!z) {
                    if (j < 0.0f) {
                        str2 = str2 + "- ";
                        j = -j;
                    }
                } else if (j > 0.0f) {
                    str2 = str2 + " + ";
                } else {
                    str2 = str2 + " - ";
                    j = -j;
                }
                if (j == 1.0f) {
                    str3 = str2 + solverVariable;
                } else {
                    str3 = str2 + j + " " + solverVariable;
                }
                str2 = str3;
                z = true;
            }
        }
        if (z) {
            return str2;
        }
        return str2 + "0.0";
    }
}
