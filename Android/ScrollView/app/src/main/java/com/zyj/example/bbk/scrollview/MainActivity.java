package com.zyj.example.bbk.scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ScrollView scroll;
    private Button up_btn;
    private Button down_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.content);
        up_btn=(Button) findViewById(R.id.up);
        down_btn=(Button) findViewById(R.id.down);
        tv.setText(getResources().getString(R.string.content));
        scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        break;
                    }

                    case MotionEvent.ACTION_DOWN: {
                        break;
                    }

                    case MotionEvent.ACTION_MOVE: {
                        /**
                         * (1)getScrollY()--滚动条滑动的距离
                         * (2)getMeasuredHeight()--包括隐藏内容的高度
                         * (3)getHeight()
                         */
                        //顶部状态
                        if(scroll.getScrollY() <= 0) {
                            Log.i("MAIN", "onTouch :顶部");
                        }

                        //底部状态
                        //TextView的高度<=一屏幕的高度+滚动条的滚动距离 :滑动到地步
                        if(scroll.getChildAt(0).getMeasuredHeight() <=
                                scroll.getHeight() + scroll.getScrollY()) {
                            Log.i("MAIN", "onTouch: 滑动到底部");
                            tv.append(getResources().getString(R.string.content));
                        }
                        break;
                    }
                }

                return false;
            }
        });

        //scrollTo():以滚动视图起始位置开始计算的
        //scrollBy():相对前一次的位置滚动
        up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroll.scrollBy(0, -30);
            }
        });

        down_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroll.scrollBy(0, 30);
            }
        });
    }
}
