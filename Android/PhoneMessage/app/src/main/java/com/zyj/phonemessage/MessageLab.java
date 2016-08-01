package com.zyj.phonemessage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zyj.phonemessage.database.MessageDbSchema.MessageTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class MessageLab {

    private static MessageLab sMessageLab;

    private List<Message> mMessages;
    private Context mContext;

    public static MessageLab get(Context context, SQLiteDatabase db) {
        if (sMessageLab == null) {
            sMessageLab = new MessageLab(context, db);
        }
        return sMessageLab;
    }

    private MessageLab(Context context, SQLiteDatabase db) {
        mContext = context.getApplicationContext();
        //创建list用于保存Message对象
        mMessages = new ArrayList<>();

        //初始化数据
        Cursor cursor = db.query("message", null, null, null, null, null, null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            Message message = new Message();
            message.setName(cursor.getString(cursor.getColumnIndex(MessageTable.Cols.NAME)));
            message.setNum(cursor.getString(cursor.getColumnIndex(MessageTable.Cols.NUM)));
            message.setContent(cursor.getString(cursor.getColumnIndex(MessageTable.Cols.CONTENT)));
            message.setIcon(R.drawable.icon);
            message.setSend(true);
            mMessages.add(message);
        }
        Message message1 = new Message();
        message1.setName("name");
        message1.setNum("18463101652");
        message1.setContent("content");
        message1.setSend(true);
        message1.setIcon(R.drawable.icon);
        mMessages.add(message1);
        Message message2 = new Message();
        message2.setName("name1");
        message2.setNum("18463101652");
        message2.setContent("content1");
        message2.setSend(false);
        message2.setIcon(R.drawable.icon);
        mMessages.add(message2);
    }

    public void addMessage(Message m) {
        mMessages.add(m);
    }

    public List<Message> getMessages() {
        return  mMessages;
    }

    //返回指定姓名的message
    public Message getMessage(String name) {
        for (Message message : mMessages) {
            if (message.getName().equals(name)) {
                return message;
            }
        }
        return null;
    }
}
