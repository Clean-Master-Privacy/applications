    package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.k;

final class h<T> implements b<T> {
    private volatile boolean canceled;
    @GuardedBy("this")
    private boolean executed;
    private final n<T, ?> kiQ;
    @Nullable
    private final Object[] kiR;
    @GuardedBy("this")
    @Nullable
    private Call kiS;
    @GuardedBy("this")
    @Nullable
    private Throwable kiT;

    h(n<T, ?> nVar, @Nullable Object[] objArr) {
        this.kiQ = nVar;
        this.kiR = objArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: bYG */
    public h<T> clone() {
        return new h<>(this.kiQ, this.kiR);
    }

    public final void a(d<T> dVar) {
        Call call;
        Throwable th;
        o.checkNotNull(dVar, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                call = this.kiS;
                th = this.kiT;
                if (call == null && th == null) {
                    try {
                        Call bYH = bYH();
                        this.kiS = bYH;
                        call = bYH;
                    } catch (Throwable th2) {
                        th = th2;
                        this.kiT = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            dVar.onFailure(this, th);
            return;
        }
        boolean z = this.canceled;
        call.enqueue(new 1(this, dVar));
    }

    public final l<T> bYD() throws IOException {
        Call call;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                if (this.kiT == null) {
                    call = this.kiS;
                    if (call == null) {
                        try {
                            call = bYH();
                            this.kiS = call;
                        } catch (IOException | RuntimeException e) {
                            this.kiT = e;
                            throw e;
                        }
                    }
                } else if (this.kiT instanceof IOException) {
                    throw ((IOException) this.kiT);
                } else {
                    throw ((RuntimeException) this.kiT);
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        boolean z = this.canceled;
        return b(call.execute());
    }

    private Call bYH() throws IOException {
        HttpUrl httpUrl;
        n<T, ?> nVar = this.kiQ;
        Object[] objArr = this.kiR;
        k kVar = new k(nVar.kjt, nVar.baseUrl, nVar.kje, nVar.headers, nVar.contentType, nVar.kjh, nVar.kju, nVar.kjv);
        i[] iVarArr = nVar.kjw;
        int length = objArr != null ? objArr.length : 0;
        if (length == iVarArr.length) {
            for (int i = 0; i < length; i++) {
                iVarArr[i].a(kVar, objArr[i]);
            }
            HttpUrl.Builder builder = kVar.kjf;
            if (builder != null) {
                httpUrl = builder.build();
            } else {
                httpUrl = kVar.baseUrl.resolve(kVar.kje);
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Malformed URL. Base: " + kVar.baseUrl + ", Relative: " + kVar.kje);
                }
            }
            RequestBody requestBody = kVar.body;
            if (requestBody == null) {
                if (kVar.kjj != null) {
                    requestBody = kVar.kjj.build();
                } else if (kVar.kji != null) {
                    requestBody = kVar.kji.build();
                } else if (kVar.kjh) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
            MediaType mediaType = kVar.contentType;
            if (mediaType != null) {
                if (requestBody != null) {
                    requestBody = new k.a(requestBody, mediaType);
                } else {
                    kVar.kjg.addHeader("Content-Type", mediaType.toString());
                }
            }
            Call newCall = this.kiQ.callFactory.newCall(kVar.kjg.url(httpUrl).method(kVar.method, requestBody).build());
            if (newCall != null) {
                return newCall;
            }
            throw new NullPointerException("Call.Factory returned null.");
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + iVarArr.length + ")");
    }

    /* access modifiers changed from: package-private */
    public final l<T> b(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new b(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return l.a(o.b(body), build);
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            body.close();
            return l.a(null, build);
        } else {
            a aVar = new a(body);
            try {
                return l.a(this.kiQ.kjs.convert(aVar), build);
            } catch (RuntimeException e) {
                if (aVar.thrownException != null) {
                    throw aVar.thrownException;
                }
                throw e;
            }
        }
    }

    public final boolean isCanceled() {
        boolean z;
        boolean z2 = this.canceled;
        synchronized (this) {
            z = this.kiS != null && this.kiS.isCanceled();
        }
        return z;
    }
}
    
