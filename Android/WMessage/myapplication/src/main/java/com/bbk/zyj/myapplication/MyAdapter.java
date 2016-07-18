package com.bbk.zyj.myapplication;

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
    private List<Message> messages;
    private Context context;

    class ViewHolder
    {
        ImageView icon;
        TextView name,content;
    }

    public MyAdapter(List<Message> mMessages, Context context) {
        this.messages = mMessages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.textview, null);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.tv_name);
            holder.content = (TextView) view.findViewById(R.id.tv_content);
            holder.icon = (ImageView) view.findViewById(R.id.iv_icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(messages.get(i).getName());
        holder.content.setText(messages.get(i).getContent());
        holder.icon.setImageResource(R.drawable.icon);
        return view;
    }
}
