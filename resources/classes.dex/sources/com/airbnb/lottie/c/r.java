    package com.airbnb.lottie.c;

import android.support.v4.util.LongSparseArray;
import android.util.JsonReader;
import com.airbnb.lottie.b;
import com.airbnb.lottie.c;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.Layer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class r {
    public static void a(JsonReader jsonReader, c cVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer l = q.l(jsonReader, cVar);
            if (l.qf == Layer.LayerType.Image) {
                i++;
            }
            list.add(l);
            longSparseArray.put(l.qe, l);
            if (i > 4) {
                b.bt("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    public static void a(JsonReader jsonReader, c cVar, Map<String, List<Layer>> map, Map<String, f> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != -1109732030) {
                    if (hashCode != 104) {
                        if (hashCode != 112) {
                            if (hashCode != 117) {
                                if (hashCode != 119) {
                                    if (hashCode == 3355 && nextName.equals("id")) {
                                        c2 = 0;
                                    }
                                } else if (nextName.equals("w")) {
                                    c2 = 2;
                                }
                            } else if (nextName.equals("u")) {
                                c2 = 5;
                            }
                        } else if (nextName.equals("p")) {
                            c2 = 4;
                        }
                    } else if (nextName.equals("h")) {
                        c2 = 3;
                    }
                } else if (nextName.equals("layers")) {
                    c2 = 1;
                }
                switch (c2) {
                    case 0:
                        str2 = jsonReader.nextString();
                        break;
                    case 1:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Layer l = q.l(jsonReader, cVar);
                            longSparseArray.put(l.qe, l);
                            arrayList.add(l);
                        }
                        jsonReader.endArray();
                        break;
                    case 2:
                        jsonReader.nextInt();
                        break;
                    case 3:
                        jsonReader.nextInt();
                        break;
                    case 4:
                        str = jsonReader.nextString();
                        break;
                    case 5:
                        jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (str != null) {
                f fVar = new f(str2, str);
                map2.put(fVar.id, fVar);
            } else {
                map.put(str2, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.util.JsonReader r8, java.util.Map<java.lang.String, com.airbnb.lottie.model.c> r9) throws java.io.IOException {
        /*
            r8.beginObject()
        L_0x0003:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00b2
            java.lang.String r0 = r8.nextName()
            int r1 = r0.hashCode()
            r2 = 3322014(0x32b09e, float:4.655133E-39)
            r3 = 0
            r4 = -1
            if (r1 == r2) goto L_0x0019
            goto L_0x0023
        L_0x0019:
            java.lang.String r1 = "list"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0023
            r0 = 0
            goto L_0x0024
        L_0x0023:
            r0 = -1
        L_0x0024:
            if (r0 == 0) goto L_0x002a
            r8.skipValue()
            goto L_0x0003
        L_0x002a:
            r8.beginArray()
        L_0x002d:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00ad
            r8.beginObject()
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0039:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L_0x009f
            java.lang.String r5 = r8.nextName()
            int r6 = r5.hashCode()
            r7 = -1866931350(0xffffffff90b8e36a, float:-7.292559E-29)
            if (r6 == r7) goto L_0x007a
            r7 = -1408684838(0xffffffffac092cda, float:-1.9493769E-12)
            if (r6 == r7) goto L_0x0070
            r7 = -1294566165(0xffffffffb2d67ceb, float:-2.4969685E-8)
            if (r6 == r7) goto L_0x0066
            r7 = 96619537(0x5c24c11, float:1.8271615E-35)
            if (r6 == r7) goto L_0x005c
            goto L_0x0084
        L_0x005c:
            java.lang.String r6 = "fName"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0084
            r5 = 1
            goto L_0x0085
        L_0x0066:
            java.lang.String r6 = "fStyle"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0084
            r5 = 2
            goto L_0x0085
        L_0x0070:
            java.lang.String r6 = "ascent"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0084
            r5 = 3
            goto L_0x0085
        L_0x007a:
            java.lang.String r6 = "fFamily"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0084
            r5 = 0
            goto L_0x0085
        L_0x0084:
            r5 = -1
        L_0x0085:
            switch(r5) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0095;
                case 2: goto L_0x0090;
                case 3: goto L_0x008c;
                default: goto L_0x0088;
            }
        L_0x0088:
            r8.skipValue()
            goto L_0x0039
        L_0x008c:
            r8.nextDouble()
            goto L_0x0039
        L_0x0090:
            java.lang.String r2 = r8.nextString()
            goto L_0x0039
        L_0x0095:
            java.lang.String r1 = r8.nextString()
            goto L_0x0039
        L_0x009a:
            java.lang.String r0 = r8.nextString()
            goto L_0x0039
        L_0x009f:
            r8.endObject()
            com.airbnb.lottie.model.c r5 = new com.airbnb.lottie.model.c
            r5.<init>(r0, r1, r2)
            java.lang.String r0 = r5.name
            r9.put(r0, r5)
            goto L_0x002d
        L_0x00ad:
            r8.endArray()
            goto L_0x0003
        L_0x00b2:
            r8.endObject()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.r.a(android.util.JsonReader, java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.util.JsonReader r11, com.airbnb.lottie.c r12, android.support.v4.util.SparseArrayCompat<com.airbnb.lottie.model.d> r13) throws java.io.IOException {
        /*
            r11.beginArray()
        L_0x0003:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00f6
            r0 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r11.beginObject()
            r2 = 0
            r4 = 0
            r5 = r0
            r7 = r2
            r8 = r7
            r0 = 0
        L_0x0019:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x00e3
            java.lang.String r1 = r11.nextName()
            r2 = -1
            int r9 = r1.hashCode()
            r10 = -1866931350(0xffffffff90b8e36a, float:-7.292559E-29)
            if (r9 == r10) goto L_0x007a
            r10 = 119(0x77, float:1.67E-43)
            if (r9 == r10) goto L_0x006f
            r10 = 3173(0xc65, float:4.446E-42)
            if (r9 == r10) goto L_0x0065
            r10 = 3076010(0x2eefaa, float:4.310408E-39)
            if (r9 == r10) goto L_0x005b
            r10 = 3530753(0x35e001, float:4.947639E-39)
            if (r9 == r10) goto L_0x0050
            r10 = 109780401(0x68b1db1, float:5.2329616E-35)
            if (r9 == r10) goto L_0x0045
            goto L_0x0084
        L_0x0045:
            java.lang.String r9 = "style"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0084
            r1 = 3
            goto L_0x0085
        L_0x0050:
            java.lang.String r9 = "size"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0084
            r1 = 1
            goto L_0x0085
        L_0x005b:
            java.lang.String r9 = "data"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0084
            r1 = 5
            goto L_0x0085
        L_0x0065:
            java.lang.String r9 = "ch"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0084
            r1 = 0
            goto L_0x0085
        L_0x006f:
            java.lang.String r9 = "w"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0084
            r1 = 2
            goto L_0x0085
        L_0x007a:
            java.lang.String r9 = "fFamily"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0084
            r1 = 4
            goto L_0x0085
        L_0x0084:
            r1 = -1
        L_0x0085:
            switch(r1) {
                case 0: goto L_0x00d9;
                case 1: goto L_0x00d4;
                case 2: goto L_0x00ce;
                case 3: goto L_0x00c8;
                case 4: goto L_0x00c2;
                case 5: goto L_0x008c;
                default: goto L_0x0088;
            }
        L_0x0088:
            r11.skipValue()
            goto L_0x0019
        L_0x008c:
            r11.beginObject()
        L_0x008f:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x00bd
            java.lang.String r1 = "shapes"
            java.lang.String r2 = r11.nextName()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00b9
            r11.beginArray()
        L_0x00a5:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x00b5
            com.airbnb.lottie.model.content.b r1 = com.airbnb.lottie.c.g.i(r11, r12)
            com.airbnb.lottie.model.content.j r1 = (com.airbnb.lottie.model.content.j) r1
            r3.add(r1)
            goto L_0x00a5
        L_0x00b5:
            r11.endArray()
            goto L_0x008f
        L_0x00b9:
            r11.skipValue()
            goto L_0x008f
        L_0x00bd:
            r11.endObject()
            goto L_0x0019
        L_0x00c2:
            java.lang.String r8 = r11.nextString()
            goto L_0x0019
        L_0x00c8:
            java.lang.String r7 = r11.nextString()
            goto L_0x0019
        L_0x00ce:
            double r5 = r11.nextDouble()
            goto L_0x0019
        L_0x00d4:
            r11.nextDouble()
            goto L_0x0019
        L_0x00d9:
            java.lang.String r0 = r11.nextString()
            char r0 = r0.charAt(r4)
            goto L_0x0019
        L_0x00e3:
            r11.endObject()
            com.airbnb.lottie.model.d r1 = new com.airbnb.lottie.model.d
            r2 = r1
            r4 = r0
            r2.<init>(r3, r4, r5, r7, r8)
            int r0 = r1.hashCode()
            r13.put(r0, r1)
            goto L_0x0003
        L_0x00f6:
            r11.endArray()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.r.a(android.util.JsonReader, com.airbnb.lottie.c, android.support.v4.util.SparseArrayCompat):void");
    }
}
    
