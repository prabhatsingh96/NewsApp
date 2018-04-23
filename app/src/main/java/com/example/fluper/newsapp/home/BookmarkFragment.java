package com.example.fluper.newsapp.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.FragmentBookmarkBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookmarkFragment extends Fragment implements View.OnClickListener{

    private FragmentBookmarkBinding binding;
    private View view;
    private BookMarksAdapter adapter;

    public BookmarkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate (R.layout.fragment_bookmark, container, false);
        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_bookmark, container, false);
        view = binding.getRoot ();
        binding.bookmarksRecycleView.setLayoutManager (new LinearLayoutManager (getContext (),
                LinearLayoutManager.VERTICAL,true));
        adapter = new BookMarksAdapter (getContext ());
        binding.bookmarksRecycleView.setAdapter (adapter);
       // binding.includeBookmarksBottom.ivBookmark.setImageResource (R.drawable.bottom_bookmark_ac);

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId ()){

        }
    }
}
