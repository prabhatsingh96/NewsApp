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
        initControles ();

        return view;
    }



    public void initControles(){
        binding.signupBtn.setOnClickListener (this);
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
                    //binding.cPasswordSignup.setError ("Please enter confirm password");
                    Toast.makeText (getContext (), "Please enter confirm password", Toast.LENGTH_SHORT).show ();
                    break;
                } else if(!(binding.passwordSignup.getText ().toString ().trim ().equals
                        (binding.cPasswordSignup.getText ().toString ().trim ()))) {
                    binding.cPasswordSignup.setEnabled (true);
                    Toast.makeText (getContext (), "Password do not matched.", Toast.LENGTH_SHORT).show ();
                   /* binding.cPasswordSignup.setError (" Password are not matched");
                    binding.cPasswordSignup.requestFocus(binding.cPasswordSignup.length());
*/
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
