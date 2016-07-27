package bbk.com.smsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.util.Log;


/**
 * Created by Administrator on 2016/7/8.
 */
public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //广播接收短信意图
        final android.telephony.SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

        // Check messages for validity
        if (messages == null || messages.length < 1) {
            Log.d("TAG", "onReceive null");
        }
        try {
            //Read the PDUs out of an SMS_RECEIVED_ACTION or a DATA_SMS_RECEIVED_ACTION intent.
            //final String messageBody = messages[0].getDisplayMessageBody();

        } catch (final NullPointerException e) {

        }
        Log.d("TAG","content："+messages);
    }
}
