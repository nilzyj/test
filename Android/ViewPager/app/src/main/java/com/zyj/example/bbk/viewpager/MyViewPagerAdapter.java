package com.zyj.example.bbk.viewpager;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyViewPagerAdapter extends PagerAdapter{

	private List<View> viewList;
	private List<String> titleList;
	
	public MyViewPagerAdapter(List<View> viewList, List<String> titleList)
	{
		this.viewList=viewList;
		this.titleList=titleList;
	}
	
	//返回的是页卡的数量
	@Override
	public int getCount() {
		return viewList.size();
	}
  
	//View是否来自于对象
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		//官方做法
		return arg0==arg1;
	}
	
	//实例化页卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    	container.addView(viewList.get(position));
    	return viewList.get(position);
    }
    
    //销毁页卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	// TODO Auto-generated method stub
    	container.removeView(viewList.get(position));
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
    	// TODO Auto-generated method stub
    	return titleList.get(position);
    }

}
