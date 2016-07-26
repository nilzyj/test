package com.zyj.phonemessage;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.SmsMessage;
import android.util.Log;


/**
 * Created by Administrator on 2016/7/26.
 */
public class MessageReceiver extends BroadcastReceiver {
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("telephony","SMS received");
//        final android.telephony.SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
        String format = intent.getStringExtra("format");

        int pduCount = messages.length;
        SmsMessage[] msgs = new SmsMessage[pduCount];

        for (int i = 0; i < pduCount; i++) {
            byte[] pdu = (byte[]) messages[i];
            msgs[i] = SmsMessage.createFromPdu(pdu, format);
        }
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
        Log.i("sms receive",content);
    }
}
