package com.example.zetamptask1.database;

import android.provider.BaseColumns;

public final class DetailsContract {
        private DetailsContract(){}
        public static class UserDetails implements BaseColumns {
            public static final String DB_NAME = "UserDetails";
            public static final String TABLE_NAME = "LoginDetails";
            public static final String COLUMN_NAME_PERSON_NAME = "PersonName";
            public static final String COLUMN_NAME_EMAIL = "Email";
            public static final String COLUMN_NAME_PASSWORD = "Password";
        }
    }

