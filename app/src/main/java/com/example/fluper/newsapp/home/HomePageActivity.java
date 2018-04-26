package com.example.fluper.newsapp.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.appUtils.BottomNavigationViewHelper;
import com.example.fluper.newsapp.authentication.TabAdapter;
import com.example.fluper.newsapp.databinding.ActivityHomePageBinding;
import com.example.fluper.newsapp.subscription.SubscriptionDetailsRecyclerLayout;

import butterknife.BindView;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityHomePageBinding binding;
    private BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        binding = DataBindingUtil.setContentView (this, R.layout.activity_home_page);
        addFirstFragment ();

        /*binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(binding.navigation);*/


        binding.includeBottomLayout.relProfile.setOnClickListener (this);
        binding.includeBottomLayout.relHome.setOnClickListener (this);
        binding.includeBottomLayout.relSaved.setOnClickListener (this);
        binding.includeBottomLayout.relSearch.setOnClickListener (this);
        binding.includeBottomLayout.relBookmark.setOnClickListener (this);
        binding.includeToolHome.notificationIcon.setOnClickListener (this);
        binding.includeToolHome.sortIcon.setOnClickListener (this);
        binding.includeToolHome.filterIcon.setOnClickListener (this);

        binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_ac);
        binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor
                (R.color.colorbutton));

    }




