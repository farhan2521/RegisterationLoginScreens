package com.example.zetamptask1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zetamptask1.database.DetailsContract.UserDetails;

public class DbAccessObject {
    SQLiteDatabase entriesdb;
    DbHelper dbHelper;

    public DbAccessObject(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void openDb() {
        entriesdb = dbHelper.getWritableDatabase();
    }

    public void closeDb(){
        entriesdb.close();
    }

    public void createRow(String title, String date, String time) {
        ContentValues values = new ContentValues();
        values.put(DetailsContract.UserDetails.COLUMN_NAME_PERSON_NAME,title);
        values.put(DetailsContract.UserDetails.COLUMN_NAME_EMAIL,date);
        values.put(DetailsContract.UserDetails.COLUMN_NAME_PASSWORD,time);
        entriesdb.insert(DetailsContract.UserDetails.TABLE_NAME,null,values);
    }

    public boolean checkEmailExist(String email) {
        String query = "select " + UserDetails.COLUMN_NAME_EMAIL + " from " + UserDetails.TABLE_NAME + " where " + UserDetails.COLUMN_NAME_EMAIL + " =?";
        Cursor cursor = entriesdb.rawQuery(query, new String[]{email});
        if (cursor.getCount() > 0)
        {
            cursor.close();
            return true;
        }
        else {
            cursor.close();
            return false;
        }
    }

    public boolean checkEmailPasswordExist(String email, String password) {
        String query = "select " + UserDetails.COLUMN_NAME_EMAIL + " from " + UserDetails.TABLE_NAME + " where " + UserDetails.COLUMN_NAME_EMAIL + " =? and " + UserDetails.COLUMN_NAME_PASSWORD + " =?";
        Cursor cursor = entriesdb.rawQuery(query, new String[]{email,password});
        if (cursor.getCount() > 0)
        {
            cursor.close();
            return true;
        }
        else {
            cursor.close();
            return false;
        }
    }

}