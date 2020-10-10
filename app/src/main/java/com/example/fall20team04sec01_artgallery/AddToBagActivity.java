package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddToBagActivity extends AppCompatActivity {

    Button addtobag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_bag);
        addtobag= findViewById(R.id.adtobagBtn);
        addtobag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bagIntent = new Intent(AddToBagActivity.this, my_cart.class);
                startActivity(bagIntent);
            }
        });
    }
}