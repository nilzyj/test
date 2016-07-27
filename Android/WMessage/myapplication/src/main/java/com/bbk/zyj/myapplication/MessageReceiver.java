package com.bbk.zyj.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.SmsMessage;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
        String format = intent.getStringExtra("format");

        int pduCount = messages.length;
        SmsMessage[] msgs = new SmsMessage[pduCount];

        for (int i = 0; i < pduCount; i++) {
            byte[] pdu = (byte[]) messages[i];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                msgs[i] = SmsMessage.createFromPdu(pdu, format);
            } else {
                msgs[i] = SmsMessage.createFromPdu(pdu);
            }
        }
        String content = msgs[0].getMessageBody();
    }
}
