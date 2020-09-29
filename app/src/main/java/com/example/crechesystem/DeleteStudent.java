package com.example.crechesystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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

        myDb = new DatabaseHelper(this);
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
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }
}