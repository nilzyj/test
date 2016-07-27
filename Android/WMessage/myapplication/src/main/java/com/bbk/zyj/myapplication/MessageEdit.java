package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bbk.zyj.myapplication.database.MessageBaseHelper;

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
        final String num = bundle.getString("num");

        et_send = (EditText) findViewById(R.id.et_send);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et_send.getText().toString();
                if(!content.equals("")) {
                    smsManager.sendTextMessage(num, null, content, pendingMsgSent,
                            pendingMsgReceipt);
                    et_send.setText("");
                    saveDb(content);
                } else {
                    Toast.makeText(MessageEdit.this, "请输入短信内容", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void saveDb(String content) {
        MessageBaseHelper database = new MessageBaseHelper(MessageEdit.this);
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("content",content);
        db.insert("content",null,cv);
        Cursor c = db.query("content",null,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.moveToNext()){
            Log.d("db",c.getString(c.getColumnIndex("content")));
        }
        db.close();
    }
}
