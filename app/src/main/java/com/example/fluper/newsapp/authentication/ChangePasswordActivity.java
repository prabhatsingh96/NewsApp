package com.example.fluper.newsapp.authentication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.databinding.ActivityChangePasswordBinding;
import com.example.fluper.newsapp.databinding.ActivityResetPasswordBinding;
import com.example.fluper.newsapp.profile.EditProfileActivity;

import butterknife.BindView;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView( R.id.include_change_layout)
    View toolLayout;
    private ActivityChangePasswordBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        initControles ();
    }


    //all button action liostener
    public void initControles(){
        binding = DataBindingUtil.setContentView (this,R.layout.activity_change_password);
        binding.includeChangeLayout.headerBack.setOnClickListener (this);
        binding.submitPassword.setOnClickListener (this);
        binding.includeChangeLayout.headerToolText.setText ("Change Password");

    }

    // on click method
    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;
            case R.id.submit_password:
                if (!Validation.isValidPassword (binding.oldPasswordText.getText ().toString ())) {
                    binding.oldPasswordText.setEnabled (true);
                    binding.oldPasswordText.setError ("Please enter old password");
                    break;
                }
                else if(!Validation.isValidPassword (binding.newPasswordText.getText ().toString ())){
                    binding.newPasswordText.setEnabled (true);
                    binding.newPasswordText.setError ("please enter confirm password");
                    break;
                }
                else if(!Validation.isValidPassword (binding.confirmPasswordText.getText ().toString ())){
                    binding.confirmPasswordText.setEnabled (true);
                    binding.confirmPasswordText.setError ("please enter confirm password");
                    break;
                }
                else if(!(binding.confirmPasswordText.getText ().toString ().trim ().equals
                        (binding.newPasswordText.getText ().toString ().trim ()))) {
                    binding.confirmPasswordText.setEnabled (true);
                    binding.confirmPasswordText.setError (" Passwords are not matched");

                }
                else
                {
                    startActivity(new Intent (this, EditProfileActivity.class));
                    binding.oldPasswordText.setText ("");
                    binding.newPasswordText.setText ("");
                    binding.confirmPasswordText.setText ("");
                    break;
                }
        }
    }
}
