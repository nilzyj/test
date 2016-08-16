package com.zyj.volleydemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/8/16.
 */
public class MyApplication extends Application {

    public static RequestQueue mQueues;

    @Override
    public void onCreate() {
        super.onCreate();

        mQueues = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpQueues() {
        return mQueues;
    }
}
