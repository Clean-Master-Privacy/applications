    package okhttp3;

import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.c;
import okio.d;

public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    public final String name(int i) {
        return HttpUrl.percentDecode(encodedName(i), true);
    }

    public final String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    public final String value(int i) {
        return HttpUrl.percentDecode(encodedValue(i), true);
    }

    public final MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final long contentLength() {
        return writeOrCountBytes((d) null, true);
    }

    public final void writeTo(d dVar) throws IOException {
        writeOrCountBytes(dVar, false);
    }

    private long writeOrCountBytes(@Nullable d dVar, boolean z) {
        c cVar;
        if (z) {
            cVar = new c();
        } else {
            cVar = dVar.bYi();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                cVar.Nu(38);
            }
            cVar.GY(this.encodedNames.get(i));
            cVar.Nu(61);
            cVar.GY(this.encodedValues.get(i));
        }
        if (!z) {
            return 0;
        }
        long j = cVar.size;
        cVar.clear();
        return j;
    }
}
    
