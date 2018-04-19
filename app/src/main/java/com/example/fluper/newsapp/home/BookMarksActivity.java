package com.example.fluper.newsapp.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityBookMarksBinding;

public class BookMarksActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityBookMarksBinding binding;
    private BookMarksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_book_marks);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_book_marks);
        binding.bookmarksRecycleView.setLayoutManager (new LinearLayoutManager (this,
                LinearLayoutManager.VERTICAL,true));
        adapter = new BookMarksAdapter (this);
        binding.bookmarksRecycleView.setAdapter (adapter);
        binding.includeBookmarksBottom.ivBookmark.setImageResource (R.drawable.bottom_bookmark_ac);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){

        }
    }
}
