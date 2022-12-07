package com.example.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    public DataHelper( Context context) {
        super(context, "ThuChiDatabase", null, 15);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qTaiKhoan = "CREATE TABLE TAIKHOAN (soTK integer primary key autoincrement, taikhoan text, matkhau text)";
        db.execSQL(qTaiKhoan);
        String qloai = "CREATE TABLE LOAI (maloai integer primary key autoincrement, tenloai text, trangthai text, soTK integer,FOREIGN KEY(soTK) references TAIKHOAN(SoTK))";
        db.execSQL(qloai);
        String khoanno = "CREATE TABLE KHOANNO(makhoan integer primary key autoincrement, tien integer, tiendatra integer, ngay text,Ten text, maloai integer,FOREIGN KEY(maloai) references LOAI(maloai)) ";
        db.execSQL(khoanno);

        String qKhoan = "CREATE TABLE KHOANTHUCHI(makhoan integer primary key autoincrement, tien integer, ngay text, maloai integer,FOREIGN KEY(maloai) references LOAI(maloai))";
        db.execSQL(qKhoan);
        //data mẫu:
        String taikhoan = "INSERT INTO TAIKHOAN VALUES(1, 'admin', 'admin'), (2, 'hoa123', '123'), (3, 'tai456', '456'), (4, 'loi789', '789')";
        db.execSQL(taikhoan);

        String loai = "INSERT INTO LOAI VALUES(1, 'tiền xăng', 'chi',2), (2, 'tiền lương', 'thu',2), (3, 'ăn sáng', 'chi',2)";
        db.execSQL(loai);
//        String KHOANNO =  "INSERT INTO KHOANNO VALUES(4, 5000 ,'01/11/2022' ,6), (5, 7000, '09/11/2022', 5), (6, 1000, '08/12/2022',4)";
//        db.execSQL(KHOANNO);

//        String no = "INSERT INTO KHOANNO VALUES(10, 'tiền xăng', 'no',2), (12, 'tiền lương', 'no',2), (13, 'ăn sáng', 'no',2)";
//        db.execSQL(no);

        String loai1 = "INSERT INTO LOAI VALUES(4, 'tiền ăn', 'chi',3), (5, 'tiền lương', 'thu',3), (6, 'ăn đòn', 'thu',3)";
        db.execSQL(loai1);

        String khoanthuchi = "INSERT INTO KHOANTHUCHI VALUES(1, 6000, '02/11/2022' ,1), (2, 5000, '03/11/2022', 3), (3, 10000, '05/01/2022',2)";
        db.execSQL(khoanthuchi);

        String khoanthuchi1 = "INSERT INTO KHOANTHUCHI VALUES(4, 5000, '01/11/2022' ,6), (5, 7000, '09/11/2022', 5), (6, 1000, '08/12/2022',4)";
        db.execSQL(khoanthuchi1);

           }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            String dTaiKhoan = "DROP TABLE IF EXISTS TAIKHOAN";
            db.execSQL(dTaiKhoan);
            String dLoai = "DROP TABLE IF EXISTS LOAI";
            db.execSQL(dLoai);
            String KHOANNO = "DROP TABLE IF EXISTS KHOANNO";
            db.execSQL(KHOANNO);
            String dKhoan = "DROP TABLE IF EXISTS KHOANTHUCHI";
            db.execSQL(dKhoan);
            onCreate(db);
        }
    }
}
