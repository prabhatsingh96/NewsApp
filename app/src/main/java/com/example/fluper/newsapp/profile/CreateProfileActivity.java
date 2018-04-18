package com.example.fluper.newsapp.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.authentication.OtpActivity;
import com.example.fluper.newsapp.databinding.ActivityCreateProfileBinding;
import com.example.fluper.newsapp.home.HomePageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityCreateProfileBinding binding;
    @BindView( R.id.inlude_create_tool_layout) View toolLayout;
    private IncludedLayout includeForgotLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_create_profile);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_create_profile);
        ButterKnife.bind (this);
        includeForgotLayout = new IncludedLayout ();
        ButterKnife.bind( includeForgotLayout, toolLayout );
        binding.inludeCreateToolLayout.headerToolText.setText ("Create Profile");
        binding.inludeCreateToolLayout.headerBack.setVisibility (View.GONE);
        binding.saveBtn.setOnClickListener (this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId ()){
            case R.id.saveBtn:
                if(!Validation.isValidPassword (binding.fullNameTextCreateProfile.getText ().toString ())) {
                binding.fullNameTextCreateProfile.setEnabled (true);
                binding.fullNameTextCreateProfile.setError ("Please enter full name.");

                break;
            }
                else if(!Validation.isValidPassword (binding.emailTextCreateProfile.getText ().toString ().trim ())){
                    binding.emailTextCreateProfile.setEnabled (true);
                    binding.emailTextCreateProfile.setError ("Please enter email id.");

                    break;
                }

            else if(!Validation.isValidEmail (binding.emailTextCreateProfile.getText ().toString ().trim ())){
                    binding.emailTextCreateProfile.setEnabled (true);
                    binding.emailTextCreateProfile.setError ("Please enter valid email id.");

                    break;
                }
                else if(!Validation.isValidPassword (binding.mobileTextCreateProfile.getText ().toString ().trim ())){
                    binding.mobileTextCreateProfile.setEnabled (true);
                    binding.mobileTextCreateProfile.setError ("Please enter mobile number.");

                    break;
                }

                else if(!Validation.isValidPassword (binding.intrestTextCreateProfile.getText ().toString ().trim ())){
                    binding.intrestTextCreateProfile.setEnabled (true);
                    binding.intrestTextCreateProfile.setError ("Please enter your interest.");

                    break;
                }
                else {

                    startActivity (new Intent (this, HomePageActivity.class));
                    binding.fullNameTextCreateProfile.setText ("");
                    binding.emailTextCreateProfile.setText ("");
                    binding.mobileTextCreateProfile.setText ("");
                    binding.intrestTextCreateProfile.setText ("");
                    break;
                }
        }
    }

    static class IncludedLayout {
        @BindView( R.id.header_back )
        ImageView backImage;
    }
}
