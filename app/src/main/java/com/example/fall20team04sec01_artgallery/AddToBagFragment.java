package com.example.fall20team04sec01_artgallery;


import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.room.Room;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fall20team04sec01_artgallery.RoomDatabase.Art;
import com.example.fall20team04sec01_artgallery.RoomDatabase.FavouriteModel;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.RoomDatabase.PurchaseModel;

import java.util.List;

public class AddToBagFragment extends Fragment {
    OnNavigationRequestedListener listener;
    Button addToBag;
    MyDatabase database;
    public static Art artItem;
    Boolean isFavourite = false;

    ImageButton artImageButton, favouriteButton;
    TextView dimensions, price;

    public AddToBagFragment() {
        // Required empty public constructor
    }

    public static AddToBagFragment newInstance(Art art) {
        AddToBagFragment fragment = new AddToBagFragment();
        Bundle args = new Bundle();
        artItem = art;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_add_to_bag, container, false);

        artImageButton = view.findViewById(R.id.artBtn);
        price = view.findViewById(R.id.price);
        dimensions = view.findViewById(R.id.dimensionTV);
        favouriteButton = view.findViewById(R.id.favourite_id);

        artImageButton.setImageURI(Uri.parse(artItem.getImagesPath().get(0)));
        price.setText(artItem.getPrice() + "$");
        dimensions.setText(artItem.getDimensions());

        addToBag = view.findViewById(R.id.adtobagBtn);

        addToBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNavigationRequested(R.layout.activity_my_cart);
            }
        });

        database = Room.databaseBuilder(getContext(), MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();

        List<Art> userFavourites = database.favouriteDAO().getUsersFavourites(UserState.getUser().getEmail());

        for(Art item : userFavourites)
            if(item.getId() == artItem.getId()){
                isFavourite = true;
                break;
            }

        if(isFavourite)
            favouriteButton.setImageResource(R.drawable.ic_baseline_favorite_24);
        else
            favouriteButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);

        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavouriteModel fav = new FavouriteModel(artItem.getId(), UserState.getUser().getEmail());

                if(isFavourite){
                    database.favouriteDAO().removeFavourite(fav.getArtId(), fav.getUserEmailId());
                    favouriteButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                }

                else{
                    database.favouriteDAO().makeFavourite(fav);

                    favouriteButton.setImageResource(R.drawable.ic_baseline_favorite_24);
                }

                isFavourite = !isFavourite;
            }
        });

        return view;
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