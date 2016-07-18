package com.example.theaddemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView image1,image2,image3,image4,image6,image7,image8,image9;
	private Button btn_start;
	private ImageView images[]=new ImageView[8];
	private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handler=new Handler()
        {
        	public void handleMessage(android.os.Message msg) 
        	{
        		super.handleMessage(msg);
        		anim(msg.what);
        	}
        };
        StartThread st=new StartThread();
        st.start();
    }
    public void initView()
    {
    	image1=(ImageView) findViewById(R.id.icon1);
        image2=(ImageView) findViewById(R.id.icon2);
        image3=(ImageView) findViewById(R.id.icon3);
        image4=(ImageView) findViewById(R.id.icon4);
        image6=(ImageView) findViewById(R.id.icon6);
        image7=(ImageView) findViewById(R.id.icon7);
        image8=(ImageView) findViewById(R.id.icon8);
        image9=(ImageView) findViewById(R.id.icon9);
        btn_start=(Button) findViewById(R.id.start);
        images[0]=image1;
        images[1]=image2;
        images[2]=image3;
        images[3]=image4;
        images[4]=image6;
        images[5]=image7;
        images[6]=image8;
        images[7]=image9;
    }
    public void anim(int a)
    {
    	for(int i=0;i<8;++i)
    		if(i==a)
    		{
    			images[i].setBackgroundResource(R.drawable.background);
    		}
    		else
    		{
    			images[i].setBackgroundColor(Color.TRANSPARENT);
    		}
    }
    class StartThread extends Thread
    {
    	@Override
    	public void run()
    	{
    		super.run();
    		int position=0;
    		while(position<9)
    		{
    			handler.sendEmptyMessage(position++);
    			try {
					Thread.sleep(200);
					if(position==8)
	    				position=0;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    }
}
