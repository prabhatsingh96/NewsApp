package com.example.fluper.newsapp.home;

import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityTryForFreeBinding;
import com.example.fluper.newsapp.subscription.SubscriptionDetailsRecyclerLayout;

public class SaveArticleDiscription extends AppCompatActivity implements View.OnClickListener {

    private ActivityTryForFreeBinding binding;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_try_for_free);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_try_for_free);
        binding.bottonArticleLayout.setOnClickListener (this);
        binding.backBtnDescription.setOnClickListener (this);
        binding.tryForText.setOnClickListener (this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()) {
            case R.id.botton_article_layout:
                //binding.rootLayout.setBackgroundColor (getResources ().getColor (R.color.colorPrimary));
                binding.rootLayout.setAlpha (0.9f);
                addFirstFragment ();
                break;

            case R.id.back_btn_description:
                super.onBackPressed ();
                break;
            case R.id.try_for_text:
                showTryForFreeDialog();
                break;

        }
    }

    public void replaceFragment(int fragmentId, Fragment fragment) {
        android.support.v4.app.FragmentManager frg = getSupportFragmentManager ();
        FragmentTransaction ft = frg.beginTransaction ();
        ft.replace (fragmentId, fragment);
        ft.commit ();
    }

    public void addFirstFragment() {

        android.support.v4.app.FragmentManager frg = getSupportFragmentManager ();
        FragmentTransaction ft = frg.beginTransaction ();
        ft.add (R.id.tryfree_fragment_container, new ReletedFragment ());
        ft.commit ();
    }


    public void showTryForFreeDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

            LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view1 = inflater.inflate(R.layout.try_for_free_dialog_layout, null);
          /*  RecyclerView rv = view1.findViewById (R.id.list_details);
            rv.setLayoutManager (new LinearLayoutManager (this));
            SubscriptionDetailsRecyclerLayout sra = new SubscriptionDetailsRecyclerLayout (this);
            rv.setAdapter (sra);*/


           /* BottomSheetDialog dialog = new BottomSheetDialog(this); dialog.setContentView(view1);

            dialog.show();*/

        builder.setView(view1);
        alertDialog = builder.create();
        //alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        }


}
