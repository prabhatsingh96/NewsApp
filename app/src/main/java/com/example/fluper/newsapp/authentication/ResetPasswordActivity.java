package com.example.fluper.newsapp.authentication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.databinding.ActivityResetPasswordBinding;

import butterknife.BindView;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityResetPasswordBinding binding;
    @BindView( R.id.include_otp_layout)
    View toolLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
       //setContentView (R.layout.activity_reset_password);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_reset_password);
        binding.includeOtpLayout.headerBack.setOnClickListener (this);
        binding.submitPassword.setOnClickListener (this);
        binding.includeOtpLayout.headerBack.setImageResource (R.drawable.cancel);
        binding.includeOtpLayout.headerToolText.setText ("Reset Password");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;
            case R.id.submit_password:
                if (!Validation.isValidPassword (binding.newPassword.getText ().toString ())) {
                    binding.newPassword.setEnabled (true);
                    binding.newPassword.setError ("Please enter new password");
                    break;
                }
                else if(!Validation.isValidPassword (binding.confirmPassword.getText ().toString ())){
                    binding.confirmPassword.setEnabled (true);
                    binding.confirmPassword.setError ("please enter confirm password");
                    break;
                }
                else if(!(binding.newPassword.getText ().toString ().trim ().equals
                        (binding.confirmPassword.getText ().toString ().trim ()))) {
                         binding.confirmPassword.setEnabled (true);
                         binding.confirmPassword.setError (" Password are not matched");

                }
                else
                {
                    startActivity(new Intent (this, HomeActivity.class));
                    binding.newPassword.setText ("");
                    binding.confirmPassword.setText ("");
                    break;
                }

        }
    }
}
