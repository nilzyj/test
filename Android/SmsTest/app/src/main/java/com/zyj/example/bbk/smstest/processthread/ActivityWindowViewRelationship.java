package com.zyj.example.bbk.smstest.processthread;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.zyj.example.bbk.smstest.R;

public class ActivityWindowViewRelationship extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setContentView(LayoutInflater.from(this).inflate(R.layout.layout_inflater, null)) ;
	}

}
