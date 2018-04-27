package com.example.fluper.newsapp.authentication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.databinding.ActivityForgotBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgotActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView( R.id.include_forgot_layout ) View toolLayout;
    ActivityForgotBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_forgot);
        initControles ();
    }


    //All clicks events listener
    public void initControles(){
        binding.includeForgotLayout.headerBack.setOnClickListener (this);
        binding.submitForgot.setOnClickListener (this);
    }



    @Override
    public void onClick(View v) {
        switch(v.getId ()){

            case R.id.header_back:
                super.onBackPressed ();
                break;
            case R.id.submit_forgot:

                if(!Validation.isValidPassword (binding.emailForgotLay.getText ().toString ())) {
                    binding.emailForgotLay.setEnabled (true);
                    binding.emailForgotLay.setError ("Please enter email id.");
                    break;
                }
                else  if(!Validation.isValidEmail (binding.emailForgotLay.getText ().toString ())) {
                binding.emailForgotLay.setEnabled (true);
                binding.emailForgotLay.setError ("Please enter valid email id.");
                break;
            }else{
                startActivity (new Intent (this, OtpActivity.class).putExtra
                        ("key","otp"));
                binding.emailForgotLay.setText ("");
                break;
                }
        }
    }


    static class IncludedLayout {
        @BindView( R.id.header_back ) ImageView backImage;
    }
}
