package com.zyj.contentprovider1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MyContentProvider extends ContentProvider {
    //在ContentProvider创建后被调用
    @Override
    public boolean onCreate() {
        return false;
    }

    //根据uri查询出s指定的条件所匹配的全部记录，并且可以指定查询哪些列以什么方式(order)排序
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    //返回当前uri的MIME类型，如果该URI对应的数据可能包括多条记录
    //那么MIME类型字符串 就是以vnd.android.dir/开头
    //如果该URI对应的数据只有一条记录 该MIME类型字符串 就是以vnd.android.cursor.item/开头
    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    //根据uri插入contentValues对应的数据
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    //根据uri删除s指定的条件所匹配的全部记录
    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    //根据uri修改s指定的条件所匹配的全部记录
    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
