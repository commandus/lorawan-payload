package com.commandus.lorawanpayload;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PayloadSettings {
    public static final String APPLICATION_ID = "com.commandus.lorawanpayload";
    private static final String PREF_THEME = "theme";

    private static PayloadSettings mSettings = null;
    private final Context mContext;

    private String mTheme; // light|dark

    public String getTheme() {
        return mTheme;
    }

    public void load() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mTheme = prefs.getString(PREF_THEME, "dark");
    }

    public PayloadSettings(Context context) {
        mContext = context;
        load();
    }

    public void save() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(PREF_THEME, mTheme);
        editor.apply();
    }

    public synchronized static PayloadSettings getSettings(Context context) {
        if (mSettings == null) {
            mSettings = new PayloadSettings(context);
        }
        return mSettings;
    }
}
