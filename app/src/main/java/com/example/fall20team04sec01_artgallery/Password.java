package com.example.fall20team04sec01_artgallery;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.fall20team04sec01_artgallery.ForgotPassword.ForgotPassword;
import com.example.fall20team04sec01_artgallery.ForgotPassword.OTPPassword;
import com.example.fall20team04sec01_artgallery.RoomDatabase.AdminCredentials;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.RoomDatabase.UserModel;

import java.util.List;
import java.util.Random;

public class Password extends Fragment {

    public MyValidator validator;
    LinearLayout otpLayout,passwordLayout;
    String currentOtp;
    EditText otpEditText,passwordEditText;

    MyDatabase myDatabase;


    public Password() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Password newInstance() {
        Password fragment = new Password();
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
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.activity_o_t_p_password, container, false);

        view.findViewById(R.id.mainLayout).setBackgroundColor(Color.parseColor("#FDFEFE"));
        otpLayout = view.findViewById(R.id.otpLayout);
        otpEditText = view.findViewById(R.id.otp_edit_text);
        passwordLayout = view.findViewById(R.id.passwordLayout);
        passwordEditText = view.findViewById(R.id.password_edit_text);

        validator = new MyValidator(view.getContext());
        myDatabase = Room.databaseBuilder(view.getContext(), MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();


        view.findViewById(R.id.continue_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(otpEditText.getText().toString().equals(currentOtp))
                {
                    otpLayout.setVisibility(View.INVISIBLE);
                    passwordLayout.setVisibility(View.VISIBLE);
                }
                else
                    Toast.makeText(getContext(),"Invalid OTP",Toast.LENGTH_LONG).show();
            }
        });

        view.findViewById(R.id.resend_otp_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationSender();
            }
        });

        view.findViewById(R.id.passwordConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validator.passwordValidate(passwordEditText.getText().toString()));
                else
                {
                    try{
                        myDatabase.dao().changeUserPassword(UserState.getUser().getEmail(),passwordEditText.getText().toString());
                        Toast.makeText(getContext(),"Password Change Successfully",Toast.LENGTH_LONG).show();

                    }catch(Exception exception) {
                        Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        notificationSender();

        return view;
    }

    public void notificationSender()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("n", "Umer", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("1234");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Random r = new Random();
        currentOtp =  Integer.toString(r.nextInt(20000 - 10000) + 10000);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "n")
                .setSmallIcon(R.drawable.search_icon)
                .setContentTitle("Otp")
                .setContentText(currentOtp)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
        notificationManager.notify(999,builder.build());

    }
}
