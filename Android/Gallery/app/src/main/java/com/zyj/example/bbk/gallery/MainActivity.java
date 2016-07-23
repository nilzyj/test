package com.zyj.example.bbk.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    // 准备数据源
    private int[] res = { R.drawable.item1, R.drawable.item2, R.drawable.item3,
            R.drawable.item4, R.drawable.item5, R.drawable.item6,
            R.drawable.item7, R.drawable.item8, R.drawable.item9,
            R.drawable.item10, R.drawable.item11, R.drawable.item12 };

    private ImageAdapter adapter;
    private Gallery gallery;
    private ImageSwitcher is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = (Gallery) findViewById(R.id.gallery);
        is=(ImageSwitcher) findViewById(R.id.is);
        // gallery加载适配器
        adapter = new ImageAdapter(res, this);
        gallery.setAdapter(adapter);
        is.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        is.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                is.setBackgroundResource(res[i % res.length]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView image=new ImageView(MainActivity.this);
                //等比例缩放
                image.setScaleType(ImageView.ScaleType.FIT_CENTER);

                return image;
            }
        });
    }
}
