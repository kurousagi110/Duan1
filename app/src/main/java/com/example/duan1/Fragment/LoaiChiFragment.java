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

import com.example.duan1.Adapter.LoaiChiAdapter;
import com.example.duan1.Adapter.LoaiThuAdapter;
import com.example.duan1.DAO.ThuChiDAO;
import com.example.duan1.Model.Loai;
import com.example.duan1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LoaiChiFragment extends Fragment {
    ListView listViewLoaiChi;
    FloatingActionButton floatAdd;
    LoaiChiAdapter loaiChiAdapter;
    ArrayList<Loai> list;
    ThuChiDAO thuChiDAO;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loaichi,container,false);

        listViewLoaiChi = view.findViewById(R.id.listViewLoaiChi);
        floatAdd = view.findViewById(R.id.floatAdd);
        thuChiDAO = new ThuChiDAO(getContext());
        loadData();

        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDiaLogThem();
            }
        });
        return view;
    }
    private void loadData(){
        list = thuChiDAO.getDSLoaiThuChi("chi",2);

        loaiChiAdapter = new LoaiChiAdapter(list,getContext(),thuChiDAO);
        listViewLoaiChi.setAdapter(loaiChiAdapter);
    }
    private void showDiaLogThem(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_themloaichi,null);
        EditText edtInput = view.findViewById(R.id.edtInput);
        builder.setView(view);

        builder.setPositiveButton("Them", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String tenloai = edtInput.getText().toString();
                Loai loaiThem = new Loai(tenloai,"chi",2);
                if(thuChiDAO.addLoaiThuChi(loaiThem)){
                    Toast.makeText(getContext(), "Theem thnah cong", Toast.LENGTH_SHORT).show();
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