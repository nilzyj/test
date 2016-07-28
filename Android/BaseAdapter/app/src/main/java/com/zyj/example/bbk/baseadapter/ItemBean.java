package com.zyj.example.bbk.baseadapter;

/**
 * Created by dim on 2016/7/23.
 */
public class ItemBean {
    public int itemImageResId;
    public String itemTitle;
    public String itemContent;

    public ItemBean(int itemImageResId, String itemTitle, String itemContent) {
        this.itemImageResId = itemImageResId;
        this.itemTitle = itemTitle;
        this.itemContent = itemContent;
    }
}
