package com.example.fall20team04sec01_artgallery;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements GalleryFragment.OnNavigationRequestedListener, HomeFragment.OnNavigationRequestedListener, AddToBagFragment.OnNavigationRequestedListener, MyCartFragment.OnNavigationRequestedListener, PaymentFragment.OnNavigationRequestedListener,MoreScreenFragment.OnNavigationRequestedListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        HomeFragment fragment = HomeFragment.newInstance();
        fragmentTransaction.add(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

}