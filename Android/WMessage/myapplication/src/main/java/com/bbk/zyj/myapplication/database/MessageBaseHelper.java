package com.bbk.zyj.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bbk.zyj.myapplication.Message;
import com.bbk.zyj.myapplication.database.MessageDbSchema.MessageTable;

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
        String sql = "create table " + MessageTable.TABLENAME + "(" +
                MessageTable.Cols.ID + " integer primary key auto increment" +
                MessageTable.Cols.NAME + " varchar(20)," +
                MessageTable.Cols.NUMBER + " varchar(20) not null," +
                MessageTable.Cols.TIME + " varchar(30)" +
                MessageTable.Cols.CONTENT + " varchar(100)," +
                MessageTable.Cols.ICON + " integer +" +
                MessageTable.Cols.ISSEND + " boolean);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}