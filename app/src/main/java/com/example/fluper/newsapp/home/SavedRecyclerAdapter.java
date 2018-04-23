package com.example.fluper.newsapp.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 20/4/18.
 */

public class SavedRecyclerAdapter extends RecyclerView.Adapter<SavedRecyclerAdapter.MyViewHolder> implements View.OnClickListener{

    Context context;

    public SavedRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SavedRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (parent.getContext ());
        View view = inflater.inflate (R.layout.bookmarks_layout, parent, false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(SavedRecyclerAdapter.MyViewHolder holder, int position) {
      holder.homeProductImage.setImageResource (R.drawable.related_img);
      holder.count.setVisibility (View.GONE);
      holder.homeProductImage.setOnClickListener (this);

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId ()){

            case R.id.home_product_image_bookmark:
                context.startActivity (new Intent (context, SaveArticleDiscription.class));
                break;

        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView homeProductImage;
        TextView count;
        public MyViewHolder(View itemView) {
            super (itemView);
            homeProductImage = itemView.findViewById (R.id.home_product_image_bookmark);
            count = itemView.findViewById (R.id.count);


        }
    }
}
