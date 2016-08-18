package com.zyj.picassodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 图片下载的步骤
 * 1.使用异步任务或handler+thread 获取图片资源
 * 2.使用bitmapFactory对图片进行解码
 * 3.显示图片
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.button)
    Button mButton;
    @Bind(R.id.imageView)
    ImageView mImageView;

    private final String IMAGE_PATH = "http://b.hiphotos.baidu.com/image/h%3D360/sign=326e83f4f236afc3110c39638319eb85/908fa0ec08fa513d17b6a2ea386d55fbb2fbd9e2.jpg";
//    private final String IMAGE_PATH = "http://d.hiphotos.baidu.com/image/pic/item/72f082025aafa40fc8e49138af64034f78f01930.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(MainActivity.this).load(IMAGE_PATH).fit().into(mImageView);
                Log.i("picasso", "onClick: ");
            }
        });
    }
}
