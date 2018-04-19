package com.example.fluper.newsapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 19/4/18.
 */

public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchRecyclerAdapter.MyViewHolder> {
    private Context mContext;
    public SearchRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rectangle_recycler_layout,parent,false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       holder.mImageView.setImageResource (R.drawable.details_img);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super (itemView);
            mImageView = itemView.findViewById (R.id.home_product_image_rectangle);
        }
    }
}
