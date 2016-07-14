package com.bbk.zyj.db;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    private final String DB_NAME = "zyjdata.db";//数据库名称
    private final int VERSION = 1;//数据库版本
    private EditText etAddName;
    private EditText etAddPassword;
    private Button btnAdd;
    private EditText etDeleteName;
    private Button btnDelete;
    private EditText etUpdateName;
    private EditText etUpdatePassword;
    private Button btnUpdate;
    private EditText etQueryName;
    private Button btnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAddName = (EditText) findViewById(R.id.et_add_name);
        etAddPassword = (EditText) findViewById(R.id.et_add_password);
        btnAdd = (Button) findViewById(R.id.btn_add);//add
        etDeleteName = (EditText) findViewById(R.id.et_delete_name);
        btnDelete = (Button) findViewById(R.id.btn_delete);//delete
        etUpdateName = (EditText) findViewById(R.id.et_update_name);
        etUpdatePassword = (EditText) findViewById(R.id.et_update_password);
        btnUpdate = (Button) findViewById(R.id.btn_update);//update
        etQueryName = (EditText) findViewById(R.id.et_query_name);
        btnQuery = (Button) findViewById(R.id.btn_query);//query

        DatabaseHelper database = new DatabaseHelper(this,DB_NAME,null,VERSION);
        final SQLiteDatabase db = database.getWritableDatabase();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("username",etAddName.getText().toString());
                cv.put("password",etAddPassword.getText().toString());
                db.insert("user",null,cv);
                etAddName.setText("");
                etAddPassword.setText("");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whereClause = "username=?";
                String whereArgs[] = {etDeleteName.getText().toString()};
                db.delete("user",whereClause,whereArgs);
                etDeleteName.setText("");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("password",etUpdatePassword.getText().toString());
                String whereClause = "username=?";
                String whereArgs[] = {etUpdateName.getText().toString()};
                db.update("user",cv,whereClause,whereArgs);
                etUpdateName.setText("");
                etUpdatePassword.setText("");
            }
        });

        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whereArgs[] = {etQueryName.getText().toString()};
                Cursor cursor = db.query("user",null,"username=?",whereArgs,null,null,null);
                if(cursor.moveToFirst()){
                    String password = cursor.getString(cursor.getColumnIndex("password"));
                    etQueryName.setText(password);
                }
                else
                    etQueryName.setText("null");
            }
        });
    }
}
