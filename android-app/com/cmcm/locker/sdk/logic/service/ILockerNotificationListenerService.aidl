// ILockerNotificationListenerService.aidl
package com.cmcm.locker.sdk.logic.service;

import com.cmcm.locker.sdk.logic.service.ILockerNotificationListener;

// Declare any non-default types here with import statements

interface ILockerNotificationListenerService {

    void setListener(in ILockerNotificationListener listener);
}
