package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.duan1.DAO.ThuChiDAO;
import com.example.duan1.Model.KhoanThuChi;
import com.example.duan1.database.DataHelper;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        DataHelper dataHelper = new DataHelper(this);
        ThuChiDAO thuChiDAO = new ThuChiDAO(this);
        ArrayList<KhoanThuChi> list = thuChiDAO.getDSKhoanThuChi("chi",3);
        int a = list.size();
        Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
    }
}