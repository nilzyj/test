package com.zyj.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class BC1 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String s = intent.getStringExtra("msg");
		System.out.println("reveiver1收到消息:"+s);
		abortBroadcast();
//		Bundle bundle = 	new Bundle();
//		bundle.putString("test", "");
//		setResultExtras(bundle);
	}

}
