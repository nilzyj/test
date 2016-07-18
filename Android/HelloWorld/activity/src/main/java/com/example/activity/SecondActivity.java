package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dim on 2016/6/13.
 */
public class SecondActivity extends Activity{
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text=(TextView)findViewById(R.id.text);
        Intent intent=getIntent();
        String str=intent.getStringExtra("name");
        //int no=intent.getIntExtra("num",-1);
        Toast.makeText(SecondActivity.this, str, Toast.LENGTH_SHORT).show();
        text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent();
                intent.putExtra("答复", "回复的话");
                setResult(2000, intent);
                finish();
            }
        });
        //传递int型时，makeText第二个参数要转换为String类型
        //Toast.makeText(OtherActivity.this, no+"", Toast.LENGTH_LONG).show();
        //char ch=intent.getCharExtra("ch",'0');
        //Toast.makeText(OtherActivity.this, ch+"", Toast.LENGTH_SHORT).show();
    }
}
