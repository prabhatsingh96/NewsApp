package com.example.fluper.newsapp.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.FragmentProfileBinding;
import com.example.fluper.newsapp.payment.PaymentActivity;
import com.example.fluper.newsapp.profile.EditProfileActivity;
import com.example.fluper.newsapp.profile.SettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener{

    private FragmentProfileBinding binding;
    private View view;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate (R.layout.fragment_profile, container, false);
        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_profile, container, false);
        view = binding.getRoot ();
        binding.editProfile.setOnClickListener (this);
        binding.settig.setOnClickListener (this);
        binding.payments.setOnClickListener (this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()) {
            case R.id.edit_profile:
                startActivity (new Intent (getContext (), EditProfileActivity.class));
                break;
            case R.id.settig:
                startActivity (new Intent (getContext (), SettingActivity.class));
                break;

            case R.id.payments:
                startActivity (new Intent (getContext (), PaymentActivity.class));
                break;
        }
    }
}
