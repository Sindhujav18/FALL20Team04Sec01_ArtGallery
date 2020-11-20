package com.example.fall20team04sec01_artgallery.ForgotPassword;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.fall20team04sec01_artgallery.R;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;

public class OTPPassword {

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
    }


}
