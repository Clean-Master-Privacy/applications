package a;

/* compiled from: AppLinks */
public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri a(android.content.Context r8, android.content.Intent r9) {
        /*
            r0 = 0
            java.lang.String r1 = "al_applink_data"
            android.os.Bundle r1 = r9.getBundleExtra(r1)
            if (r1 == 0) goto L_0x0087
            java.lang.String r2 = "target_url"
            java.lang.String r2 = r1.getString(r2)
            if (r2 == 0) goto L_0x0087
            java.lang.String r3 = "al_nav_in"
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            if (r9 == 0) goto L_0x00c6
            java.lang.String r0 = "al_applink_data"
            android.os.Bundle r0 = r9.getBundleExtra(r0)
            if (r0 == 0) goto L_0x0088
            android.os.Bundle r0 = a.b.a(r8, r3, r0, r9)
        L_0x0026:
            a.b r1 = new a.b
            r1.<init>(r8, r3, r0)
            java.lang.String r0 = r1.f20b
            if (r0 != 0) goto L_0x0036
            java.lang.Class r0 = r1.getClass()
            r0.getName()
        L_0x0036:
            java.lang.String r0 = "android.support.v4.content.f"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r3 = "getInstance"
            r4 = 1
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x00bd }
            r5 = 0
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r4[r5] = r6     // Catch:{ Exception -> 0x00bd }
            java.lang.reflect.Method r3 = r0.getMethod(r3, r4)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r4 = "sendBroadcast"
            r5 = 1
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00bd }
            r6 = 0
            java.lang.Class<android.content.Intent> r7 = android.content.Intent.class
            r5[r6] = r7     // Catch:{ Exception -> 0x00bd }
            java.lang.reflect.Method r0 = r0.getMethod(r4, r5)     // Catch:{ Exception -> 0x00bd }
            r4 = 0
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00bd }
            r6 = 0
            android.content.Context r7 = r1.f19a     // Catch:{ Exception -> 0x00bd }
            r5[r6] = r7     // Catch:{ Exception -> 0x00bd }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Exception -> 0x00bd }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x00bd }
            java.lang.String r5 = "com.parse.bolts.measurement_event"
            r4.<init>(r5)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r5 = "event_name"
            java.lang.String r6 = r1.f20b     // Catch:{ Exception -> 0x00bd }
            r4.putExtra(r5, r6)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r5 = "event_args"
            android.os.Bundle r6 = r1.f21c     // Catch:{ Exception -> 0x00bd }
            r4.putExtra(r5, r6)     // Catch:{ Exception -> 0x00bd }
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00bd }
            r6 = 0
            r5[r6] = r4     // Catch:{ Exception -> 0x00bd }
            r0.invoke(r3, r5)     // Catch:{ Exception -> 0x00bd }
        L_0x0083:
            android.net.Uri r0 = android.net.Uri.parse(r2)
        L_0x0087:
            return r0
        L_0x0088:
            android.net.Uri r0 = r9.getData()
            if (r0 == 0) goto L_0x0097
            java.lang.String r4 = "intentData"
            java.lang.String r0 = r0.toString()
            r1.putString(r4, r0)
        L_0x0097:
            android.os.Bundle r4 = r9.getExtras()
            if (r4 == 0) goto L_0x00c6
            java.util.Set r0 = r4.keySet()
            java.util.Iterator r5 = r0.iterator()
        L_0x00a5:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00c6
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r6 = r4.get(r0)
            java.lang.String r6 = a.b.a(r6)
            r1.putString(r0, r6)
            goto L_0x00a5
        L_0x00bd:
            r0 = move-exception
            java.lang.Class r0 = r1.getClass()
            r0.getName()
            goto L_0x0083
        L_0x00c6:
            r0 = r1
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a(android.content.Context, android.content.Intent):android.net.Uri");
    }
}
