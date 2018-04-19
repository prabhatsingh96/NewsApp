package com.example.fluper.newsapp.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivitySearchBinding binding;
    private SearchRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
       // setContentView (R.layout.activity_search);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_search);
        binding.includeSearchBottomLayout.ivSearch.setImageResource (R.drawable.bottom_search_ac);
        binding.includeSearchBottomLayout.savedText.setTextColor
                (getResources ().getColor (R.color.colorPurple));

        adapter = new SearchRecyclerAdapter (this);
        binding.searchRecyclerView.setLayoutManager (new LinearLayoutManager (this,
                LinearLayoutManager.HORIZONTAL, true));
        binding.searchRecyclerView.setAdapter (adapter);




    }

    @Override
    public void onClick(View view) {
        switch(view.getId ()){


        }
    }
}
