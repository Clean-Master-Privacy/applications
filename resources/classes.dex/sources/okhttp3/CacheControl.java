    package okhttp3;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    @Nullable
    String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    CacheControl(Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
        this.immutable = builder.immutable;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okhttp3.CacheControl parse(okhttp3.Headers r23) {
        /*
            r0 = r23
            int r1 = r23.size()
            r6 = 0
            r7 = 1
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = -1
            r18 = -1
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x001b:
            if (r6 >= r1) goto L_0x0149
            java.lang.String r9 = r0.name(r6)
            java.lang.String r2 = r0.value(r6)
            java.lang.String r4 = "Cache-Control"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0033
            if (r8 == 0) goto L_0x0031
        L_0x002f:
            r7 = 0
            goto L_0x003c
        L_0x0031:
            r8 = r2
            goto L_0x003c
        L_0x0033:
            java.lang.String r4 = "Pragma"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0142
            goto L_0x002f
        L_0x003c:
            r4 = 0
        L_0x003d:
            int r9 = r2.length()
            if (r4 >= r9) goto L_0x0142
            java.lang.String r9 = "=,;"
            int r9 = okhttp3.internal.http.HttpHeaders.skipUntil(r2, r4, r9)
            java.lang.String r4 = r2.substring(r4, r9)
            java.lang.String r4 = r4.trim()
            int r3 = r2.length()
            if (r9 == r3) goto L_0x009e
            char r3 = r2.charAt(r9)
            r5 = 44
            if (r3 == r5) goto L_0x009e
            char r3 = r2.charAt(r9)
            r5 = 59
            if (r3 != r5) goto L_0x0068
            goto L_0x009e
        L_0x0068:
            int r9 = r9 + 1
            int r3 = okhttp3.internal.http.HttpHeaders.skipWhitespace(r2, r9)
            int r5 = r2.length()
            if (r3 >= r5) goto L_0x008d
            char r5 = r2.charAt(r3)
            r9 = 34
            if (r5 != r9) goto L_0x008d
            int r3 = r3 + 1
            java.lang.String r5 = "\""
            int r5 = okhttp3.internal.http.HttpHeaders.skipUntil(r2, r3, r5)
            java.lang.String r3 = r2.substring(r3, r5)
            r22 = 1
            int r5 = r5 + 1
            goto L_0x00a4
        L_0x008d:
            r22 = 1
            java.lang.String r5 = ",;"
            int r5 = okhttp3.internal.http.HttpHeaders.skipUntil(r2, r3, r5)
            java.lang.String r3 = r2.substring(r3, r5)
            java.lang.String r3 = r3.trim()
            goto L_0x00a4
        L_0x009e:
            r22 = 1
            int r9 = r9 + 1
            r5 = r9
            r3 = 0
        L_0x00a4:
            java.lang.String r9 = "no-cache"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00af
            r4 = r5
            r10 = 1
            goto L_0x003d
        L_0x00af:
            java.lang.String r9 = "no-store"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00ba
            r4 = r5
            r11 = 1
            goto L_0x003d
        L_0x00ba:
            java.lang.String r9 = "max-age"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00ca
            r9 = -1
            int r12 = okhttp3.internal.http.HttpHeaders.parseSeconds(r3, r9)
        L_0x00c7:
            r4 = r5
            goto L_0x003d
        L_0x00ca:
            java.lang.String r9 = "s-maxage"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00d9
            r9 = -1
            int r13 = okhttp3.internal.http.HttpHeaders.parseSeconds(r3, r9)
            goto L_0x00c7
        L_0x00d9:
            java.lang.String r9 = "private"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00e5
            r4 = r5
            r14 = 1
            goto L_0x003d
        L_0x00e5:
            java.lang.String r9 = "public"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00f1
            r4 = r5
            r15 = 1
            goto L_0x003d
        L_0x00f1:
            java.lang.String r9 = "must-revalidate"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00fe
            r4 = r5
            r16 = 1
            goto L_0x003d
        L_0x00fe:
            java.lang.String r9 = "max-stale"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x010e
            r4 = 2147483647(0x7fffffff, float:NaN)
            int r17 = okhttp3.internal.http.HttpHeaders.parseSeconds(r3, r4)
            goto L_0x00c7
        L_0x010e:
            java.lang.String r9 = "min-fresh"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x011c
            r9 = -1
            int r18 = okhttp3.internal.http.HttpHeaders.parseSeconds(r3, r9)
            goto L_0x00c7
        L_0x011c:
            r9 = -1
            java.lang.String r3 = "only-if-cached"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x012a
            r4 = r5
            r19 = 1
            goto L_0x003d
        L_0x012a:
            java.lang.String r3 = "no-transform"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0137
            r4 = r5
            r20 = 1
            goto L_0x003d
        L_0x0137:
            java.lang.String r3 = "immutable"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00c7
            r21 = 1
            goto L_0x00c7
        L_0x0142:
            r9 = -1
            r22 = 1
            int r6 = r6 + 1
            goto L_0x001b
        L_0x0149:
            if (r7 != 0) goto L_0x014e
            r22 = 0
            goto L_0x0150
        L_0x014e:
            r22 = r8
        L_0x0150:
            okhttp3.CacheControl r0 = new okhttp3.CacheControl
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.parse(okhttp3.Headers):okhttp3.CacheControl");
    }

    public final String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        String headerValue2 = headerValue();
        this.headerValue = headerValue2;
        return headerValue2;
    }

    private String headerValue() {
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
    
