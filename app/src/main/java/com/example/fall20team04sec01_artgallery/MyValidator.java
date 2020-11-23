package com.example.fall20team04sec01_artgallery;

import android.content.Context;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyValidator {

    public Context context;

    final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public MyValidator(Context context) {
        this.context = context;
    }

    public boolean emailValidate(String email){

        if(!email.trim().matches(emailPattern)){
            Toast.makeText(context,"Invalid  Email",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;
    }

    public boolean nameValidate(String name){

        if(name.length()<=4){
            Toast.makeText(context,"Name is too short",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;

    }

    public boolean phoneNumberValidate(String phoneNumber){

        if(phoneNumber.length()<=9){
            Toast.makeText(context,"Invalid Phone Number\nDigits Length should be 10 or more",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;
    }

    public boolean passwordValidate(String password){

        if(password.length()<=5){
            Toast.makeText(context,"Week Password\nPassword length should be greater than 5",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;
    }

    public boolean countryValidate(String country){

        if(country.equals("")){
            Toast.makeText(context,"Country is not selected",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;
    }

    public boolean dimensionValidate(String dimension)
    {
        if(dimension.equals(""))
        {
            Toast.makeText(context,"Dimension sholud not be empty",Toast.LENGTH_LONG).show();
            return true;
        }
        else
        {
            int number = Integer.parseInt(dimension);

            if(number>0)
                return false;
        }

        Toast.makeText(context,"Dimension should be greater than 0",Toast.LENGTH_LONG).show();
        return true;
    }

    public boolean artDescription(String description)
    {
        if(description.length()>0)
            return false;
        Toast.makeText(context,"Description Length should be 1 or more",Toast.LENGTH_LONG).show();
        return true;
    }

    public boolean artistName(String artistName)
    {
        if(artistName.equals("Select Artist"))
        {
            Toast.makeText(context,"Please Select artist",Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    public boolean priceValidate(String price)
    {
        if(!price.equals(""))
        {
            int pr = Integer.parseInt(price);
            if(pr<=0)
            {
                Toast.makeText(context,"Price should be greater then 0",Toast.LENGTH_LONG).show();
                return true;
            }
            return false;
        }

        Toast.makeText(context,"Price field is empty",Toast.LENGTH_LONG).show();
        return true;
    }

    public boolean checkImageString(List<String> image)
    {
        for(int i=0;i<3;i++)
        {
            if(image.get(i).equals(""))
            {
                Toast.makeText(context,"Image "+ (i+1) +" is not selected",Toast.LENGTH_LONG).show();
                return true;
            }
        }

        return false;
    }

    public boolean addressValidate(String address)
    {
        if(address.length()<5){
            Toast.makeText(context,"Address should be length 4 or more",Toast.LENGTH_LONG).show();
            return true;}
        return false;
    }


}
