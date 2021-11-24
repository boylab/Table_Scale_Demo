package com.boylab.tablescale.base.utils;

import java.util.HashMap;

public class Config {
    /**
     * 数值 0 1 2 3 4 5 6 7 8
     * 含义 kg g t lb N kN mL L kL
     */
    public static final String[] UNIT = new String[]{"kg", "g", "t", "lb", "N", "kN", "mL", "L", "kL"};
    public static final HashMap<String, Integer> unitCode = new HashMap<String, Integer>(){{
        put("kg", 0);put("g", 1);put("t", 2);put("lb", 3);put("N", 4);put("kN", 5);put("mL", 6);put("L", 7);put("kL", 8);
    }};

    /**
     * 代号 0 1 2 3 4 5 6 7 8 9 10 11
     * 分度值 1 2 5 10 20 50 100 200 500 1000 2000 5000
     */
    private static int[] DIVISIONI = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
    public static final HashMap<Integer, Integer> DivCode = new HashMap<Integer, Integer>(){{
        put(1, 0);     put(2, 1);      put(5, 2);  put(10, 3); put(20, 4);
        put(50, 5);    put(100, 6);    put(200, 7);put(500, 8);put(1000, 9);
        put(2000, 10); put(5000, 11);
    }};

}
