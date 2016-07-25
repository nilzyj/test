package com.zyj.example.bbk.newsimooc;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private static String url = "http://www.imooc.com/api/teacher?type=4&num=30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lv_main);

        new NewsAsyncTask().execute(url);
    }

    //将url对应的json格式的数据转化为我们所封装的NewsBean
    private List<NewsBean> getJsonData(String string) {
        List<NewsBean> newsBeanList = new ArrayList<>();
        //new URL(url).openStream()功能同url.openConnection().getInputStream()相同,可根据URL直接
        //联网获取网络数据,简单粗暴.返回值类型为InputStream
        try {
            String jsonString = readStream(new URL(url).openStream());
            JSONObject jsonObject;
            NewsBean newsBean;
            try {
                jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    newsBean = new NewsBean();
                    newsBean.newsIconUrl = jsonObject.getString("picSmall");
                    newsBean.newsTitle = jsonObject.getString("name");
                    newsBean.newsContent = jsonObject.getString("description");
                    newsBeanList.add(newsBean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        return newsBeanList;
    }

    //通过inputstream解析网页返回的数据
    private String readStream(InputStream is) {
        InputStreamReader isr;
        String result = "";
        try {
            String line = "";
            isr = new InputStreamReader(is, "UTF-8");//字节流转化为字符流
            BufferedReader br = new BufferedReader(isr);//将字符流以buffer读取出来
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //实现网络的异步访问
    class NewsAsyncTask extends AsyncTask<String, Void, List<NewsBean>> {
        @Override
        protected List<NewsBean> doInBackground(String... strings) {
            return getJsonData(strings[0]);
        }

        @Override
        protected void onPostExecute(List<NewsBean> newsBeen) {
            super.onPostExecute(newsBeen);
            NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, newsBeen, mListView);
            mListView.setAdapter(newsAdapter);
        }
    }
}
