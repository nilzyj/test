package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MessageSend extends Activity {

    private TextView mTextView;
    private ImageView ivNoMessage;
    private TextView tvNoMessage;
    private TextView tvReceiveMessage;
    private TextView tvSendMessage;
    private Button btnSendMessage;

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
                tvSendMessage = (TextView) stub.findViewById(R.id.);
                Intent intent = getIntent();
                String name = intent.getStringExtra("name");

            }
        });
    }
}
