package com.example.fall20team04sec01_artgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fall20team04sec01_artgallery.ForgotPassword.ForgotPassword;
import com.example.fall20team04sec01_artgallery.RoomDatabase.AdminCredentials;
import com.example.fall20team04sec01_artgallery.RoomDatabase.MyDatabase;
import com.example.fall20team04sec01_artgallery.RoomDatabase.UserModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    TextView registerTV,forgotpasswordTV, adminloginTV;
    private static final int REQUEST = 112;
    EditText email,password;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        loginBtn = (Button) findViewById(R.id.login_button);
        registerTV= findViewById(R.id.register);
        forgotpasswordTV= findViewById(R.id.forgot_password);
        adminloginTV= findViewById(R.id.admin_login);
        email = findViewById(R.id.email_edit_text);
        password= findViewById(R.id.password_edit_text);

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (Build.VERSION.SDK_INT >= 23) {
            String[] PERMISSIONS = {android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (!hasPermissions(LoginActivity.this, PERMISSIONS)) {
                ActivityCompat.requestPermissions((Activity) this, PERMISSIONS, REQUEST );
            } else {
                //do here
            }
        } else {
            //do here
        }

        myDatabase = Room.databaseBuilder(LoginActivity.this,MyDatabase.class,"UserDb")
                .allowMainThreadQueries().build();

        defaultAdminAndUserInsertion();

        registerTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent signupIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(signupIntent);
            }
        });

        adminloginTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent adminIntent = new Intent(LoginActivity.this, AdminLogin.class);
                startActivity(adminIntent);
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(email.getText().toString().trim().matches(emailPattern)) {

                    List<UserModel> user = myDatabase.dao().getInformationAndValidate(email.getText().toString(), password.getText().toString());

                    if (user.size() < 1)
                        Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_LONG).show();

                    else {
                        UserState.setUser(user.get(0));
                        Intent loginIntent = new Intent(LoginActivity.this,  MainActivity.class);
                        startActivity(loginIntent);
                    }
                }
                else
                    Toast.makeText(getApplicationContext(),"Please enter valid email address",Toast.LENGTH_LONG).show();
            }
        });

        forgotpasswordTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent resetIntent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(resetIntent);
            }
        });

    }

    public void defaultAdminAndUserInsertion()
    {
        try {

            if(myDatabase.dao().getAdmin().size()<=0) {
                AdminCredentials adminCredentials = new AdminCredentials("email@gmail.com", "1234567");
                Long message = myDatabase.dao().adminInsert(adminCredentials);
                Log.e("DB message : ", message + "");

            }

            if(myDatabase.dao().checkEmail("default@gmail.com").size()<=0){
                UserModel user = new UserModel("Default User", "default@gmail.com", "123445677654", "1234567","Street Something USA");
                myDatabase.dao().UserInsertion(user);
            }
        }
        catch (Exception database){

            Toast.makeText(getApplicationContext(),database.getMessage(),Toast.LENGTH_LONG).show();

        }
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}