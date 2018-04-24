package com.example.fluper.newsapp.payment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 24/4/18.
 */

public class PaymentInfoRecyclerAdapter extends RecyclerView.Adapter<PaymentInfoRecyclerAdapter.MyCustomViewHolder>{

    private Context mContext;
    private int lastPosition = -1;

    public PaymentInfoRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MyCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.payment_info_layout,parent,false);
        return new MyCustomViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyCustomViewHolder holder, int position) {
        holder.paymentMode.setText ("mPesa");
        holder.rdbtn.setChecked (position == lastPosition);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyCustomViewHolder extends RecyclerView.ViewHolder{
        RadioButton rdbtn;
        TextView paymentMode;

        public MyCustomViewHolder(View itemView) {
            super (itemView);
            paymentMode = itemView.findViewById (R.id.payment_mode);
            rdbtn = itemView.findViewById (R.id.radio_button_payment_mode);
            rdbtn.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    lastPosition = getAdapterPosition ();
                    notifyDataSetChanged ();
                }
            });
        }
    }
}
