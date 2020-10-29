package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

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
}