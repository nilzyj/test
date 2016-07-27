package com.zyj.handlersendmessage;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private Button mButton;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            //return true;拦截消息,
            return false;
        }
    }) {
        @Override
        public void handleMessage(Message msg) {
            mTextView.setText("" + msg.arg1 + "-" +msg.arg2 + msg.obj);
        }
    };
    private ImageView mImageView;
    private int images[] = {R.drawable.p1, R.drawable.p2, R.drawable.p3};
    private int index;
    private MyRunnable mMyRunnable = new MyRunnable();

    class Person {
        public int age;
        public String name;

        @Override
        public String toString() {
            return "name:" + name + ",age:" +age;
        }
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            index ++;
            index = index % 3;
            mImageView.setImageResource(images[index]);
            mHandler.postDelayed(mMyRunnable, 1000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mButton = (Button) findViewById(R.id.button);

        mHandler.postDelayed(mMyRunnable, 1000);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.removeCallbacks(mMyRunnable);
            }
        });

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Message message = new Message();
                    //Message message = mHandler.obtainMessage();
                    message.arg1 = 88;
                    message.arg2 = 100;
                    Person person = new Person();
                    person.age = 21;
                    person.name = "jml";
                    message.obj = person;
                    mHandler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
