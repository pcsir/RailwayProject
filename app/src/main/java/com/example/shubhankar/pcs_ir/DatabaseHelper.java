package com.example.shubhankar.pcs_ir;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "CNF_CHART";
    private DBManager database;
    // Table columns
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_PNR = "PNR";
    public static final String COL_STATUS = "STATUS";
    public static final String COL_SEAT_NO = "SEAT_NO";

    // Database Information
    private static final String DB_NAME = "charts001.db";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    public static final String CREATE_TABLE = "CREATE TABLE " +  TABLE_NAME + "( "
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, "
            + COL_PNR + " INTEGER NOT NULL, "
            + COL_STATUS + " TEXT NOT NULL, "
            + COL_SEAT_NO + " TEXT NOT NULL"+" );";




    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
