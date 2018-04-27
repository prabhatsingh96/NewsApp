package com.example.fluper.newsapp.subscription;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityArticleNameReadMoreBinding;

public class ArticleNameReadMoreActivity extends AppCompatActivity implements View.OnClickListener{


    private ActivityArticleNameReadMoreBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_article_name_read_more);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_article_name_read_more);
        initControles ();
    }



    public void initControles(){
        binding.includeArticleNameTool.headerBack.setOnClickListener (this);
        binding.includeArticleNameTool.headerToolText.setText ("Article Name");
        binding.includeArticleNameTool.headerBack.setImageResource (R.drawable.cancel);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.header_back:
                onBackPressed ();
                break;
        }
    }
}
