package com.zyj.example.bbk.smstest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.zyj.example.bbk.smstest.configration.CommonConstants;

public class LauncherService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onBind") ;
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onStart") ;
	}

}
