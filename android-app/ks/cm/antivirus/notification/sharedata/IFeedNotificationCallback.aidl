// IFeedNotificationCallback.aidl
package ks.cm.antivirus.notification.sharedata;

import ks.cm.antivirus.notification.sharedata.NotificationData;
// Declare any non-default types here with import statements

interface IFeedNotificationCallback {
     void deleteNotification(int id);
     void updateNotification(in NotificationData data);
}
