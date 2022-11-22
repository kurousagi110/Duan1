package com.example.duan1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login_Activity extends AppCompatActivity {
    EditText edUserName, edPassword;
    Button btnLogin;
    CheckBox chkRememberPass;
    String strUser, strPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        setTitle("ĐĂNG NHÂP");
        edUserName = findViewById(R.id.edtUsername);
        edPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        chkRememberPass = findViewById(R.id.chkRememberPass);

    }
    public void rememberUser (String U, String P, boolean status) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (!status) {
            //хоа tinh trang luu tru truoc do
            edit.clear();
        } else {
            //luu du lieu
            edit.putString("USERNAME", U);
            edit.putString("PASSWORD", P);
            edit.putBoolean("REMEMBER", status);
        }
        //luu Lai toan bo
        edit.commit();
    }

}