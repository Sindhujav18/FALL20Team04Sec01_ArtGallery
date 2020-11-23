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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.GalleryFragmentGridView.ArtListRecyclerViewAdapter;
import com.example.fall20team04sec01_artgallery.RoomDatabase.Art;
import com.example.fall20team04sec01_artgallery.RoomDatabase.ArtistModel;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    GalleryFragment.OnNavigationRequestedListener listener;
    RecyclerView recyclerView;
    MyDatabase myDatabase;
    SearchView searchView;
    RadioGroup radioGroup;
    List<Art> artList;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
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
        final View inflated = inflater.inflate(R.layout.activity_search, container, false);
        recyclerView = (RecyclerView)inflated.findViewById(R.id.recycler_view);
        searchView = (SearchView) inflated.findViewById(R.id.search);
        radioGroup = (RadioGroup) inflated.findViewById(R.id.radio_action);
        myDatabase = Room.databaseBuilder(getContext(), MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = inflated.findViewById(selectedId);
                artList = new ArrayList<Art>();

                switch (radioButton.getTag().toString()){
                    case "Country":
                        artList = myDatabase.dao().getArtByCountry(query.toLowerCase());
                        break;
                    case "Gallery":
                        artList = myDatabase.dao().getArtByName(query.toLowerCase());
                        break;
                    case "Artist":
                        List<ArtistModel> findingArtistByName = myDatabase.dao().getArtistUsingName(query.toLowerCase());
                        for(int i=0;i<findingArtistByName.size();i++)
                            artList = myDatabase.dao().getArtistUsingEmail(findingArtistByName.get(i).getEmail());
                        break;
                }

                if(artList.size()>0) {
                    try {
                        settingRecyclerView(inflated.getContext());
                    }
                    catch (Exception e){
                        Toast.makeText(getContext(),"Something Went Wrong",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getContext(),"No Art",Toast.LENGTH_LONG).show();
                    settingRecyclerView(inflated.getContext());
                }

                //AutoFitGridLayoutManager that auto fits the cells by the column width defined.
                GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(manager);
                System.out.println(myDatabase.purchaseDAO().getUsersPurchases(UserState.getUser().getEmail()));

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });

        return inflated;
    }

    public void settingRecyclerView(Context context)
    {
        ArtListRecyclerViewAdapter adapter = new ArtListRecyclerViewAdapter(context, artList, new ArtListRecyclerViewAdapter.ItemListener() {
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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (GalleryFragment.OnNavigationRequestedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }

    public interface OnNavigationRequestedListener {
        public void onNavigationRequested(int fragmentLayoutId);
    }

}