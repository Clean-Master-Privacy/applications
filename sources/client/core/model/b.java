    package client.core.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public abstract class b<T> extends Thread implements e<T> {
    protected BlockingQueue<T> jp = null;
    protected ExecutorService jq = null;
    private volatile boolean jr = false;

    public c m(T t) {
        return null;
    }

    public void run() {
        while (true) {
            boolean z = this.jr;
            try {
                this.jq.submit(new a(this.jp.take(), this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void n(T t) {
        this.jp.add(t);
    }
}
    
