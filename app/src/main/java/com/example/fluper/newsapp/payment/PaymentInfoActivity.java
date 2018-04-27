package com.example.fluper.newsapp.payment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityPaymentBinding;
import com.example.fluper.newsapp.databinding.ActivityPaymentInfoBinding;
import com.example.fluper.newsapp.home.HomePageActivity;
import com.example.fluper.newsapp.subscription.SubscriptionDetailsRecyclerLayout;

public class PaymentInfoActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityPaymentInfoBinding binding;
    private PaymentInfoRecyclerAdapter adapter;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_payment_info);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_payment_info);
        initControles ();

    }


    public void initControles(){
        adapter = new PaymentInfoRecyclerAdapter (this);
        binding.recyclerListPaymentMode.setLayoutManager (new LinearLayoutManager (this));
        binding.recyclerListPaymentMode.setAdapter (adapter);
        binding.includeHeaderToolPaymentInfo.headerToolText.setText ("Payment Info");
        binding.includeHeaderToolPaymentInfo.headerBack.setOnClickListener (this);
        binding.proceedBtnPaymentInfo.setOnClickListener (this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;

            case R.id.proceed_btn_payment_info:
                openSuccessDialog();
                break;

        }
    }

    private void openSuccessDialog() {
        final Intent intent = new Intent (this, HomePageActivity.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.payment_successful_dialog_layout, null);

        TextView okay = view1.findViewById (R.id.tv_okay);
        okay.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (intent);
            }
        });

        builder.setView(view1);
        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable (Color.TRANSPARENT));
        alertDialog.show();
    }
}
