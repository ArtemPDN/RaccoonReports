package com.artempdn.raccoonreports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.artempdn.raccoonreports.adapter.ModuleAdapter;
import com.artempdn.raccoonreports.module.Module;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ModuleAdapter moduleAdapter;
    RecyclerView recyclerView;
    List<Module> moduleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moduleList.add(new Module(1,"ОМСУ","Поиск нарушения\nсроков","omsu","#E04F5F"));
        moduleList.add(new Module(2,"ОМСУ","Список ОМСУ\nотправляющие сведения","omsu","#E04F5F"));
        moduleList.add(new Module(3,"ОМСУ","Количество\nприсланных сведений","omsu","#E04F5F"));

        moduleList.add(new Module(4,"Бухгалтерия","Список бланков\n","buh","#6089F6"));
        moduleList.add(new Module(5,"Бухгалтерия","Бланки у нотариусов\n","buh","#6089F6"));
        moduleList.add(new Module(6,"Бухгалтерия","Уничтожение\nиспорченных бланков","buh","#6089F6"));
        moduleList.add(new Module(7,"Бухгалтерия","Данные из стат. отчета\n","buh","#6089F6"));

        moduleList.add(new Module(8,"Отдел кадров","Список нотариусов\n","clerk","#FFD279"));
        moduleList.add(new Module(9,"Отдел кадров","Список ВРИО\n","clerk","#FFD279"));
        moduleList.add(new Module(10,"Отдел кадров","Подсчет лет\n","clerk","#FFD279"));

        setModuleRecycler(moduleList);
    }

    private void setModuleRecycler(List<Module> moduleList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView = findViewById(R.id.moduleRecycler);
        recyclerView.setLayoutManager(layoutManager);
        moduleAdapter = new ModuleAdapter(this,moduleList);
        recyclerView.setAdapter(moduleAdapter);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this,activity_settings.class);
        startActivity(intent);
    }
}