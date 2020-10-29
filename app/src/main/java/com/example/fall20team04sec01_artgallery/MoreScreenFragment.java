package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class MoreScreenFragment extends Fragment {

    ListView list;
    private OnNavigationRequestedListener listener;

    String[] maintitle = {
            "Profile", "Password",
            "Addresses", "Currency",
            "Favourities", "Orders", "Log Out"
    };

    Integer[] imgid={
            R.drawable.ic_profile_black_24dp,R.drawable.ic_password,
            R.drawable.ic_add,R.drawable.ic_add,
            R.drawable.ic_add,R.drawable.shopping_bag,R.drawable.ic_add
    };

    public MoreScreenFragment() {
        // Required empty public constructor
    }

    public static MoreScreenFragment newInstance() {
        MoreScreenFragment fragment = new MoreScreenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}