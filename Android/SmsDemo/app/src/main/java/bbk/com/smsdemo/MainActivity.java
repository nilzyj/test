package bbk.com.smsdemo;

import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText1,mEditText2;
    private Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //透过findViewById建构子来建构EditText1,EditText2与Button对象
        mEditText1 = (EditText) findViewById(R.id.et_num);
        mEditText2 = (EditText) findViewById(R.id.et_content);
        mButton1 = (Button) findViewById(R.id.btn_send);
        //将默认文字加载EditText中
        //mEditText1.setText("请输入电话号码");
        //mEditText2.setText("请输入短信内容!!");
        //设定onClickListener 让使用者点选EditText时做出反应
        mEditText1.setOnClickListener(new EditText.OnClickListener()
        {
            public void onClick(View v)
            {
        //点选EditText时清空内文
                mEditText1.setText("");
            }
        });
        //设定onClickListener 让使用者点选EditText时做出反应
        mEditText2.setOnClickListener(new EditText.OnClickListener()
        {
            public void onClick(View v)
            {
        //点选EditText时清空内文
                mEditText2.setText("");
            }
        });
        //设定onClickListener 让使用者点选Button时做出反应
        mButton1.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //由EditText1取得简讯收件人电话
                String strDestAddress = mEditText1.getText().toString();
                //由EditText2取得简讯文字内容
                String strMessage = mEditText2.getText().toString();
                //建构一取得default instance的 SmsManager对象
                SmsManager smsManager = SmsManager.getDefault();
                try
                {
                    /*
                     * 先构建一个PendingIntent对象并使用getBroadcast()方法获得Broadcast
                     * 将PendingIntent,电话,简讯文字等参数传入sendTextMessage()方法发送简讯
                     */
                    PendingIntent mPI = PendingIntent.getBroadcast(MainActivity.this, 0,
                            new Intent(), 0);
                    smsManager.sendTextMessage(strDestAddress, null, strMessage, mPI,
                            null);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "送出成功!!", Toast.LENGTH_SHORT).show();
                mEditText1.setText("");
                mEditText2.setText("");
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
}
