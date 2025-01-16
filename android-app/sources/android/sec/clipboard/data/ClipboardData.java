package android.sec.clipboard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.sec.clipboard.data.list.ClipboardDataBitmap;
import java.io.Serializable;

public abstract class ClipboardData implements Parcelable, Serializable {
    public static final Parcelable.Creator<ClipboardData> CREATOR = new Parcelable.Creator<ClipboardData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ClipboardData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ClipboardDataBitmap clipboardDataBitmap = new ClipboardDataBitmap(parcel.readInt());
            clipboardDataBitmap.readFormSource(parcel);
            return clipboardDataBitmap;
        }
    };
    private static final long serialVersionUID = 1;
    protected int mFormatID;
    private boolean mIsProtected = false;

    public int describeContents() {
        return 0;
    }

    public abstract void readFormSource(Parcel parcel);

    public ClipboardData(int i) {
        this.mFormatID = i;
    }

    protected ClipboardData(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mFormatID);
    }
}
