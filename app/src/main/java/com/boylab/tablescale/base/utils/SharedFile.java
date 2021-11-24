package com.boylab.tablescale.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.boylab.tablescale.base.db.table.User;

public class SharedFile {

    private static volatile SharedPreferences sharedPre = null;

    /**
     * 第一次登陆
     */
    public static boolean isLoginFirst(Context mContext){
        sharedPre = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean isAutoLogin = sharedPre.getBoolean("isLoginFirst", true);
        return isAutoLogin;
    }

    public static void setLoginFirst(Context mContext, boolean isAutoLogin){
        sharedPre = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPre.edit();
        edit.putBoolean("isLoginFirst", isAutoLogin);
        edit.commit();
    }

    /**
     *
     * @param mContext
     * @return
     */
    public static boolean isAutoLogin(Context mContext){
        sharedPre = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean isAutoLogin = sharedPre.getBoolean("isAutoLogin", false);
        return isAutoLogin;
    }

    public static void setAutoLogin(Context mContext, boolean isAutoLogin){
        sharedPre = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPre.edit();
        edit.putBoolean("isAutoLogin", isAutoLogin);
        edit.commit();
    }

    /**
     * 登陆用户
     */
    public static User getLoginUser(Context mContext){
        sharedPre = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        String userJson = sharedPre.getString("user", null);
        User loginUser = null;
        if (TextUtils.isEmpty(userJson)){
            loginUser = new Gson().fromJson(userJson, User.class);
        }
        if (loginUser == null){
            loginUser = new User();
            loginUser.setUserName("Admin");
        }
        return loginUser;
    }

    public static void setLoginUser(Context mContext, User user){
        sharedPre = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPre.edit();
        edit.putString("user", new Gson().toJson(user));
        edit.commit();
    }


}
