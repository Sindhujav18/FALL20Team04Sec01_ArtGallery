package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class Orders extends Fragment {

    public Orders() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Orders newInstance() {
        Orders fragment = new Orders();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}

