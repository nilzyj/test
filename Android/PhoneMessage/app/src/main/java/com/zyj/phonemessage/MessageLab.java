package com.zyj.phonemessage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zyj.phonemessage.database.MessageDbSchema.MessageTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 * Model
 * 初始化数据类
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

    /**
     * 构造函数，读取数据库中数据
     * @param context 上下文
     * @param db 数据库
     */
    private MessageLab(Context context, SQLiteDatabase db) {
        mContext = context.getApplicationContext();
        //创建list用于保存Message对象
        mMessages = new ArrayList<>();

        //初始化数据
        Cursor cursor = db.query("message", null, null, null, null, null, null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(MessageTable.Cols.NAME));
            String num = cursor.getString(cursor.getColumnIndex(MessageTable.Cols.NUM));
            String content = cursor.getString(cursor.getColumnIndex(MessageTable.Cols.CONTENT));
            int isSend = cursor.getInt(cursor.getColumnIndex(MessageTable.Cols.ISSEND));

            Message message = new Message();
            message.setName(name);
            message.setNum(num);
            message.setContent(content);
            message.setIcon(R.drawable.icon);
            message.setSend(isSend);
            if (name == null) {
                noNameRepeatMessage(mMessages, num);
            } else {
                hasNameRepeatMessage(mMessages, name);
            }
            mMessages.add(message);
        }
        db.close();
    }

    public void addMessage(Message m) {
        mMessages.add(m);
    }

    public List<Message> getMessages() {
        return  mMessages;
    }

    /**
     * 返回指定姓名的message
     * @param name 指定姓名
     * @return message
     */
    public Message getMessage(String name) {
        for (Message message : mMessages) {
            if (message.getName().equals(name)) {
                return message;
            }
        }
        return null;
    }

    private void noNameRepeatMessage(List<Message> mMessages, String num) {
        for (int i = 0; i < mMessages.size(); i++) {
            if (mMessages.get(i).getNum().equals(num)) {
                mMessages.remove(mMessages.get(i));
            }
        }
    }

    private void hasNameRepeatMessage(List<Message> mMessages, String name) {
        for (int i = 0; i < mMessages.size(); i++) {
            if (mMessages.get(i).getName().equals(name)) {
                mMessages.remove(mMessages.get(i));
            }
        }
    }
}
