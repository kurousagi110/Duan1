package com.example.duan1.Adapter;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.DAO.ThuChiDAO;
import com.example.duan1.Model.KhoanThuChi;
import com.example.duan1.R;

import java.util.ArrayList;


public class KeHoachAdapter extends BaseAdapter {
    private ArrayList<KhoanThuChi> list;
    private Context context;
    private ThuChiDAO thuChiDAO;

    public KeHoachAdapter(ArrayList<KhoanThuChi> list, Context context, ThuChiDAO thuChiDAO) {
        this.list = list;
        this.context = context;
        this.thuChiDAO = thuChiDAO;
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
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewOfItem {
        TextView txtTenKeHoach, txtTienKeHoach, txtNgayKeHoach;
        ImageView ivSuaKeHoach, ivXoaKeHoach;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        KeHoachAdapter.ViewOfItem viewOfItem;
        if (view == null) {
            view = inflater.inflate(R.layout.item_kehoach, viewGroup, false);
            viewOfItem = new KeHoachAdapter.ViewOfItem();
            viewOfItem.txtTenKeHoach = view.findViewById(R.id.txtNgayKeHoach);
            viewOfItem.txtTienKeHoach = view.findViewById(R.id.txtTienKeHoach);
            viewOfItem.ivSuaKeHoach = view.findViewById(R.id.ivSuaKeHoach);
            viewOfItem.ivXoaKeHoach = view.findViewById(R.id.ivXoaKeHoach);
            viewOfItem.txtNgayKeHoach = view.findViewById(R.id.txtNgayKeHoach);

            view.setTag(viewOfItem);
        } else {
            viewOfItem = (KeHoachAdapter.ViewOfItem) view.getTag();
        }
        viewOfItem.txtTenKeHoach.setText("Tên: " + list.get(i).getTenKhoan());
        viewOfItem.txtTienKeHoach.setText("Số tiền: " + list.get(i).getTien());
        viewOfItem.txtNgayKeHoach.setText("Ngày: " + list.get(i).getNgay());
        return view;
    }
}
