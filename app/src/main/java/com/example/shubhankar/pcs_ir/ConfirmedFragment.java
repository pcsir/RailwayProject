package com.example.shubhankar.pcs_ir;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ConfirmedFragment extends Fragment {



    private DBManager dbManager;
    private ListView listView;
    View view;
    Cursor cursor;

    private ConfirmedAdapter adapter;

    PassengerModel passengerModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            view=inflater.inflate(R.layout.fragment_emp_list, container,false);


        dbManager = new DBManager(getContext());
        dbManager.open();




        //dbManager.insert("Rohit Joshi","Waiting","B1 21", "2","2348384");

        //dbManager.insert("Rohit Joshi","RAC","S2 21", "7","23456745");
       //dbManager.insert("Parag Chitnis","Confirmed","S3 32", "8","6546754L");


        cursor = dbManager.fetch();

        ArrayList<PassengerModel> arrayList=new ArrayList<>();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            passengerModel=new PassengerModel(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ID)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME)),cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PNR)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_STATUS)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_SEAT_NO)));


            arrayList.add(passengerModel);
            Log.d("string", arrayList.toString());

        }

        listView = (ListView) view.findViewById(R.id.list_view);
        listView.setEmptyView(view.findViewById(R.id.empty));

        adapter = new ConfirmedAdapter(getContext(), arrayList);
        adapter.notifyDataSetChanged();

        Log.d("count", String.valueOf(adapter.getCount()));
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        dbManager.close();
    }
}