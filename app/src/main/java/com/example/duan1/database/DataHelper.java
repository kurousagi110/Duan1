package com.example.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    public DataHelper( Context context) {
        super(context, "ThuChiDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qTaiKhoan = "CREATE TABLE TAIKHOAN (soTK integer primary key autoincrement, taikhoan text, matkhau text)";
        db.execSQL(qTaiKhoan);
        String qloai = "CREATE TABLE LOAI (maloai integer primary key autoincrement, tenloai text, trangthai text)";
        db.execSQL(qloai);

        String qKhoan = "CREATE TABLE KHOANTHUCHI(makhoan integer primary key autoincrement, tien integer, ngay date, maloai integer references LOAI(maloai), soTK integer references TAIKHOAN(SoTK))";
        db.execSQL(qKhoan);
        //data mẫu:
        String taikhoan = "INSERT INTO TAIKHOAN VALUES(1, 'admin', 'admin'), (2, 'hoa123', '123'), (3, 'tai456', '456'), (4, 'loi789', '789')";
        db.execSQL(taikhoan);

        String loai = "INSERT INTO LOAI VALUES(1, 'tiền xăng', 'chi'), (2, 'tiền lương', 'thu'), (3, 'ăn sáng', 'chi')";
        db.execSQL(loai);

        String loai1 = "INSERT INTO LOAI VALUES(4, 'tiền ăn', 'chi'), (5, 'tiền lương', 'thu'), (6, 'ăn đòn', 'thu')";
        db.execSQL(loai1);

        String khoanthuchi = "INSERT INTO KHOANTHUCHI VALUES(1, 5000, 11/2/2022 ,1,2), (2, 5000, 11,3,2022, 3,2), (3, 1000, 15/5/2022,2,2)";
        db.execSQL(khoanthuchi);

        String khoanthuchi1 = "INSERT INTO KHOANTHUCHI VALUES(1, 5000, 11/1/2022 ,6,3), (2, 5000, 11,9,2022, 5,3), (3, 1000, 15/8/2022,4,3)";
        db.execSQL(khoanthuchi1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            String dTaiKhoan = "DROP TABLE IF EXISTS TAIKHOAN";
            db.execSQL(dTaiKhoan);
            String dLoai = "DROP TABLE IF EXISTS LOAI";
            db.execSQL(dLoai);
            String dKhoan = "DROP TABLE IF EXISTS KHOANTHUCHI";
            db.execSQL(dKhoan);
            onCreate(db);
        }
    }
}
