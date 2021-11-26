package com.boylab.tablescale.base.modbus.socket;

import com.boylab.tablescale.base.modbus.bean.ReqModbus;
import com.boylab.tablescale.base.modbus.master.SerialMaster;

public class ModbusEngine {

    private volatile SerialMaster serialMaster = null;

    private volatile QueueManager queueManager = null;

    private static ModbusEngine instance = null;

    private ModbusEngine(){

    }

    /**
     * 单例模式
     * @return
     */
    public static ModbusEngine instance(){
        if (instance == null){
            instance = new ModbusEngine();
        }
        return instance;
    }

    public boolean isStart() {
        return queueManager.isShutdown();
    }

    /**
     * 开启
     */
    public void startEngine(){
        if (isStart()){
            return;
        }
        /**
         * 启动串口
         */
        serialMaster = SerialMaster.newInstance();
        serialMaster.startSerial();

        /**
         * 启动队列线程
         */
        queueManager = new QueueManager();
        queueManager.start();
    }

    /**
     * 发送队列
     * @param reqModbus
     */
    public void sendRequest(ReqModbus reqModbus){
        if (queueManager != null){
            queueManager.sendRequest(reqModbus);
        }
    }

    public void setOnModbusResponse(ModbusListener modbusListener) {
        if (queueManager != null){
            queueManager.setModbusListener(modbusListener);
        }
    }

    /**
     * 关闭队列
     */
    public void stopEngine(){
        if (queueManager != null){
            queueManager.shutdown();
            queueManager = null;
        }

        serialMaster = SerialMaster.newInstance();
        serialMaster.stopSerial();
    }
}
