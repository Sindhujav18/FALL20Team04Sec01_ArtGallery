package com.example.fall20team04sec01_artgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private Button asiaGallary, africaGallary, europeGallary;
    private OnNavigationRequestedListener listener;

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
        View inflated =  inflater.inflate(R.layout.activity_home, container, false);

        asiaGallary = inflated.findViewById(R.id.asiaBtn);
        africaGallary = inflated.findViewById(R.id.africaBtn);
        europeGallary = inflated.findViewById(R.id.europeBtn);

        final MainActivity mainActivity = new MainActivity();

        asiaGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.regionSelected("ASIA");
                listener.onNavigationRequested(R.layout.activity_gallery);
            }
        });
        africaGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.regionSelected("EUROPE");
                listener.onNavigationRequested(R.layout.activity_gallery);
            }
        });
        europeGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.regionSelected("AFRICA");
                listener.onNavigationRequested(R.layout.activity_gallery);
            }
        });

        return inflated;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnNavigationRequestedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }

    public interface OnNavigationRequestedListener {
        public void onNavigationRequested(int fragmentLayoutId);
    }
}