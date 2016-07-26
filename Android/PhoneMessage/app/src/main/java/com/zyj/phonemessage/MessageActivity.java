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

import java.util.List;

public class MessageActivity extends Activity {

    //绑定状态
    private static final boolean CONTECT_STATE = true;

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

        initView();
        initData();

        //listview响应事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (CONTECT_STATE) {
                    //有消息记录
                    Intent intent = new Intent(MessageActivity.this, MessageSend.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", mMessages.get(i).getName());
                    bundle.putString("content", mMessages.get(i).getContent());
                    bundle.putString("num", mMessages.get(i).getNum());
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


    public void initView() {
        mTextView = (TextView) findViewById(R.id.text);
        //mNameTextView = (TextView) stub.findViewById(R.id.tv_name);
        //mContentTextView = (TextView) stub.findViewById(R.id.tv_content);
        mListView = (ListView) findViewById(R.id.listview);
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
