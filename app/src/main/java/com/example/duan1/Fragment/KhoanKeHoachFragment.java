package com.example.duan1.Fragment;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.duan1.Adapter.KhoanKeHoachAdapter;
import com.example.duan1.DAO.ThuChiDAO;
import com.example.duan1.Model.KhoanThuChi;
import com.example.duan1.Model.Loai;
import com.example.duan1.MyAlarm;
import com.example.duan1.MyBroadcast;
import com.example.duan1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class KhoanKeHoachFragment extends Fragment {
    ListView listViewKhoanKeHoach;
    ArrayList<KhoanThuChi> list;
    ThuChiDAO thuChiDAO;
    ArrayList<HashMap<String,Object>> listSpinner;
    KhoanKeHoachAdapter adapter;
    Calendar calendar;
    AlarmManager am;
    PendingIntent pi;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_khoankehoach,container,false);

        listViewKhoanKeHoach = view.findViewById(R.id.listViewKhoanKeHoach);
        FloatingActionButton floatAdd = view.findViewById(R.id.floatAddKhoanKeHoach);

        Intent i = new Intent(getContext(), MyAlarm.class);
        pi = PendingIntent.getBroadcast(getContext(), 0, i, 0);
        MyBroadcast broadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter("com.example");
        getContext().registerReceiver(broadcast, intentFilter);


        thuChiDAO = new ThuChiDAO(getContext());
        getData();

        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogThem();
            }
        });

        return view;
    }
    private void getData(){
        list = thuChiDAO.getDSKhoanThuChi("kehoach");

        adapter = new KhoanKeHoachAdapter(list,getContext(),thuChiDAO,getDataSpinner());
        listViewKhoanKeHoach.setAdapter(adapter);
    }
    private void showDialogThem(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_themkhoankehoach,null);
        Spinner spnLoaiKeHoach = view.findViewById(R.id.spnLoaiKeHoach);
        EditText edtTienKeHoachen = view.findViewById(R.id.edtTienKeHoach);
        EditText edtNgayChon = view.findViewById(R.id.edtChonngay);

        Calendar calendar = Calendar.getInstance();

        edtNgayChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int i, int i1, int i2) {
                        String ngay = "";
                        String thang = "";
                        calendar.clear();
                        calendar.set(Calendar.YEAR, i);
                        calendar.set(Calendar.MONTH, i1);
                        calendar.set(Calendar.DAY_OF_MONTH, i2);
                        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {


                                //SetTime
                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);


                                am =(AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

                                am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
                            }

                        };
                        //5
                        new TimePickerDialog(getContext(), timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
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
                        edtNgayChon.setText(i+"/"+thang+"/"+ngay);
                    }
                },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        builder.setView(view);
        SimpleAdapter adapter = new SimpleAdapter(
                getContext(),
                getDataSpinner(),
                android.R.layout.simple_list_item_1,
                new String[]{"tenloai"},
                new int[]{android.R.id.text1}
        );
        builder.setPositiveButton("thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String tien = edtTienKeHoachen.getText().toString();
                String ngay = edtNgayChon.getText().toString();
                HashMap<String,Object> selected = (HashMap<String, Object>) spnLoaiKeHoach.getSelectedItem();
                int maloai = (int) selected.get("maloai");
                KhoanThuChi khoanThuChi = new KhoanThuChi(Integer.parseInt(tien),maloai,ngay);
                if(thuChiDAO.addKhoanThuChi(khoanThuChi)){
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    getData();
                }else{
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        spnLoaiKeHoach.setAdapter(adapter);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private ArrayList<HashMap<String,Object>> getDataSpinner(){
        ArrayList<Loai> listLoai = thuChiDAO.getDsLoaiThuChi("kehoach");
        listSpinner = new ArrayList<>();

        for(Loai loai : listLoai){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("maloai",loai.getMaLoai());
            hashMap.put("tenloai",loai.getTenLoai());
            listSpinner.add(hashMap);
        }
        return listSpinner;
    }
//    private int soTK(){
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("THUTHU", Context.MODE_PRIVATE);
//        int soTK = sharedPreferences.getInt("soTK", 0);
//        return soTK;
//    }

    private void showDateTimeDialog() {


        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                //3 Set DATE
                calendar.clear();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {


                        //SetTime
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);


                        am =(AlarmManager)getContext().getSystemService(Context.ALARM_SERVICE);
//                        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
                        am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
                    }

                };
                //5
                new TimePickerDialog(getActivity(), timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
            }
        };

        new DatePickerDialog(getActivity(), dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}
