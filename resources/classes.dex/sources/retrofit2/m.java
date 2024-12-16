    package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.a;
import retrofit2.b.b;
import retrofit2.b.e;
import retrofit2.b.f;
import retrofit2.b.g;
import retrofit2.b.h;
import retrofit2.b.k;
import retrofit2.b.l;
import retrofit2.b.o;
import retrofit2.b.p;
import retrofit2.n;

public final class m {
    final List<c$a> adapterFactories;
    final HttpUrl baseUrl;
    final Call.Factory callFactory;
    @Nullable
    final Executor callbackExecutor;
    final List<e$a> converterFactories;
    private final Map<Method, n<?, ?>> serviceMethodCache = new ConcurrentHashMap();
    final boolean validateEagerly;

    m(Call.Factory factory, HttpUrl httpUrl, List<e$a> list, List<c$a> list2, @Nullable Executor executor) {
        this.callFactory = factory;
        this.baseUrl = httpUrl;
        this.converterFactories = Collections.unmodifiableList(list);
        this.adapterFactories = Collections.unmodifiableList(list2);
        this.callbackExecutor = executor;
        this.validateEagerly = false;
    }

    public final <T> T y(final Class<T> cls) {
        o.A(cls);
        if (this.validateEagerly) {
            j bYK = j.bYK();
            for (Method method : cls.getDeclaredMethods()) {
                if (!bYK.c(method)) {
                    d(method);
                }
            }
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            private final j kjm = j.bYK();

            public final Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.kjm.c(method)) {
                    return this.kjm.a(method, cls, obj, objArr);
                }
                n<?, ?> d = m.this.d(method);
                return d.kjr.a(new h(d, objArr));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final n<?, ?> d(Method method) {
        n<?, ?> nVar;
        n<?, ?> nVar2 = (n) this.serviceMethodCache.get(method);
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (this.serviceMethodCache) {
            nVar = (n) this.serviceMethodCache.get(method);
            if (nVar == null) {
                n.a aVar = new n.a(this, method);
                aVar.kjr = aVar.bYO();
                aVar.kjB = aVar.kjr.bYF();
                if (aVar.kjB == l.class || aVar.kjB == Response.class) {
                    throw aVar.b((Throwable) null, "'" + o.getRawType(aVar.kjB).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
                }
                aVar.kjs = aVar.bYP();
                for (Annotation annotation : aVar.kjy) {
                    if (annotation instanceof b) {
                        aVar.r("DELETE", ((b) annotation).value(), false);
                    } else if (annotation instanceof f) {
                        aVar.r("GET", ((f) annotation).value(), false);
                    } else if (annotation instanceof g) {
                        aVar.r("HEAD", ((g) annotation).value(), false);
                        if (!Void.class.equals(aVar.kjB)) {
                            throw aVar.b((Throwable) null, "HEAD method must use Void as response type.", new Object[0]);
                        }
                    } else if (annotation instanceof retrofit2.b.n) {
                        aVar.r("PATCH", ((retrofit2.b.n) annotation).value(), true);
                    } else if (annotation instanceof o) {
                        aVar.r("POST", ((o) annotation).value(), true);
                    } else if (annotation instanceof p) {
                        aVar.r("PUT", ((p) annotation).value(), true);
                    } else if (annotation instanceof retrofit2.b.m) {
                        aVar.r("OPTIONS", ((retrofit2.b.m) annotation).value(), false);
                    } else if (annotation instanceof h) {
                        h hVar = (h) annotation;
                        aVar.r(hVar.method(), hVar.path(), hVar.bYS());
                    } else if (annotation instanceof k) {
                        String[] value = ((k) annotation).value();
                        if (value.length != 0) {
                            aVar.headers = aVar.y(value);
                        } else {
                            throw aVar.b((Throwable) null, "@Headers annotation is empty.", new Object[0]);
                        }
                    } else if (annotation instanceof l) {
                        if (!aVar.kju) {
                            aVar.kjv = true;
                        } else {
                            throw aVar.b((Throwable) null, "Only one encoding annotation is allowed.", new Object[0]);
                        }
                    } else if (!(annotation instanceof e)) {
                        continue;
                    } else if (!aVar.kjv) {
                        aVar.kju = true;
                    } else {
                        throw aVar.b((Throwable) null, "Only one encoding annotation is allowed.", new Object[0]);
                    }
                }
                if (aVar.kjt != null) {
                    if (!aVar.kjh) {
                        if (aVar.kjv) {
                            throw aVar.b((Throwable) null, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        } else if (aVar.kju) {
                            throw aVar.b((Throwable) null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    }
                    int length = aVar.kjz.length;
                    aVar.kjw = new i[length];
                    int i = 0;
                    while (i < length) {
                        Type type = aVar.kjA[i];
                        if (!o.d(type)) {
                            Annotation[] annotationArr = aVar.kjz[i];
                            if (annotationArr != null) {
                                aVar.kjw[i] = aVar.a(i, type, annotationArr);
                                i++;
                            } else {
                                throw aVar.a(i, "No Retrofit annotation found.", new Object[0]);
                            }
                        } else {
                            throw aVar.a(i, "Parameter type must not include a type variable or wildcard: %s", new Object[]{type});
                        }
                    }
                    if (aVar.kje == null) {
                        if (!aVar.kjH) {
                            throw aVar.b((Throwable) null, "Missing either @%s URL or @Url parameter.", new Object[]{aVar.kjt});
                        }
                    }
                    if (!aVar.kju && !aVar.kjv && !aVar.kjh) {
                        if (aVar.kjE) {
                            throw aVar.b((Throwable) null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                        }
                    }
                    if (aVar.kju) {
                        if (!aVar.kjC) {
                            throw aVar.b((Throwable) null, "Form-encoded method must contain at least one @Field.", new Object[0]);
                        }
                    }
                    if (aVar.kjv) {
                        if (!aVar.kjD) {
                            throw aVar.b((Throwable) null, "Multipart method must contain at least one @Part.", new Object[0]);
                        }
                    }
                    n<?, ?> nVar3 = new n<>(aVar);
                    this.serviceMethodCache.put(method, nVar3);
                    nVar = nVar3;
                } else {
                    throw aVar.b((Throwable) null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
                }
            }
        }
        return nVar;
    }

    public final <T> e<T, String> b(Type type, Annotation[] annotationArr) {
        o.checkNotNull(type, "type == null");
        o.checkNotNull(annotationArr, "annotations == null");
        int size = this.converterFactories.size();
        for (int i = 0; i < size; i++) {
            this.converterFactories.get(i);
        }
        return a.d.kiF;
    }

    public static final class a {
        private final List<c$a> adapterFactories;
        private HttpUrl baseUrl;
        @Nullable
        private Call.Factory callFactory;
        private final List<e$a> converterFactories;
        private final j kjm;

        private a(j jVar) {
            this.converterFactories = new ArrayList();
            this.adapterFactories = new ArrayList();
            this.kjm = jVar;
            this.converterFactories.add(new a());
        }

        public a() {
            this(j.bYK());
        }

        public final a b(OkHttpClient okHttpClient) {
            this.callFactory = (Call.Factory) o.checkNotNull((Call.Factory) o.checkNotNull(okHttpClient, "client == null"), "factory == null");
            return this;
        }

        public final a Ha(String str) {
            o.checkNotNull(str, "baseUrl == null");
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                o.checkNotNull(parse, "baseUrl == null");
                List<String> pathSegments = parse.pathSegments();
                if ("".equals(pathSegments.get(pathSegments.size() - 1))) {
                    this.baseUrl = parse;
                    return this;
                }
                throw new IllegalArgumentException("baseUrl must end in /: " + parse);
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public final a a(e$a e_a) {
            this.converterFactories.add(o.checkNotNull(e_a, "factory == null"));
            return this;
        }

        public final m bYN() {
            if (this.baseUrl != null) {
                Call.Factory factory = this.callFactory;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Call.Factory factory2 = factory;
                Executor bYM = this.kjm.bYM();
                ArrayList arrayList = new ArrayList(this.adapterFactories);
                arrayList.add(this.kjm.c(bYM));
                return new m(factory2, this.baseUrl, new ArrayList(this.converterFactories), arrayList, bYM);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    public final <T> e<T, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        o.checkNotNull(type, "type == null");
        o.checkNotNull(annotationArr, "parameterAnnotations == null");
        o.checkNotNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.converterFactories.indexOf((Object) null) + 1;
        int size = this.converterFactories.size();
        for (int i = indexOf; i < size; i++) {
            e<?, RequestBody> b2 = this.converterFactories.get(i).b(type);
            if (b2 != null) {
                return b2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.converterFactories.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
    
