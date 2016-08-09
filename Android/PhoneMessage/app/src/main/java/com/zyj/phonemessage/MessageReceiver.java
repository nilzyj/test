package com.zyj.phonemessage;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.telephony.SmsMessage;

import com.zyj.phonemessage.database.MessageBaseHelper;

import static com.zyj.phonemessage.database.MessageDbSchema.*;

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
        String num = msgs[0].getOriginatingAddress();

        saveReceiveToDb(context, num, content);

        //发送通知
        MessageNotification notification = new MessageNotification();
        notification.sendNotification(context, num, content);

    }

    //保存收到的信息

    /**
     * 保存接收到的短信
     * @param context 上下文
     * @param num 号码
     * @param content 内容
     */
    private void saveReceiveToDb(Context context, String num, String content) {
        String name = null;
        MessageBaseHelper helper = new MessageBaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MessageTable.Cols.NUM, num);
        cv.put(MessageTable.Cols.CONTENT, content);
        Cursor c = db.query(MessageTable.TABLENAME, null, "num=?", new String[]{num}, null, null,null);
        if (c.moveToFirst()) {
            name = c.getString(c.getColumnIndex(MessageTable.Cols.NAME));
        }
        cv.put(MessageTable.Cols.NAME, name);
        cv.put(MessageTable.Cols.ISSEND, 0);
        db.insert(MessageTable.TABLENAME, null, cv);
        db.close();
    }
}
