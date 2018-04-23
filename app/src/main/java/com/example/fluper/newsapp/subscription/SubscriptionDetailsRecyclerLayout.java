package com.example.fluper.newsapp.subscription;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 23/4/18.
 */

public class SubscriptionDetailsRecyclerLayout extends RecyclerView.Adapter<SubscriptionDetailsRecyclerLayout.MyViewHolder>{

    private Context mContext;

    public SubscriptionDetailsRecyclerLayout(Context context) {
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.details_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super (itemView);
        }
    }
}
