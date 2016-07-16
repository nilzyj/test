package com.example.sharedperference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_register,btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_register=(Button) findViewById(R.id.btn_register);
        btn_login=(Button) findViewById(R.id.btn_login);
        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
                String acc=preferences.getString("r_account", "defaultname");
                String psw=preferences.getString("r_psw", "0");
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("account", acc);
                intent.putExtra("psw", psw);
                startActivity(intent);
            }
        });
    }
}
