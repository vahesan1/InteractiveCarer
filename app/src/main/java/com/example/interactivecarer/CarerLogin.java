package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CarerLogin extends AppCompatActivity {
    DatabaseHelperC dbc;
    TextView mRegisterCarer;
    TextView mHome_two;
    EditText mCarerUsername;
    EditText mCarerPassword;
    Button mCarerScreenLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carer_login);
        dbc = new DatabaseHelperC(this);
        mRegisterCarer = (TextView) findViewById(R.id.carerregister);
        mHome_two = (TextView) findViewById(R.id.home_two);
        mCarerUsername = (EditText) findViewById(R.id.carerusername);
        mCarerPassword = (EditText) findViewById(R.id.carerpassword);
        mCarerScreenLogin = (Button) findViewById(R.id.carerscreenlogin);
        mRegisterCarer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerCarer = new Intent(CarerLogin.this, CarerRegister.class);
                startActivity(registerCarer);
            }
        });

        mHome_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeScreen2 = new Intent(CarerLogin.this, MainActivity.class);
                startActivity(homeScreen2);
            }

        });
        mCarerScreenLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carerUsername = mCarerUsername.getText().toString().trim();
                String carerPassword = mCarerPassword.getText().toString().trim();
                Boolean res = dbc.checkCarer(carerUsername, carerPassword);
                if (res == true) {
                    Toast.makeText(CarerLogin.this, "Successfully Logged In Carer", Toast.LENGTH_SHORT).show();
                    Intent mCarerHome = new Intent(CarerLogin.this, CarerHome.class);
                    startActivity(mCarerHome);
                } else {
                    Toast.makeText(CarerLogin.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}