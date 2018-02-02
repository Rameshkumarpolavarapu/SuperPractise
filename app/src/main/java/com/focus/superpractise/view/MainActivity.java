package com.focus.superpractise.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.focus.superpractise.R;
import com.focus.superpractise.utils.Utility;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout =   new LinearLayout(this);
        LinearLayout.LayoutParams params    =   new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);

        layout.addView(getMyView(this));


        setContentView(layout);
    }

    private View getMyView(Context clContext) {
        Utility utility = new Utility();
        LinearLayout layout =   new LinearLayout(clContext);
        LinearLayout.LayoutParams params    =   new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(45,0,45,0);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);

        ImageView imageView =   new ImageView(clContext);
        LinearLayout.LayoutParams imageViewParams    =   new LinearLayout.LayoutParams(utility.getMyLayoutParams(false,false,false,true,130,130,0,60,0,80,Gravity.CENTER_HORIZONTAL));
        imageViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        imageView.setLayoutParams(imageViewParams);
        imageView.setImageResource(R.drawable.ic_yoga_ball);
        layout.addView(imageView);


        TextView textView_welcome_title   =   new TextView(clContext);
        textView_welcome_title.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,0,0,28,Gravity.CENTER_HORIZONTAL));
        textView_welcome_title.setText(R.string.welcome_msg);
        textView_welcome_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        textView_welcome_title.setTypeface(Typeface.DEFAULT_BOLD);
        textView_welcome_title.setPadding(0,10,0,10);
        textView_welcome_title.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(textView_welcome_title);


        TextView textView_Welcome_desc   =   new TextView(clContext);
        textView_Welcome_desc.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,0,0,55,Gravity.CENTER_HORIZONTAL));
        textView_Welcome_desc.setText(R.string.welcome_desc);
        textView_Welcome_desc.setLineSpacing(1f,1.5f);
        textView_Welcome_desc.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        textView_Welcome_desc.setPadding(3,10,3,10);
        textView_Welcome_desc.setTextColor(Color.DKGRAY);
        textView_Welcome_desc.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(textView_Welcome_desc);

        Button createAccountButton  =   new Button(clContext);
        createAccountButton.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,35,0,5,Gravity.CENTER_HORIZONTAL));
        createAccountButton.setText(R.string.create_account_button);
        createAccountButton.setId(R.id.create_account_button);
        createAccountButton.setBackground(utility.getMyButtonBackGround(ContextCompat.getColor(this,R.color.colorPurpleTheme)));
        createAccountButton.setPadding(5,35,5,35);
        createAccountButton.setTextColor(Color.WHITE);
        createAccountButton.setOnClickListener(this);
        layout.addView(createAccountButton);

        Button signInButton  =   new Button(clContext);
        signInButton.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,10,0,10,Gravity.CENTER_HORIZONTAL));
        signInButton.setText(R.string.sign_in_button);
        signInButton.setId(R.id.sign_in_button);
        signInButton.setTextColor(Color.WHITE);
        signInButton.setOnClickListener(this);
        signInButton.setBackground(utility.getMyButtonBackGround(ContextCompat.getColor(this,R.color.colorGrayTheme)));
        signInButton.setPadding(5,35,5,35);
        layout.addView(signInButton);

        TextView textView_terms_privacy =   new TextView(clContext);
        textView_terms_privacy.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,0,0,0,Gravity.CENTER_HORIZONTAL));
        textView_terms_privacy.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        textView_terms_privacy.setPadding(0,10,0,10);
        textView_terms_privacy.setGravity(Gravity.CENTER_HORIZONTAL);
        textView_terms_privacy.setTextColor(ContextCompat.getColor(clContext,R.color.colorBlueLight));
        textView_terms_privacy.setTypeface(Typeface.DEFAULT_BOLD);
        textView_terms_privacy.setOnClickListener(this);
        //        textView_terms_privacy.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        String udata=getResources().getString(R.string.terms_and_privacy);
        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);
        textView_terms_privacy.setText(content);
        textView_terms_privacy.setId(R.id.term_and_conditions);
        layout.addView(textView_terms_privacy);

        return layout;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_button:
                startActivity(new Intent(this,SignInActivity.class));
                break;
            case R.id.create_account_button:
                startActivity(new Intent(this,CreateAccountActivity.class));
                break;
            case R.id.term_and_conditions:
                Toast.makeText(this, R.string.terms_and_privacy, Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
