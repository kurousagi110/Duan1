package com.example.duan1.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.Model.Loai;
import com.example.duan1.database.DataHelper;

import java.util.ArrayList;

public class ThuChiDAO {
    DataHelper dataHelper;
    public ThuChiDAO(Context context){
        dataHelper = new DataHelper(context);
    }

    // get danh sách loại thu/chi

    public ArrayList<Loai> getDsLoaiThuChi(String loai){
        ArrayList<Loai> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM LOAI", null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                String trangthai = cursor.getString(2);
                if(trangthai.equals(loai)){
                    list.add(new Loai(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3)));
                }
            }while (cursor.moveToNext());
        }
        return list;
    }

}
