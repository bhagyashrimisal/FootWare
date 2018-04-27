package com.example.rohini.footware;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rohini on 26-04-2018.
 */

public class DatabaseForUpdate extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "all-notice";
    public static final String TABLE_NAME = "notice";
    public static final String COL1 = "ID";
    public static final String COL2 = "PNAME";

    public DatabaseForUpdate(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " PNAME TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);

    }

    public boolean addData(String pname)      //updatedata by declaring in database but by actual implementation done in new activity
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, pname);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public void deleteData(String ID)       //deletedata is the method used in new activity from calling and declaration part
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID = '" + ID + "'", null);
    }


    public boolean updatedata(String pid, String pname)       //updatedata by declaring in database but by actual implementation done in new activity
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, pname);
        int result = db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{pid});
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
