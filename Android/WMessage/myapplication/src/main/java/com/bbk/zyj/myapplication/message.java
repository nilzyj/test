package com.bbk.zyj.myapplication;

/**
 * Created by Administrator on 2016/7/18.
 */
public class Message {
    //联系人姓名
    private String name;
    //短信内容
    private String content;
    //电话号码
    private String num;
    //头像
    private int icon;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
