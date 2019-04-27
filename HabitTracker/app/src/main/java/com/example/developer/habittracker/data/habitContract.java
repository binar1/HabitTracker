package com.example.developer.habittracker.data;

import android.provider.BaseColumns;
import android.provider.Telephony;

/**
 * Created by binar on 15/11/2017.
 */

public class habitContract {

    public habitContract() {
    }

    public static final class habitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String User_Name = "UName";
        public final static String COLUMN_habit_NAME = "HName";
        public final static String COLUMN_habit_TIME = "Time";


    }
}
