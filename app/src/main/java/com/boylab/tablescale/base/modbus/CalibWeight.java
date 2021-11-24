package com.boylab.tablescale.base.modbus;

public class CalibWeight {

    /**
     *  0x0050 2 用户标定零点
     *  0x0052 2 用户标定系数
     */

    private int zeroAD;
    private int coe;

    public void setZeroAD(int zeroAD) {
        this.zeroAD = zeroAD;
    }

    public int getCoe(int weight, int weightAD) {
        coe = (weightAD - zeroAD)/weight;
        return coe;
    }

    @Override
    public String toString() {
        return "CalibWeight{" +
                "zeroAD=" + zeroAD +
                ", coe=" + coe +
                '}';
    }
}
