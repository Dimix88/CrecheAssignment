package com.example.crechesystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShowStudents extends AppCompatActivity {
    DatabaseHelper myDb;
    Button showBack;
    Button tulip;
    Button daisy;
    Button all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);
        tulip = (Button)findViewById(R.id.tulipShowBtn);
        daisy = (Button)findViewById(R.id.showFullClass);
        all = (Button)findViewById(R.id.tulipShowBtn);
        showBack = (Button)findViewById(R.id.showBackButton);
    }
    public void showBack(View v){
        Intent showToMenu = new Intent(ShowStudents.this,MainActivity.class);
        startActivity(showToMenu);
    }
    public void showAll(View v){
        Cursor res=myDb.getAllData();
        if(res.getCount()==0){
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer= new StringBuffer();
        while(res.moveToNext()) {
            buffer.append("ID:"+res.getString(0)+"\n");
            buffer.append("NAME:"+res.getString(1)+"\n");
            buffer.append("SURNAME:"+res.getString(2)+"\n");
            buffer.append("GENDER:"+res.getString(3)+"\n\n");
            buffer.append("ADDRESS:"+res.getString(4)+"\n\n");
            buffer.append("ALLERGIES:"+res.getString(5)+"\n\n");
            buffer.append("CLASS_GROUP:"+res.getString(6)+"\n\n");
        }
        showMessage("Data",buffer.toString());


    }

    public void showDaisy(View v){
        Cursor res=myDb.getAllDaisy();
        if(res.getCount()==0){
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer= new StringBuffer();
        while(res.moveToNext()) {
            buffer.append("ID:"+res.getString(0)+"\n");
            buffer.append("NAME:"+res.getString(1)+"\n");
            buffer.append("SURNAME:"+res.getString(2)+"\n");
            buffer.append("GENDER:"+res.getString(3)+"\n\n");
            buffer.append("ADDRESS:"+res.getString(4)+"\n\n");
            buffer.append("ALLERGIES:"+res.getString(5)+"\n\n");
            buffer.append("CLASS_GROUP:"+res.getString(6)+"\n\n");
        }
        showMessage("Data",buffer.toString());


    }

    public void showTulip(View v){
        Cursor res=myDb.getAllTulip();
        if(res.getCount()==0){
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer= new StringBuffer();
        while(res.moveToNext()) {
            buffer.append("ID:"+res.getString(0)+"\n");
            buffer.append("NAME:"+res.getString(1)+"\n");
            buffer.append("SURNAME:"+res.getString(2)+"\n");
            buffer.append("GENDER:"+res.getString(3)+"\n\n");
            buffer.append("ADDRESS:"+res.getString(4)+"\n\n");
            buffer.append("ALLERGIES:"+res.getString(5)+"\n\n");
            buffer.append("CLASS_GROUP:"+res.getString(6)+"\n\n");
        }
        showMessage("Data",buffer.toString());


    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }
}