package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPackageDataObserver extends IInterface {
    void onRemoveCompleted(String str, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IPackageDataObserver {
        private static final String DESCRIPTOR = "android.content.pm.IPackageDataObserver";
        static final int TRANSACTION_onRemoveCompleted = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPackageDataObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPackageDataObserver)) {
                return new a(iBinder);
            }
            return (IPackageDataObserver) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onRemoveCompleted(parcel.readString(), parcel.readInt() != 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class a implements IPackageDataObserver {
            private IBinder aW;

            a(IBinder iBinder) {
                this.aW = iBinder;
            }

            public final IBinder asBinder() {
                return this.aW;
            }

            public final void onRemoveCompleted(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.aW.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
