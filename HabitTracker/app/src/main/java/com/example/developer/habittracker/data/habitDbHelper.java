package com.example.developer.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by binar on 15/11/2017.
 */

public class habitDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Habits.db";
    public static final int DB_VERTION = 1;

    public habitDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERTION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_HABITS = "CREATE TABLE " + habitContract.habitEntry.TABLE_NAME + "(" + habitContract.habitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + habitContract.habitEntry.User_Name + " TEXT," + habitContract.habitEntry.COLUMN_habit_NAME + " TEXT," + habitContract.habitEntry.COLUMN_habit_TIME + " INTEGER);";
        sqLiteDatabase.execSQL(CREATE_TABLE_HABITS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DELETE_EXISTES = "DROPP TABLE IF EXISTS" + habitContract.habitEntry.TABLE_NAME;
        sqLiteDatabase.execSQL(DELETE_EXISTES);
        onCreate(sqLiteDatabase);

    }
}
