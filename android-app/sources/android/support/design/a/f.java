package android.support.design.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public final class f extends Property<ImageView, Matrix> {
    private final Matrix matrix = new Matrix();

    public final /* synthetic */ Object get(Object obj) {
        this.matrix.set(((ImageView) obj).getImageMatrix());
        return this.matrix;
    }

    public final /* synthetic */ void set(Object obj, Object obj2) {
        ((ImageView) obj).setImageMatrix((Matrix) obj2);
    }

    public f() {
        super(Matrix.class, "imageMatrixProperty");
    }
}
