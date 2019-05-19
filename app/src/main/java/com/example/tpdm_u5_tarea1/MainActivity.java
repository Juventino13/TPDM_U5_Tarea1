package com.example.tpdm_u5_tarea1;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int SEND_MSM_PERMISSION_REQUES_CODE = 1;

    EditText number;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number= findViewById(R.id.inputnumber);
        message= findViewById(R.id.inputmessage);
        send = findViewById(R.id.button);

        send.setEnabled(false);
        if ( checkPermission(Manifest.permission.SEND_SMS)) {
            send.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this,
                    new String []{Manifest.permission.SEND_SMS },SEND_MSM_PERMISSION_REQUES_CODE);


        }

    }
    public void onSned (View v){
        String phoneNumber = number.getText().toString();
        String smsMessage = message.getText().toString();
        if (phoneNumber == null || phoneNumber.length()==0 ||
        smsMessage == null || smsMessage.length() ==0 ){
            return;
        }
        if(checkPermission(Manifest.permission.SEND_SMS)){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(null,smsMessage,null,null,null);
            Toast.makeText(this,"Message sent!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"permision denied",Toast.LENGTH_SHORT);
        }
    }
    public boolean checkPermission (String permision) {
        int check = ContextCompat.checkSelfPermission(this, permision);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}
