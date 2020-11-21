package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.RoomDatabase.ArtistModel;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

public class AddArtist extends AppCompatActivity {

    EditText email,name,phoneNumber,country;

    MyValidator validator;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_artist);

        email = findViewById(R.id.email_edit_text);
        name = findViewById(R.id.Address);
        phoneNumber = findViewById(R.id.contact_number_edit_text);
        country = findViewById(R.id.country_edit_text);

        validator = new MyValidator(getApplicationContext());


        findViewById(R.id.done_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validator.nameValidate(name.getText().toString()));
                else if(validator.emailValidate(email.getText().toString()));
                else if(validator.phoneNumberValidate(phoneNumber.getText().toString()));
                else if(validator.countryValidate(country.getText().toString()));
                else {

                    ArtistModel artist = new ArtistModel(name.getText().toString().toLowerCase(), email.getText().toString(), phoneNumber.getText().toString(), country.getText().toString());

                    MyDatabase myDatabase = Room.databaseBuilder(AddArtist.this, MyDatabase.class, "UserDb")
                            .allowMainThreadQueries().build();

                    try {

                        Long message = myDatabase.dao().ArtistInsertion(artist);
                        Log.e("DB message : ",message+"");
                        Toast.makeText(getApplicationContext(),"Artist Added",Toast.LENGTH_SHORT).show();
                        //startActivity(in);
                    }
                    catch (Exception database){

                        Toast.makeText(getApplicationContext(),"You already have an a Account",Toast.LENGTH_LONG).show();
                    }

                }
            }

        });
    }
}