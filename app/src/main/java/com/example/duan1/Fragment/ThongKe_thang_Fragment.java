package com.example.duan1.Fragment;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.DAO.ThuChiDAO;
import com.example.duan1.Model.ThongKe;
import com.example.duan1.R;


import java.util.ArrayList;
import java.util.Calendar;

public class ThongKe_thang_Fragment extends Fragment  {
    ThuChiDAO thuChiDAO;
    EditText edtNgayBatDau, edtDenNgay;
    Button btnThongKeThang;
    ThongKe thongKe;
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
        thuChiDAO = new ThuChiDAO(getContext());
        edtNgayBatDau = view.findViewById(R.id.edtNgayBatDau);
        edtDenNgay = view.findViewById(R.id.edtDenNgay);
        btnThongKeThang = view.findViewById(R.id.btnThongKeThang);
        Calendar calendar = Calendar.getInstance();
        edtNgayBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int i, int i1, int i2) {
                        String ngay = "";
                        String thang = "";
                        if (i2<10){
                            ngay = "0"+i2;
                        }else {
                            ngay = String.valueOf(i2);
                        }
                        if ((i1+1)<10){
                            thang = "0"+(i1+1);
                        }else {
                            thang = String.valueOf(i1+1);
                        }
                        edtNgayBatDau.setText(i+"/"+thang+"/"+ngay);
                    }
                },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        edtDenNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int i, int i1, int i2) {
                        String ngay = "";
                        String thang = "";
                        if (i2<10){
                            ngay = "0"+i2;
                        }else {
                            ngay = String.valueOf(i2);
                        }
                        if ((i1+1)<10){
                            thang = "0"+(i1+1);
                        }else {
                            thang = String.valueOf(i1+1);
                        }
                        edtDenNgay.setText(i+"/"+thang+"/"+ngay);
                    }
                },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        btnThongKeThang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ngaybatdau = edtNgayBatDau.getText().toString();
                String denngay = edtDenNgay.getText().toString();
//                PieChart mChart = view.findViewById(R.id.chartThongKeTheoThang);
//                mChart.setRotationEnabled(true);
//                mChart.setHoleRadius(35f);
//                mChart.setTransparentCircleAlpha(0);
//                mChart.setDrawEntryLabels(true);
//                addDataSet(mChart, ngaybatdau, denngay);

//                String ngaybatdau = edtNgayBatDau.toString();
//                String denngay = edtDenNgay.toString();
//                thongKe = new ThongKe();
//                thongKe = thuChiDAO.getDoanhThuThang(ngaybatdau,denngay,2);
//
//                PieChart pieChart = view.findViewById(R.id.chartThongKeTheoThang);
//                ArrayList<PieEntry> thuChi = new ArrayList<>();
//                thuChi.add(new PieEntry(thongKe.getThu(),"Khoản Thu"));
//                thuChi.add(new PieEntry(thongKe.getChi(),"Khoản Chi"));
//                PieDataSet pieDataSet = new PieDataSet(thuChi,"Thống Kê Thu Chi");
//                pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//                pieDataSet.setValueTextColor(Color.BLACK);
//                pieDataSet.setValueTextSize(10f);
//
//                Legend legend = pieChart.getLegend();
//                legend.setForm(Legend.LegendForm.CIRCLE);
//
//                PieData pieData = new PieData(pieDataSet);
//
//                pieChart.setData(pieData);
//                pieChart.getDescription().setEnabled(false);
//                pieChart.setCenterText("Thống Kê");
//                pieChart.requestLayout();
//                pieChart.invalidate();
//                pieChart.animate();
            }
        });

    }
//    @Override
//    public void onValueSelected(Entry e, Highlight h) {
//
//    }
//
//    @Override
//    public void onNothingSelected() {
//
//    }
//    private void addDataSet(PieChart pieChart, String ngaybatdau, String denngay) {
//
//        ArrayList<PieEntry> entrys = new ArrayList<>();
//        Integer[] yData = thuChiDAO.getDoanhThuTheoThang(2,ngaybatdau,denngay);
//        String[] xData = {"Khoản thu", "Khoản chi"};
//        for (int i = 0; i < yData.length; i++) {
//            entrys.add(new PieEntry(yData[i], xData[i]));
//        }
//
//        PieDataSet pieDataSet = new PieDataSet(entrys, " ");
//        pieDataSet.setSliceSpace(2);
//        pieDataSet.setValueTextSize(10);
//        ArrayList<Integer> colors = new ArrayList<>();
//        colors.add(Color.BLUE);
//        colors.add(Color.RED);
//        pieDataSet.setColors(colors);
//        Legend legend = pieChart.getLegend();
//        legend.setForm(Legend.LegendForm.CIRCLE);
//        PieData pieData = new PieData(pieDataSet);
//        pieChart.setData(pieData);
//        pieChart.requestLayout();
//        pieChart.invalidate();
//        pieChart.animate();
//    }


}
