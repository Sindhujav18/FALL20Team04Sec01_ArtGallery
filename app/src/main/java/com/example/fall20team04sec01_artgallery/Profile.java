package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Profile extends Fragment {
    public Profile() {
        // Required empty public constructor
    }

    public static Profile newInstance() {
        Profile fragment = new Profile();
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
        View inflated = inflater.inflate(R.layout.activity_user_details, container, false);

        TextView name = inflated.findViewById(R.id.user_name);
        TextView email = inflated.findViewById(R.id.user_email_id);
        TextView phoneNumber = inflated.findViewById(R.id.user_phone_no);
        TextView country = inflated.findViewById(R.id.user_country);

        name.setText(UserState.getUser().getName());
        email.setText(UserState.getUser().getEmail());
        phoneNumber.setText(UserState.getUser().getPhoneNumber());

        country.setText(UserState.getUser().getAddress());

        return inflated;
    }
}