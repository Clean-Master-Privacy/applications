package android.support.design.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public final class g implements TypeEvaluator<Matrix> {
    private final float[] eX = new float[9];
    private final float[] eY = new float[9];
    private final Matrix eZ = new Matrix();

    public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        ((Matrix) obj).getValues(this.eX);
        ((Matrix) obj2).getValues(this.eY);
        for (int i = 0; i < 9; i++) {
            this.eY[i] = this.eX[i] + ((this.eY[i] - this.eX[i]) * f);
        }
        this.eZ.setValues(this.eY);
        return this.eZ;
    }
}
