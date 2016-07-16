package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {

    private Button mButton;

    String[] from={"name","id"};              //这里是ListView显示内容每一列的列名
    int[] to={R.id.tv_name, R.id.tv_content};   //这里是ListView显示每一列对应的list_item中控件的id

    String[] userName={"zhangsan","lisi","wangwu","zhaoliu"}; //这里第一列所要显示的人名
    String[] userId={"1001","1002","1003","1004"};  //这里是人名对应的ID

    ArrayList<HashMap<String,String>> list=null;
    HashMap<String,String> map=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mButton = (Button) stub.findViewById(R.id.btn);
                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                //创建ArrayList对象；
                list=new ArrayList<HashMap<String,String>>();
                //将数据存放进ArrayList对象中，数据安排的结构是，ListView的一行数据对应一个HashMap对象，
                //HashMap对象，以列名作为键，以该列的值作为Value，将各列信息添加进map中，然后再把每一列对应
                //的map对象添加到ArrayList中

                for(int i=0; i<4; i++){
                    map=new HashMap<String,String>();       //为避免产生空指针异常，有几列就创建几个map对象
                    map.put("id", userId[i]);
                    map.put("name", userName[i]);
                    list.add(map);
                }

                //创建一个SimpleAdapter对象
                SimpleAdapter adapter=new SimpleAdapter(MainActivity.this, list, R.layout.rect_activity_main, from, to);
                //调用ListActivity的setListAdapter方法，为ListView设置适配器
                setListAdapter(adapter);
            }
        });
    }

/*
    String[] from={"name","id"};              //这里是ListView显示内容每一列的列名
    int[] to={R.id.user_name,R.id.user_id};   //这里是ListView显示每一列对应的list_item中控件的id

    String[] userName={"zhangsan","lisi","wangwu","zhaoliu"}; //这里第一列所要显示的人名
    String[] userId={"1001","1002","1003","1004"};  //这里是人名对应的ID

    ArrayList<HashMap<String,String>> list=null;
    HashMap<String,String> map=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);       //为MainActivity设置主布局
        //创建ArrayList对象；
        list=new ArrayList<HashMap<String,String>>();
        //将数据存放进ArrayList对象中，数据安排的结构是，ListView的一行数据对应一个HashMap对象，
        //HashMap对象，以列名作为键，以该列的值作为Value，将各列信息添加进map中，然后再把每一列对应
        //的map对象添加到ArrayList中

        for(int i=0; i<4; i++){
            map=new HashMap<String,String>();       //为避免产生空指针异常，有几列就创建几个map对象
            map.put("id", userId[i]);
            map.put("name", userName[i]);
            list.add(map);
        }

        //创建一个SimpleAdapter对象
        SimpleAdapter adapter=new SimpleAdapter(this,list,R.layout.list_item,from,to);
        //调用ListActivity的setListAdapter方法，为ListView设置适配器
        setListAdapter(adapter);
    }
*/



//    public void sendWearNotify() {
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(
//                this);
//
//        // 1.设置显示内容
//        builder.setContentTitle("消息标题");
//        builder.setContentText("消息内容");
//        // 若只设置了SmallIcon,而没设置LargeIcon,则在通知栏左侧会显示SmallIcon设置的图标;若同时设置了LargeIcon,则左侧显示LargeIcon,右侧显示SmallIcon
//        builder.setSmallIcon(R.drawable.ic_launcher);
//        // 若设置了LargeIcon,则Wear背景会变成LargeIcon.
//        // builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),
//        // R.drawable.default_background_sunny_day_bg));
//        // 2.设置跳转属性
////        Intent intent = new Intent(this, PhoneActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
//                null, 0);
//
//        // 设置了ContentIntent后,通知栏有了点击效果,而wear滑动到最右侧时,多了一个Open on phone的页面
//        builder.setContentIntent(pendingIntent);
//
//        // 3.设置通知属性
//        builder.setAutoCancel(true);
//        builder.setDefaults(Notification.DEFAULT_ALL);
//
//        // 4.设置手表特有属性
//        builder.extend(extendWear(builder));
//        mNotificationManager.notify(1, builder.build());
//    }
}
