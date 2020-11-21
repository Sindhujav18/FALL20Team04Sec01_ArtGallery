package com.example.fall20team04sec01_artgallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.main_frame, HomeFragment.newInstance());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_search:
                    fragmentTransaction.replace(R.id.main_frame, SearchFragment.newInstance());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmentTransaction.replace(R.id.main_frame, CategoryFragment.newInstance());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_cart:
                    fragmentTransaction.replace(R.id.main_frame, MyCartFragment.newInstance());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_profile:
                    fragmentTransaction.replace(R.id.main_frame, MoreScreenFragment.newInstance());
                    fragmentTransaction.commit();

            }
            return false;
        }
    };

    @Override
    public void onBackPressed(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void onNavigationRequested(int fragmentLayoutId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment targetFragment = HomeFragment.newInstance();

        switch (fragmentLayoutId){
            case R.layout.activity_gallery:
                targetFragment = GalleryFragment.newInstance();
                break;
            case  R.layout.activity_add_to_bag:
                targetFragment = AddToBagFragment.newInstance();
                break;

            case  R.layout.activity_my_cart:
                targetFragment = MyCartFragment.newInstance();
                break;
            case  R.layout.activity_payment:
                targetFragment = PaymentFragment.newInstance();
                break;
            case R.layout.fragment_more_screen_fragment:
                targetFragment = MoreScreenFragment.newInstance();
                break;
            case R.layout.activity_user_details:
                targetFragment = Profile.newInstance();
                break;
            case R.layout.activity_forgot_password:
                targetFragment = Password.newInstance();
                break;
            case R.layout.activity_item_billing_address:
                targetFragment = Addresses.newInstance();
                break;
            case R.layout.activity_register:
                targetFragment = Favourities.newInstance();
                break;
            case R.layout.fragment_login:
                targetFragment = LogOut.newInstance();
                break;

        }


        fragmentTransaction.add(R.id.main_frame, targetFragment).addToBackStack(null);
        fragmentTransaction.commit();
    }
}