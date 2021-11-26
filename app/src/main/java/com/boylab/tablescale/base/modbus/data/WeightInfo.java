package com.boylab.tablescale.base.modbus.data;

import com.boylab.tablescale.base.modbus.socket.ModbusEngine;
import com.gotokeep.keep.taira.TairaData;
import com.gotokeep.keep.taira.annotation.ParamField;

public class WeightInfo implements TairaData {

    /**0x0000 2 毛重 注 1
     * 0x0002 2 皮重
     * 0x0004 2 净重
     * 0x0006 1 状态标志 1 注 2
     * 0x0007 1 状态标志 2 注 3
     * 0x0008 2 锁定毛量DS-D3数 字 模 块4
     * 0x000A 2 锁定净重
     * 0x000C 2 毛重内码
     * 0x000E 2 皮重内码
     * 0x0010 2 净重内码
     * 0x0012 2 累计净重
     * 0x0014 1 累计次数
     * 0x0015 1 模块型号
     * 0x0016 1 模块硬件版本
     * 0x0017 1 模块软件版本
     * 0x0018 10 设备标识字
    */
    @ParamField(order = 0,length = 4)
    private int gross;
    @ParamField(order = 1,length = 4)
    private int tare;
    @ParamField(order = 2,length = 4)
    private int net;
    @ParamField(order = 3,length = 2)
    private int sign1;
    @ParamField(order = 4,length = 2)
    private int sign2;
    @ParamField(order = 5,length = 4)
    private int lockGross;
    @ParamField(order = 6,length = 4)
    private int lockTare;
    @ParamField(order = 7,length = 4)
    private int grossCode;
    @ParamField(order = 8,length = 4)
    private int tareCode;
    @ParamField(order = 9,length = 4)
    private int netCode;
    @ParamField(order = 10,length = 4)
    private int sumNet;
    @ParamField(order = 11,length = 2)
    private int sumCount;
    @ParamField(order = 12,length = 2)
    private int model;
    @ParamField(order = 13,length = 2)
    private int hardVersion;
    @ParamField(order = 14,length = 2)
    private int softVersion;
    @ParamField(order = 15,length = 20)
    private String identify;

    private static WeightInfo instance = null;

    public WeightInfo() {
    }

    public static WeightInfo info(){
        if (instance == null){
            instance = new WeightInfo();
        }
        return instance;
    }

    public void toInfo(byte[] data){
        if (data.length >= 34 * 2){

        }
    }













    public int getGross() {
        return gross;
    }

    public void setGross(int gross) {
        this.gross = gross;
    }

    public int getTare() {
        return tare;
    }

    public void setTare(int tare) {
        this.tare = tare;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public int getSign1() {
        return sign1;
    }

    public void setSign1(int sign1) {
        this.sign1 = sign1;
    }

    public int getSign2() {
        return sign2;
    }

    public void setSign2(int sign2) {
        this.sign2 = sign2;
    }

    public int getLockGross() {
        return lockGross;
    }

    public void setLockGross(int lockGross) {
        this.lockGross = lockGross;
    }

    public int getLockTare() {
        return lockTare;
    }

    public void setLockTare(int lockTare) {
        this.lockTare = lockTare;
    }

    public int getGrossCode() {
        return grossCode;
    }

    public void setGrossCode(int grossCode) {
        this.grossCode = grossCode;
    }

    public int getTareCode() {
        return tareCode;
    }

    public void setTareCode(int tareCode) {
        this.tareCode = tareCode;
    }

    public int getNetCode() {
        return netCode;
    }

    public void setNetCode(int netCode) {
        this.netCode = netCode;
    }

    public int getSumNet() {
        return sumNet;
    }

    public void setSumNet(int sumNet) {
        this.sumNet = sumNet;
    }

    public int getSumCount() {
        return sumCount;
    }

    public void setSumCount(int sumCount) {
        this.sumCount = sumCount;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getHardVersion() {
        return hardVersion;
    }

    public void setHardVersion(int hardVersion) {
        this.hardVersion = hardVersion;
    }

    public int getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(int softVersion) {
        this.softVersion = softVersion;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    @Override
    public String toString() {
        return "WeightInfo{" +
                "gross=" + gross +
                ", tare=" + tare +
                ", net=" + net +
                ", sign1=" + sign1 +
                ", sign2=" + sign2 +
                ", lockGross=" + lockGross +
                ", lockTare=" + lockTare +
                ", grossCode=" + grossCode +
                ", tareCode=" + tareCode +
                ", netCode=" + netCode +
                ", sumNet=" + sumNet +
                ", sumCount=" + sumCount +
                ", model=" + model +
                ", hardVersion=" + hardVersion +
                ", softVersion=" + softVersion +
                ", identify='" + identify + '\'' +
                '}';
    }
}
