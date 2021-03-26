package com.example.ex2_week3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edDate, edTime;
    private Button btDate, btTime;
    private int mday, mMonth, mYear, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btDate.setOnClickListener(this);
        btTime.setOnClickListener(this);
    }

    private void initView() {
        edDate = findViewById(R.id.txtDate);
        edTime = findViewById(R.id.txtTime);
        btDate = findViewById(R.id.btDate);
        btTime = findViewById(R.id.btTime);

    }

    @Override
    public void onClick(View v) {
        if(v==btDate){
            Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mday = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int y,
                                      int m, int day) {
                    edDate.setText(day+"/"+(m+1)+"/"+y);
                }
            },mYear, mMonth, mday);
            dialog.show();
        }
        if(v==btTime){
            Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR);
            mMinute = c.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hour, int minute) {
                    edTime.setText(hour+":"+minute);
                }
            }, mHour, mMinute, false);
            dialog.show();
        }
    }
}