package com.example.developer.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.developer.habittracker.data.habitContract;
import com.example.developer.habittracker.data.habitDbHelper;

public class MainActivity extends AppCompatActivity {
    habitDbHelper mhabitDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhabitDbHelper = new habitDbHelper(this);
        insert("binar", "Reading", 2);
        insert("muhammed", "Walking", 1);
        Cursor cursor = readData();
    }


    public boolean insert(String UName, String HName, int times) {
        SQLiteDatabase db = mhabitDbHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(habitContract.habitEntry.User_Name, UName);
        value.put(habitContract.habitEntry.COLUMN_habit_NAME, HName);
        value.put(habitContract.habitEntry.COLUMN_habit_TIME, times);
        long newRow = db.insert(habitContract.habitEntry.TABLE_NAME, null, value);
        return newRow != -1;

    }


    public Cursor readData() {
        SQLiteDatabase db = mhabitDbHelper.getReadableDatabase();
        String[] projection = {habitContract.habitEntry._ID,
                habitContract.habitEntry.User_Name,
                habitContract.habitEntry.COLUMN_habit_NAME,
                habitContract.habitEntry.COLUMN_habit_TIME};
        String selection = habitContract.habitEntry._ID + "=?";
        String[] selectionArgs = {"1"};


        Cursor cursor = db.query(habitContract.habitEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        return cursor;

    }

}
