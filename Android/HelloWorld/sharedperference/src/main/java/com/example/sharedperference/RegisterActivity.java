package com.example.sharedperference;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends ActionBarActivity {
	private TextView account,psw;
	private Button btn_register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		account=(TextView) findViewById(R.id.r_account);
		psw=(TextView) findViewById(R.id.r_psw);
		btn_register=(Button) findViewById(R.id.r_btn_register);
		btn_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				SharedPreferences preferences=getSharedPreferences("user",Context.MODE_APPEND);
				Editor editor=preferences.edit();
				String sacc=account.getText().toString();
				String spsw=psw.getText().toString();
				editor.putString("r_account", sacc);
				editor.putString("r_psw", spsw);
				editor.commit();
				//Intent intent=new Intent();
				finish();
			}
		});
		
	}

	
}
/*��ȡSharedPreferences�����ַ�ʽ:
1 ����Context�����getSharedPreferences()����
2 ����Activity�����getPreferences()����
���ַ�ʽ������:
����Context�����getSharedPreferences()������õ�SharedPreferences������Ա�ͬһӦ�ó����µ������������.
����Activity�����getPreferences()������õ�SharedPreferences����ֻ���ڸ�Activity��ʹ��.*/