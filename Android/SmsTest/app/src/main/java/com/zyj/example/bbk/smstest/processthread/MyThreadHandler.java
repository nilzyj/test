package com.zyj.example.bbk.smstest.processthread;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.zyj.example.bbk.smstest.configration.CommonConstants;

public class MyThreadHandler extends Handler {

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handleMessage(msg);
		Log.i(CommonConstants.LOGCAT_TAG_NAME, "Get the message by Handler Thread")  ;
	}

}
