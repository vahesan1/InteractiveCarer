package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClientLogin extends AppCompatActivity {
    DatabaseHelper db;
    TextView mRegisterClient;
    TextView mHome;
    EditText mClientUsername;
    EditText mClientPassword;
    Button mClientScreenLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        db = new DatabaseHelper(this);
        mRegisterClient = (TextView) findViewById(R.id.clientregister);
        mHome = (TextView)findViewById(R.id.home);
        mClientUsername = (EditText)findViewById(R.id.clientusername);
        mClientPassword = (EditText)findViewById(R.id.clientpassword);
        mClientScreenLogin = (Button)findViewById(R.id.clientscreenlogin);


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

        mClientScreenLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clientUsername = mClientUsername.getText().toString().trim();
                String clientPassword = mClientPassword.getText().toString().trim();
                Boolean res = db.checkClient(clientUsername,clientPassword);
                if (res == true)
                {
                    Toast.makeText(ClientLogin.this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
                    Intent mClientHome = new Intent(ClientLogin.this,ClientHome.class);
                    startActivity(mClientHome);
                }
                else
                {
                    Toast.makeText(ClientLogin.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
