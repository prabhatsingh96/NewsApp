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
import com.example.fluper.newsapp.databinding.FragmentHomePageBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    private FragmentHomePageBinding binding;
    private View view;
    MyRecyclerAdapter mMyRecyclerAdapter;
    private MyHomeRecyclerAdapter adapterRectangle;

    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_home_page, container, false);
        view = binding.getRoot ();
        mMyRecyclerAdapter = new MyRecyclerAdapter (getContext ());
        binding.homeRecyclerView.setLayoutManager (new LinearLayoutManager
                (getContext (), LinearLayoutManager.HORIZONTAL, true));
        binding.homeRecyclerView.setAdapter (mMyRecyclerAdapter);
        binding.homeRecyclerVieww.setLayoutManager (new GridLayoutManager (getContext (), 2));
        adapterRectangle = new MyHomeRecyclerAdapter (getContext ());
        binding.homeRecyclerVieww.setAdapter (adapterRectangle);
        return view;
    }

}
