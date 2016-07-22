package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MessageActivity extends Activity {

    private  static final boolean CONTECT_STATE = true;

//    private ImageView mImageView;
    private TextView mTextView;
//    private TextView mNameTextView;
//    private TextView mContentTextView;
    private ListView mListView;
    private List<Message> mMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                //mNameTextView = (TextView) stub.findViewById(R.id.tv_name);
                //mContentTextView = (TextView) stub.findViewById(R.id.tv_content);
                mListView = (ListView) stub.findViewById(R.id.listview);

                mMessages = MessageLab.get(MessageActivity.this).getMessages();

                MyAdapter adapter = new MyAdapter(mMessages, MessageActivity.this);
                mListView.setAdapter(adapter);
                //listview响应事件
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (CONTECT_STATE) {
                            //有消息记录
                            changeActivity(MessageSend.class, i);
                        } else {
                            //无消息记录
                            changeActivity(Binding.class);
                        }

                    }
                });
                mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MessageActivity.this, "LongClick", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        });
    }

    //有消息记录
    public void changeActivity(Class<?> cls, int i) {
        Intent intent = new Intent(MessageActivity.this, cls);
        intent.putExtra("name", mMessages.get(i).getName());
        intent.putExtra("content", mMessages.get(i).getContent());
        startActivity(intent);
    }
    //无消息记录
    public void changeActivity(Class<?> cls) {
        Intent intent = new Intent(MessageActivity.this, cls);
        startActivity(intent);
    }
}
