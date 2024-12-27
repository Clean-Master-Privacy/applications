// IScreenSaverNotificationManager.aidl
package ks.cm.antivirus.notification.sharedata;
import ks.cm.antivirus.notification.sharedata.IFeedNotificationCallback;

// Declare any non-default types here with import statements

interface IScreenSaverNotificationManager {

       void getNotificationItem();

       void cancel(int notifyId);

       void register(IFeedNotificationCallback cb);

       void unRegister();

}
