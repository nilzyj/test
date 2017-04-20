package com.example.zyj.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;

    String[] single_list = {"boy", "girl", "zyj"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEvent();
    }

    private void initEvent() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog1();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog2();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog3();
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog4();
            }
        });
    }

    private void showDialog1() {
//        选择对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确认对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("确认对话框提示内容");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "accept", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();
    }

    private void showDialog2() {
//        单选对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("title");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, single_list[i], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialog3() {
//        多选对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("title");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(single_list, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b) {
                    Toast.makeText(MainActivity.this, "1" + single_list[i], Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "2" + single_list[i], Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    private void showDialog4() {
//        列表对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("title");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(single_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, single_list[i], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
