package com.artempdn.raccoonreports.module;

import android.graphics.Color;

public class Module {
    int id;
    String strTitle,strNameImage,strDepartment;
    String colorBG;

    public Module(int id,String strDepartment, String strTitle, String strNameImage, String colorBG) {
        this.id = id;
        this.strDepartment = strDepartment;
        this.strTitle = strTitle;
        this.strNameImage = strNameImage;
        this.colorBG = colorBG;
    }

    public int getId() {
        return id;
    }

    public String getStrTitle() {
        return strTitle;
    }

    public String getStrNameImage() {
        return strNameImage;
    }

    public String getColorBG() {
        return colorBG;
    }

    public String getStrDepartment() { return strDepartment; }
}
