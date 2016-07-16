package com.example.multiautocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private MultiAutoCompleteTextView mactextview;
    private String[] str={"ab","ac","ad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mactextview=(MultiAutoCompleteTextView)findViewById(R.id.multiautocomplete);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
        mactextview.setAdapter(adapter);
        mactextview.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
