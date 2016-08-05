package com.example.zyj.submenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        SubMenu sm1 = menu.addSubMenu("file");
//        SubMenu sm2 = menu.addSubMenu("edit");
//        sm1.add(1, 1, 1, "item1");
//        sm1.add(1, 2, 1, "item2");
//        sm1.add(1, 3, 1, "item3");
//        sm1.setHeaderTitle("File");
//        sm1.setHeaderIcon(R.mipmap.ic_launcher);
//        sm2.add(2, 1, 1, "item1");
//        sm2.add(2, 2, 1, "item2");
//        sm2.add(2, 3, 1, "item3");
//        sm2.setHeaderTitle("Edit");
//        sm2.setHeaderIcon(R.mipmap.ic_launcher);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getGroupId() == 1 ) {
            switch (item.getItemId()) {
                case 1:
                    Toast.makeText(MainActivity.this, "item1", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(MainActivity.this, "item2", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(MainActivity.this, "item3", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (item.getGroupId() == 2) {
            Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
