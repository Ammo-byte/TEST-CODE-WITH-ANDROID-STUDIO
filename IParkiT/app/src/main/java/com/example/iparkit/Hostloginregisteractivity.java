package com.example.iparkit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Hostloginregisteractivity extends AppCompatActivity
{
    private Button Hostloginbutton;
    private Button Hostregisterbutton;
    private TextView Hostregisterlink;
    private TextView Hoststatus;
    private EditText Hostemail;
    private EditText Hostpassword;
    private ProgressDialog loadingbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostloginregisteractivity);

        mAuth = FirebaseAuth.getInstance();

        Hostloginbutton =  findViewById(R.id.host_login_button);
        Hostregisterbutton =  findViewById(R.id.host_register_button);
        Hostregisterlink =  findViewById(R.id.host_register);
        Hoststatus =  findViewById(R.id.host_status);
        Hostemail =  findViewById(R.id.host_email);
        Hostpassword =  findViewById(R.id.host_password);
        loadingbar= new ProgressDialog(this);


        Hostregisterbutton.setVisibility(View.INVISIBLE);
        Hostregisterbutton.setEnabled(false);
        Hostregisterlink.setOnContextClickListener(new View.OnContextClickListener()
        {
            @Override
            public boolean onContextClick(View v) {
                Hostloginbutton.setVisibility(View.INVISIBLE);
                Hostregisterlink.setVisibility(View.INVISIBLE);
                Hoststatus.setText("Register Customer");

                Hostregisterbutton.setVisibility(View.VISIBLE);
                Hostregisterbutton.setEnabled(true);
                return true;
            }
        });

        Hostregisterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Hostemail.getText().toString();
                String password = Hostpassword.getText().toString();

                registerhost(email, password);

            }
        });
    }

    private void registerhost(String email, String password)
    {
        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(Hostloginregisteractivity.this, "Please write email:", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(Hostloginregisteractivity.this, "Please write password:", Toast.LENGTH_SHORT).show();
        }

        else
        {
            loadingbar.setTitle("Driver Registration");
            Toast.makeText(Hostloginregisteractivity.this, "Please wait", Toast.LENGTH_SHORT).show();
            loadingbar.show();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())

                    {
                        Toast.makeText(Hostloginregisteractivity.this, "Host Register Successful", Toast.LENGTH_SHORT).show();
                        loadingbar.dismiss();
                    }

                else

                    {
                        Toast.makeText(Hostloginregisteractivity.this, "Registration Unsuccessful ", Toast.LENGTH_SHORT).show();
                        loadingbar.dismiss();
                    }

                }
            });
        }
    }
}
