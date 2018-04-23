package com.example.fluper.newsapp.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.authentication.TabAdapter;
import com.example.fluper.newsapp.databinding.ActivityHomePageBinding;

import butterknife.BindView;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityHomePageBinding binding;
    @BindView(R.id.include_forgot_layout)
    View toolLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        binding = DataBindingUtil.setContentView (this, R.layout.activity_home_page);
        addFirstFragment ();

        binding.includeBottomLayout.relProfile.setOnClickListener (this);
        binding.includeBottomLayout.relHome.setOnClickListener (this);
        binding.includeBottomLayout.relSaved.setOnClickListener (this);
        binding.includeBottomLayout.relSearch.setOnClickListener (this);
        binding.includeBottomLayout.relBookmark.setOnClickListener (this);
        binding.includeToolHome.notificationIcon.setOnClickListener (this);

        binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_ac);
        binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor
                (R.color.colorbutton));

    }

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
        ft.add (R.id.home_fragment_container, new HomePageFragment ());
        ft.commit ();
    }
}