/*
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment (R.id.home_fragment_container, new HomePageFragment ());
                    return true;
                case R.id.navigation_search:
                    replaceFragment (R.id.home_fragment_container, new SearchFragment ());
                    return true;
                case R.id.navigation_saved:
                    replaceFragment (R.id.home_fragment_container, new SavedFragment ());
                    return true;
                case R.id.navigation_profile:
                    replaceFragment (R.id.home_fragment_container, new ProfileFragment ());
                    return true;
                case R.id.bookmarkk:
                    replaceFragment (R.id.home_fragment_container, new BookmarkFragment ());
                    return true;
            }
            return false;
        }
    };*/











    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.rel_profile:
                binding.includeToolHome.sortIcon.setVisibility (View.GONE);
                binding.includeToolHome.filterIcon.setVisibility (View.GONE);
                binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_ac);
                binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorPurple));
                binding.includeBottomLayout.homeViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.profileViewLine.setVisibility (View.VISIBLE);
                binding.includeBottomLayout.searchViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.savedViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.bookmarkViewLine.setVisibility (View.GONE);
                replaceFragment (R.id.home_fragment_container, new ProfileFragment ());

                binding.includeBottomLayout.ivSearch.setColorFilter (this.getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.searchText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.ivBookmark.setImageResource (R.drawable.bottom_bookmark_de);
                binding.includeBottomLayout.bookmarkText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_de);
                binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                binding.includeBottomLayout.ivSaved.setImageResource (R.drawable.bottom_download_de);
                binding.includeBottomLayout.savedText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                break;
            case R.id.rel_home:
                binding.includeToolHome.filterIcon.setVisibility (View.GONE);
                binding.includeToolHome.sortIcon.setVisibility (View.GONE);
                binding.includeBottomLayout.homeViewLine.setVisibility (View.VISIBLE);
                binding.includeBottomLayout.profileViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.searchViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.savedViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.bookmarkViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_ac);
                binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorPurple));

                replaceFragment (R.id.home_fragment_container, new HomePageFragment ());
                binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_de);
                binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.ivBookmark.setImageResource (R.drawable.bottom_bookmark_de);
                binding.includeBottomLayout.bookmarkText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.ivSearch.setColorFilter (this.getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.searchText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                binding.includeBottomLayout.ivSaved.setImageResource (R.drawable.bottom_download_de);
                binding.includeBottomLayout.savedText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                break;
            case R.id.rel_bookmark:
                binding.includeToolHome.sortIcon.setVisibility (View.GONE);
                binding.includeToolHome.filterIcon.setVisibility (View.GONE);
                binding.includeBottomLayout.ivBookmark.setImageResource (R.drawable.bottom_bookmark_ac);
                binding.includeBottomLayout.bookmarkText.setTextColor (getResources ().getColor (R.color.colorPurple));
                binding.includeBottomLayout.homeViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.profileViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.searchViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.savedViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.bookmarkViewLine.setVisibility (View.VISIBLE);

                replaceFragment (R.id.home_fragment_container, new BookmarkFragment ());
                binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_de);
                binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                binding.includeBottomLayout.ivSearch.setColorFilter (this.getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.searchText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_de);
                binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.ivSaved.setImageResource (R.drawable.bottom_download_de);
                binding.includeBottomLayout.savedText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                break;
            case R.id.rel_search:
                binding.includeToolHome.filterIcon.setVisibility (View.VISIBLE);
                binding.includeToolHome.sortIcon.setVisibility (View.GONE);
                binding.includeBottomLayout.homeViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.profileViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.searchViewLine.setVisibility (View.VISIBLE);
                binding.includeBottomLayout.savedViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.bookmarkViewLine.setVisibility (View.GONE);

                replaceFragment (R.id.home_fragment_container, new SearchFragment ());
                binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_de);
                binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.ivBookmark.setImageResource (R.drawable.bottom_bookmark_de);
                binding.includeBottomLayout.bookmarkText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                binding.includeBottomLayout.ivSearch.setColorFilter (this.getResources ().getColor (R.color.colorPurple));
                binding.includeBottomLayout.searchText.setTextColor (getResources ().getColor (R.color.colorPurple));

                binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_de);
                binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.ivSaved.setImageResource (R.drawable.bottom_download_de);
                binding.includeBottomLayout.savedText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                break;
            case R.id.rel_saved:
                binding.includeToolHome.filterIcon.setVisibility (View.GONE);
                binding.includeToolHome.sortIcon.setVisibility (View.VISIBLE);
                binding.includeBottomLayout.ivSaved.setImageResource (R.drawable.bottom_download_ac);
                binding.includeBottomLayout.savedText.setTextColor (getResources ().getColor (R.color.colorPurple));
                binding.includeBottomLayout.homeViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.profileViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.searchViewLine.setVisibility (View.GONE);
                binding.includeBottomLayout.savedViewLine.setVisibility (View.VISIBLE);
                binding.includeBottomLayout.bookmarkViewLine.setVisibility (View.GONE);

                replaceFragment (R.id.home_fragment_container, new SavedFragment ());
                binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_de);
                binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.ivBookmark.setImageResource (R.drawable.bottom_bookmark_de);
                binding.includeBottomLayout.bookmarkText.setTextColor (getResources ().getColor (R.color.colorPrimary));


                binding.includeBottomLayout.ivSearch.setColorFilter (this.getResources ().getColor (R.color.colorPrimary));
                binding.includeBottomLayout.searchText.setTextColor (getResources ().getColor (R.color.colorPrimary));

                binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_de);
                binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorPrimary));
                break;

            case R.id.notification_icon:
                startActivity (new Intent (this, NotificationActivity.class));
                break;

            case R.id.filter_icon:
                 openFilterDialog();
                 break;
            case R.id.sort_icon:
                 openSortDialog();
                 break;
        }
    }


    private void openSortDialog() {
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.sort_layout, null);
        dialog = new BottomSheetDialog(this); dialog.setContentView(view1);
        dialog.show();

    }



    private void openFilterDialog() {
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.filter_layout, null);
        TextView applyText = view1.findViewById (R.id.apply_text);
        final BottomSheetDialog dialog = new BottomSheetDialog(this); dialog.setContentView(view1);
        applyText.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                dialog.dismiss ();
            }
        });
        dialog.show();
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
        ft.add (R.id.home_fragment_container, new HomePageFragment ());
        ft.commit ();
    }

}
