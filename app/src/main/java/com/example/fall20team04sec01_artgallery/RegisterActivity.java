package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.RoomDatabase.UserModel;

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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.getText().length()<=4)
                    Toast.makeText(getApplicationContext(),"Name is too short",Toast.LENGTH_LONG).show();
                else if(!(email.getText().toString().trim().matches(emailPattern)))
                    Toast.makeText(getApplicationContext(),"Invalid Email",Toast.LENGTH_LONG).show();
                else if(phoneNumber.getText().length()<=10)
                    Toast.makeText(getApplicationContext(),"Invalid Phone Number\nDigits should be greater than 10",Toast.LENGTH_LONG).show();
                else if(password.getText().length()<=5)
                    Toast.makeText(getApplicationContext(),"Week Password\nPassword length should be greater than 5",Toast.LENGTH_LONG).show();
                else {
                    UserModel user = new UserModel(name.getText().toString(), email.getText().toString(), phoneNumber.getText().toString(), password.getText().toString());

                    MyDatabase myDatabase = Room.databaseBuilder(RegisterActivity.this, MyDatabase.class, "UserDb")
                            .allowMainThreadQueries().build();

                    try {

                        Long message = myDatabase.dao().UserInsertion(user);
                        Log.e("DB message : ",message+"");
                        Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(in);
                    }
                    catch (Exception database){

                        Toast.makeText(getApplicationContext(),"You already have an a Account",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}