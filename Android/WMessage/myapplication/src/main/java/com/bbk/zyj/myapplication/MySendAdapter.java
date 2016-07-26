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
public class MySendAdapter extends BaseAdapter {
    private List<String> mContent;
    private Context mContext;

    class ViewHolder
    {
        TextView content;
    }

    public MySendAdapter(Context context, List<String> content) {
        this.mContent = content;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mContent.size();
    }

    @Override
    public Object getItem(int i) {
        return mContent.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            if ()
            view = LayoutInflater.from(mContext).inflate(R.layout.item_message_left null);
            holder = new ViewHolder();
            holder.content = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(.get(i).getName());
        holder.content.setText(messages.get(i).getContent());
        holder.icon.setImageResource(R.drawable.icon);
        return view;
    }
}
