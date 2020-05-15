package com.bryanpoh.c347_p04_demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnGetTasks;
    TextView tvResults;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);

        lv = (ListView) this.findViewById(R.id.listView);



        btnGetTasks.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                task = new ArrayList<Task>();

                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                ArrayList<Task> taskData = db.getTasks();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    task.add(new Task(taskData.get(i).getId(), taskData.get(i).getDescription(), taskData.get(i).getDate()));

                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);
                aa = new TaskAdapter(MainActivity.this, R.layout.row, task);
                lv.setAdapter(aa);
            }
        }));
    }
}