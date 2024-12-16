    package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.a;
import okio.r;

final class RealCall implements Call {

    /* renamed from: client  reason: collision with root package name */
    final OkHttpClient f375client;
    /* access modifiers changed from: private */
    @Nullable
    public EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final a timeout = new 1(this);

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.f375client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
        this.timeout.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    public final Request request() {
        return this.originalRequest;
    }

    public final Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            this.f375client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                this.f375client.dispatcher().finished(this);
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException timeoutExit = timeoutExit(e);
            this.eventListener.callFailed(this, timeoutExit);
            throw timeoutExit;
        } catch (Throwable th) {
            this.f375client.dispatcher().finished(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final IOException timeoutExit(@Nullable IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public final void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.f375client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public final void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public final r timeout() {
        return this.timeout;
    }

    public final synchronized boolean isExecuted() {
        return this.executed;
    }

    public final boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    public final RealCall clone() {
        return newRealCall(this.f375client, this.originalRequest, this.forWebSocket);
    }

    /* access modifiers changed from: package-private */
    public final StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        static {
            Class<RealCall> cls = RealCall.class;
        }

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public final String host() {
            return RealCall.this.originalRequest.url().host();
        }

        /* access modifiers changed from: package-private */
        public final Request request() {
            return RealCall.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public final RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public final void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.f375client.dispatcher().finished(this);
            } catch (Throwable th) {
                RealCall.this.f375client.dispatcher().finished(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004a A[Catch:{ all -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0067 A[Catch:{ all -> 0x003d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void execute() {
            /*
                r5 = this;
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okio.a r0 = r0.timeout
                r0.enter()
                r0 = 1
                r1 = 0
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003f }
                okhttp3.Response r2 = r2.getResponseWithInterceptorChain()     // Catch:{ IOException -> 0x003f }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003f }
                okhttp3.internal.http.RetryAndFollowUpInterceptor r3 = r3.retryAndFollowUpInterceptor     // Catch:{ IOException -> 0x003f }
                boolean r3 = r3.isCanceled()     // Catch:{ IOException -> 0x003f }
                if (r3 == 0) goto L_0x002a
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x0028 }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0028 }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0028 }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x0028 }
                r1.onFailure(r2, r3)     // Catch:{ IOException -> 0x0028 }
                goto L_0x0031
            L_0x0028:
                r1 = move-exception
                goto L_0x0042
            L_0x002a:
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x0028 }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0028 }
                r1.onResponse(r3, r2)     // Catch:{ IOException -> 0x0028 }
            L_0x0031:
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r0 = r0.f375client
                okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.finished((okhttp3.RealCall.AsyncCall) r5)
                return
            L_0x003d:
                r0 = move-exception
                goto L_0x007a
            L_0x003f:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0042:
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                java.io.IOException r1 = r2.timeoutExit(r1)     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x0067
                okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x003d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
                java.lang.String r4 = "Callback failure for "
                r3.<init>(r4)     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r4 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                java.lang.String r4 = r4.toLoggableString()     // Catch:{ all -> 0x003d }
                r3.append(r4)     // Catch:{ all -> 0x003d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x003d }
                r0.log(r2, r3, r1)     // Catch:{ all -> 0x003d }
                goto L_0x0031
            L_0x0067:
                okhttp3.RealCall r0 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                okhttp3.EventListener r0 = r0.eventListener     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                r0.callFailed(r2, r1)     // Catch:{ all -> 0x003d }
                okhttp3.Callback r0 = r5.responseCallback     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                r0.onFailure(r2, r1)     // Catch:{ all -> 0x003d }
                goto L_0x0031
            L_0x007a:
                okhttp3.RealCall r1 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r1 = r1.f375client
                okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.finished((okhttp3.RealCall.AsyncCall) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.AsyncCall.execute():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    /* access modifiers changed from: package-private */
    public final Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f375client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.f375client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.f375client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.f375client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.f375client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        return new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.originalRequest, this, this.eventListener, this.f375client.connectTimeoutMillis(), this.f375client.readTimeoutMillis(), this.f375client.writeTimeoutMillis()).proceed(this.originalRequest);
    }
}
    
