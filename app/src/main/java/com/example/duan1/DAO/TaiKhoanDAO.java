package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.Model.TaiKhoan;
import com.example.duan1.database.DataHelper;

public class TaiKhoanDAO {
    DataHelper dataHelper;

    public TaiKhoanDAO(Context context) {
        dataHelper = new DataHelper(context);
    }

    public boolean checkLogin(String taikhoan, String matkhau) {
        SQLiteDatabase sqLiteOpenHelper = dataHelper.getReadableDatabase();
        Cursor cursor = sqLiteOpenHelper.rawQuery("select * from TAIKHOAN where taikhoan = ? and matkhau = ?", new String[]{taikhoan, matkhau});
        if (cursor.getCount() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(TaiKhoan obj) {
        SQLiteDatabase database = dataHelper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("taikhoan", obj.getTaiKhoan());
            values.put("matkhau", obj.getMatKhau());
            long check = database.insert("THUTHU", null, values);
            if (check == -1) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            Log.d("THUTHUDAO insert error: ", e.getMessage());
            return false;
        }
    }

    public boolean update(String username, String oldPass, String newPass) {
        SQLiteDatabase database = dataHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM THUTHU WHERE maTT = ? and matKhau = ?",new String[]{username,oldPass});
        if (cursor.getCount()>0){
            ContentValues values = new ContentValues();
            values.put("matKhau", newPass);
            long check = database.update("THUTHU",values,"maTT = ?",new String[]{username});
            if (check == -1){
                return false;
            }else {
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        SQLiteDatabase database = dataHelper.getWritableDatabase();
        try {
            long check = database.delete("THUTHU", "maTT = ?", new String[]{id});
            if (check == -1) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            Log.d("THUTHUDAO update error: ", e.getMessage());
            return false;
        }
    }
}
