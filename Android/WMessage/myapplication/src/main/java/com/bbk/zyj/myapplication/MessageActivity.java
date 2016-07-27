package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bbk.zyj.myapplication.database.MessageBaseHelper;

import java.io.Serializable;
import java.util.List;

public class MessageActivity extends Activity {

    //绑定状态
    private  static final boolean CONTECT_STATE = true;

    private TextView mTextView;
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

                initView(stub);
                initData();

                //listview响应事件
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (CONTECT_STATE) {
                            //有消息记录
                            Intent intent = new Intent(MessageActivity.this, MessageSend.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("message", (Serializable) mMessages);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } else {
                            //无消息记录
                            Intent intent = new Intent(MessageActivity.this, Binding.class);
                            startActivity(intent);
                        }

                    }
                });

                //listvie长按监听
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

    public void initView(WatchViewStub stub) {
        mTextView = (TextView) stub.findViewById(R.id.text);
        mListView = (ListView) stub.findViewById(R.id.listview);
    }

    public void initData() {
        MessageBaseHelper database = new MessageBaseHelper(MessageActivity.this);
        final SQLiteDatabase db = database.getWritableDatabase();
        mMessages = MessageLab.get(MessageActivity.this, db).getMessages();
        db.close();

        MyAdapter adapter = new MyAdapter(mMessages, MessageActivity.this);
        mListView.setAdapter(adapter);
    }
}
