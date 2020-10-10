package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboardActivity extends AppCompatActivity {
    Button addArtist, uploadArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        addArtist= findViewById(R.id.addartistBtn);
        uploadArt= findViewById(R.id.uploadartBtn);
        addArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(AdminDashboardActivity.this, AddArtist.class);
                startActivity(artistIntent);
            }
        });
        uploadArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uploadartIntent = new Intent(AdminDashboardActivity.this, upload_art.class);
                startActivity(uploadartIntent);
            }
        });

    }
}