package com.bbk.zyj.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bbk.zyj.myapplication.database.MessageBaseHelper;
import com.bbk.zyj.myapplication.database.MessageDbSchema;
import com.bbk.zyj.myapplication.database.MessageDbSchema.MessageTable;

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
        Message message = new Message();
        message.setName("name");
        message.setNum("18463101652");
        message.setContent("content");
        message.setIcon(R.drawable.icon);
        message.setSend(true);
        mMessages.add(message);
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
