package com.example.fluper.newsapp.profile;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityInviteAndEarnsBinding;

public class InviteAndEarnsActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityInviteAndEarnsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
       // setContentView (R.layout.activity_invite_and_earns);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_invite_and_earns);
        initControles ();
    }



    public void initControles(){
        binding.includeToolInviteAndEarns.headerToolText.setText ("Invite & Earn");
        binding.includeToolInviteAndEarns.headerBack.setOnClickListener (this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;
        }
    }
}
