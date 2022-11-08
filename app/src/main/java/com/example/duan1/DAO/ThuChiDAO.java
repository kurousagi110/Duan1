package com.example.duan1.DAO;

import android.content.Context;

import com.example.duan1.database.DataHelper;

public class ThuChiDAO {
    DataHelper dataHelper;
    public ThuChiDAO(Context context){
        dataHelper = new DataHelper(context);
    }

}
