package com.example.fluper.newsapp.payment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 23/4/18.
 */

public class PaymentRecyclerAdapter extends RecyclerView.Adapter<PaymentRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private int lastPosition = -1;
    public PaymentRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.payment_layout,parent,false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
           holder.rdbtn.setChecked (position == lastPosition);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RadioButton rdbtn;
        public MyViewHolder(View itemView) {
            super (itemView);
            rdbtn = itemView.findViewById (R.id.radio_button_payment);
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
