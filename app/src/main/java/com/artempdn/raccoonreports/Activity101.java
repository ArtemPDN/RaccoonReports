package com.artempdn.raccoonreports;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.artempdn.raccoonreports.OtherClass.MyDatePicker;

import java.util.Calendar;

public class Activity101 extends AppCompatActivity {

    private Button btnDatePickerBegin;
    private EditText editTextDateBegin;
    // делаем переменные даты/времени полями, т.к. в реальных
    // приложениях они чаще всего используются и в других местах.
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_101);

        btnDatePickerBegin = findViewById(R.id.btn_date_Activity101_Begin);
        editTextDateBegin = findViewById(R.id.editTextDateActivity101Begin);

        btnDatePickerBegin.setOnClickListener(this::onClick);

    }

    //@Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_date_Activity101_Begin:
                // вызываем диалог с выбором даты
                MyDatePicker datePicker = new MyDatePicker(this);
                Log.d("strDateA = ",datePicker.getStrDate());
                String str = datePicker.getStrDate();
                Log.e("strDate = ",str);
                Log.e("Day = ",String.valueOf(datePicker.getmDay()));
                Log.e("Month = ",String.valueOf(datePicker.getmMonth()));
                Log.e("Year = ",String.valueOf(datePicker.getmYear()));
                editTextDateBegin.setText("123");
                editTextDateBegin.setText(str);
                break;

        }
    }

}