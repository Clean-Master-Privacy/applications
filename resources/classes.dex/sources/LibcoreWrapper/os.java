    package LibcoreWrapper;

public class os {
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ExcHandler: NoSuchMethodException (unused java.lang.NoSuchMethodException), SYNTHETIC, Splitter:B:12:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[ExcHandler: IllegalAccessException | NullPointerException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:9:0x0010] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void close(java.io.FileDescriptor r7) {
        /*
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "libcore.io.Libcore"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0037 }
            java.lang.String r1 = "os"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch:{ NoSuchFieldException -> 0x0036 }
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ IllegalAccessException | NullPointerException -> 0x0035, IllegalArgumentException -> 0x0034 }
            r2 = 0
            java.lang.Object r0 = r0.get(r2)     // Catch:{ IllegalAccessException | NullPointerException -> 0x0035, IllegalArgumentException -> 0x0034 }
            java.lang.Class r2 = r0.getClass()     // Catch:{ IllegalAccessException | NullPointerException -> 0x0035, IllegalArgumentException -> 0x0034 }
            java.lang.String r3 = "close"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0033, IllegalAccessException | NullPointerException -> 0x0035 }
            java.lang.Class<java.io.FileDescriptor> r5 = java.io.FileDescriptor.class
            r6 = 0
            r4[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0033, IllegalAccessException | NullPointerException -> 0x0035 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0033, IllegalAccessException | NullPointerException -> 0x0035 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException | NullPointerException | InvocationTargetException -> 0x0032, IllegalArgumentException -> 0x0031, NoSuchMethodException -> 0x0033 }
            r1[r6] = r7     // Catch:{ IllegalAccessException | NullPointerException | InvocationTargetException -> 0x0032, IllegalArgumentException -> 0x0031, NoSuchMethodException -> 0x0033 }
            r2.invoke(r0, r1)     // Catch:{ IllegalAccessException | NullPointerException | InvocationTargetException -> 0x0032, IllegalArgumentException -> 0x0031, NoSuchMethodException -> 0x0033 }
            return
        L_0x0031:
            return
        L_0x0032:
            return
        L_0x0033:
            return
        L_0x0034:
            return
        L_0x0035:
            return
        L_0x0036:
            return
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: LibcoreWrapper.os.close(java.io.FileDescriptor):void");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static LibcoreWrapper.a stat(java.lang.String r8) {
        /*
            r0 = 0
            java.lang.String r1 = "libcore.io.Libcore"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{  }
            java.lang.String r2 = "os"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{  }
            r2 = 1
            r1.setAccessible(r2)     // Catch:{ ClassNotFoundException -> 0x0032 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ ClassNotFoundException -> 0x0032 }
            java.lang.Class r3 = r1.getClass()     // Catch:{ ClassNotFoundException -> 0x0032 }
            java.lang.String r4 = "stat"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{  }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{  }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{  }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ ClassNotFoundException -> 0x0032 }
            r2[r7] = r8     // Catch:{ ClassNotFoundException -> 0x0032 }
            java.lang.Object r8 = r3.invoke(r1, r2)     // Catch:{ ClassNotFoundException -> 0x0032 }
            LibcoreWrapper.a r8 = (LibcoreWrapper.a) r8     // Catch:{ ClassNotFoundException -> 0x0032 }
            goto L_0x0033
        L_0x0032:
            r8 = r0
        L_0x0033:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: LibcoreWrapper.os.stat(java.lang.String):LibcoreWrapper.a");
    }
}
    
