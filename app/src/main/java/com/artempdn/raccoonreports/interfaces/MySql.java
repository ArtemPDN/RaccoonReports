package com.artempdn.raccoonreports.interfaces;

public interface MySql {
    public boolean connect(String url,String baseName,int port,String login, String pass);
    public boolean disconnect();
    public boolean connectTest(String url,String baseName,int port,String login, String pass);
}
