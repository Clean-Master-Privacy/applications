// IExternalRemoteConnectStateCallback.aidl
package com.cmcm.freevpn;

// Declare any non-default types here with import statements

oneway interface IExternalRemoteConnectStateCallback {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
        void onStateChange(int state, int oldState, String meta);
        void onTransferInfoUpdate();
}
