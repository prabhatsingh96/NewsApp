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

import java.util.ArrayList;

/**
 * Created by fluper on 16/4/18.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> implements View.OnClickListener{



    private ArrayList<String> arrayList;
    private Context context;
    private ImageView iv;
    //private final View.OnClickListener mOnClickListener = new MyOnClickListener();

    public MyRecyclerAdapter(Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.home_recycler_view_layout,parent,false);
        iv = view.findViewById (R.id.home_product_image);
        iv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                context.startActivity (new Intent (context, ArticleDescriptionActivity.class));
            }
        });
       // view.setOnClickListener ((View.OnClickListener) context);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.homeProductImage.setImageResource(R.drawable.product_img);
        holder.homeProductImage.setImageResource(R.drawable.product_img);
        holder.homeProductImage.setImageResource(R.drawable.product_img);
        holder.homeProductImage.setImageResource(R.drawable.product_img);
        holder.homeProductImage.setImageResource(R.drawable.product_img);




        // ArrayList<Bitmap> bitmap=videoDetail.getThum().get(position);
        // holder.rv.setImageBitmap();

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onClick(View view) {

        context.startActivity (new Intent (context, ArticleDescriptionActivity.class));
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //  public ImageView rv;
        public ImageView homeProductImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            //  rv = itemView.findViewById(R.id.img_cicular_video_thumnail);
            homeProductImage = itemView.findViewById(R.id.home_product_image);
        }


    }
}
