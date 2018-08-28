package com.example.shubhankar.pcs_ir;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChartsActivity extends AppCompatActivity {


    private DBManager dbManager;

    private ListView listView;

    private ConfirmedAdapter adapter;

    PassengerModel passengerModel;



    final String[] from = new String[] { DatabaseHelper.COL_ID,
            DatabaseHelper.COL_NAME, DatabaseHelper.COL_PNR,DatabaseHelper.COL_STATUS
    ,DatabaseHelper.COL_SEAT_NO};

    final int[] to = new int[] { R.id.id1, R.id.name,R.id.pnr,R.id.status,
                                    R.id.seat_no};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();

        Cursor cursor = dbManager.fetch();
        //dbManager.insert("Sap","Waiting","123", "001","453535657");

       //dbManager.insert("Sap","RAC","123", "45","23456745L");
       //dbManager.insert("Rohit","Confirmed","72", "46","6546754L");
        ArrayList<PassengerModel> arrayList=new ArrayList<>();
      //dbManager.insert("qwerty","123","123", "48","54213443");




        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
           passengerModel=new PassengerModel(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ID)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME)),cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PNR)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_SEAT_NO)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_STATUS)));


            arrayList.add(passengerModel);
            // The Cursor is now set to the right position
           // arrayList.add(passengerModel);

        }



        Log.d("col_id",DatabaseHelper.COL_ID);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new ConfirmedAdapter(this,arrayList);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

}