package com.example.yiyuanapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yiyuanapp.R;
import com.example.yiyuanapp.activity_manager.ActivityCollector;
import com.example.yiyuanapp.activity_manager.BaseActivity;

public class StartActivity extends BaseActivity implements View.OnClickListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    ImageView menu;
    ImageView exit;
    private Button zixi_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav);
        menu = findViewById(R.id.blue_menu);
        exit = findViewById(R.id.back);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
            }
        });
        View headerView = navigationView.getHeaderView(0);
        menu.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(StartActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        zixi_button = findViewById(R.id.zixi_study);
        zixi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(StartActivity.this,LocationActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }


    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.blue_menu:
                 if (drawerLayout.isDrawerOpen(navigationView)){
                     drawerLayout.closeDrawer(navigationView);
                 }else {
                     drawerLayout.openDrawer(navigationView);
                 }
                 break;
         }
    }
}
