    package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.c;

public class Platform {
    public static final int INFO = 4;
    private static final Platform PLATFORM = findPlatform();
    public static final int WARN = 5;
    private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) {
    }

    public String getPrefix() {
        return "OkHttp";
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public static Platform get() {
        return PLATFORM;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        try {
            Object readFieldOrNull = readFieldOrNull(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (readFieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void log(int i, String str, @Nullable Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object getStackTraceForCloseable(String str) {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void logCloseableLeak(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str, (Throwable) obj);
    }

    public static List<String> alpnProtocolNames(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager trustManager = trustManager(sSLSocketFactory);
        if (trustManager != null) {
            return buildCertificateChainCleaner(trustManager);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static Platform findPlatform() {
        ConscryptPlatform buildIfSupported;
        Platform buildIfSupported2 = AndroidPlatform.buildIfSupported();
        if (buildIfSupported2 != null) {
            return buildIfSupported2;
        }
        if (isConscryptPreferred() && (buildIfSupported = ConscryptPlatform.buildIfSupported()) != null) {
            return buildIfSupported;
        }
        Jdk9Platform buildIfSupported3 = Jdk9Platform.buildIfSupported();
        if (buildIfSupported3 != null) {
            return buildIfSupported3;
        }
        Platform buildIfSupported4 = JdkWithJettyBootPlatform.buildIfSupported();
        if (buildIfSupported4 != null) {
            return buildIfSupported4;
        }
        return new Platform();
    }

    static byte[] concatLengthPrefixed(List<Protocol> list) {
        c cVar = new c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                cVar.Nu(protocol.toString().length());
                cVar.GY(protocol.toString());
            }
        }
        return cVar.readByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK, PHI: r4 
      PHI: (r4v1 java.lang.Object) = (r4v0 java.lang.Object), (r4v2 java.lang.Object) binds: [B:0:0x0000, B:20:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T readFieldOrNull(java.lang.Object r4, java.lang.Class<T> r5, java.lang.String r6) {
        /*
        L_0x0000:
            java.lang.Class r0 = r4.getClass()
        L_0x0004:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            r2 = 0
            if (r0 == r1) goto L_0x002f
            java.lang.reflect.Field r1 = r0.getDeclaredField(r6)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            r3 = 1
            r1.setAccessible(r3)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            if (r1 == 0) goto L_0x0023
            boolean r3 = r5.isInstance(r1)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            if (r3 != 0) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            java.lang.Object r1 = r5.cast(r1)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            return r1
        L_0x0023:
            return r2
        L_0x0024:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x002a:
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x0004
        L_0x002f:
            java.lang.String r0 = "delegate"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0042
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r1 = "delegate"
            java.lang.Object r4 = readFieldOrNull(r4, r0, r1)
            if (r4 == 0) goto L_0x0042
            goto L_0x0000
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Platform.readFieldOrNull(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public SSLContext getSSLContext() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
    
