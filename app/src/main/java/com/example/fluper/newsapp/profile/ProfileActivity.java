package com.example.fluper.newsapp.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityProfileBinding;
import com.example.fluper.newsapp.home.HomePageActivity;

public class ProfileActivity extends AppCompatActivity  implements View.OnClickListener{

    private ActivityProfileBinding binding;

    @Override
    protected void onRestart() {
        super.onRestart ();
        binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_de);
        binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorPrimary));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
       // setContentView (R.layout.activity_profile);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_profile);
        binding.editProfile.setOnClickListener (this);
        binding.settig.setOnClickListener (this);
        binding.includeBottomLayout.ivProfile.setOnClickListener (this);
        binding.includeBottomLayout.ivHome.setOnClickListener (this);
        binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_ac);
        binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorbutton));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.edit_profile:
                startActivity (new Intent (this, EditProfileActivity.class));
                break;
            case R.id.settig:
                startActivity (new Intent (this, SettingActivity.class));
                break;
            case R.id.iv_profile:
               startActivity (new Intent (this, ProfileActivity.class));
                break;
            case R.id.iv_home:
                binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_ac);
                binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorbutton));
                startActivity (new Intent (this, HomePageActivity.class));
                break;

        }
    }
}
