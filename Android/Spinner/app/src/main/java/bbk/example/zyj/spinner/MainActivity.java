package bbk.example.zyj.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ScrollingTabContainerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Spinner mSpinner;
    private List<String> mStringList;
    private ArrayAdapter<String> mStringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mSpinner = (Spinner) findViewById(R.id.spinner);

        mTextView.setText("choose:北京");

        // 1.设置数据源
        mStringList = new ArrayList<String>();
        mStringList.add("北京");
        mStringList.add("上海");
        mStringList.add("广州");
        mStringList.add("深圳");

        // 2.新建ArrayAdapter (数组适配器)
        mStringArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, mStringList);

        // 3.设置下拉列表样式
        mStringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 4.spinner加载适配器
        mSpinner.setAdapter(mStringArrayAdapter);

        // 5.spinner设置监听器
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String city = mStringArrayAdapter.getItem(i);
//                String city = mStringList.get(i);
                mTextView.setText("choose:" + city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
