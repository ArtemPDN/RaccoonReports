package com.artempdn.raccoonreports.OtherClass;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public final class MyDatePicker {

    int mYear,mMonth,mDay;
    private String strDate="";
    private EditText mEditText;

    public MyDatePicker(Context context01, EditText view) {
        mEditText = view;
        callDatePicker(context01);
    }

    private String setStrDate(int dayOfMonth, int monthOfYear, int year) {
        String strDateTempMonth;
        String strDateTempDay;
        if((monthOfYear + 1)>=10){
            strDateTempMonth = String.valueOf((monthOfYear + 1));
        }else{
            strDateTempMonth = "0" + String.valueOf((monthOfYear + 1));
        }
        if(dayOfMonth>=10){
            strDateTempDay = String.valueOf(dayOfMonth);
        }else{
            strDateTempDay = "0" + String.valueOf(dayOfMonth);
        }
        String str = strDateTempDay + "." + strDateTempMonth + "." + String.valueOf(year);
        return str;
    }

    public String getStrDate() { return strDate; }

    public int getmYear() { return mYear; }

    public int getmMonth() { return mMonth; }

    public int getmDay() { return mDay; }

    private void callDatePicker(Context context) {
        // получаем текущую дату
        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        // инициализируем диалог выбора даты текущими значениями
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mDay = dayOfMonth;
                        mMonth = (monthOfYear + 1);
                        mYear = year;
                        mEditText.setText(setStrDate(mDay,mMonth,mYear));
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

}
