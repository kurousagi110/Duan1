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
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.DAO.QuanLyNoDAO;
import com.example.duan1.DAO.ThuChiDAO;
import com.example.duan1.Model.Loai;
import com.example.duan1.Model.QLno;
import com.example.duan1.R;

import java.util.ArrayList;

public class LoaiNoAdapter extends BaseAdapter {
    private final com.example.duan1.DAO.QuanLyNoDAO QuanLyNoDAO;
    private ArrayList<QLno> list;
    private Context context;
    private QuanLyNoDAO quanlynoDao;

    public LoaiNoAdapter(ArrayList<QLno> list, Context context, QuanLyNoDAO quanlynoDao) {
        this.list = list;
        this.context = context;
        this.QuanLyNoDAO = quanlynoDao;
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
        TextView txtTen, txtSoDu, txtDaTra, txtSoTien;
        ImageView ivSua,ivXoa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =((Activity)context).getLayoutInflater();
        ViewOfItem viewOfItem;
        if(view == null){
            viewOfItem = new ViewOfItem();
            view = inflater.inflate(R.layout.item_loaino,viewGroup,false);
            viewOfItem.txtSoTien = view.findViewById(R.id.tvSoTien);
            viewOfItem.txtDaTra = view.findViewById(R.id.tv_DaTra);
            viewOfItem.txtSoDu = view.findViewById(R.id.tv_ConLai);
            viewOfItem.txtTen = view.findViewById(R.id.tv_tenNo);
            viewOfItem.ivSua = view.findViewById(R.id.iv_cong);
            viewOfItem.ivXoa = view.findViewById(R.id.iv_tru);
            view.setTag(viewOfItem);
        }else{
            viewOfItem = (ViewOfItem) view.getTag();
        }
        viewOfItem.txtTen.setText(list.get(i).getTEN());
        viewOfItem.txtSoDu.setText(list.get(i).getConLai());
        viewOfItem.txtSoTien.setText(list.get(i).getSoTien());
        viewOfItem.txtDaTra.setText(list.get(i).getDaTra());


        viewOfItem.ivSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDiaLogSuaLoaiThuNo(list.get(i));
            }
        });
//        viewOfItem.ivXoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int idCanXoa = Integer.parseInt(list.get(i).getTEN());
//                if(QuanLyNoDAO.deleteLoaiThuChi(idCanXoa)){
//                    Toast.makeText(context, "xoa thanh cong", Toast.LENGTH_SHORT).show();
//                    reLoadData();
//                }else{
//                    Toast.makeText(context, "that bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        return view;
    }
    private void showDiaLogSuaLoaiThuNo(QLno qLno){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_sualoaino,null);
        EditText edtTenno = view.findViewById(R.id.edt_sua_ten_khoan_no);
        EditText edtSoDu = view.findViewById(R.id.edt_so_du);

        builder.setView(view);

        edtTenno.setText(qLno.getTEN());
        edtSoDu.setText(qLno.getConLai());

        builder.setPositiveButton("Cập Nhật", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String tenno = edtTenno.getText().toString();
                qLno.setTEN(tenno);
                if(quanlynoDao.updateLoaino(qLno)){
                    Toast.makeText(context, "cap nhat thnah cong", Toast.LENGTH_SHORT).show();
                    reLoadData();
                }else{
                    Toast.makeText(context, "Thát bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void reLoadData(){
        list.clear();
        list = quanlynoDao.getDsQuanLyNo("no");
        notifyDataSetChanged();
    }
}
