package com.example.crechesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateStudent extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText updateID;
    EditText updateName;
    EditText updateSurname;
    EditText updateGender;
    EditText updateAddress;
    EditText updateAllergies;
    EditText updateClass;
    Button updateBack;
    Button updateStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);
        myDb = new DatabaseHelper(this);
        updateID = (EditText)findViewById(R.id.updateID);
        updateName = (EditText)findViewById(R.id.updateName);
        updateSurname = (EditText)findViewById(R.id.updateSurname);
        updateGender = (EditText)findViewById(R.id.updateGender);
        updateAddress = (EditText)findViewById(R.id.updateAddress);
        updateAllergies = (EditText)findViewById(R.id.updateAllergies);
        updateClass = (EditText)findViewById(R.id.updateClass);
        updateBack = (Button)findViewById(R.id.updateBack);
        updateStudent = (Button)findViewById(R.id.updateBtn);

    }
    public void updateBack(View v){
        Intent updateToMenu = new Intent(UpdateStudent.this,MainActivity.class);
        startActivity(updateToMenu);
    }

    public void updateData(View v){

        boolean IsUpdate= myDb.updateData(updateID.getText().toString(),
                updateName.getText().toString(),
                updateSurname.getText().toString(),
                updateGender.getText().toString(),
                updateAddress.getText().toString(),
                updateAllergies.getText().toString(),
                updateClass.getText().toString());
        if(IsUpdate==true)
        {
            Toast.makeText(UpdateStudent.this, "Data updated", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(UpdateStudent.this, "Data not updated", Toast.LENGTH_SHORT).show();
        }
    }

}