    package client.core;

import client.core.model.c;
import client.core.model.h;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

public final class e {
    private static e jg = new e();
    private BlockingQueue<h> jh = new LinkedBlockingQueue(b.iW);
    private BlockingQueue<FutureTask<c>> ji = new LinkedBlockingQueue();
    b jj = new b(this.jh);
    a jk = new a(this.ji);
    /* access modifiers changed from: private */
    public ExecutorService jl = Executors.newFixedThreadPool(b.iV);

    class b extends client.core.model.b<h> {
        public final /* synthetic */ c m(Object obj) {
            FutureTask futureTask = new FutureTask((h) obj);
            e.this.jk.n(futureTask);
            e.this.jl.submit(futureTask);
            return null;
        }

        public b(BlockingQueue<h> blockingQueue) {
            this.jp = blockingQueue;
            this.jq = Executors.newFixedThreadPool(b.iU);
            setName("TaskDispather");
        }
    }

    static class a extends client.core.model.b<FutureTask<c>> {
        public final /* synthetic */ c m(Object obj) {
            return b((FutureTask) obj);
        }

        public a(BlockingQueue<FutureTask<c>> blockingQueue) {
            this.jp = blockingQueue;
            this.jq = Executors.newFixedThreadPool(1);
            setName("PendingEventDispatcher");
        }

        private static c b(FutureTask<c> futureTask) {
            try {
                c.bA().a(futureTask.get());
                return null;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                return null;
            } catch (ExecutionException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    private e() {
        this.jj.start();
        this.jk.start();
    }

    public static e bB() {
        return jg;
    }
}
    
