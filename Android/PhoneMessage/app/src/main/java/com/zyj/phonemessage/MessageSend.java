package com.zyj.phonemessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageSend extends Activity {

    private TextView mTextView;
    private ImageView ivNoMessage;
    private TextView tvNoMessage;
    private TextView tvReceiveMessage;
    private TextView tvSendMessage;
    private Button btnSendMessage;
    private ListView lvSendMessage;

    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_send);
        mTextView = (TextView) findViewById(R.id.text);
        ivNoMessage = (ImageView) findViewById(R.id.iv_img_no_message);
        tvNoMessage = (TextView) findViewById(R.id.tv_no_message);
        lvSendMessage = (ListView) findViewById(R.id.lv_send_message);

        Bundle bundle = getIntent().getExtras();
//                String name = bundle.getString("name");
//                String num = bundle.getString("num");
        String content = bundle.getString("content");
        final String num = bundle.getString("num");
        Log.i("zyj", "onCreate: " + content);
        mList = new ArrayList<>();
        mList.add(content);
        mList.add("content1");
        mList.add("content2");
        mList.add("content3");

        MySendAdapter adapter = new MySendAdapter(MessageSend.this, mList);
        lvSendMessage.setAdapter(adapter);

        btnSendMessage = (Button) findViewById(R.id.btn_send_message);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEdit = new Intent(MessageSend.this, MessageEdit.class);
                Bundle bundle = new Bundle();
                bundle.putString("num", num);
                intentEdit.putExtras(bundle);
                startActivity(intentEdit);
            }
        });

    }
}
