package com.example.iparkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity
{
    private Button WelcomeHostbutton;
    private Button WelcomeParkerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        WelcomeHostbutton = (Button) findViewById(R.id.welcome_host_btn);
        WelcomeParkerbutton = (Button) findViewById(R.id.welcome_parker_btn);

        WelcomeHostbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent loginregisterhostintent = new Intent(WelcomeActivity.this, Hostloginregisteractivity.class);
                startActivity(loginregisterhostintent);
            }
        });

        WelcomeParkerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent loginregisterparkerintent = new Intent(WelcomeActivity.this, parkerloginactivty.class);
                startActivity(loginregisterparkerintent);
            }
        });
    }
}
