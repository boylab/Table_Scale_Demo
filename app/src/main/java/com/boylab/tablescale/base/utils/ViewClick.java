package com.boylab.tablescale.base.utils;

public class ViewClick {

    private static long lastClickTime;

    public static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}

