package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ClientLogin extends AppCompatActivity {
    DatabaseHelper db;
    TextView mRegisterClient;
    TextView mHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        db = new DatabaseHelper(this);
        mRegisterClient = (TextView) findViewById(R.id.clientregister);
        mHome = (TextView)findViewById(R.id.home);
        mRegisterClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerClient = new Intent(ClientLogin.this,ClientRegister.class );
                startActivity(registerClient);
            }
        });
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainScreen = new Intent(ClientLogin.this,MainActivity.class);
                startActivity(mainScreen);
            }
        });
    }
}
