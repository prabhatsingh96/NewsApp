package com.example.fluper.newsapp.startApplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.authentication.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    private Intent splashIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature (Window.FEATURE_NO_TITLE);
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.
                LayoutParams.FLAG_FULLSCREEN);

        setContentView (R.layout.activity_splash);
        splashIntent = new Intent (this, HomeActivity.class);
        new Thread (new Runnable () {
            @Override
            public void run() {
                try {

                    Thread.sleep (4000);
                    startActivity (splashIntent);

                    finish ();

                } catch (InterruptedException ie) {
                    ie.printStackTrace ();
                }

            }
        }).start ();
    }

}

