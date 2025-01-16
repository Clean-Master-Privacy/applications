package android.support.constraint.solver.widgets;

import android.support.constraint.solver.e;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public final class b extends ConstraintWidget {
    public float eH = -1.0f;
    public int eI = -1;
    public int eJ = -1;
    private ConstraintAnchor eK = this.dC;
    int mOrientation = 0;

    public b() {
        new c();
        this.dJ.clear();
        this.dJ.add(this.eK);
    }

    public final void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            this.dJ.clear();
            if (this.mOrientation == 1) {
                this.eK = this.dB;
            } else {
                this.eK = this.dC;
            }
            this.dJ.add(this.eK);
        }
    }

    public final int getOrientation() {
        return this.mOrientation;
    }

    public final ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
            case RIGHT:
                if (this.mOrientation == 1) {
                    return this.eK;
                }
                return null;
            case TOP:
            case BOTTOM:
                if (this.mOrientation == 0) {
                    return this.eK;
                }
                return null;
            default:
                return null;
        }
    }

    public final ArrayList<ConstraintAnchor> an() {
        return this.dJ;
    }

    public final float as() {
        return this.eH;
    }

    public final int at() {
        return this.eI;
    }

    public final int au() {
        return this.eJ;
    }

    public final void b(e eVar) {
        a aVar = (a) this.dK;
        if (aVar != null) {
            ConstraintAnchor a2 = aVar.a(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor a3 = aVar.a(ConstraintAnchor.Type.RIGHT);
            if (this.mOrientation == 0) {
                a2 = aVar.a(ConstraintAnchor.Type.TOP);
                a3 = aVar.a(ConstraintAnchor.Type.BOTTOM);
            }
            if (this.eI != -1) {
                eVar.b(e.a(eVar, eVar.f(this.eK), eVar.f(a2), this.eI, false));
            } else if (this.eJ != -1) {
                eVar.b(e.a(eVar, eVar.f(this.eK), eVar.f(a3), -this.eJ, false));
            } else if (this.eH != -1.0f) {
                eVar.b(e.a(eVar, eVar.f(this.eK), eVar.f(a2), eVar.f(a3), this.eH));
            }
        }
    }

    public final void aq() {
        if (this.dK != null) {
            int g = e.g(this.eK);
            if (this.mOrientation == 1) {
                setX(g);
                setY(0);
                setHeight(this.dK.getHeight());
                setWidth(0);
                return;
            }
            setX(0);
            setY(g);
            setWidth(this.dK.getWidth());
            setHeight(0);
        }
    }
}
