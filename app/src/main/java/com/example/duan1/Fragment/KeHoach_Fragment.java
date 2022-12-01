package com.example.duan1.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duan1.Adapter.KeHoachAdapter;
import com.example.duan1.Adapter.LoaiChiAdapter;
import com.example.duan1.DAO.ThuChiDAO;
import com.example.duan1.Model.KhoanThuChi;
import com.example.duan1.Model.Loai;
import com.example.duan1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class KeHoach_Fragment extends Fragment {
    ListView listViewKeHoach;
    FloatingActionButton floatAddKeHoach;
    KeHoachAdapter keHoachAdapter;
    ArrayList<KhoanThuChi> list;
    ThuChiDAO thuChiDAO;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ke_hoach,container,false);

        listViewKeHoach = view.findViewById(R.id.listViewKeHoach);
        floatAddKeHoach= view.findViewById(R.id.floatAddKeHoach);
        thuChiDAO = new ThuChiDAO(getContext());
        loadData();

        floatAddKeHoach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDiaLogThem();
            }
        });
        return view;
    }
    //    private int soTK(){
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("THUTHU", Context.MODE_PRIVATE);
//        int soTK = sharedPreferences.getInt("soTK", 0);
//        return soTK;
//    }
    private void loadData(){
        list = thuChiDAO.getDSKhoanThuChi("thu");

        keHoachAdapter = new KeHoachAdapter(list,getContext(),thuChiDAO);
        listViewKeHoach.setAdapter(keHoachAdapter);
    }
    private void showDiaLogThem(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_kehoach,null);
        EditText edtTenMucKeHoach = view.findViewById(R.id.edtTenMucKeHoach);
        EditText edtTien = view.findViewById(R.id.edtTien);
        builder.setView(view);

        builder.setPositiveButton("Them", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String tenloai = edtTenMucKeHoach.getText().toString();
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
