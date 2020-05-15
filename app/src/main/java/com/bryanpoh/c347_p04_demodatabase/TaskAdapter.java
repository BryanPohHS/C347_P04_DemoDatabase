package com.bryanpoh.c347_p04_demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter  extends ArrayAdapter<Task>{
        private ArrayList<Task> task;
        private Context context;
        private TextView tvID, tvDesc, tvDate;
        private ImageView ivStar;

        public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
            super(context, resource, objects);

            // Store the food that is passed into this adapter
            task = objects;
            this.context = context;
        }

        // getView() is the method Listview will call to get the view object everytime listview needs a row
        @Override
        public View getView(int position, View converView, ViewGroup parent){
            // inflate xml into view object
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Inflate the row.xml as layout for view object
            View rowView = inflater.inflate(R.layout.row, parent, false);

            // Get the tv object
            tvID = rowView.findViewById(R.id.tvID);
            tvDesc = rowView.findViewById(R.id.tvDesc);
            tvDate = rowView.findViewById(R.id.tvDate);

            // position = index of row that lv is requesting. Get food at same index
            Task currTask = task.get(position);

            // Set tv to show food
            tvID.setText(Integer.toString(currTask.getId()));
            tvDesc.setText(currTask.getDescription());
            tvDate.setText(currTask.getDate());

            return rowView;

        }
}
