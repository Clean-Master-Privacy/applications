// ILockerNotificationListener.aidl
package com.cmcm.locker.sdk.logic.service;

// Declare any non-default types here with import statements
import android.service.notification.StatusBarNotification;
import android.view.accessibility.AccessibilityEvent;
import com.cmcm.locker.sdk.logic.service.ISSNotificationClean;

interface ILockerNotificationListener {

    void onNotificationPosted(in StatusBarNotification sbn);
    void onNotificationRemoved(in StatusBarNotification sbn);
    void onNotificationPostedByAccessibilityService(in AccessibilityEvent event);
    void setSSNotificationCleanListener(ISSNotificationClean cleaner);

}
