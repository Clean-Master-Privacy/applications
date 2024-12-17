    package com.airbnb.lottie.d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.r;
import com.airbnb.lottie.b;
import java.io.Closeable;

public final class e {
    private static final PathMeasure nI = new PathMeasure();
    private static final Path nK = new Path();
    private static final float[] points = new float[4];
    private static final Path qY = new Path();
    private static final float qZ = ((float) Math.sqrt(2.0d));
    private static float rb = -1.0f;

    public static int b(float f2, float f3, float f4, float f5) {
        int i = f2 != 0.0f ? (int) (f2 * 527.0f) : 17;
        if (f3 != 0.0f) {
            i = (int) (((float) (i * 31)) * f3);
        }
        if (f4 != 0.0f) {
            i = (int) (((float) (i * 31)) * f4);
        }
        return f5 != 0.0f ? (int) (((float) (i * 31)) * f5) : i;
    }

    public static boolean b(int i, int i2, int i3) {
        if (i < 4) {
            return false;
        }
        if (i > 4) {
            return true;
        }
        if (i2 < 4) {
            return false;
        }
        return i2 > 4 || i3 >= 0;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            Path path2 = path;
            path2.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static float a(Matrix matrix) {
        points[0] = 0.0f;
        points[1] = 0.0f;
        points[2] = qZ;
        points[3] = qZ;
        matrix.mapPoints(points);
        return ((float) Math.hypot((double) (points[2] - points[0]), (double) (points[3] - points[1]))) / 2.0f;
    }

    public static void a(Path path, float f2, float f3, float f4) {
        b.cq();
        nI.setPath(path, false);
        float length = nI.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            b.cr();
        } else if (length < 1.0f || ((double) Math.abs((f3 - f2) - 1.0f)) < 0.01d) {
            b.cr();
        } else {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = (float) d.b(min, length);
                max = (float) d.b(max, length);
            }
            if (min < 0.0f) {
                min = (float) d.b(min, length);
            }
            if (max < 0.0f) {
                max = (float) d.b(max, length);
            }
            if (min == max) {
                path.reset();
                b.cr();
                return;
            }
            if (min >= max) {
                min -= length;
            }
            nK.reset();
            nI.getSegment(min, max, nK, true);
            if (max > length) {
                qY.reset();
                nI.getSegment(0.0f, max % length, qY, true);
                nK.addPath(qY);
            } else if (min < 0.0f) {
                qY.reset();
                nI.getSegment(min + length, length, qY, true);
                nK.addPath(qY);
            }
            path.set(nK);
            b.cr();
        }
    }

    public static float dd() {
        if (rb == -1.0f) {
            rb = Resources.getSystem().getDisplayMetrics().density;
        }
        return rb;
    }

    public static void a(Path path, @Nullable r rVar) {
        if (rVar != null) {
            a(path, rVar.nu.getValue().floatValue() / 100.0f, rVar.nv.getValue().floatValue() / 100.0f, rVar.nw.getValue().floatValue() / 360.0f);
        }
    }
}
    
