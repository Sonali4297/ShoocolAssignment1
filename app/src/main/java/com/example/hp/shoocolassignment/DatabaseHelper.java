package com.example.hp.shoocolassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "shoocal.db";
    public static final String TABLE_NAME = "auth_form";
    public static final String COL_1 = "first_name";
    public static final String COL_2 = "last_name";
    public static final String COL_3 = "phone";
    public static final String COL_4 = "address";
    public static final String COL_5 = "restau_name";
    public static final String COL_6 = "requestby";

    public Context myContext;
    public final static String DATABASE_PATH = "/data/data/com.example.hp.shoocalassignment/databases/";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + COL_1 + " text," + COL_2 + " text," + COL_3 + " number," + COL_4 + " text," + COL_5 + " text," +
                COL_6 + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String first_name, String last_name, String phone, String address, String restau_name,
                              String requestby) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, first_name);
        contentValues.put(COL_2, last_name);
        contentValues.put(COL_3, phone);
        contentValues.put(COL_4, address);
        contentValues.put(COL_5, restau_name);
        contentValues.put(COL_6, requestby);
        long result=db.insert(TABLE_NAME, null, contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }
}


