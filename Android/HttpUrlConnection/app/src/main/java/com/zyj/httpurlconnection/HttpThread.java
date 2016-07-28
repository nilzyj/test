package com.zyj.httpurlconnection;

import android.os.Handler;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/27.
 */
public class HttpThread extends Thread {

    private String mUrl;
    private WebView mWebView;
    private Handler mHandler = new Handler();

    public HttpThread(String url, WebView webView, Handler handler) {
        mUrl = url;
        mWebView = webView;
        mHandler = handler;
    }

    @Override
    public void run() {
        try {
            URL httpUrl = new URL(mUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            final StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mWebView.loadData(stringBuffer.toString(), "text/html;charset=utf-8", null);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
