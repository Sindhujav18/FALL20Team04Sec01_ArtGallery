package com.example.fall20team04sec01_artgallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fall20team04sec01_artgallery.GalleryFragmentGridView.ArtListRecyclerViewAdapter;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

import java.util.Objects;

public class FavouriteArtsFragment extends Fragment {
    protected RecyclerView favourites;

    public FavouriteArtsFragment() {
        // Required empty public constructor
    }

    public static FavouriteArtsFragment newInstance() {
        FavouriteArtsFragment fragment = new FavouriteArtsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflated = inflater.inflate(R.layout.fragment_favourite_arts, container, false);

        favourites = inflated.findViewById(R.id.favourites_recycler);

        MyDatabase database =  Room.databaseBuilder(Objects.requireNonNull(getContext()), MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();


        ArtListRecyclerViewAdapter adapter = new ArtListRecyclerViewAdapter(getContext(),
                database.favouriteDAO().getUsersFavourites(UserState.getUser().getEmail()),
                null);

        favourites.setLayoutManager(new LinearLayoutManager(getContext()));
        favourites.setAdapter(adapter);
        favourites.setHasFixedSize(true);

        return inflated;
    }
}
