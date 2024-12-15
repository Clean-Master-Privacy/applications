    package client.core.model;

import client.core.model.TimeStamp;
import com.appsflyer.share.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class h implements Comparable<h>, Callable<c> {
    private static AtomicInteger jy = new AtomicInteger(0);
    private String jt = "";
    public g ju = new g();
    private TimeStamp jz = new TimeStamp();
    private String mId = "";
    private int mUid = hashCode();
    private int mWeight = jy.getAndIncrement();

    public c bC() {
        return null;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        if (this.mWeight > hVar.mWeight) {
            return 1;
        }
        return this.mWeight == hVar.mWeight ? 0 : -1;
    }

    public String toString() {
        TimeStamp timeStamp = this.jz;
        timeStamp.a(TimeStamp.Tag.END_TIME);
        double d2 = (double) (timeStamp.mEndTime - timeStamp.mStartTime);
        Double.isNaN(d2);
        return String.format("(%s (:desc %s) (:weight %d) (:sec %f))", new Object[]{getClass().getSimpleName() + "@" + hashCode() + Constants.URL_PATH_DELIMITER + this.mId, this.jt, Integer.valueOf(this.mWeight), Double.valueOf(d2 / 1000.0d)});
    }

    public /* synthetic */ Object call() throws Exception {
        this.jz.a(TimeStamp.Tag.START_TIME);
        c bC = bC();
        if (!(this.ju == null || bC == null)) {
            bC.js = String.valueOf(this.mUid);
            bC.ju = this.ju;
        }
        this.jz.a(TimeStamp.Tag.END_TIME);
        return bC;
    }
}
    
