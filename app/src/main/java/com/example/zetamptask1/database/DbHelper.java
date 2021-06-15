package com.example.zetamptask1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.zetamptask1.database.DetailsContract.UserDetails;

public class DbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DetailsContract.UserDetails.TABLE_NAME + " (" +
                    UserDetails._ID + " INTEGER PRIMARY KEY," +
                    UserDetails.COLUMN_NAME_PERSON_NAME + " TEXT," +
                    UserDetails.COLUMN_NAME_EMAIL + " TEXT," +
                    UserDetails.COLUMN_NAME_PASSWORD +" TEXT)";

    public DbHelper(@Nullable Context context) {
        super(context, UserDetails.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
