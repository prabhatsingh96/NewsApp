package com.example.fluper.newsapp.subscription;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fluper.newsapp.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by fluper on 23/4/18.
 */

public class SubscriptionRecyclerAdapter extends RecyclerView.Adapter<SubscriptionRecyclerAdapter.MyViewHolder> implements View.OnClickListener{

    SubscriptionActivity context;
    private AlertDialog alertDialog;

    public SubscriptionRecyclerAdapter(SubscriptionActivity context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.subscription_layout_list,parent,false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.viewDetail.setOnClickListener (this);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.view_detail_subscription:
                context.dialogOpen ();
               // showShareOppDialog ();

                break;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView viewDetail;
        public MyViewHolder(View itemView) {
            super (itemView);
            viewDetail =itemView.findViewById (R.id.view_detail_subscription);


        }
    }


  /*  public void showShareOppDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.subscription_detail_layout, null);




        RecyclerView rv = view1.findViewById (R.id.list_details);
        rv.setLayoutManager (new LinearLayoutManager (context));
        SubscriptionRecyclerAdapter sra = new SubscriptionRecyclerAdapter (context);
        rv.setAdapter (sra);



        builder.setView(view1);
        alertDialog = builder.create();
        //alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();


    }*/
}
