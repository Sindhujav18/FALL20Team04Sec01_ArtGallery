package com.example.fall20team04sec01_artgallery;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.GalleryFragmentGridView.ArtListRecyclerViewAdapter;
import com.example.fall20team04sec01_artgallery.RoomDatabase.Art;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

import java.util.List;

public class GalleryFragment extends Fragment{
    OnNavigationRequestedListener listener;

    RecyclerView recyclerView;
    MyDatabase myDatabase;

    public static String region;

    public GalleryFragment() {
        // Required empty public constructor
    }

    public static GalleryFragment newInstance(String regionName) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        region= regionName;
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
        View inflated = inflater.inflate(R.layout.activity_gallery, container, false);

        recyclerView = (RecyclerView)inflated.findViewById(R.id.recyclerView);

        myDatabase = Room.databaseBuilder(getContext(), MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();

        // Fetch All Art from Database
        List<Art> artList = myDatabase.dao().getArtByRegion(region);

        //Check id there is any art in the Gallery

        if(artList.size()>0) {

            try {

                ArtListRecyclerViewAdapter adapter = new ArtListRecyclerViewAdapter(inflated.getContext(), artList, new ArtListRecyclerViewAdapter.ItemListener() {
                    @Override
                    public void onItemClick(Art item) {
                        MainActivity mainActivity = new MainActivity();
                        mainActivity.artSelectedItem(item);
                        listener.onNavigationRequested(R.layout.activity_add_to_bag);
                        Toast.makeText(getContext(), item.getName() + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                recyclerView.setAdapter(adapter);
            }
            catch (Exception e){
                Toast.makeText(getContext(),"Something Went Wrong",Toast.LENGTH_LONG).show();
            }
        }
        else
            Toast.makeText(getContext(),"No Art",Toast.LENGTH_LONG).show();

//         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

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
