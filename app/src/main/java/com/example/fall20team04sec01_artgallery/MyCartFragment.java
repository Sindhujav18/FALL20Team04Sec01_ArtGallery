package com.example.fall20team04sec01_artgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflated = inflater.inflate(R.layout.activity_my_cart, container, false);

        confirmBtn = inflated.findViewById(R.id.confirm_details);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNavigationRequested(R.layout.activity_payment);
            }
        });

        return inflated;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (MyCartFragment.OnNavigationRequestedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }

    public interface OnNavigationRequestedListener {
        public void onNavigationRequested(int fragmentLayoutId);
    }
}