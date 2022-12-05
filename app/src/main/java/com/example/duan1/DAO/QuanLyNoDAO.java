package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.Model.Loai;
import com.example.duan1.Model.QLno;
import com.example.duan1.database.DataHelper;

import java.util.ArrayList;

public class QuanLyNoDAO {
    DataHelper dataHelper;
    private String TEN;

    public QuanLyNoDAO(Context context) {
        dataHelper = new DataHelper(context);
    }


    // get danh sách

    public ArrayList<QLno> getDsQuanLyNo(String loaino) {
        ArrayList<QLno> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM KHOANNO", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                String trangthai = cursor.getString(2);
                if (trangthai.equals(loaino)) {
                    list.add(new QLno(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getString(3), cursor.getInt(4)));
                }
            } while (cursor.moveToNext());
        }
        return list;
    }
    public boolean addLoaino(QLno qLno) {
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TEN",qLno.getTEN());
        contentValues.put("trangThai", qLno.getTrangThai());
        contentValues.put("SoTien",qLno.getSoTien());
        contentValues.put("DaTra",qLno.getDaTra());
        contentValues.put("ConLai",qLno.getConLai());

        long check = sqLiteDatabase.insert("KHOANNO",  null, contentValues);
        if (check == -1)
            return false;
        return true;
    }
    public boolean updateLoaino(QLno qLno) {
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TEN",qLno.getTEN());
        contentValues.put("trangThai", qLno.getTrangThai());
        contentValues.put("SoTien",qLno.getSoTien());
        contentValues.put("DaTra",qLno.getDaTra());
        contentValues.put("ConLai",qLno.getConLai());
        long check = sqLiteDatabase.update("KHOANNO", contentValues, "Ten = ?", new String[]{String.valueOf(qLno.getTEN())});
        if (check == -1)
            return false;
        return true;
    }

    public void setTenno(String tenno) {
        this.TEN = tenno;
    }
}
