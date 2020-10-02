package com.example.crechesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crechesystem.model.User;

public class Registration extends AppCompatActivity {

    EditText name;
    EditText password;
    Button reg;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText)findViewById(R.id.nameReg);
        password = (EditText)findViewById(R.id.passW);
        reg = (Button)findViewById(R.id.registerUser);
        db = new DatabaseHelper(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    db.addUser(new User(name.getText().toString(), password.getText().toString()));
                    Toast.makeText(Registration.this, "Added User", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    password.setText("");
                }else{
                    Toast.makeText(Registration.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    private boolean emptyValidation() {
        if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }
}