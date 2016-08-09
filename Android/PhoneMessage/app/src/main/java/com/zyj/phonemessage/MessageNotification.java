package com.zyj.phonemessage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/8/5.
 */
public class MessageNotification {

    private NotificationManager mNotificationManager;
    private int mNotificationId;

    /**
     * 发送通知
     * @param context 上下文
     * @param name 姓名
     * @param content 短信内容
     */
    public void sendNotification(Context context, String name, String content) {
        Intent intent = new Intent(context, MessageSend.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("Message");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentText(content);
        builder.setContentTitle(name);
        builder.setContentIntent(pendingIntent);
        builder.setDefaults(Notification.DEFAULT_ALL);
        Notification notification = builder.build();
        mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mNotificationId, notification);
    }
}
