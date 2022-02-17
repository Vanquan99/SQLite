package com.vanquan.sqlite.SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TaoDatabaseNV extends SQLiteOpenHelper {

    public static final String DB_QUANLYNHANVIEN="QuanLyNhanVien";
    public static final int DB_VERSION=1;
    public static final String TABLE_NHANVIEN="NHANVIEN";
    public static final String ID_NHANVIEN="_id";
    public static final String TEN_NHANVIEN="TenNhanVien";


//    public TaoDatabaseNV(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, DB_QUANLYNHANVIEN, factory, DB_VERSION);
//    }
//chi co context la gan dong nen xoa cho gon
    public TaoDatabaseNV(@Nullable Context context) {
        super(context, DB_QUANLYNHANVIEN, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String cautruyvan= "CREATE TABLE NHAN VIEN(_id INTEGER PRIMARY KEY AUTOINCREMENT ,TenNhanVien TEXT);";
//        db.execSQL(cautruyvan);

        String cautruyvan= " CREATE TABLE " + TABLE_NHANVIEN +
                " ( " + ID_NHANVIEN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TEN_NHANVIEN + "TEXT);";
        db.execSQL(cautruyvan);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS NHANVIEN"+ TABLE_NHANVIEN);
        onCreate(db);

    }
}
