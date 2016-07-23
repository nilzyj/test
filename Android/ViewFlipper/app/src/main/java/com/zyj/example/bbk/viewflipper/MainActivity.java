package com.zyj.example.bbk.viewflipper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper flipper;
    private float startX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        //动态导入的方法为ViewFlipper加入子View
        flipper.addView(getImageView(R.drawable.pic1));
        flipper.addView(getImageView(R.drawable.pic2));
        flipper.addView(getImageView(R.drawable.pic3));
        flipper.addView(getImageView(R.drawable.pic4));
        flipper.setBackgroundColor(Color.BLACK);

//        //为ViewFlipper添加动画效果
//        flipper.setInAnimation(this, R.anim.left_in);
//        flipper.setOutAnimation(this, R.anim.left_out);
//        //设定ViewFlipper视图切换的时间间隔
//        flipper.setFlipInterval(3000);
//        //开始播放
//        flipper.startFlipping();
    }

    private ImageView getImageView(int resId) {
        ImageView image = new ImageView(this);
        image.setBackgroundResource(resId);
        return image;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            //手指落下
            case MotionEvent.ACTION_DOWN: {
                startX = event.getX();
                break;
            }

            //手指滑动
            case MotionEvent.ACTION_MOVE: {

                break;
            }

            //手指离开
            case MotionEvent.ACTION_UP: {
                //向右滑动
                if (event.getX() - startX > 50) {
                    flipper.setInAnimation(this, R.anim.left_in);
                    flipper.setOutAnimation(this, R.anim.left_out);
                    flipper.showNext();

                }
                //向左滑动
                if (startX - event.getX() > 50) {
                    flipper.setInAnimation(this, R.anim.right_in);
                    flipper.setOutAnimation(this, R.anim.right_out);
                    flipper.showPrevious();
                }
                break;
            }
        }

        return super.onTouchEvent(event);
    }
}
