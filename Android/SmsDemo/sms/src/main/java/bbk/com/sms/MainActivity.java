package bbk.com.sms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
    private EditText mEditText1,mEditText2;
    private Button mButton1;
    private TextView mTextVIew;
    private String content;

    BroadcastReceiver rcvMsgSent = null;
    BroadcastReceiver rcvMsgReceipt = null;

    BroadcastReceiver rcvIncoming = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText1 = (EditText) findViewById(R.id.et_num);
        mEditText2 = (EditText) findViewById(R.id.et_content);
        mButton1 = (Button) findViewById(R.id.btn_send);
        mTextVIew = (TextView) findViewById(R.id.tv_receive);
        final SmsManager smsManager = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");
        Intent msgReceipt = new Intent("ACTION_MSG_RECEIPT");
        final PendingIntent pendingMsgSent =
                PendingIntent.getBroadcast(MainActivity.this, 0, msgSent, 0);
        final PendingIntent pendingMsgReceipt =
                PendingIntent.getBroadcast(MainActivity.this, 0, msgReceipt, 0);
        //设定onClickListener 让使用者点选Button时做出反应
        mButton1.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //由EditText1取得简讯收件人电话
                final String strDestAddress = mEditText1.getText().toString();
                //由EditText2取得简讯文字内容
                final String strMessage = mEditText2.getText().toString();
                //取得default instance的 SmsManager对象
                smsManager.sendTextMessage(strDestAddress, null, strMessage, pendingMsgSent,
                        pendingMsgReceipt);
                mEditText1.setText("");
                mEditText2.setText("");
                DatabaseHelper database = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = database.getReadableDatabase();
                Cursor cursor = db.query("content",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    String content = cursor.getString(cursor.getColumnIndex("content"));
                    mTextVIew.setText(content);
                }
                db.close();
                Log.d("sms send","send");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
//        unregisterReceiver(rcvIncoming);
//        unregisterReceiver(rcvMsgSent);
        super.onDestroy();
    }
}

//requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},);

//                rcvMsgSent = new BroadcastReceiver() {
//                    @Override
//                    public void onReceive(Context context, Intent intent) {
//                        int result = getResultCode();
//                        if (result != Activity.RESULT_OK) {
//                            Log.e("telephony", "SMS send failed code = " + result);
//                            pendingMsgReceipt.cancel();
//                        } else {
//                            Toast.makeText(MainActivity.this,"send",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                };
//                registerReceiver(rcvMsgSent, new IntentFilter("SENT_SMS_ACTION"));//ACTION_MSG_SENT
//try
//{
                    /*
                     * 先构建一个PendingIntent对象并使用getBroadcast()方法获得Broadcast
                     * 将PendingIntent,电话,简讯文字等参数传入sendTextMessage()方法发送简讯
                     */
//                    PendingIntent mPI = PendingIntent.getBroadcast(MainActivity.this, 0,
//                            new Intent(), 0);
//                    smsManager.sendTextMessage(strDestAddress, null, strMessage, mPI,
//                            null);
//                } catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//                Toast.makeText(MainActivity.this, "发送成功!!", Toast.LENGTH_SHORT).show();
//                mEditText1.setText("");
//                mEditText2.setText("");
//                Log.i("SMS", "send message");
//        rcvIncoming = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Log.d("telephony","SMS received");
//                final android.telephony.SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
//                //String content = messages[0].getDisplayMessageBody();
//                String content = messages[0].getMessageBody();
//                Toast.makeText(MainActivity.this,"receive",Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity.this,content,Toast.LENGTH_LONG).show();
//                mTextVIew.setText(content);
                /*Bundle data = intent.getExtras();
                if (data != null) {
                    //Object pdus[] = (Object[]) data.get("pdus");

                    String message = "new message:\n";
                    String sender = null;
                    android.telephony.SmsMessage[] part = Telephony.Sms.Intents.getMessagesFromIntent(intent);
                    message += part[0].getDisplayMessageBody();

                    if (sender == null) {
                        sender = part[0].getDisplayMessageBody();
                    }
                    mTextVIew.setText(message + "\nForm: " + sender);
                    //mEditText1.setText(sender);
                }*/
//}
//};
//registerReceiver(rcvIncoming, new IntentFilter("DELIVERED_SMS_ACTION"));
//android.provider.Telephony.SMS_RECEIVED