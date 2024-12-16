    package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

abstract class i<T> {
    /* access modifiers changed from: package-private */
    public abstract void a(k kVar, @Nullable T t) throws IOException;

    i() {
    }

    /* access modifiers changed from: package-private */
    public final i<Iterable<T>> bYI() {
        return new i<Iterable<T>>() {
            /* access modifiers changed from: package-private */
            public final /* synthetic */ void a(k kVar, @Nullable Object obj) throws IOException {
                Iterable<Object> iterable = (Iterable) obj;
                if (iterable != null) {
                    for (Object a2 : iterable) {
                        i.this.a(kVar, a2);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final i<Object> bYJ() {
        return new i<Object>() {
            /* access modifiers changed from: package-private */
            public final void a(k kVar, @Nullable Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        i.this.a(kVar, Array.get(obj, i));
                    }
                }
            }
        };
    }

    static final class m extends i<Object> {
        m() {
        }

        /* access modifiers changed from: package-private */
        public final void a(k kVar, @Nullable Object obj) {
            o.checkNotNull(obj, "@Url parameter is null.");
            kVar.kje = obj.toString();
        }
    }

    static final class d<T> extends i<T> {
        private final e<T, String> kiY;
        private final String name;

        d(String str, e<T, String> eVar) {
            this.name = (String) o.checkNotNull(str, "name == null");
            this.kiY = eVar;
        }

        /* access modifiers changed from: package-private */
        public final void a(k kVar, @Nullable T t) throws IOException {
            String str;
            if (t != null && (str = (String) this.kiY.convert(t)) != null) {
                kVar.addHeader(this.name, str);
            }
        }
    }

    static final class h<T> extends i<T> {
        private final e<T, String> kiY;
        private final boolean kiZ;
        private final String name;

        h(String str, e<T, String> eVar, boolean z) {
            this.name = (String) o.checkNotNull(str, "name == null");
            this.kiY = eVar;
            this.kiZ = z;
        }

        /* access modifiers changed from: package-private */
        public final void a(k kVar, @Nullable T t) throws IOException {
            if (t != null) {
                String str = this.name;
                String str2 = (String) this.kiY.convert(t);
                boolean z = this.kiZ;
                if (kVar.kje != null) {
                    String str3 = kVar.kje;
                    kVar.kje = str3.replace("{" + str + "}", k.Z(str2, z));
                    return;
                }
                throw new AssertionError();
            }
            throw new IllegalArgumentException("Path parameter \"" + this.name + "\" value must not be null.");
        }
    }

    /* renamed from: retrofit2.i$i  reason: collision with other inner class name */
    static final class C0161i<T> extends i<T> {
        private final e<T, String> kiY;
        private final boolean kiZ;
        private final String name;

        C0161i(String str, e<T, String> eVar, boolean z) {
            this.name = (String) o.checkNotNull(str, "name == null");
            this.kiY = eVar;
            this.kiZ = z;
        }

        /* access modifiers changed from: package-private */
        public final void a(k kVar, @Nullable T t) throws IOException {
            String str;
            if (t != null && (str = (String) this.kiY.convert(t)) != null) {
                kVar.p(this.name, str, this.kiZ);
            }
        }
    }

    static final class k<T> extends i<T> {
        private final boolean kiZ;
        private final e<T, String> kjb;

        k(e<T, String> eVar, boolean z) {
            this.kjb = eVar;
            this.kiZ = z;
        }

        /* access modifiers changed from: package-private */
        public final void a(k kVar, @Nullable T t) throws IOException {
            if (t != null) {
                kVar.p((String) this.kjb.convert(t), (String) null, this.kiZ);
            }
        }
    }

    static final class j<T> extends i<Map<String, T>> {
        private final e<T, String> kiY;
        private final boolean kiZ;

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void a(k kVar, @Nullable Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String str2 = (String) this.kiY.convert(value);
                            if (str2 != null) {
                                kVar.p(str, str2, this.kiZ);
                            } else {
                                throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.kiY.getClass().getName() + " for key '" + str + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Query map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }

        j(e<T, String> eVar, boolean z) {
            this.kiY = eVar;
            this.kiZ = z;
        }
    }

    static final class e<T> extends i<Map<String, T>> {
        private final e<T, String> kiY;

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void a(k kVar, @Nullable Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            kVar.addHeader(str, (String) this.kiY.convert(value));
                        } else {
                            throw new IllegalArgumentException("Header map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Header map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }

        e(e<T, String> eVar) {
            this.kiY = eVar;
        }
    }

    static final class b<T> extends i<T> {
        private final e<T, String> kiY;
        private final boolean kiZ;
        private final String name;

        b(String str, e<T, String> eVar, boolean z) {
            this.name = (String) o.checkNotNull(str, "name == null");
            this.kiY = eVar;
            this.kiZ = z;
        }

        /* access modifiers changed from: package-private */
        public final void a(k kVar, @Nullable T t) throws IOException {
            String str;
            if (t != null && (str = (String) this.kiY.convert(t)) != null) {
                kVar.q(this.name, str, this.kiZ);
            }
        }
    }

    static final class c<T> extends i<Map<String, T>> {
        private final e<T, String> kiY;
        private final boolean kiZ;

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void a(k kVar, @Nullable Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String str2 = (String) this.kiY.convert(value);
                            if (str2 != null) {
                                kVar.q(str, str2, this.kiZ);
                            } else {
                                throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.kiY.getClass().getName() + " for key '" + str + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Field map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }

        c(e<T, String> eVar, boolean z) {
            this.kiY = eVar;
            this.kiZ = z;
        }
    }

    static final class f<T> extends i<T> {
        private final Headers headers;
        private final e<T, RequestBody> kiX;

        f(Headers headers2, e<T, RequestBody> eVar) {
            this.headers = headers2;
            this.kiX = eVar;
        }

        /* access modifiers changed from: package-private */
        public final void a(k kVar, @Nullable T t) {
            if (t != null) {
                try {
                    kVar.a(this.headers, (RequestBody) this.kiX.convert(t));
                } catch (IOException e) {
                    throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
                }
            }
        }
    }

    static final class l extends i<MultipartBody.Part> {
        static final l kjc = new l();

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void a(k kVar, @Nullable Object obj) throws IOException {
            MultipartBody.Part part = (MultipartBody.Part) obj;
            if (part != null) {
                kVar.kji.addPart(part);
            }
        }

        private l() {
        }
    }

    static final class g<T> extends i<Map<String, T>> {
        private final e<T, RequestBody> kiY;
        private final String kja;

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void a(k kVar, @Nullable Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            kVar.a(Headers.of("Content-Disposition", "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.kja), (RequestBody) this.kiY.convert(value));
                        } else {
                            throw new IllegalArgumentException("Part map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }

        g(e<T, RequestBody> eVar, String str) {
            this.kiY = eVar;
            this.kja = str;
        }
    }

    static final class a<T> extends i<T> {
        private final e<T, RequestBody> kiX;

        a(e<T, RequestBody> eVar) {
            this.kiX = eVar;
        }

        /* access modifiers changed from: package-private */
        public final void a(k kVar, @Nullable T t) {
            if (t != null) {
                try {
                    kVar.body = (RequestBody) this.kiX.convert(t);
                } catch (IOException e) {
                    throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }
}
    
