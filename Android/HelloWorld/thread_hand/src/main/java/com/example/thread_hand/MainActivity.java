package com.example.thread_hand;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup group_hand;
    private RadioButton btn1,btn2,btn3;
    private Button btn_start;
    private TextView text_result;
    private ImageView img1,img2,img3;
    private ImageView imgs[]=new ImageView[3];
    private int id;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group_hand=(RadioGroup) findViewById(R.id.hand);
        btn_start=(Button) findViewById(R.id.btn_start);
        text_result=(TextView) findViewById(R.id.text_result);
        img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);
        img3=(ImageView) findViewById(R.id.img3);
        imgs[0]=img1;
        imgs[1]=img2;
        imgs[2]=img3;
        handler=new Handler()
        {
            public void handleMessage(android.os.Message msg)
            {
                super.sendMessage(msg);
                anim(msg.what);
            }
        };
        StartThread st=new StartThread();
        st.start();
        group_hand.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                id=arg0.getCheckedRadioButtonId();
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //比较
                text_result.setText(id+"");//设置结果
            }
        });
    }

    public void anim(int a)
    {
        for(int i=0;i<3;++i)
        {
            if(i==a)
                imgs[i].setBackgroundResource(R.drawable.back);
            else
                imgs[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }
    class StartThread extends Thread
    {
        public void run()
        {
            super.run();
            int position=0;
            while(position<4)
            {
                handler.sendEmptyMessage(position++);
                try {
                    Thread.sleep(200);
                    if(position==3)
                        position=0;
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
}
