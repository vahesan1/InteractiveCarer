package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClientHome extends AppCompatActivity {

    Button viewCarer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home);
        viewCarer =findViewById(R.id.viewCarers);
        viewCarer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewCarersAvailable = new Intent(ClientHome.this,FindCarer.class);
                startActivity(viewCarersAvailable);
            }
        });
    }
}
