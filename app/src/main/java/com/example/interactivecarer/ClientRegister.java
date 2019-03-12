package com.example.interactivecarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClientRegister extends AppCompatActivity {
    DatabaseHelper db;
    TextView mAlreadyClient;
    EditText nClientUsername;
    EditText nClientPassword;
    EditText nClientPasswordCnf;
    Button nButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_register);
        db = new DatabaseHelper(this);
        mAlreadyClient = (TextView)findViewById(R.id.clientregisteredalready);
        nClientUsername = (EditText)findViewById(R.id.nclientusername);
        nClientPassword = (EditText)findViewById(R.id.nclientpassword);
        nClientPasswordCnf = (EditText)findViewById(R.id.nclientpassword2);
        nButton = (Button)findViewById(R.id.clientregisterbutton);
        mAlreadyClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginClientScreen = new Intent(ClientRegister.this,ClientLogin.class);
                startActivity(loginClientScreen);
            }
        });

        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nClientUser = nClientUsername.getText().toString().trim();
               String nClientPass = nClientPassword.getText().toString().trim();
               String nClientPassCnf = nClientPasswordCnf.getText().toString().trim();

               if (nClientPass.equals(nClientPassCnf)){
                    Long val = db.addClient(nClientUser,nClientPass);
                    if( val > 0){Toast.makeText(ClientRegister.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
                        Intent successfulRegister = new Intent(ClientRegister.this,ClientLogin.class);
                        startActivity(successfulRegister);

                    }
                    else {

                            Toast.makeText(ClientRegister.this, "Registration Error/Already Registered", Toast.LENGTH_SHORT).show();
                        }

                    }
               else{
                   Toast.makeText(ClientRegister.this,"Password do not match",Toast.LENGTH_SHORT).show();

               }
            }
        });
    }
}

