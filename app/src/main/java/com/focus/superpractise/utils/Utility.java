package com.focus.superpractise.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

/**
 * Created by P Ramesh Kumar on 25-01-2018.
 */

public class Utility {
    public static short toDip(Context context,int pixels)
    {
        return (short) (pixels * context.getResources().getDisplayMetrics().density + 0.5f);
        //return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixels, context.getResources().getDisplayMetrics());
    }

    public LinearLayout.LayoutParams getMyLayoutParams(boolean bBothMatchParent, boolean bMatch_Wrap, boolean bBothWrap_Content, boolean bCustom_Width_Height, int iWidth, int iHeight, int iLEFT_MARGIN, int iTOP_MARGIN, int iRIGHT_MARGIN, int iBOTTOM_MARGIN, int iGravity) {
        if (bBothMatchParent) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(iLEFT_MARGIN, iTOP_MARGIN, iRIGHT_MARGIN, iBOTTOM_MARGIN);
            params.gravity = iGravity;
            return params;
        } else if (bMatch_Wrap) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(iLEFT_MARGIN, iTOP_MARGIN, iRIGHT_MARGIN, iBOTTOM_MARGIN);
            return params;
        } else if (bBothWrap_Content) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(iLEFT_MARGIN, iTOP_MARGIN, iRIGHT_MARGIN, iBOTTOM_MARGIN);
            return params;
        } else if (bCustom_Width_Height) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(iWidth, iHeight);
            params.setMargins(iLEFT_MARGIN, iTOP_MARGIN, iRIGHT_MARGIN, iBOTTOM_MARGIN);
            return params;
        }
        // default
        return new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public GradientDrawable getMyButtonBackGround(int iColor1) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20f);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(iColor1);
        return gradientDrawable;
    }

    public GradientDrawable getMyEditextBackGround(int iColor1) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setStroke(1,Color.parseColor("#D4D3D3"));
        gradientDrawable.setColor(iColor1);
        return gradientDrawable;
    }

    public RelativeLayout getHorizontalLineWithCenterText(Context context, String sText, int sColorCode) {

        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeLayout.setLayoutParams(params);

        View view = new View(context);
        RelativeLayout.LayoutParams viewParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        viewParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        view.setLayoutParams(viewParams);
        view.setBackgroundColor(sColorCode);
        relativeLayout.addView(view);

        TextView textView   =   new TextView(context);
        RelativeLayout.LayoutParams textViewParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        textView.setBackgroundColor(Color.WHITE);
        textView.setLayoutParams(textViewParams);
        textView.setPadding(7,0,7,0);
        if (Objects.equals(sText,"")||sText==null){
            textView.setText("");
        }else {
            textView.setText(sText);
            relativeLayout.addView(textView);
        }
        return relativeLayout;
    }
}