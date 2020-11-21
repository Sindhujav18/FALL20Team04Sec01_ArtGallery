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

    EditText name,email,phoneNumber,password,address;
    Button btn;
    MyValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        validator = new MyValidator(getApplicationContext());

        btn = findViewById(R.id.create_account_button);
        name = findViewById(R.id.name_edit_text);
        email = findViewById(R.id.email_edit_text);
        phoneNumber = findViewById(R.id.phone_edit_text);
        password = findViewById(R.id.r_password_edit_text);
        address = findViewById(R.id.r_address_edit_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validator.nameValidate(name.getText().toString()));

                else if(validator.emailValidate(email.getText().toString()));

                else if(validator.phoneNumberValidate(phoneNumber.getText().toString()));

                else if(validator.passwordValidate(password.getText().toString()));

                else if(validator.addressValidate(address.getText().toString()));

                else {

                    UserModel user = new UserModel(name.getText().toString(), email.getText().toString(), phoneNumber.getText().toString(), password.getText().toString(),address.getText().toString());

                    MyDatabase myDatabase = Room.databaseBuilder(RegisterActivity.this, MyDatabase.class, "UserDb")
                            .allowMainThreadQueries().build();

                    try {

                        Long message = myDatabase.dao().UserInsertion(user);

                        Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(in);

                        Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_LONG).show();

                    }
                    catch (Exception database){

                        Toast.makeText(getApplicationContext(),"You already have an a Account",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}