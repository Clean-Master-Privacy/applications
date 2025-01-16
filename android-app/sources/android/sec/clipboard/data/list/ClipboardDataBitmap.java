package android.sec.clipboard.data.list;

import android.os.Parcel;
import android.sec.clipboard.data.ClipboardData;

public class ClipboardDataBitmap extends ClipboardData {
    private static final long serialVersionUID = 1;
    private String mExtraDataPath = "";
    private String mInitBaseValue = "";
    private boolean mInitBaseValueCheck = true;
    private String mValue = "";
    private String mValueUrl = "";

    public ClipboardDataBitmap(int i) {
        super(3);
    }

    /* access modifiers changed from: protected */
    public void readFormSource(Parcel parcel) {
        this.mValue = (String) parcel.readValue(String.class.getClassLoader());
        this.mInitBaseValue = (String) parcel.readValue(String.class.getClassLoader());
        this.mValueUrl = (String) parcel.readValue(String.class.getClassLoader());
        this.mExtraDataPath = (String) parcel.readValue(String.class.getClassLoader());
    }
}
