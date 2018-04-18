package com.example.fluper.newsapp.authentication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private TabAdapter tabAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_home);
        tabSetUp ();
    }

    public void tabSetUp(){
        tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addTab(new LogInFragment (),"Login");
        tabAdapter.addTab(new SignUpFragment (),"Sign Up");

        binding.viewPager.setAdapter(tabAdapter);
        binding.homeTabLayout.setupWithViewPager(binding.viewPager);
    }
}
