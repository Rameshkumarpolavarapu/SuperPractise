package com.focus.superpractise.view;
import com.focus.superpractise.utils.Utility;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.focus.superpractise.R;

/**
 * Created by P Ramesh Kumar on 25-01-2018.
 */

public class SignInActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout =   new LinearLayout(this);
        LinearLayout.LayoutParams params    =   new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.WHITE);
        layout.setLayoutParams(params);
        layout.addView(getMyView(this));

        setContentView(layout);
    }

    private View getMyView(Context clContext) {
        Utility utility = new Utility();

        LinearLayout layout =   new LinearLayout(clContext);
        LinearLayout.LayoutParams params    =   new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(45,0,45,0);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);

        ImageView logo_ImageView =   new ImageView(clContext);
        logo_ImageView.setImageResource(R.drawable.ic_yoga_ball);
        LinearLayout.LayoutParams imageViewParams    =   new LinearLayout.LayoutParams(utility.getMyLayoutParams(false,false,false,true,130,130,0,60,0,70, Gravity.CENTER_HORIZONTAL));
        imageViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        logo_ImageView.setLayoutParams(imageViewParams);
        layout.addView(logo_ImageView);

        EditText editText_userName = new EditText(clContext);
        editText_userName.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,0,0,0,Gravity.CENTER_HORIZONTAL));
        editText_userName.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(clContext,R.drawable.ic_user),null,null,null);
        editText_userName.setSingleLine(true);
        editText_userName.setHint(R.string.user_name);
        editText_userName.setId(R.id.user_name_editText);
        editText_userName.setPadding(20,30,0,30);
        editText_userName.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(editText_userName);

        EditText editText_password = new EditText(clContext);
        editText_password.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,25,0,25,Gravity.CENTER_HORIZONTAL));
        editText_password.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(clContext,R.drawable.ic_padlock),null,null,null);
        editText_password.setHint(R.string.password);
        editText_password.setSingleLine(true);
        editText_password.setId(R.id.password_editText);
        editText_password.setPadding(20,30,0,30);
        editText_password.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(editText_password);

        TextView textView_Forget_password   =   new TextView(clContext);
        textView_Forget_password.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,0,0,0,Gravity.CENTER_HORIZONTAL));
        textView_Forget_password.setText(R.string.forgot_password);
        textView_Forget_password.setId(R.id.forget_password);
        textView_Forget_password.setTextColor(Color.parseColor("#FFA7A7A7"));
        textView_Forget_password.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(textView_Forget_password);

        Button createAccountButton  =   new Button(clContext);
        createAccountButton.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,45,0,30,Gravity.CENTER_HORIZONTAL));
        createAccountButton.setText(R.string.log_in_button);
        createAccountButton.setId(R.id.log_in_button);
        createAccountButton.setBackground(utility.getMyButtonBackGround(ContextCompat.getColor(this,R.color.colorGrayTheme)));
        createAccountButton.setPadding(5,35,5,35);
        createAccountButton.setTextColor(Color.WHITE);
        createAccountButton.setOnClickListener(this);
        layout.addView(createAccountButton);

        layout.addView(utility.getHorizontalLineWithCenterText(clContext,"OR",Color.GRAY));

        Button fb_LoginButton  =   new Button(clContext);
        fb_LoginButton.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,30,0,10,Gravity.START));
        fb_LoginButton.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(clContext,R.drawable.ic_facebook_logo),null,null,null);
        fb_LoginButton.setBackground(utility.getMyButtonBackGround(ContextCompat.getColor(this,R.color.colorFbTheme)));
        fb_LoginButton.setPadding(60,35,150,35);
        fb_LoginButton.setGravity(Gravity.END);
        fb_LoginButton.setText(R.string.fb_login);
        fb_LoginButton.setId(R.id.fb_login_button);
        fb_LoginButton.setTextColor(Color.WHITE);
        fb_LoginButton.setOnClickListener(this);
        layout.addView(fb_LoginButton);

        TextView textView_signUp_option =   new TextView(clContext);
        textView_signUp_option.setLayoutParams(utility.getMyLayoutParams(false,true,false,false,0,0,0,15,0,0,Gravity.START));
        textView_signUp_option.setPadding(0,10,0,10);
        textView_signUp_option.setGravity(Gravity.START);
        textView_signUp_option.setOnClickListener(this);

        String udata=getResources().getString(R.string.dont_have_account);
        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 20, udata.length(), 0);

        ClickableSpan clickableSpan =   new ClickableSpan() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this,CreateAccountActivity.class));
                finish();
            }
        };
        content.setSpan(clickableSpan,20,udata.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        content.setSpan(new ForegroundColorSpan(Color.BLUE),20,udata.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView_signUp_option.setText(content);
        textView_signUp_option.setMovementMethod(LinkMovementMethod.getInstance());
        textView_signUp_option.setGravity(Gravity.CENTER_HORIZONTAL);
        textView_signUp_option.setId(R.id.term_and_conditions);
        layout.addView(textView_signUp_option);

        return layout;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.log_in_button:
                Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
            break;
            case R.id.fb_login_button:
                Toast.makeText(this, "Fb Login", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}