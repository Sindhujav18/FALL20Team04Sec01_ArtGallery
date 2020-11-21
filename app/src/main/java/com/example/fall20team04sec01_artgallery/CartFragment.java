package com.example.fall20team04sec01_artgallery;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.CartListView.CartListViewAdapter;
import com.example.fall20team04sec01_artgallery.RoomDatabase.Art;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.RoomDatabase.PurchaseModel;

import java.util.ArrayList;
import java.util.Objects;

public class CartFragment extends Fragment {
    Button confirmBtn;
    OnNavigationRequestedListener listener;

    public static Art artItem;

    public static ArrayList<Art> boughtItemsList = new ArrayList<Art>();

    public CartFragment() {
        // Required empty public constructor
    }

    public static CartFragment newInstance(Art art) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        artItem = art;
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View inflated = inflater.inflate(R.layout.activity_my_cart, container, false);
        final TextView billingAddress = inflated.findViewById(R.id.billingAddress_tv);
        final Button shopMore = inflated.findViewById(R.id.shop_more);

        billingAddress.setText(UserState.getUser().getAddress());

        shopMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNavigationRequested(R.layout.activity_gallery);
            }
        });

        if(artItem != null){
            boughtItemsList.add(artItem);
        }

        final ListView chosenItemsListView = inflated.findViewById(R.id.chosenItems_lv);
        confirmBtn = inflated.findViewById(R.id.confirm_details);

        updateCounts(getContext(), inflated);

        CartListViewAdapter adapter = new CartListViewAdapter(getContext(), boughtItemsList) {
            @Override
            public void onItemRemoved() {
                updateCounts(getContext(), inflated);
            }
        };

        chosenItemsListView.setAdapter(adapter);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // listener.onNavigationRequested(R.layout.activity_payment);

                MyDatabase database =  Room.databaseBuilder(Objects.requireNonNull(getContext()), MyDatabase.class,"UserDb")
                        .allowMainThreadQueries().build();

                for (Art art : boughtItemsList) {
                    database.purchaseDAO().PurchaseInsertion(new PurchaseModel(art.getId(), UserState.getUser().getEmail()));
                }

                boughtItemsList = new ArrayList<>();

                Toast.makeText(getContext(), "Items bought!", Toast.LENGTH_SHORT).show();
            }
        });

        return inflated;
    }

    private void updateCounts(Context context, View inflated){
        final TextView itemTextView = inflated.findViewById(R.id.item_text_view);
        final TextView totalTextView = inflated.findViewById(R.id.total_text_view);

        itemTextView.setText(""+ boughtItemsList.size());

        int total = 0 ;

        for (Art item : boughtItemsList)
            total = total + Integer.parseInt(item.getPrice());

        totalTextView.setText(""+total);

        if(boughtItemsList.size() == 0){
            confirmBtn.setEnabled(false);
            confirmBtn.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.red, null));
            Toast.makeText(getContext(), "You must select some items before you can confirm purchases", Toast.LENGTH_SHORT).show();
        }

        else{
            confirmBtn.setEnabled(true);
            confirmBtn.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.green, null));
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (CartFragment.OnNavigationRequestedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }

    public interface OnNavigationRequestedListener {
        public void onNavigationRequested(int fragmentLayoutId);
    }
}
