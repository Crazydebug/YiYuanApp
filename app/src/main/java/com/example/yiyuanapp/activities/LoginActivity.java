package com.example.yiyuanapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yiyuanapp.activity_manager.BaseActivity;
import com.example.yiyuanapp.R;

public class LoginActivity extends BaseActivity {

    private EditText accountEdit;     //账号
    private EditText passwordEdit;    //密码
    private Button login;              //登录
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = findViewById(R.id.account);
        passwordEdit = findViewById(R.id.password);
        remember = findViewById(R.id.remember_pass);
        boolean isRemember = pref.getBoolean("remember_pass",false);
        if (isRemember){
            //将账号和密码设置到文本框中
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            remember.setChecked(true);
        }
        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password =passwordEdit.getText().toString();
                editor = pref.edit();
                if (remember.isChecked()){
                    editor.putBoolean("remember_pass",true);
                    editor.putString("account",account);
                    editor.putString("password",password);
                }else {
                    editor.clear();
                }
                editor.apply();
                if (account.equals("admin") && password.equals("123456")) {
                    Intent intent = new Intent(LoginActivity.this,SchoolActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"您输入的账号或密码错误!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        getSupportActionBar().hide();
    }
}
