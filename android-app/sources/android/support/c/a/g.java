package android.support.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.cleanmaster.news.bean.BaseResponse;
import org.xmlpull.v1.XmlPullParser;

public final class g implements Interpolator {
    private float[] tE;
    private float[] tF;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = android.support.v4.content.a.g.obtainAttributes(resources, theme, attributeSet, a.tt);
        if (android.support.v4.content.a.g.a(xmlPullParser, "pathData")) {
            String c2 = android.support.v4.content.a.g.c(obtainAttributes, xmlPullParser, "pathData", 4);
            Path createPathFromPathData = b.createPathFromPathData(c2);
            if (createPathFromPathData != null) {
                a(createPathFromPathData);
            } else {
                throw new InflateException("The path is null, which is created from " + c2);
            }
        } else if (!android.support.v4.content.a.g.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (android.support.v4.content.a.g.a(xmlPullParser, "controlY1")) {
            float a2 = android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "controlX1", 0, 0.0f);
            float a3 = android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "controlY1", 1, 0.0f);
            boolean a4 = android.support.v4.content.a.g.a(xmlPullParser, "controlX2");
            if (a4 != android.support.v4.content.a.g.a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!a4) {
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.quadTo(a2, a3, 1.0f, 1.0f);
                a(path);
            } else {
                float a5 = android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "controlX2", 2, 0.0f);
                float a6 = android.support.v4.content.a.g.a(obtainAttributes, xmlPullParser, "controlY2", 3, 0.0f);
                Path path2 = new Path();
                path2.moveTo(0.0f, 0.0f);
                path2.cubicTo(a2, a3, a5, a6, 1.0f, 1.0f);
                a(path2);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        obtainAttributes.recycle();
    }

    private void a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(BaseResponse.ResultCode.ERROR_SERVER, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.tE = new float[min];
            this.tF = new float[min];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, (float[]) null);
                this.tE[i2] = fArr[0];
                this.tF[i2] = fArr[1];
            }
            if (((double) Math.abs(this.tE[0])) <= 1.0E-5d && ((double) Math.abs(this.tF[0])) <= 1.0E-5d) {
                int i3 = min - 1;
                if (((double) Math.abs(this.tE[i3] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.tF[i3] - 1.0f)) <= 1.0E-5d) {
                    float f = 0.0f;
                    int i4 = 0;
                    while (i < min) {
                        int i5 = i4 + 1;
                        float f2 = this.tE[i4];
                        if (f2 >= f) {
                            this.tE[i] = f2;
                            i++;
                            f = f2;
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.tE[0]);
            sb.append(",");
            sb.append(this.tF[0]);
            sb.append(" end:");
            int i6 = min - 1;
            sb.append(this.tE[i6]);
            sb.append(",");
            sb.append(this.tF[i6]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.tE.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.tE[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.tE[length] - this.tE[i];
        if (f2 == 0.0f) {
            return this.tF[i];
        }
        float f3 = this.tF[i];
        return f3 + (((f - this.tE[i]) / f2) * (this.tF[length] - f3));
    }
}
