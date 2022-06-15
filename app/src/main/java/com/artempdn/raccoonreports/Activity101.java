package com.artempdn.raccoonreports;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

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

        btnDatePickerBegin = (Button) findViewById(R.id.btn_date_Activity101_Begin);
        editTextDateBegin = (EditText) findViewById(R.id.editTextDateActivity101Begin);

        btnDatePickerBegin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_date_Activity101_Begin:
                // вызываем диалог с выбором даты
                callDatePicker();
                break;

        }
    }

    private void callDatePicker() {
        // получаем текущую дату
        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        // инициализируем диалог выбора даты текущими значениями
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        editTextDateBegin.setText(editTextDateParam);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}