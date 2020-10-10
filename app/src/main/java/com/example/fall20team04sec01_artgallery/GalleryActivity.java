package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GalleryActivity extends AppCompatActivity {
    Button art1, art2, art3, art4,art5,art6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        art1= findViewById(R.id.paint1);
        art2= findViewById(R.id.paint2);
        art3= findViewById(R.id.paint3);
        art4= findViewById(R.id.paint4);
        art5= findViewById(R.id.paint5);
        art6= findViewById(R.id.paint6);

        art1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstIntent= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(firstIntent);
            }
        });
        art2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(secondIntent);
            }
        });

        art3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdIntent= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(thirdIntent);
            }
        });

        art4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fourthIntent= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(fourthIntent);
            }
        });
        art5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fifthIntent= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(fifthIntent);
            }
        });

        art6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sixthIntent= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(sixthIntent);
            }
        });

    }
}