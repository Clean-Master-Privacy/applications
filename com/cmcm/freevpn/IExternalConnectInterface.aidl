// IExternalConnectInterface.aidl
package com.cmcm.freevpn;

// Declare any non-default types here with import statements
import com.cmcm.freevpn.IExternalRemoteConnectStateCallback;

interface IExternalConnectInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int getConnState();
    void registerStatusCallback(IExternalRemoteConnectStateCallback cb);
    void unregisterStatusCallback(IExternalRemoteConnectStateCallback cb);
}
