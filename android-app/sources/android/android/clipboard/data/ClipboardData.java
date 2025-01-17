package android.android.clipboard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public abstract class ClipboardData
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<android.sec.clipboard.data.ClipboardData> CREATOR = new Parcelable.Creator() {};
  private static final long serialVersionUID = 1L;
  protected int mFormatID;
  private boolean mIsProtected = false;
  
  public ClipboardData(int paramInt)
  {
    mFormatID = paramInt;
  }
  
  protected ClipboardData(Parcel paramParcel) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public abstract void readFormSource(Parcel paramParcel);
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mFormatID);
  }
}
