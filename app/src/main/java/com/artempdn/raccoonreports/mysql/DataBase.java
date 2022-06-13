package com.artempdn.raccoonreports.mysql;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase extends Thread{
    private String strHost;
    private int port;
    private String strNameBase;
    private String strUser;
    private String strPass;
    private boolean blTestConnect;
    private boolean blRezultTestConnect;

    public void setStrHost(String strHost) { this.strHost = strHost; }

    public void setPort(int port) { this.port = port; }

    public void setStrNameBase(String strNameBase) {this.strNameBase = strNameBase; }

    public void setStrUser(String strUser) { this.strUser = strUser; }

    public void setStrPass(String strPass) { this.strPass = strPass; }

    public boolean isBlRezultTestConnect() { return blRezultTestConnect; }

    public boolean isBlTestConnect() { return blTestConnect; }

    public void setBlTestConnect(boolean blTestConnect) { this.blTestConnect = blTestConnect; }

    public boolean testConnect(String strHost,int port,String strNameBase,String strUser,String strPass){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String strPort;
            try {
                strPort = String.valueOf(port);
            }catch (Exception ex){
                strPort = "3306";
            }
            Connection connection = DriverManager.getConnection("jdbc:mysql://"+strHost+":"+strPort+"/"+strNameBase, strUser, strPass);
            connection.close();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public void run() {

        if(blTestConnect){
            Log.d("1","blRezultTestConnect = " + String.valueOf(blRezultTestConnect));
            blRezultTestConnect = testConnect(strHost, port, strNameBase, strUser, strPass);
            Log.d("2","blRezultTestConnect = " + String.valueOf(blRezultTestConnect));
        }

    }
}
