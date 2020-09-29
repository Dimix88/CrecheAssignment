package com.example.crechesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    TextView crecheName;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        crecheName = (TextView)findViewById(R.id.rainbow);

        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);
        crecheName.setText(buildRainbowText("Rainbow Tots"));



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent goToMenu = new Intent(LogInActivity.this,MainActivity.class);
                    startActivity(goToMenu);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                            tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private Spannable buildRainbowText(String pack_name){
        int[] colors = new int[]{Color.RED,Color.MAGENTA,Color.YELLOW,Color.GREEN,Color.BLUE,Color.RED,Color.MAGENTA,Color.YELLOW,Color.GREEN,Color.BLUE,Color.RED,Color.MAGENTA,Color.YELLOW,Color.GREEN,Color.BLUE};
        Spannable word = new SpannableString(pack_name);
        for(int i = 0; i<word.length();i++){
            word.setSpan(new ForegroundColorSpan(colors[i]),i,i+1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return word;
    }
}