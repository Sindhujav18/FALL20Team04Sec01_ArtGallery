package com.example.fall20team04sec01_artgallery;


import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Addresses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Addresses extends Fragment {

    public Addresses() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Addresses newInstance() {
        Addresses fragment = new Addresses();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_item_billing_address, container, false);
    }

}