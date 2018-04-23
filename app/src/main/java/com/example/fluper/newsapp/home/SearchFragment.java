package com.example.fluper.newsapp.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.FragmentSearchBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements View.OnClickListener{

    private FragmentSearchBinding binding;
    private SearchRecyclerAdapter adapter;
    private View view;
    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_search, container, false);
        view = binding.getRoot ();
        adapter = new SearchRecyclerAdapter (getContext ());
        binding.searchRecyclerView.setLayoutManager (new GridLayoutManager (getContext (),2));
        binding.searchRecyclerView.setAdapter (adapter);

        return view;

    }

    @Override
    public void onClick(View view) {

    }
}
