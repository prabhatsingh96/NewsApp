package com.example.fluper.newsapp.authentication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.databinding.FragmentSignUpBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener{

    private View view;
    private FragmentSignUpBinding binding;


    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_sign_up, container, false);
        view = binding.getRoot ();
        binding.signupBtn.setOnClickListener (this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.signup_btn:

                if(!Validation.isValidPassword (binding.emailSignup.getText ().toString ().trim ())){
                    binding.emailSignup.setEnabled (true);
                    binding.emailSignup.setError ("Please enter email id");
                    break;
                }
                else if(!Validation.isValidEmail (binding.emailSignup.getText ().toString ().trim ())){
                    binding.emailSignup.setEnabled (true);
                    binding.emailSignup.setError ("Please enter valid email id");
                    break;
                }
                else if(!Validation.isValidPassword (binding.passwordSignup.getText ().toString ())) {
                    binding.passwordSignup.setEnabled (true);
                    binding.passwordSignup.setError ("Please enter password");
                    break;
                }
                else if(!Validation.isValidPassword (binding.cPasswordSignup.getText ().toString ())) {
                    binding.cPasswordSignup.setEnabled (true);
                    binding.cPasswordSignup.setError ("Please enter confirm password");
                    break;
                } else if(!(binding.passwordSignup.getText ().toString ().trim ().equals
                        (binding.cPasswordSignup.getText ().toString ().trim ()))) {
                    binding.cPasswordSignup.setEnabled (true);
                    binding.cPasswordSignup.setError (" Password are not matched");

                }

                else {

                    startActivity (new Intent (getContext (), OtpActivity.class).putExtra
                            ("key", "o"));
                    binding.emailSignup.setText ("");
                    binding.passwordSignup.setText ("");
                    binding.cPasswordSignup.setText ("");
                    break;
                }
        }
    }
}