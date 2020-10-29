package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;

import android.content.Context;
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflated = inflater.inflate(R.layout.activity_add_to_bag, container, false);

        addToBag = inflated.findViewById(R.id.adtobagBtn);

        addToBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNavigationRequested(R.layout.activity_my_cart);
            }
        });

        return inflated;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (AddToBagFragment.OnNavigationRequestedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }

    public interface OnNavigationRequestedListener {
        public void onNavigationRequested(int fragmentLayoutId);
    }
}