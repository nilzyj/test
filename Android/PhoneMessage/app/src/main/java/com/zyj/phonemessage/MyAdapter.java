package com.zyj.phonemessage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class MyAdapter extends BaseAdapter {
    private List<Message> mMessages;
    private Context mContext;

    class ViewHolder
    {
        ImageView icon;
        TextView name,content;
    }

    public MyAdapter(List<Message> messages, Context context) {
        this.mMessages = messages;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mMessages.size();
    }

    @Override
    public Object getItem(int i) {
        return mMessages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.textview, null);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.tv_name);
            holder.content = (TextView) view.findViewById(R.id.tv_content);
            holder.icon = (ImageView) view.findViewById(R.id.iv_icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(mMessages.get(i).getName());
        holder.content.setText(mMessages.get(i).getContent());
        holder.icon.setImageResource(R.drawable.icon);
        return view;
    }
}
