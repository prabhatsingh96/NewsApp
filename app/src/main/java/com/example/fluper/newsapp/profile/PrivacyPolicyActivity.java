package com.example.fluper.newsapp.profile;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityPrivacyPolicyBinding;

import butterknife.BindView;

public class PrivacyPolicyActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView (R.id.include_privacy_policy_layout) View toolView;
    private ActivityPrivacyPolicyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_privacy_policy);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_privacy_policy);
        binding.includePrivacyPolicyLayout.headerToolText.setText ("Privacy Policy");
        binding.includePrivacyPolicyLayout.headerBack.setOnClickListener (this);
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
