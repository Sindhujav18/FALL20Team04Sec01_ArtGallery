package com.example.fall20team04sec01_artgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomnavigationView;
    private Button asiaGallary, africaGallary, europeGallary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomnavigationView= findViewById(R.id.navigation);
        asiaGallary= findViewById(R.id.asiaBtn);
        africaGallary= findViewById(R.id.africaBtn);
        europeGallary= findViewById(R.id.europeBtn);
        bottomnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent ini = new Intent(HomeActivity.this, HomeActivity.class);
                        startActivity(ini);
                        break;
                    case R.id.navigation_cart:
                        Intent cintent = new Intent(HomeActivity.this, my_cart.class);
                        startActivity(cintent);
                        break;
                    case R.id.navigation_dashboard:
                        Intent categoryIntent = new Intent(HomeActivity.this, Categories.class);
                        startActivity(categoryIntent);
                        break;
                    case R.id.navigation_search:
                        Intent searchIntent = new Intent(HomeActivity.this, SearchActivity.class);
                        startActivity(searchIntent);
                        break;
                }
                return true;
            }
        });

       asiaGallary.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent galleryIntent= new Intent(HomeActivity.this, GalleryActivity.class);
               startActivity(galleryIntent);
           }
       });
        africaGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent= new Intent(HomeActivity.this, GalleryActivity.class);
                startActivity(galleryIntent);
            }
        });
        europeGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent= new Intent(HomeActivity.this, GalleryActivity.class);
                startActivity(galleryIntent);
            }
        });
    }
}