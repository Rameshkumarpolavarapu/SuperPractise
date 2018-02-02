package com.focus.superpractise.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.focus.superpractise.R;
import com.focus.superpractise.utils.Utility;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by P Ramesh Kumar on 30-01-2018.
 */

public class ProfileView extends Activity implements View.OnClickListener {
    private Utility utility = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scrollView.setFillViewport(true);

        LinearLayout relativeLayout = new LinearLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#EDEDED"));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(params);
        scrollView.addView(relativeLayout);

        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.setMargins(45, 60, 45, 0);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params1);

        ImageView circleImageView = new ImageView(this);
        circleImageView.setId(R.id.circleImageView);
        LinearLayout.LayoutParams circleImageViewParams = new LinearLayout.LayoutParams(200, 200);
        circleImageViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            circleImageView.setZ(100f);
        }
        circleImageView.setLayoutParams(circleImageViewParams);
        circleImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.shawn));
        layout.addView(circleImageView);
        layout.addView(getMyView(this));

        layout.addView(getButtonView(this));


        relativeLayout.addView(layout);
        setContentView(scrollView);
    }

    private View getButtonView(Context clContext) {
        LinearLayout linearLayout = new LinearLayout(clContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 65, 0, 30);
        linearLayout.setLayoutParams(params);

        Button signUpButton = new Button(this);
        signUpButton.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 50, 0, 20, Gravity.CENTER_HORIZONTAL));
        signUpButton.setText(R.string.finish);
        signUpButton.setId(R.id.finish);
        signUpButton.setBackground(utility.getMyButtonBackGround(ContextCompat.getColor(this, R.color.colorGrayTheme)));
        signUpButton.setPadding(0, 40, 0, 40);
        signUpButton.setTextColor(Color.WHITE);
        signUpButton.setOnClickListener(this);
        linearLayout.addView(signUpButton);
        return linearLayout;
    }

    private View getMyView(Context clContext) {

        utility = new Utility();

        LinearLayout linearLayout = new LinearLayout(clContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, -100, 0, 0);
        linearLayout.setLayoutParams(params);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackground(utility.getMyButtonBackGround(ContextCompat.getColor(this, R.color.colorGrayTheme)));


        ImageView editImageView = new ImageView(clContext);
        LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams(60, 60);
        imageViewParams.setMargins(0, 25, 25, 0);
        imageViewParams.gravity = Gravity.END;
        editImageView.setLayoutParams(imageViewParams);
        editImageView.setImageResource(R.drawable.ic_edit);
        linearLayout.addView(editImageView);

        TextView nameTextView = new TextView(clContext);
        nameTextView.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 25, 0, 0, Gravity.CENTER_HORIZONTAL));
        nameTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        nameTextView.setTextColor(Color.WHITE);
