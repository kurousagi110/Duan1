package com.example.duan1.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.Fragment;

import com.example.duan1.R;

import java.util.ArrayList;
import java.util.List;

public class ThongKe_thang_Fragment extends Fragment {
    Spinner spinner;
    public ThongKe_thang_Fragment()
    {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongke_thang,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = view.findViewById(R.id.spinnerThang);
        List<String> thang = new ArrayList<>();
        thang.add("chọn tháng");
        thang.add("1");
        thang.add("2");
        thang.add("3");
        thang.add("4");
        thang.add("5");
        thang.add("6");
        thang.add("7");
        thang.add("8");
        thang.add("9");
        thang.add("10");
        thang.add("11");
        thang.add("12");
        ArrayAdapter<String> thangAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,thang);
        thangAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(thangAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String thangChon =spinner.getSelectedItem().toString();

            }
        });
    }
}
