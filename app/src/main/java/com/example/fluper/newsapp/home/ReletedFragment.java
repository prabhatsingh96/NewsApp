package com.example.fluper.newsapp.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.FragmentReletedBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReletedFragment extends Fragment implements View.OnClickListener{

    private FragmentReletedBinding binding;
    private View view;

    public ReletedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate (R.layout.fragment_releted, container, false);
        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_releted, container, false);
        view = binding.getRoot ();
        // getActivity ().getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        setViewPager ();
        return view;
    }

    public void setViewPager() {
        binding.reletedSearchViewPager.setClipToPadding (false);
        binding.reletedSearchViewPager.setPadding (0, 0, 30, 0);
        binding.reletedSearchViewPager.setAdapter (new IntroAdapter (getActivity ().getSupportFragmentManager ()));

        // Set a PageTransformer
        binding.reletedSearchViewPager.setPageTransformer (false, new IntroPageTransfer ());
        binding.ivCancelReletedSerch.setOnClickListener (this);

        // circleIndicator.setViewPager( binding.reletedSearchViewPager);

      /*  android.support.v4.app.FragmentManager  fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.layout_container, new HomeFragmentOne());
        ft.commit();
*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.iv_cancel_releted_serch:
                startActivity (new Intent (getContext (), SaveArticleDiscription.class));
                break;
        }
    }
}
