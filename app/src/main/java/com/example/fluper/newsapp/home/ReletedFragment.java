package com.example.fluper.newsapp.home;

import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.FragmentReletedBinding;
import com.example.fluper.newsapp.databinding.SaveArticleDiscriptionBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReletedFragment extends Fragment implements View.OnClickListener{

    private FragmentReletedBinding binding;
    private View view;
    private SaveArticleDiscription save;
    private ViewPagerAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach (context);
        save = (SaveArticleDiscription) context;
    }

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



   /* public void setViewPager(){
        List<Fragment> fragments = getFragments();
        adapter = new ViewPagerAdapter (getActivity ().getSupportFragmentManager(), fragments);
        binding.reletedSearchViewPager.setAdapter(adapter);
    }




    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment> ();
        fList.add (new ReletedFragment ());
        fList.add (new ReletedFragment ());
        fList.add (new ReletedFragment ());
        fList.add (new ReletedFragment ());
        fList.add (new ReletedFragment ());
        fList.add (new ReletedFragment ());
        return fList;
    }*/

    public void setViewPager() {
        binding.reletedSearchViewPager.setClipToPadding (false);
        binding.reletedSearchViewPager.setPadding (0, 0, 30, 0);
        binding.reletedSearchViewPager.setAdapter (new IntroAdapter (getActivity ().getSupportFragmentManager ()));

        // Set a PageTransformer
        binding.reletedSearchViewPager.setPageTransformer (false, new IntroPageTransfer ());
        binding.ivCancelReletedSerch.setOnClickListener (this);

        // circleIndicator.setViewPager( binding.reletedSearchViewPager);

     /*   android.support.v4.app.FragmentManager  fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.layout_container, new HomeFragmentOne());
        ft.commit();
*/

    }

    public void onClick(View view) {
        switch (view.getId ()) {
            case R.id.iv_cancel_releted_serch:
                save.removeFragment ();
                getContext ().startActivity (new Intent (getContext (), SaveArticleDiscription.class));
                getActivity ().finish ();
                break;
        }
    }
}

