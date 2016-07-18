package com.example.sharedperference;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private TextView text1,text2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		text1=(TextView) findViewById(R.id.text1);
		text2=(TextView) findViewById(R.id.text2);
		Intent intent=getIntent();
		String str1=intent.getStringExtra("account");
		String str2=intent.getStringExtra("psw");
		Toast.makeText(LoginActivity.this, str1, Toast.LENGTH_SHORT).show();
		Toast.makeText(LoginActivity.this, str2, Toast.LENGTH_SHORT).show();
	}

	
}
