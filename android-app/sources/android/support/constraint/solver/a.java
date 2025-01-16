package android.support.constraint.solver;

import java.util.Arrays;

public final class a {
    int cA = -1;
    int cB = -1;
    boolean cC = false;
    int ct = 0;
    private final b cu;
    final c cv;
    private int cw = 8;
    int[] cx = new int[this.cw];
    int[] cy = new int[this.cw];
    float[] cz = new float[this.cw];

    a(b bVar, c cVar) {
        this.cu = bVar;
        this.cv = cVar;
    }

    public final void a(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            a(solverVariable);
        } else if (this.cA == -1) {
            this.cA = 0;
            this.cz[this.cA] = f;
            this.cx[this.cA] = solverVariable.id;
            this.cy[this.cA] = -1;
            this.ct++;
            if (!this.cC) {
                this.cB++;
            }
        } else {
            int i = this.cA;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.ct) {
                if (this.cx[i] == solverVariable.id) {
                    this.cz[i] = f;
                    return;
                }
                if (this.cx[i] < solverVariable.id) {
                    i3 = i;
                }
                i = this.cy[i];
                i2++;
            }
            int i4 = this.cB + 1;
            if (this.cC) {
                if (this.cx[this.cB] == -1) {
                    i4 = this.cB;
                } else {
                    i4 = this.cx.length;
                }
            }
            if (i4 >= this.cx.length && this.ct < this.cx.length) {
                int i5 = 0;
                while (true) {
                    if (i5 >= this.cx.length) {
                        break;
                    } else if (this.cx[i5] == -1) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            if (i4 >= this.cx.length) {
                i4 = this.cx.length;
                this.cw <<= 1;
                this.cC = false;
                this.cB = i4 - 1;
                this.cz = Arrays.copyOf(this.cz, this.cw);
                this.cx = Arrays.copyOf(this.cx, this.cw);
                this.cy = Arrays.copyOf(this.cy, this.cw);
            }
            this.cx[i4] = solverVariable.id;
            this.cz[i4] = f;
            if (i3 != -1) {
                this.cy[i4] = this.cy[i3];
                this.cy[i3] = i4;
            } else {
                this.cy[i4] = this.cA;
                this.cA = i4;
            }
            this.ct++;
            if (!this.cC) {
                this.cB++;
            }
            if (this.ct >= this.cx.length) {
                this.cC = true;
            }
        }
    }

    public final void b(SolverVariable solverVariable, float f) {
        if (f != 0.0f) {
            if (this.cA == -1) {
                this.cA = 0;
                this.cz[this.cA] = f;
                this.cx[this.cA] = solverVariable.id;
                this.cy[this.cA] = -1;
                this.ct++;
                if (!this.cC) {
                    this.cB++;
                    return;
                }
                return;
            }
            int i = this.cA;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.ct) {
                int i4 = this.cx[i];
                if (i4 == solverVariable.id) {
                    float[] fArr = this.cz;
                    fArr[i] = fArr[i] + f;
                    if (this.cz[i] == 0.0f) {
                        if (i == this.cA) {
                            this.cA = this.cy[i];
                        } else {
                            this.cy[i3] = this.cy[i];
                        }
                        this.cv.cJ[i4].c(this.cu);
                        if (this.cC) {
                            this.cB = i;
                        }
                        this.ct--;
                        return;
                    }
                    return;
                }
                if (this.cx[i] < solverVariable.id) {
                    i3 = i;
                }
                i = this.cy[i];
                i2++;
            }
            int i5 = this.cB + 1;
            if (this.cC) {
                if (this.cx[this.cB] == -1) {
                    i5 = this.cB;
                } else {
                    i5 = this.cx.length;
                }
            }
            if (i5 >= this.cx.length && this.ct < this.cx.length) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.cx.length) {
                        break;
                    } else if (this.cx[i6] == -1) {
                        i5 = i6;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            if (i5 >= this.cx.length) {
                i5 = this.cx.length;
                this.cw <<= 1;
                this.cC = false;
                this.cB = i5 - 1;
                this.cz = Arrays.copyOf(this.cz, this.cw);
                this.cx = Arrays.copyOf(this.cx, this.cw);
                this.cy = Arrays.copyOf(this.cy, this.cw);
            }
            this.cx[i5] = solverVariable.id;
            this.cz[i5] = f;
            if (i3 != -1) {
                this.cy[i5] = this.cy[i3];
                this.cy[i3] = i5;
            } else {
                this.cy[i5] = this.cA;
                this.cA = i5;
            }
            this.ct++;
            if (!this.cC) {
                this.cB++;
            }
            if (this.cB >= this.cx.length) {
                this.cC = true;
                this.cB = this.cx.length - 1;
            }
        }
    }

    public final float a(SolverVariable solverVariable) {
        if (this.cA == -1) {
            return 0.0f;
        }
        int i = this.cA;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.ct) {
            int i4 = this.cx[i];
            if (i4 == solverVariable.id) {
                if (i == this.cA) {
                    this.cA = this.cy[i];
                } else {
                    this.cy[i3] = this.cy[i];
                }
                this.cv.cJ[i4].c(this.cu);
                this.ct--;
                this.cx[i] = -1;
                if (this.cC) {
                    this.cB = i;
                }
                return this.cz[i];
            }
            i2++;
            i3 = i;
            i = this.cy[i];
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar, b bVar2) {
        int i = this.cA;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.ct) {
                if (this.cx[i] == bVar2.cD.id) {
                    float f = this.cz[i];
                    a(bVar2.cD);
                    a aVar = bVar2.cF;
                    int i3 = aVar.cA;
                    int i4 = 0;
                    while (i3 != -1 && i4 < aVar.ct) {
                        b(this.cv.cJ[aVar.cx[i3]], aVar.cz[i3] * f);
                        i3 = aVar.cy[i3];
                        i4++;
                    }
                    bVar.cE += bVar2.cE * f;
                    bVar2.cD.c(bVar);
                    i = this.cA;
                } else {
                    i = this.cy[i];
                    i2++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public final SolverVariable i(int i) {
        int i2 = this.cA;
        int i3 = 0;
        while (i2 != -1 && i3 < this.ct) {
            if (i3 == i) {
                return this.cv.cJ[this.cx[i2]];
            }
            i2 = this.cy[i2];
            i3++;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float j(int i) {
        int i2 = this.cA;
        int i3 = 0;
        while (i2 != -1 && i3 < this.ct) {
            if (i3 == i) {
                return this.cz[i2];
            }
            i2 = this.cy[i2];
            i3++;
        }
        return 0.0f;
    }

    public final float b(SolverVariable solverVariable) {
        int i = this.cA;
        int i2 = 0;
        while (i != -1 && i2 < this.ct) {
            if (this.cx[i] == solverVariable.id) {
                return this.cz[i];
            }
            i = this.cy[i];
            i2++;
        }
        return 0.0f;
    }

    public final String toString() {
        String str = "";
        int i = this.cA;
        int i2 = 0;
        while (i != -1 && i2 < this.ct) {
            str = ((str + " -> ") + this.cz[i] + " : ") + this.cv.cJ[this.cx[i]];
            i = this.cy[i];
            i2++;
        }
        return str;
    }
}
