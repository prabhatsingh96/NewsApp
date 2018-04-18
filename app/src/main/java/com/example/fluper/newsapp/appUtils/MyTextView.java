package com.example.fluper.newsapp.appUtils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by fluper on 12/4/18.
 */

public class MyTextView  extends android.support.v7.widget.AppCompatTextView{

        public MyTextView(Context context, AttributeSet attrs, int defStyle) {
            super (context, attrs, defStyle);
            init ();
        }

        public MyTextView(Context context, AttributeSet attrs) {
            super (context, attrs);
            init ();
        }

        public MyTextView(Context context) {
            super (context);
            init ();
        }

        private void init() {
            if (!isInEditMode ()) {
                Typeface tf = Typeface.createFromAsset (getContext ().getAssets (),
                        "fonts/SF-SAN-FRANCISCO-UI-DISPLAY-REGULAR-594B948E3C12A.ttf");
                setTypeface (tf);
            }
        }

    }

