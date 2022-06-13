package com.artempdn.raccoonreports;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.artempdn.raccoonreports.mysql.DataBase;


public class activity_settings extends AppCompatActivity {

    EditText editTextHost,editTextDataBaseName,editTextPort,editTextLogin,editTextPassword;

    //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity_settings.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
         editTextHost = findViewById(R.id.editTextHost);
         editTextDataBaseName = findViewById(R.id.editTextDataBaseName);
         editTextPort = findViewById(R.id.editTextPort);
         editTextLogin = findViewById(R.id.editTextLogin);
         editTextPassword = findViewById(R.id.editTextPassword);


        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if(sh.contains("HOST")) editTextHost.setText(sh.getString("HOST", ""));
        if(sh.contains("DataBase")) editTextDataBaseName.setText(sh.getString("DataBase", ""));
        if(sh.contains("Port")) editTextPort.setText(String.valueOf(sh.getInt("Port", 3306)));
        if(sh.contains("Login")) editTextLogin.setText(sh.getString("Login", ""));
        if(sh.contains("Password")) editTextPassword.setText(sh.getString("Password", ""));
        /*
        Log.d("HOST", "HOST = " + sh.getString("HOST","STANDART"));
        Log.d("DataBase","DataBase = " + sh.getString("DataBase","STANDART"));
        Log.d("Port","Port = " + sh.getInt("Port", 3333));
        Log.d("Login","Login = " + sh.getString("Login","STANDART"));
        Log.d("Password","Password = " + sh.getString("Password","STANDART"));
         */
    }

    public void saveSettings(View view){


        if(editTextHost.getText().toString().isEmpty()){
            Toast.makeText(this,"Строка HOST пуста! :",Toast.LENGTH_LONG).show();
            return;
        }
        if(editTextDataBaseName.getText().toString().isEmpty()){
            Toast.makeText(this,"Строка DataBase пуста! :",Toast.LENGTH_LONG).show();
            return;
        }
        if(editTextPort.getText().toString().isEmpty()){
            Toast.makeText(this,"Строка Port пуста! :",Toast.LENGTH_LONG).show();
            return;
        }
        if(editTextLogin.getText().toString().isEmpty()){
            Toast.makeText(this,"Строка Login пуста! :",Toast.LENGTH_LONG).show();
            return;
        }
        if(editTextPassword.getText().toString().isEmpty()){
            Toast.makeText(this,"Строка Password пуста! :",Toast.LENGTH_LONG).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("HOST", editTextHost.getText().toString());
        editor.commit();
        editor.putString("DataBase", editTextDataBaseName.getText().toString());
        editor.commit();
        try{
            int port = Integer.parseInt(editTextPort.getText().toString());
            editor.putInt("Port",port);
            editor.commit();
        }
        catch (NumberFormatException ex){
            editor.putInt("Port",3306);
            editor.commit();
        }
        editor.putString("Login", editTextLogin.getText().toString());
        editor.commit();
        editor.putString("Password", editTextPassword.getText().toString());
        editor.commit();

        Toast.makeText(this,"Настройки сохранены",Toast.LENGTH_LONG).show();

    }

    public void testConnection(View view){


        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        String strHost = sh.getString("HOST", "localhost");
        String strBaseName = sh.getString("DataBase", "TestNameBase");
        int port = sh.getInt("Port", 3306);
        String strLogin = sh.getString("Login", "root");
        String strPass = sh.getString("Password", "123");

        DataBase dataBase = new DataBase();
        dataBase.setStrHost(strHost);
        dataBase.setStrNameBase(strBaseName);
        dataBase.setPort(port);
        dataBase.setStrUser(strLogin);
        dataBase.setStrPass(strPass);
        dataBase.setBlTestConnect(true);
        dataBase.start();
        try {
            Thread.sleep(1000); //Приостанавливает поток на 1 секунду
        } catch (Exception e) {

        }
        if(dataBase.isBlRezultTestConnect()){
            Toast.makeText(this,"Подключение успешно",Toast.LENGTH_LONG).show();
            dataBase.interrupt();
        }else{
            Toast.makeText(this,"Подключение не успешно",Toast.LENGTH_LONG).show();
            dataBase.interrupt();
        }


    }

}