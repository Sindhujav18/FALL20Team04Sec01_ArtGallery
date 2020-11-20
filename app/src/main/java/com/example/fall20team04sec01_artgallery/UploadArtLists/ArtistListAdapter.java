package com.example.fall20team04sec01_artgallery.UploadArtLists;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fall20team04sec01_artgallery.R;

import java.util.ArrayList;


public class ArtistListAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final ArrayList<String> name;
        private final ArrayList<String> email;
        private final ArrayList<String> country;

        public ArtistListAdapter(Activity context, ArrayList<String> name, ArrayList<String> email, ArrayList<String> country) {
            super(context, R.layout.artist_list_adapter,name);
            // TODO Auto-generated constructor stub

            this.context = context;
            this.name = name;
            this.email = email;
            this.country = country;

        }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.artist_list_adapter, null,true);

        TextView nameText = (TextView) rowView.findViewById(R.id.Name);
        TextView emailText = (TextView) rowView.findViewById(R.id.Email);
        TextView countryText = (TextView) rowView.findViewById(R.id.Country);

        nameText.setText("Name : "+name.get(position));
        emailText.setText("Email : "+email.get(position));
        countryText.setText("Country : "+country.get(position));


        return rowView;

    };

    }
