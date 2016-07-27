package com.zyj.handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Handler mHandler = new Handler();;
    private ImageView mImageView;
    private int images[] = {R.drawable.p1, R.drawable.p2, R.drawable.p3};
    private int index;
    private MyRunnable mMyRunnable = new MyRunnable();

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
        mHandler.postDelayed(mMyRunnable, 1000);


//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            mTextView.setText("update thread");
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
    }
}
