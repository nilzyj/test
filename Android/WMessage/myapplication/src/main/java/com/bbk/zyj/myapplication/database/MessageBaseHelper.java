package com.bbk.zyj.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/20.
 */
public class MessageBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydata.db";
    private static final int VERSION = 1;

    public MessageBaseHelper(Context context) {
        super(context, DATABASE_NAME, null ,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table message(name varchar(20) not null, password varchar(100);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
