package com.zyj.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * 1.Volley的get和post请求方式的使用
 * 2.Volley的网络请求队列建立和取消队列请求
 * 4.Volley与Activity生命周期的联动
 * 3.Volley的简单d额二次回调封装
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Volley_get();
    }

    private void Volley_get() {
        String url = "";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag("abcGet");
        MyApplication.getHttpQueues().add(request);
    }
}
