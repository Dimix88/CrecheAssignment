package com.example.crechesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button add;
    Button update;
    Button delete;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button)findViewById(R.id.addbtn);
        update = (Button)findViewById(R.id.updateBtn);
        delete = (Button)findViewById(R.id.delBtn);
        show = (Button)findViewById(R.id.showbtn);
    }

    public void toAdd(View v){
        Intent goToAdd = new Intent(MainActivity.this,AddStudent.class);
        startActivity(goToAdd);
    }
    public void toUpdate(View v){
        Intent goToUpdate = new Intent(MainActivity.this,UpdateStudent.class);
        startActivity(goToUpdate);
    }
    public void toDelete(View v){
        Intent goToDel = new Intent(MainActivity.this,DeleteStudent.class);
        startActivity(goToDel);
    }
    public void toShow(View v){
        Intent goToShow = new Intent(MainActivity.this,ShowStudents.class);
        startActivity(goToShow);
    }
}