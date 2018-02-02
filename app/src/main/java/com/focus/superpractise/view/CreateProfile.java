package com.focus.superpractise.view;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.focus.superpractise.R;
import com.focus.superpractise.utils.Utility;

/**
 * Created by P Ramesh Kumar on 30-01-2018.
 */

public class CreateProfile extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        scrollView.setFillViewport(true);

        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.WHITE);
        layout.setLayoutParams(params);
        layout.addView(getMyView(this));

        scrollView.addView(layout);

        setContentView(scrollView);
    }

    private View getMyView(final Context clContext) {

        Utility utility = new Utility();

        LinearLayout layout = new LinearLayout(clContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(55, 0, 55, 0);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.setBackgroundColor(Color.WHITE);
        layout.setLayoutParams(params);

        ImageView circleImageView = new ImageView(clContext);
        circleImageView.setLayoutParams(utility.getMyLayoutParams(false, false, false, true, 230, 230, 0, 50, 0, 20, Gravity.CENTER_VERTICAL));
        circleImageView.setImageResource(R.drawable.ic_photo_camera);
        layout.addView(circleImageView);

        TextView textView_Add_Photo = new TextView(clContext);
        layout.addView(textView_Add_Photo);
        textView_Add_Photo.setText(R.string.add_photo);
        textView_Add_Photo.setTypeface(Typeface.DEFAULT_BOLD);
        textView_Add_Photo.setGravity(Gravity.CENTER_HORIZONTAL);
        textView_Add_Photo.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 35, Gravity.CENTER_HORIZONTAL));

        EditText editText_Email = new EditText(clContext);
        editText_Email.setPadding(40, 40, 0, 40);
        editText_Email.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 30, Gravity.CENTER_HORIZONTAL));
        editText_Email.setBackground(utility.getMyEditextBackGround(Color.parseColor("#E8E6E6")));
        editText_Email.setSingleLine(true);
        editText_Email.setCursorVisible(false);
        editText_Email.setGravity(Gravity.FILL_VERTICAL);
        editText_Email.setId(R.id.full_name_editText);
        editText_Email.setHint(R.string.full_name_hint);
        layout.addView(editText_Email);

        EditText editText_userName = new EditText(clContext);
        editText_userName.setPadding(40, 40, 0, 40);
        editText_userName.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 30, Gravity.CENTER_HORIZONTAL));
        editText_userName.setBackground(utility.getMyEditextBackGround(Color.parseColor("#E8E6E6")));
        editText_userName.setSingleLine(true);
        editText_userName.setCursorVisible(false);
        editText_userName.setGravity(Gravity.START);
        editText_userName.setId(R.id.user_name_editText);
        editText_userName.setHint(R.string.user_name);
        layout.addView(editText_userName);

        EditText editText_ph = new EditText(clContext);
        editText_ph.setPadding(40, 40, 0, 40);
        editText_ph.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 30, Gravity.CENTER_HORIZONTAL));
        editText_ph.setBackground(utility.getMyEditextBackGround(Color.parseColor("#E8E6E6")));
        editText_ph.setSingleLine(true);
        editText_ph.setCursorVisible(false);
        editText_ph.setGravity(Gravity.START);
        editText_ph.setId(R.id.ph_editText);
        editText_ph.setHint(R.string.phone_no_hint);
        layout.addView(editText_ph);

        EditText editText_address = new EditText(clContext);
        editText_address.setPadding(40, 40, 0, 40);
        editText_address.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 30, Gravity.CENTER_HORIZONTAL));
        editText_address.setBackground(utility.getMyEditextBackGround(Color.parseColor("#E8E6E6")));
        editText_address.setSingleLine(true);
        editText_address.setCursorVisible(false);
        editText_address.setGravity(Gravity.START);
        editText_address.setId(R.id.address_editText);
        editText_address.setHint(R.string.address_hint);
        layout.addView(editText_address);

        EditText editText_dob = new EditText(clContext);
        editText_dob.setPadding(40, 40, 0, 40);
        editText_dob.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 0, 0, 30, Gravity.CENTER_HORIZONTAL));
        editText_dob.setBackground(utility.getMyEditextBackGround(Color.parseColor("#E8E6E6")));
        editText_dob.setSingleLine(true);
        editText_dob.setCursorVisible(false);
        editText_dob.setGravity(Gravity.START);
        editText_dob.setId(R.id.dob_editText);
        editText_dob.setHint(R.string.dob_hint);
        layout.addView(editText_dob);

        Button saveButton = new Button(clContext);
        saveButton.setLayoutParams(utility.getMyLayoutParams(false, true, false, false, 0, 0, 0, 50, 0, 20, Gravity.CENTER_HORIZONTAL));
        saveButton.setText(R.string.save);
        saveButton.setId(R.id.save);
        saveButton.setBackground(utility.getMyButtonBackGround(ContextCompat.getColor(this, R.color.colorGrayTheme)));
        saveButton.setPadding(5, 35, 5, 35);
        saveButton.setTextColor(Color.WHITE);
        saveButton.setOnClickListener(this);
        layout.addView(saveButton);

        return layout;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save:
                startActivity(new Intent(CreateProfile.this, ProfileView.class));
                break;
        }
    }
}
