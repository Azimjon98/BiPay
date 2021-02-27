package uz.bipay.addition;

import android.content.Context;
import android.content.SharedPreferences;

import static uz.bipay.addition.Constants.IS_FIRST_ENTER;
import static uz.bipay.addition.Constants.MY_TOKEN;

public class MySettings {
    static private Context appContext;
    static private MySettings instance;

    public static void initInstance(Context con) {
        appContext = con;
        if (instance == null)
            instance = new MySettings();

    }

    public static MySettings getInstance() {
        if (instance == null)
            instance = new MySettings();

        return instance;
    }


    public boolean isFirstEnter() {
        SharedPreferences preferences = appContext.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return preferences.getBoolean(IS_FIRST_ENTER, true);
    }

    public void setFirstEnter() {
        SharedPreferences preferences = appContext.getSharedPreferences("settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_FIRST_ENTER, false);
        editor.apply();
    }

    public String getToken() {
        SharedPreferences preferences = appContext.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return preferences.getString(MY_TOKEN, "");
    }

    public void setToken(String token) {
        SharedPreferences preferences = appContext.getSharedPreferences("settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(MY_TOKEN, token);
        editor.apply();
    }

}