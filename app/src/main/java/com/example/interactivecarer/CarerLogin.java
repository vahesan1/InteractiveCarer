package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CarerLogin extends AppCompatActivity {
    TextView mRegisterCarer;
    TextView mHome_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carer_login);
        mRegisterCarer = (TextView)findViewById(R.id.carerregister);
        mHome_two = (TextView)findViewById(R.id.home_two);
        mRegisterCarer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerCarer = new Intent(CarerLogin.this,CarerRegister.class );
                startActivity(registerCarer);
            }
        });
        mHome_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeScreen2 = new Intent(CarerLogin.this,MainActivity.class);
                startActivity(homeScreen2);
            }
        });
    }
}
