package com.example.duan1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.duan1.R;

public class TaiKhoan_Fragment extends Fragment {
TextView txtSoTK,txtTenTaiKhoan,txtDoiMatKhau,txtDangXuat;
    public TaiKhoan_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tai_khoan_, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtSoTK = view.findViewById(R.id.txtSoTK);
        txtTenTaiKhoan = view.findViewById(R.id.txtTenTaiKhoan);
        txtDoiMatKhau = view.findViewById(R.id.txtDoiMatKhau);
        txtDangXuat = view.findViewById(R.id.txtDangXuat);


    }
}