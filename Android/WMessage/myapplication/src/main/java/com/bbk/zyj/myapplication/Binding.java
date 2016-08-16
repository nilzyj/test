package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * 绑定Activity
 */
public class Binding extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding);
    }
}
