package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.ForgotPassword.ForgotPassword;
import com.example.fall20team04sec01_artgallery.ForgotPassword.OTPPassword;
import com.example.fall20team04sec01_artgallery.RoomDatabase.AdminCredentials;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

public class AdminLogin extends AppCompatActivity {
    Button adminLogin;
    EditText email,password;
    MyValidator validator;
    TextView forgotPassword;

    MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        adminLogin = findViewById(R.id.admloginBtn);

        email = findViewById(R.id.email_edit_text);
        password = findViewById(R.id.password_edit_text);

        validator = new MyValidator(getApplicationContext());

        forgotPassword = findViewById(R.id.forgot_password);

        myDatabase = Room.databaseBuilder(AdminLogin.this, MyDatabase.class, "UserDb")
                .allowMainThreadQueries().build();

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validator.emailValidate(email.getText().toString()));

                else if(validator.passwordValidate(password.getText().toString()));

                else
                {
                    try {
                        AdminCredentials adminCredentials = myDatabase.dao().getAdmin().get(0);

                        if(email.getText().toString().equals(adminCredentials.getEmail()))
                        {
                            if(adminCredentials.getPassword().equals(password.getText().toString()))
                            {
                                Toast.makeText(getApplicationContext(),"Admin Login",Toast.LENGTH_LONG).show();

                                Intent adminhomeIntent = new Intent(AdminLogin.this, AdminDashboardActivity.class);
                                startActivity(adminhomeIntent);

                            }
                            else
                                Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_LONG).show();
                    }
                    catch (Exception database){

                        Log.e("Admin Login Error",database.getMessage());
                    }
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent otpPassword =  new Intent(AdminLogin.this, OTPPassword.class);
                otpPassword.putExtra("email","email@gmail.com");
                otpPassword.putExtra("admin",true);
                startActivityForResult(otpPassword,1);
            }
        });

    }
}