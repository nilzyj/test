package com.example.listview1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 1.在布局文件添加listview这个控件
 * 2.声明实例化这个控件
 * 3.准备数据源
 * 4.构建适配器
 * 5.添加适配器
 * （6。添加监听）
 */
public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String food[]={"辣条","海参","无花果","苹果","人参","杀猪菜","凉皮","灵宝肉夹馍","北京烤鸭","烤冷面","炝锅鱼"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1 , food);//<>泛型
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(Adapter arg0, View arg1, int arg2, long arg3)
            {
                Toast.makeText(MainActivity.this, food[arg2],Toast.LENGTH_SHORT);
            }

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub

            }
        });
    }
}
