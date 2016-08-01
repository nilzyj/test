package com.zyj.phonemessage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zyj.phonemessage.database.MessageBaseHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageSend extends Activity implements Serializable{

    private TextView mTextView;
    private ImageView ivNoMessage;
    private TextView tvNoMessage;

    private Button btnSendMessage;
    private ListView lvSendMessage;

    private List<Message> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_send);
        mTextView = (TextView) findViewById(R.id.text);
        ivNoMessage = (ImageView) findViewById(R.id.iv_img_no_message);
        tvNoMessage = (TextView) findViewById(R.id.tv_no_message);
        lvSendMessage = (ListView) findViewById(R.id.lv_send_message);

        MessageBaseHelper database = new MessageBaseHelper(MessageSend.this);
        final SQLiteDatabase db = database.getWritableDatabase();

        mList = new ArrayList<>();
        Message message1 = new Message();
        message1.setName("name");
        message1.setNum("18463101652");
        message1.setContent("content");
        message1.setSend(true);
        message1.setIcon(R.drawable.icon);
        mList.add(message1);
        Message message2 = new Message();
        message2.setName("name1");
        message2.setNum("18463101652");
        message2.setContent("content1");
        message2.setSend(false);
        message2.setIcon(R.drawable.icon);
        mList.add(message2);

        //显示对话
        MySendAdapter adapter = new MySendAdapter(MessageSend.this, mList);
        lvSendMessage.setAdapter(adapter);

        btnSendMessage = (Button) findViewById(R.id.btn_send_message);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEdit = new Intent(MessageSend.this, MessageEdit.class);
                SharedPreferences sharedPreferences = getSharedPreferences("msg", MODE_PRIVATE);
                String str = sharedPreferences.getString("message", "");

            }
        });

    }
}
