package com.example.shubhankar.pcs_ir;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseHelper extends SQLiteAssetHelper {

    // Table Name
    public static final String TABLE_NAME = "CNF_CHART";
    public static final String TABLE_NAME_2 = "WAIT";

    // Table columns
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_PNR = "PNR";
    public static final String COL_STATUS = "STATUS";
    public static final String COL_SEAT_NO = "SEAT";

    // Database Information
    private static final String DB_NAME = "test1.sqlite";

    // database version
    static final int DB_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

}
