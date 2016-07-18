package com.example.listview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private String name[]=null;
	private String inf[]=null;
	private int icon[];
	private Context context;
	public MyAdapter(String name[],String inf[],int icon[],Context context)
	{
		this.name=name;
		this.inf=inf;
		this.icon=icon;
		this.context=context;
	}

	@Override
	public int getCount() {
		return name.length;
	}

	@Override
	public Object getItem(int arg0) {
		return name[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		ViewHolder holder;
		if(view==null)
		{
			view=LayoutInflater.from(context).inflate(R.layout.item, null);//����ת����	
			holder=new ViewHolder();
			holder.himage=(ImageView)view.findViewById(R.id.icon);
			holder.hname=(TextView)view.findViewById(R.id.name);
			holder.hsign=(TextView)view.findViewById(R.id.sign);
			view.setTag(holder);
		}
		else
		{
			holder=(ViewHolder)view.getTag();
		}
		holder.himage.setImageResource(icon[arg0]);
		holder.hname.setText(name[arg0]);
		holder.hsign.setText(inf[arg0]);
//		ImageView image=(ImageView) view.findViewById(R.id.icon);
//		TextView tname=(TextView) view.findViewById(R.id.name);
//		TextView sign=(TextView) view.findViewById(R.id.sign);
//		image.setImageResource(icon[arg0]);
//		tname.setText(name[arg0]);
//		sign.setText(inf[arg0]);
		return view;
	}
	class ViewHolder
	{
		ImageView himage;
		TextView hname,hsign;
	}

}
