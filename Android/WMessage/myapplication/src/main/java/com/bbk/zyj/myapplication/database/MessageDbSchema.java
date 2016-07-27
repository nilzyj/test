package com.bbk.zyj.myapplication.database;

import com.bbk.zyj.myapplication.R;

/**
 * Created by Administrator on 2016/7/20.
 */
public class MessageDbSchema {
    public static final class MessageTable {
        public static final String TABLENAME = "message";

        public static final class Cols {
            public static final String ID = "_id";
            public static final String NAME = "name";
            public static final String NUMBER = "number";
            public static final String TIME = "time";
            public static final String CONTENT = "content";
            public static final String ICON = "icon";
            public static final String ISSEND = "isSend";
        }
    }
}
