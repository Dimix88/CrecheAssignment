package com.example.crechesystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.crechesystem.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ShowStudents extends AppCompatActivity {
    DatabaseHelper myDb;
    Button showBack;
    Button tulip;
    Button daisy;
    Button all;
    ListView lv;
    public static Student student;
    DimitriAdapter adapter;
    public static ArrayList<Student> child = new ArrayList<>();
    public static Integer [] pics = {R.drawable.boy,R.drawable.girl};
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);
        tulip = (Button)findViewById(R.id.tulipShowBtn);
        daisy = (Button)findViewById(R.id.showFullClass);
        all = (Button)findViewById(R.id.tulipShowBtn);
        showBack = (Button)findViewById(R.id.showBackButton);
        lv = (ListView)findViewById(R.id.lister);
        myDb = new DatabaseHelper(this);


    }
    public void showBack(View v){
        Intent showToMenu = new Intent(ShowStudents.this,MainActivity.class);
        startActivity(showToMenu);
    }
    public void loadListView(View v){
        Intent intent = new Intent(ShowStudents.this, ListViewShower.class);
        text = "full";
        intent.putExtra("Value",text);
        startActivityForResult(intent,1);
    }
    public void loadListDaisyView(View v){
        Intent intentDaisy = new Intent(ShowStudents.this, ListViewShower.class);
        text = "daisy";
        intentDaisy.putExtra("Value",text);
        startActivityForResult(intentDaisy,1);
    }
    public void loadListTulipView(View v){
        Intent intentTulip = new Intent(ShowStudents.this, ListViewShower.class);
        text = "tulip";
        intentTulip.putExtra("Value",text);
        startActivityForResult(intentTulip,1);

    }
    /**
    public void showAll(View v){
        Cursor res=myDb.getAllData();

        if(res.getCount()==0){
            showMessage("Error","Nothing found");
            return;
        }
        int count = 0;
        while(res.moveToNext() && count<child.length){
            String id = res.getString(0);
            String name = res.getString(1);
            String surname = res.getString(2);
            String gender = res.getString(3);
            String address = res.getString(4);
            String allergies = res.getString(5);
            String classGroup = res.getString(6);
            student = new Student(id,name,surname,gender,address,allergies,classGroup);
            child[0] = student;

        }

        StringBuffer buffer= new StringBuffer();
        while(res.moveToNext()) {
            buffer.append("ID:"+res.getString(0)+"\n");
            buffer.append("NAME:"+res.getString(1)+"\n");
            buffer.append("SURNAME:"+res.getString(2)+"\n");
            buffer.append("GENDER:"+res.getString(3)+"\n");
            buffer.append("ADDRESS:"+res.getString(4)+"\n");
            buffer.append("ALLERGIES:"+res.getString(5)+"\n");
            buffer.append("CLASS_GROUP:"+res.getString(6)+"\n\n");
        }
        showMessage("Data",buffer.toString());


    }
     **/

    /**public void showDaisy(View v){
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
            buffer.append("GENDER:"+res.getString(3)+"\n");
            buffer.append("ADDRESS:"+res.getString(4)+"\n");
            buffer.append("ALLERGIES:"+res.getString(5)+"\n");
            buffer.append("CLASS_GROUP:"+res.getString(6)+"\n");
        }
        showMessage("Data",buffer.toString());


    }
**/
   /** public void showTulip(View v){
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
            buffer.append("GENDER:"+res.getString(3)+"\n");
            buffer.append("ADDRESS:"+res.getString(4)+"\n");
            buffer.append("ALLERGIES:"+res.getString(5)+"\n");
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
    **/

     /**   Cursor res=myDb.getAllData();

        if(res.getCount()==0){
            showMessage("Error","Nothing found");
            return;
        }

        while(res.moveToNext()){
            String id = res.getString(0);
            String name = res.getString(1);
            String surname = res.getString(2);
            String gender = res.getString(3);
            String address = res.getString(4);
            String allergies = res.getString(5);
            String classGroup = res.getString(6);
            student = new Student(id,name,surname,gender,address,allergies,classGroup);
            child.add(student);
        }

        child = (ArrayList<Student>) myDb.getListData();
        adapter = new DimitriAdapter(this,child);

        lv.setAdapter(adapter);

    }**/
}