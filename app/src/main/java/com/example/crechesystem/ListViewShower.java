package com.example.crechesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.crechesystem.model.Student;

import java.util.ArrayList;

public class ListViewShower extends AppCompatActivity {

    DatabaseHelper myDb;
    ListView lv;
    DimitriAdapter adapter;
    String text;
    public static ArrayList<Student> child = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_shower);
       lv = (ListView)findViewById(R.id.lister);
        myDb = new DatabaseHelper(this);
        text=getIntent().getExtras().getString("Value");
        if(text.equalsIgnoreCase("full")) {
            child = (ArrayList<Student>) myDb.getListData();
        }
            else if(text.equalsIgnoreCase("daisy")){
                child = (ArrayList<Student>) myDb.getListDaisyData();
            }
                else if(text.equalsIgnoreCase("tulip")){
                        child = (ArrayList<Student>) myDb.getListTulipData();
                    }
        adapter = new DimitriAdapter(this,child);

        lv.setAdapter(adapter);
    }
}