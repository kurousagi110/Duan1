package com.example.duan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1.R;

public class Login_Activity extends AppCompatActivity {
    IntentFilter intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        EditText edtUser = findViewById(R.id.edtUsername);
        EditText edtPass = findViewById(R.id.edtPassword);
        Button bntLogin = findViewById(R.id.btnLogin);

        intentFilter = new IntentFilter();
        intentFilter.addAction("KiemTraDangNhap");


        bntLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();

                Intent intent = new Intent( Login_Activity.this, KiemTraDangNhap.class);
                Bundle bundle = new Bundle();
                bundle.putString("user", user);
                bundle.putString("pass", pass);
                intent.putExtras(bundle);
                startService(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    public BroadcastReceiver myBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {// nhan data

            switch (intent.getAction()){
                case "KiemTraDangNhap":
                    Bundle bundle = intent.getExtras();
                    boolean check  = bundle.getBoolean("check");
                    if(check){
                        startActivity(new Intent(Login_Activity.this, MainActivity.class));
                    }else {
                        Toast.makeText(context, "Dang nhap khong thanh cong",Toast.LENGTH_LONG);
                    }
                    break;
                default:
                    break;
            }
        }
    };
}
