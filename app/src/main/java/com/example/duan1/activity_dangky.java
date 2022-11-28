package com.example.duan1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.DAO.TaiKhoanDAO;
import com.example.duan1.Model.TaiKhoan;

public class activity_dangky extends AppCompatActivity {
    EditText edtUserdk, edtPassdk;
    Button  buttondk;
    TaiKhoan taiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        edtUserdk = findViewById(R.id.edtUsername);
        edtPassdk = findViewById(R.id.edtPassword);
        buttondk = findViewById(R.id.btnDangKy);
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO(this);
        taiKhoan = new TaiKhoan();

        buttondk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edtUserdk.getText().toString();
                String matkhau = edtPassdk.getText().toString();
                taiKhoan.setTaiKhoan(taikhoan);
                taiKhoan.setMatKhau(matkhau);

                boolean checkDK = taiKhoanDAO.insert(taiKhoan);
                if(checkDK==true) {
                    Toast.makeText(activity_dangky.this, "thanh cong", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(activity_dangky.this, "khong thanh cong", Toast.LENGTH_SHORT).show();
                    return;
                    }

                }
        });

    }

}

