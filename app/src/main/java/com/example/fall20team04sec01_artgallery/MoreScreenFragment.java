package com.example.fall20team04sec01_artgallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MoreScreenFragment extends Fragment {
    private OnNavigationRequestedListener listener;

    public MoreScreenFragment() {
        // Required empty public constructor
    }

    public static MoreScreenFragment newInstance() {
        MoreScreenFragment fragment = new MoreScreenFragment();
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
        View inflated = inflater.inflate(R.layout.more_screen_fragment, container, false);

        LinearLayout profile = inflated.findViewById(R.id.profile_lv);
        LinearLayout password = inflated.findViewById(R.id.passwords_lv);
        LinearLayout orders = inflated.findViewById(R.id.orders_lv);
        LinearLayout favourites = inflated.findViewById(R.id.favourites_lv);
        LinearLayout logout = inflated.findViewById(R.id.logout_lv);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNavigationRequested(R.layout.activity_user_details);
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNavigationRequested(R.layout.activity_forgot_password);
            }
        });

        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNavigationRequested(R.layout.fragment_purchases);
            }
        });

        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNavigationRequested(R.layout.fragment_favourite_arts);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLogoutSignalled();
            }
        });

        return inflated;
    }


    public interface OnNavigationRequestedListener {
        public void onNavigationRequested(int fragmentLayoutId);
        public void onLogoutSignalled();
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

}