package com.example.zyj.rssdemo;

import java.util.Vector;

/**
 * Created by dim on 2016/8/17.
 */
public class RSSFeed {
    private String title = null;
    private String pubdate = null;
    private int itemcount = 0;
    private Vector itemlist;

    public RSSFeed() {
        itemlist = new Vector(0);
    }

    public int addItem(RSSItem item)
}
