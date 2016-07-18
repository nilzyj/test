package com.example.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends Activity implements OnClickListener{
	private Button btn1,btn2,btn3;
	private FrameLayout frame;
	//private FragmentManager manager;�����಻��������ȫ�ֵ�
	//private FragmentTransaction action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        FragmentManager manager=getFragmentManager();//������
        FragmentTransaction action=manager.beginTransaction();//����
        //manager=getFragmentManager();
        //action=manager.beginTransaction();
        action.replace(R.id.frame, new MessageFragment());
        action.commit();
    }
    public void initView()
    {
    	btn1=(Button) findViewById(R.id.btn1);
    	btn2=(Button) findViewById(R.id.btn2);
    	btn3=(Button) findViewById(R.id.btn3);
    	frame=(FrameLayout) findViewById(R.id.frame);
    	btn1.setOnClickListener(this);
    	btn2.setOnClickListener(this);
    	btn3.setOnClickListener(this);
    }
	@Override
	public void onClick(View arg0) {
		FragmentManager manager=getFragmentManager();
        FragmentTransaction action=manager.beginTransaction();
		switch (arg0.getId())
		{
			case R.id.btn1:action.replace(R.id.frame, new MessageFragment());break;
			case R.id.btn2:action.replace(R.id.frame, new FriendFragment());break;
			case R.id.btn3:action.replace(R.id.frame, new ActionFragment());break;
		}
		action.commit();
	}
}
