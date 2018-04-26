package com.example.fluper.newsapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 26/4/18.
 */

public class BestSellerSqureRecyclerAdapter extends RecyclerView.Adapter<BestSellerSqureRecyclerAdapter.MyViewHolder>{

    private Context context;

    public BestSellerSqureRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (parent.getContext ());
        View view = inflater.inflate (R.layout.rectangle_recycler_layout, parent, false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
     holder.productImageView.setImageResource (R.drawable.details_img);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         ImageView productImageView;
        public MyViewHolder(View itemView) {
            super (itemView);
            productImageView = itemView.findViewById (R.id.home_product_image_rectangle);
        }
    }
}
