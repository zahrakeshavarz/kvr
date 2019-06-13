package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class databaseAccess extends SQLiteAssetHelper {
    private static String DATABASE_NAME = "dowlatt.db";
    private static int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public databaseAccess(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db= super.getWritableDatabase();
    }
    public SQLiteDatabase getDb (){
        return db;
    }
}
