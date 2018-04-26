package com.example.fluper.newsapp.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityBestSellerBinding;

public class BestSellerActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityBestSellerBinding binding;
    private BestSellerRectangleRecyclerAdapter rectangleAdapter;
    private BestSellerSqureRecyclerAdapter squreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_best_seller);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_best_seller);

        rectangleAdapter  =     new BestSellerRectangleRecyclerAdapter (this);
        squreAdapter      =     new BestSellerSqureRecyclerAdapter (this);

        binding.bestSellerSqureRecyclerView.setLayoutManager (new GridLayoutManager (this,
                2));
        binding.bestSellerRectangleRecyclerView.setLayoutManager (new LinearLayoutManager (this));

        binding.bestSellerRectangleRecyclerView.setAdapter (rectangleAdapter);
        binding.bestSellerSqureRecyclerView.setAdapter (squreAdapter);

        binding.includeToolBestSeller.headerBack.setOnClickListener (this);
        binding.includeToolBestSeller.headerToolText.setText ("Best Sellers");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()) {
            case R.id.header_back:
                onBackPressed ();
                break;
        }
    }
}
