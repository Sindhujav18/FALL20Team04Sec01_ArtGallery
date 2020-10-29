package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Favourities extends Fragment {



    public Favourities() {
        // Required empty public constructor
    }

    public static Favourities newInstance() {
        Favourities fragment = new Favourities();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}