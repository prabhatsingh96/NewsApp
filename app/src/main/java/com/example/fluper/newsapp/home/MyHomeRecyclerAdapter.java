package com.example.fluper.newsapp.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 18/4/18.
 */

public class MyHomeRecyclerAdapter extends RecyclerView.Adapter<MyHomeRecyclerAdapter.MyViewHolder>
        implements View.OnClickListener {
    private Context context;
    private ImageView iv;

    public MyHomeRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (parent.getContext ());
        View view = inflater.inflate (R.layout.rectangle_recycler_layout, parent, false);
        iv = view.findViewById (R.id.home_product_image_rectangle);
        iv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                context.startActivity (new Intent (context, ArticleDescriptionActivity.class));
            }
        });
        // view.setOnClickListener ((View.OnClickListener) context);

        return new MyViewHolder (view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.homeProductImage.setImageResource (R.drawable.related_img);
        /*holder.homeProductImage.setImageResource (R.drawable.related_img);
        holder.homeProductImage.setImageResource (R.drawable.related_img);
        holder.homeProductImage.setImageResource (R.drawable.details_img);
        holder.homeProductImage.setImageResource (R.drawable.details_img);*/

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void onClick(View view) {

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView homeProductImage;

        public MyViewHolder(View itemView) {
            super (itemView);
            homeProductImage = itemView.findViewById (R.id.home_product_image_rectangle);
        }
    }
}
