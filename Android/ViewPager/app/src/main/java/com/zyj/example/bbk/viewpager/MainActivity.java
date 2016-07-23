package com.zyj.example.bbk.viewpager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    private List<View> viewList;
    private List<String> titleList;
    //ViewPager的子标签
    private PagerTabStrip tab;
    private List<Fragment> fragList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //通过View对象ViewPager作为数据源
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);
        View view4 = View.inflate(this, R.layout.view4, null);

        viewList=new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        //为ViewPager页卡设置标题
        titleList=new ArrayList<String>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");

        //为PagerTabStriip设置属性
        tab=(PagerTabStrip) findViewById(R.id.tab);
        tab.setBackgroundColor(Color.YELLOW);
        tab.setTabIndicatorColor(Color.BLUE);
        tab.setDrawFullUnderline(false);
        tab.setTextColor(Color.RED);


        //初始化ViewPager
        pager=(ViewPager) findViewById(R.id.pager);
        //创建PagerAdapter的适配器
        MyViewPagerAdapter adapter=new MyViewPagerAdapter(viewList, titleList);
        //ViewPager加载适配器
//        pager.setAdapter(adapter);
        //Fragment作为ViewPager数据源
        fragList=new ArrayList<Fragment>();
        fragList.add(new Fragment1());
        fragList.add(new Fragment2());
        fragList.add(new Fragment3());
        fragList.add(new Fragment4());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragList, titleList);
//        pager.setAdapter(myFragmentPagerAdapter);

        MyFragmentStatePagerAdapter myFragmentStatePagerAdapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), fragList, titleList);
        pager.setAdapter(myFragmentStatePagerAdapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Toast.makeText(MainActivity.this, "这是第"+(state+1)+"个界面", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
