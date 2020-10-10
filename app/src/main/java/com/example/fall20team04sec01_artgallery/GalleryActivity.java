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
        art1= (Button)findViewById(R.id.paint1);
        art2= (Button)findViewById(R.id.paint2);
        art3= (Button)findViewById(R.id.paint3);
        art4= (Button)findViewById(R.id.paint4);
        art5= (Button)findViewById(R.id.paint5);
        art6= (Button)findViewById(R.id.paint6);

        art1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inpaint1= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(inpaint1);
            }
        });

        art2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inpaint2= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(inpaint2);
            }
        });

        art3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inpaint3= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(inpaint3);
            }
        });

        art4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inpaint4= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(inpaint4);
            }
        });

        art5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inpaint5= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(inpaint5);
            }
        });

        art6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inpaint6= new Intent(GalleryActivity.this, AddToBagActivity.class);
                startActivity(inpaint6);
            }
        });

    }
}