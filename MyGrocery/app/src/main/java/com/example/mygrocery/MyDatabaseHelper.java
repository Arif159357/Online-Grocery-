package com.example.mygrocery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "grocery.db";
    private static final String TABLE_NAME = "grocery_details";
    private static final String ID = "_id";
    private static final String ITEM = "Item";
    private static final String PRICE = "Price";
    private static final int VERSION_NUMBER = 10;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ITEM+" VARCHAR(255),"+PRICE+" INTEGER); ";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            Toast.makeText(context,"onCreate is called ", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context,"Exception : "+e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context,"onUpgrade is called ", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Toast.makeText(context,"Exception : "+e, Toast.LENGTH_LONG).show();
        }
    }

    public void insert(String item, int price){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Item ", item);
        contentValues.put("Price ", price);
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }
    public ArrayList viewItem(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> array_itemlist = new ArrayList<String>();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false){
            array_itemlist.add(cursor.getString(cursor.getColumnIndex("Item")));
            cursor.moveToNext();
        }
        return  array_itemlist;


    }

    public ArrayList viewPrice(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> array_list = new ArrayList<String>();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false){
            array_list.add(cursor.getString(cursor.getColumnIndex("Price")));
            cursor.moveToNext();
        }
        return  array_list;


    }

    public void deleteEntry(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String where="item=?";
        db.delete(TABLE_NAME, where,new String[] {name}) ;
    }



}
