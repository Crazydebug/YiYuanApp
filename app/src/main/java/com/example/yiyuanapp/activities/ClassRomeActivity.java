package com.example.yiyuanapp.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yiyuanapp.Adapter.ClassRomeAdapter;
import com.example.yiyuanapp.BaseClass.ClassRome;
import com.example.yiyuanapp.R;
import com.example.yiyuanapp.activity_manager.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ClassRomeActivity extends BaseActivity {

    private List<ClassRome> classlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_rome);
        initClassRomes();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ClassRomeAdapter adapter = new ClassRomeAdapter(classlist);
        recyclerView.setAdapter(adapter);
    }

    private void initClassRomes(){
        for (int i = 0; i < 15; i++) {
            ClassRome place = new ClassRome("中北大学教学楼"+(i+1));
            classlist.add(place);
        }
    }
}
