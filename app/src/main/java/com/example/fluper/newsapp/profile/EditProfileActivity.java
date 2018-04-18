package com.example.fluper.newsapp.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.authentication.ChangePasswordActivity;
import com.example.fluper.newsapp.databinding.ActivityEditProfileBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView( R.id.inlude_create_tool_layout) View toolLayout;
    private IncludedLayout includeForgotLayout;
    private ActivityEditProfileBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
       // setContentView (R.layout.activity_edit_profile);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_edit_profile);
        ButterKnife.bind (this);
        includeForgotLayout = new IncludedLayout ();
        ButterKnife.bind( includeForgotLayout, toolLayout );
        binding.inludeCreateToolLayout.headerToolText.setText ("Edit Profile");
        binding.inludeCreateToolLayout.headerBack.setOnClickListener (this);
        binding.saveBtn.setOnClickListener (this);
        binding.changePasswordCreate.setOnClickListener (this);
        

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;
            case R.id.change_password_create:
                startActivity (new Intent (this, ChangePasswordActivity.class));
                break;

            case R.id.saveBtn:
                if(!Validation.isValidPassword (binding.fullNameTextCreateProfilee.getText ().toString ())) {
                    binding.fullNameTextCreateProfilee.setEnabled (true);
                    binding.fullNameTextCreateProfilee.setError ("Please enter full name.");

                    break;
                }
                else if(!Validation.isValidPassword (binding.emailTextCreateProfilee.getText ().toString ().trim ())){
                    binding.emailTextCreateProfilee.setEnabled (true);
                    binding.emailTextCreateProfilee.setError ("Please enter email id.");

                    break;
                }
                else if(!Validation.isValidEmail (binding.emailTextCreateProfilee.getText ().toString ().trim ())){
                    binding.emailTextCreateProfilee.setEnabled (true);
                    binding.emailTextCreateProfilee.setError ("Please enter valid email id.");

                    break;
                }
               /* else if(!Validation.isValidPassword (binding.mobileTextCreateProfilee.getText ().toString ().trim ())){
                    binding.mobileTextCreateProfilee.setEnabled (true);
                    binding.mobileTextCreateProfilee.setError ("Please enter mobile number.");

                    break;
                }*/

                else if(!Validation.isValidPassword (binding.intrestTextCreateProfilee.getText ().toString ().trim ())){
                    binding.intrestTextCreateProfilee.setEnabled (true);
                    binding.intrestTextCreateProfilee.setError ("Please enter your interest.");

                    break;
                }
                else{
                    startActivity (new Intent (this, ProfileActivity.class));
                    binding.fullNameTextCreateProfilee.setText ("");
                    binding.emailTextCreateProfilee.setText ("");
                    binding.mobileTextCreateProfilee.setText ("");
                    binding.intrestTextCreateProfilee.setText ("");
                    break;
                }

        }
    }

    static class IncludedLayout {
        @BindView( R.id.header_back ) ImageView backImage;
    }
}
