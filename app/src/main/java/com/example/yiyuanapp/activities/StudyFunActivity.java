package com.example.yiyuanapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yiyuanapp.R;
import com.example.yiyuanapp.activity_manager.BaseActivity;

public class StudyFunActivity extends BaseActivity implements View.OnClickListener{

    private Button studymap;
    private Button schoolmap;
    private Button peoplemap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_fun);
        studymap = findViewById(R.id.study_map);
        schoolmap = findViewById(R.id.school_map);
        peoplemap = findViewById(R.id.people_map);
        schoolmap.setOnClickListener(this);
        peoplemap.setOnClickListener(this);
        studymap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.school_map:
                Intent intent1 = new Intent(StudyFunActivity.this,LocationActivity.class);
                startActivity(intent1);
                break;
            case R.id.study_map:

                break;
            case R.id.people_map:

                break;
                default:
        }
    }
}
