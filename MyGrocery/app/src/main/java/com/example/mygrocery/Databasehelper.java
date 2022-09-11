package com.example.mygrocery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String  TABLE_NAME = "registeruser";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";

    public Databasehelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser(String user, String password){
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username",user);
        cv.put("password",password);

        sq.insert("registeruser",null,cv);
        sq.close();


    }

    public boolean checkUser(String username, String password){
        SQLiteDatabase sql = getReadableDatabase();
        String[] selectionArgs = new String[]{username,password};
        Cursor cursor = sql.rawQuery("SELECT * FROM registeruser WHERE username = ? AND password = ?",selectionArgs);
        int count = cursor.getCount();
        cursor.close();
        sql.close();
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }
}