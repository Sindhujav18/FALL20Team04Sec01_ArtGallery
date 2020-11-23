package com.example.fall20team04sec01_artgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.RoomDatabase.Art;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.UploadArtLists.SelectArtist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class upload_art extends AppCompatActivity{

    MyValidator validator;

    final int PERMISSION_CODE = 1001;
    final int IMAGE_PickCode = 1000;
    ArrayList<String> imagesPath;
    String artistEmail,country,region;

    TextView artistName;
    EditText artName,artPrice,widthDimension,heightDimension,artDescriptions;
    Spinner countrySpinner,regionSpinner;

    int currentRequestOfImage=0;

    ImageButton imageButton1,imageButton2,imageButton3;

    String[] regionList = {"ASIA","EUROPE","AFRICA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_art);

        imagesPath = new ArrayList<String>(){
            {
                add("");
                add("");
                add("");
            }
        };

        validator = new MyValidator(this);
        artName = findViewById(R.id.art_name_edit_text);
        artPrice = findViewById(R.id.price_edit_text);
        widthDimension = findViewById(R.id.width_edittext);
        heightDimension = findViewById(R.id.height_edittext);
        artDescriptions = findViewById(R.id.artDescription);
        artistName = findViewById(R.id.selectArtist);

        imageButton1 = findViewById(R.id.upload_image);
        imageButton2 = findViewById(R.id.upload_image_1);
        imageButton3 = findViewById(R.id.upload_image_2);

        // Setting Spinner For Country lIST
        countrySpinner = findViewById(R.id.countrySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryList.country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                country = CountryList.country[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        regionSpinner = findViewById(R.id.regionSpinner);
        ArrayAdapter<String> regionadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, regionList);
        regionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regionSpinner.setAdapter(regionadapter);

        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                region = regionList[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentRequestOfImage = 1;
                requestImage();
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentRequestOfImage = 2;
                requestImage();

            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentRequestOfImage = 3;
                requestImage();
            }
        });

        // Artist is selected using this Function
        findViewById(R.id.divi_artist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent selectArtist = new Intent(upload_art.this,  SelectArtist.class);
                startActivityForResult(selectArtist,2);
            }
        });


        findViewById(R.id.upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validator.nameValidate(artName.getText().toString()));
                else if(validator.priceValidate(artPrice.getText().toString()));
                else if(validator.dimensionValidate(widthDimension.getText().toString()));
                else if(validator.dimensionValidate(heightDimension.getText().toString()));
                else if(validator.artDescription(artDescriptions.getText().toString()));
                else if(validator.artistName(artistName.getText().toString()));
                else if(validator.checkImageString(imagesPath));
                else
                {
                    imagesPath.get(0);

                    Art art = new Art(artName.getText().toString().toLowerCase(),artistEmail,widthDimension.getText().toString()+"*"+
                            heightDimension.getText().toString(),country.toLowerCase(),artPrice.getText().toString(),region,imagesPath);

                    MyDatabase myDatabase = Room.databaseBuilder(upload_art.this, MyDatabase.class, "UserDb")
                            .allowMainThreadQueries().build();

                    try {
                        Long message = myDatabase.dao().ArtInsertion(art);
                        Toast.makeText(getApplicationContext(),"Uploaded"+imagesPath.get(0),Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception database){

                        Toast.makeText(getApplicationContext(),"Already Added",Toast.LENGTH_LONG).show();
                    }

                }

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMAGE_PickCode && data!=null)
        {
            Uri selectedImageUri = data.getData();

            switch(currentRequestOfImage){
                case 1:
                    imageButton1.setImageURI(selectedImageUri);
                    imagesPath.set(0,getRealPathFromURI(selectedImageUri));
                    break;
                case 2:
                    imageButton2.setImageURI(selectedImageUri);
                    imagesPath.set(1,getRealPathFromURI(selectedImageUri));
                    break;
                case 3:
                    imageButton3.setImageURI(selectedImageUri);
                    imagesPath.set(2,getRealPathFromURI(selectedImageUri));
                    break;
            }

        }
        else if(requestCode==2)
        {
            if(data!=null)
            {
                String artist = data.getStringExtra("Name");
                artistEmail = data.getStringExtra("Email");
                artistName.setText(artist);
            }
        }
    }

    void requestImage()
    {
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED)
        {
            String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};

            requestPermissions(permission,PERMISSION_CODE);
        }
        else
        {
            pickImageFromGallery();
        }
    }

    void pickImageFromGallery()
    {
        Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PickCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case PERMISSION_CODE:{

                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)

                    pickImageFromGallery();

                else
                    Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
            }
        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }



}