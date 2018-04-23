package com.example.fluper.newsapp.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityNotificationBinding;

import butterknife.BindView;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView (R.id.include_notification_header) View tol;
    private ActivityNotificationBinding binding;
    private NotificationRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_notification);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_notification);
        adapter = new NotificationRecyclerAdapter (this);
        binding.notificationRecyclerView.setLayoutManager (new LinearLayoutManager (this));
        binding.notificationRecyclerView.setAdapter (adapter);
        binding.includeNotificationHeader.headerBack.setOnClickListener (this);
        binding.includeNotificationHeader.headerToolText.setText ("Notifications");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.header_back:
                super.onBackPressed ();
                break;
        }
    }
}
