package com.example.fluper.newsapp.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityHomePageBinding;
import com.example.fluper.newsapp.profile.ProfileActivity;

import butterknife.BindView;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityHomePageBinding binding;
    MyRecyclerAdapter mMyRecyclerAdapter;
    @BindView( R.id.include_forgot_layout ) View toolLayout;

    @Override
    protected void onRestart() {
        super.onRestart ();
        binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_de);
        binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorPrimary));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_home_page);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_home_page);
        mMyRecyclerAdapter = new MyRecyclerAdapter (this);
        binding.homeRecyclerView.setLayoutManager (new LinearLayoutManager
                (this,LinearLayoutManager.HORIZONTAL,true));
        binding.homeRecyclerView.setAdapter (mMyRecyclerAdapter);
        binding.homeRecyclerVieww.setLayoutManager (new GridLayoutManager (this,2));
        binding.homeRecyclerVieww.setAdapter (mMyRecyclerAdapter);
        binding.includeBottomLayout.ivProfile.setOnClickListener (this);
        binding.includeBottomLayout.ivHome.setOnClickListener (this);
        binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_ac);
        binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorbutton));






    }

    @Override
    public void onClick(View v) {
        switch(v.getId ()){
            case R.id.home_recycler_view:
                startActivity (new Intent (this,ArticleDescriptionActivity.class));
                break;
            case R.id.iv_profile:
                binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_ac);
                binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorbutton));
                startActivity (new Intent (this, ProfileActivity.class));
                break;
            case R.id.iv_home:
                startActivity (new Intent (this, HomePageActivity.class));
                break;

        }
    }
}
