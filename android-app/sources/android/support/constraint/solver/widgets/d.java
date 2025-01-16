package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public final class d {
    ArrayList<a> eL = new ArrayList<>();
    int mHeight;
    int mWidth;
    int mX;
    int mY;

    static class a {
        ConstraintAnchor di;
        ConstraintAnchor eK;
        ConstraintAnchor.Strength eM;
        int eN;
        int mMargin;

        public a(ConstraintAnchor constraintAnchor) {
            this.eK = constraintAnchor;
            this.di = constraintAnchor.di;
            this.mMargin = constraintAnchor.ad();
            this.eM = constraintAnchor.dk;
            this.eN = constraintAnchor.dm;
        }
    }

    public d(ConstraintWidget constraintWidget) {
        this.mX = constraintWidget.getX();
        this.mY = constraintWidget.getY();
        this.mWidth = constraintWidget.getWidth();
        this.mHeight = constraintWidget.getHeight();
        ArrayList<ConstraintAnchor> an = constraintWidget.an();
        int size = an.size();
        for (int i = 0; i < size; i++) {
            this.eL.add(new a(an.get(i)));
        }
    }
}
