package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    TextView registerTV,forgotpasswordTV, adminloginTV;

    EditText email,password;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        loginBtn = (Button) findViewById(R.id.login_button);
        registerTV= findViewById(R.id.register);
        forgotpasswordTV= findViewById(R.id.forgot_password);
        adminloginTV= findViewById(R.id.admin_login);
        email = findViewById(R.id.email_edit_text);
        password= findViewById(R.id.password_edit_text);

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        myDatabase = Room.databaseBuilder(LoginActivity.this,MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent loginIntent = new Intent(LoginActivity.this, HomeFragment.class);
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