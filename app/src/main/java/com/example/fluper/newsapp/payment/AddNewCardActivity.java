package com.example.fluper.newsapp.payment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;

import android.databinding.DataBindingUtil;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.Validation;
import com.example.fluper.newsapp.databinding.ActivityAddNewCardBinding;

import java.sql.Date;
import java.util.Calendar;

public class AddNewCardActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityAddNewCardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_add_new_card);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_add_new_card);
        initControles ();
        //binding.expireDateText.setOnClickListener (this);

    }


    public void initControles(){
        binding.includeToolAddNewCard.headerBack.setOnClickListener (this);
        binding.includeToolAddNewCard.headerToolText.setText ("Add New Card");
        binding.saveBtnAddNewCard.setOnClickListener (this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;
            case R.id.saveBtnAddNewCard:

                if(!Validation.isValidPassword (binding.cardNumberText.getText ().toString ().trim ())){
                    binding.cardNumberText.setEnabled (true);
                    binding.cardNumberText.setError ("Please enter card number");}
                else if(!Validation.isValidPassword (binding.cvvText.getText ().toString ().trim ())) {
                    binding.cvvText.setEnabled (true);
                    binding.cvvText.setError ("Please enter CVV");
                }
                else if(!Validation.isValidPassword (binding.expireDateText.getText ().toString ().trim ())) {
                    binding.expireDateText.setEnabled (true);
                    binding.expireDateText.setError ("Please enter expire date");
                }
                else {
                    startActivity (new Intent (this, PaymentActivity.class));
                    binding.expireDateText.setText ("");
                    binding.cvvText.setText ("");
                    binding.cardNumberText.setText ("");
                    break;
                }
            /*case R.id.expire_date_text:
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
                break;*/
        }
    }




    /*//Date Picker Dialog
    @SuppressLint("ValidFragment")
    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            String date = day+"/"+month+"/"+year;
            binding.expireDateText.setText (date);

        }
    }
*/

}
