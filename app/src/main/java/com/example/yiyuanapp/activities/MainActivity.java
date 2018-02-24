package com.example.yiyuanapp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.yiyuanapp.activity_manager.BaseActivity;
import com.example.yiyuanapp.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();  //去掉标题栏
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        final Intent intent1 = new Intent(MainActivity.this,LoginActivity.class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                     startActivity(intent1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
