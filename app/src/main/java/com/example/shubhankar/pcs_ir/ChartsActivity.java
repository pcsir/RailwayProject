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

public class ChartsActivity extends AppCompatActivity {


    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

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
      //  dbManager.insert("Sap","123","123", 45L,23L);
        Log.d("col_id",DatabaseHelper.COL_ID);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this,R.layout.activity_charts,
                    cursor,from,to,0);
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