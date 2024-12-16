    package retrofit2;

import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.c;

final class k {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final HttpUrl baseUrl;
    @Nullable
    RequestBody body;
    @Nullable
    MediaType contentType;
    @Nullable
    String kje;
    @Nullable
    HttpUrl.Builder kjf;
    final Request.Builder kjg = new Request.Builder();
    final boolean kjh;
    @Nullable
    MultipartBody.Builder kji;
    @Nullable
    FormBody.Builder kjj;
    final String method;

    k(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.kje = str2;
        this.contentType = mediaType;
        this.kjh = z;
        if (headers != null) {
            this.kjg.headers(headers);
        }
        if (z2) {
            this.kjj = new FormBody.Builder();
        } else if (z3) {
            this.kji = new MultipartBody.Builder();
            this.kji.setType(MultipartBody.FORM);
        }
    }

    /* access modifiers changed from: package-private */
    public final void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            MediaType parse = MediaType.parse(str2);
            if (parse != null) {
                this.contentType = parse;
                return;
            }
            throw new IllegalArgumentException("Malformed content type: " + str2);
        }
        this.kjg.addHeader(str, str2);
    }

    static String Z(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                c cVar = new c();
                cVar.t(str, 0, i);
                c cVar2 = null;
                while (i < length) {
                    int codePointAt2 = str.codePointAt(i);
                    if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (codePointAt2 < 32 || codePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt2) != -1 || (!z && (codePointAt2 == 47 || codePointAt2 == 37))) {
                            if (cVar2 == null) {
                                cVar2 = new c();
                            }
                            cVar2.Nn(codePointAt2);
                            while (!cVar2.bYk()) {
                                byte readByte = cVar2.readByte() & 255;
                                cVar.Nu(37);
                                cVar.Nu(HEX_DIGITS[(readByte >> 4) & 15]);
                                cVar.Nu(HEX_DIGITS[readByte & 15]);
                            }
                        } else {
                            cVar.Nn(codePointAt2);
                        }
                    }
                    i += Character.charCount(codePointAt2);
                }
                return cVar.bYr();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void p(String str, @Nullable String str2, boolean z) {
        if (this.kje != null) {
            this.kjf = this.baseUrl.newBuilder(this.kje);
            if (this.kjf != null) {
                this.kje = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.kje);
            }
        }
        if (z) {
            this.kjf.addEncodedQueryParameter(str, str2);
        } else {
            this.kjf.addQueryParameter(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void q(String str, String str2, boolean z) {
        if (z) {
            this.kjj.addEncoded(str, str2);
        } else {
            this.kjj.add(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Headers headers, RequestBody requestBody) {
        this.kji.addPart(headers, requestBody);
    }
}
    
