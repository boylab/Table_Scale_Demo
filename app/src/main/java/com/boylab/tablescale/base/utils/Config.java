package com.boylab.tablescale.base.utils;

import java.util.HashMap;

public class Config {

    /**
     * 代号 0 1 2 3 4 5 6 7 8 9 10 11
     * 分度值 1 2 5 10 20 50 100 200 500 1000 2000 5000
     */
    public static String[] DIV = new String[]{"1", "2", "5", "10", "20", "50", "100", "200", "500", "1000", "2000", "5000"};
    public static final HashMap<String, Integer> DivCode = new HashMap<String, Integer>(){{
        put("1", 0);     put("2", 1);      put("5", 2);  put("10", 3); put("20", 4);
        put("50", 5);    put("100", 6);    put("200", 7);put("500", 8);put("1000", 9);
        put("2000", 10); put("5000", 11);
    }};

    public static String[] POINT = new String[]{"0", "1", "2", "3", "4"};

    /**
     * 数值 0 1 2 3 4 5 6 7 8
     * 含义 kg g t lb N kN mL L kL
     */
    public static final String[] UNIT = new String[]{"kg", "g", "t", "lb", "N", "kN", "mL", "L", "kL"};
    public static final HashMap<String, Integer> unitCode = new HashMap<String, Integer>(){{
        put("kg", 0);put("g", 1);put("t", 2);put("lb", 3);put("N", 4);put("kN", 5);put("mL", 6);put("L", 7);put("kL", 8);
    }};

    //滤波模式
    public static final String[] FilterMode = new String[]{"滑动滤波"};

    /**
     * 滤波强度
     */
    public static final String[] FilterLevel = new String[]{"0", "1", "2", "3"};

    /**
     * 判稳范围
     */
    public static final String[] StableRange = new String[]{"1d", "2d", "3d", "4d", "5d", "6d", "7d", "8d", "9d", "10d"};
    public static final HashMap<String, Integer> StableCode = new HashMap<String, Integer>(){{
        put("1d", 0);put("2d", 1);put("3d", 2);put("4d", 3);put("5", 4);put("6d", 5);put("7d", 6);put("8d", 7);put("9d", 8);put("10d", 9);
    }};

    //开机置零范围
    public static final int[] BootZero = new int[]{0, 100};

    //手动置零范围
    public static final int[] ManualZero = new int[]{0, 100};

    /**
     * 零点跟踪模式
     */
    public static final String[] ZeroMode = new String[]{"毛重为0跟踪", "净重为0跟踪"};
    public static final HashMap<String, Integer> ZeroModeCode = new HashMap<String, Integer>(){{
        put("毛重为0跟踪", 0);put("净重为0跟踪", 1);
    }};

    /**
     * 零点跟踪范围
     */
    public static final String[] ZeroRange = new String[]{"不跟踪", "0.5d", "1d", "1.5d", "2d", "2.5d", "3d", "3.5d", "4d", "4.5d"};
    public static final HashMap<String, Integer> ZeroRangeCode = new HashMap<String, Integer>(){{
        put("不跟踪", 0);put("0.5d", 1);put("1d", 2);put("1.5d", 3);put("2d", 4);put("2.5d", 5);put("3d", 6);put("3.5d", 7);put("4d", 8);put("4.5d", 9);
    }};

    /**
     * 零点跟踪范围
     */
    public static final String[] ZeroSpeed = new String[]{"0", "1", "2", "3"};
    public static final HashMap<String, Integer> ZeroSpeedCode = new HashMap<String, Integer>(){{
        put("0", 0);put("1", 1);put("2", 2);put("3", 3);
    }};

    /**
     * 蠕变补偿
     */
    public static final String[] Compensate = new String[]{"不使用", "使用"};
    public static final HashMap<String, Integer> CompensateCode = new HashMap<String, Integer>(){{
        put("不使用", 0);put("使用", 1);
    }};

}
