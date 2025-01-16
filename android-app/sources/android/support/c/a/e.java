package android.support.c.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.a.g;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.cleanmaster.activitymanagerhelper.RunningAppProcessInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class e {
    private static boolean N(int i) {
        return i >= 28 && i <= 31;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.Animator a(android.content.Context r10, android.content.res.Resources r11, android.content.res.Resources.Theme r12, int r13) throws android.content.res.Resources.NotFoundException {
        /*
            r0 = 0
            android.content.res.XmlResourceParser r9 = r11.getAnimation(r13)     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0026 }
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r9)     // Catch:{ XmlPullParserException -> 0x0021, IOException -> 0x001e, all -> 0x001b }
            r6 = 0
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r9
            android.animation.Animator r10 = a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ XmlPullParserException -> 0x0021, IOException -> 0x001e, all -> 0x001b }
            if (r9 == 0) goto L_0x001a
            r9.close()
        L_0x001a:
            return r10
        L_0x001b:
            r10 = move-exception
            r0 = r9
            goto L_0x005e
        L_0x001e:
            r10 = move-exception
            r0 = r9
            goto L_0x0027
        L_0x0021:
            r10 = move-exception
            r0 = r9
            goto L_0x0043
        L_0x0024:
            r10 = move-exception
            goto L_0x005e
        L_0x0026:
            r10 = move-exception
        L_0x0027:
            android.content.res.Resources$NotFoundException r11 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x0024 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "Can't load animation resource ID #0x"
            r12.<init>(r1)     // Catch:{ all -> 0x0024 }
            java.lang.String r13 = java.lang.Integer.toHexString(r13)     // Catch:{ all -> 0x0024 }
            r12.append(r13)     // Catch:{ all -> 0x0024 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0024 }
            r11.<init>(r12)     // Catch:{ all -> 0x0024 }
            r11.initCause(r10)     // Catch:{ all -> 0x0024 }
            throw r11     // Catch:{ all -> 0x0024 }
        L_0x0042:
            r10 = move-exception
        L_0x0043:
            android.content.res.Resources$NotFoundException r11 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x0024 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "Can't load animation resource ID #0x"
            r12.<init>(r1)     // Catch:{ all -> 0x0024 }
            java.lang.String r13 = java.lang.Integer.toHexString(r13)     // Catch:{ all -> 0x0024 }
            r12.append(r13)     // Catch:{ all -> 0x0024 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0024 }
            r11.<init>(r12)     // Catch:{ all -> 0x0024 }
            r11.initCause(r10)     // Catch:{ all -> 0x0024 }
            throw r11     // Catch:{ all -> 0x0024 }
        L_0x005e:
            if (r0 == 0) goto L_0x0063
            r0.close()
        L_0x0063:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.e.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, int):android.animation.Animator");
    }

    private static class a implements TypeEvaluator<b.C0020b[]> {
        private b.C0020b[] tC;

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            b.C0020b[] bVarArr = (b.C0020b[]) obj;
            b.C0020b[] bVarArr2 = (b.C0020b[]) obj2;
            if (b.a(bVarArr, bVarArr2)) {
                if (this.tC == null || !b.a(this.tC, bVarArr)) {
                    this.tC = b.a(bVarArr);
                }
                for (int i = 0; i < bVarArr.length; i++) {
                    this.tC[i].a(bVarArr[i], bVarArr2[i], f);
                }
                return this.tC;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        a() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.PropertyValuesHolder a(android.content.res.TypedArray r11, int r12, int r13, int r14, java.lang.String r15) {
        /*
            android.util.TypedValue r0 = r11.peekValue(r13)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000a
            r3 = r1
            goto L_0x000b
        L_0x000a:
            r3 = r2
        L_0x000b:
            if (r3 == 0) goto L_0x0010
            int r0 = r0.type
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            android.util.TypedValue r4 = r11.peekValue(r14)
            if (r4 == 0) goto L_0x0019
            r5 = r1
            goto L_0x001a
        L_0x0019:
            r5 = r2
        L_0x001a:
            if (r5 == 0) goto L_0x001f
            int r4 = r4.type
            goto L_0x0020
        L_0x001f:
            r4 = r2
        L_0x0020:
            r6 = 4
            r7 = 3
            if (r12 != r6) goto L_0x0037
            if (r3 == 0) goto L_0x002c
            boolean r12 = N(r0)
            if (r12 != 0) goto L_0x0034
        L_0x002c:
            if (r5 == 0) goto L_0x0036
            boolean r12 = N(r4)
            if (r12 == 0) goto L_0x0036
        L_0x0034:
            r12 = r7
            goto L_0x0037
        L_0x0036:
            r12 = r2
        L_0x0037:
            if (r12 != 0) goto L_0x003b
            r6 = r1
            goto L_0x003c
        L_0x003b:
            r6 = r2
        L_0x003c:
            r8 = 0
            r9 = 2
            if (r12 != r9) goto L_0x00a7
            java.lang.String r12 = r11.getString(r13)
            java.lang.String r11 = r11.getString(r14)
            android.support.v4.graphics.b$b[] r13 = android.support.v4.graphics.b.s(r12)
            android.support.v4.graphics.b$b[] r14 = android.support.v4.graphics.b.s(r11)
            if (r13 != 0) goto L_0x0054
            if (r14 == 0) goto L_0x00a4
        L_0x0054:
            if (r13 == 0) goto L_0x0095
            android.support.c.a.e$a r0 = new android.support.c.a.e$a
            r0.<init>()
            if (r14 == 0) goto L_0x008b
            boolean r3 = android.support.v4.graphics.b.a((android.support.v4.graphics.b.C0020b[]) r13, (android.support.v4.graphics.b.C0020b[]) r14)
            if (r3 == 0) goto L_0x006f
            java.lang.Object[] r11 = new java.lang.Object[r9]
            r11[r2] = r13
            r11[r1] = r14
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r0, r11)
            goto L_0x0167
        L_0x006f:
            android.view.InflateException r13 = new android.view.InflateException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = " Can't morph from "
            r14.<init>(r15)
            r14.append(r12)
            java.lang.String r12 = " to "
            r14.append(r12)
            r14.append(r11)
            java.lang.String r11 = r14.toString()
            r13.<init>(r11)
            throw r13
        L_0x008b:
            java.lang.Object[] r11 = new java.lang.Object[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r0, r11)
            goto L_0x0167
        L_0x0095:
            if (r14 == 0) goto L_0x00a4
            android.support.c.a.e$a r11 = new android.support.c.a.e$a
            r11.<init>()
            java.lang.Object[] r12 = new java.lang.Object[r1]
            r12[r2] = r14
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofObject(r15, r11, r12)
        L_0x00a4:
            r11 = r8
            goto L_0x0167
        L_0x00a7:
            if (r12 != r7) goto L_0x00ae
            android.support.c.a.f r12 = android.support.c.a.f.cR()
            goto L_0x00af
        L_0x00ae:
            r12 = r8
        L_0x00af:
            r7 = 5
            r10 = 0
            if (r6 == 0) goto L_0x00f8
            if (r3 == 0) goto L_0x00e3
            if (r0 != r7) goto L_0x00bc
            float r13 = r11.getDimension(r13, r10)
            goto L_0x00c0
        L_0x00bc:
            float r13 = r11.getFloat(r13, r10)
        L_0x00c0:
            if (r5 == 0) goto L_0x00d9
            if (r4 != r7) goto L_0x00c9
            float r11 = r11.getDimension(r14, r10)
            goto L_0x00cd
        L_0x00c9:
            float r11 = r11.getFloat(r14, r10)
        L_0x00cd:
            float[] r14 = new float[r9]
            r14[r2] = r13
            r14[r1] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofFloat(r15, r14)
            goto L_0x015f
        L_0x00d9:
            float[] r11 = new float[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofFloat(r15, r11)
            goto L_0x015f
        L_0x00e3:
            if (r4 != r7) goto L_0x00ea
            float r11 = r11.getDimension(r14, r10)
            goto L_0x00ee
        L_0x00ea:
            float r11 = r11.getFloat(r14, r10)
        L_0x00ee:
            float[] r13 = new float[r1]
            r13[r2] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofFloat(r15, r13)
            goto L_0x015f
        L_0x00f8:
            if (r3 == 0) goto L_0x013e
            if (r0 != r7) goto L_0x0102
            float r13 = r11.getDimension(r13, r10)
            int r13 = (int) r13
            goto L_0x0111
        L_0x0102:
            boolean r0 = N(r0)
            if (r0 == 0) goto L_0x010d
            int r13 = r11.getColor(r13, r2)
            goto L_0x0111
        L_0x010d:
            int r13 = r11.getInt(r13, r2)
        L_0x0111:
            if (r5 == 0) goto L_0x0135
            if (r4 != r7) goto L_0x011b
            float r11 = r11.getDimension(r14, r10)
            int r11 = (int) r11
            goto L_0x012a
        L_0x011b:
            boolean r0 = N(r4)
            if (r0 == 0) goto L_0x0126
            int r11 = r11.getColor(r14, r2)
            goto L_0x012a
        L_0x0126:
            int r11 = r11.getInt(r14, r2)
        L_0x012a:
            int[] r14 = new int[r9]
            r14[r2] = r13
            r14[r1] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r14)
            goto L_0x015f
        L_0x0135:
            int[] r11 = new int[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r11)
            goto L_0x015f
        L_0x013e:
            if (r5 == 0) goto L_0x015f
            if (r4 != r7) goto L_0x0148
            float r11 = r11.getDimension(r14, r10)
            int r11 = (int) r11
            goto L_0x0157
        L_0x0148:
            boolean r13 = N(r4)
            if (r13 == 0) goto L_0x0153
            int r11 = r11.getColor(r14, r2)
            goto L_0x0157
        L_0x0153:
            int r11 = r11.getInt(r14, r2)
        L_0x0157:
            int[] r13 = new int[r1]
            r13[r2] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r13)
        L_0x015f:
            r11 = r8
            if (r11 == 0) goto L_0x0167
            if (r12 == 0) goto L_0x0167
            r11.setEvaluator(r12)
        L_0x0167:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.e.a(android.content.res.TypedArray, int, int, int, java.lang.String):android.animation.PropertyValuesHolder");
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        ValueAnimator valueAnimator2 = valueAnimator;
        TypedArray typedArray3 = typedArray;
        TypedArray typedArray4 = typedArray2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long a2 = (long) g.a(typedArray3, xmlPullParser2, "duration", 1, (int) RunningAppProcessInfo.IMPORTANCE_SERVICE);
        long a3 = (long) g.a(typedArray3, xmlPullParser2, "startOffset", 2, 0);
        int a4 = g.a(typedArray3, xmlPullParser2, "valueType", 7, 4);
        if (g.a(xmlPullParser2, "valueFrom") && g.a(xmlPullParser2, "valueTo")) {
            if (a4 == 4) {
                TypedValue peekValue = typedArray3.peekValue(5);
                boolean z = peekValue != null;
                int i = z ? peekValue.type : 0;
                TypedValue peekValue2 = typedArray3.peekValue(6);
                boolean z2 = peekValue2 != null;
                a4 = ((!z || !N(i)) && (!z2 || !N(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder a5 = a(typedArray3, a4, 5, 6, "");
            if (a5 != null) {
                valueAnimator2.setValues(new PropertyValuesHolder[]{a5});
            }
        }
        valueAnimator2.setDuration(a2);
        valueAnimator2.setStartDelay(a3);
        valueAnimator2.setRepeatCount(g.a(typedArray3, xmlPullParser2, "repeatCount", 3, 0));
        valueAnimator2.setRepeatMode(g.a(typedArray3, xmlPullParser2, "repeatMode", 4, 1));
        if (typedArray4 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator2;
            String c2 = g.c(typedArray4, xmlPullParser2, "pathData", 1);
            if (c2 != null) {
                String c3 = g.c(typedArray4, xmlPullParser2, "propertyXName", 2);
                String c4 = g.c(typedArray4, xmlPullParser2, "propertyYName", 3);
                if (c3 == null && c4 == null) {
                    throw new InflateException(typedArray2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                a(b.createPathFromPathData(c2), objectAnimator, 0.5f * f, c3, c4);
                return;
            }
            objectAnimator.setPropertyName(g.c(typedArray4, xmlPullParser2, "propertyName", 0));
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f3 = f2 / ((float) (min - 1));
        int i = 0;
        float f4 = 0.0f;
        int i2 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i2 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f4 - ((Float) arrayList.get(i)).floatValue(), fArr3, (float[]) null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f4 += f3;
            int i3 = i + 1;
            if (i3 < arrayList.size() && f4 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i = i3;
            }
            i2++;
        }
        PropertyValuesHolder ofFloat = str3 != null ? PropertyValuesHolder.ofFloat(str3, fArr) : null;
        if (str4 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (ofFloat == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
        } else if (propertyValuesHolder == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat});
        } else {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, propertyValuesHolder});
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) throws XmlPullParserException, IOException {
        int i2;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AnimatorSet animatorSet2 = animatorSet;
        int depth = xmlPullParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        ObjectAnimator objectAnimator = new ObjectAnimator();
                        a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
                        Context context2 = context;
                        valueAnimator = objectAnimator;
                    } else if (name.equals("animator")) {
                        valueAnimator = a(context, resources, theme, attributeSet, (ValueAnimator) null, f, xmlPullParser);
                        Context context3 = context;
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet3 = new AnimatorSet();
                        TypedArray obtainAttributes = g.obtainAttributes(resources2, theme2, attributeSet, a.tn);
                        a(context, resources, theme, xmlPullParser, attributeSet, animatorSet3, g.a(obtainAttributes, xmlPullParser2, "ordering", 0, 0), f);
                        obtainAttributes.recycle();
                        Context context4 = context;
                        valueAnimator = animatorSet3;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] a2 = a(context, resources2, theme2, xmlPullParser2, Xml.asAttributeSet(xmlPullParser));
                        if (!(a2 == null || valueAnimator == null || !(valueAnimator instanceof ValueAnimator))) {
                            valueAnimator.setValues(a2);
                        }
                        i2 = 1;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet2 != null && i2 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAnimator);
                    }
                } else {
                    Context context5 = context;
                }
            }
        }
        if (!(animatorSet2 == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet2.playTogether(animatorArr);
            } else {
                animatorSet2.playSequentially(animatorArr);
            }
        }
        return valueAnimator;
    }

    private static PropertyValuesHolder[] a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        PropertyValuesHolder propertyValuesHolder;
        int size;
        Keyframe keyframe;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 3) {
                int i = 1;
                if (eventType != 1) {
                    if (eventType != 2) {
                        xmlPullParser.next();
                    } else {
                        if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                            TypedArray obtainAttributes = g.obtainAttributes(resources2, theme2, attributeSet, a.tp);
                            String c2 = g.c(obtainAttributes, xmlPullParser2, "propertyName", 3);
                            int i2 = 4;
                            int a2 = g.a(obtainAttributes, xmlPullParser2, "valueType", 2, 4);
                            int i3 = a2;
                            ArrayList arrayList2 = null;
                            while (true) {
                                int next = xmlPullParser.next();
                                if (next == 3 || next == i) {
                                    Context context2 = context;
                                } else {
                                    if (xmlPullParser.getName().equals("keyframe")) {
                                        if (i3 == i2) {
                                            TypedArray obtainAttributes2 = g.obtainAttributes(resources2, theme2, Xml.asAttributeSet(xmlPullParser), a.tq);
                                            TypedValue a3 = g.a(obtainAttributes2, xmlPullParser2, "value");
                                            i3 = (!(a3 != null) || !N(a3.type)) ? 0 : 3;
                                            obtainAttributes2.recycle();
                                        }
                                        TypedArray obtainAttributes3 = g.obtainAttributes(resources2, theme2, Xml.asAttributeSet(xmlPullParser), a.tq);
                                        float a4 = g.a(obtainAttributes3, xmlPullParser2, "fraction", 3, -1.0f);
                                        TypedValue a5 = g.a(obtainAttributes3, xmlPullParser2, "value");
                                        boolean z = a5 != null;
                                        int i4 = i3 == i2 ? (!z || !N(a5.type)) ? 0 : 3 : i3;
                                        if (z) {
                                            if (i4 != 3) {
                                                switch (i4) {
                                                    case 0:
                                                        keyframe = Keyframe.ofFloat(a4, g.a(obtainAttributes3, xmlPullParser2, "value", 0, 0.0f));
                                                        break;
                                                    case 1:
                                                        break;
                                                    default:
                                                        keyframe = null;
                                                        break;
                                                }
                                            }
                                            keyframe = Keyframe.ofInt(a4, g.a(obtainAttributes3, xmlPullParser2, "value", 0, 0));
                                        } else if (i4 == 0) {
                                            keyframe = Keyframe.ofFloat(a4);
                                        } else {
                                            keyframe = Keyframe.ofInt(a4);
                                        }
                                        int b2 = g.b(obtainAttributes3, xmlPullParser2, "interpolator", 1);
                                        if (b2 > 0) {
                                            keyframe.setInterpolator(d.loadInterpolator(context, b2));
                                        } else {
                                            Context context3 = context;
                                        }
                                        obtainAttributes3.recycle();
                                        if (keyframe != null) {
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(keyframe);
                                        }
                                        xmlPullParser.next();
                                    } else {
                                        Context context4 = context;
                                    }
                                    i = 1;
                                    i2 = 4;
                                }
                            }
                            Context context22 = context;
                            if (arrayList2 == null || (size = arrayList2.size()) <= 0) {
                                propertyValuesHolder = null;
                            } else {
                                Keyframe keyframe2 = (Keyframe) arrayList2.get(0);
                                Keyframe keyframe3 = (Keyframe) arrayList2.get(size - 1);
                                float fraction = keyframe3.getFraction();
                                if (fraction < 1.0f) {
                                    if (fraction < 0.0f) {
                                        keyframe3.setFraction(1.0f);
                                    } else {
                                        arrayList2.add(arrayList2.size(), a(keyframe3, 1.0f));
                                        size++;
                                    }
                                }
                                float fraction2 = keyframe2.getFraction();
                                if (fraction2 != 0.0f) {
                                    if (fraction2 < 0.0f) {
                                        keyframe2.setFraction(0.0f);
                                    } else {
                                        arrayList2.add(0, a(keyframe2, 0.0f));
                                        size++;
                                    }
                                }
                                Keyframe[] keyframeArr = new Keyframe[size];
                                arrayList2.toArray(keyframeArr);
                                for (int i5 = 0; i5 < size; i5++) {
                                    Keyframe keyframe4 = keyframeArr[i5];
                                    if (keyframe4.getFraction() < 0.0f) {
                                        if (i5 == 0) {
                                            keyframe4.setFraction(0.0f);
                                        } else {
                                            int i6 = size - 1;
                                            if (i5 == i6) {
                                                keyframe4.setFraction(1.0f);
                                            } else {
                                                int i7 = i5 + 1;
                                                int i8 = i5;
                                                while (true) {
                                                    if (i7 < i6) {
                                                        if (keyframeArr[i7].getFraction() < 0.0f) {
                                                            i8 = i7;
                                                            i7++;
                                                        }
                                                    }
                                                }
                                                a(keyframeArr, keyframeArr[i8 + 1].getFraction() - keyframeArr[i5 - 1].getFraction(), i5, i8);
                                            }
                                        }
                                    }
                                }
                                propertyValuesHolder = PropertyValuesHolder.ofKeyframe(c2, keyframeArr);
                                if (i3 == 3) {
                                    propertyValuesHolder.setEvaluator(f.cR());
                                }
                            }
                            if (propertyValuesHolder == null) {
                                propertyValuesHolder = a(obtainAttributes, a2, 0, 1, c2);
                            }
                            if (propertyValuesHolder != null) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(propertyValuesHolder);
                            }
                            obtainAttributes.recycle();
                        } else {
                            Context context5 = context;
                            AttributeSet attributeSet2 = attributeSet;
                        }
                        xmlPullParser.next();
                    }
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        int size2 = arrayList.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size2];
        for (int i9 = 0; i9 < size2; i9++) {
            propertyValuesHolderArr[i9] = (PropertyValuesHolder) arrayList.get(i9);
        }
        return propertyValuesHolderArr;
    }

    private static Keyframe a(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    private static void a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((float) ((i2 - i) + 2));
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray obtainAttributes = g.obtainAttributes(resources, theme, attributeSet, a.tm);
        TypedArray obtainAttributes2 = g.obtainAttributes(resources, theme, attributeSet, a.tr);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, obtainAttributes, obtainAttributes2, f, xmlPullParser);
        int b2 = g.b(obtainAttributes, xmlPullParser, "interpolator", 0);
        if (b2 > 0) {
            valueAnimator.setInterpolator(d.loadInterpolator(context, b2));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }
}
