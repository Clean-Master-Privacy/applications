package com.securitymaster.base.syncipc.aidl;

import ks.cm.antivirus.notification.sharedata.NotificationData;

interface INotifySenderServiceRaw {

       void cancelAllNotificationItem();

       boolean checkExist(int notifyID);

       void AddToCancelListByType(int priorityType , int cancelType);

       boolean AddNotifyList(int priorityType , int notifyId , boolean isForce);

       void removeNotificationItem(int notifyId);

       // 436 screen saver 新加
       void addSSNotificationItem(in NotificationData notificationData);

       void removeSSNotificationItem(int notifyId);

}
