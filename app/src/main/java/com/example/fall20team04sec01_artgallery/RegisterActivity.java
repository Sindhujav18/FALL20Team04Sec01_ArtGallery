package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText name,email,phoneNumber,password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn = findViewById(R.id.create_account_button);

        name = findViewById(R.id.name_edit_text);
        email = findViewById(R.id.email_edit_text);
        phoneNumber = findViewById(R.id.phone_edit_text);
        password = findViewById(R.id.r_password_edit_text);

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    }
}