package com.bbk.zyj.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 * ��Ϣ�ỰAdapter
 */
public class MySendAdapter extends BaseAdapter {
    private List<Message> mMessages = new ArrayList<>();
    private Context mContext;

    class ViewHolder
    {
        TextView mContentLeft, mContentRight, mTimeLeft, mTimeRight;
    }

    public MySendAdapter(Context context, List<Message> messages) {
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
        ViewHolder holder = new ViewHolder();
        if (mMessages.get(i).getSend() == 1) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_message_right, null);
            holder.mContentRight = (TextView) view.findViewById(R.id.tv_content_right);
            holder.mTimeRight = (TextView) view.findViewById(R.id.tv_time_right);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_message_left, null);
            holder.mContentLeft = (TextView) view.findViewById(R.id.tv_content_left);
            holder.mTimeLeft = (TextView) view.findViewById(R.id.tv_time_left);
        }
        view.setTag(holder);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String str = format.format(date);
        if (mMessages.get(i).getSend() == 1) {
            holder.mContentRight.setText(mMessages.get(i).getContent());
            holder.mTimeRight.setText(str);
        } else {
            holder.mContentLeft.setText(mMessages.get(i).getContent());
            holder.mTimeLeft.setText(str);
        }
        return view;
    }
}
