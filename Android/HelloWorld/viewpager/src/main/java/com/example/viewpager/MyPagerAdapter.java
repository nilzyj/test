package com.example.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyPagerAdapter extends PagerAdapter {
	private ImageView views[];
	public MyPagerAdapter(ImageView views[])//���Ե��Ҽ�source����
	{
		this.views=views;
	}

	@Override
	public int getCount() {
		return views.length;
	}
	//添加item并显示
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(views[position]);
		return views[position];
	}
	//移除划出屏幕的item
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(views[position]);
	}
	//判断当前界面有没有划出去
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	
	

}
