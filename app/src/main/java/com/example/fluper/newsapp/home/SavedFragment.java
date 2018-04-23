package com.example.fluper.newsapp.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.FragmentSavedBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedFragment extends Fragment {

    private FragmentSavedBinding binding;
    private View view;
    private SavedRecyclerAdapter adapter;

    public SavedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate (R.layout.fragment_saved, container, false);
        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_saved, container, false);
        view = binding.getRoot ();

        binding.savedRecycleView.setLayoutManager (new LinearLayoutManager (getContext (),
                LinearLayoutManager.VERTICAL,true));
        adapter = new SavedRecyclerAdapter (getContext ());
        binding.savedRecycleView.setAdapter (adapter);

        return view;
    }

}
