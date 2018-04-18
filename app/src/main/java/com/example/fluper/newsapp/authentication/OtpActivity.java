package com.example.fluper.newsapp.authentication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.databinding.ActivityOtpBinding;
import com.example.fluper.newsapp.profile.ChooseCategroyActivity;
import com.example.fluper.newsapp.profile.CreateProfileActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView( R.id.include_otp_layout) View toolLayout;
    private IncludedLayout includeForgotLayout;
    private ActivityOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
       // setContentView (R.layout.activity_otp);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_otp);
        ButterKnife.bind (this);
        includeForgotLayout = new IncludedLayout ();
        ButterKnife.bind( includeForgotLayout, toolLayout );
        binding.includeOtpLayout.headerBack.setOnClickListener (this);
        binding.submitOtp.setOnClickListener (this);
        binding.includeOtpLayout.headerBack.setImageResource (R.drawable.cancel);
        binding.includeOtpLayout.headerToolText.setText ("Enter OTP");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.header_back:
                super.onBackPressed ();
                break;
            case R.id.submit_otp:

                if (!Validation.isValidPassword (binding.otp.getText ().toString ())) {
                    binding.otp.setEnabled (true);
                    binding.otp.setError ("Please enter OTP.");
                    break;
                } else {

                    if (getIntent ().getExtras ().getString ("key").equals ("otp")) {
                        startActivity (new Intent (this, ResetPasswordActivity.class));
                        binding.otp.setText ("");
                        break;
                    }
                    if (getIntent ().getExtras ().getString ("key").equals ("o")) {

                        startActivity (new Intent (this, ChooseCategroyActivity.class));
                        binding.otp.setText ("");
                        break;
                    }
                }
        }
    }

    static class IncludedLayout {
        @BindView( R.id.header_back ) ImageView backImage;
    }
}
