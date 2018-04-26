package com.example.fluper.newsapp.home;

import android.content.ContentResolver;
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

public class BestSellerRectangleRecyclerAdapter extends RecyclerView.Adapter<BestSellerRectangleRecyclerAdapter.MyViewHolder>{

    private Context mContext;

    public BestSellerRectangleRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (parent.getContext ());
        View view = inflater.inflate (R.layout.best_seller_rectangle_layout, parent, false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
     holder.productImageView.setImageResource (R.drawable.product_img_two);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView productImageView;
        public MyViewHolder(View itemView) {
            super (itemView);
            productImageView = itemView.findViewById (R.id.best_seller_product_image_rectangle);
        }
    }
}
