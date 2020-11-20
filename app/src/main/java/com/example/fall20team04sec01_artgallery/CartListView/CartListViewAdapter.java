package com.example.fall20team04sec01_artgallery.CartListView;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fall20team04sec01_artgallery.R;
import com.example.fall20team04sec01_artgallery.RoomDatabase.Art;

import java.util.ArrayList;

public abstract class CartListViewAdapter extends ArrayAdapter<Art> {
    public CartListViewAdapter(Context context, ArrayList<Art> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Art item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_cart_item, parent, false);
        }

        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.itemName_tv);
        ImageButton tvHome = (ImageButton) convertView.findViewById(R.id.removeItem_btn);

        // Populate the data into the template view using the data object
        assert item != null;
        tvName.setText(item.getName());

        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(item);
                onItemRemoved();
            }
        });

        return convertView;
    }

    public abstract void onItemRemoved();
}
