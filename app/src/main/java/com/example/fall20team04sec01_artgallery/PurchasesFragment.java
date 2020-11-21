package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fall20team04sec01_artgallery.GalleryFragmentGridView.ArtListRecyclerViewAdapter;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.RoomDatabase.PurchaseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PurchasesFragment extends Fragment {
    protected RecyclerView purchases;

    public PurchasesFragment() {
    }

    public static PurchasesFragment newInstance() {
        return new PurchasesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflated = inflater.inflate(R.layout.fragment_purchases, container, false);

        purchases = inflated.findViewById(R.id.purchases_recycler);

        MyDatabase database =  Room.databaseBuilder(Objects.requireNonNull(getContext()), MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();


        ArtListRecyclerViewAdapter adapter = new ArtListRecyclerViewAdapter(getContext(),
                database.purchaseDAO().getUsersPurchases(UserState.getUser().getEmail()),
                null);

        purchases.setLayoutManager(new LinearLayoutManager(getContext()));
        purchases.setAdapter(adapter);
        purchases.setHasFixedSize(true);

        return inflated;
    }
}
