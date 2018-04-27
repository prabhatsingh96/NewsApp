package com.example.fluper.newsapp.profile;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityTermsAndConditionBinding;

import butterknife.BindView;

public class TermsAndConditionActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView (R.id.include_terms_and_condition_tool) View toolView;
    private ActivityTermsAndConditionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
       // setContentView (R.layout.activity_terms_and_condition);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_terms_and_condition);
        initControles ();
    }




    public void initControles(){
        binding.includeTermsAndConditionTool.headerToolText.setText ("Terms & Conditions");
        binding.includeTermsAndConditionTool.headerBack.setOnClickListener (this);
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
