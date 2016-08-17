package com.zyj.phonemessage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zyj.phonemessage.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 * 消息列表Adapter
 */
public class MyAdapter extends BaseAdapter {
    private List<Message> mMessages;
    private Context mContext;

    class ViewHolder
    {
        RoundedImageView icon;
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
            holder.icon = (RoundedImageView) view.findViewById(R.id.roundedimageview);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (mMessages.get(i).getName() == null) {
            holder.name.setText(mMessages.get(i).getNum());
        } else {
            holder.name.setText(mMessages.get(i).getName());
        }
        holder.content.setText(mMessages.get(i).getContent());
        holder.icon.setOval(true);
        holder.icon.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.icon));
        holder.icon.setTileModeX(Shader.TileMode.CLAMP);
        holder.icon.setTileModeY(Shader.TileMode.CLAMP);
        return view;
    }
}
