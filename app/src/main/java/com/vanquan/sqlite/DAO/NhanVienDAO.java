package com.vanquan.sqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vanquan.sqlite.DTO.NhanVienDTO;
import com.vanquan.sqlite.SQLiteHelper.TaoDatabaseNV;
//kết nối đến databaseHelper thực hiện các câu truy vấn
public class NhanVienDAO {

    SQLiteDatabase database;
    TaoDatabaseNV taoDatabaseNV;
    public NhanVienDAO(Context context){
        taoDatabaseNV=new TaoDatabaseNV(context);
    }

    public void open(){
        database=taoDatabaseNV.getWritableDatabase();
    }
    public void close(){
        taoDatabaseNV.close();
    }

    public boolean ThemNhanVien(NhanVienDTO nv){
        ContentValues contentValues=new ContentValues();
//        contentValues.put(TaoDatabaseNV.ID_NHANVIEN,""); khong can vi tu dong tang

        contentValues.put(TaoDatabaseNV.TEN_NHANVIEN,nv.getTenNV().toString());

        long id_nhanvien = database.insert(TaoDatabaseNV.TABLE_NHANVIEN,null,contentValues);

        if(id_nhanvien!=0){
            return true;
        }else {
            return false;
        }


    }
}
