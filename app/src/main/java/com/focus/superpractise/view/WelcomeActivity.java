package com.focus.superpractise.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.focus.superpractise.R;
import com.focus.superpractise.storage.PrefManager;

public class WelcomeActivity extends Activity implements View.OnClickListener {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private Button skip, next;
    private PrefManager prefManager;
    private View viewArray[]    =   null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // checking  for First Time Launch - before calling setContextView();

        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(getView(this));

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        skip = (Button) findViewById(R.id.skipButton);
        next = (Button) findViewById(R.id.nextButton);


        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent

        changeStatusBarColor();




        myViewPagerAdapter = new MyViewPagerAdapter(viewArray);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setOnPageChangeListener(viewPagerPageChangeListener);


    }


    private View getView(Context clContext) {

        RelativeLayout relativeLayout = new RelativeLayout(clContext);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(params);
//        relativeLayout.setBackgroundColor(Color.RED);

        ViewPager viewPager = new ViewPager(clContext);
        RelativeLayout.LayoutParams view_pager_Params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        viewPager.setLayoutParams(view_pager_Params);
        viewPager.setId(R.id.view_pager);
        // adding viewPager view to relativeLayout
        relativeLayout.addView(viewPager);

        LinearLayout layoutDotsLinearLayout = new LinearLayout(clContext);
        layoutDotsLinearLayout.setId(R.id.layoutDots);
        RelativeLayout.LayoutParams layoutDotsParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutDotsParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        layoutDotsParams.bottomMargin = 20;
        layoutDotsLinearLayout.setLayoutParams(layoutDotsParams);
        layoutDotsLinearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        layoutDotsLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        // adding layoutDotsLinearLayout view to relativeLayout
        relativeLayout.addView(layoutDotsLinearLayout);

        View horizontalLineView = new View(clContext);
        RelativeLayout.LayoutParams horizontalLineViewParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        horizontalLineView.setAlpha(.5f);
        horizontalLineViewParams.addRule(RelativeLayout.ABOVE, R.id.layoutDots);
//        horizontalLineViewParams.bottomMargin = 35;
        horizontalLineView.setLayoutParams(horizontalLineViewParams);
        horizontalLineView.setBackgroundColor(Color.WHITE);
        // adding horizontalLineView view to relativeLayout
        relativeLayout.addView(horizontalLineView);


        Button nextButton = new Button(clContext);
        RelativeLayout.LayoutParams nextButtonParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nextButtonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        nextButtonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        nextButton.setId(R.id.nextButton);
        nextButton.setLayoutParams(nextButtonParams);
        nextButton.setOnClickListener(this);
        nextButton.setBackground(null);
        nextButton.setText(R.string.next);
        nextButton.setTextColor(Color.WHITE);
        // adding nextButton view to relativeLayout
        relativeLayout.addView(nextButton);

        Button skipButton = new Button(clContext);
        skipButton.setId(R.id.skipButton);
        RelativeLayout.LayoutParams skipButtonParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        skipButtonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        skipButtonParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        skipButton.setLayoutParams(skipButtonParams);
        skipButton.setBackground(null);
        skipButton.setText(R.string.skip);
        skipButton.setTextColor(Color.WHITE);
        skipButton.setOnClickListener(this);
        // adding skipButton view to relativeLayout
        relativeLayout.addView(skipButton);

        return relativeLayout;
    }

    @Override
    public void onClick(View view) {
        if (viewArray==null){
            inti();
        }
        switch (view.getId()) {
            case R.id.skipButton:
                launchHomeScreen();
                break;
            case R.id.nextButton:
                int iCurrent = getItem(+1);
                if (iCurrent < viewArray.length) {
                    viewPager.setCurrentItem(iCurrent);
                } else {
                    launchHomeScreen();
                }
                break;
        }
    }

    private void inti() {
        WelcomeSlide welcomeSlide = new WelcomeSlide();
        viewArray = new View[]{

                welcomeSlide.WelcomeSlideModel1(this, R.id.slide1, R.color.bg_screen1, R.drawable.ic_food, getResources().getString(R.string.slide_1_title), getResources().getString(R.string.slide_1_desc)),
                welcomeSlide.WelcomeSlideModel1(this, R.id.slide2, R.color.bg_screen2, R.drawable.ic_discount, getResources().getString(R.string.slide_3_title), getResources().getString(R.string.slide_3_desc)),
                welcomeSlide.WelcomeSlideModel1(this, R.id.slide3, R.color.bg_screen3, R.drawable.ic_travel, getResources().getString(R.string.slide_4_title), getResources().getString(R.string.slide_4_desc)),
                welcomeSlide.WelcomeSlideModel1(this, R.id.slide4, R.color.bg_screen4, R.drawable.ic_movie, getResources().getString(R.string.slide_2_title), getResources().getString(R.string.slide_2_desc)),

                welcomeSlide.WelcomeSlideModel1(this, R.id.slide1, R.color.bg_screen1, R.drawable.ic_food, getResources().getString(R.string.slide_1_title), getResources().getString(R.string.slide_1_desc)),
                welcomeSlide.WelcomeSlideModel1(this, R.id.slide2, R.color.bg_screen2, R.drawable.ic_discount, getResources().getString(R.string.slide_3_title), getResources().getString(R.string.slide_3_desc)),
                welcomeSlide.WelcomeSlideModel1(this, R.id.slide3, R.color.bg_screen3, R.drawable.ic_travel, getResources().getString(R.string.slide_4_title), getResources().getString(R.string.slide_4_desc)),
                welcomeSlide.WelcomeSlideModel1(this, R.id.slide4, R.color.bg_screen4, R.drawable.ic_movie, getResources().getString(R.string.slide_2_title), getResources().getString(R.string.slide_2_desc))

        };

    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void changeStatusBarColor() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void addBottomDots(int iCurrentPage) {
        if (viewArray==null){
            inti();
        }

        dots = new TextView[viewArray.length];


        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);

        int[] colorsInActive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setPadding(3, 0, 3, 0);
            dots[i].setTextColor(colorsInActive[iCurrentPage]);
            //            dots[i].setBackgroundColor(Color.LTGRAY);

            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[iCurrentPage].setPadding(3, 0, 3, 0);
            dots[iCurrentPage].setTextColor(colorsActive[iCurrentPage]);
            //            dots[iCurrentPage].setBackgroundColor(Color.WHITE);
        }
    }

    private void launchHomeScreen() {

        prefManager.setFirstTimeLaunch(true);
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();

    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            if (viewArray==null){
                inti();
            }
            // changing the next button text 'NEXT' / 'GOT IT'
            addBottomDots(position);
            if (position == viewArray.length - 1) {
                next.setText(getString(R.string.start));
                skip.setVisibility(View.GONE);
            } else {
                // still pages are left
                next.setText(getString(R.string.next));
                skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private class MyViewPagerAdapter extends PagerAdapter {

        private final View[] views;

        public MyViewPagerAdapter(View[] views) {
            this.views = views;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = views[position];
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return views.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(views[position]);
        }
    }
}
