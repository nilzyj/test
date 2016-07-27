package com.bbk.zyj.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class MySendAdapter extends BaseAdapter {
    private List<Message> mMessage;
    private Context mContext;

    class ViewHolder
    {
        TextView mContentLeft, mContentRight, mTimeLeft, mTimeRight;
    }

    public MySendAdapter(Context context, List<Message> messages) {
        this.mMessage = messages;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mMessage.size();
    }

    @Override
    public Object getItem(int i) {
        return mMessage.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_message_left, null);
            holder = new ViewHolder();
            holder.mContentLeft = (TextView) view.findViewById(R.id.tv_content_left);
            holder.mTimeLeft = (TextView) view.findViewById(R.id.tv_time_left);
            holder.mContentRight = (TextView) view.findViewById(R.id.tv_content_right);
            holder.mTimeRight = (TextView) view.findViewById(R.id.tv_time_right);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String str = format.format(date);
        if (mMessage.get(i).isSend()) {
            holder.mContentLeft.setText(mMessage.get(i).getContent());
            holder.mTimeLeft.setText(str);
        } else {
            holder.mContentRight.setText(mMessage.get(i).getContent());
            holder.mTimeRight.setText(str);
        }
        return view;
    }
}
