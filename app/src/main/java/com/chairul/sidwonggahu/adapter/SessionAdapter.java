package com.chairul.sidwonggahu.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.chairul.sidwonggahu.LoginActivity;
import com.chairul.sidwonggahu.MainActivity;
import com.chairul.sidwonggahu.SplashActivity;

public class SessionAdapter {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;
    private int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "Sesi";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String IS_SHOW = "IsShow";
    public static final String KEY_KTP = "ktp";
    public static final String FIREBASE_TOKEN = "token";

    public SessionAdapter(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void simpanToken(String token){
        editor.putString(FIREBASE_TOKEN, token);
        editor.commit();
    }

    public void createLoginSession(String ktp){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_KTP, ktp);
        editor.commit();
    }

    public void createDialogSession(){
        editor.putBoolean(IS_SHOW, true);
        editor.commit();
    }

    public void checkLoginMain(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    public void checkLogin(){
        if(this.isLoggedIn()){
            Intent i = new Intent(_context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    public String getKTP(){
        String user = pref.getString(KEY_KTP, null);
        return user;
    }

    public String getToken(){
        String token = pref.getString(FIREBASE_TOKEN, null);
        return token;
    }

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public boolean isShow(){
        return pref.getBoolean(IS_SHOW, false);
    }
}
