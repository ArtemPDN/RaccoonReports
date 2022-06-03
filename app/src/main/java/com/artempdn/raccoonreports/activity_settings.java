package com.artempdn.raccoonreports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        if(sh.contains("DataBase")) editTextHost.setText(sh.getString("DataBase", ""));
        //if(sh.contains("Port")) editTextHost.setText(sh.getInt("Port", 3306));
        if(sh.contains("Login")) editTextHost.setText(sh.getString("Login", ""));
        if(sh.contains("Password")) editTextHost.setText(sh.getString("Password", ""));

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
    }


}