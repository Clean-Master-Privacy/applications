    package retrofit2;

import javax.annotation.Nullable;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class l<T> {
    @Nullable
    public final T body;
    public final Response kjl;

    public static <T> l<T> a(@Nullable T t, Response response) {
        o.checkNotNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new l<>(response, t);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> l<T> a(ResponseBody responseBody, Response response) {
        o.checkNotNull(responseBody, "body == null");
        o.checkNotNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new l<>(response, (Object) null);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private l(Response response, @Nullable T t) {
        this.kjl = response;
        this.body = t;
    }

    @Nullable
    public final T body() {
        return this.body;
    }

    public final String toString() {
        return this.kjl.toString();
    }
}
    
