package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyCartFragment extends Fragment {
    Button confirmBtn;
    OnNavigationRequestedListener listener;

    public MyCartFragment() {
        // Required empty public constructor
    }

    public static MyCartFragment newInstance() {
        MyCartFragment fragment = new MyCartFragment();
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



    }
}