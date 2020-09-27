package com.example.crechesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteStudent extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText deleteID;
    Button deleteBack;
    Button deleteButton;
    Button showDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        deleteID = (EditText)findViewById(R.id.delID);
        deleteBack = (Button)findViewById(R.id.backDelBtn);
        deleteButton = (Button)findViewById(R.id.delStudentBtn);
        showDel = (Button)findViewById(R.id.fullClassBtn);

    }
    public void deleteBack(View v){
        Intent delToMenu = new Intent(DeleteStudent.this,MainActivity.class);
        startActivity(delToMenu);
    }
    public void deleteStudent(View v){
        Integer deletedRows = myDb.deleteData(deleteID.getText().toString());
        if (deletedRows > 0) {
            Toast.makeText(DeleteStudent.this, "Data deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(DeleteStudent.this, "Data not deleted", Toast.LENGTH_SHORT).show();
        }
    }
}