package com.example.fluper.newsapp.profile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fluper.newsapp.R;


/**
 * Created by fluper on 17/4/18.
 */

public class MyFlowRecyclerAdapter extends RecyclerView.Adapter<MyFlowRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private String array[];

    public MyFlowRecyclerAdapter(Context context, String array[]) {
        this.mContext = context;
        this.array = array;
    }

    @Override
    public MyFlowRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.flow_catrgory_layout,parent,false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyFlowRecyclerAdapter.MyViewHolder holder, int position) {
     holder.mTextView.setText (array[position]);

    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //  public ImageView rv;
        private TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);

            //  rv = itemView.findViewById(R.id.img_cicular_video_thumnail);
            mTextView = itemView.findViewById(R.id.entertainment);
        }


    }

}
