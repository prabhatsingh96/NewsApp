package com.example.fluper.newsapp.subscription;

import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivitySubscriptionBinding;

public class SubscriptionActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivitySubscriptionBinding binding;
    private SubscriptionRecyclerAdapter adapter;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_subscription);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_subscription);
        adapter = new SubscriptionRecyclerAdapter (SubscriptionActivity.this);
        binding.subscriptionRecyclerList.setLayoutManager (new LinearLayoutManager (this));
        binding.subscriptionRecyclerList.setAdapter (adapter);
        binding.includeToolSubscription.headerBack.setOnClickListener (this);
        binding.includeToolSubscription.headerToolText.setText ("Subscription");

    }

    public void dialogOpen()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.subscription_detail_layout, null);
        RecyclerView rv = view1.findViewById (R.id.list_details);
        rv.setLayoutManager (new LinearLayoutManager (this));
        SubscriptionDetailsRecyclerLayout sra = new SubscriptionDetailsRecyclerLayout (this);
        rv.setAdapter (sra);


        BottomSheetDialog dialog = new BottomSheetDialog(this); dialog.setContentView(view1);

        dialog.show();


       /* builder.setView(view1);
        alertDialog = builder.create();
        //alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;
        }
    }
}
