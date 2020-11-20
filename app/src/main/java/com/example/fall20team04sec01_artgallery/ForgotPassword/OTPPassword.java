package com.example.fall20team04sec01_artgallery.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.MyValidator;
import com.example.fall20team04sec01_artgallery.R;
import com.example.fall20team04sec01_artgallery.RoomDatabase.AdminCredentials;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

import java.util.Random;

import java.util.Random;

public class OTPPassword extends AppCompatActivity {

    public MyValidator validator;
    LinearLayout otpLayout,passwordLayout;
    String currentOtp;
    EditText otpEditText,passwordEditText;

    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p_password);

        otpLayout = findViewById(R.id.otpLayout);
        otpEditText = findViewById(R.id.otp_edit_text);
        passwordLayout = findViewById(R.id.passwordLayout);
        passwordEditText = findViewById(R.id.password_edit_text);

        validator = new MyValidator(this);
        myDatabase = Room.databaseBuilder(OTPPassword.this, MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();


        findViewById(R.id.continue_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(otpEditText.getText().toString().equals(currentOtp))
                {
                    otpLayout.setVisibility(View.INVISIBLE);
                    passwordLayout.setVisibility(View.VISIBLE);
                }
                else
                    Toast.makeText(getApplicationContext(),"Invalid OTP",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.resend_otp_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationSender();
            }
        });

        findViewById(R.id.passwordConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validator.passwordValidate(passwordEditText.getText().toString()));
                else
                {
                    Intent intent = getIntent();
                    try{

                        if(intent.getBooleanExtra("admin",false))
                        {
                            AdminCredentials adminCredentials = new AdminCredentials(intent.getStringExtra("email"),passwordEditText.getText().toString());
                            myDatabase.dao().adminInsert(adminCredentials);
                        }
                        else
                            myDatabase.dao().changeUserPassword(intent.getStringExtra("email"),passwordEditText.getText().toString());

                        Toast.makeText(getApplicationContext(),"Password Change Successfully",Toast.LENGTH_LONG).show();
                        finish();
                    }catch(Exception exception)
                    {
                        Toast.makeText(getApplicationContext(),exception.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        notificationSender();
    }

    public void notificationSender()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("n", "Umer", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("1234");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Random r = new Random();
        currentOtp =  Integer.toString(r.nextInt(20000 - 10000) + 10000);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "n")
                .setSmallIcon(R.drawable.search_icon)
                .setContentTitle("Otp")
                .setContentText(currentOtp)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(999,builder.build());

    }
}