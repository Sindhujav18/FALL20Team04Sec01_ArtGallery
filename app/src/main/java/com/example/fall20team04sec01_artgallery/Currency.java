package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Currency#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Currency extends Fragment {

    public Currency() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Currency newInstance() {
        Currency fragment = new Currency();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


}