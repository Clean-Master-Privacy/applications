package android.support.constraint.solver.widgets;

import android.support.constraint.solver.c;
import java.util.ArrayList;

public class e extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> mChildren = new ArrayList<>();

    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public final void a(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.dK != null) {
            ((e) constraintWidget.dK).b(constraintWidget);
        }
        constraintWidget.dK = this;
    }

    public final void b(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.dK = null;
    }

    public final void d(int i, int i2) {
        super.d(i, i2);
        int size = this.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mChildren.get(i3).d(ak(), al());
        }
    }

    public final void ao() {
        super.ao();
        if (this.mChildren != null) {
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                constraintWidget.d(ah(), ai());
                if (!(constraintWidget instanceof a)) {
                    constraintWidget.ao();
                }
            }
        }
    }

    public void ar() {
        ao();
        if (this.mChildren != null) {
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof e) {
                    ((e) constraintWidget).ar();
                }
            }
        }
    }

    public final void a(c cVar) {
        super.a(cVar);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).a(cVar);
        }
    }

    public final void av() {
        this.mChildren.clear();
    }
}
