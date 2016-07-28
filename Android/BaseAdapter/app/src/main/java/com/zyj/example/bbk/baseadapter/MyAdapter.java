package com.zyj.example.bbk.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dim on 2016/7/23.
 */
public class MyAdapter extends BaseAdapter {

    //布局装载器对象
    private LayoutInflater mInflater;

    //通过构造方法数据源与数据适配器关联,映射数据
    private List<ItemBean> mList;

    public MyAdapter(Context context, List<ItemBean> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //返回每一项的显示内容
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        //没有利用到ListView的缓存机制,逗比式*****
        //需要装载到item中的布局文件
        //由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
//        View view = mInflater.inflate(R.layout.item, null);
//        // 实例化控件
//        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
//        TextView title = (TextView) view.findViewById(R.id.tv_title);
//        TextView content = (TextView) view.findViewById(R.id.tv_content);
//
//        //将数据从数据源中取出并赋给控件
//        ItemBean bean = mList.get(i);
//         // 设置控件的数据
//        imageView.setImageResource(bean.itemImageResId);
//        title.setText(bean.itemTitle);
//        content.setText(bean.itemContent);
//
//        return view;
        //逗比式********************************

        //使用缓存机制,普通式*********************
        //View未被实例化,缓冲池中无缓存
//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.item, null);
//        }
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
//        TextView title = (TextView) convertView.findViewById(R.id.tv_title);
//        TextView content = (TextView) convertView.findViewById(R.id.tv_content);
//
//        ItemBean bean = mList.get(i);
//        imageView.setImageResource(bean.itemImageResId);
//        title.setText(bean.itemTitle);
//        content.setText(bean.itemContent);
//
//        return convertView;
        //普通式********************************

        //文艺式********************************
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.tv_content);
            //通过setTag()将ViewHolder与convertView绑定
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ItemBean bean = mList.get(i);
        viewHolder.imageView.setImageResource(bean.itemImageResId);
        viewHolder.title.setText(bean.itemTitle);
        viewHolder.content.setText(bean.itemContent);

        return convertView;
        //文艺式********************************
    }

    class ViewHolder {
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}
