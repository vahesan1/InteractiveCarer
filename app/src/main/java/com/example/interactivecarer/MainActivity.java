package com.example.interactivecarer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;



public class MainActivity extends AppCompatActivity {

    Button mClientLogin;
    Button mCarerLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mClientLogin = (Button) findViewById(R.id.clientlogin);
        mCarerLogin = (Button) findViewById(R.id.carerlogin);

    mClientLogin.setOnClickListener(new View.OnClickListener(){

        public void onClick( View view) {
            Intent ClientLoginIntent = new Intent(MainActivity.this,ClientLogin.class);
                    startActivity(ClientLoginIntent);
            }});
    mCarerLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick( View view) {
                Intent CarerLoginIntent = new Intent(MainActivity.this,CarerLogin.class);
                startActivity(CarerLoginIntent);
            }});
    }
}


//comment test