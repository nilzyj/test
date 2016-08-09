package com.zyj.phonemessage;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zyj.phonemessage.database.MessageBaseHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.zyj.phonemessage.database.MessageDbSchema.*;

public class MessageActivity extends Activity implements Serializable {

    //绑定状态
    private static final boolean CONTECT_STATE = true;

    private TextView mTextView;
    private ListView mListView;
    private List<Message> mMessages;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessages = new ArrayList<>();

        initView();
        initData();

        //listview响应事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (CONTECT_STATE) {
                    //有消息记录
                    Intent intent = new Intent(MessageActivity.this, MessageSend.class);
                    //传递姓名,通过姓名获取信息内容?
                    intent.putExtra(MessageTable.Cols.NUM, mMessages.get(i).getNum());
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


    public void initView() {
        mTextView = (TextView) findViewById(R.id.text);
        mListView = (ListView) findViewById(R.id.listview);
    }

    /**
     * 初始化数据
     */
    public void initData() {
        MessageBaseHelper database = new MessageBaseHelper(MessageActivity.this);
        final SQLiteDatabase db = database.getWritableDatabase();
        mMessages = MessageLab.get(MessageActivity.this, db).getMessages();
        db.close();

        adapter = new MyAdapter(mMessages, MessageActivity.this);
        mListView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter == null) {
            MyAdapter adapter = new MyAdapter(mMessages, MessageActivity.this);
            mListView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
