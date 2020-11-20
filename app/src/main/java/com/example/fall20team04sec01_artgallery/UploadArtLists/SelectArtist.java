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
    ArrayList<String> country;}

