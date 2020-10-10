package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    TextView registerTV,forgotpasswordTV, adminloginTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        loginBtn = (Button) findViewById(R.id.login_button);
        registerTV= findViewById(R.id.register);
        forgotpasswordTV= findViewById(R.id.forgot_password);
        adminloginTV= findViewById(R.id.admin_login);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);
               startActivity(loginIntent);
            }
        });

        registerTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent signupIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(signupIntent);
            }
        });
       forgotpasswordTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent resetIntent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(resetIntent);
            }
        });
        adminloginTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent adminIntent = new Intent(LoginActivity.this, AdminLogin.class);
                startActivity(adminIntent);
            }
        });


    }
}