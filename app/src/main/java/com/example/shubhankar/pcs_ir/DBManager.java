package com.example.shubhankar.pcs_ir;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {


    private DatabaseHelper databaseHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        databaseHelper = new DatabaseHelper(context) {};
        database = databaseHelper.getWritableDatabase();

        return this;
    }

    public void close() {
        databaseHelper.close();
    }

    public void insert(String name, String status, String seat, String  id, String pnr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_ID, id);
        contentValues.put(DatabaseHelper.COL_NAME, name);
        contentValues.put(DatabaseHelper.COL_PNR, pnr);
        contentValues.put(DatabaseHelper.COL_STATUS, status);
        contentValues.put(DatabaseHelper.COL_SEAT_NO, seat);

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper.COL_ID,DatabaseHelper.COL_NAME
                ,DatabaseHelper.COL_PNR,DatabaseHelper.COL_STATUS, DatabaseHelper.COL_SEAT_NO};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


    /*
        public int update(long _id, String name, String desc) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.SUBJECT, name);
            contentValues.put(DatabaseHelper.DESC, desc);
            int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
            return i;
        }
    */
    public void delete(long _id) {
        // database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}
