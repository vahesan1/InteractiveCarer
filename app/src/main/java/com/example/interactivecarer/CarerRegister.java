package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CarerRegister extends AppCompatActivity {
    TextView mAlreadyCarer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carer_register);
        mAlreadyCarer = (TextView)findViewById(R.id.carerregisteredalready);
        mAlreadyCarer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginScreenCarer = new Intent(CarerRegister.this,CarerLogin.class);
                startActivity(loginScreenCarer);
            }
        });
    }
}
