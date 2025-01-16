package android.sec.clipboard;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.sec.clipboard.data.ClipboardData;

public interface IClipboardFormatListener extends IInterface {
    void a(int i, ClipboardData clipboardData) throws RemoteException;

    public static abstract class Stub extends Binder implements IClipboardFormatListener {
        public Stub() {
            attachInterface(this, "android.sec.clipboard.IClipboardFormatListener");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.sec.clipboard.IClipboardFormatListener");
                a(parcel.readInt(), parcel.readInt() != 0 ? ClipboardData.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.sec.clipboard.IClipboardFormatListener");
                return true;
            }
        }

        private static class Proxy implements IClipboardFormatListener {
            public IBinder asBinder() {
                return null;
            }

            public final void a(int i, ClipboardData clipboardData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.sec.clipboard.IClipboardFormatListener");
                    obtain.writeInt(i);
                    if (clipboardData != null) {
                        obtain.writeInt(1);
                        clipboardData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    iBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
