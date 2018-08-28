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
            convertView = layoutInflater.inflate(R.layout.fragment_confirmed, parent, false);
            viewHolder = new ViewHolder();
            //Casting of views from the custom_row layout
            viewHolder.id= convertView.findViewById(R.id.id1);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.status=convertView.findViewById(R.id.status);
            viewHolder.seat_no=convertView.findViewById(R.id.seat_no);
            viewHolder.pnr=convertView.findViewById(R.id.pnr);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Filling each views values
        viewHolder.id.setText(passengerModel.getId());
        viewHolder.name.setText(passengerModel.getName());
        viewHolder.status.setText(passengerModel.getStatus());
        viewHolder.pnr.setText(String.valueOf(passengerModel.getPnr()));
        viewHolder.seat_no.setText(passengerModel.getSeat());


        return convertView;
    }

    static class ViewHolder{
        TextView id,name,status,pnr,seat_no;

    }
}
