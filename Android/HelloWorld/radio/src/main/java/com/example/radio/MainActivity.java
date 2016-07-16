package com.example.radio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text = (TextView) findViewById(R.id.text);
         group=(RadioGroup) findViewById(R.id.sex);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //获取选中radio的ID
                int radioButtonId = group.getCheckedRadioButtonId();
                RadioButton rbtn = (RadioButton) MainActivity.this.findViewById(radioButtonId);
                text.setText(rbtn.getText());
            }
        });
    }
}
