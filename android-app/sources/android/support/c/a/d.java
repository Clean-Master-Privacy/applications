package android.support.c.a;

public final class d {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.content.res.XmlResourceParser} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.content.res.XmlResourceParser} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.content.res.XmlResourceParser} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: android.view.animation.Interpolator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.content.res.XmlResourceParser} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.animation.Interpolator loadInterpolator(android.content.Context r5, int r6) throws android.content.res.Resources.NotFoundException {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x000b
            android.view.animation.Interpolator r5 = android.view.animation.AnimationUtils.loadInterpolator(r5, r6)
            return r5
        L_0x000b:
            r0 = 17563663(0x10c000f, float:2.571398E-38)
            r1 = 0
            if (r6 != r0) goto L_0x0021
            android.support.v4.view.b.a r5 = new android.support.v4.view.b.a     // Catch:{ XmlPullParserException -> 0x001e, IOException -> 0x001b }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x001e, IOException -> 0x001b }
            return r5
        L_0x0017:
            r5 = move-exception
            r0 = r1
            goto L_0x014e
        L_0x001b:
            r5 = move-exception
            goto L_0x0118
        L_0x001e:
            r5 = move-exception
            goto L_0x0133
        L_0x0021:
            r0 = 17563661(0x10c000d, float:2.5713975E-38)
            if (r6 != r0) goto L_0x002c
            android.support.v4.view.b.b r5 = new android.support.v4.view.b.b     // Catch:{ XmlPullParserException -> 0x001e, IOException -> 0x001b }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x001e, IOException -> 0x001b }
            return r5
        L_0x002c:
            r0 = 17563662(0x10c000e, float:2.5713978E-38)
            if (r6 != r0) goto L_0x0037
            android.support.v4.view.b.c r5 = new android.support.v4.view.b.c     // Catch:{ XmlPullParserException -> 0x001e, IOException -> 0x001b }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x001e, IOException -> 0x001b }
            return r5
        L_0x0037:
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ XmlPullParserException -> 0x001e, IOException -> 0x001b }
            android.content.res.XmlResourceParser r0 = r0.getAnimation(r6)     // Catch:{ XmlPullParserException -> 0x001e, IOException -> 0x001b }
            r5.getResources()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r5.getTheme()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            int r2 = r0.getDepth()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
        L_0x0049:
            int r3 = r0.next()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r4 = 3
            if (r3 != r4) goto L_0x0056
            int r4 = r0.getDepth()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 <= r2) goto L_0x010a
        L_0x0056:
            r4 = 1
            if (r3 == r4) goto L_0x010a
            r4 = 2
            if (r3 != r4) goto L_0x0049
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r0)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            java.lang.String r3 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            java.lang.String r4 = "linearInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x0072
            android.view.animation.LinearInterpolator r1 = new android.view.animation.LinearInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x0049
        L_0x0072:
            java.lang.String r4 = "accelerateInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x0081
            android.view.animation.AccelerateInterpolator r3 = new android.view.animation.AccelerateInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r3.<init>(r5, r1)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
        L_0x007f:
            r1 = r3
            goto L_0x0049
        L_0x0081:
            java.lang.String r4 = "decelerateInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x008f
            android.view.animation.DecelerateInterpolator r3 = new android.view.animation.DecelerateInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r3.<init>(r5, r1)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x007f
        L_0x008f:
            java.lang.String r4 = "accelerateDecelerateInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x009d
            android.view.animation.AccelerateDecelerateInterpolator r1 = new android.view.animation.AccelerateDecelerateInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x0049
        L_0x009d:
            java.lang.String r4 = "cycleInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x00ab
            android.view.animation.CycleInterpolator r3 = new android.view.animation.CycleInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r3.<init>(r5, r1)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x007f
        L_0x00ab:
            java.lang.String r4 = "anticipateInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x00b9
            android.view.animation.AnticipateInterpolator r3 = new android.view.animation.AnticipateInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r3.<init>(r5, r1)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x007f
        L_0x00b9:
            java.lang.String r4 = "overshootInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x00c7
            android.view.animation.OvershootInterpolator r3 = new android.view.animation.OvershootInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r3.<init>(r5, r1)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x007f
        L_0x00c7:
            java.lang.String r4 = "anticipateOvershootInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x00d5
            android.view.animation.AnticipateOvershootInterpolator r3 = new android.view.animation.AnticipateOvershootInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r3.<init>(r5, r1)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x007f
        L_0x00d5:
            java.lang.String r4 = "bounceInterpolator"
            boolean r4 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x00e4
            android.view.animation.BounceInterpolator r1 = new android.view.animation.BounceInterpolator     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x0049
        L_0x00e4:
            java.lang.String r4 = "pathInterpolator"
            boolean r3 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            if (r3 == 0) goto L_0x00f2
            android.support.c.a.g r3 = new android.support.c.a.g     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r3.<init>(r5, r1, r0)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            goto L_0x007f
        L_0x00f2:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = "Unknown interpolator name: "
            r1.<init>(r2)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r1.append(r2)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            java.lang.String r1 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            r5.<init>(r1)     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
            throw r5     // Catch:{ XmlPullParserException -> 0x0115, IOException -> 0x0112, all -> 0x0110 }
        L_0x010a:
            if (r0 == 0) goto L_0x010f
            r0.close()
        L_0x010f:
            return r1
        L_0x0110:
            r5 = move-exception
            goto L_0x014e
        L_0x0112:
            r5 = move-exception
            r1 = r0
            goto L_0x0118
        L_0x0115:
            r5 = move-exception
            r1 = r0
            goto L_0x0133
        L_0x0118:
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x0017 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = "Can't load animation resource ID #0x"
            r2.<init>(r3)     // Catch:{ all -> 0x0017 }
            java.lang.String r6 = java.lang.Integer.toHexString(r6)     // Catch:{ all -> 0x0017 }
            r2.append(r6)     // Catch:{ all -> 0x0017 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0017 }
            r0.<init>(r6)     // Catch:{ all -> 0x0017 }
            r0.initCause(r5)     // Catch:{ all -> 0x0017 }
            throw r0     // Catch:{ all -> 0x0017 }
        L_0x0133:
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x0017 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = "Can't load animation resource ID #0x"
            r2.<init>(r3)     // Catch:{ all -> 0x0017 }
            java.lang.String r6 = java.lang.Integer.toHexString(r6)     // Catch:{ all -> 0x0017 }
            r2.append(r6)     // Catch:{ all -> 0x0017 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0017 }
            r0.<init>(r6)     // Catch:{ all -> 0x0017 }
            r0.initCause(r5)     // Catch:{ all -> 0x0017 }
            throw r0     // Catch:{ all -> 0x0017 }
        L_0x014e:
            if (r0 == 0) goto L_0x0153
            r0.close()
        L_0x0153:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.d.loadInterpolator(android.content.Context, int):android.view.animation.Interpolator");
    }
}
