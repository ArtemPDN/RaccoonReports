package com.artempdn.raccoonreports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.artempdn.raccoonreports.OtherClass.MyDatePicker;

import java.lang.ref.WeakReference;

public class Activity101 extends AppCompatActivity {

    private Button btnDatePickerBegin,btnDatePickerEnd;
    private EditText editTextDateBegin,editTextDateEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_101);

        btnDatePickerBegin = findViewById(R.id.btn_date_Activity101_Begin);
        editTextDateBegin = findViewById(R.id.editTextDateActivity101Begin);
        btnDatePickerEnd = findViewById(R.id.btn_date_Activity101_End);
        editTextDateEnd = findViewById(R.id.editTextDateActivity101End);

        btnDatePickerBegin.setOnClickListener(this::onClick);
        btnDatePickerEnd.setOnClickListener(this::onClick);

    }

    //@Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_date_Activity101_Begin:
                // вызываем диалог с выбором даты
                MyDatePicker datePickerBegin = new MyDatePicker(this,editTextDateBegin);
                WeakReference weakReferenceBegin = new WeakReference(datePickerBegin);
                if(!editTextDateBegin.equals("")) datePickerBegin = null;
            break;
            case R.id.btn_date_Activity101_End:
                // вызываем диалог с выбором даты
                MyDatePicker datePickerEnd = new MyDatePicker(this,editTextDateEnd);
                WeakReference weakReferenceEnd = new WeakReference(datePickerEnd);
                if(!editTextDateBegin.equals("")) datePickerEnd = null;
                break;


        }
    }

}