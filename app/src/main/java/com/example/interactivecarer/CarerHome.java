package com.example.interactivecarer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CarerHome extends AppCompatActivity {

   DatabaseHelperD dbd;
   EditText Carer_Username;
   EditText Carer_mail;
   EditText Carer_location;
   EditText Carer_contact;
   EditText Carer_type;
   Button Carer_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carer_home);

        dbd = new DatabaseHelperD(this);

        Carer_Username = findViewById(R.id.dCarerUsername);
        Carer_mail = findViewById(R.id.dCarerEmail);
        Carer_location = findViewById(R.id.dCarerLocation);
        Carer_contact = findViewById(R.id.dCarerContact);
        Carer_type = findViewById(R.id.dCarerType);
        Carer_info = findViewById(R.id.saveCarerInfo);

        Carer_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dcarer = Carer_Username.getText().toString();
                if (!dcarer.equals("") && dbd.insertData(dcarer)){
                    Toast.makeText(CarerHome.this,"Carer Information Added",Toast.LENGTH_SHORT).show();
                    Carer_Username.setText("");
                } else {
                    Toast.makeText(CarerHome.this,"Information not added",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
