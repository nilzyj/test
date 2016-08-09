package com.zyj.phonemessage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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

import static com.zyj.phonemessage.database.MessageDbSchema.*;

public class MessageSend extends Activity implements Serializable{

    private TextView mTextView;
    private ImageView ivNoMessage;
    private TextView tvNoMessage;

    private Button btnSendMessage;
    private ListView lvSendMessage;

    private List<Message> mList;
    private String num;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_send);
        mTextView = (TextView) findViewById(R.id.text);
        ivNoMessage = (ImageView) findViewById(R.id.iv_img_no_message);
        ivNoMessage = (ImageView) findViewById(R.id.iv_img_no_message);
        tvNoMessage = (TextView) findViewById(R.id.tv_no_message);
        lvSendMessage = (ListView) findViewById(R.id.lv_send_message);

        initMessages();

        btnSendMessage = (Button) findViewById(R.id.btn_send_message);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEdit = new Intent(MessageSend.this, MessageEdit.class);
                intentEdit.putExtra(MessageTable.Cols.NUM, num);
                intentEdit.putExtra(MessageTable.Cols.NAME, name);
                startActivity(intentEdit);
            }
        });
    }

    /**
     * 初始化消息列表
     */
    private void initMessages() {
        MessageBaseHelper database = new MessageBaseHelper(MessageSend.this);
        final SQLiteDatabase db = database.getWritableDatabase();

        mList = new ArrayList<>();
        //通过num查询db
        final Intent intent = getIntent();
        num = intent.getStringExtra(MessageTable.Cols.NUM);

        final Cursor c = db.query(MessageTable.TABLENAME, null, "num=?", new String[] {num}
                , null, null, null);
        while (c.moveToNext()) {
            Message message = new Message();
            message.setName(c.getString(c.getColumnIndex(MessageTable.Cols.NAME)));
            name = c.getString(c.getColumnIndex(MessageTable.Cols.NAME));
            message.setNum(num);
            message.setContent(c.getString(c.getColumnIndex(MessageTable.Cols.CONTENT)));
            message.setSend(c.getInt(c.getColumnIndex(MessageTable.Cols.ISSEND)));
            message.setIcon(R.drawable.icon);
            mList.add(message);
        }

        db.close();

        //显示对话
        MySendAdapter adapter = new MySendAdapter(MessageSend.this, mList);
        lvSendMessage.setAdapter(adapter);
    }
}
