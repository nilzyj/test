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

    /**
     * 获得MessageLab实例
     * @param context 上下文
     * @param db 数据库
     * @return MessageLab实例
     */
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
        //每次从数据库中读取一条消息，查看消息列表中是否已存在相同联系人的消息，有则移除。
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
            handleRepeatMessage(mMessages, num);
            mMessages.add(message);
        }
        db.close();
    }

    /**
     * 添加Message对象
     * @param m message
     */
    public void addMesgesa(Message m) {
        mMessages.add(m);
    }

    /**
     * 返回从数据库中获得的消息
     * @return messages
     */
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

    /**
     * 获得每一个联系人的最新一条消息
     * @param mMessages 所有的消息
     * @param num 号码
     */
    private void handleRepeatMessage(List<Message> mMessages, String num) {
        for (int i = 0; i < mMessages.size(); i++) {
            if (mMessages.get(i).getNum().equals(num)) {
                mMessages.remove(mMessages.get(i));
            }
        }
    }
}
