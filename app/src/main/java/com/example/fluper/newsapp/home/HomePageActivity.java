package com.example.fluper.newsapp.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.authentication.LogInFragment;
import com.example.fluper.newsapp.authentication.SignUpFragment;
import com.example.fluper.newsapp.authentication.TabAdapter;
import com.example.fluper.newsapp.databinding.ActivityHomePageBinding;
import com.example.fluper.newsapp.profile.ProfileActivity;

import butterknife.BindView;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityHomePageBinding binding;
    private TabAdapter tabAdapter;
    MyRecyclerAdapter mMyRecyclerAdapter;
    private MyHomeRecyclerAdapter adapterRectangle;
    @BindView(R.id.include_forgot_layout)
    View toolLayout;

    @Override
    protected void onRestart() {
        super.onRestart ();
      /*  binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_de);
        binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorPrimary));
       *//* binding.includeBottomLayout.ivBookmark.setImageResource (R.drawable.bottom_bookmark_de);
        binding.includeBottomLayout.bookmarkText.setTextColor (getResources ().getColor (R.color.colorPrimary));

        binding.includeBottomLayout.ivSearch.setImageResource (R.drawable.bottom_search_de);
        binding.includeBottomLayout.searchText.setTextColor (getResources ().getColor (R.color.colorPrimary));
    */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_home_page);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_home_page);
       /* binding.navigation.setOnNavigationItemSelectedListener (new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId ()) {
                    case R.id.navigation_home:
                        addFirstFragment ();
                        break;
                    case R.id.navigation_search:
                        replaceFragment (R.id.home_fragment_container,new SearchFragment ());
                        break;
                    case R.id.navigation_saved:
                        replaceFragment (R.id.home_fragment_container,new SavedFragment ());
                        break;
                    case R.id.navigation_profile:
                        replaceFragment (R.id.home_fragment_container,new SavedFragment ());
                        break;
                    case  R.id.bookmarkk:
                        replaceFragment (R.id.home_fragment_container,new BookmarkFragment ());
                        break;

                }
                return true;

            }
        });*/


        mMyRecyclerAdapter = new MyRecyclerAdapter (this);
        binding.homeRecyclerView.setLayoutManager (new LinearLayoutManager
                (this, LinearLayoutManager.HORIZONTAL, true));
        binding.homeRecyclerView.setAdapter (mMyRecyclerAdapter);
        binding.homeRecyclerVieww.setLayoutManager (new GridLayoutManager (this, 2));
        adapterRectangle = new MyHomeRecyclerAdapter (this);
        binding.homeRecyclerVieww.setAdapter (adapterRectangle);
        binding.includeBottomLayout.ivProfile.setOnClickListener (this);
        binding.includeBottomLayout.ivHome.setOnClickListener (this);
       // binding.includeBottomLayout.v.setOnClickListener (this);

    //  binding.includeBottomLayout.ivSearch.setOnClickListener (this);

     //  binding.includeBottomLayout.ivBookmark.setOnClickListener (this);
        binding.includeBottomLayout.ivHome.setImageResource (R.drawable.bottom_home_ac);
        binding.includeBottomLayout.homeText.setTextColor (getResources ().getColor (R.color.colorbutton));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.home_recycler_view:
                startActivity (new Intent (this, ArticleDescriptionActivity.class));
                break;
            case R.id.iv_profile:
                binding.includeBottomLayout.ivProfile.setImageResource (R.drawable.bottom_profile_ac);
                binding.includeBottomLayout.profileText.setTextColor (getResources ().getColor (R.color.colorbutton));
                startActivity (new Intent (this, ProfileActivity.class));
                break;
            case R.id.iv_home:
                startActivity (new Intent (this, HomePageActivity.class));
                break;
            case R.id.iv_bookmark:
                binding.includeBottomLayout.ivBookmark.setImageResource (R.drawable.bottom_bookmark_ac);
                startActivity (new Intent (this, BookMarksActivity.class));
                break;
            case R.id.iv_search:
                binding.includeBottomLayout.ivSearch.setImageResource (R.drawable.bottom_search_ac);
                binding.includeBottomLayout.searchText.setTextColor (getResources ().getColor (R.color.colorPurple));
                startActivity (new Intent (this, SearchActivity.class));
                break;
          /*  case R.id.v:
                break;
*/
        }
    }

    public void replaceFragment(int fragmentId, Fragment fragment){
    android.support.v4.app.FragmentManager frg = getSupportFragmentManager();
    FragmentTransaction ft = frg.beginTransaction();
        ft.replace(fragmentId, fragment);
        ft.commit();
}

   /* public void addFirstFragment(){

        android.support.v4.app.FragmentManager frg = getSupportFragmentManager();
        FragmentTransaction ft = frg.beginTransaction();
        ft.add(R.id.home_fragment_container, new HomePageFragment ());
        ft.commit();
    }
*/




/*
    public void tabSetUp(){
        tabAdapter = new TabAdapter (getSupportFragmentManager());
        tabAdapter.addTab(new HomePageFragment (),"Home");
        tabAdapter.addTab(new SearchFragment (),"Search");
        tabAdapter.addTab(new BookmarkFragment (),"Bookmark");
        tabAdapter.addTab(new SavedFragment (),"Saved");
        tabAdapter.addTab(new ProfileFragment (),"Profile");
        binding.viewPager.setAdapter(tabAdapter);
        binding.homeTabLayoutt.setupWithViewPager(binding.viewPager);
    }


    private void setupTabIcons() {
        binding.homeTabLayoutt.getTabAt(0).setIcon(R.drawable.bottom_home_de);
        binding.homeTabLayoutt.getTabAt(1).setIcon(R.drawable.bottom_search_de);
        binding.homeTabLayoutt.getTabAt(3).setIcon(R.drawable.bottom_bookmark_de);
        binding.homeTabLayoutt.getTabAt(4).setIcon(R.drawable.bottom_download_de);
        binding.homeTabLayoutt.getTabAt(5).setIcon(R.drawable.bottom_profile_de);
    }*/



}
