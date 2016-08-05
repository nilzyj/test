package com.example.zyj.toastwithimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this, "toast with image", Toast.LENGTH_SHORT);
                LinearLayout linearLayout = (LinearLayout) toast.getView();
                ImageView iv = new ImageView(MainActivity.this);
                iv.setImageResource(R.mipmap.ic_launcher);
                linearLayout.addView(iv);
//        图片在文字上方
//        linearLayout.addView(iv, 0);
                toast.show();
                /**
                 * 自定义Toast
                 * LayoutInflater inflater = LayoutInflater.from(Mainactivity.this);
                 * View view = inflater.inflate(R.layout.toast_layout, null);
                 * Toast toast = new Toast(MainActivity.this);
                 * toast.setView(view);
                 * toast.show();
                 */
            }
        });
    }
}
