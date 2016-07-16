package com.example.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private int images[]={R.drawable.n1,R.drawable.n2,R.drawable.n3};
    private ImageView views[]=new ImageView[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=(ViewPager) findViewById(R.id.viewPager);
        for(int i=0;i<3;++i)
        {
            ImageView image=new ImageView(MainActivity.this);
            image.setImageResource(images[i]);
            views[i]=image;
        }
        MyPagerAdapter adapter=new MyPagerAdapter(views);
        pager.setAdapter(adapter);
    }
}
