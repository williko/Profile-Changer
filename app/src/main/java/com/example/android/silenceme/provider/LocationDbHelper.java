package com.example.android.silenceme.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by williams on 30/6/19.
 */

public class LocationDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "silenceme.db";
    private static final int DATABASE_VERSION = 1;
    public LocationDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_PLACES_TABLE = "CREATE TABLE " + LocationContract.LocationEntry.TABLE_NAME + " (" +
                LocationContract.LocationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                LocationContract.LocationEntry.COLUMN_PLACE_ID + " TEXT NOT NULL, " +
                "UNIQUE (" + LocationContract.LocationEntry.COLUMN_PLACE_ID + ") ON CONFLICT REPLACE" +
                "); ";

        db.execSQL(SQL_CREATE_PLACES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LocationContract.LocationEntry.TABLE_NAME);
        onCreate(db);
    }
}
