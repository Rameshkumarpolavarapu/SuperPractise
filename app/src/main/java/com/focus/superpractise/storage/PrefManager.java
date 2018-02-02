package com.focus.superpractise.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by P Ramesh Kumar on 01-02-2018.
 */

public class PrefManager {

    private SharedPreferences pref = null;
    private SharedPreferences.Editor editor = null;
    private Context _context = null;
    private int PRIVATE_MODE = 0;

    // Shared preferences file name

    private static final String PREF_NAME = "super-practise";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
