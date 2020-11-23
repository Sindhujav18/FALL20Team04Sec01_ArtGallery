package com.example.fall20team04sec01_artgallery.ForgotPassword;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.R;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.RoomDatabase.UserModel;

import java.util.List;

public class ForgotPassword extends AppCompatActivity {


    EditText emailEditText;

    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = findViewById(R.id.email_edit_text);

        myDatabase = Room.databaseBuilder(ForgotPassword.this,MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();


        findViewById(R.id.continue_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();

                List<UserModel> emails= myDatabase.dao().checkEmail(email);

                if(emails.size()>=1)
                {
                    Intent otpPassword =  new Intent(ForgotPassword.this,OTPPassword.class);
                    otpPassword.putExtra("email",email);
                    startActivityForResult(otpPassword,1);
                }
                else
                    Toast.makeText(getApplicationContext(),"Invalid Email",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
    }
}