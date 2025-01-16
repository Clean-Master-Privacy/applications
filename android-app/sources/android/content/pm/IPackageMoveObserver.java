package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPackageMoveObserver extends IInterface {
    void packageMoved(String str, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IPackageMoveObserver {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.content.pm.IPackageMoveObserver");
        }

        public static IPackageMoveObserver b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.content.pm.IPackageMoveObserver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPackageMoveObserver)) {
                return new a(iBinder);
            }
            return (IPackageMoveObserver) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.content.pm.IPackageMoveObserver");
                packageMoved(parcel.readString(), parcel.readInt());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.content.pm.IPackageMoveObserver");
                return true;
            }
        }

        private static class a implements IPackageMoveObserver {
            private IBinder aW;

            a(IBinder iBinder) {
                this.aW = iBinder;
            }

            public final IBinder asBinder() {
                return this.aW;
            }

            public final void packageMoved(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.content.pm.IPackageMoveObserver");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.aW.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
