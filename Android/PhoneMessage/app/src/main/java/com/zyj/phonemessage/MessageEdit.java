package com.zyj.phonemessage;

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
import android.widget.Toast;

import com.zyj.phonemessage.database.MessageBaseHelper;
import com.zyj.phonemessage.database.MessageDbSchema;

import static com.zyj.phonemessage.database.MessageDbSchema.*;

public class MessageEdit extends Activity {

    private EditText et_send;
    private Button btn_send;
    private String num;
    private String name;

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

        num = getIntent().getStringExtra(MessageTable.Cols.NUM);
        name = getIntent().getStringExtra(MessageTable.Cols.NAME);

        et_send = (EditText) findViewById(R.id.et_send);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et_send.getText().toString();
                if (!content.equals("")) {
                    smsManager.sendTextMessage(num, null, content, pendingMsgSent,
                            pendingMsgReceipt);
                    et_send.setText("");
                    saveDb(content);
                } else {
                    Toast.makeText(MessageEdit.this, R.string.send_fail, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void saveDb(String content) {
        MessageBaseHelper database = new MessageBaseHelper(MessageEdit.this);
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MessageTable.Cols.CONTENT, content);
        cv.put(MessageTable.Cols.NUM, num);
        cv.put(MessageTable.Cols.ISSEND, 1);
        cv.put(MessageTable.Cols.NAME, name);
        db.insert(MessageTable.TABLENAME, null, cv);
        db.close();
    }
}
