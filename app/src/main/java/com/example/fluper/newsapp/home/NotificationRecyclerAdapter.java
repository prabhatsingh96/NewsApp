package com.example.fluper.newsapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fluper.newsapp.R;

import org.w3c.dom.Text;

/**
 * Created by fluper on 23/4/18.
 */

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<NotificationRecyclerAdapter.MyViewHolder>{

    private Context context;

    public NotificationRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (parent.getContext ());
        View view = inflater.inflate (R.layout.notification_layout, parent, false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.headingText.setText ("Heading");
      holder.notificationText.setText ("Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet," +
              "Lorem ipsum dolor sit amet.");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView headingText;
        TextView notificationText;

        public MyViewHolder(View itemView) {
            super (itemView);
            headingText = itemView.findViewById (R.id.heading_text_notification);
            notificationText = itemView.findViewById (R.id.notification_text_notification);

        }
    }
}
