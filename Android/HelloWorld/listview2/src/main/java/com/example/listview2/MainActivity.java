package com.example.listview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String name[]={"zyj","zym"};
    private String inf[]={"abc","edf"};
    private int icon[]={R.drawable.i1,R.drawable.i2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(name, inf, icon, MainActivity.this);
        listView.setAdapter(adapter);
    }
}
