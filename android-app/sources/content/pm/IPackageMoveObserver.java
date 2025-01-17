package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPackageMoveObserver
  extends IInterface
{
  public abstract void packageMoved(String paramString, int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IPackageMoveObserver
  {
    public Stub()
    {
      attachInterface(this, "android.content.pm.IPackageMoveObserver");
    }
    
    public static IPackageMoveObserver asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.content.pm.IPackageMoveObserver");
      if ((localIInterface != null) && ((localIInterface instanceof IPackageMoveObserver))) {
        return (IPackageMoveObserver)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("android.content.pm.IPackageMoveObserver");
        return true;
      }
      paramParcel1.enforceInterface("android.content.pm.IPackageMoveObserver");
      packageMoved(paramParcel1.readString(), paramParcel1.readInt());
      return true;
    }
    
    private static final class a
      implements IPackageMoveObserver
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return mRemote;
      }
      
      public final void packageMoved(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.content.pm.IPackageMoveObserver");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          mRemote.transact(1, localParcel, null, 1);
          localParcel.recycle();
          return;
        }
        catch (Throwable paramString)
        {
          localParcel.recycle();
          throw paramString;
        }
      }
    }
  }
}
