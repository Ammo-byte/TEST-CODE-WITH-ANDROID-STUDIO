package com.example.iparkit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class parkerloginactivty extends AppCompatActivity {
    private Button parkerloginbutton;
    private Button parkerregisterbutton;
    private TextView parkerregisterlink;
    private TextView parkerstatus;
    private EditText parkeremail;
    private EditText parkerpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkerloginactivty);

        parkerloginbutton =  findViewById(R.id.parker_login);
        parkerregisterbutton = findViewById(R.id.parker_register_button);
        parkerregisterlink =  findViewById(R.id.register_parker_link);
        parkerstatus =  findViewById(R.id.parker_status);
        parkeremail = findViewById(R.id.parker_email);
        parkerpassword =  findViewById(R.id.parker_password);


        parkerregisterbutton.setVisibility(View.INVISIBLE);
        parkerregisterbutton.setEnabled(false);
        parkerregisterlink.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v)
            {
                parkerloginbutton.setVisibility(View.INVISIBLE);
                parkerregisterlink.setVisibility(View.INVISIBLE);
                parkerstatus.setText("Register Customer");

                parkerregisterbutton.setVisibility(View.VISIBLE);
                parkerregisterbutton.setEnabled(true);
                return true;
            }
        });
    }

    }

