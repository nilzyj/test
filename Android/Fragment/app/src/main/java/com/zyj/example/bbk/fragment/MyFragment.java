package com.zyj.example.bbk.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MyFragment extends Fragment {

    private String aaa;


    public String getAaa() {
        return aaa;
    }


    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

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
        Button button=(Button) view.findViewById(R.id.button);
        button.setText("获取内容");
        text.setText("静态加载fragment");
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String value = getAaa();
                Toast.makeText(getActivity(), "value="+value, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
