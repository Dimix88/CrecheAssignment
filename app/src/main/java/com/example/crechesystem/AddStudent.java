package com.example.crechesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText addName;
    EditText addSurname;
    EditText addGender;
    EditText addAddress;
    EditText addAllergies;
    EditText addClassGroup;
    Button addBack;
    Button addCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        myDb = new DatabaseHelper(this);
        addName = (EditText)findViewById(R.id.nameField2);
        addSurname = (EditText)findViewById(R.id.surnameField);
        addGender = (EditText)findViewById(R.id.genderField2);
        addAddress = (EditText)findViewById(R.id.addressField);
        addAllergies = (EditText)findViewById(R.id.allergiesField);
        addClassGroup = (EditText)findViewById(R.id.classGroupField);
        addBack = (Button)findViewById(R.id.addBack);
        addCreate = (Button)findViewById(R.id.create);

    }

    public void toMenu(View v){
        Intent addToMenu = new Intent(AddStudent.this,MainActivity.class);
        startActivity(addToMenu);
    }

    public void addStudent(View v){


        boolean Isinserted= myDb.insertData(addName.getText().toString(),
                addSurname.getText().toString(),
                addGender.getText().toString(),
                addAddress.getText().toString(),
                addAllergies.getText().toString(),
                addClassGroup.getText().toString());
        if (Isinserted==true)
        {
            Toast.makeText(AddStudent.this, "Data inserted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(AddStudent.this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }
}