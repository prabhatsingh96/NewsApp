package com.example.fluper.newsapp.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fluper.newsapp.R;

/**
 * Created by fluper on 20/4/18.
 */

public class SavedRecyclerAdapter extends RecyclerView.Adapter<SavedRecyclerAdapter.MyViewHolder> implements View.OnClickListener{

    private Context context;
    private HomePageActivity home;
    public SavedRecyclerAdapter(Context context, HomePageActivity home) {
        this.context = context;
        this.home = home;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView (recyclerView);
        home = (HomePageActivity) context;
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
      holder.savedRelativeLayout.setOnClickListener (this);

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
            case R.id.saved_relative_layout:
                addDeleteFragment();
                break;

        }
    }

    private void addDeleteFragment() {
        home.replaceFragment (R.id.home_fragment_container,  new DeleteArticleFragment ());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView homeProductImage;
        TextView count;
        RelativeLayout savedRelativeLayout;
        public MyViewHolder(View itemView) {
            super (itemView);
            homeProductImage = itemView.findViewById (R.id.home_product_image_bookmark);
            count = itemView.findViewById (R.id.count);
            savedRelativeLayout = itemView.findViewById (R.id.saved_relative_layout);

        }
    }
}
