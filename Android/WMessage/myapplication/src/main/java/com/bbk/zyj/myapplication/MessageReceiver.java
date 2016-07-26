package com.bbk.zyj.myapplication;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("telephony","SMS received");
        //final android.telephony.SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
        String format = intent.getStringExtra("format");

        int pduCount = messages.length;
        SmsMessage[] msgs = new SmsMessage[pduCount];

        for (int i = 0; i < pduCount; i++) {
            byte[] pdu = (byte[]) messages[i];
//            SmsMessageBase wrappedMessage;
//
//            if (SmsConstants.FORMAT_3GPP2.equals(format)) {
//                wrappedMessage = com.android.internal.telephony.cdma.SmsMessage.createFromPdu(pdu);
//            } else if (SmsConstants.FORMAT_3GPP.equals(format)) {
//                wrappedMessage = com.android.internal.telephony.gsm.SmsMessage.createFromPdu(pdu);
//            } else {
//                Rlog.e(LOG_TAG, "createFromPdu(): unsupported message format " + format);
//                return null;
//            }
//
//            return new SmsMessage(wrappedMessage);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                msgs[i] = SmsMessage.createFromPdu(pdu, format);
            } else {
                msgs[i] = SmsMessage.createFromPdu(pdu);
            }
        }
        //String content = messages[0].getDisplayMessageBody();
        String content = msgs[0].getMessageBody();
//        DatabaseHelper database = new DatabaseHelper(context);
//        SQLiteDatabase db = database.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("content",content);
//        db.insert("content",null,cv);
//        Cursor c = db.query(content,null,null,null,null,null,null,null);
//        if (c.moveToFirst()){
//            Log.d("db",c.getString(c.getColumnIndex("content")));
//        }
//        db.close();
        Log.d("sms receive",content);
    }
}
