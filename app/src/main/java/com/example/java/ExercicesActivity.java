package com.example.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ExercicesActivity extends AppCompatActivity {
    Button buttonhomme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);
        buttonhomme=(Button) findViewById(R.id.buttonhomme);
        buttonhomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),ExercicesActivity2.class);
                startActivity(intent);
            }
        });

    }
}