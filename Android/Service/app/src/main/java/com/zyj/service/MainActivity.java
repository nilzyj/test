package com.zyj.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent1;
    Intent intent2;
    MyBindService service;
    ServiceConnection conn = new ServiceConnection() {

        @Override//当服务跟启动源意外断开的时候 会自动回调
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override//当服务跟启动源连接的时候 会自动回调
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service = ((MyBindService.MyBinder)binder).getService();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View v){
        switch (v.getId()) {
            case R.id.start:
                intent1 = 	new Intent(MainActivity.this, MyStartService.class);
                startService(intent1);
                break;

            case R.id.stop:
                stopService(intent1);
                break;
            case R.id.play:
                service.Play();
                break;
            case R.id.pause:
                service.Pause();
                break;
            case R.id.pervious:
                service.Pervious();
                break;
            case R.id.next:
                service.next();
                break;
            case R.id.bind:
                intent2 = new Intent(MainActivity.this, MyBindService.class);
                startService(intent2);
                bindService(intent2, conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(conn);
                break;
        }
    }
    @Override
    protected void onDestroy() {
        stopService(intent2);
        unbindService(conn);
        super.onDestroy();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
