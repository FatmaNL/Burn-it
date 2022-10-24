package com.example.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Acceuil extends AppCompatActivity {
    Button buttonhomme;
    Button buttonfemme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        buttonhomme=(Button) findViewById(R.id.buttonhomme);
        buttonfemme=(Button) findViewById(R.id.buttonfemme);
        buttonhomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),ExercicesActivity.class);
                startActivity(intent);
            }
        });
        buttonfemme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),WomenExercices.class);
                startActivity(intent);
            }
        });
    }
}