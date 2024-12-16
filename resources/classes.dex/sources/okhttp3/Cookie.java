    package okhttp3;

import com.appsflyer.share.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    Cookie(Builder builder) {
        if (builder.name == null) {
            throw new NullPointerException("builder.name == null");
        } else if (builder.value == null) {
            throw new NullPointerException("builder.value == null");
        } else if (builder.domain != null) {
            this.name = builder.name;
            this.value = builder.value;
            this.expiresAt = builder.expiresAt;
            this.domain = builder.domain;
            this.path = builder.path;
            this.secure = builder.secure;
            this.httpOnly = builder.httpOnly;
            this.persistent = builder.persistent;
            this.hostOnly = builder.hostOnly;
        } else {
            throw new NullPointerException("builder.domain == null");
        }
    }

    public final String name() {
        return this.name;
    }

    public final String value() {
        return this.value;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final String domain() {
        return this.domain;
    }

    public final String path() {
        return this.path;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean secure() {
        return this.secure;
    }

    public final boolean matches(HttpUrl httpUrl) {
        boolean z;
        if (this.hostOnly) {
            z = httpUrl.host().equals(this.domain);
        } else {
            z = domainMatch(httpUrl.host(), this.domain);
        }
        if (!z || !pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.verifyAsIpAddress(str)) {
            return false;
        }
        return true;
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (!encodedPath.startsWith(str)) {
            return false;
        }
        if (!str.endsWith(Constants.URL_PATH_DELIMITER) && encodedPath.charAt(str.length()) != '/') {
            return false;
        }
        return true;
    }

    @Nullable
    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0118 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0119  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static okhttp3.Cookie parse(long r25, okhttp3.HttpUrl r27, java.lang.String r28) {
        /*
            r2 = r28
            int r3 = r28.length()
            r4 = 59
            r5 = 0
            int r6 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r2, (int) r5, (int) r3, (char) r4)
            r7 = 61
            int r8 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r2, (int) r5, (int) r6, (char) r7)
            r9 = 0
            if (r8 != r6) goto L_0x0017
            return r9
        L_0x0017:
            java.lang.String r11 = okhttp3.internal.Util.trimSubstring(r2, r5, r8)
            boolean r10 = r11.isEmpty()
            if (r10 != 0) goto L_0x014e
            int r10 = okhttp3.internal.Util.indexOfControlOrNonAscii(r11)
            r12 = -1
            if (r10 == r12) goto L_0x002a
            goto L_0x014e
        L_0x002a:
            r10 = 1
            int r8 = r8 + r10
            java.lang.String r8 = okhttp3.internal.Util.trimSubstring(r2, r8, r6)
            int r13 = okhttp3.internal.Util.indexOfControlOrNonAscii(r8)
            if (r13 == r12) goto L_0x0037
            return r9
        L_0x0037:
            int r6 = r6 + r10
            r12 = -1
            r14 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r10 = r9
            r21 = r10
            r16 = r12
            r19 = r14
            r18 = 0
            r22 = 0
            r23 = 1
            r24 = 0
        L_0x004e:
            if (r6 >= r3) goto L_0x00c3
            int r9 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r2, (int) r6, (int) r3, (char) r4)
            int r4 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r2, (int) r6, (int) r9, (char) r7)
            java.lang.String r6 = okhttp3.internal.Util.trimSubstring(r2, r6, r4)
            if (r4 >= r9) goto L_0x0065
            int r4 = r4 + 1
            java.lang.String r4 = okhttp3.internal.Util.trimSubstring(r2, r4, r9)
            goto L_0x0067
        L_0x0065:
            java.lang.String r4 = ""
        L_0x0067:
            java.lang.String r7 = "expires"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x007c
            int r6 = r4.length()     // Catch:{ IllegalArgumentException -> 0x00bb }
            long r6 = parseExpires(r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x00bb }
            r19 = r6
        L_0x0079:
            r24 = 1
            goto L_0x00bb
        L_0x007c:
            java.lang.String r7 = "max-age"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x008b
            long r6 = parseMaxAge(r4)     // Catch:{  }
            r16 = r6
            goto L_0x0079
        L_0x008b:
            java.lang.String r7 = "domain"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x009b
            java.lang.String r4 = parseDomain(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            r10 = r4
            r23 = 0
            goto L_0x00bb
        L_0x009b:
            java.lang.String r7 = "path"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x00a6
            r21 = r4
            goto L_0x00bb
        L_0x00a6:
            java.lang.String r4 = "secure"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00b1
            r18 = 1
            goto L_0x00bb
        L_0x00b1:
            java.lang.String r4 = "httponly"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00bb
            r22 = 1
        L_0x00bb:
            int r6 = r9 + 1
            r4 = 59
            r7 = 61
            r9 = 0
            goto L_0x004e
        L_0x00c3:
            r2 = -9223372036854775808
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00cb
        L_0x00c9:
            r13 = r2
            goto L_0x00f1
        L_0x00cb:
            int r2 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x00ef
            r2 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x00dd
            r2 = 1000(0x3e8, double:4.94E-321)
            long r16 = r16 * r2
            goto L_0x00e2
        L_0x00dd:
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00e2:
            r2 = 0
            long r2 = r25 + r16
            int r4 = (r2 > r25 ? 1 : (r2 == r25 ? 0 : -1))
            if (r4 < 0) goto L_0x00ed
            int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c9
        L_0x00ed:
            r13 = r14
            goto L_0x00f1
        L_0x00ef:
            r13 = r19
        L_0x00f1:
            java.lang.String r0 = r27.host()
            if (r10 != 0) goto L_0x00fa
            r15 = r0
            r1 = 0
            goto L_0x0104
        L_0x00fa:
            boolean r1 = domainMatch(r0, r10)
            if (r1 != 0) goto L_0x0102
            r1 = 0
            return r1
        L_0x0102:
            r1 = 0
            r15 = r10
        L_0x0104:
            int r0 = r0.length()
            int r2 = r15.length()
            if (r0 == r2) goto L_0x0119
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.get()
            java.lang.String r0 = r0.getEffectiveTldPlusOne(r15)
            if (r0 != 0) goto L_0x0119
            return r1
        L_0x0119:
            r9 = r21
            if (r9 == 0) goto L_0x0129
            java.lang.String r0 = "/"
            boolean r0 = r9.startsWith(r0)
            if (r0 != 0) goto L_0x0126
            goto L_0x0129
        L_0x0126:
            r16 = r9
            goto L_0x013e
        L_0x0129:
            java.lang.String r0 = r27.encodedPath()
            r1 = 47
            int r1 = r0.lastIndexOf(r1)
            if (r1 == 0) goto L_0x013a
            java.lang.String r0 = r0.substring(r5, r1)
            goto L_0x013c
        L_0x013a:
            java.lang.String r0 = "/"
        L_0x013c:
            r16 = r0
        L_0x013e:
            okhttp3.Cookie r0 = new okhttp3.Cookie
            r10 = r0
            r12 = r8
            r17 = r18
            r18 = r22
            r19 = r23
            r20 = r24
            r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x014e:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.parse(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
    }

    private static long parseExpires(String str, int i, int i2) {
        int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (dateCharacterOffset < i2) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i3 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = parseInt2;
                i3 = parseInt;
            } else if (i5 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                i6 = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 <= 0 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long parseMaxAge(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    private static String parseDomain(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String canonicalizeHost = Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                return canonicalizeHost;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie parse = parse(httpUrl, values.get(i));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static final class Builder {
        @Nullable
        String domain;
        long expiresAt = 253402300799999L;
        boolean hostOnly;
        boolean httpOnly;
        @Nullable
        String name;
        String path = Constants.URL_PATH_DELIMITER;
        boolean persistent;
        boolean secure;
        @Nullable
        String value;

        public final Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.name = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public final Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.value = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > 253402300799999L) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public final Builder domain(String str) {
            return domain(str, false);
        }

        public final Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        private Builder domain(String str, boolean z) {
            if (str != null) {
                String canonicalizeHost = Util.canonicalizeHost(str);
                if (canonicalizeHost != null) {
                    this.domain = canonicalizeHost;
                    this.hostOnly = z;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
        }

        public final Builder path(String str) {
            if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Cookie build() {
            return new Cookie(this);
        }
    }

    public final String toString() {
        return toString(false);
    }

    /* access modifiers changed from: package-private */
    public final String toString(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((this.name.hashCode() + 527) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (this.expiresAt ^ (this.expiresAt >>> 32)))) * 31) + (this.secure ^ true ? 1 : 0)) * 31) + (this.httpOnly ^ true ? 1 : 0)) * 31) + (this.persistent ^ true ? 1 : 0)) * 31) + (this.hostOnly ^ true ? 1 : 0);
    }
}
    
