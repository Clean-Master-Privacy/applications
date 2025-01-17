package android.android.clipboard.data.list;

import android.android.clipboard.data.ClipboardData;
import android.os.Parcel;

public class ClipboardDataBitmap
  extends ClipboardData
{
  private static final long serialVersionUID = 1L;
  private String mExtraDataPath = "";
  private String mInitBaseValue = "";
  private boolean mInitBaseValueCheck = true;
  private String mValue = "";
  private String mValueUrl = "";
  
  public ClipboardDataBitmap(int paramInt)
  {
    super(3);
  }
  
  protected void readFormSource(Parcel paramParcel)
  {
    mValue = ((String)paramParcel.readValue(String.class.getClassLoader()));
    mInitBaseValue = ((String)paramParcel.readValue(String.class.getClassLoader()));
    mValueUrl = ((String)paramParcel.readValue(String.class.getClassLoader()));
    mExtraDataPath = ((String)paramParcel.readValue(String.class.getClassLoader()));
  }
}
