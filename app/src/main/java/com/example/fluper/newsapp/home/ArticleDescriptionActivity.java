package com.example.fluper.newsapp.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.fluper.newsapp.R;
import com.example.fluper.newsapp.databinding.ActivityArticleDescriptionBinding;
import com.example.fluper.newsapp.payment.PaymentInfoActivity;
import com.example.fluper.newsapp.subscription.SubscriptionActivity;

public class ArticleDescriptionActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int MAX_LINES = 3;

    //String myReallyLongText = "Bacon ipsum dolor amet porchetta venison ham fatback alcatra tri-tip, turducken strip steak sausage rump burgdoggen pork loin. Spare ribs filet mignon salami, strip steak ball tip shank frankfurter corned beef venison. Pig pork belly pork chop andouille. Porchetta pork belly ground round, filet mignon bresaola chuck swine shoulder leberkas jerky boudin. Landjaeger pork chop corned beef, tri-tip brisket rump pastrami flank";
    private ActivityArticleDescriptionBinding binding;
    private MyRecyclerAdapter mAdapter;
    private MyHomeRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //setContentView (R.layout.activity_article_description);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_article_description);
        initControles ();
    }


    public void initControles(){
        adapter = new MyHomeRecyclerAdapter (this);
        binding.rvProductDescription.setLayoutManager (new GridLayoutManager (this,2));
        binding.rvProductDescription.setAdapter (adapter);
        binding.backBtnDescription.setOnClickListener (this);
        binding.subcribreLayout.setOnClickListener (this);
        binding.buynowBtn.setOnClickListener (this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.back_btn_description:
                super.onBackPressed ();
                break;

            case R.id.subcribre_layout:
                startActivity (new Intent (this, SubscriptionActivity.class));
                break;

                case R.id.buynow_btn:
                    startActivity (new Intent (this, PaymentInfoActivity.class));
                    break;
        }

    }




   /*  .setText(myReallyLongText);
     textView.post(new

    Runnable() {
        @Override
        public void run () {
            // Past the maximum number of lines we want to display.
            if (textView.getLineCount () > MAX_LINES) {
                int lastCharShown = textView.getLayout ().getLineVisibleEnd (MAX_LINES - 1);

                textView.setMaxLines (MAX_LINES);

                String moreString = context.getString (R.string.more);
                String suffix = TWO_SPACES + moreString;

                // 3 is a "magic number" but it's just basically the length of the ellipsis we're going to insert
                String actionDisplayText = myReallyLongText.substring (0, lastCharShown - suffix.length () - 3) + "..." + suffix;

                SpannableString truncatedSpannableString = new SpannableString (actionDisplayText);
                int startIndex = actionDisplayText.indexOf (moreString);
                truncatedSpannableString.setSpan (new ForegroundColorSpan (context.getColor (android.R.color.blue)), startIndex, startIndex + moreString.length (), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText (truncatedSpannableString);
            }
        }
    });*/

   interface onMyRecyclerClickListener{void onClick(final View view, int pos);
       }
   }

