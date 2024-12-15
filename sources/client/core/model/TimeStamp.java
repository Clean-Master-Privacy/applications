    package client.core.model;

import java.util.ArrayList;
import java.util.Locale;

public final class TimeStamp {
    private ArrayList<Object> jA;
    long mEndTime;
    private String mId;
    long mStartTime;

    public enum Tag {
        START_TIME,
        END_TIME
    }

    public TimeStamp(String str) {
        this();
        this.mId = str;
    }

    public TimeStamp() {
        this.mStartTime = 0;
        this.mEndTime = 0;
        this.mId = "TRACER";
        this.jA = new ArrayList<>();
        bE();
    }

    public final void a(Tag tag) {
        switch (tag) {
            case START_TIME:
                this.mStartTime = System.currentTimeMillis();
                return;
            case END_TIME:
                this.mEndTime = System.currentTimeMillis();
                return;
            default:
                return;
        }
    }

    public final TimeStamp bE() {
        this.jA = new ArrayList<>();
        a(Tag.START_TIME);
        return this;
    }

    public final String bF() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("[ ");
        sb2.append(this.mId);
        sb2.append(" ] : ");
        a(Tag.END_TIME);
        sb2.append((int) (this.mEndTime - this.mStartTime));
        sb2.append("(ms)");
        sb.append(sb2.toString());
        sb.append("\n");
        long j = this.mStartTime;
        int i = 0;
        while (i < this.jA.size()) {
            this.jA.get(i);
            sb.append("  + " + String.format(Locale.US, "[ %5d ] : %-10s", new Object[]{Long.valueOf(0 - j), null}));
            sb.append("\n");
            i++;
            j = 0;
        }
        return sb.toString();
    }
}
    
