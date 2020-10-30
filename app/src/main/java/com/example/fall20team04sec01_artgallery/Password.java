package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class Password extends Fragment {

    public Password() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Password newInstance() {
        Password fragment = new Password();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}

