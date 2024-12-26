// ISSNotificationClean.aidl
package com.cmcm.locker.sdk.logic.service;
import android.service.notification.StatusBarNotification;

interface ISSNotificationClean {

    void cancleSSNotification(in StatusBarNotification sbn);
}
