package com.example.listview4;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<Map<String, Object>> mMapList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, getData(), R.layout.simple, new String[] {"img", "text"}, new int[] {R.id.imageView, R.id.textView});
        mListView.setAdapter(simpleAdapter);
    }

    public List<Map<String, Object>> getData() {
        mMapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("text", "1");
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("img", R.mipmap.ic_launcher);
        map1.put("text", "2");
        mMapList.add(map);
        mMapList.add(map1);
        return mMapList;
    }
}