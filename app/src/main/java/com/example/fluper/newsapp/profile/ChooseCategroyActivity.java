package com.example.fluper.newsapp.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityChooseCategroyBinding;
import com.xiaofeng.flowlayoutmanager.Alignment;
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.w3c.dom.Text;

public class ChooseCategroyActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityChooseCategroyBinding binding;
    private String categroyItem[] = {"Entertainment", "Relationship", "Cricket", "Politics", "Tech",
            "Lifestyle", "Fashion", "Sex", "Entertainment", "Sex", "Relationship"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_choose_categroy);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_choose_categroy);
        tagFlowLayout ();
        initControles ();

    }

    public void initControles() {

        binding.signupBtn.setOnClickListener (this);
    }

    //Tag flow layout for chosing interest fields.
    public void tagFlowLayout() {

        final LayoutInflater inflater = getLayoutInflater ();

        final LayoutInflater mInflater = LayoutInflater.from (this);
        binding.catLayout.setMaxSelectCount (4);
        binding.catLayout.setAdapter (new TagAdapter<String> (categroyItem) {

            @Override
            public View getView(FlowLayout parent, final int position, String s) {


          /*  SearchSkillsRvListScreenBinding searchSkillsRvListScreenBinding=
                    DataBindingUtil.inflate(mInflater, R.layout.search_skills_rv_list_screen,
                            parent, false);*/
                View view = mInflater.inflate (R.layout.flow_catrgory_layout,
                        binding.catLayout, false);

                final TextView searchSkillsTxtId = view.findViewById (R.id.entertainment);
                searchSkillsTxtId.setText (s);
                searchSkillsTxtId.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {
                        //searchSkillsTxtId.setBackgroundColor (getResources ().getColor (R.color.colorbutton));
                        searchSkillsTxtId.setTextColor (getResources ().getColor (R.color.colorPrimaryDark));
                        searchSkillsTxtId.setBackground (getResources ().getDrawable (R.drawable.choose_category_drawable_layout));
                    }
                });

                return view;
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()) {
            case R.id.signup_btn:
                startActivity (new Intent (this, CreateProfileActivity.class));
                break;

        }
    }
}








