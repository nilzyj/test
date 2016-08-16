package com.bbk.zyj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bbk.zyj.myapplication.database.MessageBaseHelper;
import com.bbk.zyj.myapplication.database.MessageDbSchema.MessageTable;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息会话类
 */
public class MessageSend extends Activity {

    private TextView mTextView;
    private ImageView ivNoMessage;
    private TextView tvNoMessage;
    private Button btnSendMessage;
    private ListView lvSendMessage;

    private List<Message> mList;
    private String num;
    private String name;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;

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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * 初始化消息列表
     */
    private void initMessages() {
        MessageBaseHelper database = new MessageBaseHelper(MessageSend.this);
        final SQLiteDatabase db = database.getWritableDatabase();

        mList = new ArrayList<>();
        //ͨ��num��ѯdb
        final Intent intent = getIntent();
        num = intent.getStringExtra(MessageTable.Cols.NUM);

        final Cursor c = db.query(MessageTable.TABLENAME, null, "num=?", new String[]{num}
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

        //��ʾ�Ի�
        MySendAdapter adapter = new MySendAdapter(MessageSend.this, mList);
        lvSendMessage.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MessageSend Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.bbk.zyj.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(mClient, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MessageSend Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.bbk.zyj.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(mClient, viewAction);
        mClient.disconnect();
    }
}
