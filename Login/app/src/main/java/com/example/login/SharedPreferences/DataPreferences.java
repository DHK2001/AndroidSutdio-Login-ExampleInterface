package com.example.login.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class DataPreferences {
    private static Context context;

    public DataPreferences(Context context) {
        this.context = context;
    }

    public final static String PREFS_NAME = "app_prefs";
    final String PREF_USERNAME = "username";
    final String PREF_PASSWORD = "password";
    final String PREF_REMEMBER = "remember";

    public boolean sharedPreferenceExist(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        if (!prefs.contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    public void saveUsername(String username) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_USERNAME, username);
        editor.commit();
    }
    public String getUsername() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(PREF_USERNAME, "");
    }
    public void deleteUsername() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        prefs.edit().remove(PREF_USERNAME).commit();
    }

    public void savePassword(String password) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_PASSWORD, password);
        editor.commit();
    }
    public String getPassword() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(PREF_PASSWORD, "");
    }
    public void deletePassword() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        prefs.edit().remove(PREF_PASSWORD).commit();
    }

    public void saveRememberMe(boolean rememberMe) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_REMEMBER, rememberMe);
        editor.commit();
    }
    public boolean getRememberMe() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getBoolean(PREF_REMEMBER, false);
    }
    public void deleteRememberMe() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        prefs.edit().remove(PREF_REMEMBER).commit();
    }
}