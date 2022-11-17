package com.example.duan1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context,"nguoidung",null,3);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dbNguoiDung = "CREATE TABLE NGUOIDUNG(id integer primary key autoincrement, username text, password text, name text)";
        sqLiteDatabase.execSQL ( dbNguoiDung) ;

        String insNguoiDung = "INSERT INTO NGUOIDUNG VALUES ( 1 , ' vanA ' , ' 123456 ' , ' Văn A ' ),( 2 , ' vanB ' , ' 123456 ' , ' Văn B ' ) ";
        sqLiteDatabase.execSQL(insNguoiDung);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i,int i1) {
        if(i !=i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            onCreate(sqLiteDatabase);
        }

    }
}
