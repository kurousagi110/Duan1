package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DbHelper;
import com.example.duan1.Model.KhoanThuChi;
import com.example.duan1.Model.Loai;
import com.example.duan1.database.DataHelper;

import java.util.ArrayList;

public class ThuChiDAO {
    DataHelper dataHelper;

    public ThuChiDAO(Context context) {
        dataHelper = new DataHelper(context);
    }


    // get danh sách loại thu/chi

    public ArrayList<Loai> getDSLoaiThuChi(String loai,Integer id) {
        ArrayList<Loai> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM LOAI", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Integer maTK = cursor.getInt(3);
                String trangthai = cursor.getString(2);
                if (trangthai.equals(loai)&&maTK.equals(id)) {
                    list.add(new Loai(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
                }
            } while (cursor.moveToNext());
        }
        return list;
    }
    // them loai thu/chi

    public boolean addLoaiThuChi(Loai loai) {
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenloai", loai.getTenLoai());
        contentValues.put("trangthai", loai.getTrangThai());
        contentValues.put("soTK", loai.getSoTK());
        long check = sqLiteDatabase.insert("LOAI", null, contentValues);
        if (check == -1)
            return false;
        return true;
    }
    //cap nhat loai thu chi
    public boolean updateLoaiThuChi(Loai loai) {
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maloai", loai.getMaLoai());
        contentValues.put("tenLoai", loai.getTenLoai());
        contentValues.put("trangthai", loai.getTrangThai());
        long check = sqLiteDatabase.update("LOAI", contentValues, "maloai = ?", new String[]{String.valueOf(loai.getMaLoai())});
        if (check == -1)
            return false;
        return true;
    }
    // xoa loai thu chi
    public boolean deleteLoaiThuChi(int maLoai) {
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
        long check = sqLiteDatabase.delete("LOAI", "maLoai = ?", new String[]{String.valueOf(maLoai)});
        if (check == -1)
            return false;
        return true;
    }
    //lay danh sach khoan thu chi
    public ArrayList<KhoanThuChi> getDSKhoanThuChi(String loai, int soTK){
        ArrayList<KhoanThuChi> list = new ArrayList<>();
        SQLiteDatabase database = dataHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT k.maKhoan, k.tien, l.tenLoai, k.ngay, k.maLoai FROM LOAI l, KHOANTHUCHI k WHERE l.maLoai = k.maLoai AND l.trangthai = ? and l.soTK =?", new String[]{loai, String.valueOf(soTK)});
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                list.add(new KhoanThuChi(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4)));
            }while (cursor.moveToNext());
        }
        return list;
    }
    // them khoan thu chi
    public boolean addKhoanThuChi(KhoanThuChi khoanThuChi){
        SQLiteDatabase database = dataHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tien", khoanThuChi.getTien());
        contentValues.put("ngay",khoanThuChi.getNgay());
        contentValues.put("maLoai", khoanThuChi.getMaLoai());
        long check = database.insert("KHOANTHUCHI" , null, contentValues);
        if(check == -1)
            return false;
        return true;
    }
    //cap nhat khoan thu chi
    public boolean updateKhoanThuChi(KhoanThuChi khoanThuChi){
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maKhoan", khoanThuChi.getMaKhoan());
        contentValues.put("tien", khoanThuChi.getTien());
        contentValues.put("ngay", khoanThuChi.getNgay());
        contentValues.put("maLoai", khoanThuChi.getMaLoai());
        long check = sqLiteDatabase.update("KHOANTHUCHI", contentValues, "maKhoan = ?", new String[]{String.valueOf(khoanThuChi.getMaKhoan())});
        if(check == -1)
            return false;
        return true;
    }
    //xoa khoan thu chi
    public boolean deleteKhoanThuChi(int maKhoan){
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
        long check = sqLiteDatabase.delete("KHOANTHUCHI", "maKhoan = ?", new String[]{String.valueOf(maKhoan)});
        if(check == -1)
            return false;
        return true;
    }

}
