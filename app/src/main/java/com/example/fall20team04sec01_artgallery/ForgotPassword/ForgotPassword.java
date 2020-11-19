package com.example.fall20team04sec01_artgallery.ForgotPassword;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fall20team04sec01_artgallery.R;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

public class ForgotPassword extends AppCompatActivity {


    EditText emailEditText;

    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = findViewById(R.id.email_edit_text);
    }
}

