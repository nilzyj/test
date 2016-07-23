package com.zyj.example.bbk.smstest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.zyj.example.bbk.smstest.R;
import com.zyj.example.bbk.smstest.configration.CommonConstants;

public class MainTestActivity extends Activity{

	private final String SAVE_INSTANCE_TAG = "MainTestActivity.Saveinstancetag" ;
	EditText editText = null ;
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		if(outState !=null)
		{
			outState.putString(this.SAVE_INSTANCE_TAG, "hello Sundy") ;
		}
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onSaveInstanceState")  ;
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.layout_activitysavestate) ;
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onCreate")  ;
		editText = (EditText)this.findViewById(R.id.editTextState)  ;
		if(editText !=null && savedInstanceState != null)
		{
			editText.setText(savedInstanceState.getString(this.SAVE_INSTANCE_TAG))  ;
		}
		if(savedInstanceState != null)
		{
			Log.i(CommonConstants.LOGCAT_TAG_NAME,"savedInstanceState = "+savedInstanceState.getString(SAVE_INSTANCE_TAG))  ;
		}
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.getPreferences(MODE_PRIVATE).edit().putString(SAVE_INSTANCE_TAG, editText.getText().toString()).commit()  ;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		editText.setText(this.getPreferences(MODE_PRIVATE).getString(SAVE_INSTANCE_TAG, ""))  ;
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onResume")  ;
	}



	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(CommonConstants.LOGCAT_TAG_NAME,"onRestoreInstanceState")  ;
	}

}
