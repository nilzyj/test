package bbk.example.zyj.datapicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private DatePicker mDatePicker;
    private TimePicker mTimePicker;
    private Calendar mCalendar;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取日历的对象
        mCalendar = Calendar.getInstance();
        //获取年月日时分秒的信息
        year = mCalendar.get(Calendar.YEAR);
        month = mCalendar.get(Calendar.MONTH) + 1;//获得的月份以0开始
        day = mCalendar.get(Calendar.DAY_OF_MONTH);
        hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        minute = mCalendar.get(Calendar.MINUTE);

        setTitle(year + "-" + month + "-" + day + "-" + hour + ":" + minute);

        mDatePicker = (DatePicker) findViewById(R.id.datePicker);
        mTimePicker = (TimePicker) findViewById(R.id.timePicker);

        //DatePicker初始化
        mDatePicker.init(year, mCalendar.get(Calendar.MONTH), day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                setTitle(i + "-" + (i1 + 1) + "-" + i2);
            }
        });

        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                setTitle(i + ":" +i1);
            }
        });

        new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                setTitle(i + "-" + (i1 + 1) + "-" + i2);
            }
        }, year, mCalendar.get(Calendar.MONTH), day).show();

        new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                setTitle(i + ":" +i1);
            }
        }, hour, minute, true).show();
    }
}
