package com.example.java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {
EditText etphone,etMessage;
Button btnsend;
Button btnsendmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        etphone= findViewById(R.id.et_phone);
        etMessage= findViewById(R.id.et_message);
        btnsend= findViewById(R.id.btnsend);
        btnsendmail= findViewById(R.id.btnsendmail);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkcondition
                if (ContextCompat.checkSelfPermission(SmsActivity.this , Manifest.permission.SEND_SMS)
            == PackageManager.PERMISSION_GRANTED){
                    //when permission is granted
                    //create method
                  sendMessage();
                }else{
                    //when permission is not granted
                    //Request Permission
                    ActivityCompat.requestPermissions(SmsActivity.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });
        btnsendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),Reclamation.class);
                startActivity(intent);
            }
        });
    }
    public void sendMessage(){
        //Getvalues from edit text
        String sPhone= etphone.getText().toString().trim();
        String sMessage= etMessage.getText().toString().trim();
        if(!sPhone.equals("")&& !sMessage.equals("")){
            SmsManager smsManager= SmsManager.getDefault();
            //send Text Message
            smsManager.sendTextMessage(sPhone,null,sMessage,null,null);
            //DisplayToast
            Toast.makeText(getApplicationContext(),"SMS SENT SUCCEFULLY",Toast.LENGTH_SHORT).show();
        }else{
            //when edit text value is blank
            //Display toast
            Toast.makeText(getApplicationContext(),"Enter value first",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //check condition
        if(requestCode==100 && grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            //when permission is granted
            //call method
            sendMessage();
        }else{
            //when permission denied
            //Display Toast
            Toast.makeText(getApplicationContext(),"Permission denied",Toast.LENGTH_SHORT).show();
        }
    }
}