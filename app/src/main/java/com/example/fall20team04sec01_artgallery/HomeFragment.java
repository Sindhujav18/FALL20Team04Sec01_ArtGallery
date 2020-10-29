package com.example.fall20team04sec01_artgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private Button asiaGallary, africaGallary, europeGallary;
    private OnNavigationRequestedListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

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
                        Intent ini = new Intent(HomeFragment.this, HomeFragment.class);
                        startActivity(ini);
                        break;
                    case R.id.navigation_cart:
                        Intent cintent = new Intent(HomeFragment.this, my_cart.class);
                        startActivity(cintent);
                        break;
                    case R.id.navigation_dashboard:
                        Intent categoryIntent = new Intent(HomeFragment.this, CategoryFragment.class);
                        startActivity(categoryIntent);
                        break;
                    case R.id.navigation_search:
                        Intent searchIntent = new Intent(HomeFragment.this, SearchActivity.class);
                        startActivity(searchIntent);
                        break;
                }
                return true;
            }
        });

       asiaGallary.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent galleryIntent= new Intent(HomeFragment.this, GalleryFragment.class);
               startActivity(galleryIntent);
           }
       });
        africaGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent= new Intent(HomeFragment.this, GalleryFragment.class);
                startActivity(galleryIntent);
            }
        });
        europeGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent= new Intent(HomeFragment.this, GalleryFragment.class);
                startActivity(galleryIntent);
            }
        });
    }
}