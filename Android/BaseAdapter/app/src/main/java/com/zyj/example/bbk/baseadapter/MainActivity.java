package com.zyj.example.bbk.baseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ItemBean> itemBeanList = new ArrayList<>();
        // 创建假数据
        for (int i = 0; i < 20; i++) {
            itemBeanList.add(new ItemBean(
                    R.mipmap.ic_launcher
                    , "Title" + i
                    , "Content" + i
            ));
        }

        //建立ListView和Adapter的联系
        ListView listView = (ListView) findViewById(R.id.lv_main);
        listView.setAdapter(new MyAdapter(MainActivity.this, itemBeanList));
    }
}
