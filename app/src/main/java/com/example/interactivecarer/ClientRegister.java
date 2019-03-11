package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ClientRegister extends AppCompatActivity {
    TextView mAlreadyClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_register);
        mAlreadyClient = (TextView)findViewById(R.id.clientregisteredalready);
        mAlreadyClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginClientScreen = new Intent(ClientRegister.this,ClientLogin.class);
                startActivity(loginClientScreen);
            }
        });
    }
}
