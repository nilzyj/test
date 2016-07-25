package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessageEdit extends Activity {

    private EditText et_send;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_edit);

        final SmsManager smsManager = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");
        Intent msgReceipt = new Intent("ACTION_MSG_RECEIPT");
        final PendingIntent pendingMsgSent =
                PendingIntent.getBroadcast(MessageEdit.this, 0, msgSent, 0);
        final PendingIntent pendingMsgReceipt =
                PendingIntent.getBroadcast(MessageEdit.this, 0, msgReceipt, 0);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        final String num = bundle.getString("num");
        final String content = bundle.getString("content");

        et_send = (EditText) findViewById(R.id.et_send);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("num", "onClick: " + num);
                smsManager.sendTextMessage(num, null, content, pendingMsgSent,
                        pendingMsgReceipt);
                et_send.setText("");
                Log.d("sms send","send");
            }
        });
    }
}
