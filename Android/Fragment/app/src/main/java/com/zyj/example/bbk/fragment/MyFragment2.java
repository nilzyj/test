package com.zyj.example.bbk.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MyFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * resource:Fragment需要加载的布局文件
         * root：加载layout的父ViewGroup
         * attactToRoot：false，不返回父ViewGroup
         */
        View view = inflater.inflate(R.layout.fragment, container, false);
        TextView text = (TextView) view.findViewById(R.id.text);
        text.setText("动态加载fragment");
        return view;
    }
}
