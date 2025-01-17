package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = aVar.readInt(iconCompat.mType, 1);
        iconCompat.mData = aVar.d(iconCompat.mData);
        iconCompat.Cg = aVar.a(iconCompat.Cg, 3);
        iconCompat.Ch = aVar.readInt(iconCompat.Ch, 4);
        iconCompat.Ci = aVar.readInt(iconCompat.Ci, 5);
        iconCompat.mTintList = (ColorStateList) aVar.a(iconCompat.mTintList, 6);
        iconCompat.Cj = aVar.C(iconCompat.Cj);
        iconCompat.mTintMode = PorterDuff.Mode.valueOf(iconCompat.Cj);
        int i = iconCompat.mType;
        if (i != -1) {
            switch (i) {
                case 1:
                case 5:
                    if (iconCompat.Cg == null) {
                        iconCompat.Cf = iconCompat.mData;
                        iconCompat.mType = 3;
                        iconCompat.Ch = 0;
                        iconCompat.Ci = iconCompat.mData.length;
                        break;
                    } else {
                        iconCompat.Cf = iconCompat.Cg;
                        break;
                    }
                case 2:
                case 4:
                    iconCompat.Cf = new String(iconCompat.mData, Charset.forName("UTF-16"));
                    break;
                case 3:
                    iconCompat.Cf = iconCompat.mData;
                    break;
            }
        } else if (iconCompat.Cg != null) {
            iconCompat.Cf = iconCompat.Cg;
        } else {
            throw new IllegalArgumentException("Invalid icon");
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        iconCompat.Cj = iconCompat.mTintMode.name();
        int i = iconCompat.mType;
        if (i != -1) {
            switch (i) {
                case 1:
                case 5:
                    iconCompat.Cg = (Parcelable) iconCompat.Cf;
                    break;
                case 2:
                    iconCompat.mData = ((String) iconCompat.Cf).getBytes(Charset.forName("UTF-16"));
                    break;
                case 3:
                    iconCompat.mData = (byte[]) iconCompat.Cf;
                    break;
                case 4:
                    iconCompat.mData = iconCompat.Cf.toString().getBytes(Charset.forName("UTF-16"));
                    break;
            }
        } else {
            iconCompat.Cg = (Parcelable) iconCompat.Cf;
        }
        aVar.B(iconCompat.mType, 1);
        aVar.c(iconCompat.mData);
        aVar.writeParcelable(iconCompat.Cg, 3);
        aVar.B(iconCompat.Ch, 4);
        aVar.B(iconCompat.Ci, 5);
        aVar.writeParcelable(iconCompat.mTintList, 6);
        aVar.B(iconCompat.Cj);
    }
}
