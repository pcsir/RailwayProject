package com.example.shubhankar.pcs_ir;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ConfirmedAdapter extends ArrayAdapter<PassengerModel> {
    public ConfirmedAdapter(Context context, ArrayList<PassengerModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        //Get the date item for this position
        PassengerModel passengerModel = getItem(position);

        //Check if the existing view is being reused, otherwise inflate a new view from custom_row layout
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_row, parent, false);
            viewHolder = new ViewHolder();
            //Casting of views from the custom_row layout
            viewHolder.id1= convertView.findViewById(R.id.id1);
            viewHolder.name1 = convertView.findViewById(R.id.name1);


            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Filling each views values
        viewHolder.id1.setText((int) passengerModel.getId());
        viewHolder.name1.setText(passengerModel.getName());


        return convertView;
    }

    static class ViewHolder{
        TextView id1, name1;

    }
}
