package com.example.instagramloginexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.controls.Control;

public class DBAdapter extends SQLiteOpenHelper {

    private static final String DB_NAME = "user.db";
    public static final int DB_VERSION = 1;

    public DBAdapter(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + DBContract.Entry.TABLE_NAME + " (" +
                DBContract.Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DBContract.Entry.COL_USERNAME + " TEXT, " +
                DBContract.Entry.COL_PASSWORD + " TEXT, " +
                DBContract.Entry.COL_NAME + " TEXT, " +
                DBContract.Entry.COL_NUMBER + " TEXT" +
                ");";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 1){

        }else{

        }
    }
}
