package com.example.instagramloginexample;

import android.provider.BaseColumns;

public class DBContract {

    public static final class Entry implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String COL_USERNAME = "username";
        public static final String COL_PASSWORD = "password";
        public static final String COL_NAME = "fullname";
        public static final String COL_NUMBER = "number";
    }

}
