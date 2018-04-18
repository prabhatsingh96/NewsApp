package com.example.fluper.newsapp.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.authentication.HomeActivity;
import com.example.fluper.newsapp.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivitySettingBinding binding;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_setting);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_setting);
        binding.inludeToolSettting.headerToolText.setText ("Settings");
        binding.logout.setOnClickListener (this);
        binding.inludeToolSettting.headerBack.setOnClickListener (this);
        binding.terms.setOnClickListener (this);
        binding.aboutUs.setOnClickListener (this);
        binding.privacyPolicy.setOnClickListener (this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){

            case R.id.logout:
                inflateLayout (R.layout.log_out_dialog_layout);
                break;
            case R.id.header_back:
                super.onBackPressed ();
                break;
            case R.id.terms:
                startActivity (new Intent (this, TermsAndConditionActivity.class));
                break;
            case R.id.about_us:
                startActivity (new Intent (this, AboutUsActivity.class));
                break;
            case R.id.privacy_Policy:
                startActivity (new Intent (this, PrivacyPolicyActivity.class));
                break;
        }
    }



    //inflate layouts
    public View inflateLayout(int layout){

        final Intent yesIntent = new Intent (this, HomeActivity.class);
        builder  = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);
        view.findViewById (R.id.logout_yes_btn).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (yesIntent);
            }
        });

        view.findViewById (R.id.logout_no_btn).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss ();
            }
        });
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable (Color.TRANSPARENT));
        alertDialog.show();
        return view;
    }

  /*  public void addFirstFragment(){

        android.support.v4.app.FragmentManager frg = getSupportFragmentManager();
        FragmentTransaction ft = frg.beginTransaction();
        ft.add(R.id.share_opp_fragment_container, new ShareOpportunityFragmentOne());
        ft.commit();
    }*/
}
