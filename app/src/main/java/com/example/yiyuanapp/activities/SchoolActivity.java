package com.example.yiyuanapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yiyuanapp.activity_manager.ActivityCollector;
import com.example.yiyuanapp.activity_manager.BaseActivity;
import com.example.yiyuanapp.R;

import java.util.ArrayList;
import java.util.List;

public class SchoolActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    private List<String> sheng_list;
    private List<String> school_list;
    private Button yes;
    private Button no;
    private Spinner choose_sheng;
    private Spinner choose_school;
    private ArrayAdapter<String> sheng_adapter;
    private ArrayAdapter<String> school_adapter;
    public String final_sheng;
    public String final_school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        getSupportActionBar().hide();
        choose_sheng = findViewById(R.id.sheng_spinner);
        initSheng();
        sheng_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,sheng_list);
        sheng_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choose_sheng.setAdapter(sheng_adapter);
        choose_school = findViewById(R.id.school_spinner);
        choose_sheng.setOnItemSelectedListener(this);
        yes = findViewById(R.id.yes_button);
        no = findViewById(R.id.no_button);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (final_sheng.equals("山西")){
                    Intent intent = new Intent(SchoolActivity.this,StartActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(SchoolActivity.this,"选择有误请重新选择！",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void initSheng(){
         sheng_list = new ArrayList<>();
         sheng_list.add("山西");
         sheng_list.add("北京");
         sheng_list.add("上海");
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String sheng_name = sheng_adapter.getItem(i);
        final_sheng = new String(sheng_name);
        switch (sheng_name){
            case "山西":
                initShanXiSchool();
                school_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,school_list);
                school_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                choose_school.setAdapter(school_adapter);
                break;
            case "北京":
                initBeiJingSchool();
                school_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,school_list);
                school_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                choose_school.setAdapter(school_adapter);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void initShanXiSchool(){
        school_list = new ArrayList<>();
        school_list.add("中北大学");
        school_list.add("山西大学");
        school_list.add("太原理工大学");
    }

    public void initBeiJingSchool(){
        school_list = new ArrayList<>();
        school_list.add("北京大学");
        school_list.add("清华大学");
        school_list.add("北京理工大学");
    }
}
