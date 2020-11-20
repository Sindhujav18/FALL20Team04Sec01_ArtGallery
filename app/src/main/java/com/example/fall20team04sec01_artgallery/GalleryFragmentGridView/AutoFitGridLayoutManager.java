package com.example.fall20team04sec01_artgallery.GalleryFragmentGridView;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by anupamchugh on 05/03/17.
 */

public class AutoFitGridLayoutManager extends GridLayoutManager {

    private int columnWidth;
    private boolean columnWidthChanged = true;

    public AutoFitGridLayoutManager(Context context, int columnWidth) {
        super(context, 1);

        setColumnWidth(columnWidth);
    }


    public void setColumnWidth(int newColumnWidth) {
        if (newColumnWidth > 0 && newColumnWidth != columnWidth) {
            columnWidth = newColumnWidth;
            columnWidthChanged = true;
        }
