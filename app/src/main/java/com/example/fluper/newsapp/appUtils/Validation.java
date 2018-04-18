package com.example.fluper.newsapp.appUtils;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;

/**
 * Created by fluper on 13/4/18.
 */

public class Validation {

    private Context context;
    public Validation(Context context) {
        this.context = context;
    }

    public  static boolean isValidEmail(String email){

        if (email.equals(""))
        {
            return false;
        }
        else {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

    }

    //password validation
    public static boolean isValidPassword(String password) {
        if (password.equals("")) {
            return false;
        }else
            return true;
    }
}
