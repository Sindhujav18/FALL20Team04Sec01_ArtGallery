package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AddToBagFragment extends Fragment {
    OnNavigationRequestedListener listener;
    Button addToBag;

    public AddToBagFragment() {
        // Required empty public constructor
    }

    public static AddToBagFragment newInstance() {
        AddToBagFragment fragment = new AddToBagFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}