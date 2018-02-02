package com.focus.superpractise.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.focus.superpractise.R;
import com.focus.superpractise.utils.Utility;

import java.security.PublicKey;

/**
 * Created by P Ramesh Kumar on 01-02-2018.
 */

public class WelcomeSlide {

    public RelativeLayout WelcomeSlideModel1(Context clContext, int id, int iColor, int drawable, String sTitleString, String sDescriptionString) {

        RelativeLayout relativeLayout = new RelativeLayout(clContext);
        relativeLayout.setId(id);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(params);
        relativeLayout.setBackgroundColor(ContextCompat.getColor(clContext,iColor));
        LinearLayout linearLayout = new LinearLayout(clContext);
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.addRule(RelativeLayout.CENTER_IN_PARENT);
        linearLayout.setLayoutParams(params1);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ImageView imageView = new ImageView(clContext);
        LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams(Utility.toDip(clContext,120), Utility.toDip(clContext,120));
        imageViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        imageView.setLayoutParams(imageViewParams);
        imageView.setImageDrawable(ContextCompat.getDrawable(clContext, drawable));
        linearLayout.addView(imageView);
        TextView titleTextView = new TextView(clContext);
        LinearLayout.LayoutParams titleTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleTextViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        titleTextView.setLayoutParams(titleTextViewParams);
        titleTextView.setTextColor(Color.WHITE);
        titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        titleTextView.setText(sTitleString);
        titleTextView.setTypeface(Typeface.DEFAULT_BOLD);
        linearLayout.addView(titleTextView);

        TextView descTextView = new TextView(clContext);
        LinearLayout.LayoutParams descTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        descTextViewParams.setMargins(0, 20, 0, 0);
        descTextViewParams.gravity  =   Gravity.CENTER_HORIZONTAL;
        descTextView.setLayoutParams(descTextViewParams);
        descTextView.setPadding(40, 0, 40, 0);
        descTextView.setTextColor(Color.WHITE);
        descTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        descTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        descTextView.setText(sDescriptionString);
        descTextView.setTypeface(Typeface.DEFAULT_BOLD);
        linearLayout.addView(descTextView);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }
}