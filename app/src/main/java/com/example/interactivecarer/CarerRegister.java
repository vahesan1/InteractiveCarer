package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CarerRegister extends AppCompatActivity {
    DatabaseHelperC dbc;
    TextView mAlreadyCarer;
    EditText nCarerUsername;
    EditText nCarerPassword;
    EditText nCarerPasswordCnf;
    Button nButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carer_register);
        dbc = new DatabaseHelperC(this);
        mAlreadyCarer = (TextView) findViewById(R.id.carerregisteredalready);
        nCarerUsername = (EditText) findViewById(R.id.ncarerusername);
        nCarerPassword = (EditText) findViewById(R.id.ncarerpassword);
        nCarerPasswordCnf = (EditText) findViewById(R.id.ncarerpassword2);
        nButton2 = (Button) findViewById(R.id.carerregisterbutton);
        mAlreadyCarer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginScreenCarer = new Intent(CarerRegister.this, CarerLogin.class);
                startActivity(loginScreenCarer);
            }
        });
        nButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carer = nCarerUsername.getText().toString().trim();
                String cpassword = nCarerPassword.getText().toString().trim();
                String carerPassCnf = nCarerPasswordCnf.getText().toString().trim();

                if (cpassword.equals(carerPassCnf)) {
                    Long val = dbc.addCarer(carer, cpassword);
                    if (val > 0) {
                        Toast.makeText(CarerRegister.this, "Successfully Registered Carer", Toast.LENGTH_SHORT).show();
                        Intent successfulRegister = new Intent(CarerRegister.this, CarerLogin.class);
                        startActivity(successfulRegister);

                    } else {

                        Toast.makeText(CarerRegister.this, "Registration Error/Already Registered", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CarerRegister.this, "Password do not match", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}