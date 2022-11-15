package com.example.duan_1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NguoiDungDao {

    DbHelper dbHelper;

    public NguoiDungDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    //kiem tra thong tin dang nhap
    public boolean kiemTraDangNhap(String user, String pass) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE username = ? AND password =?", new String[]{user, pass});
        if (cursor.getCount() != 0) {
            return true;
        }
        return false;
    }
}