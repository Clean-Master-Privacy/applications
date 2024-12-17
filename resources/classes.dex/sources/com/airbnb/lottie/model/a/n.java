    package com.airbnb.lottie.model.a;

import com.airbnb.lottie.e.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class n<V, O> implements m<V, O> {
    final List<a<V>> ny;

    n(V v) {
        this(Collections.singletonList(new a(v)));
    }

    n(List<a<V>> list) {
        this.ny = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.ny.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.ny.toArray()));
        }
        return sb.toString();
    }
}
    
