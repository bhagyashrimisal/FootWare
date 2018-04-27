package com.example.rohini.footware;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rohini on 24-04-2018.
 */

public class DatabaseNotice extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "all-notice";
    public static final String TABLE_NAME = "notice";
    public static final String COL1 = "ID";
    public static final String COL2 = "message";

    public DatabaseNotice(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " CREATE TABLE " +TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " message TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);

    }
    public boolean addData(String message)      //updatedata by declaring in database but by actual implementation done in new activity
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,message);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return data;
    }

    public void deleteData(String ID)       //deletedata is the method used in new activity from calling and declaration part
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID = '" +ID+ "'",null);
    }
}
