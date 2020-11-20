package com.example.fall20team04sec01_artgallery.GalleryFragmentGridView;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fall20team04sec01_artgallery.R;
import com.example.fall20team04sec01_artgallery.RoomDatabase.Art;

import java.util.List;


public class ArtListRecyclerViewAdapter extends RecyclerView.Adapter<ArtListRecyclerViewAdapter.ViewHolder> {

    List<Art> mValues;
    Context mContext;
    protected ItemListener mListener;

    public ArtListRecyclerViewAdapter(Context context, List<Art> values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        Art item;


