package com.zyj.phonemessage;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Administrator on 2016/8/15.
 */
public class MessageTest {

    @Test
    public void testData() {
        Message message = new Message();
        message.setName("zyj");
        message.setContent("content");
        message.setNum("18463101652");
        message.setIcon(R.drawable.icon);
        message.setSend(1);
        Assert.assertEquals("zyj", message.getName());
        Assert.assertEquals("content", message.getContent());
        Assert.assertEquals("18463101652", message.getNum());
        Assert.assertEquals(R.drawable.icon, message.getIcon());
        Assert.assertEquals(1, message.getSend());
    }
}
