package com.focus.superpractise.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.focus.superpractise.R;
import com.focus.superpractise.utils.Utility;

/**
 * Created by P Ramesh Kumar on 29-01-2018.
 */

public class CreateAccountActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.WHITE);
        layout.setLayoutParams(params);
        layout.addView(getMyView(this));
        setContentView(layout);
    }

    private View getMyView(final Context clContext) {

        Utility utility = new Utility();

        LinearLayout layout = new LinearLayout(clContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(55, 0, 55, 0);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.WHITE);
        layout.setLayoutParams(params);

        TextView textView_title = new TextView(clContext);
        textView_title.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 35, 0, 35, Gravity.START));
        textView_title.setText(R.string.create_account);
        textView_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        textView_title.setTypeface(Typeface.DEFAULT_BOLD);
        textView_title.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(textView_title);

        TextView textView_email = new TextView(clContext);
        textView_email.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 15, Gravity.START));
        textView_email.setText(R.string.email);
        layout.addView(textView_email);

        EditText editText_Email = new EditText(clContext);
        editText_Email.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 30, Gravity.CENTER_HORIZONTAL));
        editText_Email.setSingleLine(true);
        editText_Email.setBackground(utility.getMyEditextBackGround(Color.parseColor("#E8E6E6")));
        editText_Email.setCursorVisible(false);
        editText_Email.setPadding(40, 40, 0, 40);
        editText_Email.setHint(R.string.email_hint);
        editText_Email.setId(R.id.email_editText);
        editText_Email.setGravity(Gravity.START);
        layout.addView(editText_Email);

        TextView textView_password = new TextView(clContext);
        textView_password.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 15, Gravity.START));
        textView_password.setText(R.string.password);
        layout.addView(textView_password);

        EditText editText_pwd = new EditText(clContext);
        editText_pwd.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 30, Gravity.CENTER_HORIZONTAL));
        editText_pwd.setSingleLine(true);
        editText_pwd.setPadding(40, 40, 0, 40);
        editText_pwd.setBackground(utility.getMyEditextBackGround(Color.parseColor("#E8E6E6")));
        editText_pwd.setCursorVisible(false);
        editText_pwd.setHint(R.string.password_hint);
        editText_pwd.setId(R.id.password_editText);
        editText_pwd.setGravity(Gravity.START);
        layout.addView(editText_pwd);

        TextView textView_re_pwd = new TextView(clContext);
        textView_re_pwd.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 15, Gravity.START));
        textView_re_pwd.setText(R.string.re_psw);
        layout.addView(textView_re_pwd);

        EditText editText_re_pwd = new EditText(clContext);
        editText_re_pwd.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 30, Gravity.CENTER_HORIZONTAL));
        editText_re_pwd.setSingleLine(true);
        editText_re_pwd.setPadding(40, 40, 0, 40);
        editText_re_pwd.setBackground(utility.getMyEditextBackGround(Color.parseColor("#E8E6E6")));
        editText_re_pwd.setCursorVisible(false);
        editText_re_pwd.setHint(R.string.re_psw_hint);
        editText_re_pwd.setId(R.id.re_pwd_editText);
        editText_re_pwd.setGravity(Gravity.START);
        layout.addView(editText_re_pwd);

        LinearLayout layout1 = new LinearLayout(clContext);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.setMargins(0, 15, 0, 0);
        layout1.setLayoutParams(params1);
        layout1.setOrientation(LinearLayout.VERTICAL);
        layout1.addView(getTermsAndConditionsView(clContext));
        layout.addView(layout1);

        Button signUpButton = new Button(clContext);
        signUpButton.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 50, 0, 20, Gravity.CENTER_HORIZONTAL));
        signUpButton.setText(R.string.sign_up_button);
        signUpButton.setId(R.id.sign_up_button);
        signUpButton.setBackground(utility.getMyButtonBackGround(ContextCompat.getColor(this, R.color.colorGrayTheme)));
        signUpButton.setPadding(5, 35, 5, 35);
        signUpButton.setTextColor(Color.WHITE);
        signUpButton.setOnClickListener(this);
        layout.addView(signUpButton);

        TextView textView_alreadyHaveAccount = new TextView(clContext);
        textView_alreadyHaveAccount.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 15, 0, 0, Gravity.START));
        textView_alreadyHaveAccount.setPadding(0, 10, 0, 10);
        textView_alreadyHaveAccount.setGravity(Gravity.START);
        String udata = getResources().getString(R.string.already_have_account);
        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 25, udata.length(), 0);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccountActivity.this, SignInActivity.class));
                finish();
            }
        };
        content.setSpan(clickableSpan, 25, udata.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        content.setSpan(new ForegroundColorSpan(Color.BLUE), 25, udata.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView_alreadyHaveAccount.setText(content);
        textView_alreadyHaveAccount.setMovementMethod(LinkMovementMethod.getInstance());
        textView_alreadyHaveAccount.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(textView_alreadyHaveAccount);
        return layout;
    }

    private View getTermsAndConditionsView(Context clContext) {

        LinearLayout linearLayout = new LinearLayout(clContext);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        linearLayout.setLayoutParams(params);

        CheckBox checkBox = new CheckBox(clContext);
        LinearLayout.LayoutParams checkBoxParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.5f);
        checkBoxParams.setMargins(20, 0, 0, 0);
        checkBox.setLayoutParams(checkBoxParams);
        linearLayout.addView(checkBox);

        TextView textView = new TextView(clContext);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 3);
        textView.setLayoutParams(textViewParams);
        textView.setText(R.string.terms_and_conditions);
        linearLayout.addView(textView);
        return linearLayout;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.sign_up_button:
                startActivity(new Intent(CreateAccountActivity.this, CreateProfile.class));
                break;
        }
    }
}
