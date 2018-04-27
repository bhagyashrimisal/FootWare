package com.example.rohini.footware;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rohini on 20-04-2018.
 */

    public class DatabaseConnection extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Customer_Details.db";  //DATABASE NAME
    public static final int DATABASE_VERSION = 3;                       //DATABASE VERSION
    public static final String TABLE_USERS = "Customer_Information";    //TABLE NAME
    public static final String KEY_ID = "id";                           //TABLE USERS COLUMNS  //ID COLUMN @primaryKey
    public static final String KEY_USER_NAME = "username";              //COLUMN user name
    public static final String KEY_USER_ADDRESS ="useraddres";          //COLUMN user address
    public static final String KEY_USER_MOBILE ="usermobile";          //COLUMN user mobile no
    public static final String KEY_EMAIL = "email";                      //COLUMN email
    public static final String KEY_PASSWORD = "password";                //COLUMN password

    //SQL for creating users table
    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_USER_ADDRESS + " TEXT, "
            + KEY_USER_MOBILE + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT"
            + " ) ";
    public DatabaseConnection(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);                                     //Create Table when oncreate gets called
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
    }


    public void addUser(User user)                                   //using this method we can add users to user table
    {
        SQLiteDatabase db = this.getWritableDatabase();              //get writable database
        ContentValues values = new ContentValues();                  //create content values to insert
        values.put(KEY_USER_NAME, user.userName);                   //Put username in  @values
        values.put(KEY_USER_ADDRESS, user.userAddress);                   //Put username in  @values
        values.put(KEY_USER_MOBILE, user.userMobile);                   //Put username in  @values
        values.put(KEY_EMAIL, user.email);                               //Put email in  @values
        values.put(KEY_PASSWORD, user.password);                         //Put password in  @values
        long todo_id = db.insert(TABLE_USERS, null, values); // insert row
    }

    public User Authenticate(User user)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        // Selecting Table
        //Selecting columns want to query
        Cursor cursor = db.query(TABLE_USERS,
                new String[]{KEY_ID, KEY_USER_NAME, KEY_USER_ADDRESS, KEY_USER_MOBILE, KEY_EMAIL, KEY_PASSWORD},
                KEY_EMAIL + "=?",
                new String[]{user.email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst())
        {
            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password))
            {
                return user1;
            }
        }
        return null;                 //if user password does not matches or there is no record with that email then return @false
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Selecting Table
        //Selecting columns want to query
        //Where clause
        Cursor cursor = db.query(TABLE_USERS,
                new String[]{KEY_ID, KEY_USER_NAME, KEY_USER_ADDRESS, KEY_USER_MOBILE, KEY_EMAIL, KEY_PASSWORD},
                KEY_EMAIL + "=?",
                new String[]{email},
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }
        //if email does not exist return false
        return false;
    }
}
