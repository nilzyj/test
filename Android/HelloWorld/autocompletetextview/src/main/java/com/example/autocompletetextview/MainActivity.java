package com.example.autocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView accompleteview;
    private String[] str={"ab","ac","ad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * 第一步：初始化控件
        * 第二步：需要一个适配器
        * 第三步：初始化数据源--用于匹配文本框输入的内容
        * 第四步：将adapter与AutoCompleteTextView绑定
        */
        accompleteview=(AutoCompleteTextView) findViewById(R.id.autocomplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
        accompleteview.setAdapter(adapter);
    }
}
