package com.example.fluper.newsapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 27/4/18.
 */

public class DeleteRecyclerAdapter extends RecyclerView.Adapter<DeleteRecyclerAdapter.MyViewHolder>{

    private Context mContext;

    public DeleteRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (parent.getContext ());
        View view = inflater.inflate (R.layout.delete_article_layout, parent, false);
        return  new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.deleteProductImage.setImageResource (R.drawable.details_img);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView  deleteProductImage;

        public MyViewHolder(View itemView) {
            super (itemView);
            deleteProductImage = itemView.findViewById (R.id.delete_product_image);
        }
    }
}
