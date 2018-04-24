package com.example.fluper.newsapp.payment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityPaymentBinding binding;
    private PaymentRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_payment);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_payment);
        adapter = new PaymentRecyclerAdapter (this);
        binding.paymentRecyclerList.setLayoutManager (new LinearLayoutManager (this));
        binding.paymentRecyclerList.setAdapter (adapter);
        binding.includeHeaderToolPayments.headerToolText.setText ("Payments");
        binding.includeHeaderToolPayments.headerBack.setOnClickListener (this);
        binding.floatAddBtn.setOnClickListener (this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;
            case R.id.float_add_btn:
                startActivity (new Intent (this, AddNewCardActivity.class));
                break;
        }
    }
}
