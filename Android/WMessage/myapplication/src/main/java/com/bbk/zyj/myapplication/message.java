package com.bbk.zyj.myapplication;

/**
 * Created by Administrator on 2016/7/18.
 */
public class Message {
    //联系人姓名
    private String name;
    //短信内容
    private String content;
    //头像

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    private int icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
