package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.ForgotPassword.ForgotPassword;
import com.example.fall20team04sec01_artgallery.RoomDatabase.AdminCredentials;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.RoomDatabase.UserModel;

import java.util.List;

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

        adminInsertion();

        registerTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent signupIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(signupIntent);
            }
        });

        adminloginTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent adminIntent = new Intent(LoginActivity.this, AdminLogin.class);
                startActivity(adminIntent);
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(email.getText().toString().trim().matches(emailPattern)) {

                    List<UserModel> user = myDatabase.dao().getInformationAndValidate(email.getText().toString(), password.getText().toString());

                    if (user.size() < 1)
                        Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_LONG).show();

                    else {
                        UserState.setUser(user.get(0));
                        Intent loginIntent = new Intent(LoginActivity.this,  MainActivity.class);
                        startActivity(loginIntent);
                    }
                }
                else
                    Toast.makeText(getApplicationContext(),"Please enter valid email address",Toast.LENGTH_LONG).show();
            }
        });

        forgotpasswordTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent resetIntent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(resetIntent);
            }
        });

    }

    public void adminInsertion()
    {
        try {

            if(myDatabase.dao().getAdmin().size()<=0) {
                AdminCredentials adminCredentials = new AdminCredentials("email@gmail.com", "1234567");
                Long message = myDatabase.dao().adminInsert(adminCredentials);
                Log.e("DB message : ", message + "");

            }
        }
        catch (Exception database){

            Toast.makeText(getApplicationContext(),database.getMessage(),Toast.LENGTH_LONG).show();

        }
    }
}