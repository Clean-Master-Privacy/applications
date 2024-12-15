    package client.core.model;

import java.util.ArrayList;
import java.util.Iterator;

public final class g {
    public ArrayList<String> jx;

    public g() {
        this("lg://default");
    }

    public g(String str) {
        this.jx = new ArrayList<>();
        this.jx.add(str);
    }

    public final synchronized void bl(String str) {
        if (!this.jx.contains(str) && !bD()) {
            this.jx.add(str);
        }
    }

    public final synchronized boolean bD() {
        return this.jx.contains("lg://*");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.jx.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(" ");
        }
        return String.format("(:to %s)", new Object[]{sb.toString()});
    }
}
    
