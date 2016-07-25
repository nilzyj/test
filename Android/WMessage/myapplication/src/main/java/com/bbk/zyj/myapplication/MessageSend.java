package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MessageSend extends Activity {

    private TextView mTextView;
    private ImageView ivNoMessage;
    private TextView tvNoMessage;
    private TextView tvReceiveMessage;
    private TextView tvSendMessage;
    private Button btnSendMessage;
    private ListView lvSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_send);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                ivNoMessage = (ImageView) stub.findViewById(R.id.iv_img_no_message);
                tvNoMessage = (TextView) stub.findViewById(R.id.tv_no_message);
                lvSendMessage = (ListView) stub.findViewById(R.id.lv_send_message);

                Bundle bundle = getIntent().getExtras();
                String name = bundle.getString("name");
                String num = bundle.getString("num");
                String content = bundle.getString("content");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MessageSend.this
                        , android.R.layout.simple_list_item_1, new String[] {content});
                lvSendMessage.setAdapter(adapter);

                btnSendMessage = (Button) findViewById(R.id.btn_send_message);
                btnSendMessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentEdit = new Intent(MessageSend.this, MessageEdit.class);
                        startActivity(intentEdit);
                    }
                });

            }
        });


    }
}
