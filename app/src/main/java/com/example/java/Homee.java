package com.example.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homee extends AppCompatActivity {
Button btnpracticehome;
Button calcul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homee);
        btnpracticehome=(Button) findViewById(R.id.btnpracticehome);
        calcul=(Button) findViewById(R.id.calcul);
        btnpracticehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),Acceuil.class);
                startActivity(intent);

            }
        });
calcul.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(getApplicationContext(),CalculActivity.class);
        startActivity(intent);
    }
});
    }
}