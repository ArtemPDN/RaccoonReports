package com.artempdn.raccoonreports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

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

        moduleList.add(new Module(1,"Название номер 1","dbconn","#E04F5F"));
        moduleList.add(new Module(2,"Название номер 2","dbnotconn","#6089F6"));
        setModuleRecycler(moduleList);
    }

    private void setModuleRecycler(List<Module> moduleList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView = findViewById(R.id.moduleRecycler);
        recyclerView.setLayoutManager(layoutManager);
        moduleAdapter = new ModuleAdapter(this,moduleList);
        recyclerView.setAdapter(moduleAdapter);
    }
}