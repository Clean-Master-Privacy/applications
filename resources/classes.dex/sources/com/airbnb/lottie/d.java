    package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.WorkerThread;
import android.util.JsonReader;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.model.g;
import com.appsflyer.share.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class d {
    /* access modifiers changed from: private */
    public static final Map<String, j<c>> lx = new HashMap();

    public static j<c> s(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return a(str, (Callable<i<c>>) new Callable<i<c>>() {
            public final /* synthetic */ Object call() throws Exception {
                return d.t(applicationContext, str);
            }
        });
    }

    @WorkerThread
    public static i<c> t(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return a(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return a(context.getAssets().open(str), str2, true);
        } catch (IOException e) {
            return new i<>((Throwable) e);
        }
    }

    public static j<c> d(Context context, @RawRes final int i) {
        final Context applicationContext = context.getApplicationContext();
        return a(E(i), (Callable<i<c>>) new Callable<i<c>>() {
            public final /* synthetic */ Object call() throws Exception {
                return d.e(applicationContext, i);
            }
        });
    }

    @WorkerThread
    public static i<c> e(Context context, @RawRes int i) {
        try {
            return a(context.getResources().openRawResource(i), E(i), true);
        } catch (Resources.NotFoundException e) {
            return new i<>((Throwable) e);
        }
    }

    private static String E(@RawRes int i) {
        return "rawRes_" + i;
    }

    @WorkerThread
    public static i<c> a(InputStream inputStream, @Nullable String str) {
        return a(inputStream, str, true);
    }

    @WorkerThread
    private static i<c> a(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return a(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                e.closeQuietly(inputStream);
            }
        }
    }

    @WorkerThread
    public static i<c> a(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            e.closeQuietly(zipInputStream);
        }
    }

    @WorkerThread
    private static i<c> b(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            c cVar = null;
            while (nextEntry != null) {
                if (!nextEntry.getName().contains("__MACOSX")) {
                    if (nextEntry.getName().contains(".json")) {
                        cVar = (c) a(zipInputStream, str, false).value;
                    } else if (nextEntry.getName().contains(".png")) {
                        String[] split = nextEntry.getName().split(Constants.URL_PATH_DELIMITER);
                        hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (cVar == null) {
                return new i<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                f a2 = a(cVar, (String) entry.getKey());
                if (a2 != null) {
                    a2.bitmap = (Bitmap) entry.getValue();
                }
            }
            for (Map.Entry next : cVar.lp.entrySet()) {
                if (((f) next.getValue()).bitmap == null) {
                    return new i<>((Throwable) new IllegalStateException("There is no image for " + ((f) next.getValue()).fileName));
                }
            }
            g.cN().a(str, cVar);
            return new i<>(cVar);
        } catch (IOException e) {
            return new i<>((Throwable) e);
        }
    }

    private static j<c> a(final String str, Callable<i<c>> callable) {
        if (lx.containsKey(str)) {
            return lx.get(str);
        }
        j<c> jVar = new j<>(callable);
        jVar.a(new g<c>() {
            public final /* synthetic */ void onResult(Object obj) {
                d.lx.remove(str);
            }
        });
        jVar.c(new g<Throwable>() {
            public final /* synthetic */ void onResult(Object obj) {
                d.lx.remove(str);
            }
        });
        lx.put(str, jVar);
        return jVar;
    }

    public static j<c> r(Context context, String str) {
        return new j<>(new Callable<i<c>>() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ java.lang.Object call(
/*
Method generation error in method: com.airbnb.lottie.network.b.1.call():java.lang.Object, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.airbnb.lottie.network.b.1.call():java.lang.Object, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.airbnb.lottie.i<com.airbnb.lottie.c> a(android.util.JsonReader r22, @android.support.annotation.Nullable java.lang.String r23) {
        /*
            r0 = r22
            float r1 = com.airbnb.lottie.d.e.dd()     // Catch:{ Exception -> 0x0171 }
            android.support.v4.util.LongSparseArray r2 = new android.support.v4.util.LongSparseArray     // Catch:{ Exception -> 0x0171 }
            r2.<init>()     // Catch:{ Exception -> 0x0171 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0171 }
            r3.<init>()     // Catch:{ Exception -> 0x0171 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0171 }
            r4.<init>()     // Catch:{ Exception -> 0x0171 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x0171 }
            r5.<init>()     // Catch:{ Exception -> 0x0171 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x0171 }
            r6.<init>()     // Catch:{ Exception -> 0x0171 }
            android.support.v4.util.SparseArrayCompat r7 = new android.support.v4.util.SparseArrayCompat     // Catch:{ Exception -> 0x0171 }
            r7.<init>()     // Catch:{ Exception -> 0x0171 }
            com.airbnb.lottie.c r8 = new com.airbnb.lottie.c     // Catch:{ Exception -> 0x0171 }
            r8.<init>()     // Catch:{ Exception -> 0x0171 }
            r22.beginObject()     // Catch:{ Exception -> 0x0171 }
            r9 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x0032:
            boolean r15 = r22.hasNext()     // Catch:{ Exception -> 0x0171 }
            if (r15 == 0) goto L_0x0135
            java.lang.String r15 = r22.nextName()     // Catch:{ Exception -> 0x0171 }
            r16 = -1
            int r17 = r15.hashCode()     // Catch:{ Exception -> 0x0171 }
            r18 = 2
            r19 = 1
            switch(r17) {
                case -1408207997: goto L_0x00a9;
                case -1109732030: goto L_0x009f;
                case 104: goto L_0x0095;
                case 118: goto L_0x008a;
                case 119: goto L_0x007f;
                case 3276: goto L_0x0075;
                case 3367: goto L_0x006b;
                case 3553: goto L_0x0061;
                case 94623709: goto L_0x0056;
                case 97615364: goto L_0x004b;
                default: goto L_0x0049;
            }     // Catch:{ Exception -> 0x0171 }
        L_0x0049:
            goto L_0x00b3
        L_0x004b:
            java.lang.String r10 = "fonts"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 8
            goto L_0x00b4
        L_0x0056:
            java.lang.String r10 = "chars"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 9
            goto L_0x00b4
        L_0x0061:
            java.lang.String r10 = "op"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 3
            goto L_0x00b4
        L_0x006b:
            java.lang.String r10 = "ip"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 2
            goto L_0x00b4
        L_0x0075:
            java.lang.String r10 = "fr"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 4
            goto L_0x00b4
        L_0x007f:
            java.lang.String r10 = "w"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 0
            goto L_0x00b4
        L_0x008a:
            java.lang.String r10 = "v"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 5
            goto L_0x00b4
        L_0x0095:
            java.lang.String r10 = "h"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 1
            goto L_0x00b4
        L_0x009f:
            java.lang.String r10 = "layers"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 6
            goto L_0x00b4
        L_0x00a9:
            java.lang.String r10 = "assets"
            boolean r10 = r15.equals(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x00b3
            r10 = 7
            goto L_0x00b4
        L_0x00b3:
            r10 = -1
        L_0x00b4:
            switch(r10) {
                case 0: goto L_0x0125;
                case 1: goto L_0x011c;
                case 2: goto L_0x0112;
                case 3: goto L_0x0103;
                case 4: goto L_0x00fd;
                case 5: goto L_0x00d4;
                case 6: goto L_0x00cc;
                case 7: goto L_0x00c8;
                case 8: goto L_0x00c4;
                case 9: goto L_0x00c0;
                default: goto L_0x00b7;
            }     // Catch:{ Exception -> 0x0171 }
        L_0x00b7:
            r20 = r6
            r21 = r7
            r22.skipValue()     // Catch:{ Exception -> 0x0171 }
            goto L_0x012d
        L_0x00c0:
            com.airbnb.lottie.c.r.a(r0, r8, r7)     // Catch:{ Exception -> 0x0171 }
            goto L_0x00cf
        L_0x00c4:
            com.airbnb.lottie.c.r.a(r0, r6)     // Catch:{ Exception -> 0x0171 }
            goto L_0x00cf
        L_0x00c8:
            com.airbnb.lottie.c.r.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r8, (java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.model.layer.Layer>>) r4, (java.util.Map<java.lang.String, com.airbnb.lottie.f>) r5)     // Catch:{ Exception -> 0x0171 }
            goto L_0x00cf
        L_0x00cc:
            com.airbnb.lottie.c.r.a((android.util.JsonReader) r0, (com.airbnb.lottie.c) r8, (java.util.List<com.airbnb.lottie.model.layer.Layer>) r3, (android.support.v4.util.LongSparseArray<com.airbnb.lottie.model.layer.Layer>) r2)     // Catch:{ Exception -> 0x0171 }
        L_0x00cf:
            r20 = r6
            r21 = r7
            goto L_0x012d
        L_0x00d4:
            java.lang.String r10 = r22.nextString()     // Catch:{ Exception -> 0x0171 }
            java.lang.String r15 = "\\."
            java.lang.String[] r10 = r10.split(r15)     // Catch:{ Exception -> 0x0171 }
            r15 = 0
            r16 = r10[r15]     // Catch:{ Exception -> 0x0171 }
            int r15 = java.lang.Integer.parseInt(r16)     // Catch:{ Exception -> 0x0171 }
            r16 = r10[r19]     // Catch:{ Exception -> 0x0171 }
            int r0 = java.lang.Integer.parseInt(r16)     // Catch:{ Exception -> 0x0171 }
            r10 = r10[r18]     // Catch:{ Exception -> 0x0171 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x0171 }
            boolean r0 = com.airbnb.lottie.d.e.b(r15, r0, r10)     // Catch:{ Exception -> 0x0171 }
            if (r0 != 0) goto L_0x00cf
            java.lang.String r0 = "Lottie only supports bodymovin >= 4.4.0"
            r8.bu(r0)     // Catch:{ Exception -> 0x0171 }
            goto L_0x00cf
        L_0x00fd:
            double r14 = r22.nextDouble()     // Catch:{ Exception -> 0x0171 }
            float r14 = (float) r14     // Catch:{ Exception -> 0x0171 }
            goto L_0x0131
        L_0x0103:
            r20 = r6
            r21 = r7
            double r6 = r22.nextDouble()     // Catch:{ Exception -> 0x0171 }
            float r0 = (float) r6     // Catch:{ Exception -> 0x0171 }
            r6 = 1008981770(0x3c23d70a, float:0.01)
            float r13 = r0 - r6
            goto L_0x012d
        L_0x0112:
            r20 = r6
            r21 = r7
            double r6 = r22.nextDouble()     // Catch:{ Exception -> 0x0171 }
            float r12 = (float) r6     // Catch:{ Exception -> 0x0171 }
            goto L_0x012d
        L_0x011c:
            r20 = r6
            r21 = r7
            int r11 = r22.nextInt()     // Catch:{ Exception -> 0x0171 }
            goto L_0x012d
        L_0x0125:
            r20 = r6
            r21 = r7
            int r9 = r22.nextInt()     // Catch:{ Exception -> 0x0171 }
        L_0x012d:
            r6 = r20
            r7 = r21
        L_0x0131:
            r0 = r22
            goto L_0x0032
        L_0x0135:
            r20 = r6
            r21 = r7
            r22.endObject()     // Catch:{ Exception -> 0x0171 }
            float r0 = (float) r9     // Catch:{ Exception -> 0x0171 }
            float r0 = r0 * r1
            int r0 = (int) r0     // Catch:{ Exception -> 0x0171 }
            float r6 = (float) r11     // Catch:{ Exception -> 0x0171 }
            float r6 = r6 * r1
            int r1 = (int) r6     // Catch:{ Exception -> 0x0171 }
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ Exception -> 0x0171 }
            r7 = 0
            r6.<init>(r7, r7, r0, r1)     // Catch:{ Exception -> 0x0171 }
            r8.bounds = r6     // Catch:{ Exception -> 0x0171 }
            r8.lu = r12     // Catch:{ Exception -> 0x0171 }
            r8.lv = r13     // Catch:{ Exception -> 0x0171 }
            r8.lw = r14     // Catch:{ Exception -> 0x0171 }
            r8.lt = r3     // Catch:{ Exception -> 0x0171 }
            r8.ls = r2     // Catch:{ Exception -> 0x0171 }
            r8.lo = r4     // Catch:{ Exception -> 0x0171 }
            r8.lp = r5     // Catch:{ Exception -> 0x0171 }
            r0 = r21
            r8.lr = r0     // Catch:{ Exception -> 0x0171 }
            r0 = r20
            r8.lq = r0     // Catch:{ Exception -> 0x0171 }
            com.airbnb.lottie.model.g r0 = com.airbnb.lottie.model.g.cN()     // Catch:{ Exception -> 0x0171 }
            r1 = r23
            r0.a(r1, r8)     // Catch:{ Exception -> 0x0171 }
            com.airbnb.lottie.i r0 = new com.airbnb.lottie.i     // Catch:{ Exception -> 0x0171 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0171 }
            return r0
        L_0x0171:
            r0 = move-exception
            com.airbnb.lottie.i r1 = new com.airbnb.lottie.i
            r1.<init>((java.lang.Throwable) r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.d.a(android.util.JsonReader, java.lang.String):com.airbnb.lottie.i");
    }

    @Nullable
    private static f a(c cVar, String str) {
        for (f next : cVar.lp.values()) {
            if (next.fileName.equals(str)) {
                return next;
            }
        }
        return null;
    }
}
    
