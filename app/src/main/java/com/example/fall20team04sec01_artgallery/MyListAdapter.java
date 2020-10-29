package com.example.fall20team04sec01_artgallery;

import android.app.Activity;
import android.widget.ArrayAdapter;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final Integer[] imgid;

    public MyListAdapter(Activity context, String[] maintitle, Integer[] imgid) {
        super(context, R.layout.more_activity_list_view_layout, maintitle);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.maintitle = maintitle;
        this.imgid = imgid;

    }
}
