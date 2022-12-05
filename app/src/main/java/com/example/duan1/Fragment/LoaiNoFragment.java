package com.example.duan1.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.Adapter.LoaiNoAdapter;
import com.example.duan1.DAO.QuanLyNoDAO;
import com.example.duan1.Model.Loai;
import com.example.duan1.Model.QLno;
import com.example.duan1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LoaiNoFragment extends Fragment {
    ListView listViewLoaiThuNo;
    FloatingActionButton floatAddLoaiNo;
    LoaiNoAdapter loaiNoAdapter;
    ArrayList<QLno> list;
    QuanLyNoDAO quanLyNoDAO;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loaino,container,false);

        listViewLoaiThuNo = view.findViewById(R.id.listViewLoaiThuNo);
       floatAddLoaiNo = view.findViewById(R.id.floatAddLoaiNo);

         quanLyNoDAO = new QuanLyNoDAO(getContext());
        loadData();

        floatAddLoaiNo.setOnClickListener(new View.OnClickListener() {@Override
           public void onClick(View v) {
               showDiaLogThem();
           }
        });
        return view;
    }

    private void loadData(){
        list = quanLyNoDAO.getDsQuanLyNo("no");

        loaiNoAdapter = new LoaiNoAdapter(list,getContext(),quanLyNoDAO);
        listViewLoaiThuNo.setAdapter(loaiNoAdapter);
    }
    private void showDiaLogThem(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_themloaino,null);
        EditText edtTen = view.findViewById(R.id.edtTenNo);
        EditText edtSoTien = view.findViewById(R.id.edtSoTienNo);
        EditText edtDaTra = view.findViewById(R.id.edtDaTra);
        EditText edtConLai = view.findViewById(R.id.edtSoDu);

        builder.setView(view);

        builder.setPositiveButton("Them", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String ten = edtTen.getText().toString();
                String sotien = edtSoTien.getText().toString();
                String datra = edtDaTra.getText().toString();
                String conlai = edtConLai.getText().toString();
                QLno noThem = new QLno(ten,"no");
                if(quanLyNoDAO.addLoaino(noThem)){
                    Toast.makeText(getContext(), "Them thanh cong", Toast.LENGTH_SHORT).show();
                    loadData();
                }else {
                    Toast.makeText(getContext(), "Them khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("huy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}