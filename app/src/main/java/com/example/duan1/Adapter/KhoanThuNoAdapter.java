package com.example.duan1.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.DAO.QuanLyNoDAO;
import com.example.duan1.DAO.ThuChiDAO;
import com.example.duan1.Model.QLno;
import com.example.duan1.R;

import java.util.ArrayList;
import java.util.HashMap;

public class KhoanThuNoAdapter extends BaseAdapter {
    private ArrayList<QLno> list;
    private Context context;
    private  QuanLyNoDAO quanLyNoDAO;
    private ArrayList<HashMap<String,Object>> listSpinner;

    public KhoanThuNoAdapter(ArrayList<QLno> list, Context context, QuanLyNoDAO quanLyNoDAO, ArrayList<HashMap<String, Object>> listSpinner) {
        this.list = list;
        this.context = context;
        this.quanLyNoDAO = quanLyNoDAO;
        this.listSpinner = listSpinner;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewOfItem{
        TextView txtTen,txtTien;
        ImageView ivSua,ivXoa;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        ViewOfItem viewOfItem;
        if(view == null){
                view = inflater.inflate(R.layout.item_khoanno,viewGroup,false);
                viewOfItem = new ViewOfItem();
                viewOfItem.txtTen = view.findViewById(R.id.txtTenThuNo);
                viewOfItem.txtTien = view.findViewById(R.id.txtTienThuNo);
                viewOfItem.ivSua = view.findViewById(R.id.ivSuaThuNo);
                viewOfItem.ivXoa = view.findViewById(R.id.ivXoaThuNo);

            view.setTag(viewOfItem);
        }else{
            viewOfItem = (ViewOfItem) view.getTag();
        }
        viewOfItem.txtTen.setText("Tên: "+list.get(i).getTEN());
        viewOfItem.txtTien.setText("Số tiền: "+list.get(i).getSoTien());



//        viewOfItem.ivSua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                showDialogSua(list.get(i));
//            }
//        });
//        viewOfItem.ivXoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int makhoan = list.get(i).getMaKhoan();
//                if(thuChiDAO.deleteKhoanThuChi(makhoan)){
//                    Toast.makeText(context, "xoa thanh cong", Toast.LENGTH_SHORT).show();
//                    reLoadData();
//                }else{
//                    Toast.makeText(context, "xoa that bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        return view;
    }
//    private void showDialogSua(QLno qLno){
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
//        View view = inflater.inflate(R.layout.dialog_suakhoanno,null);
//        Spinner spnLoaiThuNo = view.findViewById(R.id.spnLoaiThuNo);
//        EditText edtTien = view.findViewById(R.id.edt_sua_ten_khoan_no);
//        builder.setView(view);
//
//        SimpleAdapter adapter = new SimpleAdapter(
//                context,
//                listSpinner,
//                android.R.layout.simple_list_item_1,
//                new String[]{"tenloai"},
//                new int[]{android.R.id.text1}
//        );
//        spnLoaiThuNo.setAdapter(adapter);
//
//        edtTien.setText(String.valueOf(qLno.getSoTien()));
//        int index = 0;
//        int vitri = -1;
//        for(HashMap<String,Object> item : listSpinner){
//            if((int)item.get("Ten") == qLno.getTEN())
//                vitri = index;
//            index++;
//        }
//        spnLoaiThuNo.setSelection(vitri);
//
//        builder.setPositiveButton("Cập nhật", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                String tien =edtTien.getText().toString();
//                HashMap<String,Object> selected = (HashMap<String, Object>) spnLoaiThuNo.getSelectedItem();
//                int maloai = (int) selected.get("maloai");
//                khoanThuChi.setTien(Integer.parseInt(tien));
//                khoanThuChi.setMaLoai(maloai);
//                if(thuChiDAO.updateKhoanThuChi(khoanThuChi)){
//                    Toast.makeText(context, "cap nhat thanh cong", Toast.LENGTH_SHORT).show();
//                    reLoadData();
//                }else{
//                    Toast.makeText(context, "That bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
    private void reLoadData(){
        list.clear();
        list = quanLyNoDAO.getDsQuanLyNo("no");
        notifyDataSetChanged();
    }
}
