package bbk.example.zyj.gridview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    private GridView mGridView;
    private List<Map<String, Object>> mMapList;
    private int[] icon = {R.drawable.address_book, R.drawable.calendar, R.drawable.camera
            , R.drawable.clock, R.drawable.games_control, R.drawable.messenger
            , R.drawable.ringtone, R.drawable.settings, R.drawable.speech_balloon
            , R.drawable.weather, R.drawable.world, R.drawable.youtube};
    private String[] iconName = {"通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置"
            , "语音", "天气", "浏览器", "视频"};
    private SimpleAdapter mSimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView = (GridView) findViewById(R.id.gridView);
        /*
         * 1.准备数据源
         * 2.新建适配器(SimpleAdapter)
         * 3.GridViwe加载适配器
         * 4.GridView配置事件监听器(OnItemClickListener)
         */
        mMapList = new ArrayList<Map<String, Object>>();
        mSimpleAdapter = new SimpleAdapter(MainActivity.this, getData(), R.layout.item, new String[] {"image", "text"}, new int[] {R.id.image, R.id.text});
        mGridView.setAdapter(mSimpleAdapter);
        mGridView.setOnItemClickListener(this);
    }

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            mMapList.add(map);
        }

        return mMapList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this, iconName[i], Toast.LENGTH_SHORT).show();
    }
}
