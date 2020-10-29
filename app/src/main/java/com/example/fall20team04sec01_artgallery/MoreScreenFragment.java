package com.example.fall20team04sec01_artgallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MoreScreenFragment extends Fragment {

    ListView list;
    private OnNavigationRequestedListener listener;

    String[] maintitle = {
            "Profile", "Password",
            "Addresses", "Currency",
            "Favourities", "Orders", "Log Out"
    };

    Integer[] imgid={
            R.drawable.ic_profile_black_24dp,R.drawable.ic_password,
            R.drawable.ic_add,R.drawable.ic_add,
            R.drawable.ic_add,R.drawable.shopping_bag,R.drawable.ic_add
    };

    public MoreScreenFragment() {
        // Required empty public constructor
    }

    public static MoreScreenFragment newInstance() {
        MoreScreenFragment fragment = new MoreScreenFragment();
        Bundle args = new Bundle();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_more_screen_fragment, container, false);
        MyListAdapter adapter=new MyListAdapter((Activity) getContext(), maintitle,imgid);
        list=(ListView)view.findViewById(R.id.MoreScreenList);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    listener.onNavigationRequested(R.layout.activity_user_details);
                    Toast.makeText(getContext(),"Profile",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    listener.onNavigationRequested(R.layout.activity_forgot_password);
                    Toast.makeText(getContext(),"Password",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    listener.onNavigationRequested(R.layout.activity_item_billing_address);
                    Toast.makeText(getContext(),"Addresses",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    listener.onNavigationRequested(R.layout.activity_payment);
                    Toast.makeText(getContext(),"Currency",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    listener.onNavigationRequested(R.layout.activity_register);
                    Toast.makeText(getContext(),"Favourities",Toast.LENGTH_SHORT).show();
                }
                else if(position == 5) {

                    listener.onNavigationRequested(R.layout.activity_my_cart);
                    Toast.makeText(getContext(),"Orders",Toast.LENGTH_LONG).show();
                }
                else if(position == 6){

                    listener.onNavigationRequested(R.layout.fragment_login);
                    Toast.makeText(getContext(),"Log Out",Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;
    }


    public interface OnNavigationRequestedListener {
        public void onNavigationRequested(int fragmentLayoutId);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnNavigationRequestedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }

}