package com.example.fall20team04sec01_artgallery.UploadArtLists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.R;
import com.example.fall20team04sec01_artgallery.RoomDatabase.ArtistModel;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

import java.util.ArrayList;
import java.util.List;

public class SelectArtist extends AppCompatActivity {

    ListView list;
    MyDatabase myDatabase;
    ArrayList<String> name;
    ArrayList<String> email;
    ArrayList<String> country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_artist);
        list=(ListView)findViewById(R.id.ArtistList);

        myDatabase = Room.databaseBuilder(this, MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();

        name = new ArrayList<String>();
        email = new ArrayList<String>();
        country =new ArrayList<String>();

        setList();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent resultIntent = new Intent();
                // TODO Add extras or a data URI to this intent as appropriate.
                resultIntent.putExtra("Name", name.get(position));
                resultIntent.putExtra("Email",email.get(position));
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }


