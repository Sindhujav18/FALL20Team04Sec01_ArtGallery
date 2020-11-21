package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fall20team04sec01_artgallery.RoomDatabase.Art;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements GalleryFragment.OnNavigationRequestedListener, HomeFragment.OnNavigationRequestedListener, AddToBagFragment.OnNavigationRequestedListener, CartFragment.OnNavigationRequestedListener, PaymentFragment.OnNavigationRequestedListener,MoreScreenFragment.OnNavigationRequestedListener {

    static public  Art artitem;
    static public String region;

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
                    fragmentTransaction.replace(R.id.main_frame, CartFragment.newInstance(null));
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

   // Check your app on mobile phone. its hving zero percent charging please wait for two minutes
        //Send this apk to me.ok
    //are you checking the app from your mobile?yes : okay try to upload the are and buy it
    // one more thing are the login are working fine?Can we replace the project

    public void onNavigationRequested(int fragmentLayoutId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment targetFragment = HomeFragment.newInstance();

        switch (fragmentLayoutId){
            case R.layout.activity_gallery:
                targetFragment = GalleryFragment.newInstance(region);
                break;
            case  R.layout.activity_add_to_bag:
                targetFragment = AddToBagFragment.newInstance(artitem);
                break;

            case  R.layout.activity_my_cart:
                targetFragment = CartFragment.newInstance(artitem);
                break;
            case  R.layout.activity_payment:
                targetFragment = PaymentFragment.newInstance();
                break;
            case R.layout.more_screen_fragment:
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
            case R.layout.fragment_purchases:
                targetFragment = PurchasesFragment.newInstance();
                break;

            case R.layout.fragment_favourite_arts:
                targetFragment = FavouriteArtsFragment.newInstance();
                break;
        }

        fragmentTransaction.add(R.id.main_frame, targetFragment).addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onLogoutSignalled() {
        finish();
    }

    public void artSelectedItem(Art art)
    {
        artitem = art;
    }

    public void regionSelected(String regionName)
    {
        region = regionName;
    }
}