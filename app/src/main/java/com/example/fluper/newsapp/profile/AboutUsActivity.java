package com.example.fluper.newsapp.profile;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityAboutUsBinding;

import butterknife.BindView;

public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView( R.id.include_about_us) View toolLayout;
    private ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_about_us);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_about_us);
        initControles ();
    }


    public void initControles(){
        binding.includeAboutUs.headerToolText.setText ("About Us");
        binding.includeAboutUs.headerBack.setOnClickListener (this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;

        }
    }
}
