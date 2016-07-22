package com.zyj.example.bbk.webview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private String url = "http://2016.qq.com";
    private WebView mWebView;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //调用系统浏览器
//        Uri uri = Uri.parse(url);
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);

        init();

    }

    public void init() {
        mWebView = (WebView) findViewById(R.id.webView);
        //调用系统浏览器
        mWebView.loadUrl(url);
        //覆盖WebView通过系统浏览器打开网页的行为
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                //true:网页在webview中打开,false:调用系统浏览器
                return true;
            }
            //WebViewClient帮助WebView去处理一些页面控制和请求通知
        });

        //启用支持JavaScript
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //WebView加载页面优先使用缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //newProgress 1-100整数
                if (newProgress == 100) {
                    //页面加载完毕,关闭ProgressDialog
                    closeDialog();
                } else {
                    //网页正在加载,打开ProgressDialog
                    openDialog(newProgress);
                }
            }

            private void closeDialog() {
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                    mDialog = null;
                }
            }

            private void openDialog(int newProgress) {
                if (mDialog == null) {
                    mDialog = new ProgressDialog(MainActivity.this);
                    mDialog.setTitle("正在加载");
                    mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mDialog.setProgress(newProgress);
                    mDialog.show();
                } else {
                    mDialog.setProgress(newProgress);
                }
            }


        });

    }

    //改写物理按键--返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();//返回上一页面
                return true;
            } else {
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
