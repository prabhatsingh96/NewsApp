package com.example.fluper.newsapp.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.FragmentDeleteArticleBinding;
import com.example.fluper.newsapp.subscription.SubscriptionDetailsRecyclerLayout;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteArticleFragment extends Fragment implements View.OnClickListener{

    private FragmentDeleteArticleBinding binding;
    private View view;
    private DeleteRecyclerAdapter deleteAdapter;
    private HomePageActivity home;
    private AlertDialog alertDialog;

    public DeleteArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach (context);
        home = (HomePageActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       //return inflater.inflate (R.layout.fragment_delete_article, container, false);

        binding = DataBindingUtil.inflate (
                inflater, R.layout.fragment_delete_article, container, false);
        view = binding.getRoot ();
       initControles ();
        return view;

    }


    public void initControles(){
        deleteAdapter = new DeleteRecyclerAdapter (getContext ());
        binding.deleteRecycleView.setLayoutManager (new LinearLayoutManager (getContext ()));
        binding.deleteRecycleView.setAdapter (deleteAdapter);
        home.hideToolLayout ();
        binding.includeHeaderToolLayout.delete.setOnClickListener (this);
        binding.includeHeaderToolLayout.deleteCancelBtn.setOnClickListener (this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.delete_cancel_btn:
                getActivity ().onBackPressed ();
                break;
            case R.id.delete:
                openDeleteAlertDialog();
             break;
            case R.id.okay_delete_alert:
                alertDialog.dismiss ();
                break;
            case R.id.cancel_delete_alert:
                alertDialog.dismiss ();
                break;
        }
    }


    public void openDeleteAlertDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext ());

        LayoutInflater inflater = (LayoutInflater)getContext ().getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.delete_alert_dialog_layout, null);
        TextView okay = view1.findViewById (R.id.okay_delete_alert);
        TextView cancel = view1.findViewById (R.id.cancel_delete_alert);
        okay.setOnClickListener (this);
        cancel.setOnClickListener (this);
        builder.setView(view1);
        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable (Color.TRANSPARENT));
        alertDialog.show();

    }
}