//        nameTextView.setTypeface(Typeface.DEFAULT_BOLD);
        nameTextView.setText("Damir Bektilov");
        linearLayout.addView(nameTextView);

        TextView mailIdTextView = new TextView(clContext);
        mailIdTextView.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 14, 0, 25, Gravity.CENTER_HORIZONTAL));
        mailIdTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        mailIdTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        mailIdTextView.setTextColor(Color.WHITE);
        mailIdTextView.setText("damir331company@gmail.com");
        linearLayout.addView(mailIdTextView);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        View horizontalLineView = new View(clContext);
        horizontalLineView.setBackgroundColor(Color.WHITE);
        LinearLayout.LayoutParams horizontalLineParams = new LinearLayout.LayoutParams(width * 45 / 100, 2);
        horizontalLineParams.setMargins(0, 15, 0, 15);
        horizontalLineParams.gravity = Gravity.CENTER_HORIZONTAL;
        horizontalLineView.setLayoutParams(horizontalLineParams);
        linearLayout.addView(horizontalLineView);

        TextView dobTextView = new TextView(clContext);
        dobTextView.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 15, 0, 15, Gravity.CENTER_HORIZONTAL));
        dobTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        dobTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        dobTextView.setTextColor(Color.WHITE);
        dobTextView.setText("AUG | 27 | 1991");
        linearLayout.addView(dobTextView);

        TextView genderTextView = new TextView(clContext);
        genderTextView.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 15, 0, 30, Gravity.CENTER_HORIZONTAL));
        genderTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        genderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        genderTextView.setTextColor(Color.WHITE);
        genderTextView.setText("MEN");
        linearLayout.addView(genderTextView);

        linearLayout.addView(getAllSocialMediaImages(clContext));

       /* ImageView circleImageView =   new ImageView(this);
        circleImageView.setId(R.id.circleImageView);
        LinearLayout.LayoutParams circleImageViewParams    =   new LinearLayout.LayoutParams(200,200);
        circleImageViewParams.gravity = Gravity.TOP;
       *//* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            circleImageView.setZ(100f);
        }*//*
        circleImageView.setLayoutParams(circleImageViewParams);
        circleImageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.shawn));
        linearLayout.addView(circleImageView);*/

        return linearLayout;
    }

    private View getAllSocialMediaImages(Context clContext) {
        RelativeLayout relativeLayout = new RelativeLayout(clContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 35, 0, 55);
        relativeLayout.setLayoutParams(params);
        relativeLayout.setGravity(Gravity.CENTER_HORIZONTAL);


        // fb image
        ImageView fbImageView = new ImageView(clContext);
        fbImageView.setId(R.id.fbImageView);
        RelativeLayout.LayoutParams fbImageViewParams = new RelativeLayout.LayoutParams(85, 85);
        fbImageViewParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        fbImageView.setLayoutParams(fbImageViewParams);
        fbImageView.setImageResource(R.drawable.ic_facebook_logo_button);
        relativeLayout.addView(fbImageView);

        // googlePlus image
        ImageView googlePlusImageView = new ImageView(clContext);
        googlePlusImageView.setId(R.id.googlePlusImageView);
        RelativeLayout.LayoutParams googlePlusImageViewParams = new RelativeLayout.LayoutParams(85, 85);
        googlePlusImageViewParams.setMargins(25, 0, 0, 0);
        googlePlusImageViewParams.addRule(RelativeLayout.END_OF, R.id.fbImageView);
        googlePlusImageView.setLayoutParams(googlePlusImageViewParams);
        googlePlusImageView.setImageResource(R.drawable.ic_google_plus_logo_button);
        relativeLayout.addView(googlePlusImageView);

        // twitter image
        ImageView twitterImageView = new ImageView(clContext);
        RelativeLayout.LayoutParams twitterImageViewParams = new RelativeLayout.LayoutParams(85, 85);
        twitterImageViewParams.setMargins(25, 0, 0, 0);
        twitterImageViewParams.addRule(RelativeLayout.END_OF, R.id.googlePlusImageView);
        twitterImageView.setLayoutParams(twitterImageViewParams);
        twitterImageView.setId(R.id.twitterImageView);
        twitterImageView.setImageResource(R.drawable.ic_twitter_logo);
        relativeLayout.addView(twitterImageView);

        // instagram image
        ImageView instagramImageView = new ImageView(clContext);
        RelativeLayout.LayoutParams instagramImageViewParams = new RelativeLayout.LayoutParams(85, 85);
        instagramImageViewParams.setMargins(25, 0, 0, 0);
        instagramImageViewParams.addRule(RelativeLayout.END_OF, R.id.twitterImageView);
        instagramImageView.setLayoutParams(instagramImageViewParams);
        instagramImageView.setId(R.id.instagramImageView);
        instagramImageView.setImageResource(R.drawable.ic_social_instagram_circle);
        relativeLayout.addView(instagramImageView);
        return relativeLayout;
    }

    @Override
    public void onClick(View view) {

    }
}