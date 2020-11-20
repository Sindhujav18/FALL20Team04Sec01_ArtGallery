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
        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.myText);
            imageView = (ImageView) v.findViewById(R.id.myImage);

        }

        public void setData(Art item) {
            this.item = item;

            Log.e("Data set : ",item.getName()+""+Uri.parse(item.getImagesPath().get(0)));
            textView.setText(item.getName());
            imageView.setImageURI(Uri.parse(item.getImagesPath().get(0)));

        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public ArtListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position) {
        Vholder.setData(mValues.get(position));
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(Art item);
    }
}

