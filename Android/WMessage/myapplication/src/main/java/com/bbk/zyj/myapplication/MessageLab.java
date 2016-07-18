package com.bbk.zyj.myapplication;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class MessageLab {private  static final boolean CONTECT_STATE = true;

    private static MessageLab sMessageLab;

    private List<Message> mMessages;
    private Context mContext;

    public static MessageLab get(Context context) {
        if (sMessageLab == null) {
            sMessageLab = new MessageLab(context);
        }
        return sMessageLab;
    }

    private MessageLab(Context context) {
        mContext = context.getApplicationContext();
        //创建list用于保存Message对象
        mMessages = new ArrayList<>();
        //添加数据
        for (int i = 0;i < 5; ++i) {
            Message message = new Message();
            message.setName("name" + i);
            message.setContent("content" + i);
            message.setIcon(R.drawable.icon);
            mMessages.add(message);
        }
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
