    package client.core.model;

public class c {
    public String js = "";
    protected String jt = "";
    public g ju = null;

    public final boolean bk(String str) {
        return this.js.equals(str);
    }

    public String toString() {
        return String.format("(%s :desc '%s' :from '%s' %s)", new Object[]{getClass().getSimpleName() + "@" + hashCode(), this.jt, this.js, this.ju});
    }
}
    
