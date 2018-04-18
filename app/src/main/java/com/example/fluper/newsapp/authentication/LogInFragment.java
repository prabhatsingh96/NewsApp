package com.example.fluper.newsapp.authentication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.databinding.FragmentLogInBinding;
import com.example.fluper.newsapp.home.HomePageActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInFragment extends Fragment implements View.OnClickListener{

    private View view;
    private FragmentLogInBinding binding;
    public LogInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_log_in, container, false);
       view = binding.getRoot ();
       allBtnClicksListener ();


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.loginBtn:

                if(!Validation.isValidPassword (binding.loginEmaill.getText ().toString ().trim ())){
                    binding.loginEmaill.setEnabled (true);
                    binding.loginEmaill.setError ("Please enter email id.");

                    break;
                }

                else if(!Validation.isValidEmail (binding.loginEmaill.getText ().toString ().trim ())){
                         binding.loginEmaill.setEnabled (true);
                         binding.loginEmaill.setError ("Please enter valid email id.");

                         break;
                }
                else if(!Validation.isValidPassword (binding.loginPasswordd.getText ().toString ())) {
                         binding.loginPassword.setEnabled (true);
                         binding.loginPassword.setError ("Please enter password.");

                         break;
                }
                else {/*
                    binding.loginEmaill.setError (null);
                    binding.loginEmaill.setEnabled (false);
                    binding.loginPasswordd.setError (null);
                    binding.loginPasswordd.setEnabled (false);*/
                    startActivity (new Intent (getContext (), HomePageActivity.class));
                    binding.loginPasswordd.setText ("");
                    binding.loginEmaill.setText ("");
                    //Toast.makeText (getContext (), "login", Toast.LENGTH_SHORT).show ();
                         break;
                     }
            case R.id.forgot_btn:
                startActivity (new Intent (getContext (), ForgotActivity.class));
                binding.loginEmaill.setText ("");
                binding.loginPasswordd.setText ("");
                break;

        }
    }

    public void allBtnClicksListener(){
        binding.forgotBtn.setOnClickListener (this);
        binding.loginBtn.setOnClickListener (this);
    }
}
