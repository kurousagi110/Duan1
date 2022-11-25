package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1.DAO.TaiKhoanDAO;

public class Login_Activity extends AppCompatActivity {
    TaiKhoanDAO taiKhoanDAO;
    CheckBox chkRememberPass;
    EditText edtUser, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPassword);
        chkRememberPass = findViewById(R.id.chkRememberPass);
        Button bntLogin = findViewById(R.id.btnLogin);
        Button bntdangky = findViewById(R.id.btnDANGKY);
        taiKhoanDAO = new TaiKhoanDAO(this);
//        showInfoRem();

        bntdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login_Activity.this, "dd", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login_Activity.this, activity_dangky.class);
                startActivity(intent);
            }
        });

        bntLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edtUser.getText().toString();
                String matkhau = edtPass.getText().toString();
                if (validate(taikhoan, matkhau) == true) {
                    Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                    saveInfo();
                    startActivity(intent);
                    finish();
                } else {

                }
            }
        });
    }

    public void showInfoRem() {
        SharedPreferences sharedPreferences = getSharedPreferences("THUTHU", MODE_PRIVATE);
        SharedPreferences sharedPreferences1preferences = getSharedPreferences("THUTHU", MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau = sharedPreferences.getString("matkhau", "");
        boolean check = sharedPreferences.getBoolean("remember", false);
        edtUser.setText(taikhoan);
        edtPass.setText(matkhau);
        chkRememberPass.setChecked(check);

    }

    public void saveInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("THUTHU", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean ischeck = chkRememberPass.isChecked();
        if (ischeck) {
            editor.putString("taikhoan", edtUser.getText().toString());
            editor.putString("matkhau", edtPass.getText().toString());
            editor.putBoolean("remember", ischeck);
        } else {
            editor.clear();
        }
        editor.commit();
    }

    public boolean validate(String username, String password) {
        boolean check = taiKhoanDAO.checkLogin(username, password);
        if (username.equals("") || password.equals("")) {
            Toast.makeText(this, "nhap ten dang nhap hoac mat khau", Toast.LENGTH_SHORT).show();
            return false;
        } else if (check == false) {
            return false;
        }
        return true;
    }
}
